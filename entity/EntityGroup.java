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

public class EntityGroup extends EntityGroupDBRecordBase
{
   public static final int TYPE_GENERAL = 0;
   public static final int TYPE_FAMILY  = 1;
   public static final int TYPE_TEMPORARYGROUP = 2;
   public static final int TYPE_GROUP = 2;
   public static final int TYPE_COUPLE  = 3;
   public static final int TYPE_BUSINESS  = 4;
   public static final int TYPE_CONTACTCONTAINER = ObjectClassID.CONTACT;
                                                      // new type to contain businesses/families/couples/etc. Generic now.  These groups will be contained in
                                                      // other groups to identify customers, vendors, families, etc.
                                                      // all of these groups may or may not contain an additional 'person' object for the address/etc of the 'group'
                                                      // Otherwise, one member of the group will be identified as 'primary contact'.  That person's info will be used for group address

   public static final int STATUS_ACTIVE = 0;
   public static final int STATUS_INACTIVE = 1;
   public static final int STATUS_DELETED = -1;


   public static final int ALLOWS_PERSON  = 1;
   public static final int ALLOWS_GROUP   = 2;
   public static final int ALLOWS_FAMILY  = 3;
   public static final int ALLOWS_COUPLE  = 4;
   public static final int ALLOWS_BUSINESS = 4;
   public static final int ALLOWS_SAME_CATEGORY_GROUP = 5;
   public static final int ALLOWS_CONTACT = 8;

   public static final int MAXGROUPTYPE = 1;

   private GroupCategory groupCategory = null;
   public  void          setGroupCategory( GroupCategory aGroupCategory ) { groupCategory = aGroupCategory; }
   public  GroupCategory getGroupCategory()
   {
      if ( groupCategory == null )
      {
          groupCategory = new GroupCategory( dbData, category );
      }
      return(groupCategory);
   }

   private HistoryList historyList;
   public  void        setHistoryList( HistoryList aHistory ) { historyList = aHistory; }
   public  HistoryList getHistoryList()
   {
      historyList = new HistoryList( dbData, ObjectClassID.GROUP, groupNum );
      return(historyList);
   }

   public int getId() // alias for getGroupNum().... when dealing with groups used as contact containers, prefer not calling the contact id as 'groupnum'
   {
      return( groupNum );
   }


   private Object groupInfo;
   public  void   setGroupInfo( Object aGroupInfo ) { groupInfo = aGroupInfo; }
   public  Object getGroupInfo() { return(groupInfo); }

   private PersonList groupMembers;
   public  void       setGroupMembers( PersonList aGroupMembers ) { groupMembers = aGroupMembers; }
   public  PersonList getGroupMembers()  { return(groupMembers); }

   private EntityGroupList gGroupMembers;
   public  void            setGGroupMembers( EntityGroupList aGGroupMembers ) { gGroupMembers = aGGroupMembers; }
   public  EntityGroupList getGGroupMembers()      { return(gGroupMembers); }



   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityGroup( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityGroup( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      name = "Temp";
      type = TYPE_TEMPORARYGROUP;
      createRecord( "ENTITYGROUP" );

      String[] values = request.getParameterValues( label );
      for ( int i = 0; i < values.length; i++ )
      {
         GroupMemberMap aMap = new GroupMemberMap( aDbData, groupNum, TYPE_GENERAL, Integer.parseInt( values[i] ));
         aMap.createRecord( "GROUPMEMBERMAP" );
      }
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityGroup( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityGroup( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityGroup( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityGroup( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public EntityGroup( DBData aDbData, int aGroupType, int aMemberType, int aMemberId )
   {
      super( aDbData );
      String tables = "entitygroup, groupmembermap";
      String queryString = "ENTITYGROUP.TYPE= " + aGroupType
                         + " and groupmembermap.groupnum = entitygroup.groupnum"
                         + " and groupmembermap.membertype = " + aMemberType
                         + " and groupmembermap.memberid = " + aMemberId;
      populateObject( tables, queryString,"" );
   }

   public EntityGroup( DBData aDbData, int type, String aName )
   {
      super( aDbData );
      populateObject( "ENTITYGROUP", "TYPE= " + type + " AND NAME = " + prepareStringField(aName), "" );
   }

   public EntityGroup( DBData aDbData, int type, int groupNum )
   {
      super( aDbData );
      populateObject( "ENTITYGROUP", "TYPE= " + type + " AND GROUPNUM="+ groupNum, "" );
   }

   public EntityGroup( DBData aDbData, int type, String[] emailAddresses )
   {
      super( aDbData );
      String tables = "entitygroup, groupmembermap, person, email";
      String queryString = "ENTITYGROUP.TYPE= " + type
                         + " and email.ownerid = person.personid"
                         + " and person.personid = groupmembermap.memberid"
                         + " and groupmembermap.groupnum = entitygroup.groupnum"
                         + " and (";
      for (int i=0; i < emailAddresses.length; i++ )
      {
          if (i > 0) queryString += " or ";
          queryString += " email.emailaddress = '" + emailAddresses[i] + "'";
      }
      queryString += ")";
      populateObject( tables, queryString,"" );
   }

   public EntityGroup( DBData aDbData, int groupNum )
   {
      super( aDbData );
      populateObject( "ENTITYGROUP", " GROUPNUM="+ groupNum + " AND ALIASOF < 1", "" ); // 7/9/12 never pull aliases
   }

   public EntityGroup( DBData aDbData, String aName )
   {
      super( aDbData );
      populateObject( "ENTITYGROUP", " NAME="+ prepareStringField(aName), "" );
   }

   public EntityGroup( DBData dbData, String groupCategoryName, int aMemberId )
   {
      super( dbData );
      GroupCategory categoryObj = new GroupCategory( dbData, groupCategoryName );
      if ( !categoryObj.isRecordFound() )
      {
         categoryObj.setName( groupCategoryName );
         categoryObj.setContains( EntityGroup.ALLOWS_BUSINESS );
         categoryObj.setStatus( GroupCategory.STATUS_ACTIVE );
         categoryObj.createRecord( "GROUPCATEGORY" );
         categoryObj = new GroupCategory( dbData, groupCategoryName ); // refresh just to be sure I get the assigned id
      }
      category = categoryObj.getId();

      populateObject( "ENTITYGROUP,GROUPMEMBERMAP", "CATEGORY="+category + " AND ENTITYGROUP.GROUPNUM=GROUPMEMBERMAP.GROUPNUM AND MEMBERID="+aMemberId, "" );
   }

   public EntityGroup( DBData dbData, String groupName, String groupCategoryName, int groupType, int aMemberId )
   {
      this( dbData, groupName, groupCategoryName, groupType, aMemberId, 0, 0 );
   }


  // be careful using this... it doesn't have a way to set membertype.  fine for people groups.  But won't work for contact groups, etc.  alt method added below
   public EntityGroup( DBData dbData, String groupName, String groupCategoryName, int groupType, int aMemberId, int associatedWithType, int associatedWithId )
   {
      super( dbData );
      populateObject( "ENTITYGROUP", "NAME= " + prepareStringField(groupName), "" );
      if ( !recordFound )
      {
         name = groupName;

         GroupCategory categoryObj = new GroupCategory( dbData, groupCategoryName );
         if ( !categoryObj.isRecordFound() )
         {
            categoryObj.setName( groupCategoryName );
            categoryObj.setContains( EntityGroup.ALLOWS_BUSINESS );
            categoryObj.setStatus( GroupCategory.STATUS_ACTIVE );
            categoryObj.createRecord( "GROUPCATEGORY" );
            categoryObj = new GroupCategory( dbData, groupCategoryName ); // refresh just to be sure I get the assigned id
         }
         category = categoryObj.getId();
         type = groupType;
         groupMembers = new PersonList( dbData, -1 ); // get an empty member list to prevent NPE on create
         createOrUpdateRecord( "ENTITYGROUP" );   // if the requested named group didn't exist, it does now...
      }
      if ( aMemberId != -1 )
      {
         GroupMemberMap map = new GroupMemberMap( dbData );
         map.setGroupNum( groupNum );
         map.setMemberId( aMemberId );
         if ( groupType ==  EntityGroup.TYPE_GROUP ) map.setMemberType( groupType );
         map.setAssociatedWithOwnerType( associatedWithType );
         map.setAssociatedWithOwnerId( associatedWithId );
         map.createRecord( "GROUPMEMBERMAP" ); // 12/20/06 -- was createOrUpdate... but was failing on wgbe ad region due to not testing associatedWith on search.  should alway be a create, right?
      }
   }


   public EntityGroup( DBData dbData, String groupName, String groupCategoryName, int groupType, int aMemberType, int aMemberId )
   {
      super( dbData );
      populateObject( "ENTITYGROUP", "NAME= " + prepareStringField(groupName), "" );
      if ( !recordFound )
      {
         name = groupName;

         GroupCategory categoryObj = new GroupCategory( dbData, groupCategoryName );
         if ( !categoryObj.isRecordFound() )
         {
            categoryObj.setName( groupCategoryName );
            categoryObj.setContains( EntityGroup.ALLOWS_BUSINESS );
            categoryObj.setStatus( GroupCategory.STATUS_ACTIVE );
            categoryObj.createRecord( "GROUPCATEGORY" );
            categoryObj = new GroupCategory( dbData, groupCategoryName ); // refresh just to be sure I get the assigned id
         }
         category = categoryObj.getId();
         type = groupType;
         groupMembers = new PersonList( dbData, -1 ); // get an empty member list to prevent NPE on create
         createOrUpdateRecord( "ENTITYGROUP" );   // if the requested named group didn't exist, it does now...
      }
      if ( aMemberId != -1 )
      {
         GroupMemberMap map = new GroupMemberMap( dbData );
         map.setGroupNum( groupNum );
         map.setMemberId( aMemberId );
         map.setMemberType( aMemberType );
         map.createRecord( "GROUPMEMBERMAP" );
      }
   }

   public boolean removeRecord( String table )
   {
      if (!super.removeRecord( table ) ) return( false );

      GroupMemberMapList mappings = new GroupMemberMapList( dbData, type, groupNum, true );
      return( mappings.removeRecords( "GROUPMEMBERMAP" ));

   }

   public boolean createOrUpdateRecord( String table )
   {
      if (!super.createOrUpdateRecord( table ) ) return( false );
      if ( getGroupCategory().getContains() == ObjectClassID.CONTACT )
      {
         GroupMemberMapList.setMappings( dbData, groupMembers, 2, groupNum, "GROUPMEMBERMAP");  // hardcoded member map type
      }
      else if (( getGroupCategory().getContains() != EntityGroup.ALLOWS_GROUP ) &&  ( getGroupCategory().getContains() != EntityGroup.ALLOWS_SAME_CATEGORY_GROUP ))
      {
         GroupMemberMapList.setMappings( dbData, groupMembers, type, groupNum, "GROUPMEMBERMAP");
      }
      else
      {
         GroupMemberMapList.setMappings( dbData, gGroupMembers, type, groupNum, "GROUPMEMBERMAP", false);
      }

      return(true);
   }

   public boolean createOrUpdateRecord( String table, boolean dontSetMappings )
   {
      return(super.createOrUpdateRecord( table ) );
   }

   public void populateObject( HttpServletRequest request, String prefix )
   {
      super.populateObject( request, prefix );
      if (( getGroupCategory().getContains() != EntityGroup.ALLOWS_GROUP ) &&  ( getGroupCategory().getContains() != EntityGroup.ALLOWS_SAME_CATEGORY_GROUP ))
      {
         groupMembers = new PersonList( dbData, request, true );
      }
      else
      {
         gGroupMembers = new EntityGroupList( dbData, request, true );
      }
   }

   public void deepPopulate()
   {
      if (( getGroupCategory().getContains() != EntityGroup.ALLOWS_GROUP ) &&  ( getGroupCategory().getContains() != EntityGroup.ALLOWS_SAME_CATEGORY_GROUP ))
      {
         groupMembers = new PersonList( dbData, type, groupNum );
      }
      else
      {
         gGroupMembers = new EntityGroupList( dbData, groupNum, true, false );
      }
   }

   public boolean containsActiveMembers()  // requested by Pam Teich - specifically to filter out families that do not have any active members
   {
      // 'active' is a site-specific value;  there can be many more statuses for entity in sitespecific.  But one of those should match Person.STATUS_ACTIVE.  Find out the
      // value from SiteDefEntityType that matches STATUS_ACTIVE.

      SiteDefEntityType siteDef = new SiteDefEntityType( dbData, Person.STATUS_ACTIVE );

      deepPopulate();
      for ( int i = 0; i < groupMembers.getRecordList().length; i++ )
      {
         Person aMember = (Person) groupMembers.getRecordList()[i];
         log.logEvent( aMember.getLastName() + ", " + aMember.getFirstName() + " " + aMember.getStatus() );
         if (aMember.getSiteDefEntityType()== siteDef.getEntityType() ) return(true);
      }
      return(false);
   }


   public boolean removeMember( int memberId )
   {
     GroupMemberMapList mappings = new GroupMemberMapList( dbData, type, groupNum, memberId );
      return( mappings.removeRecords( "GROUPMEMBERMAP" ));
   }

   public boolean addMember( int memberType, int memberId )
   {
     GroupMemberMap map = new GroupMemberMap( dbData, groupNum, memberType, memberId );
      return( map.createOrUpdateRecord( "GROUPMEMBERMAP" ));
   }

   public static boolean isMemberOfGroup( DBData aDBData, int aGroupId, int aMemberType, int aMemberId )
   {
      GroupMemberMap aMap = new GroupMemberMap( aDBData, aGroupId, aMemberType, aMemberId, true );
      return ( aMap.isRecordFound() );
   }


}
