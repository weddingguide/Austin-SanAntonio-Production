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
 
public class PageDataDBRecordBase extends ServletRecord
{
 
   public static final int PAGEDESCRIPTION = 0;
   public static final int KEYWORDS = 1;
   public static final int GOOGLEVERIFY = 2;
   public static final int BINGVERIFY = 3;
   public static final int HOMEPAGEFEATUREDSLIDERINT = 4;
   public static final int URLPREFIX = 5;
   public static final int GOOGLEANALYTICS = 6;
   public static final int CSSNAME = 7;
 
   public static final String[] COLNAME = {
                                             "PAGEDATA.PAGEDESCRIPTION",
                                             "PAGEDATA.KEYWORDS",
                                             "PAGEDATA.GOOGLEVERIFY",
                                             "PAGEDATA.BINGVERIFY",
                                             "PAGEDATA.HOMEPAGEFEATUREDSLIDERINT",
                                             "PAGEDATA.URLPREFIX",
                                             "PAGEDATA.GOOGLEANALYTICS",
                                             "PAGEDATA.CSSNAME"
                                                    };
 
   protected String pageDescription = "";
   public    String getPageDescription() { return( pageDescription ); }
   public     void setPageDescription( String aPageDescription ) { pageDescription = aPageDescription; }
 
   protected String keywords = "";
   public    String getKeywords() { return( keywords ); }
   public     void setKeywords( String aKeywords ) { keywords = aKeywords; }
 
   protected String googleVerify = "";
   public    String getGoogleVerify() { return( googleVerify ); }
   public     void setGoogleVerify( String aGoogleVerify ) { googleVerify = aGoogleVerify; }
 
   protected String bingVerify = "";
   public    String getBingVerify() { return( bingVerify ); }
   public     void setBingVerify( String aBingVerify ) { bingVerify = aBingVerify; }
 
   protected String homePageFeaturedSliderInt = "";
   public    String getHomePageFeaturedSliderInt() { return( homePageFeaturedSliderInt ); }
   public     void setHomePageFeaturedSliderInt( String aHomePageFeaturedSliderInt ) { homePageFeaturedSliderInt = aHomePageFeaturedSliderInt; }
 
   protected String urlPrefix = "";
   public    String getUrlPrefix() { return( urlPrefix ); }
   public     void setUrlPrefix( String aUrlPrefix ) { urlPrefix = aUrlPrefix; }
 
   protected String googleAnalytics = "";
   public    String getGoogleAnalytics() { return( googleAnalytics ); }
   public     void setGoogleAnalytics( String aGoogleAnalytics ) { googleAnalytics = aGoogleAnalytics; }
 
   protected String cssName = "";
   public    String getCssName() { return( cssName ); }
   public     void setCssName( String aCssName ) { cssName = aCssName; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PageDataDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "PageDataDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PageDataDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "PageDataDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PageDataDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "PageDataDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PageDataDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "PageDataDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PageDataDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "PageDataDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PageDataDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "PageDataDBRecordBase constructor from array");
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
      dbColumns[0] = new ServletStringColumn( aDbData, "PAGEDATA.PAGEDESCRIPTION", "PAGEDATA", "pageDescription" );
      if ( pageDescription == null ) pageDescription = ((ServletStringColumn)dbColumns[0]).getValue(); // if it hasn't already been initialized...
      dbColumns[1] = new ServletStringColumn( aDbData, "PAGEDATA.KEYWORDS", "PAGEDATA", "keywords" );
      if ( keywords == null ) keywords = ((ServletStringColumn)dbColumns[1]).getValue(); // if it hasn't already been initialized...
      dbColumns[2] = new ServletStringColumn( aDbData, "PAGEDATA.GOOGLEVERIFY", "PAGEDATA", "googleVerify" );
      if ( googleVerify == null ) googleVerify = ((ServletStringColumn)dbColumns[2]).getValue(); // if it hasn't already been initialized...
      dbColumns[3] = new ServletStringColumn( aDbData, "PAGEDATA.BINGVERIFY", "PAGEDATA", "bingVerify" );
      if ( bingVerify == null ) bingVerify = ((ServletStringColumn)dbColumns[3]).getValue(); // if it hasn't already been initialized...
      dbColumns[4] = new ServletStringColumn( aDbData, "PAGEDATA.HOMEPAGEFEATUREDSLIDERINT", "PAGEDATA", "homePageFeaturedSliderInt" );
      if ( homePageFeaturedSliderInt == null ) homePageFeaturedSliderInt = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
      dbColumns[5] = new ServletStringColumn( aDbData, "PAGEDATA.URLPREFIX", "PAGEDATA", "urlPrefix" );
      if ( urlPrefix == null ) urlPrefix = ((ServletStringColumn)dbColumns[5]).getValue(); // if it hasn't already been initialized...
      dbColumns[6] = new ServletStringColumn( aDbData, "PAGEDATA.GOOGLEANALYTICS", "PAGEDATA", "googleAnalytics" );
      if ( googleAnalytics == null ) googleAnalytics = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
      dbColumns[7] = new ServletStringColumn( aDbData, "PAGEDATA.CSSNAME", "PAGEDATA", "cssName" );
      if ( cssName == null ) cssName = ((ServletStringColumn)dbColumns[7]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      pageDescription = ((ServletStringColumn)dbColumns[0]).getValue();
      keywords = ((ServletStringColumn)dbColumns[1]).getValue();
      googleVerify = ((ServletStringColumn)dbColumns[2]).getValue();
      bingVerify = ((ServletStringColumn)dbColumns[3]).getValue();
      homePageFeaturedSliderInt = ((ServletStringColumn)dbColumns[4]).getValue();
      urlPrefix = ((ServletStringColumn)dbColumns[5]).getValue();
      googleAnalytics = ((ServletStringColumn)dbColumns[6]).getValue();
      cssName = ((ServletStringColumn)dbColumns[7]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletStringColumn)dbColumns[0]).setValue( pageDescription );
      ((ServletStringColumn)dbColumns[1]).setValue( keywords );
      ((ServletStringColumn)dbColumns[2]).setValue( googleVerify );
      ((ServletStringColumn)dbColumns[3]).setValue( bingVerify );
      ((ServletStringColumn)dbColumns[4]).setValue( homePageFeaturedSliderInt );
      ((ServletStringColumn)dbColumns[5]).setValue( urlPrefix );
      ((ServletStringColumn)dbColumns[6]).setValue( googleAnalytics );
      ((ServletStringColumn)dbColumns[7]).setValue( cssName );
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
      String retString = "\n" + prefix + "PageData Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    pageDescription (PAGEDATA.PAGEDESCRIPTION) -- ";
         retString += "localVar=\"" + pageDescription.toString() + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    keywords (PAGEDATA.KEYWORDS) -- ";
         retString += "localVar=\"" + keywords.toString() + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    googleVerify (PAGEDATA.GOOGLEVERIFY) -- ";
         retString += "localVar=\"" + googleVerify.toString() + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    bingVerify (PAGEDATA.BINGVERIFY) -- ";
         retString += "localVar=\"" + bingVerify.toString() + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    homePageFeaturedSliderInt (PAGEDATA.HOMEPAGEFEATUREDSLIDERINT) -- ";
         retString += "localVar=\"" + homePageFeaturedSliderInt.toString() + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    urlPrefix (PAGEDATA.URLPREFIX) -- ";
         retString += "localVar=\"" + urlPrefix.toString() + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    googleAnalytics (PAGEDATA.GOOGLEANALYTICS) -- ";
         retString += "localVar=\"" + googleAnalytics.toString() + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    cssName (PAGEDATA.CSSNAME) -- ";
         retString += "localVar=\"" + cssName.toString() + "\";  ";
         retString += dbColumns[7].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(PageDataViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showPageDescription ) retString += commaSeparator(retString) + "pageDescription" + ndxSuffix;
         if( viewDef.showKeywords ) retString += commaSeparator(retString) + "keywords" + ndxSuffix;
         if( viewDef.showGoogleVerify ) retString += commaSeparator(retString) + "googleVerify" + ndxSuffix;
         if( viewDef.showBingVerify ) retString += commaSeparator(retString) + "bingVerify" + ndxSuffix;
         if( viewDef.showHomePageFeaturedSliderInt ) retString += commaSeparator(retString) + "homePageFeaturedSliderInt" + ndxSuffix;
         if( viewDef.showUrlPrefix ) retString += commaSeparator(retString) + "urlPrefix" + ndxSuffix;
         if( viewDef.showGoogleAnalytics ) retString += commaSeparator(retString) + "googleAnalytics" + ndxSuffix;
         if( viewDef.showCssName ) retString += commaSeparator(retString) + "cssName" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(PageDataViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showPageDescription ) retString += commaSeparator(retString) + CSVCell( pageDescription);
         if( viewDef.showKeywords ) retString += commaSeparator(retString) + CSVCell( keywords);
         if( viewDef.showGoogleVerify ) retString += commaSeparator(retString) + CSVCell( googleVerify);
         if( viewDef.showBingVerify ) retString += commaSeparator(retString) + CSVCell( bingVerify);
         if( viewDef.showHomePageFeaturedSliderInt ) retString += commaSeparator(retString) + CSVCell( homePageFeaturedSliderInt);
         if( viewDef.showUrlPrefix ) retString += commaSeparator(retString) + CSVCell( urlPrefix);
         if( viewDef.showGoogleAnalytics ) retString += commaSeparator(retString) + CSVCell( googleAnalytics);
         if( viewDef.showCssName ) retString += commaSeparator(retString) + CSVCell( cssName);
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
      sysLogger.info( "DROP TABLE PAGEDATA;" );
      sysLogger.info( "CREATE TABLE PAGEDATA ( PAGEDATA.PAGEDESCRIPTION char, PAGEDATA.KEYWORDS char, PAGEDATA.GOOGLEVERIFY char, PAGEDATA.BINGVERIFY char, PAGEDATA.HOMEPAGEFEATUREDSLIDERINT char, PAGEDATA.URLPREFIX char, PAGEDATA.GOOGLEANALYTICS char, PAGEDATA.CSSNAME char );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "PageData Object:";
      retString += "\n    pageDescription (PAGEDATA.PAGEDESCRIPTION) -- ";
      retString += "localVar=\"" + pageDescription.toString() + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    keywords (PAGEDATA.KEYWORDS) -- ";
      retString += "localVar=\"" + keywords.toString() + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    googleVerify (PAGEDATA.GOOGLEVERIFY) -- ";
      retString += "localVar=\"" + googleVerify.toString() + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    bingVerify (PAGEDATA.BINGVERIFY) -- ";
      retString += "localVar=\"" + bingVerify.toString() + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    homePageFeaturedSliderInt (PAGEDATA.HOMEPAGEFEATUREDSLIDERINT) -- ";
      retString += "localVar=\"" + homePageFeaturedSliderInt.toString() + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    urlPrefix (PAGEDATA.URLPREFIX) -- ";
      retString += "localVar=\"" + urlPrefix.toString() + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    googleAnalytics (PAGEDATA.GOOGLEANALYTICS) -- ";
      retString += "localVar=\"" + googleAnalytics.toString() + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    cssName (PAGEDATA.CSSNAME) -- ";
      retString += "localVar=\"" + cssName.toString() + "\";  ";
      retString += dbColumns[7].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "pageDescription", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "keywords", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "googleVerify", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "bingVerify", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "homePageFeaturedSliderInt", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "urlPrefix", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "googleAnalytics", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "cssName", label ); 
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
