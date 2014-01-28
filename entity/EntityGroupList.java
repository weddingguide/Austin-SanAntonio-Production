package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.gl2.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EntityGroupList extends EntityGroupDBRecordListBase
{
   public static final int ACCEPTPERSONMEMBERSFLAG = 1;
   public static final int ACCEPTBUSINESSMEMBERSFLAG = 2;


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityGroupList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityGroupList( DBData aDbData, int aType  )
   {
      super( aDbData, "TYPE = " + Integer.toString(aType), "NAME ASC"  );
   }

   public EntityGroupList( DBData aDbData, int aType, int aCategory, String signatureFlag1)
   {
      super( aDbData, "TYPE = " + Integer.toString(aType) + " AND CATEGORY = " + Integer.toString(aCategory), "NAME ASC"  );
   }

   public EntityGroupList( DBData aDbData, int aType, int aStatus, String signatureFlag1, boolean signatureFlag2, int maxCount)
   {
      super( aDbData );
      String queryString = "SELECT * FROM ENTITYGROUP WHERE TYPE = " + Integer.toString(aType) + " AND STATUS = " + Integer.toString(aStatus) + " ORDER BY NAME ASC LIMIT 0,"+maxCount ;
      buildList( queryString, maxCount );
   }

   public EntityGroupList( DBData aDbData, int aType, String signatureFlag1, String signatureFlag2, int maxCount)
   {
      // contacts (groups) that have an "OpenWorkItems" attribute = true
      super( aDbData );
      String queryString = "SELECT * FROM ENTITYGROUP, ENTITYATTRIBUTE WHERE "
                                   +" ENTITYGROUP.TYPE = " + Integer.toString(aType)
                                   +" AND ENTITYATTRIBUTE.OWNERTYPE = ENTITYGROUP.TYPE"
                                   +" AND ENTITYATTRIBUTE.OWNERID   = ENTITYGROUP.GROUPNUM"
                                   +" AND ATTRIBUTEDEFID   = 26"
                                   +" AND ATTRIBUTEDATA    = '1'"

      + " ORDER BY NAME ASC LIMIT 0,"+maxCount ;
      buildList( queryString, maxCount );
   }

   public EntityGroupList( DBData aDbData, int aType, int[] aStatusArray, int maxCount)
   {
      super( aDbData );
      String queryString = "SELECT * FROM ENTITYGROUP WHERE TYPE = " + Integer.toString(aType);
      queryString += " AND (";
      for ( int i = 0; i < aStatusArray.length; i++ )
      {
         if (i > 0) queryString += " OR ";
         queryString += "STATUS = " + aStatusArray[i];
      }
      queryString += ")";
      queryString += " ORDER BY NAME ASC LIMIT 0,"+maxCount ;
      buildList( queryString, maxCount );
   }

   public EntityGroupList( DBData aDbData, int aType, int[] omitStatusArray, int attributeDefId, int attributeDefSubId, String attributeData, int maxCount)
   {
      super( aDbData );

      EntityAttributeList attributeList = new EntityAttributeList( dbData, attributeDefId, attributeDefSubId, attributeData, true );
      String matchingIds = "";
      for ( int i = 0; i < attributeList.getRecordList().length; i++ )
      {
         EntityAttribute attr = (EntityAttribute) attributeList.getRecordList()[i];
         if ( !matchingIds.equals("") ) matchingIds += ", ";
         matchingIds += attr.getOwnerId();
      }

      String queryString = "SELECT * FROM ENTITYGROUP WHERE TYPE = " + Integer.toString(aType);
      queryString += " AND GROUPNUM IN (" + matchingIds + ")";
      queryString += " AND (";
      for ( int i = 0; i < omitStatusArray.length; i++ )
      {
         if (i > 0) queryString += " AND ";
         queryString += "STATUS != " + omitStatusArray[i];
      }
      queryString += ")";
      queryString += " ORDER BY NAME ASC LIMIT 0,"+maxCount ;
      buildList( queryString, maxCount );
   }

   public EntityGroupList( DBData aDbData, int aType, String aName  ) // search by group name
   {
      super( aDbData, "TYPE = " + Integer.toString(aType)
             + " AND ENTITYGROUP.STATUS != " + EntityGroup.STATUS_DELETED
             + " AND NAME LIKE "+prepareStringField("%"+aName+"%"), "NAME ASC"  );
   }

   public EntityGroupList( DBData aDbData, int aType, int groupId, int signatureFlag, boolean signatureFlag2, boolean signatureFlag3  ) // get single group by id
   {
      super( aDbData, "TYPE = " + aType
                    + " AND GROUPNUM = " + groupId, "" );
   }

   public EntityGroupList( DBData aDbData, String aName, boolean signatureFlag1, boolean signatureFlag2, boolean signatureFlag3 ) // find contact groups from EGGroups
   {
      super( aDbData );
      String queryString = "select * from entitygroup, groupmembermap contactmap, groupmembermap businessEGmap where"
                        +  " entitygroup.type = 8"
                        +  " and entitygroup.groupnum = contactmap.groupnum"
                        +  " and contactmap.memberid = businessEGmap.memberId"
                        +  " and businessEGmap.groupnum in ( -999";

      EntityGroupList matchingEGs = new EntityGroupList( dbData, 4, aName, true );
      for ( int i = 0; i < matchingEGs.getRecordList().length; i++ )
      {
         EntityGroup egGroup = (EntityGroup) matchingEGs.getRecordList()[i];
         queryString += ", ";
         queryString += iString( egGroup.getGroupNum() );
      }
      queryString += ");";
      buildList( queryString,999 );
   }


   public EntityGroupList( DBData aDbData, int aType, boolean inclDeleted, String aName, boolean signaturFlag  ) // search by group name, option for including 'deleted' status group
   {
      super( aDbData );


      String queryString = "SELECT * FROM ENTITYGROUP, PROJECTSTATUS WHERE ";
      queryString +=       "ENTITYGROUP.TYPE = " + aType;
      queryString +=       " AND ( ENTITYGROUP.STATUS = PROJECTSTATUS.ID" ;
      if (!inclDeleted) queryString +=       " AND PROJECTSTATUS.STATUSCLASS != 1010";
      queryString +=       "     )";

      queryString +=       " AND (";
      queryString +=       "        (ENTITYGROUP.NAME LIKE "+prepareStringField("%"+aName+"%") +")";
      queryString +=       "         OR ";
      queryString +=       "        (ENTITYGROUP.GROUPNUM IN (-999";

      // next get contacts that have businessEGs with poeple matching the name
      EntityGroupList contactGroupsFromEGGroups = new EntityGroupList( dbData, aName, true, true, true );
      dbData.getLog().logEvent( "return from calling to get matching EG contact groups");
      for ( int i = 0; i < contactGroupsFromEGGroups .getRecordList().length; i++ )
      {
         EntityGroup cGroup = (EntityGroup) contactGroupsFromEGGroups.getRecordList()[i];
         queryString += ", ";
         queryString += iString( cGroup.getGroupNum() );
      }
      queryString +=      "                                  )";
      queryString +=      "         )";
      queryString +=       "         OR ";
      queryString +=       "        (ENTITYGROUP.GROUPNUM IN (-999";
      EntityGroupList contactGroups = new EntityGroupList( dbData, 8, aName, true );
      for ( int i = 0; i < contactGroups.getRecordList().length; i++ )
      {
         EntityGroup cGroup = (EntityGroup) contactGroups.getRecordList()[i];
         queryString += ", ";
         queryString += iString( cGroup.getGroupNum() );
      }
      queryString +=      "                                  )";
      queryString +=      "         )";
      queryString +=      "      )";

      queryString +=       " ORDER BY LASTUPDATE DESC;";
      dbData.getLog().logEvent( "final queryString " + queryString);
      buildList( queryString,999 );
   }

   // date range for events owned by projects that are owned by contacts

   public EntityGroupList( DBData aDbData, int aType, boolean inclDeleted, java.util.Date bgnDate, java.util.Date endDate  )
   {
      super( aDbData );
      buildFromDateRange( aType, inclDeleted, bgnDate, endDate );
   }

   public EntityGroupList( DBData aDbData, int aType, int[] statusClassArray, java.util.Date bgnDate, java.util.Date endDate  )
   {
      super( aDbData );
      buildFromDateRange( aType, statusClassArray, bgnDate, endDate );
   }

   public EntityGroupList( DBData aDbData, int aType, int aStatus, java.util.Date theDate  )
   {
      super( aDbData );

      Calendar beginStamp = Calendar.getInstance();
      beginStamp.setTime( theDate );
      beginStamp.set( Calendar.HOUR_OF_DAY, 0);
      beginStamp.set( Calendar.MINUTE, 0);
      beginStamp.set( Calendar.SECOND, 0);

      Calendar endStamp = Calendar.getInstance();
      endStamp.setTime( theDate );
      endStamp.set( Calendar.HOUR_OF_DAY, 23);
      endStamp.set( Calendar.MINUTE, 59);
      endStamp.set( Calendar.SECOND, 59);

      buildFromDateRange( aType, aStatus, beginStamp.getTime(), endStamp.getTime() );
   }


   public EntityGroupList( DBData aDbData, int aType, boolean inclDeleted, java.util.Date theDate, int range  )
   {
      super( aDbData );

      Calendar earliestDate = Calendar.getInstance();
      earliestDate.setTime( theDate );
      earliestDate.add( Calendar.DATE, -range);

      Calendar latestDate = Calendar.getInstance();
      latestDate.setTime( theDate );
      latestDate.add( Calendar.DATE, range);

      buildFromDateRange( aType, inclDeleted, earliestDate.getTime(), latestDate.getTime() );
   }

   public EntityGroupList( DBData aDbData, int aType, String aName, boolean signatureFlag  ) // search by member last name
   {
      super( aDbData );
      String queryString = "SELECT DISTINCT ( ENTITYGROUP.NAME ), entitygroup.groupnum, TYPE , entitygroup.description, entitygroup.aliasof, entitygroup.extname, entitygroup.createdate, entitygroup.lastupdate, entitygroup.notifychange, entitygroup.status, entitygroup.category, notifygroup";
      queryString +=       " FROM ENTITYGROUP, GROUPMEMBERMAP, PERSON WHERE ";
      queryString +=       "ENTITYGROUP.TYPE = " + aType
                           + " AND "
                           + " GROUPMEMBERMAP.GROUPNUM = ENTITYGROUP.GROUPNUM"
                           + " AND "
                           + " GROUPMEMBERMAP.MEMBERID = PERSON.PERSONID"
                           + " AND "
                           + " PERSON.LASTNAME LIKE '%"+aName+"%'";
      queryString +=       " ORDER BY ENTITYGROUP.NAME ASC;";
      buildList( queryString, 999 );
   }

   public EntityGroupList( DBData aDbData, boolean signatureFlag, int aType, int count ) // return 'count' groups based on lastUpdate
   {
      super( aDbData );

      String queryString = "SELECT * FROM ENTITYGROUP, PROJECTSTATUS WHERE ";
      queryString +=       "ENTITYGROUP.TYPE = " + aType;
      queryString +=       " AND ENTITYGROUP.STATUS = PROJECTSTATUS.ID";
      queryString +=       " AND PROJECTSTATUS.TRACKFOLLOWUP = 1"; // filter out the cold/warm leads we haven't heard from
      queryString +=       " ORDER BY LASTUPDATE DESC;";
      buildList( queryString, count );
   }

   public EntityGroupList( DBData aDbData, boolean signatureFlag, int aType, int count, boolean signatureFlag2 ) // return 'count' groups based on account activity
   {
      super( aDbData );

      String queryString = "SELECT * FROM ENTITYGROUP, ACCOUNTSTATEMENT WHERE ";
      queryString +=       "ENTITYGROUP.TYPE = " + aType;
      queryString +=       " AND ENTITYGROUP.GROUPNUM = ACCOUNTSTATEMENT.OWNERID" ;
      queryString +=       " AND ACCOUNTSTATEMENT.OWNERTYPE = ENTITYGROUP.TYPE";
      queryString +=       " ORDER BY ACCOUNTSTATEMENT.LASTACTIVITY DESC;";
      buildList( queryString, count );
   }

   public EntityGroupList( DBData aDbData, boolean signatureFlag, int aType, boolean signatureFlag2 ) // return all groups with open accounts
   {
      this( aDbData, signatureFlag, aType, signatureFlag2, AccountStatement.STATUS_OPEN );
   }

   public EntityGroupList( DBData aDbData, boolean signatureFlag, int aType, boolean signatureFlag2, int status ) // return all groups with specified status
   {
      super( aDbData );

      String queryString = "SELECT * FROM ENTITYGROUP, ACCOUNTSTATEMENT WHERE ";
      queryString +=       "ENTITYGROUP.TYPE = " + aType;
      queryString +=       " AND ENTITYGROUP.GROUPNUM = ACCOUNTSTATEMENT.OWNERID" ;
      queryString +=       " AND ACCOUNTSTATEMENT.OWNERTYPE = ENTITYGROUP.TYPE";
      queryString +=       " AND ACCOUNTSTATEMENT.STATUS = " + status;
      queryString +=       " ORDER BY ACCOUNTSTATEMENT.LASTACTIVITY DESC;";
      buildList( queryString, 9999);
   }



   public EntityGroupList( DBData aDbData, int aType, String aName, boolean signatureFlag, boolean signatureFlag2  ) // search by asso project name
   {
      super( aDbData );
      String queryString = "SELECT DISTINCT ( ENTITYGROUP.NAME ), entitygroup.groupnum, TYPE , entitygroup.description, entitygroup.aliasof, entitygroup.extname, entitygroup.createdate, entitygroup.lastupdate, entitygroup.notifychange, entitygroup.status, entitygroup.category, notifygroup";
      queryString +=       " FROM ENTITYGROUP, PROJECT WHERE ";
      queryString +=       "ENTITYGROUP.TYPE = " + aType
                           + " AND "
                           + " PROJECT.CONTACTTYPE = ENTITYGROUP.TYPE"
                           + " AND "
                           + " PROJECT.CONTACTID = ENTITYGROUP.GROUPNUM"
                           + " AND "
                           + " PROJECT.NAME LIKE '%"+aName+"%' ";
      queryString +=       " ORDER BY ENTITYGROUP.NAME ASC;";
      buildList( queryString, 999 );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityGroupList( DBData dbData )
   {
      super( dbData );
   }


   public EntityGroupList( DBData aDbData, String categoryName )
   {
      super( aDbData );
      String queryString = "SELECT * FROM ENTITYGROUP, GROUPCATEGORY WHERE "
                            + " ENTITYGROUP.CATEGORY = GROUPCATEGORY.ID "
                            + " AND GROUPCATEGORY.NAME like '%" + categoryName + "%'";
      queryString += " ORDER BY ENTITYGROUP.NAME ASC;";
      buildList( queryString, 999 );
   }

   public EntityGroupList( DBData aDbData, int region, String categoryName, int recordType, int siteDefEntityType  )
   {
      super( aDbData );
      String queryString =     "SELECT DISTINCT ( ENTITYGROUP.NAME ), entitygroup.groupnum, TYPE , entitygroup.description, entitygroup.aliasof, entitygroup.extname, entitygroup.createdate, entitygroup.lastupdate, entitygroup.notifychange, entitygroup.status, entitygroup.category, notifygroup"
                            +  " FROM PERSON, ENTITYGROUP, GROUPMEMBERMAP vCat, GROUPMEMBERMAP region, GROUPCATEGORY"
                            +  " WHERE ENTITYGROUP.CATEGORY = GROUPCATEGORY.ID"
                            +  " AND ENTITYGROUP.GROUPNUM = vCat.GROUPNUM"       //    OR (ENTITYGROUP.ALIASOF = vCat.GROUPNUM))"
                            +  " AND GROUPCATEGORY.NAME like '%" + categoryName + "%'"
                            +  " AND region.GROUPNUM =" + region
                            +  " AND PERSON.SITEDEFENTITYTYPE = " + siteDefEntityType
                            +  " AND PERSON.RECORDTYPE = " + recordType
                            +  " AND PERSON.STATUS = " + Person.STATUS_ACTIVE
                            +  " AND vCat.MEMBERID = PERSON.PERSONID"
                            +  " AND vCat.MEMBERID = region.MEMBERID";
      queryString += " ORDER BY ENTITYGROUP.NAME ASC;";
      buildList( queryString, 999 );
   }

   public EntityGroupList( DBData aDbData, int region, String categoryName, int recordType, int siteDefEntityType, int count  )
   {
      super( aDbData );
      String queryString =     "SELECT DISTINCT ( ENTITYGROUP.NAME ), entitygroup.groupnum, TYPE , entitygroup.description, entitygroup.aliasof, entitygroup.extname, entitygroup.createdate, entitygroup.lastupdate, entitygroup.notifychange, entitygroup.status, entitygroup.category, notifygroup"
                            +  " FROM PERSON, ENTITYGROUP, GROUPMEMBERMAP vCat, GROUPMEMBERMAP region, GROUPCATEGORY"
                            +  " WHERE ENTITYGROUP.CATEGORY = GROUPCATEGORY.ID"
                            +  " AND ENTITYGROUP.GROUPNUM = vCat.GROUPNUM" // OR (ENTITYGROUP.ALIASOF = vCat.GROUPNUM))"
                            +  " AND GROUPCATEGORY.NAME like '%" + categoryName + "%'"
                            +  " AND region.GROUPNUM =" + region
                            +  " AND PERSON.SITEDEFENTITYTYPE = " + siteDefEntityType
                            +  " AND PERSON.RECORDTYPE = " + recordType
                            +  " AND PERSON.STATUS = " + Person.STATUS_ACTIVE
                            +  " AND vCat.MEMBERID = PERSON.PERSONID"
                            +  " AND vCat.MEMBERID = region.MEMBERID";
      queryString += " Order by rand() limit " + count;
      buildList( queryString, 999 );
   }

   public EntityGroupList( DBData aDbData, int aFollowUpStatus, boolean signatureFlag, int aType, int count )
   {
      super( aDbData );

      String queryString = "SELECT * FROM ENTITYGROUP, PROJECTSTATUS WHERE ";
      queryString +=       "ENTITYGROUP.TYPE = " + aType;
      queryString +=       " AND ENTITYGROUP.STATUS = PROJECTSTATUS.ID";
      queryString +=       " AND PROJECTSTATUS.TRACKFOLLOWUP = 1"; // filter out the cold/warm leads we haven't heard from
      queryString +=       " AND ENTITYGROUP.FOLLOWUPSTATUSCACHE = " + aFollowUpStatus;
      queryString +=       " ORDER BY ENTITYGROUP.NAME ASC;";
      buildList( queryString, count);
   }


   // get all groups that match the grouptype and can contain the specified record type
   public EntityGroupList( DBData aDbData, int aEntityGroupType, int entityRecordType )
   {
      super( aDbData );
      String acceptString = "";
      if (entityRecordType == Person.RECORDTYPE_PERSON ) acceptString = "GROUPCATEGORY.CONTAINS = " + EntityGroup.ALLOWS_PERSON;
      if (entityRecordType == Person.RECORDTYPE_BUSINESS_ORG ) acceptString = "GROUPCATEGORY.CONTAINS = " + EntityGroup.ALLOWS_BUSINESS;
      if (entityRecordType == ObjectClassID.CONTACT ) acceptString = "GROUPCATEGORY.CONTAINS = " + EntityGroup.ALLOWS_CONTACT;
      String queryString = "SELECT * FROM ENTITYGROUP, GROUPCATEGORY WHERE ENTITYGROUP.TYPE = " + aEntityGroupType
                            + " AND TYPE = " + Integer.toString(aEntityGroupType)
                            + " AND ENTITYGROUP.CATEGORY = GROUPCATEGORY.ID "
                            + " AND " + acceptString;
      queryString += " ORDER BY ENTITYGROUP.NAME ASC;";
      buildList( queryString, 999 );
   }

   // get the groups this person is NOT in that match the grouptype (for now, it's only 0, 'general'); and groups that can contain the specified record type
   public EntityGroupList( DBData aDbData, int aEntityGroupType, int entityRecordType, EntityGroupList aEntityGroupList  )
   {
      this( aDbData, aEntityGroupType, entityRecordType, aEntityGroupList, -1 );  // default is to ignore update type
   }

   public EntityGroupList( DBData aDbData, int aEntityGroupType, int entityRecordType, EntityGroupList aEntityGroupList, int updateType  )
   {
      super( aDbData );
      String acceptString = "";
      if (entityRecordType == Person.RECORDTYPE_PERSON ) acceptString = "GROUPCATEGORY.CONTAINS = " + EntityGroup.ALLOWS_PERSON;
      if (entityRecordType == Person.RECORDTYPE_BUSINESS_ORG ) acceptString = "GROUPCATEGORY.CONTAINS = " + EntityGroup.ALLOWS_BUSINESS;
      if (entityRecordType == Person.RECORDTYPE_GROUP ) acceptString = "GROUPCATEGORY.CONTAINS = " + EntityGroup.ALLOWS_GROUP;
      if (entityRecordType == ObjectClassID.CONTACT ) acceptString = "GROUPCATEGORY.CONTAINS = " + EntityGroup.ALLOWS_CONTACT;
      String queryString = "SELECT * FROM ENTITYGROUP, GROUPCATEGORY WHERE ENTITYGROUP.TYPE = " + aEntityGroupType
                            + " AND TYPE = " + Integer.toString(aEntityGroupType)
                            + " AND ENTITYGROUP.CATEGORY = GROUPCATEGORY.ID "
                            + " AND " + acceptString;

      if ( updateType != -1 ) queryString += " AND GROUPCATEGORY.UPDATETYPE = " + updateType;

      for ( int i = 0; i < aEntityGroupList.getRecordList().length; i++ )
      {
          EntityGroup aEntityGroup = (EntityGroup) aEntityGroupList.getRecordList()[i];
          queryString += " AND GROUPNUM != " + aEntityGroup.getGroupNum();
      }
      queryString += " ORDER BY ENTITYGROUP.NAME ASC";
      buildList( queryString, 999 );
   }

   // get the groups this person is in matching the grouptype (for now, it's only 0, 'general'); and groups that can contain the specified record type (theoretically, this is redundant, since person should not be in a group that contains businesses, etc.
   public EntityGroupList( DBData aDbData, int aEntityGroupType, int entityRecordType, int aPersonId  )
   {
      this( aDbData, aEntityGroupType, entityRecordType, aPersonId, -1, -1, -1 );  // default is to ignore update type
   }

   public EntityGroupList( DBData aDbData, String groupCategory, int aPersonId  )
   {
      super( aDbData );
      String queryString = "SELECT * FROM ENTITYGROUP, GROUPMEMBERMAP, GROUPCATEGORY WHERE  "
                          + " GROUPMEMBERMAP.MEMBERID=" + aPersonId
                          + " AND GROUPMEMBERMAP.GROUPNUM = ENTITYGROUP.GROUPNUM "
                          + " AND ENTITYGROUP.ALIASOF < 1 " // June 16, 2011 -- added for WGBE... should be fine for all domains.  But keep a watch.... #############
                          + " AND ENTITYGROUP.CATEGORY = GROUPCATEGORY.ID AND GROUPCATEGORY.NAME = '" + groupCategory + "'";
      buildList( queryString, 999 );
   }

   public EntityGroupList( DBData aDbData, String groupCategory, int aMemberType, int aMemberId  )
   {
      super( aDbData );
      String queryString = "SELECT * FROM ENTITYGROUP, GROUPMEMBERMAP, GROUPCATEGORY WHERE  "
                          + " GROUPMEMBERMAP.MEMBERType=" + aMemberType
                          + " AND GROUPMEMBERMAP.MEMBERID=" + aMemberId
                          + " AND GROUPMEMBERMAP.GROUPNUM = ENTITYGROUP.GROUPNUM "
                          + " AND ENTITYGROUP.ALIASOF < 1 " // June 16, 2011 -- added for WGBE... should be fine for all domains.  But keep a watch.... #############
                          + " AND ENTITYGROUP.CATEGORY = GROUPCATEGORY.ID AND GROUPCATEGORY.NAME = '" + groupCategory + "'";
      buildList( queryString, 999 );
   }

   public EntityGroupList( DBData aDbData, String groupName, boolean inclDeleted   ) // get the list of groups contained in the group by this name - initially provided to find groups of vendors/clients/christmas card list for 2gvp v2
   {
      super( aDbData );
      EntityGroup theGroup = new EntityGroup( dbData, groupName );  //get the container group by name to get the groupNum
      String queryString = "SELECT * FROM ENTITYGROUP, GROUPMEMBERMAP, PROJECTSTATUS WHERE"
                          + " GROUPMEMBERMAP.GROUPNUM =  " + theGroup.getGroupNum()
                          + " AND ENTITYGROUP.STATUS = PROJECTSTATUS.ID" ;
      if (!inclDeleted) queryString += " AND PROJECTSTATUS.STATUSCLASS != 1010";
      queryString +=        " AND ENTITYGROUP.GROUPNUM = GROUPMEMBERMAP.MEMBERID"
                          + " ORDER BY ENTITYGROUP.NAME ASC";
      buildList( queryString, 9999 );
   }

   public EntityGroupList( DBData aDbData, boolean inclDeleted, int aType, String groupName  ) // get the list of (specified TYPE) groups contained in the group by this name - initially provided to find groups of vendors/clients/christmas card list for 2gvp v2
   {
      super( aDbData );
      EntityGroup theGroup = new EntityGroup( dbData, groupName );  //get the container group by name to get the groupNum
      String queryString = "SELECT * FROM ENTITYGROUP, GROUPMEMBERMAP, PROJECTSTATUS WHERE"
                          + " GROUPMEMBERMAP.GROUPNUM =  " + theGroup.getGroupNum()
                          + " AND ENTITYGROUP.TYPE   = " + aType
                          + " AND ENTITYGROUP.STATUS = PROJECTSTATUS.ID" ;
      if (!inclDeleted) queryString += " AND PROJECTSTATUS.STATUSCLASS != 1010";
      queryString +=        " AND ENTITYGROUP.GROUPNUM = GROUPMEMBERMAP.MEMBERID"
                          + " ORDER BY ENTITYGROUP.NAME ASC";
      buildList( queryString, 9999 );
   }

   public EntityGroupList( DBData aDbData, int aEntityGroupType, int entityRecordType, int aPersonId, int updateType, int associatedWithType, int associatedWithId )
   {
      super( aDbData );
      String acceptString = "";
      if (entityRecordType == Person.RECORDTYPE_PERSON ) acceptString = "GROUPCATEGORY.CONTAINS = " + EntityGroup.ALLOWS_PERSON;
      if (entityRecordType == Person.RECORDTYPE_BUSINESS_ORG ) acceptString = "GROUPCATEGORY.CONTAINS = " + EntityGroup.ALLOWS_BUSINESS;
      String queryString = "SELECT * FROM ENTITYGROUP, GROUPMEMBERMAP, GROUPCATEGORY WHERE  ENTITYGROUP.TYPE = " + aEntityGroupType
                          + " AND GROUPMEMBERMAP.MEMBERID=" + aPersonId
                          + " AND GROUPMEMBERMAP.GROUPNUM = ENTITYGROUP.GROUPNUM AND ENTITYGROUP.TYPE = " + aEntityGroupType
                          + " AND ENTITYGROUP.CATEGORY = GROUPCATEGORY.ID AND "
                          + acceptString;

      if ( updateType != -1 ) queryString += " AND GROUPCATEGORY.UPDATETYPE = " + updateType;

      if ( associatedWithType != -1 )
      {
         queryString += " AND GROUPMEMBERMAP.ASSOCIATEDWITHOWNERTYPE = " + associatedWithType
                       +" AND GROUPMEMBERMAP.ASSOCIATEDWITHOWNERID = " + associatedWithId;
      }

      queryString    += " ORDER BY ENTITYGROUP.NAME ASC"
                     + ";";

      buildList( queryString, 999 );
   }

   // this is primarily used for finding businesses a person is associated with (category = 0 for these groups, so method above won't work
   // 11/11/11 and now also for finding customer groups that a person is a member of
   public EntityGroupList( DBData aDbData, int aEntityGroupType, int aPersonId, boolean signatureFlag  )
   {
      super( aDbData );
      String queryString = "SELECT * FROM ENTITYGROUP, GROUPMEMBERMAP WHERE  ENTITYGROUP.TYPE = " + aEntityGroupType
                          + " AND GROUPMEMBERMAP.MEMBERID=" + aPersonId
                          + " AND STATUS != " + EntityGroup.STATUS_INACTIVE
                          + " AND GROUPMEMBERMAP.GROUPNUM = ENTITYGROUP.GROUPNUM"
                          + ";";
      buildList( queryString, 999 );
   }

   // find families where a family member is in a certain group
   public EntityGroupList( DBData aDbData, int aEntityGroupType, int aGroupId, boolean signatureFlag, boolean signatureFlag1   )
   {
      super( aDbData );
      PersonList aPersonList = new PersonList( aDbData, EntityGroup.TYPE_GENERAL, aGroupId );
      buildList( aDbData, aEntityGroupType, Person.RECORDTYPE_PERSON, aPersonList );
   }

   // i think this is used by wedding couple search....
   // also used to find families with family member in certain group
   public EntityGroupList( DBData aDbData, int aEntityGroupType, int entityRecordType, PersonList aPersonList  )
   {
      super( aDbData );
      buildList( aDbData, aEntityGroupType, Person.RECORDTYPE_PERSON, aPersonList );
   }

   public EntityGroupList( DBData aDbData, int aEntityGroupType, HttpServletRequest request  )
   {
      super( aDbData );
      String[] groups = request.getParameterValues( "listRight" );
      if ( groups != null )
      {
         recordList = getListInstance(groups.length);
         for ( int i = 0; i < groups.length; i++ )
         {
            recordList[i] = new EntityGroup( aDbData, aEntityGroupType, Integer.parseInt( groups[i] ) );
         }
      }
      else
      {
         recordList = getListInstance(0);
      }
   }

   protected String getPersonListSubClause( PersonList aPersonList )
   {
      String subClause = "( ";
      for ( int i = 0; i < aPersonList.getRecordList().length; i++ )
      {
        Person aPerson=(Person)aPersonList.getRecordList()[i];
        if ( i > 0 ) subClause += " OR ";
        subClause += " GROUPMEMBERMAP.MEMBERID = " + aPerson.getPersonId();
      }
      subClause += ")";
      return( subClause );
   }

// 11-07-06 -- i believe the only place this was used was in itemtrack... moving itemtrack to use a newer constructor based on redesign of group structure
// public EntityGroupList( DBData aDbData, boolean includeImplicit  )
// {
//    super( aDbData );
//    if ( includeImplicit )
//    {
//       buildList( "EntityGroup", "" );
//    }
//    else
//    {
//       String queryString = "SELECT * FROM ENTITYGROUP, GROUPTYPE WHERE GROUPTYPE.IMPLICITGROUPTYPE=0 AND GROUPTYPE.GROUPTYPE = ENTITYGROUP.TYPE";
//       buildList( queryString, 999 );
//    }
// }

// 11-07-06 comment out until I figure out if this is used.... most likely not since it still calls out implicit which went away months ago
// public EntityGroupList( DBData aDbData, String searchString  )
// {
//    super( aDbData );
//    String queryString = "SELECT * FROM ENTITYGROUP, GROUPTYPE WHERE GROUPTYPE.IMPLICITGROUPTYPE=0 AND NAME LIKE '%" + searchString + "%'";
//    buildList( queryString, 999 );
// }

   public EntityGroupList( DBData aDbData, int accept, boolean dummy  )
   {
      super( aDbData );
      String queryString;
      if ( accept == EntityGroupList.ACCEPTPERSONMEMBERSFLAG )
      {
         queryString = "SELECT * FROM ENTITYGROUP, GROUPTYPE WHERE GROUPTYPE.ACCEPTPERSONMEMBERS=1 AND GROUPTYPE.GROUPTYPE = ENTITYGROUP.TYPE";
      }
      else
      {
         queryString = "SELECT * FROM ENTITYGROUP, GROUPTYPE WHERE GROUPTYPE.ACCEPTBUSINESSMEMBERS=1 AND GROUPTYPE.GROUPTYPE = ENTITYGROUP.TYPE";
      }
      buildList( queryString, 999 );
   }

   private void buildList( DBData aDbData, int aEntityGroupType, int entityRecordType, PersonList aPersonList  )
   {
      String acceptString = "";
      String queryString = "SELECT * FROM ENTITYGROUP, GROUPMEMBERMAP WHERE ENTITYGROUP.TYPE = " + aEntityGroupType
                        + " AND " + getPersonListSubClause(aPersonList)
                        + " AND GROUPMEMBERMAP.GROUPNUM = ENTITYGROUP.GROUPNUM AND ENTITYGROUP.TYPE = " + aEntityGroupType;
      buildList( queryString, 9999 );
      removeDuplicates( EntityGroup.GROUPNUM );
   }

   // find groups in this group (group of groups)
   public EntityGroupList( DBData aDbData, int aEntityGroup, boolean inclDeleted, boolean dummy2 )
   {
      super( aDbData );
      String queryString = "SELECT * FROM ENTITYGROUP, GROUPMEMBERMAP, PROJECTSTATUS WHERE"
                         + "     GROUPMEMBERMAP.MEMBERID = ENTITYGROUP.GROUPNUM";
      queryString +=       " AND ENTITYGROUP.STATUS = PROJECTSTATUS.ID" ;
      if (!inclDeleted) queryString += " AND PROJECTSTATUS.STATUSCLASS != 1010";
      queryString +=       " AND GROUPMEMBERMAP.GROUPNUM = " + aEntityGroup
                         + " AND ( GROUPMEMBERMAP.MEMBERTYPE = " + Person.RECORDTYPE_GROUP  // see comment in Person.java
                         + "     OR GROUPMEMBERMAP.MEMBERTYPE = 8 )"  // added 11/09/12 -- contact groups have type 8, maillist to groups was failing
                         + " ORDER BY ENTITYGROUP.NAME ASC";
      buildList( queryString, 9999 );
   }

   // find groups that specified group is in (group of groups)                           ############ same method with different signature, but with 'corrected' SQL
   public EntityGroupList( DBData aDbData, int aEntityGroup, boolean dummy1, boolean dummy2, boolean dummy3 )
   {
      super( aDbData );
      String queryString = "SELECT * FROM ENTITYGROUP, GROUPMEMBERMAP WHERE"
                         + "     GROUPMEMBERMAP.GROUPNUM = ENTITYGROUP.GROUPNUM"
                         + " AND GROUPMEMBERMAP.MEMBERID = " + aEntityGroup
                         + " AND ( GROUPMEMBERMAP.MEMBERTYPE = " + Person.RECORDTYPE_GROUP  // see comment in Person.java
                         + "       OR GROUPMEMBERMAP.MEMBERTYPE = " + ObjectClassID.CONTACT + ")"  // contact is just another form of 'group type'
                         + " ORDER BY ENTITYGROUP.NAME ASC";
      buildList( queryString, 9999 );
   }

   // find groups that specified group is in 2 specific simultaneous groups  (used for preferred vendors page)
   public EntityGroupList( DBData aDbData, int aEntityGroup, int aEntityGroup2, boolean dummy1, boolean dummy2, boolean dummy3 )
   {
      super( aDbData );
      String queryString = "SELECT * FROM ENTITYGROUP, GROUPMEMBERMAP gm1, GROUPMEMBERMAP gm2 WHERE"

                         + "     gm1.MEMBERID = ENTITYGROUP.GROUPNUM"
                         + " AND gm1.GROUPNUM = " + aEntityGroup
                         + " AND gm1.MEMBERTYPE = " + Person.RECORDTYPE_GROUP  // see comment in Person.java

                         + " AND gm2.MEMBERID = ENTITYGROUP.GROUPNUM"
                         + " AND gm2.GROUPNUM = " + aEntityGroup2
                         + " AND gm2.MEMBERTYPE = " + Person.RECORDTYPE_GROUP  // see comment in Person.java

                         + " ORDER BY ENTITYGROUP.NAME ASC";
      buildList( queryString, 9999 );
   }

   // find groups that specified group is NOT a member of (group of groups)
   public EntityGroupList( DBData aDbData, EntityGroupList aExcludeList )
   {
      super( aDbData );
      String queryString = "SELECT * FROM ENTITYGROUP,GROUPCATEGORY WHERE"
                         + "     ENTITYGROUP.CATEGORY = GROUPCATEGORY.ID"
                         + " AND GROUPCATEGORY.CONTAINS != " + EntityGroup.ALLOWS_GROUP;

      for ( int i = 0; i < aExcludeList.getRecordList().length; i++ )
      {
          EntityGroup aGroup = (EntityGroup) aExcludeList.getRecordList()[i];
          queryString += " AND ENTITYGROUP.GROUPNUM != " + aGroup.getGroupNum();
      }
      queryString += " ORDER BY ENTITYGROUP.NAME ASC";
      buildList( queryString, 999 );
   }

   // find contacts that are not in this group -- 5/18/12
   public EntityGroupList( DBData aDbData, EntityGroupList aExcludeList, boolean signatureFlag )
   {
      super( aDbData );
      String queryString = "SELECT * FROM ENTITYGROUP WHERE"
                         + "     ENTITYGROUP.TYPE = " + ObjectClassID.CONTACT;

      for ( int i = 0; i < aExcludeList.getRecordList().length; i++ )
      {
          EntityGroup aGroup = (EntityGroup) aExcludeList.getRecordList()[i];
          queryString += " AND ENTITYGROUP.GROUPNUM != " + aGroup.getGroupNum();
      }
      queryString += " ORDER BY ENTITYGROUP.NAME ASC";
      buildList( queryString, 999 );
   }

   // find SAME CATEGORY groups that specified group is NOT a member of (group of groups)
   public EntityGroupList( DBData aDbData, EntityGroupList aExcludeList, int categoryId )
   {
      super( aDbData );
      String queryString = "SELECT * FROM ENTITYGROUP WHERE"
                         + "     ENTITYGROUP.CATEGORY = " + categoryId;

      for ( int i = 0; i < aExcludeList.getRecordList().length; i++ )
      {
          EntityGroup aGroup = (EntityGroup) aExcludeList.getRecordList()[i];
          queryString += " AND ENTITYGROUP.GROUPNUM != " + aGroup.getGroupNum();
      }
      queryString += " ORDER BY ENTITYGROUP.NAME ASC";
      buildList( queryString, 999 );
   }

   public void removeNonActiveMembers()  // works only on person and business lists -- do after query since so many query variations to add qual to
   {
      for ( int i = 0; i < recordList.length; i++ )
      {
         EntityGroup aGroup = (EntityGroup) recordList[i];
         if ( !aGroup.containsActiveMembers() ) removeRecord(aGroup);
      }
   }

   public EntityGroupList( DBData aDbData, HttpServletRequest request, boolean flag  )
   {
      super( aDbData );
      String[] groupMembers = request.getParameterValues( "listRight" );
      if ( groupMembers != null )
      {
         recordList = getListInstance(groupMembers.length);
         for ( int i = 0; i < groupMembers.length; i++ )
         {
            recordList[i] = new EntityGroup( aDbData, Integer.parseInt( groupMembers[i] ) );
         }
      }
      else
      {
         recordList = getListInstance(0);
      }
   }

   public EntityGroupList( DBData aDbData, int vendorId, boolean flag, String afterDate )
   {
      super( aDbData );
      String queryString = "SELECT DISTINCT(ENTITYGROUP.GROUPNUM), LASTUPDATE, NAME, EXTNAME,TYPE,CATEGORY FROM ENTITYGROUP, GROUPMEMBERMAP vendormap, GROUPMEMBERMAP leadmap1, GROUPMEMBERMAP leadmap2 WHERE "


                         + "     (vendormap.MEMBERTYPE = " + ObjectClassID.CONTACT +" OR  vendormap.MEMBERTYPE = 2)"
                         + " AND (leadmap1.MEMBERTYPE = " + ObjectClassID.CONTACT  +" OR  leadmap1.MEMBERTYPE = 2)"
                         + " AND (leadmap2.MEMBERTYPE = " + ObjectClassID.CONTACT  +" OR  leadmap2.MEMBERTYPE = 2)"

                         + " AND leadmap1.MEMBERID = leadmap2.MEMBERID "       // lead id must match lead list group and 'leads' group and contact group
                         + " AND leadmap2.MEMBERID = ENTITYGROUP.GROUPNUM "

                         + " AND vendormap.MEMBERID = " + vendorId

                         + " AND vendormap.GROUPNUM = leadmap1.GROUPNUM "
                         + " AND leadmap2.GROUPNUM = 4880 " // this is the 'leads' group.  Ensure we don't also pick up other vendors in the group

                         + " AND leadmap1.GROUPNUM = vendormap.GROUPNUM "

                         + " AND ENTITYGROUP.LASTUPDATE > '" + afterDate + "'"

                         + " ORDER BY ENTITYGROUP.NAME ASC";
      buildList( queryString, 9999 );
   }

   private void buildFromDateRange( int aType, boolean inclDeleted, java.util.Date bgnDate, java.util.Date endDate )
   {
      // Note since all relevant events at this time use the start date the event end date is NOT used in the query - only chk if event.bgn is in range

      SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");

      String queryString =             "SELECT distinct(groupnum), entitygroup.name, entitygroup.status, events.bgntimestamp from projectstatus, entitygroup, project, events where ";
      queryString +=                   "ENTITYGROUP.TYPE = " + aType;
      queryString +=                   " AND ENTITYGROUP.STATUS = PROJECTSTATUS.ID" ;
      if (!inclDeleted) queryString += " AND PROJECTSTATUS.STATUSCLASS != 1010";
      queryString +=                   " AND PROJECT.CONTACTTYPE = ENTITYGROUP.TYPE";
      queryString +=                   " AND PROJECT.CONTACTID = ENTITYGROUP.GROUPNUM";
      queryString +=                   " AND EVENTS.OWNERTYPE = " + ObjectClassID.PROJECT;
      queryString +=                   " AND EVENTS.OWNERID = PROJECT.ID";
      queryString +=                   " AND EVENTS.BGNTIMESTAMP > '" + formatter.format( bgnDate ) + "'";
      queryString +=                   " AND EVENTS.BGNTIMESTAMP < '" + formatter.format( endDate ) + "'";
      queryString +=                   " ORDER BY EVENTS.BGNTIMESTAMP ASC;";
      System.out.println( queryString );
      buildList( queryString,999 );
   }

   private void buildFromDateRange( int aType, int aStatus, java.util.Date bgnDate, java.util.Date endDate )
   {
      // Note since all relevant events at this time use the start date the event end date is NOT used in the query - only chk if event.bgn is in range

      SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");

      String queryString =             "SELECT distinct(groupnum), entitygroup.name, entitygroup.status, events.bgntimestamp from entitygroup, project, events where ";
      queryString +=                   "ENTITYGROUP.TYPE = " + aType;
      queryString +=                   " AND ENTITYGROUP.STATUS = " + aStatus;
      queryString +=                   " AND PROJECT.CONTACTTYPE = ENTITYGROUP.TYPE";
      queryString +=                   " AND PROJECT.CONTACTID = ENTITYGROUP.GROUPNUM";
      queryString +=                   " AND EVENTS.OWNERTYPE = " + ObjectClassID.PROJECT;
      queryString +=                   " AND EVENTS.OWNERID = PROJECT.ID";
      queryString +=                   " AND EVENTS.BGNTIMESTAMP >= '" + formatter.format( bgnDate ) + "'";
      queryString +=                   " AND EVENTS.BGNTIMESTAMP < '" + formatter.format( endDate ) + "'";
      queryString +=                   " ORDER BY EVENTS.BGNTIMESTAMP ASC;";
      System.out.println( queryString );
      buildList( queryString,999 );
   }

   private void buildFromDateRange( int aType, int[] statusClassArray, java.util.Date bgnDate, java.util.Date endDate )
   {
      // Note since all relevant events at this time use the start date the event end date is NOT used in the query - only chk if event.bgn is in range

      SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");

      String queryString =             "SELECT distinct(groupnum), entitygroup.name, entitygroup.status, events.bgntimestamp from projectstatus, entitygroup, project, events where ";
      queryString +=                   "ENTITYGROUP.TYPE = " + aType;
      queryString +=                   " AND ENTITYGROUP.STATUS = PROJECTSTATUS.ID" ;

      queryString += " AND ( ";
      for (int i=0; i < statusClassArray.length; i++ )
      {
         if ( i > 0 ) queryString += " OR ";
         queryString += " PROJECTSTATUS.STATUSCLASS = " + statusClassArray[i];
      }
      queryString += " ) ";

      queryString +=                   " AND PROJECT.CONTACTTYPE = ENTITYGROUP.TYPE";
      queryString +=                   " AND PROJECT.CONTACTID = ENTITYGROUP.GROUPNUM";
      queryString +=                   " AND EVENTS.OWNERTYPE = " + ObjectClassID.PROJECT;
      queryString +=                   " AND EVENTS.OWNERID = PROJECT.ID";
      queryString +=                   " AND EVENTS.BGNTIMESTAMP > '" + formatter.format( bgnDate ) + "'";
      queryString +=                   " AND EVENTS.BGNTIMESTAMP < '" + formatter.format( endDate ) + "'";
      queryString +=                   " ORDER BY EVENTS.BGNTIMESTAMP ASC;";
      System.out.println( queryString );
      buildList( queryString,999 );
      removeDuplicates(0);  // not sure why query is returning dups... but need unique groupnum
   }
}
