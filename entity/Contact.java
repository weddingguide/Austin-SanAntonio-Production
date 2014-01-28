package jwm.entity;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.db.*;
import jwm.event.*;
import jwm.project.*;
import jwm.logger.*;
import java.text.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;

public class Contact extends ContactDBRecordBase
{
   public static int FOLLOWUP_NONE = 0;
   public static int FOLLOWUP_PENDING = 1;
   public static int FOLLOWUP_DUE = 2;

   private Project trackingProject = null;

   protected int status = -999;
   public  void setStatus( int aStatus )
   {
      status = aStatus;
      people.setStatus( aStatus );
   }
   public  int getStatus()
   {
      if ( getProjectCount() != 0 ) setStatus(); // if there are projects... projects dictate status
      return(status);
   }

   private ProjectList projectList = null;
   public  void        setProjectList( ProjectList aProjectList ) { projectList = aProjectList; }
   public  void        setProjectList()
   {
      if (projectList == null ) projectList = new ProjectList( dbData, ObjectClassID.CONTACT, id, false, true );
   }
   public  ProjectList getProjectList()
   {
      if ( projectList == null ) setProjectList();
      return(projectList);
   }


   private  int projectCount =-999;
   public  void setProjectCount( int aProjectCount ) { projectCount = aProjectCount; }
   public  int  getProjectCount()
   {
      if ( projectCount == -999 )
      {
         setProjectList();
         projectCount = projectList.getRecordList().length;
      }
      return(projectCount);
   }


   public static String[] FOLLOWUP_STATUS_TEXT = {"None", "Pending", "Due" };

   protected EntityGroup people;
   public  void        setPeople( EntityGroup aPeople ) { people = aPeople; }
   public  EntityGroup getPeople()         { return(people); }

   private String[] emailAddresses = null;
   public  void    setEmailAddresses( String[] aEmailAddresses ) { emailAddresses = aEmailAddresses; }
   public  String[] getEmailAddresses()
   {
      if (emailAddresses == null ) deepPopulate();
      return(emailAddresses);
   }

   protected PersonList personList = null;
   public  void       setPersonList( PersonList aPersonList ) { personList = aPersonList; }
   public  PersonList getPersonList()
   {
      if (personList == null ) deepPopulate();
      return(personList);
   }

   private String to         = "[to]";
   public  void   setTo( String aTo ) { to = aTo; }
   public  String getTo()        { return(to); }

   private String brideFirst = "[brideFirst]";
   public  void   setBrideFirst( String aBrideFirst ) { brideFirst = aBrideFirst; }
   public  String getBrideFirst() { return(brideFirst); }

   private String brideLast  = "[brideLast]";
   public  void   setBrideLast( String aBrideLast ) { brideLast = aBrideLast; }
   public  String getBrideLast() { return(brideLast); }

   private String groomFirst = "[groomFirst]";
   public  void   setGroomFirst( String aGroomFirst ) { groomFirst = aGroomFirst; }
   public  String getGroomFirst() { return(groomFirst); }

   private String groomLast  = "[groomLast]";
   public  void   setGroomLast( String aGroomLast ) { groomLast = aGroomLast; }
   public  String getGroomLast() { return(groomLast); }

   private String altFirst = "[altFirst]";
   public  void   setAltFirst( String aAltFirst ) { altFirst = aAltFirst; }
   public  String getAltFirst() { return(altFirst); }

   private String altLast  = "[altLast]";
   public  void   setAltLast( String aAltLast ) { altLast = aAltLast; }
   public  String getAltLast() { return(altLast); }

   private String whose      = "your";
   public  void   setWhose( String aWhose ) { whose = aWhose; }
   public  String getWhose()     { return(whose); }

   private Project aProject;
   public  void    setAProject( Project aAProject ) { aProject = aAProject; }
   public  Project getAProject()   { return(aProject); }


   private int    projectId;
   public  void   setProjectId( int aProjectId ) { projectId = aProjectId; }
   public  int    getProjectId() { return(projectId); }

   private String eventDate = "[date]";
   public  void   setEventDate( String aEventDate ) { eventDate = aEventDate; }
   public  String getEventDate() { return(eventDate); }

   private String shortName = "[shortName]";
   public  void   setShortName( String aShortName ) { shortName = aShortName; }
   public  String getShortName() { return(shortName); }

   private HistoryList historyList = null;
   public  void        setHistoryList( HistoryList aHistoryList ) { historyList = aHistoryList; }


   private boolean dateIsScheduled = false;
   public  void    setDateIsScheduled( boolean aDateIsScheduled ) { dateIsScheduled = aDateIsScheduled; }
   public  boolean getDateIsScheduled()
   {
      ContactList conflictDateContacts = new ContactList( dbData, 3, getTrackingDate());
      if ( conflictDateContacts.getRecordList().length > 0 ) dateIsScheduled = true;
      return(dateIsScheduled);
   }


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Contact( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
      dbData= aDbData;
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Contact( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
      dbData= aDbData;
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Contact( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
      dbData= aDbData;
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Contact( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
      dbData= aDbData;
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Contact( DBData aDbData )
   {
      super( aDbData );
      dbData= aDbData;
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Contact( DBData aDbData, String[] fields, int[] map )
   {
      super( aDbData, fields, map );
      dbData= aDbData;
   }

   public Contact( DBData aDbData, EntityGroup aGroup )
   {
      super( aDbData );
      dbData= aDbData;
      people = aGroup;
      id = aGroup.getId();  // contact id should always match entity group id (groupNum)
      name = aGroup.getName();
      createDate = aGroup.getCreateDate();
      lastUpdate = aGroup.getLastUpdate();
   }

   public Contact( DBData aDbData, int contactId )
   {
      super( aDbData );
      dbData= aDbData;
      EntityGroup aGroup = new EntityGroup( dbData, ObjectClassID.CONTACT, contactId );
      people = aGroup;
      id = aGroup.getId();  // contact id should always match entity group id (groupNum)
      name = aGroup.getName();
      createDate = aGroup.getCreateDate();
      lastUpdate = aGroup.getLastUpdate();
      recordFound = aGroup.isRecordFound();
   }

   public Contact( DBData aDbData, String aName, boolean signatureFlag  )
   {
      super( aDbData );
      dbData= aDbData;
      EntityGroup aGroup = new EntityGroup( dbData, aName );
      people = aGroup;
      id = aGroup.getId();  // contact id should always match entity group id (groupNum)
      name = aGroup.getName();
      createDate = aGroup.getCreateDate();
      lastUpdate = aGroup.getLastUpdate();
      recordFound = aGroup.isRecordFound();
   }

   public Contact( DBData aDbData, String emailAddress )
   {
      super( aDbData );
      String[] emailAddresses = new String[1];
      emailAddresses[0] = emailAddress;

      dbData= aDbData;
      EntityGroup aGroup = new EntityGroup( dbData, ObjectClassID.CONTACT, emailAddresses );
      people = aGroup;
      id = aGroup.getId();  // contact id should always match entity group id (groupNum)
      name = aGroup.getName();
      createDate = aGroup.getCreateDate();
      lastUpdate = aGroup.getLastUpdate();
      recordFound = aGroup.isRecordFound();
   }

   public Contact( DBData aDbData, String[] emailAddresses )
   {
      super( aDbData );
      dbData= aDbData;
      EntityGroup aGroup = new EntityGroup( dbData, ObjectClassID.CONTACT, emailAddresses );
      people = aGroup;
      id = aGroup.getId();  // contact id should always match entity group id (groupNum)
      name = aGroup.getName();
      createDate = aGroup.getCreateDate();
      lastUpdate = aGroup.getLastUpdate();
      recordFound = aGroup.isRecordFound();
   }




   public Contact( DBData aDbData, int personId, boolean createFlag )
   {
      super( aDbData );
      dbData= aDbData;
      ContactList contactList = new ContactList( dbData, personId, true);
      if (contactList.getRecordList().length > 0 )
      {
         Contact aContact = (Contact) contactList.getRecordList()[0];
         people = aContact.getPeople();
         id = aContact.getId();
         name = aContact.getName();
         createDate = aContact.getCreateDate();
         lastUpdate = aContact.getLastUpdate();
         recordFound = true;
      }
      else // does not exist
      {
         recordFound = false;
         if ( createFlag )
         {
            people = new EntityGroup( dbData, -1 );
            people.setType( ObjectClassID.CONTACT );

            Person aPerson = new Person( dbData, personId );
            people.setName( aPerson.getFirstName() + " " + aPerson.getLastName() );
            people.setCategory(3); // 3 is "Customer Group" category
            people.createRecord("ENTITYGROUP");

            // now dup the group stuff into this contact object
            id = people.getId();
            name = people.getName();
            createDate = people.getCreateDate();
            lastUpdate = people.getLastUpdate();

            GroupMemberMap map = new GroupMemberMap( dbData, id, Person.RECORDTYPE_PERSON, personId); // now put this person into the new contact group
            map.createOrUpdateRecord( "GROUPMEMBERMAP" );
         }
      }
   }

   public void saveStatus()
   {
      EntityGroup cGroup = new EntityGroup( dbData, id );
      cGroup.setStatus( status );
      cGroup.createOrUpdateRecord("ENTITYGROUP", true );
   }

   public void setStatus()
   {
     // if no projects exist, we can set the project status as in the past on the project itself.
     // if projects do exist, status is inherited from the project status


      status = people.getStatus(); // start with what was there before...
      int origStatus = status;

      int statusClass = -2;
      setProjectList();
      for (int i = 0; i < projectList.getRecordList().length; i++ )
      {
         Project aProject = (Project)projectList.getRecordList()[i];
         ProjectStatus pStatus = new ProjectStatus( dbData, aProject.getStatus() );

         if ( pStatus.getStatusClass() >= statusClass ) // higher classes for projects take precedence
         {
            status = aProject.getStatus();
            statusClass = pStatus.getStatusClass();
            trackingProject = aProject;
         }
      }
      if (status != origStatus )
      {
         people.setStatus( status );
         people.updateRecord("ENTITYGROUP" );
      }
   }

   public void updateStatus( int newStatus )
   {
      // need to update project that is currently dictating this contact's status
      setStatus(); // use this to find dictating project
      if ( trackingProject != null ) trackingProject.updateStatus( newStatus );
      people.setStatus( newStatus ); // just to be sure...
      people.updateRecord( "ENTITYGROUP" );
   }

   public String getPersonalizedAttributeText( int domainId, int attributeDefId, int attributeDefSubId, int ndx )
   {
      return( personalize( EntityAttributeList.getAttributeValue(dbData, ObjectClassID.DOMAIN, domainId, 0, attributeDefId, attributeDefSubId, ndx)));
   }

   public String personalize( String text )
   {
      text = text.replaceAll("%%to", to);
      text = text.replaceAll("%%whose", whose);
      text = text.replaceAll("%%date", eventDate);
      text = text.replaceAll("%%brideFirst", brideFirst);
      text = text.replaceAll("%%brideLast", brideLast);
      text = text.replaceAll("%%groomFirst", groomFirst);
      text = text.replaceAll("%%groomLast", groomLast);
      text = text.replaceAll("%%altFirst", altFirst);
      text = text.replaceAll("%%altLast", altLast);
      text = text.replaceAll("%%shortName", shortName);
      return( text );
   }

   public void deepPopulate()
   {
      Vector emailAddressVector = new Vector();
      Hashtable usedEmailAddresses;
      usedEmailAddresses = new Hashtable();

      personList = new PersonList( dbData, -1, id );
      for ( int i= 0; i < personList.getRecordList().length; i++ )
      {
         Person aPerson = (Person) personList.getRecordList()[i];
         aPerson.deepPopulate();

         GroupMemberMap aMap = new GroupMemberMap( dbData, id, -1, aPerson.getPersonId(), true );
         if (( aMap.getMemberRole() == GroupMemberMap.MEMBERROLE_BRIDE )
            ||( aMap.getMemberRole() == GroupMemberMap.MEMBERROLE_FAMILY_WIFE ) )
         {
            brideLast = aPerson.getLastName();
            brideFirst= aPerson.getFirstName();
            aPerson.setRole( "Bride" );
         }
         else if (( aMap.getMemberRole() == GroupMemberMap.MEMBERROLE_GROOM )
                 ||( aMap.getMemberRole() == GroupMemberMap.MEMBERROLE_FAMILY_HUSBAND ))
         {
            groomLast = aPerson.getLastName();
            groomFirst= aPerson.getFirstName();
            aPerson.setRole( "Groom" );
         }
         else if (( aMap.getMemberRole() == GroupMemberMap.MEMBERROLE_ALT_CONTACT )
                  ||( aMap.getMemberRole() == GroupMemberMap.MEMBERROLE_FAMILY_CONTACTPERSON ))
         {
            altLast = aPerson.getLastName();
            altFirst= aPerson.getFirstName();
            aPerson.setRole( "Other" );
         }
         else
         {
            aPerson.setRole( (new Integer( aMap.getMemberRole() )).toString() );
         }

         if (aMap.getPrimaryMember() > 0)   aPerson.setPrimaryMember( true );

         EmailList  emailAddressList = aPerson.getEmailAddresses();

         for ( int j = 0; j < emailAddressList.getRecordList().length; j++ )
         {
            String addr = ((Email)emailAddressList.getRecordList()[j]).getEmailAddress();
            if (!addr.trim().equals(""))
            {
               if (!emailAddressVector.contains( addr) ) emailAddressVector.add(addr);
            }
         }
      }
      emailAddresses = new String[emailAddressVector.size()];
      for ( int i=0; i<emailAddressVector.size(); i++ )
      {
         emailAddresses[i] = (String) emailAddressVector.elementAt( i );
      }

//??  diff than setProjectList()... but theoretically should not be necessary.... delete later.... projectList = new ProjectList( dbData, ObjectClassID.CONTACT, id );
      setProjectList();
      for (int i = 0; i < projectList.getRecordList().length; i++ )
      {
         aProject = (Project)projectList.getRecordList()[i];
         projectId = aProject.getId();
         break; // first project is probably primary
      }

      if ( aProject != null )
      {
         SimpleDateFormat formatter = new SimpleDateFormat ("EEEE, MMMM d, yyyy");
         eventDate = formatter.format( aProject.getProjectDate());
         shortName = aProject.getShortName();
      }

      String who = (new History( dbData, ObjectClassID.CONTACT, id, History.TYPE_SUBMITTED_BY )).getDescription();

      if (who.equals("bride"))
      {
         to = brideFirst;
      }

      if (who.equals("groom"))
      {
         to = groomFirst;
      }

      if (who.equals("other"))
      {
         to = altFirst;
         whose = brideFirst + " and " + groomFirst +"'s ";
      }

      setStatus();
   }

   public int getFollowUpStatus()
   {
      dbData.getLog().logEvent( "Contact.getFollowUpStatus()" );
      int followUp = FOLLOWUP_NONE;
      int days = 0;

      HistoryList historyList = new HistoryList( dbData, ObjectClassID.CONTACT, id, History.TYPE_RECORD_UPDATE, false, 100 );
      if ( historyList.getRecordList().length > 0 )
      {
        // first loop looking for followup situation


        for (int j=0; j<historyList.getRecordList().length; j++)
        {
           History entry = (History) historyList.getRecordList()[j];

           Calendar entryDateC  = Calendar.getInstance();
           entryDateC.setTime( entry.getDate() );

           Calendar today = Calendar.getInstance();
           today.setTime( new java.util.Date() );

           // days siuce this entry entered
           days = (int) (( today.getTimeInMillis() - entryDateC.getTimeInMillis() ) / (DBEnhDateColumn.MILLISPERDAY));


           if (entry.getEventType() == History.TYPE_CLEAR_FOLLOWUP ) // first thing we hit in the loop is a clear-followup... it trumps all followups
           {
              break;
           }
         // if first thing we hit is an explicit followup, then set based on that and exit
           if ( (entry.getEventType() == History.TYPE_FOLLOWUP_7)
              ||(entry.getEventType() == History.TYPE_FOLLOWUP_14)
              ||(entry.getEventType() == History.TYPE_FOLLOWUP_30)
              ||(entry.getEventType() == History.TYPE_FOLLOWUP_60)
              ||(entry.getEventType() == History.TYPE_FOLLOWUP_90)
              ||(entry.getEventType() == History.TYPE_RESPONSE_DUE) )
           {
              int followUpDays = History.type_followupDays[entry.getEventType()];
              if (followUpDays > days)
              {
                 followUp = FOLLOWUP_PENDING;
              }
              else
              {
                 followUp = FOLLOWUP_DUE;
              }
              break;
           }

           if ( days < 120 ) // only worry about mail below if it's recent mail
           {
              // if first thing we hit is an inbound email, automatically set to response_due
              if (entry.getEventType() == History.TYPE_RECEIVED_EMAIL)
              {
                 followUp = FOLLOWUP_DUE;
                 break;
              }


              // if first thing we hit is an outbound_email, treat it as a 7-day followup
              if (entry.getEventType() == History.TYPE_SENT_EMAIL)
              {
                 int followUpDays = 7;
                 if (followUpDays > days)
                 {
                    followUp = FOLLOWUP_PENDING;
                 }
                 else
                 {
                    followUp = FOLLOWUP_DUE;
                 }
                 break;
              }
           }
        }
      }
      return( followUp );
   }


   public Person getPrimaryPerson()
   {
      Person member = new Person( dbData );
      member.deepPopulate();  // in case no members

      PersonList members = new PersonList( dbData, EntityGroup.TYPE_CONTACTCONTAINER, id );
      System.out.println( "person count: " + members.getRecordList().length );
      for (int i=0; i < members.getRecordList().length; i++ )
      {
         member = (Person)members.getRecordList()[i];
         GroupMemberMap map = new GroupMemberMap( dbData, id, Person.RECORDTYPE_PERSON, member.getPersonId(), true );
         if ( member.getRecordType() == Person.RECORDTYPE_PERSON )
         {
            if (map.getPrimaryMember() > 0) break;
         }
      }
      member.deepPopulate();
      return( member ); // return primary or last member in list if no primary
   }

   public boolean isInGroup( int aGroupType, int aGroupNum )
   {
      GroupMemberMap aMap = new GroupMemberMap( dbData, aGroupNum, aGroupType, id, true );

      return( aMap.isRecordFound());
   }

   public String toCSVString( ContactViewBase viewDef1 )
   {
      StdCSVContactView viewDef = (StdCSVContactView)viewDef1;

      String csvString = super.toCSVString( viewDef );

      Person primaryPerson = getPrimaryPerson();
      primaryPerson.deepPopulate();

      if ( viewDef.showPrimaryPerson )
      {
         csvString += ", " + primaryPerson.toCSVString( viewDef.personView );
      }
      return(csvString );
   }

   public String toCSVHeaderString( ContactViewBase viewDef1, int ndx )
   {
      StdCSVContactView viewDef = (StdCSVContactView)viewDef1;

      String csvString = super.toCSVHeaderString( viewDef, ndx );

      if ( viewDef.showPrimaryPerson )
      {
         csvString += getPrimaryPerson().toCSVHeaderString( viewDef.personView, ndx );
      }
      return(csvString );
   }

   public void deleteRecord()
   {
      deleteRecord(false);
   }

   public void deleteRecord( boolean deleteMembers )
   {
      if ( deleteMembers )
      {
         people.deepPopulate();
         for ( int i = 0; i < people.getGroupMembers().getRecordList().length; i++ )
         {
            Person aMember = (Person) people.getGroupMembers().getRecordList()[i];
            aMember.deleteRecord();
         }
      }

      GroupMemberMapList memberMapList = new GroupMemberMapList( dbData, true, ObjectClassID.CONTACT, id );
      for ( int i = 0; i < memberMapList.getRecordList().length; i++ )
      {
         GroupMemberMap memberMap = (GroupMemberMap) memberMapList.getRecordList()[i];
         memberMap.removeRecord( "GROUPMEMBERMAP" );
      }
      HistoryList historyList = new HistoryList( dbData, ObjectClassID.CONTACT, id );
      for ( int i = 0; i < historyList.getRecordList().length; i++ )
      {
         History history = (History) historyList.getRecordList()[i];
         history.removeRecord( "HISTORY" );
      }
      people.removeRecord( "ENTITYGROUP" );
   }

   public  HistoryList getHistoryList()
   {
      if (historyList == null ) historyList = new HistoryList( dbData, ObjectClassID.CONTACT, id);
      return(historyList);
   }

   public boolean checkAbandon()
   {
      // only abandon prospective contacts....

      ProjectStatus pStatus = new ProjectStatus( dbData, getStatus() );
      if ( pStatus.getStatusClass() != 1030 ) return( false );  // not prospective class status

      try
      {
         // 01-18-2014 -- decision to no longer take doubles -- see if date is no longer available
         if ( getDateIsScheduled() )
         {
            updateStatus(122); // permanently abandon
            new History( dbData, "auto", ObjectClassID.CONTACT, id, History.TYPE_GENERALNOTE, "Force abandon based on date no longer available", "", "HISTORY" );
         }
         else // see if date has expired
         {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime( new java.util.Date() ); // now...

            // is recent create?
            calendar.add(Calendar.DAY_OF_MONTH, -60); // don't expire anything that's less than a couple of months since record was created
            java.util.Date createThreshhold = calendar.getTime();
            dbData.getLog().logEvent( "Too new to expire? " + createThreshhold + " " + getCreateDate() );
            if ( getCreateDate().after( createThreshhold )) return( false ); // don't abandon new contacts

            // is tracking date past (or within a month and a half)?
            calendar.setTime( new java.util.Date() ); // reset it to 'now'
            calendar.add(Calendar.DAY_OF_MONTH, 45); // set expire date to a month and a half from now
            java.util.Date expireDate = calendar.getTime();

            if ( getTrackingDate().before( expireDate ) ) // too late for this contact... abandon them
            {
               updateStatus(122); // permanently abandon
               new History( dbData, "auto", ObjectClassID.CONTACT, id, History.TYPE_GENERALNOTE, "Force abandon based on expiration", expireDate.toString(), "HISTORY" );
            }
         }
      }
      catch( Exception e)
      {
         new History( dbData, "auto", ObjectClassID.CONTACT, id, History.TYPE_GENERALNOTE, "Exception in Contact checkAbandon()", e.toString(), "HISTORY" );
      }
      return( false ); // don't abandon
   }

   public java.util.Date getTrackingDate()
   {
      setStatus();  // this determines the current primary project
      java.util.Date trackByDate = null;
      try
      {
         if ( getProjectCount() > 0 ) // if projects, inherit date from projects
         {
            trackByDate = trackingProject.getTrackByDate();
         }
         else // no projects, therefore no project dates.... let's assume createDate + 1 year
         {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime( getCreateDate() );
            calendar.add(Calendar.YEAR, 1); // create date + 1 year
            trackByDate = calendar.getTime();
            dbData.getLog().logEvent( "no projects... track by createDate + 1 year ");
         }
      }
      catch( Exception e)
      {
         new History( dbData, "auto", ObjectClassID.CONTACT, id, History.TYPE_GENERALNOTE, "Exception in Contact getTrackingDate()", e.toString(), "HISTORY" );
         e.printStackTrace( System.out );
      }
      return( trackByDate );
   }
}
