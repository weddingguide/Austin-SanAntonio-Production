package jwm.entity;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.db.*;
import jwm.event.*;
import jwm.idmanager.*;
import jwm.project.*;
import jwm.calendar.*;
import jwm.gl2.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CoupleGroupInfo extends CoupleGroupInfoDBRecordBase
{
   public static final int STATUS_NOCONTACT =0;
   public static final int STATUS_CONTACTED =1;
   public static final int STATUS_QUERY =2;
   public static final int STATUS_SIGNED =3;
   public static final int STATUS_LOST =4;
   public static final int STATUS_WEDDINGCANCELLED =5;
   public static final int STATUS_WEDDINGCOMPLETED =6;
   public static final int STATUS_CLOSED =7;
   public static final int STATUS_VISITEDSHOWBOOTH =8;
   public static final int STATUS_FORM_QUERY =9;
   public static final int STATUS_FORM_QUERY_RESPONDED =10;
   public static final int STATUS_SHOW_FOLLOWUP_EMAIL_SENT =11;
   public static final int STATUS_CONSULTATION_MEETING_SCHEDULED =12;
   public static final int STATUS_CONSULTATION_MEETING_COMPLETED =13;
   public static final int STATUS_VISITEDSHOWBOOTH_DORMANT =14;



   public static final String STATUSTEXT[] =   { "No Contact", "Contacted", "Query", "Signed", "Did Not Sign", "Wedding Cancelled", "Wedding Completed", "Closed", "Visited Booth At Show", "Contact Form Request Received", "Contact Form Response Sent", "Show Followup Email Sent", "Consultation Mtg Scheduled", "Consultation Mtg Completed", "Visited Show Booth -- Dormant" };
   public static final String STATUSCOLOR[] =  { "neutral"     , "neutral"    , "warn","go" , "neutral"       , "neutral"            , "neutral"            , "neutral" , "neutral"                , "critical"                          , "slow"                    , "neutral"                   , "warn"                    , "warn"                    , "neutral"                         };

   private EventList events;
   public  void      setEvents( EventList aEvents ) { events = aEvents; }
   public  EventList getEvents()       { return(events); }

   private Event receptionEvent;
   public  void  setReceptionEvent( Event aReceptionEvent ) { receptionEvent = aReceptionEvent; }
   public  Event getReceptionEvent() { return(receptionEvent); }


   private Event weddingEvent;  // dup from the list above, but we need to easily access the ceremony date
   public  void  setWeddingEvent( Event aWeddingEvent ) { weddingEvent = aWeddingEvent; }
   public  Event getWeddingEvent() { return(weddingEvent); }


   private InvoiceList invoices;
   public  void        setInvoices( InvoiceList aInvoices ) { invoices = aInvoices; }
   public  InvoiceList getInvoices()       { return(invoices); }

   private HistoryList history;
   public  void        setHistory( HistoryList aHistory ) { history = aHistory; }
   public  HistoryList getHistory()        { return(history); }

   private Person groom;
   public  void   setGroom( Person aGroom ) { groom = aGroom; }
   public  Person getGroom()     { return(groom); }

   private Person bride;
   public  void   setBride( Person aBride ) { bride = aBride; }
   public  Person getBride()     { return(bride); }

   private Person altContact;
   public  void   setAltContact( Person aAltContact ) { altContact = aAltContact; }
   public  Person getAltContact() { return(altContact); }


   private String videoRoot;
   public  void   setVideoRoot( String aVideoRoot ) { videoRoot = aVideoRoot; }
   public  String getVideoRoot() { return(videoRoot); }

   private String videoRootURL;
   public  void   setVideoRootURL( String aVideoRootURL ) { videoRootURL = aVideoRootURL; }
   public  String getVideoRootURL() { return(videoRootURL); }

   private String[] emailAddresses;
   public  void    setEmailAddresses( String[] aEmailAddresses ) { emailAddresses = aEmailAddresses; }
   public  String[] getEmailAddresses() { return(emailAddresses); }




   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public CoupleGroupInfo( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public CoupleGroupInfo( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public CoupleGroupInfo( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public CoupleGroupInfo( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public CoupleGroupInfo( DBData dbData )
   {
      super( dbData );
   }

   public CoupleGroupInfo( DBData aDbData, int aId )
   {
      super( aDbData);
      if ( aId != -1 )
      {
         populateObject( "COUPLEGROUPINFO", "OWNERID", aId );
         deepPopulate();
      }
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public CoupleGroupInfo( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public CoupleGroupInfo( DBData dbData, int aOwnerType, int aOwnerId )
   {
      super( dbData );
      populateObject( "COUPLEGROUPINFO", "OWNERTYPE= " + aOwnerType + " AND OWNERID="+ aOwnerId, "" );

      events = new EventList( dbData, aOwnerType, aOwnerId );
      invoices = new InvoiceList( dbData, ObjectClassID.CONTACT, aOwnerId );

      history = new HistoryList( dbData, aOwnerType, aOwnerId );

      weddingEvent = new Event( dbData, aOwnerType, aOwnerId, "Ceremony" );
      receptionEvent = new Event( dbData, aOwnerType, aOwnerId, "Reception" );
   }

   public static void verifyExists( EntityGroup coupleGroup )
   {
      verifyExists( coupleGroup, STATUS_CONTACTED );  // assume if creating the record manually (where this usually occurs, there has been some contact )
   }

   public static void verifyExists( EntityGroup coupleGroup, int initialStatus )
   {
      CoupleGroupInfo coupleInfo = new CoupleGroupInfo( coupleGroup.getDbData(), 3, coupleGroup.getGroupNum() );
      if ( !coupleInfo.isRecordFound() )
      {
         coupleInfo.setOwnerType( 3 );
         coupleInfo.setOwnerId( coupleGroup.getGroupNum() );
         coupleInfo.setStatus( initialStatus );

         coupleInfo.createOrUpdateRecord( "COUPLEGROUPINFO" );

      }
   }

   public boolean createRecord( String tableName )
   {
      createDate = new java.sql.Date( new java.util.Date().getTime() );
      return( super.createRecord( tableName ) );
   }

   public void deepPopulate()
   {
      groom = new Person( dbData, -1);
      bride = new Person( dbData, -1);
      altContact = new Person( dbData, -1);

      GroupMemberMapList personIdList = new GroupMemberMapList( dbData, EntityGroup.TYPE_CONTACTCONTAINER, ownerId, true );
      for ( int i = 0; i < personIdList.getRecordList().length; i++ )
      {
          GroupMemberMap aMap = (GroupMemberMap)personIdList.getRecordList()[i];
          if (aMap.getMemberRole() == GroupMemberMap.MEMBERROLE_FAMILY_HUSBAND ) groom = new Person( dbData, aMap.getMemberId());
          if (aMap.getMemberRole() == GroupMemberMap.MEMBERROLE_FAMILY_WIFE )    bride = new Person( dbData, aMap.getMemberId());
          if (aMap.getMemberRole() == GroupMemberMap.MEMBERROLE_FAMILY_CONTACTPERSON )    altContact = new Person( dbData, aMap.getMemberId());
      }
      bride.deepPopulate();
      groom.deepPopulate();
      altContact.deepPopulate();

      videoRoot = SiteProperty.valueOf( dbData, "videoRoot") +"\\" +groom.getLastName().toLowerCase();
      videoRootURL = SiteProperty.valueOf( dbData, "videoRootURL") +"/" +groom.getLastName().toLowerCase();

      Vector emailAddressVector = new Vector();

      EmailList  emailAddressList = bride.getEmailAddresses();
      for ( int j = 0; j < emailAddressList.getRecordList().length; j++ )
      {
         String addr = ((Email)emailAddressList.getRecordList()[j]).getEmailAddress();
         if (!emailAddressVector.contains( addr) ) emailAddressVector.add(addr);
      }
      emailAddressList = groom.getEmailAddresses();
      for ( int j = 0; j < emailAddressList.getRecordList().length; j++ )
      {
         String addr = ((Email)emailAddressList.getRecordList()[j]).getEmailAddress();
         if (!emailAddressVector.contains( addr) ) emailAddressVector.add(addr);
      }
      emailAddressList = altContact.getEmailAddresses();
      for ( int j = 0; j < emailAddressList.getRecordList().length; j++ )
      {
         String addr = ((Email)emailAddressList.getRecordList()[j]).getEmailAddress();
         if (!emailAddressVector.contains( addr) ) emailAddressVector.add(addr);
      }

      emailAddresses = new String[emailAddressVector.size()];
      for ( int i=0; i<emailAddressVector.size(); i++ )
      {
         emailAddresses[i] = (String) emailAddressVector.elementAt( i );
      }
   }

   public String getURLParmEmailAddresses()
   {
      String retVal = "";
      for (int i=0; i<emailAddresses.length; i++ )
      {
         if ( i>0) retVal += "&";
         retVal += "address="+emailAddresses[i];
      }
      return( retVal);
   }

}
