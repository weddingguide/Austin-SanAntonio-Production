package jwm.entity.db;
 
import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;
 
public class GroupMemberMapDBRecordBase extends ServletRecord
{
 
   public static final int GROUPNUM = 0;
   public static final int MEMBERTYPE = 1;
   public static final int MEMBERID = 2;
   public static final int MEMBERROLE = 3;
   public static final int MEMBERROLETEXT = 4;
   public static final int ASSOCIATEDWITHOWNERTYPE = 5;
   public static final int ASSOCIATEDWITHOWNERID = 6;
   public static final int PRIMARYMEMBER = 7;
 
   public static final String[] COLNAME = {
                                             "GROUPMEMBERMAP.GROUPNUM",
                                             "GROUPMEMBERMAP.MEMBERTYPE",
                                             "GROUPMEMBERMAP.MEMBERID",
                                             "GROUPMEMBERMAP.MEMBERROLE",
                                             "GROUPMEMBERMAP.MEMBERROLETEXT",
                                             "GROUPMEMBERMAP.ASSOCIATEDWITHOWNERTYPE",
                                             "GROUPMEMBERMAP.ASSOCIATEDWITHOWNERID",
                                             "GROUPMEMBERMAP.PRIMARYMEMBER"
                                                    };
 
   protected int groupNum;
   public    int getGroupNum() { return( groupNum ); }
   public     void setGroupNum( int aGroupNum ) { groupNum = aGroupNum; }
 
   protected int memberType;
   public    int getMemberType() { return( memberType ); }
   public     void setMemberType( int aMemberType ) { memberType = aMemberType; }
 
   protected int memberId;
   public    int getMemberId() { return( memberId ); }
   public     void setMemberId( int aMemberId ) { memberId = aMemberId; }
 
   protected int memberRole;
   public    int getMemberRole() { return( memberRole ); }
   public     void setMemberRole( int aMemberRole ) { memberRole = aMemberRole; }
 
   protected String memberRoleText = "";
   public    String getMemberRoleText() { return( memberRoleText ); }
   public     void setMemberRoleText( String aMemberRoleText ) { memberRoleText = aMemberRoleText; }
 
   protected int associatedWithOwnerType;
   public    int getAssociatedWithOwnerType() { return( associatedWithOwnerType ); }
   public     void setAssociatedWithOwnerType( int aAssociatedWithOwnerType ) { associatedWithOwnerType = aAssociatedWithOwnerType; }
 
   protected int associatedWithOwnerId;
   public    int getAssociatedWithOwnerId() { return( associatedWithOwnerId ); }
   public     void setAssociatedWithOwnerId( int aAssociatedWithOwnerId ) { associatedWithOwnerId = aAssociatedWithOwnerId; }
 
   protected int primaryMember;
   public    int getPrimaryMember() { return( primaryMember ); }
   public     void setPrimaryMember( int aPrimaryMember ) { primaryMember = aPrimaryMember; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public GroupMemberMapDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "GroupMemberMapDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public GroupMemberMapDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "GroupMemberMapDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public GroupMemberMapDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "GroupMemberMapDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public GroupMemberMapDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "GroupMemberMapDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public GroupMemberMapDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "GroupMemberMapDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public GroupMemberMapDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "GroupMemberMapDBRecordBase constructor from array");
      for ( int i = 0; i<fields.length; i++ )
      {
          if ( map[i] != -1 )
          {
             if ( !fields[i].equals("") ) log.logEvent( log.TRACE, i + " " + fields[i] );
             dbColumns[ map[i] ].populateFromString( fields[ i ] );
          }
      }
      refreshLocalVariables();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void createColumnObjects( DBData aDbData )
   {
      dbColumns = new DBColumn[ 8 ];
      dbColumns[0] = new ServletIntColumn( aDbData, "GROUPMEMBERMAP.GROUPNUM", "GROUPMEMBERMAP", "groupNum" );
      dbColumns[1] = new ServletIntColumn( aDbData, "GROUPMEMBERMAP.MEMBERTYPE", "GROUPMEMBERMAP", "memberType" );
      dbColumns[2] = new ServletIntColumn( aDbData, "GROUPMEMBERMAP.MEMBERID", "GROUPMEMBERMAP", "memberId" );
      dbColumns[3] = new ServletIntColumn( aDbData, "GROUPMEMBERMAP.MEMBERROLE", "GROUPMEMBERMAP", "memberRole" );
      dbColumns[4] = new ServletStringColumn( aDbData, "GROUPMEMBERMAP.MEMBERROLETEXT", "GROUPMEMBERMAP", "memberRoleText" );
      if ( memberRoleText == null ) memberRoleText = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
      dbColumns[5] = new ServletIntColumn( aDbData, "GROUPMEMBERMAP.ASSOCIATEDWITHOWNERTYPE", "GROUPMEMBERMAP", "associatedWithOwnerType" );
      dbColumns[6] = new ServletIntColumn( aDbData, "GROUPMEMBERMAP.ASSOCIATEDWITHOWNERID", "GROUPMEMBERMAP", "associatedWithOwnerId" );
      dbColumns[7] = new ServletBoolIntColumn( aDbData, "GROUPMEMBERMAP.PRIMARYMEMBER", "GROUPMEMBERMAP", "primaryMember" );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      groupNum = ((ServletIntColumn)dbColumns[0]).getValue();
      memberType = ((ServletIntColumn)dbColumns[1]).getValue();
      memberId = ((ServletIntColumn)dbColumns[2]).getValue();
      memberRole = ((ServletIntColumn)dbColumns[3]).getValue();
      memberRoleText = ((ServletStringColumn)dbColumns[4]).getValue();
      associatedWithOwnerType = ((ServletIntColumn)dbColumns[5]).getValue();
      associatedWithOwnerId = ((ServletIntColumn)dbColumns[6]).getValue();
      primaryMember = ((ServletBoolIntColumn)dbColumns[7]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletIntColumn)dbColumns[0]).setValue( groupNum );
      ((ServletIntColumn)dbColumns[1]).setValue( memberType );
      ((ServletIntColumn)dbColumns[2]).setValue( memberId );
      ((ServletIntColumn)dbColumns[3]).setValue( memberRole );
      ((ServletStringColumn)dbColumns[4]).setValue( memberRoleText );
      ((ServletIntColumn)dbColumns[5]).setValue( associatedWithOwnerType );
      ((ServletIntColumn)dbColumns[6]).setValue( associatedWithOwnerId );
      ((ServletBoolIntColumn)dbColumns[7]).setValue( primaryMember );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public String toString()
   {
         return( toString( "" ) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public String toString( String prefix )
   {
      String retString = "\n" + prefix + "GroupMemberMap Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    groupNum (GROUPMEMBERMAP.GROUPNUM) -- ";
         retString += "localVar=\"" + Integer.toString( groupNum) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    memberType (GROUPMEMBERMAP.MEMBERTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( memberType) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    memberId (GROUPMEMBERMAP.MEMBERID) -- ";
         retString += "localVar=\"" + Integer.toString( memberId) + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    memberRole (GROUPMEMBERMAP.MEMBERROLE) -- ";
         retString += "localVar=\"" + Integer.toString( memberRole) + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    memberRoleText (GROUPMEMBERMAP.MEMBERROLETEXT) -- ";
         retString += "localVar=\"" + memberRoleText.toString() + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    associatedWithOwnerType (GROUPMEMBERMAP.ASSOCIATEDWITHOWNERTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( associatedWithOwnerType) + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    associatedWithOwnerId (GROUPMEMBERMAP.ASSOCIATEDWITHOWNERID) -- ";
         retString += "localVar=\"" + Integer.toString( associatedWithOwnerId) + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    primaryMember (GROUPMEMBERMAP.PRIMARYMEMBER) -- ";
         retString += "localVar=\"" + Integer.toString( primaryMember) + "\";  ";
         retString += dbColumns[7].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(GroupMemberMapViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showGroupNum ) retString += commaSeparator(retString) + "groupNum" + ndxSuffix;
         if( viewDef.showMemberType ) retString += commaSeparator(retString) + "memberType" + ndxSuffix;
         if( viewDef.showMemberId ) retString += commaSeparator(retString) + "memberId" + ndxSuffix;
         if( viewDef.showMemberRole ) retString += commaSeparator(retString) + "memberRole" + ndxSuffix;
         if( viewDef.showMemberRoleText ) retString += commaSeparator(retString) + "memberRoleText" + ndxSuffix;
         if( viewDef.showAssociatedWithOwnerType ) retString += commaSeparator(retString) + "associatedWithOwnerType" + ndxSuffix;
         if( viewDef.showAssociatedWithOwnerId ) retString += commaSeparator(retString) + "associatedWithOwnerId" + ndxSuffix;
         if( viewDef.showPrimaryMember ) retString += commaSeparator(retString) + "primaryMember" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(GroupMemberMapViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showGroupNum ) retString += commaSeparator(retString) + CSVCell( groupNum);
         if( viewDef.showMemberType ) retString += commaSeparator(retString) + CSVCell( memberType);
         if( viewDef.showMemberId ) retString += commaSeparator(retString) + CSVCell( memberId);
         if( viewDef.showMemberRole ) retString += commaSeparator(retString) + CSVCell( memberRole);
         if( viewDef.showMemberRoleText ) retString += commaSeparator(retString) + CSVCell( memberRoleText);
         if( viewDef.showAssociatedWithOwnerType ) retString += commaSeparator(retString) + CSVCell( associatedWithOwnerType);
         if( viewDef.showAssociatedWithOwnerId ) retString += commaSeparator(retString) + CSVCell( associatedWithOwnerId);
         if( viewDef.showPrimaryMember ) retString += commaSeparator(retString) + CSVCell( primaryMember);
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public boolean isValidDbCreate()
   {
      return( true );
   }
   public void getSQLCreateStatement()
   {
      sysLogger.info( "DROP TABLE GROUPMEMBERMAP;" );
      sysLogger.info( "CREATE TABLE GROUPMEMBERMAP ( GROUPMEMBERMAP.GROUPNUM integer, GROUPMEMBERMAP.MEMBERTYPE integer, GROUPMEMBERMAP.MEMBERID integer, GROUPMEMBERMAP.MEMBERROLE integer, GROUPMEMBERMAP.MEMBERROLETEXT char, GROUPMEMBERMAP.ASSOCIATEDWITHOWNERTYPE integer, GROUPMEMBERMAP.ASSOCIATEDWITHOWNERID integer, GROUPMEMBERMAP.PRIMARYMEMBER integer );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "GroupMemberMap Object:";
      retString += "\n    groupNum (GROUPMEMBERMAP.GROUPNUM) -- ";
      retString += "localVar=\"" + Integer.toString( groupNum) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    memberType (GROUPMEMBERMAP.MEMBERTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( memberType) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    memberId (GROUPMEMBERMAP.MEMBERID) -- ";
      retString += "localVar=\"" + Integer.toString( memberId) + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    memberRole (GROUPMEMBERMAP.MEMBERROLE) -- ";
      retString += "localVar=\"" + Integer.toString( memberRole) + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    memberRoleText (GROUPMEMBERMAP.MEMBERROLETEXT) -- ";
      retString += "localVar=\"" + memberRoleText.toString() + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    associatedWithOwnerType (GROUPMEMBERMAP.ASSOCIATEDWITHOWNERTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( associatedWithOwnerType) + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    associatedWithOwnerId (GROUPMEMBERMAP.ASSOCIATEDWITHOWNERID) -- ";
      retString += "localVar=\"" + Integer.toString( associatedWithOwnerId) + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    primaryMember (GROUPMEMBERMAP.PRIMARYMEMBER) -- ";
      retString += "localVar=\"" + Integer.toString( primaryMember) + "\";  ";
      retString += dbColumns[7].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "memberRoleText", label ); 
      return( dBQuery );
   }
public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int qualifierCol, int qualifierValue, int logic )
   {
      DBQuery dBQuery = getDBQuery( aTableName, aDbData, request, label, logic );
     if ( !dBQuery.isNull() )
      {
         if ( qualifierValue != -1 )
         {
            dBQuery.add( aTableName, COLNAME[ qualifierCol ] + " = " + Integer.toString( qualifierValue ) );
         }
      }
      return( dBQuery );
   }
}
