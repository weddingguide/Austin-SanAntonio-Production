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
 
public class ContactStatusCategoryDBRecordBase extends ServletRecord
{
 
   public static final int ID = 0;
   public static final int NAME = 1;
   public static final int CSS = 2;
 
   public static final String[] COLNAME = {
                                             "CONTACTSTATUSCATEGORY.ID",
                                             "CONTACTSTATUSCATEGORY.name",
                                             "CONTACTSTATUSCATEGORY.css"
                                                    };
 
   protected int id;
   public    int getId() { return( id ); }
   public     void setId( int aId ) { id = aId; }
 
   protected String name = "";
   public    String getName() { return( name ); }
   public     void setName( String aName ) { name = aName; }
 
   protected String css = "";
   public    String getCss() { return( css ); }
   public     void setCss( String aCss ) { css = aCss; }
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactStatusCategoryDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "ContactStatusCategoryDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactStatusCategoryDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "ContactStatusCategoryDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactStatusCategoryDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "ContactStatusCategoryDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactStatusCategoryDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "ContactStatusCategoryDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactStatusCategoryDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "ContactStatusCategoryDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactStatusCategoryDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "ContactStatusCategoryDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 3 ];
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "CONTACTSTATUSCATEGORY.ID", "CONTACTSTATUSCATEGORY", "id" );
      dbColumns[1] = new ServletStringColumn( aDbData, "CONTACTSTATUSCATEGORY.name", "CONTACTSTATUSCATEGORY", "name" );
      if ( name == null ) name = ((ServletStringColumn)dbColumns[1]).getValue(); // if it hasn't already been initialized...
      dbColumns[2] = new ServletStringColumn( aDbData, "CONTACTSTATUSCATEGORY.css", "CONTACTSTATUSCATEGORY", "css" );
      if ( css == null ) css = ((ServletStringColumn)dbColumns[2]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      id = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      name = ((ServletStringColumn)dbColumns[1]).getValue();
      css = ((ServletStringColumn)dbColumns[2]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( id );
      ((ServletStringColumn)dbColumns[1]).setValue( name );
      ((ServletStringColumn)dbColumns[2]).setValue( css );
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
      String retString = "\n" + prefix + "ContactStatusCategory Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    id (CONTACTSTATUSCATEGORY.ID) -- ";
         retString += "localVar=\"" + Integer.toString( id) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    name (CONTACTSTATUSCATEGORY.name) -- ";
         retString += "localVar=\"" + name.toString() + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    css (CONTACTSTATUSCATEGORY.css) -- ";
         retString += "localVar=\"" + css.toString() + "\";  ";
         retString += dbColumns[2].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(ContactStatusCategoryViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + "id" + ndxSuffix;
         if( viewDef.showName ) retString += commaSeparator(retString) + "name" + ndxSuffix;
         if( viewDef.showCss ) retString += commaSeparator(retString) + "css" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(ContactStatusCategoryViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + CSVCell( id);
         if( viewDef.showName ) retString += commaSeparator(retString) + CSVCell( name);
         if( viewDef.showCss ) retString += commaSeparator(retString) + CSVCell( css);
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
      sysLogger.info( "DROP TABLE CONTACTSTATUSCATEGORY;" );
      sysLogger.info( "CREATE TABLE CONTACTSTATUSCATEGORY ( CONTACTSTATUSCATEGORY.ID integer, CONTACTSTATUSCATEGORY.name char, CONTACTSTATUSCATEGORY.css char );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "ContactStatusCategory Object:";
      retString += "\n    id (CONTACTSTATUSCATEGORY.ID) -- ";
      retString += "localVar=\"" + Integer.toString( id) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    name (CONTACTSTATUSCATEGORY.name) -- ";
      retString += "localVar=\"" + name.toString() + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    css (CONTACTSTATUSCATEGORY.css) -- ";
      retString += "localVar=\"" + css.toString() + "\";  ";
      retString += dbColumns[2].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "name", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "css", label ); 
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
