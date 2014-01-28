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
 
public class ContactStatusDBRecordBase extends ServletRecord
{
 
   public static final int ID = 0;
   public static final int CATEGORY = 1;
   public static final int NAME = 2;
   public static final int SORTWEIGHT = 3;
   public static final int TRACKCONTACTACTIVITY = 4;
   public static final int LISTCONTACTS = 5;
   public static final int DISPLAYINREPORT = 6;
 
   public static final String[] COLNAME = {
                                             "CONTACTSTATUS.ID",
                                             "CONTACTSTATUS.category",
                                             "CONTACTSTATUS.name",
                                             "CONTACTSTATUS.sortweight",
                                             "CONTACTSTATUS.trackContactActivity",
                                             "CONTACTSTATUS.listContacts",
                                             "CONTACTSTATUS.displayInReport"
                                                    };
 
   protected int id;
   public    int getId() { return( id ); }
   public     void setId( int aId ) { id = aId; }
 
   protected int category;
   public    int getCategory() { return( category ); }
   public     void setCategory( int aCategory ) { category = aCategory; }
 
   protected String name = "";
   public    String getName() { return( name ); }
   public     void setName( String aName ) { name = aName; }
 
   protected int sortWeight;
   public    int getSortWeight() { return( sortWeight ); }
   public     void setSortWeight( int aSortWeight ) { sortWeight = aSortWeight; }
 
   protected int trackContactActivity;
   public    int getTrackContactActivity() { return( trackContactActivity ); }
   public     void setTrackContactActivity( int aTrackContactActivity ) { trackContactActivity = aTrackContactActivity; }
 
   protected int listContacts;
   public    int getListContacts() { return( listContacts ); }
   public     void setListContacts( int aListContacts ) { listContacts = aListContacts; }
 
   protected int displayInReport;
   public    int getDisplayInReport() { return( displayInReport ); }
   public     void setDisplayInReport( int aDisplayInReport ) { displayInReport = aDisplayInReport; }
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactStatusDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "ContactStatusDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactStatusDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "ContactStatusDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactStatusDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "ContactStatusDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactStatusDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "ContactStatusDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactStatusDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "ContactStatusDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactStatusDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "ContactStatusDBRecordBase constructor from array");
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
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "CONTACTSTATUS.ID", "CONTACTSTATUS", "id" );
      dbColumns[1] = new ServletIntColumn( aDbData, "CONTACTSTATUS.category", "CONTACTSTATUS", "category" );
      dbColumns[2] = new ServletStringColumn( aDbData, "CONTACTSTATUS.name", "CONTACTSTATUS", "name" );
      if ( name == null ) name = ((ServletStringColumn)dbColumns[2]).getValue(); // if it hasn't already been initialized...
      dbColumns[3] = new ServletIntColumn( aDbData, "CONTACTSTATUS.sortweight", "CONTACTSTATUS", "sortWeight" );
      dbColumns[4] = new ServletIntColumn( aDbData, "CONTACTSTATUS.trackContactActivity", "CONTACTSTATUS", "trackContactActivity" );
      dbColumns[5] = new ServletIntColumn( aDbData, "CONTACTSTATUS.listContacts", "CONTACTSTATUS", "listContacts" );
      dbColumns[6] = new ServletIntColumn( aDbData, "CONTACTSTATUS.displayInReport", "CONTACTSTATUS", "displayInReport" );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      id = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      category = ((ServletIntColumn)dbColumns[1]).getValue();
      name = ((ServletStringColumn)dbColumns[2]).getValue();
      sortWeight = ((ServletIntColumn)dbColumns[3]).getValue();
      trackContactActivity = ((ServletIntColumn)dbColumns[4]).getValue();
      listContacts = ((ServletIntColumn)dbColumns[5]).getValue();
      displayInReport = ((ServletIntColumn)dbColumns[6]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( id );
      ((ServletIntColumn)dbColumns[1]).setValue( category );
      ((ServletStringColumn)dbColumns[2]).setValue( name );
      ((ServletIntColumn)dbColumns[3]).setValue( sortWeight );
      ((ServletIntColumn)dbColumns[4]).setValue( trackContactActivity );
      ((ServletIntColumn)dbColumns[5]).setValue( listContacts );
      ((ServletIntColumn)dbColumns[6]).setValue( displayInReport );
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
      String retString = "\n" + prefix + "ContactStatus Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    id (CONTACTSTATUS.ID) -- ";
         retString += "localVar=\"" + Integer.toString( id) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    category (CONTACTSTATUS.category) -- ";
         retString += "localVar=\"" + Integer.toString( category) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    name (CONTACTSTATUS.name) -- ";
         retString += "localVar=\"" + name.toString() + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    sortWeight (CONTACTSTATUS.sortweight) -- ";
         retString += "localVar=\"" + Integer.toString( sortWeight) + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    trackContactActivity (CONTACTSTATUS.trackContactActivity) -- ";
         retString += "localVar=\"" + Integer.toString( trackContactActivity) + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    listContacts (CONTACTSTATUS.listContacts) -- ";
         retString += "localVar=\"" + Integer.toString( listContacts) + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    displayInReport (CONTACTSTATUS.displayInReport) -- ";
         retString += "localVar=\"" + Integer.toString( displayInReport) + "\";  ";
         retString += dbColumns[6].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(ContactStatusViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + "id" + ndxSuffix;
         if( viewDef.showCategory ) retString += commaSeparator(retString) + "category" + ndxSuffix;
         if( viewDef.showName ) retString += commaSeparator(retString) + "name" + ndxSuffix;
         if( viewDef.showSortWeight ) retString += commaSeparator(retString) + "sortWeight" + ndxSuffix;
         if( viewDef.showTrackContactActivity ) retString += commaSeparator(retString) + "trackContactActivity" + ndxSuffix;
         if( viewDef.showListContacts ) retString += commaSeparator(retString) + "listContacts" + ndxSuffix;
         if( viewDef.showDisplayInReport ) retString += commaSeparator(retString) + "displayInReport" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(ContactStatusViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + CSVCell( id);
         if( viewDef.showCategory ) retString += commaSeparator(retString) + CSVCell( category);
         if( viewDef.showName ) retString += commaSeparator(retString) + CSVCell( name);
         if( viewDef.showSortWeight ) retString += commaSeparator(retString) + CSVCell( sortWeight);
         if( viewDef.showTrackContactActivity ) retString += commaSeparator(retString) + CSVCell( trackContactActivity);
         if( viewDef.showListContacts ) retString += commaSeparator(retString) + CSVCell( listContacts);
         if( viewDef.showDisplayInReport ) retString += commaSeparator(retString) + CSVCell( displayInReport);
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
      sysLogger.info( "DROP TABLE CONTACTSTATUS;" );
      sysLogger.info( "CREATE TABLE CONTACTSTATUS ( CONTACTSTATUS.ID integer, CONTACTSTATUS.category integer, CONTACTSTATUS.name char, CONTACTSTATUS.sortweight integer, CONTACTSTATUS.trackContactActivity integer, CONTACTSTATUS.listContacts integer, CONTACTSTATUS.displayInReport integer );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "ContactStatus Object:";
      retString += "\n    id (CONTACTSTATUS.ID) -- ";
      retString += "localVar=\"" + Integer.toString( id) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    category (CONTACTSTATUS.category) -- ";
      retString += "localVar=\"" + Integer.toString( category) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    name (CONTACTSTATUS.name) -- ";
      retString += "localVar=\"" + name.toString() + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    sortWeight (CONTACTSTATUS.sortweight) -- ";
      retString += "localVar=\"" + Integer.toString( sortWeight) + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    trackContactActivity (CONTACTSTATUS.trackContactActivity) -- ";
      retString += "localVar=\"" + Integer.toString( trackContactActivity) + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    listContacts (CONTACTSTATUS.listContacts) -- ";
      retString += "localVar=\"" + Integer.toString( listContacts) + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    displayInReport (CONTACTSTATUS.displayInReport) -- ";
      retString += "localVar=\"" + Integer.toString( displayInReport) + "\";  ";
      retString += dbColumns[6].toString();
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
