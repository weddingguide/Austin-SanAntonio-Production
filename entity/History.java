package jwm.entity;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.w3c.dom.*;

public class History extends HistoryDBRecordBase
{
   protected Document doc;
   public  void       setDoc( Document aDoc ) { doc = aDoc; }
   public  Document   getDoc()           { return(doc); }

   public static final int OWNERTYPE_PERSON = 1;  // owner types
   public static final int OWNERTYPE_EMAIL  = 2;
   public static final int OWNERTYPE_GROUP  = 3;
   public static final int OWNERTYPE_WORKITEM  = 4;
   public static final int OWNERTYPE_BE_EXHIBITOR  = 5;
   public static final int OWNERTYPE_WG_AD  = 6;
   public static final int OWNERTYPE_WG_CONTRACT  = 7;


   public static final int TYPE_RECORD_CREATION        = 0;
   public static final int TYPE_INITIAL_CONTACT_LETTER = 1;
   public static final int TYPE_REMOVE_REQUEST         = 2;
   public static final int TYPE_BOUNCE                 = 3;
   public static final int TYPE_GENERALNOTE            = 4;
   public static final int TYPE_RECORD_UPDATE          = 5;
   public static final int TYPE_MIGRATION              = 6;
   public static final int TYPE_RECORD_REMOVE          = 7;
   public static final int TYPE_TIMELOG                = 8;
   public static final int TYPE_SUBMITTED_BY           = 9;
   public static final int TYPE_RECEIVED_EMAIL         = 10;
   public static final int TYPE_SENT_EMAIL             = 11;
   public static final int TYPE_FOLLOWUP_7             = 12;
   public static final int TYPE_FOLLOWUP_14            = 13;
   public static final int TYPE_FOLLOWUP_30            = 14;
   public static final int TYPE_FOLLOWUP_60            = 15;
   public static final int TYPE_FOLLOWUP_90            = 16;
   public static final int TYPE_CLEAR_FOLLOWUP         = 17;
   public static final int TYPE_RESPONSE_DUE           = 18;
   public static final int TYPE_LEAD_LIST_ENTRY        = 19;
   public static final int TYPE_CLOCK_IN               = 20;
   public static final int TYPE_CLOCK_OUT              = 21;
   public static final int TYPE_END_PAY_PERIOD         = 22;
   public static final int TYPE_EVENT_DATE             = 23;
   public static final int TYPE_SOURCE                 = 24;
   public static final int TYPE_STICKYNOTE             = 25;
   public static final int TYPE_SQL_CREATE              = 100;
   public static final int TYPE_SQL_UPDATE              = 101;
   public static final int TYPE_SQL_DELETE              = 102;

   private String strType;
   public  void   setStrType( String aStrType ) { strType = aStrType; }
   public  String getStrType()
   {
      if (strType == null ) strType = types[eventType]; // might not have string version initialized yet
      return(strType);
   }

   public  String getStrType2()
   {
      String theType = type_image[eventType];
      if ( theType.indexOf(".") > -1 )
      {
         theType = "<img src=\"/images/"+theType+"\" style=\"width: 25px;\">";
      }
      return( theType );
   }


   public static String[] types =      {"Record Creation",
                                  "Initial Contact Letter",
                                  "Remove Request",
                                  "Email Bounce",
                                  "Note",
                                  "Record Update",
                                  "Migration",
                                  "Record Remove",
                                  "Time Log",
                                  "Submitted by",
                                  "Received Email",
                                  "Sent Email",
                                  "7 Day Follow up",
                                  "14 Day Follow up",
                                  "30 Day Follow up",
                                  "60 Day Follow up",
                                  "90 Week Follow up",
                                  "Clear Followup",
                                  "Response Due",
                                  "Lead List Entry",
                                  "Clock In",
                                  "Clock Out",
                                  "End Pay Period",
                                  "Event Date",
                                  "Source",
                                  "Sticky Note"
                                  };

   public static String[] type_image = {"Record Creation",
                                  "Initial Contact Letter",
                                  "Remove Request",
                                  "Email Bounce",
                                  "document_notes.png",
                                  "Record Update",
                                  "Migration",
                                  "Record Remove",
                                  "Time Log",
                                  "Submitted by",
                                  "inbox.png",
                                  "mail-outbox.png",
                                  "7 Day Follow up",
                                  "14 Day Follow up",
                                  "30 Day Follow up",
                                  "60 Day Follow up",
                                  "90 Day Follow up",
                                  "Clear Followup",
                                  "Response Due",
                                  "Lead List Entry",
                                  "Clock In",
                                  "Clock Out",
                                  "End Pay Period",
                                  "Event Date",
                                  "Source",
                                  "Sticky Note"
                                  };

   public static boolean[] type_userEntry = {false,
                                       false,
                                       false,
                                       false,
                                       true,
                                       false,
                                       false,
                                       false,
                                       false,
                                       false,
                                       false,
                                       false,
                                       true,
                                       true,
                                       true,
                                       true,
                                       true,
                                       true,
                                       true,
                                       false,
                                       false,
                                       false,
                                       false,
                                       false,
                                       false,
                                       true
                                       };

   public static int[] type_followupDays = {0,
                                            0,
                                            0,
                                            0,
                                            0,
                                            0,
                                            0,
                                            0,
                                            0,
                                            0,
                                            0,
                                            0,
                                            7,
                                            14,
                                            30,
                                            60,
                                            90,
                                            -1,
                                             0,
                                             0,
                                             0,
                                             0,
                                             0,
                                             0,
                                             0,
                                             0
                                            };




   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public History( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
      init1();
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public History( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
      init1();
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public History( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
      init1();
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public History( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
      init1();
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public History( DBData dbData )
   {
      super( dbData );
      init1();
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public History( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
      init1();
   }

   public History( DBData aDbData, int aId )
   {
      super( aDbData);
      populateObject( "HISTORY", "EVENTID", aId );
   }

   public History( DBData aDbData, int aOwnerType, int aOwnerId, int recordType )
   {
      super( aDbData);
      init1();

      if ( aOwnerId != -1 )
      {
         populateObject( "History", "OWNERTYPE= " + aOwnerType + " AND OWNERID="+ aOwnerId + " AND EVENTTYPE =" + recordType, "" );
      }
      log.logEvent( log.TRACE, "History constructor from OWNERTYPE: " + aOwnerType + " and OwnerId: " + aOwnerId + " and EVENTTYPE: " + recordType );
   }

   public History( DBData aDbData, int aOwnerType, int aOwnerId, int recordType, String descr )
   {
      super( aDbData);
      init1();

      if ( aOwnerId != -1 )
      {
         populateObject( "History", "OWNERTYPE= " + aOwnerType + " AND OWNERID="+ aOwnerId + " AND EVENTTYPE =" + recordType + " AND DESCRIPTION = " + prepareStringField(descr), "" );
         ownerType = aOwnerType;
         ownerId = aOwnerId;
         eventType = recordType;
         description = descr;
      }
      log.logEvent( log.TRACE, "History constructor from OWNERTYPE: " + aOwnerType + " and OwnerId: " + aOwnerId + " and EVENTTYPE: " + recordType );
   }
   public History( DBData aDbData, int aOwnerType, int aOwnerId, int recordType, String aDescr, String aComment, boolean flag)
   {
      super( aDbData);
      init1();
      populateObject( "History", "OWNERTYPE= " + aOwnerType + " AND OWNERID="+ aOwnerId + " AND EVENTTYPE =" + recordType + " AND COMMENT = " + prepareStringField(aComment) + " AND DESCRIPTION = " + prepareStringField(aDescr) , "" );
   }

   public History( DBData aDbData, String aOriginator, int aOwnerType, int aOwnerId, int aRecordType, String aDescription, String aComment, String table )
   {
      super( aDbData);
      ownerType = aOwnerType;
      ownerId = aOwnerId;
      eventType = aRecordType;
      description = aDescription;
      comment = aComment;

      originator = aOriginator;
      if ( originator == null ) originator = "guest";
      else if ( originator.equals("") ) originator = "guest";

      createOrUpdateRecord( table, false, "" );
   }

   public History( DBData aDbData, String aOriginator, int aOwnerType, int aOwnerId, int aRecordType, String aDescription, String aComment, Timestamp aDate,  String table )
   {
      this( aDbData, aOriginator, aOwnerType, aOwnerId, aRecordType, aDescription, aComment, aDate, "", table );
   }

   public History( DBData aDbData, String aOriginator, int aOwnerType, int aOwnerId, int aRecordType, String aDescription, String aComment, Timestamp aDate, String aReference, String table )
   {
      super( aDbData);
      populateObject( "History", "DATE='"+aDate+"' AND OWNERTYPE= " + aOwnerType + " AND OWNERID="+ aOwnerId + " AND EVENTTYPE =" + aRecordType + " AND DESCRIPTION = " + prepareStringField(aDescription), "" );

      if ( !recordFound ) // this is most often used to update history from email library.  Will run multiple times.  So want to ensure only one entry per email
      {
         ownerType = aOwnerType;
         ownerId = aOwnerId;
         eventType = aRecordType;
         description = aDescription;
         comment = aComment;
         date = aDate;
         originator = aOriginator;
         reference = aReference;
         if ( originator == null ) originator = "guest";

         createOrUpdateRecord( table, false, "" );
         log.logEvent( "History constructor from Date: " + aDate + " OWNERTYPE: " + aOwnerType + " and OwnerId: " + aOwnerId + " and EVENTTYPE: " + aRecordType );
      }
      else
      {
         // make sure messageId is stored in reference field (added later... need to update existing entries)
         if (( reference.equals("") ) && (!aReference.equals("")))
         {
            reference = aReference;
            createOrUpdateRecord( table, false, "" );
            log.logEvent( "History constructor update existing record with reference string " + aReference );
         }
         else
         {
            log.logEvent( "Skipped (exists) --History constructor from Date: " + aDate + " OWNERTYPE: " + aOwnerType + " and OwnerId: " + aOwnerId + " and EVENTTYPE: " + aRecordType );
         }
      }
   }



   protected void init1()
   {
      strType = types[ eventType ];
   }

}
