package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import jwm.gl2.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PersonList extends PersonDBRecordListBase
{
   private DBQuery dbQuery;

   public  String getQueryString() { return(queryString); }
   private String queryString;
   public  void   setQueryString( String aQueryString ) { queryString = aQueryString; }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param request
   */
   //---------------------------------------------------------------------------

   public PersonList( DBData aDbData, HttpServletRequest request )  // populate from Person search form
   {
       this( aDbData, request, "", -1, -1, 0, -1 );
       log.logEvent( "PersonList Constructor   1" );
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
   *  @param flag
   */
   //---------------------------------------------------------------------------

   public PersonList( DBData aDbData, HttpServletRequest request, boolean flag  )
   {
      super( aDbData );
      String[] groupMembers = request.getParameterValues( "listRight" );
      if ( groupMembers != null )
      {
         recordList = getListInstance(groupMembers.length);
         for ( int i = 0; i < groupMembers.length; i++ )
         {
            recordList[i] = new Person( aDbData, Integer.parseInt( groupMembers[i] ) );
         }
      }
      else
      {
         recordList = getListInstance(0);
      }
       log.logEvent( "PersonList Constructor   2" );
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
   *  @param qualifierCol
   *  @param qualifierValue
   *  @param ownerType
   *  @param recordType
   */
   //---------------------------------------------------------------------------

   public PersonList( DBData aDbData, HttpServletRequest request, String label, int qualifierCol, int qualifierValue, int ownerType, int recordType )  // populate from Person search form
   {
      super( aDbData );
      createQueryStatement( request, label, qualifierCol, qualifierValue, ownerType, recordType, Person.STATUS_ACTIVE );
      doQuery();
      log.logEvent( "Personlist constructor from search form" ) ;
       log.logEvent( "PersonList Constructor   3" );
   }

   public PersonList( DBData aDbData, HttpServletRequest request, String label, int qualifierCol, int qualifierValue, int ownerType, int recordType, boolean doQueryFlag )  // populate from Person search form
   {
      this( aDbData, request, label, qualifierCol, qualifierValue, ownerType, recordType, doQueryFlag, Person.STATUS_ACTIVE );
   }

   public PersonList( DBData aDbData, HttpServletRequest request, String label, int qualifierCol, int qualifierValue, int ownerType, int recordType, boolean doQueryFlag, int status )  // populate from Person search form
   {
      super( aDbData );
      createQueryStatement( request, label, qualifierCol, qualifierValue, ownerType, recordType, status );
      if ( doQueryFlag ) doQuery();
      log.logEvent( "Personlist constructor from search form" ) ;
       log.logEvent( "PersonList Constructor   4" );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  generated===========generated=========generated==========generated
   *  generated===========generated=========generated==========generated
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param aId
   */
   //---------------------------------------------------------------------------

   public PersonList( DBData aDbData, boolean doQueryFlag, int aId  )
   {
      super( aDbData );
      queryString = "SELECT * FROM Person where personId = " + aId;

      if ( doQueryFlag )
      {
         doQuery();
         deepPopulate(false);
      }
       log.logEvent( "PersonList Constructor   5" );
   }

   public PersonList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "PERSON", "PERSONID = " + Integer.toString(aId) );
      deepPopulate(false);
       log.logEvent( "PersonList Constructor   6" );
   }

   public PersonList( DBData aDbData, int aPersonId, boolean flag, boolean doQueryFlag  ) // return list of business entity records for businesses this person is associated with
   {
      super( aDbData );
      EntityGroupList groupList = new EntityGroupList( dbData, EntityGroup.TYPE_BUSINESS, aPersonId, true );
      String idList = "-999";
      for ( int i = 0; i < groupList.getRecordList().length; i++ )
      {
         EntityGroup businessEG = (EntityGroup) groupList.getRecordList()[i];
         idList += ", " + businessEG.getGroupNum();
      }

      queryString = "SELECT * FROM Person where recordType = " + Person.RECORDTYPE_BUSINESS_ORG + " and OWNERID IN ( " + idList + " )";

      if ( doQueryFlag )
      {
         doQuery();
         deepPopulate(false);
      }
       log.logEvent( "PersonList Constructor   7" );
   }

   public PersonList( DBData aDbData, EntityGroupList groupList, boolean doQueryFlag ) // get primary member of each group in the grouplist
   {
      super( aDbData );

      Vector listV = new Vector();
      for ( int i = 0; i < groupList.getRecordList().length; i++ )
      {
         EntityGroup aGroup = (EntityGroup) groupList.getRecordList()[i];
         Person aPerson = new Person( dbData, aGroup.getGroupNum(), true );
         aPerson.deepPopulate();
         aPerson.setLastName("");
         aPerson.setMiddleName("");
         aPerson.setFirstName(aGroup.getName());
         listV.add( aPerson );
      }
      createRecordList( listV );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param groupType
   *  @param groupNum
   */
   //---------------------------------------------------------------------------

   public PersonList( DBData aDbData, String groupName, boolean signatureFlag, boolean signatureFlag2, boolean signatureFlag3, boolean signatureFlag4 )
   {
      super( aDbData );
      EntityGroup aGroup = new EntityGroup( aDbData, groupName );
      createQueryStatement( aGroup.getType(), aGroup.getGroupNum() , Person.STATUS_ACTIVE );
      doQuery();
   }


   public PersonList( DBData aDbData, int groupType, int groupNum )
   {
      super( aDbData );
      createQueryStatement( groupType, groupNum , Person.STATUS_ACTIVE );
      doQuery();
       log.logEvent( "PersonList Constructor   8" );
   }

   public PersonList( DBData aDbData, int groupType, int groupNum, boolean flag )
   {
      super( aDbData );
      createQueryStatement( groupType, groupNum );
      doQuery();
       log.logEvent( "PersonList Constructor   8a" );
   }

   public PersonList( DBData aDbData, int groupType, int groupNum, int siteDefEntityType, int limit )
   {
      super( aDbData );
      createQueryStatement( groupType, groupNum , Person.STATUS_ACTIVE, siteDefEntityType );
      doQuery(limit);
   }

   public PersonList( DBData aDbData, int groupType, int groupNum, int limit )
   {
      super( aDbData );
      createQueryStatement( groupType, groupNum , Person.STATUS_ACTIVE );
      doQuery(limit);
   }

   public PersonList( DBData aDbData, String groupName, boolean signatureFlag, boolean signatureFlag2, boolean signatureFlag3 )
   {
      super( aDbData );
      createQueryStatement( groupName , Person.STATUS_ACTIVE );
      doQuery();
       log.logEvent( "PersonList Constructor   9" );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param groupType
   *  @param groupNum
   *  @param recordType
   *  @param request
   */
   //---------------------------------------------------------------------------

   public PersonList( DBData aDbData, int groupType, int groupNum, int recordType, HttpServletRequest request )
   {
      super( aDbData );
      createQueryStatement(groupType, groupNum, recordType, request, Person.STATUS_ACTIVE );
      doQuery();
       log.logEvent( "PersonList Constructor  10" );
   }

   public PersonList( DBData aDbData, int groupType, int groupNum, int recordType, HttpServletRequest request, boolean doQueryFlag )
   {
      super( aDbData );
      createQueryStatement(groupType, groupNum, recordType, request, Person.STATUS_ACTIVE );
      if ( doQueryFlag ) doQuery();
       log.logEvent( "PersonList Constructor  11" );
   }

   // find persons/businesses that are in both of the specified groups (used for Austin/Videographers in WGBE)
   public PersonList( DBData aDbData, int groupType, int group1Num, int group2Num, int siteDefEntityType, int recordType, boolean doQueryFlag )
   {
      super( aDbData );
      createQueryStatement(groupType, group1Num, group2Num, siteDefEntityType, recordType, null);
      if ( doQueryFlag ) doQuery();
       log.logEvent( "PersonList Constructor  11a" );
   }

   public PersonList( DBData aDbData, int groupType, int group1Num, int group2Num, int siteDefEntityType, int recordType, boolean doQueryFlag, PersonList excludeList )
   {
      super( aDbData );
      createQueryStatement(groupType, group1Num, group2Num, siteDefEntityType, recordType, excludeList);
      if ( doQueryFlag ) doQuery();
       log.logEvent( "PersonList Constructor  11z" );
   }

   // find persons/businesses by name search that are in a specified group and match siteDefEntityType (used for vendor search in WGBE)
   public PersonList( DBData aDbData, String search, int groupType, int groupNum, int siteDefEntityType, int recordType, boolean doQueryFlag )
   {
      super( aDbData );
      createQueryStatement(search, groupType, groupNum, siteDefEntityType, recordType, Person.STATUS_ACTIVE );
      if ( doQueryFlag ) doQuery();
       log.logEvent( "PersonList Constructor  11b" );
   }

   public PersonList( DBData aDbData, String createDate, int recordType, boolean doQueryFlag )
   {
      super( aDbData );
      createQueryStatement(createDate, recordType, Person.STATUS_ACTIVE );
      if ( doQueryFlag ) doQuery();
       log.logEvent( "PersonList Constructor  12" );
   }

   public PersonList( DBData aDbData, String lastUpdate, int recordType, boolean signatureFlag, boolean doQueryFlag )
   {
      super( aDbData );
      createQueryStatement(lastUpdate, recordType, false, Person.STATUS_ACTIVE );
      if ( doQueryFlag ) doQuery();
       log.logEvent( "PersonList Constructor  13" );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param projectId
   *  @param dummyFlag
   */
   //---------------------------------------------------------------------------

   public PersonList( DBData aDbData, int projectId, boolean dummyFlag )
   {
      super( aDbData );
      queryString = "SELECT * FROM Person, Invoice WHERE Invoice.Project = " + projectId + " AND Invoice.ClientId = Person.PersonID AND Invoice.Status != " + Invoice.STATUS_DELETED;
      doQuery();
       log.logEvent( "PersonList Constructor  14" );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param recordType
   *  @param lastName
   */
   //---------------------------------------------------------------------------

   public PersonList( DBData aDbData, int recordType, String lastName)
   {
      super( aDbData );
      queryString = "SELECT * FROM Person WHERE STATUS = " + Person.STATUS_ACTIVE + " AND LASTNAME LIKE '%" + lastName + "%' AND RECORDTYPE = " + recordType;
      doQuery();
       log.logEvent( "PersonList Constructor  15" );
   }

   public PersonList( DBData aDbData, int recordType, boolean flag1, boolean flag2, boolean flag3 )
   {
      super( aDbData );
      queryString = "SELECT * FROM Person WHERE STATUS = " + Person.STATUS_ACTIVE + " AND RECORDTYPE = " + recordType;
      buildList( queryString, 10000 );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param aExcludeList
   */
   //---------------------------------------------------------------------------

   public PersonList( DBData aDbData, PersonList aExcludeList  )
   {
      this( aDbData, aExcludeList, Person.RECORDTYPE_PERSON );
       log.logEvent( "PersonList Constructor  16" );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param aExcludeList
   *  @param recordType
   */
   //---------------------------------------------------------------------------

   public PersonList( DBData aDbData, PersonList aExcludeList, int recordType  )
   {
      super( aDbData );
      queryString = " PERSON.STATUS = " + Person.STATUS_ACTIVE + " AND RECORDTYPE = " + recordType ;
      for ( int i = 0; i < aExcludeList.getRecordList().length; i++ )
      {
          Person aPerson = (Person) aExcludeList.getRecordList()[i];
          queryString += " AND PERSONID != " + aPerson.getPersonId();
      }
      buildList( "PERSON", queryString, "LASTNAME ASC");
       log.logEvent( "PersonList Constructor  17" );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  generated===========generated=========generated==========generated
   *  generated===========generated=========generated==========generated
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param criteriaString
   *  @param orderString
   */
   //---------------------------------------------------------------------------

   public PersonList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
       log.logEvent( "PersonList Constructor  18" );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param lastName
   */
   //---------------------------------------------------------------------------

   public PersonList( DBData aDbData, String lastName )
   {
      super( aDbData );
      queryString = "SELECT * FROM Person WHERE STATUS = " + Person.STATUS_ACTIVE + " AND LASTNAME LIKE '%" + lastName + "%'";
      doQuery();
       log.logEvent( "PersonList Constructor  19" );
   }

   public PersonList( DBData aDbData, String anEmailAddress, boolean signatureFlag, boolean signatureFlag2 )
   {
      super( aDbData );
      queryString = "SELECT * FROM PERSON,EMAIL WHERE ( PERSON.OWNERTYPE = 1 AND PERSON.PERSONID = EMAIL.OWNERID AND ( EMAIL.emailAddress = '"+anEmailAddress+"' ) ) AND STATUS = "+ Person.STATUS_ACTIVE;
      buildList( queryString, 1000);
      deepPopulate(false);
       log.logEvent( "PersonList Constructor  20" );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aDbData
   *  @param queryString
   *  @param savedQueryFlag
   */
   //---------------------------------------------------------------------------

   public PersonList( DBData aDbData, String queryString, boolean savedQueryFlag  )
   {
      super( aDbData );
      buildList( queryString, 1500);
      deepPopulate(false);
       log.logEvent( "PersonList Constructor  21" );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  generated===========generated=========generated==========generated
   *  generated===========generated=========generated==========generated
   *  @author Jerry Malcolm
   *  @return ...
   *  @param dbData
   */
   //---------------------------------------------------------------------------

   public PersonList( DBData dbData )
   {
      super( dbData );
       log.logEvent( "PersonList Constructor  22" );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param dbData
   *  @param sqlStatement
   *  @param maxRecords
   */
   //---------------------------------------------------------------------------

   public PersonList( DBData dbData, String sqlStatement, int maxRecords )
   {
      super( dbData );
      buildList( sqlStatement, maxRecords );
      deepPopulate(false);
       log.logEvent( "PersonList Constructor  23" );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param request
   *  @param label
   *  @param qualifierCol
   *  @param qualifierValue
   *  @param ownerType
   *  @param recordType
   */
   //---------------------------------------------------------------------------

   public void createQueryStatement(HttpServletRequest request, String label, int qualifierCol, int qualifierValue, int ownerType, int recordType , int status)
   {
      dbQuery = new DBQuery( DBQuery.AND );
      dbQuery.add( Person.getDBQuery( "PERSON", dbData, request, label, qualifierCol, qualifierValue, DBQuery.AND, ownerType, recordType ));

      boolean allStatus = false;
      String statusSubQueryString = "";

      String[] statusList = request.getParameterValues( "statuslist" );
      if (statusList != null )
      {
         // 10-31-06 --- add search criteria based on site specific entity type
         for ( int i = 0; i < statusList.length; i++ )
         {
            log.logEvent( "statuslist: " + statusList[i] );
            if (statusList[i].equals("-1")) allStatus=true;
            if ( !statusSubQueryString.equals( "" ) ) statusSubQueryString += " OR ";
            statusSubQueryString += " siteDefEntityType = " + statusList[i];
         }
         if (!allStatus) dbQuery.add( "PERSON", "("+statusSubQueryString+")", false );
         // end 10-31-06
      }
      finishQueryStatement(status);
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @param groupType
   *  @param groupNum
   */
   //---------------------------------------------------------------------------

   public void createQueryStatement( int groupType, int groupNum)
   {
      log.logEvent( "Personlist from group" );
      dbQuery = new DBQuery( DBQuery.AND );
      dbQuery.add( "GROUPMEMBERMAP", "GROUPNUM = " + groupNum );
      dbQuery.add( "PERSON", "GROUPMEMBERMAP.MEMBERID = PERSON.PERSONID", false);
      queryString = "SELECT * FROM " + dbQuery.getTableNameString() + " WHERE " + dbQuery.toString() ;
   }

   public void createQueryStatement( int groupType, int groupNum , int status)
   {
      log.logEvent( "Personlist from group" );
      dbQuery = new DBQuery( DBQuery.AND );
      dbQuery.add( "GROUPMEMBERMAP", "GROUPNUM = " + groupNum );
      dbQuery.add( "PERSON", "GROUPMEMBERMAP.MEMBERID = PERSON.PERSONID", false);
      finishQueryStatement(status);
   }

   public void createQueryStatement( int groupType, int groupNum , int status, int siteDefEntityType)
   {
      log.logEvent( "Personlist from group" );
      dbQuery = new DBQuery( DBQuery.AND );
      dbQuery.add( "GROUPMEMBERMAP", "GROUPNUM = " + groupNum );
      dbQuery.add( "PERSON", "SITEDEFENTITYTYPE = " + siteDefEntityType);
      dbQuery.add( "PERSON", "GROUPMEMBERMAP.MEMBERID = PERSON.PERSONID", false);
      finishQueryStatement(status);
   }


   public void createQueryStatement( String groupName , int status)
   {
      log.logEvent( "Personlist from group (by name)" );
      dbQuery = new DBQuery( DBQuery.AND );
      dbQuery.add( "ENTITYGROUP", "NAME LIKE '" + groupName + "'" );
      dbQuery.add( "GROUPMEMBERMAP", "GROUPNUM = ENTITYGROUP.GROUPNUM" );
      dbQuery.add( "PERSON", "GROUPMEMBERMAP.MEMBERID = PERSON.PERSONID", false);
      finishQueryStatement(status);
   }

   public void createQueryStatement( String createDate, int recordType , int status)
   {
      log.logEvent( "Personlist by create date:" + createDate );
      dbQuery = new DBQuery( DBQuery.AND );
      dbQuery.add( "PERSON", "RECORDTYPE = " + recordType );
      dbQuery.add( "PERSON", "CREATEDATE > '"+createDate+"'", false);
      finishQueryStatement(status);
   }

   public void createQueryStatement( String lastUpdate, int recordType, boolean signatureFlag , int status)
   {
      log.logEvent( "Personlist by last update:" + lastUpdate );
      dbQuery = new DBQuery( DBQuery.AND );
      dbQuery.add( "PERSON", "RECORDTYPE = " + recordType );
      dbQuery.add( "PERSON", "CREATEDATE > '"+lastUpdate+"'", false);
      finishQueryStatement(status);
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @param groupType
   *  @param groupNum
   *  @param recordType
   *  @param request
   */
   //---------------------------------------------------------------------------

   public void createQueryStatement( int groupType, int groupNum, int recordType, HttpServletRequest request , int status)
   {
      log.logEvent( "Personlist from group" );
      dbQuery = new DBQuery( DBQuery.AND );
      dbQuery.add( "GROUPMEMBERMAP", "GROUPNUM = " + groupNum );
      dbQuery.add( "PERSON", "RECORDTYPE = " + recordType );
      dbQuery.add( "PERSON", "GROUPMEMBERMAP.MEMBERID = PERSON.PERSONID", false);

      boolean allStatus = false;
      String statusSubQueryString = "";

      String[] statusList = request.getParameterValues( "statuslist" );
      if (statusList != null )
      {

         // 10-31-06 --- add search criteria based on site specific entity type
         for ( int i = 0; i < statusList.length; i++ )
         {
            log.logEvent( "statuslist: " + statusList[i] );
            if (statusList[i].equals("-1")) allStatus=true;
            if ( !statusSubQueryString.equals( "" ) ) statusSubQueryString += " OR ";
            statusSubQueryString += " siteDefEntityType = " + statusList[i];
         }
         if (!allStatus) dbQuery.add( "PERSON", "("+statusSubQueryString+")", false );
         // end 10-31-06
      }
      finishQueryStatement(status);
   }

   public void createQueryStatement( int groupType, int group1Num, int group2Num, int siteDefEntityType, int recordType, PersonList excludeList)
   {
      log.logEvent( "Personlist from group" );
      dbQuery = new DBQuery( DBQuery.AND );
      dbQuery.add( "GROUPMEMBERMAP", "gm1", "GROUPNUM = " + group1Num );
      dbQuery.add( "GROUPMEMBERMAP", "gm2", "GROUPNUM = " + group2Num );
      dbQuery.add( "PERSON", "SITEDEFENTITYTYPE = " + siteDefEntityType );
      dbQuery.add( "PERSON", "RECORDTYPE = " + recordType );
      dbQuery.add( "PERSON", "gm1.MEMBERID = PERSON.PERSONID", false);
      dbQuery.add( "PERSON", "gm2.MEMBERID = PERSON.PERSONID", false);
      if ( excludeList != null )
      {
         for ( int i=0; i<excludeList.getRecordList().length; i++ )
         {
            Person excludePerson = (Person) excludeList.getRecordList()[i];
            dbQuery.add( "PERSON", "PERSON.PERSONID != "+ excludePerson.getPersonId(), false);
         }
      }
      finishQueryStatement(Person.STATUS_ACTIVE);
   }

   public void createQueryStatement( String search, int groupType, int groupNum, int siteDefEntityType, int recordType, int status)
   {
      log.logEvent( "Vendor search" );
      dbQuery = new DBQuery( DBQuery.AND );
      dbQuery.add( "GROUPMEMBERMAP", "GROUPNUM = " + groupNum );
      dbQuery.add( "PERSON", "SITEDEFENTITYTYPE = " + siteDefEntityType );
      dbQuery.add( "PERSON", "RECORDTYPE = " + recordType );
      dbQuery.add( "PERSON", "GROUPMEMBERMAP.MEMBERID = PERSON.PERSONID", false);
      dbQuery.add( "ENTITYATTRIBUTE", "ENTITYATTRIBUTE.OWNERTYPE = " + EntityAttribute.OWNERTYPE_PERSON , false);
      dbQuery.add( "ENTITYATTRIBUTE", "ENTITYATTRIBUTE.OWNERID = PERSON.PERSONID" , false);
      dbQuery.add( "ENTITYATTRIBUTE", "ENTITYATTRIBUTE.ATTRIBUTEDATA LIKE '%" + search + "%'", false );

      finishQueryStatement(Person.STATUS_ACTIVE, "DISTINCT (PERSON.PERSONID)");

   }

   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   */
   //---------------------------------------------------------------------------

   public void doQuery()
   {
      doQuery( 0, 10000 );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @param limitStart
   *  @param limitCount
   */
   //---------------------------------------------------------------------------

   public void doQuery(int limitStart, int limitCount )
   {
      String thisQuery = queryString + " Order by lastname, firstname limit " + limitStart + ", " + limitCount;
      buildList( thisQuery, 10000 );
      deepPopulate(false);
   }

   public void doQuery(int count )
   {
      String thisQuery = queryString + " Order by rand() limit " + count;
      buildList( thisQuery, 10000 );
      deepPopulate(false);
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   */
   //---------------------------------------------------------------------------

   public void finishQueryStatement( int status )
   {
      finishQueryStatement( status, "*" );
   }


   public void finishQueryStatement( int status, String selection )
   {
      if ( !dbQuery.isNull() )
      {
         queryString = "SELECT " + selection + " FROM " + dbQuery.getTableNameString() + " WHERE " + dbQuery.toString() + " AND PERSON.STATUS = " + status;
      }
      else
      {
         queryString = "SELECT " + selection + " FROM Person WHERE STATUS = " + Person.STATUS_ACTIVE;
      }
   }

   public int getTotalRecordCount()
   {
      return( getTotalRecordCount( queryString ));
   }

   public void removeRecord( int personId )
   {
      for ( int i = 0; i < recordList.length; i++ )
      {
          Person aPerson = (Person) recordList[i];
          if (aPerson.getPersonId() == personId )
          {
             removeRecord( aPerson );
             break;
          }
      }
   }

}
