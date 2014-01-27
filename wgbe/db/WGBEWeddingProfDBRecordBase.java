package jwm.wgbe.db;
 
import jwm.db.*;
import jwm.servletdb.*;
import jwm.wgbe.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class WGBEWeddingProfDBRecordBase extends ServletRecord
{
 
   public static final int GROUPID = 0;
   public static final int WEDDINGPROFID = 1;
   public static final int SUMMARYTEXT = 2;
   public static final int DESCRIPTION = 3;
   public static final int IMAGE1 = 4;
   public static final int IMAGE2 = 5;
   public static final int IMAGE3 = 6;
 
   public static final String[] COLNAME = {
                                             "WGBEWEDDINGPROF.GROUPID",
                                             "WGBEWEDDINGPROF.WEDDINGPROFID",
                                             "WGBEWEDDINGPROF.SUMMARYTEXT",
                                             "WGBEWEDDINGPROF.DESCRIPTION",
                                             "WGBEWEDDINGPROF.IMAGE1",
                                             "WGBEWEDDINGPROF.IMAGE2",
                                             "WGBEWEDDINGPROF.IMAGE3"
                                                    };
 
   protected int groupId;
   public    int getGroupId() { return( groupId ); }
   public     void setGroupId( int aGroupId ) { groupId = aGroupId; }
 
   protected int weddingProfId;
   public    int getWeddingProfId() { return( weddingProfId ); }
   public     void setWeddingProfId( int aWeddingProfId ) { weddingProfId = aWeddingProfId; }
 
   protected String summaryText = "";
   public    String getSummaryText() { return( summaryText ); }
   public     void setSummaryText( String aSummaryText ) { summaryText = aSummaryText; }
 
   protected String description = "";
   public    String getDescription() { return( description ); }
   public     void setDescription( String aDescription ) { description = aDescription; }
 
   protected String image1 = "";
   public    String getImage1() { return( image1 ); }
   public     void setImage1( String aImage1 ) { image1 = aImage1; }
 
   protected String image2 = "";
   public    String getImage2() { return( image2 ); }
   public     void setImage2( String aImage2 ) { image2 = aImage2; }
 
   protected String image3 = "";
   public    String getImage3() { return( image3 ); }
   public     void setImage3( String aImage3 ) { image3 = aImage3; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public WGBEWeddingProfDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "WGBEWeddingProfDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public WGBEWeddingProfDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "WGBEWeddingProfDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public WGBEWeddingProfDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "WGBEWeddingProfDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public WGBEWeddingProfDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "WGBEWeddingProfDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public WGBEWeddingProfDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "WGBEWeddingProfDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public WGBEWeddingProfDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "WGBEWeddingProfDBRecordBase constructor from array");
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
      dbColumns[0] = new ServletIntColumn( aDbData, "WGBEWEDDINGPROF.GROUPID", "WGBEWEDDINGPROF", "groupId" );
      dbColumns[1] = new ServletIntColumn( aDbData, "WGBEWEDDINGPROF.WEDDINGPROFID", "WGBEWEDDINGPROF", "weddingProfId" );
      dbColumns[2] = new ServletStringColumn( aDbData, "WGBEWEDDINGPROF.SUMMARYTEXT", "WGBEWEDDINGPROF", "summaryText" );
      if ( summaryText == null ) summaryText = ((ServletStringColumn)dbColumns[2]).getValue(); // if it hasn't already been initialized...
      dbColumns[3] = new ServletStringColumn( aDbData, "WGBEWEDDINGPROF.DESCRIPTION", "WGBEWEDDINGPROF", "description" );
      if ( description == null ) description = ((ServletStringColumn)dbColumns[3]).getValue(); // if it hasn't already been initialized...
      dbColumns[4] = new ServletStringColumn( aDbData, "WGBEWEDDINGPROF.IMAGE1", "WGBEWEDDINGPROF", "image1" );
      if ( image1 == null ) image1 = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
      dbColumns[5] = new ServletStringColumn( aDbData, "WGBEWEDDINGPROF.IMAGE2", "WGBEWEDDINGPROF", "image2" );
      if ( image2 == null ) image2 = ((ServletStringColumn)dbColumns[5]).getValue(); // if it hasn't already been initialized...
      dbColumns[6] = new ServletStringColumn( aDbData, "WGBEWEDDINGPROF.IMAGE3", "WGBEWEDDINGPROF", "image3" );
      if ( image3 == null ) image3 = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      groupId = ((ServletIntColumn)dbColumns[0]).getValue();
      weddingProfId = ((ServletIntColumn)dbColumns[1]).getValue();
      summaryText = ((ServletStringColumn)dbColumns[2]).getValue();
      description = ((ServletStringColumn)dbColumns[3]).getValue();
      image1 = ((ServletStringColumn)dbColumns[4]).getValue();
      image2 = ((ServletStringColumn)dbColumns[5]).getValue();
      image3 = ((ServletStringColumn)dbColumns[6]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletIntColumn)dbColumns[0]).setValue( groupId );
      ((ServletIntColumn)dbColumns[1]).setValue( weddingProfId );
      ((ServletStringColumn)dbColumns[2]).setValue( summaryText );
      ((ServletStringColumn)dbColumns[3]).setValue( description );
      ((ServletStringColumn)dbColumns[4]).setValue( image1 );
      ((ServletStringColumn)dbColumns[5]).setValue( image2 );
      ((ServletStringColumn)dbColumns[6]).setValue( image3 );
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
      String retString = "\n" + prefix + "WGBEWeddingProf Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    groupId (WGBEWEDDINGPROF.GROUPID) -- ";
         retString += "localVar=\"" + Integer.toString( groupId) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    weddingProfId (WGBEWEDDINGPROF.WEDDINGPROFID) -- ";
         retString += "localVar=\"" + Integer.toString( weddingProfId) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    summaryText (WGBEWEDDINGPROF.SUMMARYTEXT) -- ";
         retString += "localVar=\"" + summaryText.toString() + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    description (WGBEWEDDINGPROF.DESCRIPTION) -- ";
         retString += "localVar=\"" + description.toString() + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    image1 (WGBEWEDDINGPROF.IMAGE1) -- ";
         retString += "localVar=\"" + image1.toString() + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    image2 (WGBEWEDDINGPROF.IMAGE2) -- ";
         retString += "localVar=\"" + image2.toString() + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    image3 (WGBEWEDDINGPROF.IMAGE3) -- ";
         retString += "localVar=\"" + image3.toString() + "\";  ";
         retString += dbColumns[6].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
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
      System.out.println( "DROP TABLE WGBEWEDDINGPROF;" );
      System.out.println( "CREATE TABLE WGBEWEDDINGPROF ( WGBEWEDDINGPROF.GROUPID integer, WGBEWEDDINGPROF.WEDDINGPROFID integer, WGBEWEDDINGPROF.SUMMARYTEXT char, WGBEWEDDINGPROF.DESCRIPTION char, WGBEWEDDINGPROF.IMAGE1 char, WGBEWEDDINGPROF.IMAGE2 char, WGBEWEDDINGPROF.IMAGE3 char );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "WGBEWeddingProf Object:";
      retString += "\n    groupId (WGBEWEDDINGPROF.GROUPID) -- ";
      retString += "localVar=\"" + Integer.toString( groupId) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    weddingProfId (WGBEWEDDINGPROF.WEDDINGPROFID) -- ";
      retString += "localVar=\"" + Integer.toString( weddingProfId) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    summaryText (WGBEWEDDINGPROF.SUMMARYTEXT) -- ";
      retString += "localVar=\"" + summaryText.toString() + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    description (WGBEWEDDINGPROF.DESCRIPTION) -- ";
      retString += "localVar=\"" + description.toString() + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    image1 (WGBEWEDDINGPROF.IMAGE1) -- ";
      retString += "localVar=\"" + image1.toString() + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    image2 (WGBEWEDDINGPROF.IMAGE2) -- ";
      retString += "localVar=\"" + image2.toString() + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    image3 (WGBEWEDDINGPROF.IMAGE3) -- ";
      retString += "localVar=\"" + image3.toString() + "\";  ";
      retString += dbColumns[6].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "summaryText", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "description", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "image1", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "image2", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "image3", label ); 
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
