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

public class GroupMemberMap extends GroupMemberMapDBRecordBase
{
   public static int MEMBERROLE_FAMILY_HUSBAND = 1;
   public static int MEMBERROLE_FAMILY_WIFE    = 2;
   public static int MEMBERROLE_FAMILY_CHILD   = 3;
   public static int MEMBERROLE_FAMILY_CHILD_OF_MOTHER   = 4;
   public static int MEMBERROLE_FAMILY_CHILD_OF_FATHER   = 5;
   public static int MEMBERROLE_FAMILY_CONTACTPERSON = 6;

   public static int MEMBERROLE_BRIDE = 7;
   public static int MEMBERROLE_GROOM = 8;
   public static int MEMBERROLE_ALT_CONTACT = 9;
   public static int MEMBERROLE_NONE = 10;


   public static int MEMBERROLE_BUSINESS_RECORD   = 4; // a business is an entity group with a person object (type business) + other regular person objects for contacts;
                                                       //  this role identifies the business record member of the group

   public static final int ASSOCIATED_WITH_NONE        = 0;
   public static final int ASSOCIATED_WITH_WG_CONTRACT = 1;

//   public static int MEMBERTYPE_PERSON = 0;  // not used right now... not sure why... 10/26/06  I guess assumption now is members are always Person objects (even if business, it's a person record)
   // 11/4/06 -- membertypes should use Person.RECORDTYPE_** as long as it is either person or business



   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupMemberMap( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupMemberMap( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupMemberMap( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupMemberMap( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupMemberMap( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupMemberMap( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public GroupMemberMap( DBData dbData, int aGroupNum, int aMemberType, int aMemberId )
   {
      super( dbData );
      groupNum = aGroupNum;
      memberType = aMemberType;
      memberId = aMemberId;
   }

   public GroupMemberMap( DBData dbData, int aGroupNum, int aMemberType, int aMemberId, boolean flag )
   {
      super( dbData );
      String queryString = "GROUPNUM = " + aGroupNum  + " AND MEMBERID = " + aMemberId;
      if ( aMemberType != -1 ) queryString += " AND MEMBERTYPE = " + aMemberType;
      populateObject( "GROUPMEMBERMAP", queryString, "" );
   }

   public GroupMemberMap( DBData dbData, int aGroupNum, int aMemberType, int aMemberId, int aMemberRole, int anAssociatedWithOwnerType, int anAssociatedWithOwnerId )
   {
      super( dbData );
      String queryString = "GROUPNUM = "
                           + aGroupNum
                           + " AND MEMBERID = "
                           + aMemberId
                           + " AND MEMBERROLE = "
                           + aMemberRole
                           + " AND ASSOCIATEDWITHOWNERTYPE = "
                           + anAssociatedWithOwnerType
                           + " AND ASSOCIATEDWITHOWNERID = "
                           + anAssociatedWithOwnerId;
      if ( aMemberType != -1 ) queryString += " AND MEMBERTYPE = " + aMemberType;
      populateObject( "GROUPMEMBERMAP", queryString, "" );
   }

   public GroupMemberMap( DBData dbData, int aGroupNum, int aMemberType, int aMemberRole, boolean flag, boolean flag2 )
   {
      super( dbData );
      String queryString = "GROUPNUM = " + aGroupNum  + " AND MEMBERROLE = " + aMemberRole;
      if ( aMemberType != -1 ) queryString += " AND MEMBERTYPE = " + aMemberType;
      populateObject( "GROUPMEMBERMAP", queryString , "" );
      groupNum = aGroupNum; // set this in case a new record was created (and the db record retrieved doesn't have the id)
      memberType = aMemberType;
      memberRole = aMemberRole;
   }

   public boolean createRecord( String tableName )
   {
      // 12/20/06 - added 'associated with' parms to test due to wgbe advertiser region in mult contracts
      GroupMemberMap tester = new GroupMemberMap( dbData, groupNum, memberType, memberId, memberRole, associatedWithOwnerType, associatedWithOwnerId );
      if ( !tester.isRecordFound() )
      {
         return( super.createRecord( tableName, false, "" ));  // only do create if doesn't already exist.  Need to prevent dups
      }
      return(true);
   }

   public boolean removeRecord( String table )
   {
      return( super.removeRecord( table, false, "" ));  // don't want to log to history table when updating group members, etc due to erase all / readd philosophy
   }



}
