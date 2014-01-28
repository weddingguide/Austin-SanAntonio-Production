package jwm.entity.model;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.model.db.*;
import jwm.project.model.*;
import jwm.gl2.*;
import jwm.gl2.model.*;
import jwm.event.model.*;
import jwm.entity.*;
import jwm.project.*;
import jwm.itemtrack.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;

public class ContactModel extends Contact
{
   private Document doc;

   private ContactDataAccessCtrl ctrl = null;

   private PersonModelList personModelList = null;
   private ProjectModelList projectModelList = null;
   private AccountStatementModel accountStatementModel = null;
   private HistoryModelList historyModelList = null;
   private HistoryModelList stickyNoteModelList = null;

   private int followUpStatus = -1;
   public  void setFollowUpStatus( int aFollowUpStatus ) { followUpStatus = aFollowUpStatus; }
   public  int getFollowUpStatus()
   {
      if (followUpStatus == -1 ) followUpStatus = super.getFollowUpStatus();
      return(followUpStatus);
   }

   private String followUpStatusText = "";
   private String followUpClass = "";

   private String statusHTML = "";

   public  String trackingDateText = "";
   private String trackingDateTextLong = "";
   public  String trackingDateClass= "";

   private String createDate = "";

   private String lastUpdateText    = "";

   private String lastHistoryIconHTML = "";
   private String lastHistoryDate = "";


   private String rowClass;

   private boolean deleteAvailable = true;

   private String hrefParms = "";

   private int[]      workItemCounts = new int[WorkItem.statusText.length];
   private String[]   workItemClassText   = { "hot", "warm", "complete" };
   private int[]      workItemClassCounts = new int[workItemClassText.length];


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactModel( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactModel( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactModel( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactModel( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactModel( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactModel( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public ContactModel( DBData dbData, int anId, Document aDoc, ContactDataAccessCtrl aCtrl, int ndx )
   {
      super( dbData, anId );
      doc = aDoc;
      ctrl = aCtrl;
      deepPopulate();

      if ( ctrl.inclMembers )          personModelList       = new PersonModelList( dbData, doc, ctrl.personDataAccessCtrl, personList );
      if ( ctrl.inclProjects )         projectModelList      = new ProjectModelList( dbData, doc, ctrl.projectDataAccessCtrl, ObjectClassID.CONTACT, id );
      if ( ctrl.inclAccountStatement ) accountStatementModel = new AccountStatementModel( dbData, doc, ctrl.glDataAccessCtrl, ObjectClassID.CONTACT, id );
      if ( ctrl.inclHistory )          historyModelList      = new HistoryModelList( dbData, doc, ObjectClassID.CONTACT, id );
      if ( ctrl.inclStickyNotes)       stickyNoteModelList   = new HistoryModelList( dbData, doc, ObjectClassID.CONTACT, id, History.TYPE_STICKYNOTE );

      if ( ctrl.inclAbandoned )        hrefParms += "&inclAbandoned";

      followUpStatus = getFollowUpStatus();
      followUpStatusText = FOLLOWUP_STATUS_TEXT[ followUpStatus ];

      ProjectStatus pStatus = new ProjectStatus( dbData, status );
      statusHTML = pStatus.getHTML();

      SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd");
      SimpleDateFormat dateFormatLong = new SimpleDateFormat( "yyyy-MM-dd (EEE)");
      try
      {
         trackingDateText = dateFormat.format( getTrackingDate() );
         trackingDateTextLong = dateFormatLong.format( getTrackingDate() );
         createDate = dateFormat.format( people.getCreateDate() );
      }
      catch( Exception e)
      {
         trackingDateText = "** invalid date **";
      }
      try
      {
         lastUpdateText = dateFormat.format( lastUpdate );
      }
      catch( Exception e)
      {
         lastUpdateText = "** invalid date **";
      }

      HistoryList historyList = new HistoryList( dbData, ObjectClassID.CONTACT, id, History.TYPE_RECORD_UPDATE, false, 100 );
      History lastHistory = new History( dbData );
      if ( historyList.getRecordList().length > 0 )
      {
         lastHistory = (History) historyList.getRecordList()[0];
      }
      lastHistoryIconHTML = lastHistory.getStrType2();

      SimpleDateFormat  dateFormatter1 = new SimpleDateFormat ("yyyy-MM-dd");
      lastHistoryDate = dateFormatter1.format( new java.sql.Date(lastHistory.getDate().getTime()));

      if ( ndx % 2 != 0 ) rowClass="row0";
      else                rowClass="row1";

      if (followUpStatus == Contact.FOLLOWUP_PENDING ) followUpClass = "followUpPending";
      if (followUpStatus == Contact.FOLLOWUP_DUE ) followUpClass = "followUpDue";



      InvoiceList aInvoiceList = new InvoiceList( dbData, ObjectClassID.CONTACT, id );
      if ( aInvoiceList.getRecordList().length > 0 ) deleteAvailable = false;

      for (int i=0; i<workItemCounts.length; i++)
      {
         workItemCounts[i]=0;
      }
      for (int i=0; i<workItemClassCounts.length; i++)
      {
         workItemClassCounts[i]=0;
      }

      ProjectList aProjectList = new ProjectList( dbData, ObjectClassID.CONTACT, id, false, true  );
      for ( int jj=0; jj < aProjectList.getRecordList().length; jj++ )
      {
         Project aProject = (Project) aProjectList.getRecordList()[jj];
         if ( aProject.getStatus() != 6 ) deleteAvailable = false;  // this status is "Deleted"

         if ( ctrl.inclWorkItemCounts )
         {
            for( int i=0; i < aProject.getWorkItemList().getRecordList().length; i++ )
            {
               WorkItem workItem = (WorkItem) aProject.getWorkItemList().getRecordList()[i];
               workItemCounts[ workItem.getStatus() ]++;

               if ( WorkItem.statusClass[ workItem.getStatus() ].equals( "hot" ) ) workItemClassCounts[0]++;
               if ( WorkItem.statusClass[ workItem.getStatus() ].equals( "warm" ) ) workItemClassCounts[1]++;
               if ( WorkItem.statusClass[ workItem.getStatus() ].equals( "complete" ) ) workItemClassCounts[2]++;
            }
         }
      }

      EntityGroupList aGroupList = new EntityGroupList( dbData, id, true, true, true);
      if ( aGroupList.getRecordList().length > 0 ) deleteAvailable = false;

      trackingDateClass = "trackingdateback";
      try
      {
         if ( getTrackingDate().after( new java.util.Date() )) trackingDateClass = "trackingdateforward";
      }
      catch( Exception e)
      {
      }

   }

   public Element getElement()
   {
      Element contactElement = doc.createElement( "contact" );
      contactElement.setAttribute( "name", name );
      contactElement.setAttribute( "id", new Integer( id ).toString() );
      contactElement.setAttribute( "status", new Integer( status ).toString() );

      contactElement.setAttribute( "followupstatusid", new Integer( followUpStatus ).toString() );
      contactElement.setAttribute( "followupstatus", followUpStatusText );
      contactElement.setAttribute( "followupclass", followUpClass );
      contactElement.setAttribute( "trackingDate", trackingDateText );
      contactElement.setAttribute( "trackingDateLong", trackingDateTextLong );
      contactElement.setAttribute( "createDate", createDate );
      contactElement.setAttribute( "lastUpdate", lastUpdateText );
      contactElement.setAttribute( "lastHistoryDate", lastHistoryDate );
      contactElement.setAttribute( "trackingDateClass", trackingDateClass );
      contactElement.setAttribute( "rowClass", rowClass );
      contactElement.setAttribute( "deleteAvailable", bString(deleteAvailable));
      contactElement.setAttribute( "dateIsScheduled", bString(getDateIsScheduled()));
      contactElement.setAttribute( "hrefParms", hrefParms );

      Element statusHTMLElement = doc.createElement("statusHTML");
      statusHTMLElement.appendChild(doc.createCDATASection(statusHTML));
      contactElement.appendChild(statusHTMLElement);

      Element lastHistoryIconElement = doc.createElement("lastHistoryIcon");
      lastHistoryIconElement.appendChild(doc.createCDATASection(lastHistoryIconHTML));
      contactElement.appendChild(lastHistoryIconElement);

      if ( ctrl.inclMembers ) contactElement.appendChild( personModelList.getElement() );

      if ( ctrl.inclHistory) contactElement.appendChild( historyModelList.getElement() );

      if ( ctrl.inclStickyNotes) contactElement.appendChild( stickyNoteModelList.getElement("stickyNotes") );

      if ( ctrl.inclProjects ) contactElement.appendChild( projectModelList.getElement() );

      if ( ctrl.inclAccountStatement ) contactElement.appendChild( accountStatementModel.getElement() );

      if ( ctrl.inclWorkItemCounts )
      {
         Element workItemCountsElement = doc.createElement("workItemCounts");
         contactElement.appendChild( workItemCountsElement );
         for (int i=1; i<workItemCounts.length; i++)
         {
            Element workItemStatusCountElement = doc.createElement("workItemStatus");
            workItemStatusCountElement.setAttribute( "status", WorkItem.statusText[i] );
            workItemStatusCountElement.setAttribute( "count", iString( workItemCounts[i] ) );
            workItemCountsElement.appendChild( workItemStatusCountElement );
         }
         Element workItemClassCountsElement = doc.createElement("workItemClassCounts");
         contactElement.appendChild( workItemClassCountsElement );
         for (int i=0; i<workItemClassCounts.length; i++)
         {
            Element workItemStatusCountElement = doc.createElement("workItemStatus");
            workItemStatusCountElement.setAttribute( "class", workItemClassText[i] );
            workItemStatusCountElement.setAttribute( "count", iString( workItemClassCounts[i] ) );
            workItemClassCountsElement.appendChild( workItemStatusCountElement );
         }
      }
      return( contactElement );
   }
}
