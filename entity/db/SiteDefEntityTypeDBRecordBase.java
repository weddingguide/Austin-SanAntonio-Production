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
 
public class SiteDefEntityTypeDBRecordBase extends ServletRecord
{
 
   public static final int ID = 0;
   public static final int ENTITYTYPE = 1;
   public static final int NAME = 2;
   public static final int SEARCHDEFAULT = 3;
   public static final int MATCHENTITYSTATUS = 4;
 
   public static final String[] COLNAME = {
                                             "SITEDEFENTITYTYPE.ID",
                                             "SITEDEFENTITYTYPE.ENTITYTYPE",
                                             "SITEDEFENTITYTYPE.NAME",
                                             "SITEDEFENTITYTYPE.searchDefault",
                                             "SITEDEFENTITYTYPE.matchEntityStatus"
                                                    };
 
   protected int id;
   public    int getId() { return( id ); }
   public     void setId( int aId ) { id = aId; }
 
   protected int entityType;
   public    int getEntityType() { return( entityType ); }
   public     void setEntityType( int aEntityType ) { entityType = aEntityType; }
 
   protected String name = "";
   public    String getName() { return( name ); }
   public     void setName( String aName ) { name = aName; }
 
   protected int searchDefault;
   public    int getSearchDefault() { return( searchDefault ); }
   public     void setSearchDefault( int aSearchDefault ) { searchDefault = aSearchDefault; }
 
   protected int matchEntityStatus;
   public    int getMatchEntityStatus() { return( matchEntityStatus ); }
   public     void setMatchEntityStatus( int aMatchEntityStatus ) { matchEntityStatus = aMatchEntityStatus; }
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SiteDefEntityTypeDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "SiteDefEntityTypeDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SiteDefEntityTypeDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "SiteDefEntityTypeDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SiteDefEntityTypeDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "SiteDefEntityTypeDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SiteDefEntityTypeDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "SiteDefEntityTypeDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SiteDefEntityTypeDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "SiteDefEntityTypeDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SiteDefEntityTypeDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "SiteDefEntityTypeDBRecordBase constructor from array");
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
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "SITEDEFENTITYTYPE.ID", "SITEDEFENTITYTYPE", "id" );
      dbColumns[1] = new ServletIntColumn( aDbData, "SITEDEFENTITYTYPE.ENTITYTYPE", "SITEDEFENTITYTYPE", "entityType" );
      dbColumns[2] = new ServletStringColumn( aDbData, "SITEDEFENTITYTYPE.NAME", "SITEDEFENTITYTYPE", "name" );
      if ( name == null ) name = ((ServletStringColumn)dbColumns[2]).getValue(); // if it hasn't already been initialized...
      dbColumns[3] = new ServletBoolIntColumn( aDbData, "SITEDEFENTITYTYPE.searchDefault", "SITEDEFENTITYTYPE", "searchDefault" );
      dbColumns[4] = new ServletIntColumn( aDbData, "SITEDEFENTITYTYPE.matchEntityStatus", "SITEDEFENTITYTYPE", "matchEntityStatus" );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      id = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      entityType = ((ServletIntColumn)dbColumns[1]).getValue();
      name = ((ServletStringColumn)dbColumns[2]).getValue();
      searchDefault = ((ServletBoolIntColumn)dbColumns[3]).getValue();
      matchEntityStatus = ((ServletIntColumn)dbColumns[4]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( id );
      ((ServletIntColumn)dbColumns[1]).setValue( entityType );
      ((ServletStringColumn)dbColumns[2]).setValue( name );
      ((ServletBoolIntColumn)dbColumns[3]).setValue( searchDefault );
      ((ServletIntColumn)dbColumns[4]).setValue( matchEntityStatus );
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
      String retString = "\n" + prefix + "SiteDefEntityType Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    id (SITEDEFENTITYTYPE.ID) -- ";
         retString += "localVar=\"" + Integer.toString( id) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    entityType (SITEDEFENTITYTYPE.ENTITYTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( entityType) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    name (SITEDEFENTITYTYPE.NAME) -- ";
         retString += "localVar=\"" + name.toString() + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    searchDefault (SITEDEFENTITYTYPE.searchDefault) -- ";
         retString += "localVar=\"" + Integer.toString( searchDefault) + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    matchEntityStatus (SITEDEFENTITYTYPE.matchEntityStatus) -- ";
         retString += "localVar=\"" + Integer.toString( matchEntityStatus) + "\";  ";
         retString += dbColumns[4].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(SiteDefEntityTypeViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + "id" + ndxSuffix;
         if( viewDef.showEntityType ) retString += commaSeparator(retString) + "entityType" + ndxSuffix;
         if( viewDef.showName ) retString += commaSeparator(retString) + "name" + ndxSuffix;
         if( viewDef.showSearchDefault ) retString += commaSeparator(retString) + "searchDefault" + ndxSuffix;
         if( viewDef.showMatchEntityStatus ) retString += commaSeparator(retString) + "matchEntityStatus" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(SiteDefEntityTypeViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + CSVCell( id);
         if( viewDef.showEntityType ) retString += commaSeparator(retString) + CSVCell( entityType);
         if( viewDef.showName ) retString += commaSeparator(retString) + CSVCell( name);
         if( viewDef.showSearchDefault ) retString += commaSeparator(retString) + CSVCell( searchDefault);
         if( viewDef.showMatchEntityStatus ) retString += commaSeparator(retString) + CSVCell( matchEntityStatus);
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
      sysLogger.info( "DROP TABLE SITEDEFENTITYTYPE;" );
      sysLogger.info( "CREATE TABLE SITEDEFENTITYTYPE ( SITEDEFENTITYTYPE.ID integer, SITEDEFENTITYTYPE.ENTITYTYPE integer, SITEDEFENTITYTYPE.NAME char(100), SITEDEFENTITYTYPE.searchDefault integer, SITEDEFENTITYTYPE.matchEntityStatus integer );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "SiteDefEntityType Object:";
      retString += "\n    id (SITEDEFENTITYTYPE.ID) -- ";
      retString += "localVar=\"" + Integer.toString( id) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    entityType (SITEDEFENTITYTYPE.ENTITYTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( entityType) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    name (SITEDEFENTITYTYPE.NAME) -- ";
      retString += "localVar=\"" + name.toString() + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    searchDefault (SITEDEFENTITYTYPE.searchDefault) -- ";
      retString += "localVar=\"" + Integer.toString( searchDefault) + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    matchEntityStatus (SITEDEFENTITYTYPE.matchEntityStatus) -- ";
      retString += "localVar=\"" + Integer.toString( matchEntityStatus) + "\";  ";
      retString += dbColumns[4].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "name", label ); 
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
