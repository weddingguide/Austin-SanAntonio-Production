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
 
public class EntityCustomTextDBRecordBase extends ServletRecord
{
 
   public static final int ENTITYTYPE = 0;
   public static final int OBJECTTYPE = 1;
   public static final int INSTANCE = 2;
   public static final int LONGNAME = 3;
   public static final int SHORTNAME = 4;
 
   public static final String[] COLNAME = {
                                             "ENTITYCUSTOMTEXT.ENTITYTYPE",
                                             "ENTITYCUSTOMTEXT.OBJECTTYPE",
                                             "ENTITYCUSTOMTEXT.INSTANCE",
                                             "ENTITYCUSTOMTEXT.LONGNAME",
                                             "ENTITYCUSTOMTEXT.SHORTNAME"
                                                    };
 
   protected int entityType;
   public    int getEntityType() { return( entityType ); }
   public     void setEntityType( int aEntityType ) { entityType = aEntityType; }
 
   protected int objectType;
   public    int getObjectType() { return( objectType ); }
   public     void setObjectType( int aObjectType ) { objectType = aObjectType; }
 
   protected int instance;
   public    int getInstance() { return( instance ); }
   public     void setInstance( int aInstance ) { instance = aInstance; }
 
   protected String longName = "";
   public    String getLongName() { return( longName ); }
   public     void setLongName( String aLongName ) { longName = aLongName; }
 
   protected String shortName = "";
   public    String getShortName() { return( shortName ); }
   public     void setShortName( String aShortName ) { shortName = aShortName; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityCustomTextDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "EntityCustomTextDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityCustomTextDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "EntityCustomTextDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityCustomTextDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "EntityCustomTextDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityCustomTextDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "EntityCustomTextDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityCustomTextDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "EntityCustomTextDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityCustomTextDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "EntityCustomTextDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 5 ];
      dbColumns[0] = new ServletIntColumn( aDbData, "ENTITYCUSTOMTEXT.ENTITYTYPE", "ENTITYCUSTOMTEXT", "entityType" );
      dbColumns[1] = new ServletIntColumn( aDbData, "ENTITYCUSTOMTEXT.OBJECTTYPE", "ENTITYCUSTOMTEXT", "objectType" );
      dbColumns[2] = new ServletIntColumn( aDbData, "ENTITYCUSTOMTEXT.INSTANCE", "ENTITYCUSTOMTEXT", "instance" );
      dbColumns[3] = new ServletStringColumn( aDbData, "ENTITYCUSTOMTEXT.LONGNAME", "ENTITYCUSTOMTEXT", "longName" );
      if ( longName == null ) longName = ((ServletStringColumn)dbColumns[3]).getValue(); // if it hasn't already been initialized...
      dbColumns[4] = new ServletStringColumn( aDbData, "ENTITYCUSTOMTEXT.SHORTNAME", "ENTITYCUSTOMTEXT", "shortName" );
      if ( shortName == null ) shortName = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      entityType = ((ServletIntColumn)dbColumns[0]).getValue();
      objectType = ((ServletIntColumn)dbColumns[1]).getValue();
      instance = ((ServletIntColumn)dbColumns[2]).getValue();
      longName = ((ServletStringColumn)dbColumns[3]).getValue();
      shortName = ((ServletStringColumn)dbColumns[4]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletIntColumn)dbColumns[0]).setValue( entityType );
      ((ServletIntColumn)dbColumns[1]).setValue( objectType );
      ((ServletIntColumn)dbColumns[2]).setValue( instance );
      ((ServletStringColumn)dbColumns[3]).setValue( longName );
      ((ServletStringColumn)dbColumns[4]).setValue( shortName );
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
      String retString = "\n" + prefix + "EntityCustomText Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    entityType (ENTITYCUSTOMTEXT.ENTITYTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( entityType) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    objectType (ENTITYCUSTOMTEXT.OBJECTTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( objectType) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    instance (ENTITYCUSTOMTEXT.INSTANCE) -- ";
         retString += "localVar=\"" + Integer.toString( instance) + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    longName (ENTITYCUSTOMTEXT.LONGNAME) -- ";
         retString += "localVar=\"" + longName.toString() + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    shortName (ENTITYCUSTOMTEXT.SHORTNAME) -- ";
         retString += "localVar=\"" + shortName.toString() + "\";  ";
         retString += dbColumns[4].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(EntityCustomTextViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showEntityType ) retString += commaSeparator(retString) + "entityType" + ndxSuffix;
         if( viewDef.showObjectType ) retString += commaSeparator(retString) + "objectType" + ndxSuffix;
         if( viewDef.showInstance ) retString += commaSeparator(retString) + "instance" + ndxSuffix;
         if( viewDef.showLongName ) retString += commaSeparator(retString) + "longName" + ndxSuffix;
         if( viewDef.showShortName ) retString += commaSeparator(retString) + "shortName" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(EntityCustomTextViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showEntityType ) retString += commaSeparator(retString) + CSVCell( entityType);
         if( viewDef.showObjectType ) retString += commaSeparator(retString) + CSVCell( objectType);
         if( viewDef.showInstance ) retString += commaSeparator(retString) + CSVCell( instance);
         if( viewDef.showLongName ) retString += commaSeparator(retString) + CSVCell( longName);
         if( viewDef.showShortName ) retString += commaSeparator(retString) + CSVCell( shortName);
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
      sysLogger.info( "DROP TABLE ENTITYCUSTOMTEXT;" );
      sysLogger.info( "CREATE TABLE ENTITYCUSTOMTEXT ( ENTITYCUSTOMTEXT.ENTITYTYPE integer, ENTITYCUSTOMTEXT.OBJECTTYPE integer, ENTITYCUSTOMTEXT.INSTANCE integer, ENTITYCUSTOMTEXT.LONGNAME char, ENTITYCUSTOMTEXT.SHORTNAME char );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "EntityCustomText Object:";
      retString += "\n    entityType (ENTITYCUSTOMTEXT.ENTITYTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( entityType) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    objectType (ENTITYCUSTOMTEXT.OBJECTTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( objectType) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    instance (ENTITYCUSTOMTEXT.INSTANCE) -- ";
      retString += "localVar=\"" + Integer.toString( instance) + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    longName (ENTITYCUSTOMTEXT.LONGNAME) -- ";
      retString += "localVar=\"" + longName.toString() + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    shortName (ENTITYCUSTOMTEXT.SHORTNAME) -- ";
      retString += "localVar=\"" + shortName.toString() + "\";  ";
      retString += dbColumns[4].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "longName", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "shortName", label ); 
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
