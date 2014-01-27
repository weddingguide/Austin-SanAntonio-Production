package jwm.wgbe;

import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;

import java.sql.*;
import java.util.*;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.logger.*;
import jwm.entity.*;
import jwm.scheduler.*;
import jwm.mailer.*;
import jwm.idmanager.*;
import jwm.wgbe.*;
import java.sql.*;

/**
 *
 */
public class MailListTask
{
   private ServletDBData dbData;
   private ServletContext context;
   private static Logger sysLogger = null;

   public MailListTask( DBData aDbData, Logger aLogger, ServletContext aContext )
   {
      dbData = (ServletDBData) aDbData;
      sysLogger = aLogger;
      context = aContext;
   }


   public MailListTask( ServletContext aContext )
   {
      dbData = ServletDBData.getInstance( aContext, "jdbc/wgbe" );
      dbData.setVersionHandler( new WGBEDataVersionHandler() );
      dbData.getLog().setLogLevel( Log.DEBUG );
   }


   public void run()
   {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      dbData.getLog().logEvent(Log.INFO, "Run WGBE MailListTask" );
      try
      {
         // 12/29/12 -- Need to write a dummy entry to this table due to mysql table R/O problem.
         // if table is locked, this should kick us out of processing completely

         {
            dbData.getLog().logEvent(Log.INFO, "Adding dummy entry to table checking for MySQL R/O problem..." );
            ContactFormData contactFormData = new ContactFormData();
            contactFormData.populate( dbData, null, "dummy", "See wgbe\\MailListTask.java", 0 );
            contactFormData.queue( dbData, -999 );

            Statement statement = dbData.getConnection().createStatement();
            statement.execute( "DELETE from contactformemailqueue where status = -999" ); //writing to table is ok... delete the dummy entries
         }

         // end

         pstmt = dbData.getConnection().prepareStatement("SELECT date, contactFormData FROM contactformemailqueue where status = 0" );
         rs = pstmt.executeQuery();
         while(rs.next() )
         {


               ObjectInputStream objIn   = new ObjectInputStream(
                                          new BufferedInputStream(
                                          rs.getBlob(2).getBinaryStream()
                                          ));

               ContactFormData contactFormData = (ContactFormData) objIn.readObject();

               Timestamp timeStamp = rs.getTimestamp(1);
               processOneContactForm( contactFormData, timeStamp );
         }

         // summarize all failed entries in queue

         pstmt = dbData.getConnection().prepareStatement("SELECT date, contactFormData FROM contactformemailqueue where status = -1" );
         rs = pstmt.executeQuery();
         dbData.getLog().logEvent( "Reviewing all failed entries in queue...." );

         while(rs.next() )
         {
               ObjectInputStream objIn   = new ObjectInputStream(
                                          new BufferedInputStream(
                                          rs.getBlob(2).getBinaryStream()
                                          ));

               ContactFormData contactFormData = (ContactFormData) objIn.readObject();

               Timestamp timeStamp = rs.getTimestamp(1);
               for (int j=0; j<contactFormData.vendors.length; j++)
               {
                  int vendorId = contactFormData.vendors[j];

                  String vendorName = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, vendorId, 1, 0);
                  String[] vendorEmailAddresses = EntityAttributeList.getAttributeValues(dbData, EntityAttribute.OWNERTYPE_PERSON, vendorId, 4, 0);

                  for (int i=0; i < vendorEmailAddresses.length; i++ )
                  {
                      dbData.getLog().logEvent( "--- Failed Send (on at least one vendor/address in list: " + vendorName + "Vendor email address: " + vendorEmailAddresses[i] + "<br>from: " + contactFormData.firstName + " " + contactFormData.lastName + " Client email address: '" + contactFormData.email + "'; sent: " + timeStamp);
                  }
               }
         }
      }
      catch(Exception e)
      {
         dbData.getLog().logEvent( Log.ERROR, "error reading contactFormData record: " + e.toString() );
      }
      finally
      {
         try
         {
            rs.close();
            pstmt.close();
         }
         catch( Exception e)
         {
            dbData.getLog().logEvent( Log.ERROR, "error closing resultset or preparedstatement: " + e.toString() );
         }
      }
      dbData.getLog().logEvent(Log.INFO, "Exiting MailListTask" );
   }

   private void processOneContactForm( ContactFormData contactFormData, java.sql.Timestamp timeStamp )
   {
      dbData.getLog().setLogLevel( Log.DEBUG ); // if we get here, we've got work in the queue.. enable logging
      String additionalInfoForExceptionReport = "";
      try
      {
          String clientSubject = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, contactFormData.texasWeddingsBusinessId, 64, 2);
          String vendorSubject = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, contactFormData.texasWeddingsBusinessId, 64, 3);

          int subId = 0;
          if (contactFormData.categoryRequest) subId=5;

          String clientBody = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, contactFormData.texasWeddingsBusinessId, 64, subId);
          String vendorBody = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, contactFormData.texasWeddingsBusinessId, 64, 1);

//        clientBody = clientBody.replace( "[vendor]", businessEntityName );
          clientBody = "<hr>" + clientBody + contactFormData.toHTMLString(true);

          clientBody += "<p>Your information was sent to:</p>";

          for (int i = 0; i < contactFormData.vendors.length; i++ )
          {
             clientBody +="<li>"+ EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, contactFormData.vendors[i], 1, 0);
             dbData.getLog().logEvent( Log.INFO,"Vendor: " +  contactFormData.vendors[i] + " - Name: " + contactFormData.firstName + " " + contactFormData.lastName);
          }

//        vendorBody = vendorBody.replace( "[vendor]", businessEntityName );
          vendorBody = "<hr>" + vendorBody + contactFormData.toHTMLString(true);

          vendorSubject += contactFormData.getNameDate();



          if ( !contactFormData.scriptRun.equals( "*" ) )  // if script was not run, form was submitted by a spam robot
          {
             //=============================================================================================
             // send to client

              additionalInfoForExceptionReport = "<br>Sending to client: " + contactFormData.firstName + " " + contactFormData.lastName + " email address: '" + contactFormData.email + "';";

              SMTPClient smtpClient = new SMTPClient( "localhost",
                                                      contactFormData.regionName,
                                                      contactFormData.regionEmailAddress );

              smtpClient.sendMail( contactFormData.firstName + " " + contactFormData.lastName,
                                   contactFormData.email,
                                   clientSubject,
                                   clientBody,
                                   "text/html" );

             //=============================================================================================
             // cc to wgbe

              smtpClient.sendMail( "Leads",
                                   "leads@texasweddings.com",
                                   vendorSubject,
                                   clientBody,
                                   "text/html" );

             //=============================================================================================
             // send to vendors

             for (int j=0; j<contactFormData.vendors.length; j++)
             {
                int vendorId = contactFormData.vendors[j];

                String vendorName = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, vendorId, 1, 0);
                String[] vendorEmailAddresses = EntityAttributeList.getAttributeValues(dbData, EntityAttribute.OWNERTYPE_PERSON, vendorId, 4, 0);


                smtpClient = new SMTPClient( "localhost",
                                             contactFormData.regionName,
                                             contactFormData.regionEmailAddress,
                                             contactFormData.email                 // reply-to address goes back to client
                                             );

                for (int i=0; i < vendorEmailAddresses.length; i++ )
                {
                    String logInfo = "Send to vendor: " + vendorName + "<br>Vendor email address: " + vendorEmailAddresses[i] + "<br>from: " + contactFormData.firstName + " " + contactFormData.lastName + " " + contactFormData.email;
                    additionalInfoForExceptionReport = logInfo;
                    dbData.getLog().logEvent( Log.INFO, logInfo );

                    smtpClient.sendMail( vendorName,
                                         vendorEmailAddresses[i],
                                         vendorSubject,
                                         vendorBody + "<p>[ " + contactFormData.scriptRun + " ]",
                                         "text/html" );
                }
             }
           }
           else // spam...
           {
              SMTPClient smtpClient = new SMTPClient( "localhost",
                                                      contactFormData.regionName,
                                                      contactFormData.regionEmailAddress );

              smtpClient.sendMail( contactFormData.regionName,
                                   contactFormData.regionEmailAddress,
                                   "Contact Form Response -- Spam",
                                   vendorBody + "<p>validation script: "+contactFormData.scriptRun,
                                   "text/html" );
              dbData.getLog().logEvent(Log.INFO,  "Spam: " + contactFormData.toString());
           }

           Statement statement = dbData.getConnection().createStatement();
           statement.execute( "DELETE from contactformemailqueue where name = '" + contactFormData.firstName + " " +contactFormData.lastName + "' and date = '" + timeStamp.toString() + "'" );
           dbData.getLog().logEvent( Log.INFO, "Successful send, deleting from queue" );

       }
       catch( Exception e)
       {
          dbData.getLog().logEvent( Log.ERROR, "send error: " + e.toString() );
           dbData.getLog().logEvent(Log.ERROR,  contactFormData.toString());
           e.printStackTrace( System.out );

          try
          {

              SMTPClient smtpClient = new SMTPClient( "localhost",
                                                      contactFormData.regionName,
                                                      contactFormData.regionEmailAddress );

              smtpClient.sendMail( "JWM",
                                   "jerry@jwmhosting.com",
                                   "WGBE Contact Form Send Error",
                                   e + "<br>" + additionalInfoForExceptionReport ,

                                   "text/html" );

              smtpClient.sendMail( "WGBE",
                                   "inquiries@texasweddings.com",
                                   "WGBE Contact Form Send Error",
                                   e + "<br>" + additionalInfoForExceptionReport ,

                                   "text/html" );

             //=============================================================================================
             // cc to wgbe

              smtpClient.sendMail( "Leads",
                                   "leads@texasweddings.com",
                                   "WGBE Contact Form Send Error",
                                   e + "\n",
                                   "text/html" );


             Statement statement = dbData.getConnection().createStatement();
             statement.execute( "UPDATE contactformemailqueue set status = -1 where name = '" + contactFormData.firstName + " " + contactFormData.lastName + "' and date = '" + timeStamp.toString() + "'" );
          }
          catch( Exception e1)
          {
             dbData.getLog().logEvent( Log.ERROR, "error flagging record with send-error: " + e1.toString() );
          }

       }
   }


}
