package jwm.wgbe.model.db;
 
import jwm.db.*;
import jwm.servletdb.*;
import jwm.wgbe.model.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;
 
public class CategoryDBRecordBase extends ServletRecord
{
 
   public static final int NAME = 0;
   public static final int KEYWORDS = 1;
   public static final int IMAGETAG = 2;
   public static final int URL = 3;
   public static final int SELECTEDTEXT = 4;
 
   public static final String[] COLNAME = {
                                             "CATEGORY.NAME",
                                             "CATEGORY.KEYWORDS",
                                             "CATEGORY.IMAGETAG",
                                             "CATEGORY.URL",
                                             "CATEGORY.SELECTEDTEXT"
                                                    };
 
   protected String name = "";
   public    String getName() { return( name ); }
   public     void setName( String aName ) { name = aName; }
 
   protected String keywords = "";
   public    String getKeywords() { return( keywords ); }
   public     void setKeywords( String aKeywords ) { keywords = aKeywords; }
 
   protected String imageTag = "";
   public    String getImageTag() { return( imageTag ); }
   public     void setImageTag( String aImageTag ) { imageTag = aImageTag; }
 
   protected String url = "";
   public    String getUrl() { return( url ); }
   public     void setUrl( String aUrl ) { url = aUrl; }
 
   protected String selectedText = "";
   public    String getSelectedText() { return( selectedText ); }
   public     void setSelectedText( String aSelectedText ) { selectedText = aSelectedText; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public CategoryDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "CategoryDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public CategoryDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "CategoryDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public CategoryDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "CategoryDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public CategoryDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "CategoryDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public CategoryDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "CategoryDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public CategoryDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "CategoryDBRecordBase constructor from array");
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
      dbColumns[0] = new ServletStringColumn( aDbData, "CATEGORY.NAME", "CATEGORY", "name" );
      if ( name == null ) name = ((ServletStringColumn)dbColumns[0]).getValue(); // if it hasn't already been initialized...
      dbColumns[1] = new ServletStringColumn( aDbData, "CATEGORY.KEYWORDS", "CATEGORY", "keywords" );
      if ( keywords == null ) keywords = ((ServletStringColumn)dbColumns[1]).getValue(); // if it hasn't already been initialized...
      dbColumns[2] = new ServletStringColumn( aDbData, "CATEGORY.IMAGETAG", "CATEGORY", "imageTag" );
      if ( imageTag == null ) imageTag = ((ServletStringColumn)dbColumns[2]).getValue(); // if it hasn't already been initialized...
      dbColumns[3] = new ServletStringColumn( aDbData, "CATEGORY.URL", "CATEGORY", "url" );
      if ( url == null ) url = ((ServletStringColumn)dbColumns[3]).getValue(); // if it hasn't already been initialized...
      dbColumns[4] = new ServletStringColumn( aDbData, "CATEGORY.SELECTEDTEXT", "CATEGORY", "selectedText" );
      if ( selectedText == null ) selectedText = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      name = ((ServletStringColumn)dbColumns[0]).getValue();
      keywords = ((ServletStringColumn)dbColumns[1]).getValue();
      imageTag = ((ServletStringColumn)dbColumns[2]).getValue();
      url = ((ServletStringColumn)dbColumns[3]).getValue();
      selectedText = ((ServletStringColumn)dbColumns[4]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletStringColumn)dbColumns[0]).setValue( name );
      ((ServletStringColumn)dbColumns[1]).setValue( keywords );
      ((ServletStringColumn)dbColumns[2]).setValue( imageTag );
      ((ServletStringColumn)dbColumns[3]).setValue( url );
      ((ServletStringColumn)dbColumns[4]).setValue( selectedText );
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
      String retString = "\n" + prefix + "Category Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    name (CATEGORY.NAME) -- ";
         retString += "localVar=\"" + name.toString() + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    keywords (CATEGORY.KEYWORDS) -- ";
         retString += "localVar=\"" + keywords.toString() + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    imageTag (CATEGORY.IMAGETAG) -- ";
         retString += "localVar=\"" + imageTag.toString() + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    url (CATEGORY.URL) -- ";
         retString += "localVar=\"" + url.toString() + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    selectedText (CATEGORY.SELECTEDTEXT) -- ";
         retString += "localVar=\"" + selectedText.toString() + "\";  ";
         retString += dbColumns[4].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(CategoryViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showName ) retString += commaSeparator(retString) + "name" + ndxSuffix;
         if( viewDef.showKeywords ) retString += commaSeparator(retString) + "keywords" + ndxSuffix;
         if( viewDef.showImageTag ) retString += commaSeparator(retString) + "imageTag" + ndxSuffix;
         if( viewDef.showUrl ) retString += commaSeparator(retString) + "url" + ndxSuffix;
         if( viewDef.showSelectedText ) retString += commaSeparator(retString) + "selectedText" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(CategoryViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showName ) retString += commaSeparator(retString) + CSVCell( name);
         if( viewDef.showKeywords ) retString += commaSeparator(retString) + CSVCell( keywords);
         if( viewDef.showImageTag ) retString += commaSeparator(retString) + CSVCell( imageTag);
         if( viewDef.showUrl ) retString += commaSeparator(retString) + CSVCell( url);
         if( viewDef.showSelectedText ) retString += commaSeparator(retString) + CSVCell( selectedText);
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
      sysLogger.info( "DROP TABLE CATEGORY;" );
      sysLogger.info( "CREATE TABLE CATEGORY ( CATEGORY.NAME char, CATEGORY.KEYWORDS char, CATEGORY.IMAGETAG char, CATEGORY.URL char, CATEGORY.SELECTEDTEXT char );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "Category Object:";
      retString += "\n    name (CATEGORY.NAME) -- ";
      retString += "localVar=\"" + name.toString() + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    keywords (CATEGORY.KEYWORDS) -- ";
      retString += "localVar=\"" + keywords.toString() + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    imageTag (CATEGORY.IMAGETAG) -- ";
      retString += "localVar=\"" + imageTag.toString() + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    url (CATEGORY.URL) -- ";
      retString += "localVar=\"" + url.toString() + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    selectedText (CATEGORY.SELECTEDTEXT) -- ";
      retString += "localVar=\"" + selectedText.toString() + "\";  ";
      retString += dbColumns[4].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "name", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "keywords", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "imageTag", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "url", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "selectedText", label ); 
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
