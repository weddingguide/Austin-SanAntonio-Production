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
 
public class EntityGroupDBRecordBase extends ServletRecord
{
 
   public static final int GROUPNUM = 0;
   public static final int ALIASOF = 1;
   public static final int TYPE = 2;
   public static final int NAME = 3;
   public static final int EXTNAME = 4;
   public static final int DESCRIPTION = 5;
   public static final int STATUS = 6;
   public static final int CATEGORY = 7;
   public static final int NOTIFYGROUP = 8;
   public static final int CREATEDATE = 9;
   public static final int LASTUPDATE = 10;
   public static final int NOTIFYCHANGE = 11;
   public static final int FOLLOWUPSTATUSCACHE = 12;
 
   public static final String[] COLNAME = {
                                             "ENTITYGROUP.GROUPNUM",
                                             "ENTITYGROUP.ALIASOF",
                                             "ENTITYGROUP.TYPE",
                                             "ENTITYGROUP.NAME",
                                             "ENTITYGROUP.EXTNAME",
                                             "ENTITYGROUP.DESCRIPTION",
                                             "ENTITYGROUP.STATUS",
                                             "ENTITYGROUP.CATEGORY",
                                             "ENTITYGROUP.NOTIFYGROUP",
                                             "ENTITYGROUP.CREATEDATE",
                                             "ENTITYGROUP.LASTUPDATE",
                                             "ENTITYGROUP.NOTIFYCHANGE",
                                             "ENTITYGROUP.FOLLOWUPSTATUSCACHE"
                                                    };
 
   protected int groupNum;
   public    int getGroupNum() { return( groupNum ); }
   public     void setGroupNum( int aGroupNum ) { groupNum = aGroupNum; }
 
   protected int aliasOf;
   public    int getAliasOf() { return( aliasOf ); }
   public     void setAliasOf( int aAliasOf ) { aliasOf = aAliasOf; }
 
   protected int type;
   public    int getType() { return( type ); }
   public     void setType( int aType ) { type = aType; }
 
   protected String name = "";
   public    String getName() { return( name ); }
   public     void setName( String aName ) { name = aName; }
 
   protected String extName = "";
   public    String getExtName() { return( extName ); }
   public     void setExtName( String aExtName ) { extName = aExtName; }
 
   protected String description = "";
   public    String getDescription() { return( description ); }
   public     void setDescription( String aDescription ) { description = aDescription; }
 
   protected int status;
   public    int getStatus() { return( status ); }
   public     void setStatus( int aStatus ) { status = aStatus; }
 
   protected int category;
   public    int getCategory() { return( category ); }
   public     void setCategory( int aCategory ) { category = aCategory; }
 
   protected int notifyGroup;
   public    int getNotifyGroup() { return( notifyGroup ); }
   public     void setNotifyGroup( int aNotifyGroup ) { notifyGroup = aNotifyGroup; }
 
   protected java.sql.Date createDate;
   public    java.sql.Date getCreateDate() { return( createDate ); }
   public     void setCreateDate( java.sql.Date aCreateDate ) { createDate = aCreateDate; }
 
   protected Timestamp lastUpdate = new Timestamp( ( new java.util.Date()).getTime() );
   public    Timestamp getLastUpdate() { return( lastUpdate ); }
   public     void setLastUpdate( Timestamp aLastUpdate ) { lastUpdate = aLastUpdate; }
 
   protected int notifyChange;
   public    int getNotifyChange() { return( notifyChange ); }
   public     void setNotifyChange( int aNotifyChange ) { notifyChange = aNotifyChange; }
 
   protected int followUpStatusCache;
   public    int getFollowUpStatusCache() { return( followUpStatusCache ); }
   public     void setFollowUpStatusCache( int aFollowUpStatusCache ) { followUpStatusCache = aFollowUpStatusCache; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityGroupDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "EntityGroupDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityGroupDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "EntityGroupDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityGroupDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "EntityGroupDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityGroupDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "EntityGroupDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityGroupDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "EntityGroupDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityGroupDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "EntityGroupDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 13 ];
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "ENTITYGROUP.GROUPNUM", "ENTITYGROUP", "groupNum" );
      dbColumns[1] = new ServletIntColumn( aDbData, "ENTITYGROUP.ALIASOF", "ENTITYGROUP", "aliasOf" );
      dbColumns[2] = new ServletIntColumn( aDbData, "ENTITYGROUP.TYPE", "ENTITYGROUP", "type" );
      dbColumns[3] = new ServletStringColumn( aDbData, "ENTITYGROUP.NAME", "ENTITYGROUP", "name" );
      if ( name == null ) name = ((ServletStringColumn)dbColumns[3]).getValue(); // if it hasn't already been initialized...
      dbColumns[4] = new ServletStringColumn( aDbData, "ENTITYGROUP.EXTNAME", "ENTITYGROUP", "extName" );
      if ( extName == null ) extName = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
      dbColumns[5] = new ServletStringColumn( aDbData, "ENTITYGROUP.DESCRIPTION", "ENTITYGROUP", "description" );
      if ( description == null ) description = ((ServletStringColumn)dbColumns[5]).getValue(); // if it hasn't already been initialized...
      dbColumns[6] = new ServletIntColumn( aDbData, "ENTITYGROUP.STATUS", "ENTITYGROUP", "status" );
      dbColumns[7] = new ServletIntColumn( aDbData, "ENTITYGROUP.CATEGORY", "ENTITYGROUP", "category" );
      dbColumns[8] = new ServletIntColumn( aDbData, "ENTITYGROUP.NOTIFYGROUP", "ENTITYGROUP", "notifyGroup" );
      dbColumns[9] = new ServletDateColumn( aDbData, "ENTITYGROUP.CREATEDATE", "ENTITYGROUP", "createDate" );
      if ( createDate == null ) createDate = ((ServletDateColumn)dbColumns[9]).getValue(); // if it hasn't already been initialized...
      dbColumns[10] = new ServletTimestampColumn( aDbData, "ENTITYGROUP.LASTUPDATE", "ENTITYGROUP", "lastUpdate" );
      if ( lastUpdate == null ) lastUpdate = ((ServletTimestampColumn)dbColumns[10]).getValue(); // if it hasn't already been initialized...
      dbColumns[11] = new ServletIntColumn( aDbData, "ENTITYGROUP.NOTIFYCHANGE", "ENTITYGROUP", "notifyChange" );
      dbColumns[12] = new ServletIntColumn( aDbData, "ENTITYGROUP.FOLLOWUPSTATUSCACHE", "ENTITYGROUP", "followUpStatusCache" );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      groupNum = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      aliasOf = ((ServletIntColumn)dbColumns[1]).getValue();
      type = ((ServletIntColumn)dbColumns[2]).getValue();
      name = ((ServletStringColumn)dbColumns[3]).getValue();
      extName = ((ServletStringColumn)dbColumns[4]).getValue();
      description = ((ServletStringColumn)dbColumns[5]).getValue();
      status = ((ServletIntColumn)dbColumns[6]).getValue();
      category = ((ServletIntColumn)dbColumns[7]).getValue();
      notifyGroup = ((ServletIntColumn)dbColumns[8]).getValue();
      createDate = ((ServletDateColumn)dbColumns[9]).getValue();
      lastUpdate = ((ServletTimestampColumn)dbColumns[10]).getValue();
      notifyChange = ((ServletIntColumn)dbColumns[11]).getValue();
      followUpStatusCache = ((ServletIntColumn)dbColumns[12]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( groupNum );
      ((ServletIntColumn)dbColumns[1]).setValue( aliasOf );
      ((ServletIntColumn)dbColumns[2]).setValue( type );
      ((ServletStringColumn)dbColumns[3]).setValue( name );
      ((ServletStringColumn)dbColumns[4]).setValue( extName );
      ((ServletStringColumn)dbColumns[5]).setValue( description );
      ((ServletIntColumn)dbColumns[6]).setValue( status );
      ((ServletIntColumn)dbColumns[7]).setValue( category );
      ((ServletIntColumn)dbColumns[8]).setValue( notifyGroup );
      ((ServletDateColumn)dbColumns[9]).setValue( createDate );
      ((ServletTimestampColumn)dbColumns[10]).setValue( lastUpdate );
      ((ServletIntColumn)dbColumns[11]).setValue( notifyChange );
      ((ServletIntColumn)dbColumns[12]).setValue( followUpStatusCache );
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
      String retString = "\n" + prefix + "EntityGroup Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    groupNum (ENTITYGROUP.GROUPNUM) -- ";
         retString += "localVar=\"" + Integer.toString( groupNum) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    aliasOf (ENTITYGROUP.ALIASOF) -- ";
         retString += "localVar=\"" + Integer.toString( aliasOf) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    type (ENTITYGROUP.TYPE) -- ";
         retString += "localVar=\"" + Integer.toString( type) + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    name (ENTITYGROUP.NAME) -- ";
         retString += "localVar=\"" + name.toString() + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    extName (ENTITYGROUP.EXTNAME) -- ";
         retString += "localVar=\"" + extName.toString() + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    description (ENTITYGROUP.DESCRIPTION) -- ";
         retString += "localVar=\"" + description.toString() + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    status (ENTITYGROUP.STATUS) -- ";
         retString += "localVar=\"" + Integer.toString( status) + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    category (ENTITYGROUP.CATEGORY) -- ";
         retString += "localVar=\"" + Integer.toString( category) + "\";  ";
         retString += dbColumns[7].toString();
         retString += "\n"+ prefix +   "    notifyGroup (ENTITYGROUP.NOTIFYGROUP) -- ";
         retString += "localVar=\"" + Integer.toString( notifyGroup) + "\";  ";
         retString += dbColumns[8].toString();
         retString += "\n"+ prefix +   "    createDate (ENTITYGROUP.CREATEDATE) -- ";
         retString += "localVar=\"" + createDate.toString() + "\";  ";
         retString += dbColumns[9].toString();
         retString += "\n"+ prefix +   "    lastUpdate (ENTITYGROUP.LASTUPDATE) -- ";
         retString += "localVar=\"" + lastUpdate.toString() + "\";  ";
         retString += dbColumns[10].toString();
         retString += "\n"+ prefix +   "    notifyChange (ENTITYGROUP.NOTIFYCHANGE) -- ";
         retString += "localVar=\"" + Integer.toString( notifyChange) + "\";  ";
         retString += dbColumns[11].toString();
         retString += "\n"+ prefix +   "    followUpStatusCache (ENTITYGROUP.FOLLOWUPSTATUSCACHE) -- ";
         retString += "localVar=\"" + Integer.toString( followUpStatusCache) + "\";  ";
         retString += dbColumns[12].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(EntityGroupViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showGroupNum ) retString += commaSeparator(retString) + "groupNum" + ndxSuffix;
         if( viewDef.showAliasOf ) retString += commaSeparator(retString) + "aliasOf" + ndxSuffix;
         if( viewDef.showType ) retString += commaSeparator(retString) + "type" + ndxSuffix;
         if( viewDef.showName ) retString += commaSeparator(retString) + "name" + ndxSuffix;
         if( viewDef.showExtName ) retString += commaSeparator(retString) + "extName" + ndxSuffix;
         if( viewDef.showDescription ) retString += commaSeparator(retString) + "description" + ndxSuffix;
         if( viewDef.showStatus ) retString += commaSeparator(retString) + "status" + ndxSuffix;
         if( viewDef.showCategory ) retString += commaSeparator(retString) + "category" + ndxSuffix;
         if( viewDef.showNotifyGroup ) retString += commaSeparator(retString) + "notifyGroup" + ndxSuffix;
         if( viewDef.showCreateDate ) retString += commaSeparator(retString) + "createDate" + ndxSuffix;
         if( viewDef.showLastUpdate ) retString += commaSeparator(retString) + "lastUpdate" + ndxSuffix;
         if( viewDef.showNotifyChange ) retString += commaSeparator(retString) + "notifyChange" + ndxSuffix;
         if( viewDef.showFollowUpStatusCache ) retString += commaSeparator(retString) + "followUpStatusCache" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(EntityGroupViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showGroupNum ) retString += commaSeparator(retString) + CSVCell( groupNum);
         if( viewDef.showAliasOf ) retString += commaSeparator(retString) + CSVCell( aliasOf);
         if( viewDef.showType ) retString += commaSeparator(retString) + CSVCell( type);
         if( viewDef.showName ) retString += commaSeparator(retString) + CSVCell( name);
         if( viewDef.showExtName ) retString += commaSeparator(retString) + CSVCell( extName);
         if( viewDef.showDescription ) retString += commaSeparator(retString) + CSVCell( description);
         if( viewDef.showStatus ) retString += commaSeparator(retString) + CSVCell( status);
         if( viewDef.showCategory ) retString += commaSeparator(retString) + CSVCell( category);
         if( viewDef.showNotifyGroup ) retString += commaSeparator(retString) + CSVCell( notifyGroup);
         if( viewDef.showCreateDate ) retString += commaSeparator(retString) + CSVCell( createDate);
         if( viewDef.showLastUpdate ) retString += commaSeparator(retString) + CSVCell( lastUpdate);
         if( viewDef.showNotifyChange ) retString += commaSeparator(retString) + CSVCell( notifyChange);
         if( viewDef.showFollowUpStatusCache ) retString += commaSeparator(retString) + CSVCell( followUpStatusCache);
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
      sysLogger.info( "DROP TABLE ENTITYGROUP;" );
      sysLogger.info( "CREATE TABLE ENTITYGROUP ( ENTITYGROUP.GROUPNUM integer, ENTITYGROUP.ALIASOF integer, ENTITYGROUP.TYPE integer, ENTITYGROUP.NAME char(60), ENTITYGROUP.EXTNAME char(60), ENTITYGROUP.DESCRIPTION char(100), ENTITYGROUP.STATUS integer, ENTITYGROUP.CATEGORY integer, ENTITYGROUP.NOTIFYGROUP integer, ENTITYGROUP.CREATEDATE Date, ENTITYGROUP.LASTUPDATE timestamp, ENTITYGROUP.NOTIFYCHANGE integer, ENTITYGROUP.FOLLOWUPSTATUSCACHE integer );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "EntityGroup Object:";
      retString += "\n    groupNum (ENTITYGROUP.GROUPNUM) -- ";
      retString += "localVar=\"" + Integer.toString( groupNum) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    aliasOf (ENTITYGROUP.ALIASOF) -- ";
      retString += "localVar=\"" + Integer.toString( aliasOf) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    type (ENTITYGROUP.TYPE) -- ";
      retString += "localVar=\"" + Integer.toString( type) + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    name (ENTITYGROUP.NAME) -- ";
      retString += "localVar=\"" + name.toString() + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    extName (ENTITYGROUP.EXTNAME) -- ";
      retString += "localVar=\"" + extName.toString() + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    description (ENTITYGROUP.DESCRIPTION) -- ";
      retString += "localVar=\"" + description.toString() + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    status (ENTITYGROUP.STATUS) -- ";
      retString += "localVar=\"" + Integer.toString( status) + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    category (ENTITYGROUP.CATEGORY) -- ";
      retString += "localVar=\"" + Integer.toString( category) + "\";  ";
      retString += dbColumns[7].toString();
      retString += "\n    notifyGroup (ENTITYGROUP.NOTIFYGROUP) -- ";
      retString += "localVar=\"" + Integer.toString( notifyGroup) + "\";  ";
      retString += dbColumns[8].toString();
      retString += "\n    createDate (ENTITYGROUP.CREATEDATE) -- ";
      retString += "localVar=\"" + createDate.toString() + "\";  ";
      retString += dbColumns[9].toString();
      retString += "\n    lastUpdate (ENTITYGROUP.LASTUPDATE) -- ";
      retString += "localVar=\"" + lastUpdate.toString() + "\";  ";
      retString += dbColumns[10].toString();
      retString += "\n    notifyChange (ENTITYGROUP.NOTIFYCHANGE) -- ";
      retString += "localVar=\"" + Integer.toString( notifyChange) + "\";  ";
      retString += dbColumns[11].toString();
      retString += "\n    followUpStatusCache (ENTITYGROUP.FOLLOWUPSTATUSCACHE) -- ";
      retString += "localVar=\"" + Integer.toString( followUpStatusCache) + "\";  ";
      retString += dbColumns[12].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "name", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "extName", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "description", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "createDate", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "lastUpdate", label ); 
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
