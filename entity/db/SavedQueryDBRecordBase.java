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
 
public class SavedQueryDBRecordBase extends ServletRecord
{
 
   public static final int QUERYID = 0;
   public static final int NAME = 1;
   public static final int QUERYSTRING = 2;
   public static final int QUERYTYPE = 3;
   public static final int SORTWEIGHT = 4;
   public static final int SELECTED = 5;
   public static final int VIEW = 6;
 
   public static final String[] COLNAME = {
                                             "SAVEDQUERY.QueryId",
                                             "SAVEDQUERY.Name",
                                             "SAVEDQUERY.QueryString",
                                             "SAVEDQUERY.QueryType",
                                             "SAVEDQUERY.SortWeight",
                                             "SAVEDQUERY.Selected",
                                             "SAVEDQUERY.View"
                                                    };
 
   protected int queryId;
   public    int getQueryId() { return( queryId ); }
   public     void setQueryId( int aQueryId ) { queryId = aQueryId; }
 
   protected String name = "";
   public    String getName() { return( name ); }
   public     void setName( String aName ) { name = aName; }
 
   protected String queryString = "";
   public    String getQueryString() { return( queryString ); }
   public     void setQueryString( String aQueryString ) { queryString = aQueryString; }
 
   protected int queryType;
   public    int getQueryType() { return( queryType ); }
   public     void setQueryType( int aQueryType ) { queryType = aQueryType; }
 
   protected int sortWeight;
   public    int getSortWeight() { return( sortWeight ); }
   public     void setSortWeight( int aSortWeight ) { sortWeight = aSortWeight; }
 
   protected int selected;
   public    int getSelected() { return( selected ); }
   public     void setSelected( int aSelected ) { selected = aSelected; }
 
   protected String view = "";
   public    String getView() { return( view ); }
   public     void setView( String aView ) { view = aView; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SavedQueryDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "SavedQueryDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SavedQueryDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "SavedQueryDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SavedQueryDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "SavedQueryDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SavedQueryDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "SavedQueryDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SavedQueryDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "SavedQueryDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SavedQueryDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "SavedQueryDBRecordBase constructor from array");
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
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "SAVEDQUERY.QueryId", "SAVEDQUERY", "queryId" );
      dbColumns[1] = new ServletStringColumn( aDbData, "SAVEDQUERY.Name", "SAVEDQUERY", "name" );
      if ( name == null ) name = ((ServletStringColumn)dbColumns[1]).getValue(); // if it hasn't already been initialized...
      dbColumns[2] = new ServletStringColumn( aDbData, "SAVEDQUERY.QueryString", "SAVEDQUERY", "queryString" );
      if ( queryString == null ) queryString = ((ServletStringColumn)dbColumns[2]).getValue(); // if it hasn't already been initialized...
      dbColumns[3] = new ServletIntColumn( aDbData, "SAVEDQUERY.QueryType", "SAVEDQUERY", "queryType" );
      dbColumns[4] = new ServletIntColumn( aDbData, "SAVEDQUERY.SortWeight", "SAVEDQUERY", "sortWeight" );
      dbColumns[5] = new ServletIntColumn( aDbData, "SAVEDQUERY.Selected", "SAVEDQUERY", "selected" );
      dbColumns[6] = new ServletStringColumn( aDbData, "SAVEDQUERY.View", "SAVEDQUERY", "view" );
      if ( view == null ) view = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      queryId = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      name = ((ServletStringColumn)dbColumns[1]).getValue();
      queryString = ((ServletStringColumn)dbColumns[2]).getValue();
      queryType = ((ServletIntColumn)dbColumns[3]).getValue();
      sortWeight = ((ServletIntColumn)dbColumns[4]).getValue();
      selected = ((ServletIntColumn)dbColumns[5]).getValue();
      view = ((ServletStringColumn)dbColumns[6]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( queryId );
      ((ServletStringColumn)dbColumns[1]).setValue( name );
      ((ServletStringColumn)dbColumns[2]).setValue( queryString );
      ((ServletIntColumn)dbColumns[3]).setValue( queryType );
      ((ServletIntColumn)dbColumns[4]).setValue( sortWeight );
      ((ServletIntColumn)dbColumns[5]).setValue( selected );
      ((ServletStringColumn)dbColumns[6]).setValue( view );
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
      String retString = "\n" + prefix + "SavedQuery Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    queryId (SAVEDQUERY.QueryId) -- ";
         retString += "localVar=\"" + Integer.toString( queryId) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    name (SAVEDQUERY.Name) -- ";
         retString += "localVar=\"" + name.toString() + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    queryString (SAVEDQUERY.QueryString) -- ";
         retString += "localVar=\"" + queryString.toString() + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    queryType (SAVEDQUERY.QueryType) -- ";
         retString += "localVar=\"" + Integer.toString( queryType) + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    sortWeight (SAVEDQUERY.SortWeight) -- ";
         retString += "localVar=\"" + Integer.toString( sortWeight) + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    selected (SAVEDQUERY.Selected) -- ";
         retString += "localVar=\"" + Integer.toString( selected) + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    view (SAVEDQUERY.View) -- ";
         retString += "localVar=\"" + view.toString() + "\";  ";
         retString += dbColumns[6].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(SavedQueryViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showQueryId ) retString += commaSeparator(retString) + "queryId" + ndxSuffix;
         if( viewDef.showName ) retString += commaSeparator(retString) + "name" + ndxSuffix;
         if( viewDef.showQueryString ) retString += commaSeparator(retString) + "queryString" + ndxSuffix;
         if( viewDef.showQueryType ) retString += commaSeparator(retString) + "queryType" + ndxSuffix;
         if( viewDef.showSortWeight ) retString += commaSeparator(retString) + "sortWeight" + ndxSuffix;
         if( viewDef.showSelected ) retString += commaSeparator(retString) + "selected" + ndxSuffix;
         if( viewDef.showView ) retString += commaSeparator(retString) + "view" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(SavedQueryViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showQueryId ) retString += commaSeparator(retString) + CSVCell( queryId);
         if( viewDef.showName ) retString += commaSeparator(retString) + CSVCell( name);
         if( viewDef.showQueryString ) retString += commaSeparator(retString) + CSVCell( queryString);
         if( viewDef.showQueryType ) retString += commaSeparator(retString) + CSVCell( queryType);
         if( viewDef.showSortWeight ) retString += commaSeparator(retString) + CSVCell( sortWeight);
         if( viewDef.showSelected ) retString += commaSeparator(retString) + CSVCell( selected);
         if( viewDef.showView ) retString += commaSeparator(retString) + CSVCell( view);
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
      sysLogger.info( "DROP TABLE SAVEDQUERY;" );
      sysLogger.info( "CREATE TABLE SAVEDQUERY ( SAVEDQUERY.QueryId integer, SAVEDQUERY.Name char, SAVEDQUERY.QueryString char, SAVEDQUERY.QueryType integer, SAVEDQUERY.SortWeight integer, SAVEDQUERY.Selected integer, SAVEDQUERY.View char );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "SavedQuery Object:";
      retString += "\n    queryId (SAVEDQUERY.QueryId) -- ";
      retString += "localVar=\"" + Integer.toString( queryId) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    name (SAVEDQUERY.Name) -- ";
      retString += "localVar=\"" + name.toString() + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    queryString (SAVEDQUERY.QueryString) -- ";
      retString += "localVar=\"" + queryString.toString() + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    queryType (SAVEDQUERY.QueryType) -- ";
      retString += "localVar=\"" + Integer.toString( queryType) + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    sortWeight (SAVEDQUERY.SortWeight) -- ";
      retString += "localVar=\"" + Integer.toString( sortWeight) + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    selected (SAVEDQUERY.Selected) -- ";
      retString += "localVar=\"" + Integer.toString( selected) + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    view (SAVEDQUERY.View) -- ";
      retString += "localVar=\"" + view.toString() + "\";  ";
      retString += dbColumns[6].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "name", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "queryString", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "view", label ); 
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
