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
 
public class GroupCategoryDBRecordBase extends ServletRecord
{
 
   public static final int ID = 0;
   public static final int NAME = 1;
   public static final int DESCRIPTION = 2;
   public static final int CONTAINS = 3;
   public static final int DETAILSURL = 4;
   public static final int STATUS = 5;
   public static final int UPDATETYPE = 6;
 
   public static final String[] COLNAME = {
                                             "GROUPCATEGORY.ID",
                                             "GROUPCATEGORY.NAME",
                                             "GROUPCATEGORY.DESCRIPTION",
                                             "GROUPCATEGORY.CONTAINS",
                                             "GROUPCATEGORY.DETAILSURL",
                                             "GROUPCATEGORY.STATUS",
                                             "GROUPCATEGORY.UPDATETYPE"
                                                    };
 
   protected int id;
   public    int getId() { return( id ); }
   public     void setId( int aId ) { id = aId; }
 
   protected String name = "";
   public    String getName() { return( name ); }
   public     void setName( String aName ) { name = aName; }
 
   protected String description = "";
   public    String getDescription() { return( description ); }
   public     void setDescription( String aDescription ) { description = aDescription; }
 
   protected int contains;
   public    int getContains() { return( contains ); }
   public     void setContains( int aContains ) { contains = aContains; }
 
   protected String detailsURL = "";
   public    String getDetailsURL() { return( detailsURL ); }
   public     void setDetailsURL( String aDetailsURL ) { detailsURL = aDetailsURL; }
 
   protected int status;
   public    int getStatus() { return( status ); }
   public     void setStatus( int aStatus ) { status = aStatus; }
 
   protected int updateType;
   public    int getUpdateType() { return( updateType ); }
   public     void setUpdateType( int aUpdateType ) { updateType = aUpdateType; }
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public GroupCategoryDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "GroupCategoryDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public GroupCategoryDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "GroupCategoryDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public GroupCategoryDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "GroupCategoryDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public GroupCategoryDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "GroupCategoryDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public GroupCategoryDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "GroupCategoryDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public GroupCategoryDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "GroupCategoryDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 7 ];
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "GROUPCATEGORY.ID", "GROUPCATEGORY", "id" );
      dbColumns[1] = new ServletStringColumn( aDbData, "GROUPCATEGORY.NAME", "GROUPCATEGORY", "name" );
      if ( name == null ) name = ((ServletStringColumn)dbColumns[1]).getValue(); // if it hasn't already been initialized...
      dbColumns[2] = new ServletStringColumn( aDbData, "GROUPCATEGORY.DESCRIPTION", "GROUPCATEGORY", "description" );
      if ( description == null ) description = ((ServletStringColumn)dbColumns[2]).getValue(); // if it hasn't already been initialized...
      dbColumns[3] = new ServletIntColumn( aDbData, "GROUPCATEGORY.CONTAINS", "GROUPCATEGORY", "contains" );
      dbColumns[4] = new ServletStringColumn( aDbData, "GROUPCATEGORY.DETAILSURL", "GROUPCATEGORY", "detailsURL" );
      if ( detailsURL == null ) detailsURL = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
      dbColumns[5] = new ServletIntColumn( aDbData, "GROUPCATEGORY.STATUS", "GROUPCATEGORY", "status" );
      dbColumns[6] = new ServletIntColumn( aDbData, "GROUPCATEGORY.UPDATETYPE", "GROUPCATEGORY", "updateType" );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      id = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      name = ((ServletStringColumn)dbColumns[1]).getValue();
      description = ((ServletStringColumn)dbColumns[2]).getValue();
      contains = ((ServletIntColumn)dbColumns[3]).getValue();
      detailsURL = ((ServletStringColumn)dbColumns[4]).getValue();
      status = ((ServletIntColumn)dbColumns[5]).getValue();
      updateType = ((ServletIntColumn)dbColumns[6]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( id );
      ((ServletStringColumn)dbColumns[1]).setValue( name );
      ((ServletStringColumn)dbColumns[2]).setValue( description );
      ((ServletIntColumn)dbColumns[3]).setValue( contains );
      ((ServletStringColumn)dbColumns[4]).setValue( detailsURL );
      ((ServletIntColumn)dbColumns[5]).setValue( status );
      ((ServletIntColumn)dbColumns[6]).setValue( updateType );
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
      String retString = "\n" + prefix + "GroupCategory Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    id (GROUPCATEGORY.ID) -- ";
         retString += "localVar=\"" + Integer.toString( id) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    name (GROUPCATEGORY.NAME) -- ";
         retString += "localVar=\"" + name.toString() + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    description (GROUPCATEGORY.DESCRIPTION) -- ";
         retString += "localVar=\"" + description.toString() + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    contains (GROUPCATEGORY.CONTAINS) -- ";
         retString += "localVar=\"" + Integer.toString( contains) + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    detailsURL (GROUPCATEGORY.DETAILSURL) -- ";
         retString += "localVar=\"" + detailsURL.toString() + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    status (GROUPCATEGORY.STATUS) -- ";
         retString += "localVar=\"" + Integer.toString( status) + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    updateType (GROUPCATEGORY.UPDATETYPE) -- ";
         retString += "localVar=\"" + Integer.toString( updateType) + "\";  ";
         retString += dbColumns[6].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(GroupCategoryViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + "id" + ndxSuffix;
         if( viewDef.showName ) retString += commaSeparator(retString) + "name" + ndxSuffix;
         if( viewDef.showDescription ) retString += commaSeparator(retString) + "description" + ndxSuffix;
         if( viewDef.showContains ) retString += commaSeparator(retString) + "contains" + ndxSuffix;
         if( viewDef.showDetailsURL ) retString += commaSeparator(retString) + "detailsURL" + ndxSuffix;
         if( viewDef.showStatus ) retString += commaSeparator(retString) + "status" + ndxSuffix;
         if( viewDef.showUpdateType ) retString += commaSeparator(retString) + "updateType" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(GroupCategoryViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + CSVCell( id);
         if( viewDef.showName ) retString += commaSeparator(retString) + CSVCell( name);
         if( viewDef.showDescription ) retString += commaSeparator(retString) + CSVCell( description);
         if( viewDef.showContains ) retString += commaSeparator(retString) + CSVCell( contains);
         if( viewDef.showDetailsURL ) retString += commaSeparator(retString) + CSVCell( detailsURL);
         if( viewDef.showStatus ) retString += commaSeparator(retString) + CSVCell( status);
         if( viewDef.showUpdateType ) retString += commaSeparator(retString) + CSVCell( updateType);
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
      sysLogger.info( "DROP TABLE GROUPCATEGORY;" );
      sysLogger.info( "CREATE TABLE GROUPCATEGORY ( GROUPCATEGORY.ID integer, GROUPCATEGORY.NAME char(60), GROUPCATEGORY.DESCRIPTION char(100), GROUPCATEGORY.CONTAINS integer, GROUPCATEGORY.DETAILSURL char(150), GROUPCATEGORY.STATUS integer, GROUPCATEGORY.UPDATETYPE integer );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "GroupCategory Object:";
      retString += "\n    id (GROUPCATEGORY.ID) -- ";
      retString += "localVar=\"" + Integer.toString( id) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    name (GROUPCATEGORY.NAME) -- ";
      retString += "localVar=\"" + name.toString() + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    description (GROUPCATEGORY.DESCRIPTION) -- ";
      retString += "localVar=\"" + description.toString() + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    contains (GROUPCATEGORY.CONTAINS) -- ";
      retString += "localVar=\"" + Integer.toString( contains) + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    detailsURL (GROUPCATEGORY.DETAILSURL) -- ";
      retString += "localVar=\"" + detailsURL.toString() + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    status (GROUPCATEGORY.STATUS) -- ";
      retString += "localVar=\"" + Integer.toString( status) + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    updateType (GROUPCATEGORY.UPDATETYPE) -- ";
      retString += "localVar=\"" + Integer.toString( updateType) + "\";  ";
      retString += dbColumns[6].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "name", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "description", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "detailsURL", label ); 
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
