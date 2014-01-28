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

public class Person extends PersonDBRecordBase
{
   public static final int FEMALE = 1;

   public static final int MALE = 0;

   public static final int OWNERTYPE_CLIENT = 1;

   public static final int OWNERTYPE_COUPLE = 0;

   public static final int OWNERTYPE_GROUP  = 2;

   public static final int RECORDTYPE_GROUP = 2;       // added 9/15/07 -- absolutely incorrect to have this here.  but recordtype is used to specify contents of group.  this is used to specify that a group contains other groups

   public static final int RECORDTYPE_BUSINESS_ORG = 1;

   public static final int RECORDTYPE_PERSON = 0;

   public static final int RECORDTYPE_CUSTOMER = 2;

   public static final int STATUS_ACTIVE = 1;

   public static final int STATUS_INACTIVE = 3;

   public static final int STATUS_REMOVED = 2;

   public static final int SEX_M = 1;
   public static final int SEX_F = 2;

   public static String[] RECORDTYPE_TEXT = {"Person", "Business/Organization", "Group/Customer" };
   public static String[] STATUS_TEXT     = {"--", "Active", "Inactive", "Removed" };
   public static String[] SEX_TEXT     = {"--", "M", "F"};
   public static String[] OWNERTYPE_TEXT     = {"Couple", "Client", "Group"};

   protected AddressList addresses;
   public  AddressList getAddresses()      { return(addresses); }
   public  void        setAddresses( AddressList aAddresses ) { addresses = aAddresses; }

   protected EmailList   emailAddresses;
   public  EmailList   getEmailAddresses()
   {
      if ( emailAddresses == null )
      {
         emailAddresses = new EmailList( dbData, personId );
         emailAddresses.deepPopulate();
      }
      return(emailAddresses);
   }
   public  void        setEmailAddresses( EmailList aEmailAddresses ) { emailAddresses = aEmailAddresses; }

   public  EntityGroupList getGroupSet(int i)             { return(groupSets[i]); }
   public  void            setGroupSet( EntityGroupList aGroups, int i ) { groupSets[i] = aGroups; }

   protected EntityGroupList[] groupSets;

   protected HistoryList historyList;
   public  void        setHistoryList( HistoryList aHistoryList ) { historyList = aHistoryList; }

   public  int getMaxGroupType() { return(maxGroupType); }
   protected int maxGroupType = 1;  // arbitrary... can be increased, but there is a query for each group set (1 groupSet / type)
   public  void setMaxGroupType( int aMaxGroupType ) { maxGroupType = aMaxGroupType; }

   public  PhoneList   getPhoneNumbers()   { return(phoneNumbers); }
   protected PhoneList   phoneNumbers;
   public  void        setPhoneNumbers( PhoneList aPhoneNumbers ) { phoneNumbers = aPhoneNumbers; }

   public  boolean getUpdateGroups() { return(updateGroups); }
   public  void    setUpdateGroups( boolean aUpdateGroups ) { updateGroups = aUpdateGroups; }
   protected boolean updateGroups = true;

   protected EntityGroupList assoFamilies;
   public  void            setAssoFamilies( EntityGroupList aAssoFamilies ) { assoFamilies = aAssoFamilies; }
   public  EntityGroupList getAssoFamilies()       { return(assoFamilies); }

   protected EntityCustomTextList customText;
   public  void                 setCustomText( EntityCustomTextList aCustomText ) { customText = aCustomText; }
   public  EntityCustomTextList getCustomText()              { return(customText); }

   protected boolean primaryMember = false;
   public  void    setPrimaryMember( boolean aPrimaryMember ) { primaryMember = aPrimaryMember; }
   public  boolean getPrimaryMember() { return(primaryMember); }

   protected String role = "";
   public  void     setRole( String aRole ) { role = aRole; }
   public  String   getRole()        { return(role); }



   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param hashTable
   *  @param label
   */
   //---------------------------------------------------------------------------

   public Person( DBData aDbData, Hashtable hashTable, String label )
   {
     this( aDbData, -1 );
     deepPopulate();
     populateObject( hashTable, label );
     deepPopulate( hashTable, label );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param request
   *  @param label
   */
   //---------------------------------------------------------------------------

   public Person( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param request
   *  @param label
   *  @param aId
   */
   //---------------------------------------------------------------------------

   public Person( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param aId
   */
   //---------------------------------------------------------------------------

   public Person( DBData aDbData, int aId )
   {
      super( aDbData);
      if ( aId != -1 )
      {
         populateObject( "PERSON", "PERSONID", aId );
      }
//    log.logEvent( log.TRACE, "PERSON constructor from id: " + aId );
   }



   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param aId
   */
   //---------------------------------------------------------------------------

   public Person( DBData aDbData, int aOwnerType, int aOwnerId )
   {
      super( aDbData);
      populateObject( "PERSON", "PERSON.OWNERTYPE = " + aOwnerType + " AND PERSON.OWNERID = " + aOwnerId, "" );
   }

   public Person( DBData aDbData, int groupNum, boolean signatureFlag )
   {
      super( aDbData);
      populateObject( "PERSON,GROUPMEMBERMAP", "PERSON.PERSONID = GROUPMEMBERMAP.MEMBERID"
                     +" AND GROUPMEMBERMAP.GROUPNUM = "+groupNum
                     +" AND GROUPMEMBERMAP.PRIMARYMEMBER > 0"
                     +" AND GROUPMEMBERMAP.MEMBERTYPE = " + Person.RECORDTYPE_PERSON,
                     "" );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param results
   */
   //---------------------------------------------------------------------------

   public Person( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param anEmailAddress
   */
   //---------------------------------------------------------------------------

   public Person( DBData aDbData, String anEmailAddress )
   {
      super( aDbData );
      populateObject( "PERSON, EMAIL", "( ( PERSON.OWNERTYPE = 1 AND PERSON.PERSONID = EMAIL.OWNERID AND ( EMAIL.emailAddress = '"+anEmailAddress+"' ) ) ) AND STATUS = 1", "" );
      log.logEvent( log.TRACE, "PERSON constructor from emailAddress: " + anEmailAddress );
   }

   public Person( DBData aDbData, String aLastName, String aFirstName, String anAddressLine1 )
   {
      super( aDbData );
      deepPopulate();
      String queryString = "LASTNAME = "
                         + prepareStringField( aLastName )
                         + " AND FIRSTNAME = "
                         + prepareStringField( aFirstName)
                         + " AND PERSON.PERSONID = ADDRESS.OWNERID"
                         + " AND ADDRESS.ADDRESSLINE1 = "
                         + prepareStringField( anAddressLine1 );

      populateObject( "PERSON,ADDRESS", queryString, "" );
      log.logEvent( log.TRACE, "PERSON constructor from first/last names and addressline1: " + aFirstName + " " + aLastName + " -- " + anAddressLine1);
   }

   public Person( DBData aDbData, String aLastName, String aFirstName )
   {
      super( aDbData );
      deepPopulate();
      String queryString = "LASTNAME = "
                         + prepareStringField( aLastName )
                         + " AND FIRSTNAME = "
                         + prepareStringField( aFirstName);

      populateObject( "PERSON", queryString, "" );
      log.logEvent( log.TRACE, "PERSON constructor from first/last names: " + aFirstName + " " + aLastName );
   }

   public Person( DBData aDbData, String aLastName, String aFirstName, boolean fuzzy )
   {
      super( aDbData );
      deepPopulate();
      String queryString = "LASTNAME LIKE "
                         + prepareStringField( "%"+aLastName+"%" )
                         + " AND FIRSTNAME LIKE "
                         + prepareStringField( "%"+aFirstName+"%")
                         + " AND STATUS = "
                         + Person.STATUS_ACTIVE;

      populateObject( "PERSON", queryString, "" );
      log.logEvent( log.TRACE, "PERSON constructor from first/last names (fuzzy search): " + aFirstName + " " + aLastName );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param dbData
   */
   //---------------------------------------------------------------------------

   public Person( DBData dbData )
   {
      super( dbData );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   */
   //---------------------------------------------------------------------------

   public Address addAddress()
   {
      if ( addresses == null ) addresses = new AddressList( dbData );
      return( (Address) addresses.addRecord() );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   */
   //---------------------------------------------------------------------------

   public Email addEmail()
   {
      if ( emailAddresses == null ) emailAddresses = new EmailList( dbData );
      return( (Email) emailAddresses.addRecord() );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   */
   //---------------------------------------------------------------------------

   public Phone addPhone()
   {
      if ( phoneNumbers == null ) phoneNumbers = new PhoneList( dbData );
      return( (Phone) phoneNumbers.addRecord() );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param tableName
   */
   //---------------------------------------------------------------------------

   public boolean createOrUpdateRecord( String tableName )
   {
      lastUpdate = new java.sql.Date( new java.util.Date().getTime() );
      super.createOrUpdateRecord( tableName );

      if ( addresses != null )
      {
         for ( int i = 0; i<addresses.getRecordList().length; i++ )
         {
            ((Address)addresses.getRecordList()[i]).setOwnerId( personId );
         }
         addresses.createOrUpdateRecords( "ADDRESS" );
      }

      if ( phoneNumbers != null )
      {
         for ( int i = 0; i<phoneNumbers.getRecordList().length; i++ )
         {
            ((Phone)phoneNumbers.getRecordList()[i]).setOwnerId( personId );
         }
         phoneNumbers.createOrUpdateRecords("PHONE");
      }

      if ( emailAddresses != null )
      {
         for ( int i = 0; i<emailAddresses.getRecordList().length; i++ )
         {
            ((Email)emailAddresses.getRecordList()[i]).setOwnerId( personId );
         }
         emailAddresses.createOrUpdateRecords("EMAIL");
      }

      doUpdateGroups();

      return(true);
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param tableName
   */
   //---------------------------------------------------------------------------

   public boolean createRecord( String tableName )
   {
      createDate = new java.sql.Date( new java.util.Date().getTime() );
      if (status == 0) status = STATUS_ACTIVE;
      return( super.createRecord( tableName ) );
   }


   //===========================================================================
   //===========================================================================



   public void populateAddresses()
   {
      addresses = new AddressList( dbData, personId );
   }

   public void populateEmailAddresses()
   {
      emailAddresses = new EmailList( dbData, personId );
   }

   public void populatePhoneNumbers()
   {
      phoneNumbers = new PhoneList( dbData, personId );
   }

   public void populateHistoryList()
   {
      historyList = new HistoryList( dbData, History.OWNERTYPE_PERSON, personId );
   }

   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @param inclGroups
   */
   //---------------------------------------------------------------------------

   public void deepPopulate( boolean inclGroups )
   {
      log.logEvent( "Person.deepPopulate from db -- addresses" );
      populateAddresses();
      log.logEvent( "Person.deepPopulate from db -- email" );
      populateEmailAddresses();
      emailAddresses.deepPopulate();
      log.logEvent( "Person.deepPopulate from db -- phone" );
      populatePhoneNumbers();
      populateHistoryList();
//    log.logEvent( toString() );

      if ( inclGroups )
      {
         try
         {
               groupSets = new EntityGroupList[ maxGroupType ];
               for ( int i = 0; i < maxGroupType; i++ )
               {
                  groupSets[i] = new EntityGroupList( dbData, i, recordType, personId );
               }
         }
         catch (Exception e)
         {
         }
      }
      log.logEvent( "Person.deepPopulate from db -- families" );
      assoFamilies = new EntityGroupList( dbData, EntityGroup.TYPE_FAMILY,  personId, true ); // all families this person is a member of
      customText = new EntityCustomTextList( dbData );

   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @param hashTable
   *  @param label
   */
   //---------------------------------------------------------------------------

   public void deepPopulate( Hashtable hashTable, String label )
   {
      log.logEvent( "Person.deepPopulate from hashTable -- addresses " + addresses + " " + hashTable );

      if ( addresses == null ) addresses = new AddressList( dbData );
      addresses.populateObjects( hashTable, label+"_%", Address.ADDRESSID, "addressType" ); // will use matchOrAdd based on last 2 parms to identify correct instance to update

      log.logEvent( "Person.deepPopulate from hashTable -- email" );
      emailAddresses.populateObjects( hashTable, label+"_%", Email.EMAILID, "emailAddressType" );
      if ( emailAddresses == null ) emailAddresses = new EmailList( dbData );
      emailAddresses.deepPopulate();

      log.logEvent( "Person.deepPopulate from hashTable -- phone" );
      phoneNumbers.populateObjects( hashTable, label+"_%", Phone.PHONEID, "phoneNumberType" );
      if ( phoneNumbers == null ) phoneNumbers = new PhoneList( dbData );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @param request
   *  @param label
   */
   //---------------------------------------------------------------------------

   public void deepPopulate( HttpServletRequest request, String label )
   {
      log.logEvent( "Person.deepPopulate from httprequest -- addresses" );
      addresses.populateObjects( request, label+"_%", Address.ADDRESSTYPE, "addressType" ); // will use matchOrAdd based on last 2 parms to identify correct instance to update
      log.logEvent( "Person.deepPopulate from httprequest -- email" );
      emailAddresses.populateObjects( request, label+"_%", Email.EMAILADDRESSTYPE, "emailAddressType" );
      emailAddresses.deepPopulate();
      log.logEvent( "Person.deepPopulate from httprequest -- phone" );
      phoneNumbers.populateObjects( request, label+"_%", Phone.PHONENUMBERTYPE, "phoneNumberType" );

      deepPopulateGroups( request, label );

      log.logEvent( toString() );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   */
   //---------------------------------------------------------------------------

   public void deepPopulate()
   {
      deepPopulate( true );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @param request
   *  @param label
   */
   //---------------------------------------------------------------------------

   public void deepPopulateGroups( HttpServletRequest request, String label )
   {
      if ( request.getParameter( "groupincl" ) != null )   // if form omitted displaying groups, don't process here or all the group membership will be erased
      {
         groupSets = new EntityGroupList[ maxGroupType ];
         for ( int i = 0; i < maxGroupType; i++ )
         {
            groupSets[i] = new EntityGroupList( dbData, i, request );
         }
      }
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   */
   //---------------------------------------------------------------------------

   public void doUpdateGroups()
   {
      if (( updateGroups ) && (groupSets != null ))
      {
         for( int i = 0; i<maxGroupType; i++ )     // groupsets needs work when more than one group... not finished... 9/1/05
         {
//          if ( i == EntityGroup.TYPE_COUPLE ) GroupMemberMapList.setMappings( dbData, groupSets[i], i, personId, "GROUPMEMBERMAP"); // don't mess with couple groups...
// changed 9/11/06
            if ( i == EntityGroup.TYPE_GENERAL) GroupMemberMapList.setMappings( dbData, groupSets[i], i, Person.RECORDTYPE_PERSON, personId, "GROUPMEMBERMAP");
         }
      }
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param type
   */
   //---------------------------------------------------------------------------

   public Address getAddress( int type )
   {
      return( (Address) addresses.matchOrAddRecord( Address.ADDRESSTYPE, type ));
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   */
   //---------------------------------------------------------------------------

   public Address getAddress()
   {
//    change 11-20-06
//    return( (Address) addresses.getOrAddRecord( 0 ));
      return( getAddress(0));
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param tableName
   *  @param aDbData
   *  @param request
   *  @param label
   *  @param qualifierCol
   *  @param qualifierValue
   *  @param logic
   *  @param ownerType
   *  @param aRecordType
   */
   //---------------------------------------------------------------------------

   public static DBQuery getDBQuery( String tableName, DBData aDbData, HttpServletRequest request, String label, int qualifierCol, int qualifierValue, int logic, int ownerType, int aRecordType )
   {
      DBQuery dBQuery = PersonDBRecordBase.getDBQuery( tableName, aDbData, request, label, logic );  // need to do the qual stuff after sub-objects

      if (ownerType != -1 ) dBQuery.add( "PERSON", "OWNERTYPE" + " = " + Integer.toString( ownerType ) );
      if (aRecordType != -1 ) dBQuery.add( "PERSON", "RECORDTYPE" + " = " + Integer.toString( aRecordType ) );
      dBQuery.add( Address.getDBQuery( "ADDRESS", aDbData, request, label+"_%", logic ));
      dBQuery.add( Phone.getDBQuery( "PHONE", aDbData, request, label+"_%", logic ));
      dBQuery.add( Email.getDBQuery( "EMAIL", aDbData, request, label+"_%", logic ));

      if ( dBQuery.usesTable( "ADDRESS" ) ) dBQuery.add( "PERSON", "PERSONID = ADDRESS.OWNERID" );
      if ( dBQuery.usesTable( "PHONE" ) ) dBQuery.add( "PERSON", "PERSONID = PHONE.OWNERID" );
      if ( dBQuery.usesTable( "EMAIL" ) ) dBQuery.add( "PERSON", "PERSONID = EMAIL.OWNERID" );

      if ( !dBQuery.isNull() )
      {
         if ( qualifierValue != -1 )
         {
            dBQuery.add( tableName, COLNAME[ qualifierCol ] + " = " + Integer.toString( qualifierValue ) );
         }
      }
      return( dBQuery );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param type
   */
   //---------------------------------------------------------------------------

   public Email getEmail( int type )
   {
      return( (Email) emailAddresses.matchOrAddRecord( Email.EMAILADDRESSTYPE, type ));
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   */
   //---------------------------------------------------------------------------

   public Email getEmail()
   {
      return( (Email) getEmail(0));
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   */
   //---------------------------------------------------------------------------

   public  HistoryList getHistoryList()
   {
     // roll up history from child email objects into temp list to return (probably need to add history to phone and address as well... )
      HistoryList compositeHistory = new HistoryList( dbData, -1 );

      compositeHistory.addRecords( historyList );

      for ( int i = 0; i<emailAddresses.getRecordList().length; i++ )
      {
          compositeHistory.addRecords( ((Email)emailAddresses.getRecordList()[i]).getHistoryList() );
      }
      return(compositeHistory);
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param type
   */
   //---------------------------------------------------------------------------

   public Phone getPhone( int type )
   {
//    log.logEvent( "Person.getPhone( " + type + ")" );
      return( (Phone) phoneNumbers.matchOrAddRecord( Phone.PHONENUMBERTYPE, type ));
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   */
   //---------------------------------------------------------------------------

   public Phone getPhone()
   {
//    change 11-20-06
//    return( (Phone) phoneNumbers.getOrAddRecord( 0 ));
      return( getPhone(0));
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aGroupType
   *  @param aGroupNum
   */
   //---------------------------------------------------------------------------

   public boolean isInGroup( int aGroupType, int aGroupNum )
   {
      GroupMemberMap aMap = new GroupMemberMap( dbData, aGroupNum, aGroupType, personId, true );
      return( aMap.isRecordFound());
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param prefix
   */
   //---------------------------------------------------------------------------

   public String toString( String prefix )
   {
      String retString = super.toString( prefix );
      retString += addresses.toString( prefix + "|  " );
      retString += phoneNumbers.toString( prefix + "|  " );
      retString += emailAddresses.toString( prefix + "|  " );
      return( retString );
   }

   public String getRoleForGroup( int aGroupNum )
   {
      GroupMemberMap aMap = new GroupMemberMap( dbData, aGroupNum, Person.RECORDTYPE_PERSON, personId, true );
      return( aMap.getMemberRoleText() );
   }

   public boolean setRoleForGroup( int aGroupNum, String aMemberRoleText )
   {
      GroupMemberMap aMap = new GroupMemberMap( dbData, aGroupNum, Person.RECORDTYPE_PERSON, personId, true );
      aMap.setMemberRoleText( aMemberRoleText );
      return( aMap.createOrUpdateRecord( "GROUPMEMBERMAP" ));
   }


   public String toCSVString( PersonViewBase viewDef1 )
   {
      StdCSVPersonView viewDef = (StdCSVPersonView)viewDef1;

      System.out.println( "Person.toCSVString() - " + lastName );

      String csvString = super.toCSVString( viewDef );

      for ( int jj = 0; jj < customText.getInstanceCount(recordType, EntityCustomText.OBJECTTYPE_ADDRESS); jj++ )
      {
         csvString += ", " + getAddress(jj).toCSVString( viewDef.addressView );
      }

      for ( int i = 0; i<phoneNumbers.getRecordList().length; i++ )
      {
         csvString += ", " + ((Phone)phoneNumbers.getRecordList()[i]).toCSVString( viewDef.phoneView );
      }

      for ( int i = 0; i<emailAddresses.getRecordList().length; i++ )
      {
         csvString += ", " + ((Email)emailAddresses.getRecordList()[i]).toCSVString( viewDef.emailView );
      }

      log.logEvent( "adding families to CSV..." + assoFamilies.getRecordList().length );
      for ( int i = 0; i < 3; i++ )
      {
          EntityGroup familyEG = new EntityGroup( dbData );
          if ( i < assoFamilies.getRecordList().length )
          {
             familyEG = (EntityGroup) assoFamilies.getRecordList()[i];
          }
         csvString += ", " + CSVCell(familyEG.getName());
      }
      return(csvString );
   }

   public String toCSVHeaderString( PersonViewBase viewDef1, int ndx )
   {
      StdCSVPersonView viewDef = (StdCSVPersonView)viewDef1;

      String csvString = super.toCSVHeaderString( viewDef, ndx );

      for ( int jj = 0; jj < customText.getInstanceCount(recordType, EntityCustomText.OBJECTTYPE_ADDRESS); jj++ )
      {
         csvString += ", " + getAddress(jj).toCSVHeaderString( viewDef.addressView, jj);
      }

      for ( int i = 0; i<phoneNumbers.getRecordList().length; i++ )
      {
         csvString += ", " + ((Phone)phoneNumbers.getRecordList()[i]).toCSVHeaderString( viewDef.phoneView, i );
      }

      for ( int i = 0; i<emailAddresses.getRecordList().length; i++ )
      {
         csvString += ", " + ((Email)emailAddresses.getRecordList()[i]).toCSVHeaderString( viewDef.emailView, i );
      }
      for ( int i = 0; i < 3; i++ )
      {
         csvString += ", " + "Family-"+i;
      }
      return(csvString );
   }

   public String getName()
   {
      return( firstName + " " + lastName );
   }


   public String personalize( String text )
   {
      text = text.replaceAll("%%firstName", firstName);
      text = text.replaceAll("%%lastName", lastName);
      text = text.replaceAll("%%to", firstName);
      return( text );
   }


   public void deleteRecord()
   {
      dbData.getLog().logEvent( "----- locating all groupmembermap records for this person" );
      GroupMemberMapList memberMapList = new GroupMemberMapList( dbData, true, recordType, personId );
      for ( int i = 0; i < memberMapList.getRecordList().length; i++ )
      {
         GroupMemberMap memberMap = (GroupMemberMap) memberMapList.getRecordList()[i];
         memberMap.removeRecord( "GROUPMEMBERMAP" );
      }
      HistoryList historyList = new HistoryList( dbData, History.OWNERTYPE_PERSON, personId );
      for ( int i = 0; i < historyList.getRecordList().length; i++ )
      {
         History history = (History) historyList.getRecordList()[i];
         history.removeRecord( "HISTORY" );
      }
      removeRecord( "PERSON" );
   }

}
