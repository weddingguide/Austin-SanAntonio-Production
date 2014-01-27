package jwm.wgbe;


import javax.servlet.*;
import javax.servlet.http.*;
import jwm.db.*;
import java.sql.*;
import java.io.*;
import jwm.logger.*;
import org.w3c.dom.*;

public class ContactFormData implements Serializable
{
   public String lastName = "";
   public String firstName = "";
   public String me = "";
   public String email = "";
   public String phone = "";
   public String month = "";
   public String day = "";
   public String year = "";
   public String theDate = "";
   public String ceremonyLoc = "";
   public String receptionLoc = "";
   public String comments ="";
   public String scriptRun = "";
   public String  categoryForm = "";
   public String  regionName = "";
   public String  regionEmailAddress = "";
   public int texasWeddingsBusinessId = 0;
   public int[] vendors;
   public String[] vendorNames = new String[0];
   public boolean categoryRequest = false;


   public void populate( DBData dbData, HttpServletRequest request, String aRegionName, String aRegionEmailAddress, int aTexasWeddingsBusinessId )
   {
      if ( request != null )
      {
         lastName = request.getParameter( "lastName");
         firstName = request.getParameter( "firstName");
         me = request.getParameter( "me");
         email = request.getParameter( "email");
         phone = request.getParameter( "phone");
         month = request.getParameter( "dateMonth");
         day   = request.getParameter( "dateDay");
         year  = request.getParameter( "dateYear");
         theDate = month + "/" + day + "/" + year;

         if ( request.getParameter( "date" ) != null )
         {
            theDate = request.getParameter( "date" );
         }

         if (request.getParameter( "ceremonyLoc") != null) ceremonyLoc  = request.getParameter( "ceremonyLoc");
         if (request.getParameter( "receptionLoc") != null) receptionLoc  = request.getParameter( "receptionLoc");
         comments  = request.getParameter( "comments");

         scriptRun = request.getParameter( "scriptrun" );
         if (request.getParameter( "category" ) != null )
         {
            categoryForm = "*";
         }
         else
         {
            categoryForm = "";
         }
         String[] selectedVendors = request.getParameterValues( "vendor" );
         vendors = new int[ selectedVendors.length ];
         for ( int i = 0; i < selectedVendors.length; i++ )
         {
            vendors[i] = (new Integer(selectedVendors[i])).intValue();
         }
         if ( request.getParameter( "category" ) != null ) categoryRequest=true;
      }

      regionName = aRegionName;
      regionEmailAddress = aRegionEmailAddress;

      texasWeddingsBusinessId = aTexasWeddingsBusinessId;

   }

   public String getNameDate()
   {
      return( firstName + " " + lastName + " - " + theDate );
   }

   public String toHTMLString(boolean inclLoc)
   {
      String retVal =  "<p>&nbsp;"
                       +"<li>Name: " + firstName + " " + lastName
                       +"<li>I am: " + me
                       +"<li>Email: " + email
                       +"<li>Phone: " + phone
                       +"<li>Date: "+ theDate;
      if (inclLoc)
      {
         retVal += "<li>Ceremony Location: " + ceremonyLoc
                  +"<li>Reception Location: " + receptionLoc;
      }
      retVal += "<li>Comments: " + comments;

      return( retVal);
   }

   public void queue( DBData dbData )
   {
      queue( dbData, 0);
   }

   public void queue( DBData dbData, int theStatus )
   {
      try
      {
         Connection conn = dbData.getConnection();
         PreparedStatement pstmt = conn.prepareStatement("INSERT INTO contactformemailqueue(date, contactFormData, name, status) VALUES (?, ?, '"+firstName + " " + lastName+"', "+theStatus+")");

         pstmt.setTimestamp(1, new java.sql.Timestamp(new java.util.Date().getTime()));

         ByteArrayOutputStream b = new ByteArrayOutputStream();
         ObjectOutputStream out = new ObjectOutputStream(b);
         out.writeObject(this);
         byte [] dataAsByteArray = b.toByteArray();
         pstmt.setBinaryStream(2,new ByteArrayInputStream(dataAsByteArray),dataAsByteArray.length);
         pstmt.execute();
         pstmt.close();
      }
      catch( Exception e)
      {
         dbData.getLog().logEvent( Log.ERROR, "Contact Form Queuing failed -- " + e.toString() );
         e.printStackTrace( System.out );
      }
   }

   public Element getElement(Document doc)
   {
      Element contactFormDataElement = doc.createElement( "contactformdata" );

      Element htmlElement = doc.createElement( "HTMLText" );
      htmlElement.appendChild( doc.createCDATASection(toHTMLString(true)));
      contactFormDataElement.appendChild( htmlElement );

      contactFormDataElement.setAttribute( "lastName" ,                 lastName );
      contactFormDataElement.setAttribute( "firstName" ,                firstName );
      contactFormDataElement.setAttribute( "me" ,                       me );
      contactFormDataElement.setAttribute( "email" ,                    email );
      contactFormDataElement.setAttribute( "phone" ,                    phone );
      contactFormDataElement.setAttribute( "date" ,                     theDate );
      contactFormDataElement.setAttribute( "ceremonyLoc" ,              ceremonyLoc );
      contactFormDataElement.setAttribute( "receptionLoc" ,             receptionLoc );
      contactFormDataElement.setAttribute( "comments" ,                 comments );
      contactFormDataElement.setAttribute( "scriptRun" ,                scriptRun );
      contactFormDataElement.setAttribute( "categoryForm" ,             categoryForm );
      contactFormDataElement.setAttribute( "regionName" ,               regionName );
      contactFormDataElement.setAttribute( "regionEmailAddress" ,       regionEmailAddress );
      contactFormDataElement.setAttribute( "texasWeddingsBusinessId" ,  (new Integer(texasWeddingsBusinessId )).toString());
      contactFormDataElement.setAttribute( "categoryRequest",           (new Boolean(categoryRequest)).toString() );

      Element vendorsElement = doc.createElement( "vendors" );
      contactFormDataElement.appendChild( vendorsElement );

      for (int j=0; j<vendors.length; j++)
      {
         Element vendorElement = doc.createElement( "vendor" );
         vendorElement.setAttribute( "id", (new Integer( vendors[j])).toString() );
         vendorElement.setAttribute( "name", vendorNames[j] );
         vendorsElement.appendChild( vendorElement );
      }

      return( contactFormDataElement );
   }

}




