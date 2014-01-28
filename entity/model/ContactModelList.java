package jwm.entity.model;

import jwm.db.*;
import jwm.entity.model.db.*;
import jwm.entity.*;
import jwm.project.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;

public class ContactModelList extends ContactModelDBRecordListBase
{
   protected ContactDataAccessCtrl ctrl = null;

   private Document doc;

   protected String   title = "---";
   public  void       setTitle( String aTitle ) { title = aTitle; }
   public  String     getTitle()       { return(title); }

   protected boolean  listOption = true;
   public  void       setListOption( boolean aListOption ) { listOption = aListOption; }
   public  boolean    getListOption()    { return(listOption); }

   protected String   reportEntryTemplateQualifiers = "---";
   public  void       setReportEntryTemplateQualifiers( String aReportEntryTemplateQualifiers ) { reportEntryTemplateQualifiers = aReportEntryTemplateQualifiers; }
   public  String     getReportEntryTemplateQualifiers() { return(reportEntryTemplateQualifiers); }

   protected boolean  expandedAccountInfo = false;

   protected int      count = 0;

   protected String   type = "";
   protected int      groupId = -1;
   protected int      statusId = -1;

   protected int      batchEmailType = -1;
   protected int      batchEmailId = -1;

   private String[]   mailTemplates   = null;
   private int[]      mailTemplateIds = null;

   private String[]   templateQualifiers = { "---" };

   private int        followUpDue = 0;
   private int        followUpPending = 0;



   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactModelList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactModelList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "CONTACTMODEL", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactModelList( DBData dbData )
   {
      super( dbData );
   }

   public ContactModelList( DBData dbData, Document aDoc, ContactDataAccessCtrl aCtrl, int ndx )  // use ndx into ctrl.statusArray
   {
      super( dbData );
      doc = aDoc;
      ctrl = aCtrl;

      buildContactModelList( new ContactList( dbData, ctrl.statusArray[ndx], true, true ), true, ctrl.max ); // can't limit query due to no date in record to sort; just limit contact model objects
      type = "bySingleStatus";
      statusId = ctrl.statusArray[ndx];
      batchEmailId = ctrl.statusArray[ndx];
      batchEmailType = ObjectClassID.CONTACTSTATUS;
      ProjectStatus pStatus = new ProjectStatus( dbData, statusId );
      templateQualifiers[0] = pStatus.getName();
      title = pStatus.getName();
   }

   public ContactModelList( DBData dbData, Document aDoc, ContactDataAccessCtrl aCtrl )
   {
      super( dbData );
      doc = aDoc;
      ctrl = aCtrl;

      title = ctrl.title;

      dbData.getLog().logEvent( "ContactModelList Constructor -- Title -- " + title);

      if ( ctrl.inclSearch )
      {
         buildContactModelList(  new ContactList( dbData, ctrl.inclAbandoned, ctrl.search, false), false);
         if (title.equals("")) title = "Search: " + ctrl.search;
         type = "search";
      }

      if ( ctrl.inclSingleContact )
      {
         buildContactModelList(  new ContactList( dbData, ctrl.singleContactId, true, -1), false);
         if (title.equals("")) title = "Single Contact";
         type = "Single Contact";
      }

      if ( ctrl.inclRecentAccountActivity )
      {
         buildContactModelList( new ContactList( dbData, true, 50), false); // most recent account/invoice updates
         if (title.equals("")) title = "Recent Client Account Activity";
         expandedAccountInfo = true;
         type = "Recent Account Activity";
      }

      if ( ctrl.inclAllOpenAccounts )
      {
         buildContactModelList( new ContactList( dbData, true, true), false); // all contacts with open invoices
         if (title.equals("")) title = "All Open Accounts";
         expandedAccountInfo = true;
         type = "All Open Accounts";
      }

      if ( ctrl.inclByGroupName )
      {
         if (title.equals("")) title = "Group: " + ctrl.groupName;
         buildContactModelList( new ContactList( dbData, ctrl.groupName, false), false, ctrl.max );
         type = "byGroup";
         EntityGroup theGroup = new EntityGroup( dbData, ctrl.groupName );  //get the container group by name to get the groupNum
         groupId = theGroup.getGroupNum();
         batchEmailId = theGroup.getGroupNum();
         batchEmailType = ObjectClassID.GROUP;
         templateQualifiers[0] = ctrl.groupName;

      }

      if ( ctrl.inclByStatus )
      {
         buildContactModelList( new ContactList( dbData, ctrl.statusArray, 9999 ), true, ctrl.max ); // can't limit query due to no date in record to sort; just limit contact model objects
         if ( ctrl.statusArray.length == 1 )
         {
            type = "bySingleStatus";
            statusId = ctrl.statusArray[0];
            batchEmailId = ctrl.statusArray[0];
            batchEmailType = ObjectClassID.CONTACTSTATUS;
            ProjectStatus pStatus = new ProjectStatus( dbData, statusId );
            templateQualifiers[0] = pStatus.getName();
         }
         else
         {
            type = "byMultipleStatus";
         }
      }

      if ( ctrl.inclByEventDate )
      {
        type = "byDate";
        System.out.println( "ContactModelList -- inclByEventDate" );

         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

         try
         {
            buildContactModelList( new ContactList( dbData, ctrl.inclAbandoned, dateFormat.parse(ctrl.eventDate), 10), true);
         }
         catch( Exception e)
         {
            dbData.getLog().logEvent( "ContactModelList " + e );
         }
         if (title.equals("")) title = "Event Date: " + ctrl.eventDate;

      }

      if ( ctrl.inclByYear )
      {
         type = "byYear";
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

         try
         {
            int[] statusClassArray = {1020, 1040 };
            buildContactModelList( new ContactList( dbData, statusClassArray, dateFormat.parse(ctrl.year+"-01-01"), dateFormat.parse(ctrl.year+"-12-31")), true);
         }
         catch( Exception e)
         {
            dbData.getLog().logEvent( "ContactModelList " + e );
         }
         if (title.equals("")) title = "Year: " + ctrl.year;

      }

      if ( ctrl.inclByEventLoc )
      {
         buildContactModelList( new ContactList( dbData, ctrl.omitStatusArray, 18, 0, ctrl.eventLoc ), true );
         if (title.equals("")) title = "Event Loc: " + ctrl.eventLoc;
      }

      if ( ctrl.inclByFollowUp )
      {
         dbData.getLog().logEvent( "ContactModelList -- byFollowUp" );
         buildContactModelList( new ContactList( dbData, ctrl.followUpStatus, ctrl.max ), false );
         if (title.equals("")) title = "By Followup";
      }

      if ( ctrl.inclRecent )
      {
         buildContactModelList( new ContactList( dbData, ctrl.max), false);
         if (title.equals("")) title = "Recent";
      }

      if ( ctrl.inclByOpenWorkItems )
      {
         dbData.getLog().logEvent( "ContactModelList -- byOpenWorkItems" );
         buildContactModelList( new ContactList( dbData, true, true, true), false);
         if (title.equals("")) title = "Contacts with Open Work Items";
      }


      if ( ctrl.inclMailTemplates )
      {
         MailTemplateList templateList = new MailTemplateList( dbData, templateQualifiers, batchEmailType );

         mailTemplates = new String[ templateList.getRecordList().length ];
         mailTemplateIds= new int[ templateList.getRecordList().length ];

         for ( int j = 0; j < templateList.getRecordList().length; j++ )
         {
            MailTemplate template = (MailTemplate) templateList.getRecordList()[j];
            mailTemplates[j] = template.getName();
            mailTemplateIds[j] = template.getId();
         }
      }
   }

   private void buildContactModelList( ContactList contactList, boolean sortFlag )
   {
      buildContactModelList( contactList, sortFlag, 9999, -1 );
   }

   private void buildContactModelList( ContactList contactList, boolean sortFlag, int max )
   {
      buildContactModelList( contactList, sortFlag, max, -1 );
   }

   private void buildContactModelList( ContactList contactList, boolean sortFlag, int max, int followUpStatus )
   {
      try
      {
         if (sortFlag ) contactList.sort();
      }
      catch( Exception e)
      {
         System.out.println( "ContactModelList.buildContactModelList() sort --> " + e );
      }

      // in case it's needed below....
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
      String newGroupName = "@ContactGroup-"+ dateFormat.format( new java.util.Date() );


      recordList = getListInstance(0);  // initialize contactModel recordList to size 0; preparing to build the list
      int j=0;
      ContactModel previousContact = new ContactModel(dbData); // dummy to initialize....

      for ( int i=0; i < contactList.getRecordList().length; i++ )
      {
         Contact contact = (Contact) contactList.getRecordList()[i];


         if (( followUpStatus == -1 ) || ( contact.getFollowUpStatus() == followUpStatus ))
         {
            ContactModel aContactModel = new ContactModel( dbData, contact.getId(), doc, ctrl, j ); // build a contact from each contact group

            dbData.getLog().logEvent( Log.ERROR, "**** buildContactModelList " + i + " of " + contactList.getRecordList().length + " " + contact.getName() );

            if (aContactModel.trackingDateText.equals( previousContact.trackingDateText ))
            {
               aContactModel.trackingDateClass = "trackingdateoverlap";
               previousContact.trackingDateClass = "trackingdateoverlap";
            }
            previousContact = aContactModel;

            // 9/19/13 -- decided that this is where expired prospects get set to abandoned....

            if ( !aContactModel.checkAbandon() ) // use the model since dates/status have already been calculated
            {
               add( aContactModel ); //add it to the list

               if ( aContactModel.getFollowUpStatus() == Contact.FOLLOWUP_PENDING ) followUpPending++;
               if ( aContactModel.getFollowUpStatus() == Contact.FOLLOWUP_DUE     ) followUpDue++;

               if ( ctrl.createGroup )  new EntityGroup( dbData, newGroupName, "Contact Groups", EntityGroup.TYPE_GENERAL, ObjectClassID.CONTACT, contact.getId() );

               j++;
            }
         }
         if ( j == (max-1) ) break;
      }
      count = j;
   }



   public Element getElement()
   {
      Element contactListElement = doc.createElement( "contactlist" );
      contactListElement.setAttribute( "title", title );
      contactListElement.setAttribute( "count", iString(count) );
      contactListElement.setAttribute( "statusId", iString(statusId ));
      contactListElement.setAttribute( "groupId", iString(groupId ));
      contactListElement.setAttribute( "type", type );
      contactListElement.setAttribute( "batchEmailType", iString(batchEmailType ));
      contactListElement.setAttribute( "batchEmailId", iString(batchEmailId ));
      contactListElement.setAttribute( "followUpDue", iString(followUpDue ));
      contactListElement.setAttribute( "followUpPending", iString(followUpPending ));

      if ( ctrl.inclIndividualContacts )
      {
         for ( int i = 0; i < count; i++ )
         {
            ContactModel contactModel = (ContactModel) recordList[i];
            contactListElement.appendChild( contactModel.getElement() );
         }
      }

      if (( ctrl.inclMailTemplates )
         &&( batchEmailType != -1 ))
      {

         Element mailTemplateElement = doc.createElement( "mailTemplates" );
         for (int i = 0; i< mailTemplates.length; i++ )
         {
            Element templateElement = doc.createElement( "template" );
            templateElement.setAttribute( "name", mailTemplates[i] );
            templateElement.setAttribute( "id", iString( mailTemplateIds[i] ) );
            mailTemplateElement.appendChild( templateElement );
         }
         contactListElement.appendChild( mailTemplateElement );
      }

      return( contactListElement );
   }
}
