package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class GroupMemberMapList extends GroupMemberMapDBRecordListBase
{

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupMemberMapList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupMemberMapList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "GROUPMEMBERMAP", "GROUPNUM = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupMemberMapList( DBData dbData )
   {
      super( dbData );
   }

   // this should typically return 0 or 1 record (but in error could have dups...) it's the map record between a group and a member
   public GroupMemberMapList( DBData dbData, int groupType, int groupNum, int personId )
   {
      super( dbData );
      String queryString = "SELECT * FROM GROUPMEMBERMAP, ENTITYGROUP WHERE ENTITYGROUP.GROUPNUM = GROUPMEMBERMAP.GROUPNUM AND ENTITYGROUP.TYPE = " + groupType
      + " AND GROUPMEMBERMAP.GROUPNUM = " + groupNum
      + " AND GROUPMEMBERMAP.MEMBERID = " + personId ;
      buildList( queryString, 9999 );
   }

   // this returns the map records for all groups of a certain type (to determine what groups this person is a member of)
   public GroupMemberMapList( DBData dbData, int type, int personId )
   {
      super( dbData );
      String queryString = "SELECT * FROM GROUPMEMBERMAP, ENTITYGROUP WHERE ENTITYGROUP.GROUPNUM = GROUPMEMBERMAP.GROUPNUM AND ENTITYGROUP.TYPE = " + type
      + " AND GROUPMEMBERMAP.MEMBERID = " + personId ;
      buildList( queryString, 9999 );
   }

   // return maps for all groups this member is in
   public GroupMemberMapList( DBData dbData, boolean flag1, int memberType, int memberId )
   {
      super( dbData );
      String queryString = "SELECT * FROM GROUPMEMBERMAP WHERE MEMBERTYPE = " + memberType + " AND MEMBERID = " + memberId;
      buildList( queryString, 9999 );
   }

   public GroupMemberMapList( DBData dbData, int assoOwnerType, int assoOwnerId, boolean flag, boolean flag2, boolean flag3 )
   {
      super( dbData );
      String queryString = "SELECT * FROM GROUPMEMBERMAP WHERE"
                          + " ASSOCIATEDWITHOWNERTYPE  = " + assoOwnerType
                          + " AND ASSOCIATEDWITHOWNERID  = " + assoOwnerId;
      buildList( queryString, 9999 );
   }

   // this returns the map records for all UPDATABLE groups of a certain type (to determine what UPDATABLE groups this person is a member of)
   public GroupMemberMapList( DBData dbData, int groupType, int memberType, int memberId, boolean flag, boolean flag2, boolean flag3 )
   {
      super( dbData );
      String queryString = "SELECT * FROM GROUPMEMBERMAP, ENTITYGROUP, GROUPCATEGORY WHERE"
                          + " ENTITYGROUP.GROUPNUM = GROUPMEMBERMAP.GROUPNUM"
                          + " AND ENTITYGROUP.CATEGORY = GROUPCATEGORY.ID"
                          + " AND GROUPCATEGORY.UPDATETYPE = " + GroupCategory.UPDATETYPE_DEFAULT
                          + " AND ENTITYGROUP.TYPE = " + groupType
                          + " AND GROUPMEMBERMAP.MEMBERTYPE = " + memberType
                          + " AND GROUPMEMBERMAP.MEMBERID = " + memberId ;
      buildList( queryString, 9999 );
   }

   // this finds all members of a particular group
   public GroupMemberMapList( DBData dbData, int type, int groupNum, boolean byGroupFlag )
   {
      super( dbData );
      String queryString = "SELECT * FROM GROUPMEMBERMAP, ENTITYGROUP WHERE ENTITYGROUP.GROUPNUM = GROUPMEMBERMAP.GROUPNUM AND ENTITYGROUP.TYPE = " + type
      + " AND GROUPMEMBERMAP.GROUPNUM = " + groupNum ;
      buildList( queryString, 9999 );
   }

// public static boolean setMappings( DBData aDbData, EntityGroupList groups, int type, int personId, String table )
// {
//    boolean rc = false;
//
//    // 11-16-06 --- ONLY mess with records where Group Category has updateType of DEFAULT (meaning it's user-updatable)
//    GroupMemberMapList currMapping = new GroupMemberMapList( aDbData, type, personId, true );  12-30-06 -- constructors were reversed... see below
//    aDbData.getLog().logEvent( "setMappings: " + groups.getRecordList().length );
//    GroupMemberMapList currMapping = new GroupMemberMapList( aDbData, type, personId, true, true );
//    currMapping.removeRecords( table );
//    for ( int i = 0; i < groups.getRecordList().length; i++ )
//    {
//       EntityGroup aGroup = (EntityGroup)groups.getRecordList()[i];
//       GroupMemberMap aMap = new GroupMemberMap( aDbData, aGroup.getGroupNum(), type, personId );
//       rc = aMap.createRecord( table );
//    }
//    return(rc);
// }

   // 'type' in the above method is ambiguous. Need to separate groupType from memberType (12/24/11 - found when converting to contactcontainer groups)
   public static boolean setMappings( DBData aDbData, EntityGroupList groups, int groupType, int memberType, int memberId, String table )
   {
      boolean rc = false;

      GroupMemberMapList currMapping = new GroupMemberMapList( aDbData, groupType, memberType, memberId, true, true, true );
      currMapping.removeRecords( table );
      for ( int i = 0; i < groups.getRecordList().length; i++ )
      {
         EntityGroup aGroup = (EntityGroup)groups.getRecordList()[i];
         GroupMemberMap aMap = new GroupMemberMap( aDbData, aGroup.getGroupNum(), memberType, memberId );
         rc = aMap.createRecord( table );
      }
      return(rc);
   }

   public static boolean setMappings( DBData aDbData, PersonList groupMembers, int type, int groupNum, String table )
   {
      boolean rc = false;
//    GroupMemberMapList currMapping = new GroupMemberMapList( aDbData, type, groupNum, true, true ); 12-30-06 -- wrong constructor! (??)
      GroupMemberMapList currMapping = new GroupMemberMapList( aDbData, type, groupNum, true );
      currMapping.removeRecords( table );
      aDbData.getLog().logEvent( "setMappings: " + groupMembers.getRecordList().length );
      for ( int i = 0; i < groupMembers.getRecordList().length; i++ )
      {
         Person aPerson = (Person)groupMembers.getRecordList()[i];
         GroupMemberMap aMap = new GroupMemberMap( aDbData, groupNum, type, aPerson.getPersonId() );
         rc = aMap.createRecord( table );
      }
      return(rc);
   }

   public static boolean setMappings( DBData aDbData, EntityGroupList groupMembers, int type, int groupNum, String table, boolean dummy )
   {
      boolean rc = false;
      GroupMemberMapList currMapping = new GroupMemberMapList( aDbData, type, groupNum, true );
      currMapping.removeRecords( table );
      aDbData.getLog().logEvent( "setMappings: " + groupMembers.getRecordList().length );
      for ( int i = 0; i < groupMembers.getRecordList().length; i++ )
      {
         EntityGroup aEntityGroup = (EntityGroup)groupMembers.getRecordList()[i];
         GroupMemberMap aMap = new GroupMemberMap( aDbData, groupNum, Person.RECORDTYPE_GROUP, aEntityGroup.getGroupNum() );
         rc = aMap.createRecord( table );
      }
      return(rc);
   }
}
