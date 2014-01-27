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
 
public class RegionDBRecordBase extends ServletRecord
{
 
   public static final int NAME = 0;
   public static final int GROUP = 1;
   public static final int FEATUREDVENDORGROUPID = 2;
   public static final int BUSINESSID = 3;
   public static final int TEXASWEDDINGSBUSINESSID = 4;
   public static final int TEXASWEDDINGSGROUP = 5;
   public static final int MOBILEDOMAIN = 6;
   public static final int FACEBOOK = 7;
   public static final int TWITTER = 8;
   public static final int MYSPACE = 9;
   public static final int PINTEREST = 10;
   public static final int PHONE = 11;
   public static final int EMAIL = 12;
   public static final int VIRTUALBOOKLINK = 13;
   public static final int SITESPECIFICATTRIBUTESUBID = 14;
   public static final int BLOG = 15;
   public static final int BRIDALEXTRAVAGANZA = 16;
 
   public static final String[] COLNAME = {
                                             "REGION.NAME",
                                             "REGION.GROUP",
                                             "REGION.FEATUREDVENDORGROUPID",
                                             "REGION.BUSINESSID",
                                             "REGION.TEXASWEDDINGSBUSINESSID",
                                             "REGION.TEXASWEDDINGSGROUP",
                                             "REGION.MOBILEDOMAIN",
                                             "REGION.FACEBOOK",
                                             "REGION.TWITTER",
                                             "REGION.MYSPACE",
                                             "REGION.PINTEREST",
                                             "REGION.PHONE",
                                             "REGION.EMAIL",
                                             "REGION.VIRTUALBOOKLINK",
                                             "REGION.SITESPECIFICATTRIBUTESUBID",
                                             "REGION.BLOG",
                                             "REGION.BRIDALEXTRAVAGANZA"
                                                    };
 
   protected String name = "";
   public    String getName() { return( name ); }
   public     void setName( String aName ) { name = aName; }
 
   protected int group;
   public    int getGroup() { return( group ); }
   public     void setGroup( int aGroup ) { group = aGroup; }
 
   protected int featuredVendorGroupId;
   public    int getFeaturedVendorGroupId() { return( featuredVendorGroupId ); }
   public     void setFeaturedVendorGroupId( int aFeaturedVendorGroupId ) { featuredVendorGroupId = aFeaturedVendorGroupId; }
 
   protected int businessId;
   public    int getBusinessId() { return( businessId ); }
   public     void setBusinessId( int aBusinessId ) { businessId = aBusinessId; }
 
   protected int texasWeddingsBusinessId;
   public    int getTexasWeddingsBusinessId() { return( texasWeddingsBusinessId ); }
   public     void setTexasWeddingsBusinessId( int aTexasWeddingsBusinessId ) { texasWeddingsBusinessId = aTexasWeddingsBusinessId; }
 
   protected int texasWeddingsGroup;
   public    int getTexasWeddingsGroup() { return( texasWeddingsGroup ); }
   public     void setTexasWeddingsGroup( int aTexasWeddingsGroup ) { texasWeddingsGroup = aTexasWeddingsGroup; }
 
   protected String mobileDomain = "";
   public    String getMobileDomain() { return( mobileDomain ); }
   public     void setMobileDomain( String aMobileDomain ) { mobileDomain = aMobileDomain; }
 
   protected String faceBook = "";
   public    String getFaceBook() { return( faceBook ); }
   public     void setFaceBook( String aFaceBook ) { faceBook = aFaceBook; }
 
   protected String twitter = "";
   public    String getTwitter() { return( twitter ); }
   public     void setTwitter( String aTwitter ) { twitter = aTwitter; }
 
   protected String mySpace = "";
   public    String getMySpace() { return( mySpace ); }
   public     void setMySpace( String aMySpace ) { mySpace = aMySpace; }
 
   protected String pinterest = "";
   public    String getPinterest() { return( pinterest ); }
   public     void setPinterest( String aPinterest ) { pinterest = aPinterest; }
 
   protected String phone = "";
   public    String getPhone() { return( phone ); }
   public     void setPhone( String aPhone ) { phone = aPhone; }
 
   protected String email = "";
   public    String getEmail() { return( email ); }
   public     void setEmail( String aEmail ) { email = aEmail; }
 
   protected String virtualBookLink = "";
   public    String getVirtualBookLink() { return( virtualBookLink ); }
   public     void setVirtualBookLink( String aVirtualBookLink ) { virtualBookLink = aVirtualBookLink; }
 
   protected int siteSpecificAttributeSubId;
   public    int getSiteSpecificAttributeSubId() { return( siteSpecificAttributeSubId ); }
   public     void setSiteSpecificAttributeSubId( int aSiteSpecificAttributeSubId ) { siteSpecificAttributeSubId = aSiteSpecificAttributeSubId; }
 
   protected String blog = "";
   public    String getBlog() { return( blog ); }
   public     void setBlog( String aBlog ) { blog = aBlog; }
 
   protected String bridalExtravaganza = "";
   public    String getBridalExtravaganza() { return( bridalExtravaganza ); }
   public     void setBridalExtravaganza( String aBridalExtravaganza ) { bridalExtravaganza = aBridalExtravaganza; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public RegionDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "RegionDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public RegionDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "RegionDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public RegionDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "RegionDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public RegionDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "RegionDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public RegionDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "RegionDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public RegionDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "RegionDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 17 ];
      dbColumns[0] = new ServletStringColumn( aDbData, "REGION.NAME", "REGION", "name" );
      if ( name == null ) name = ((ServletStringColumn)dbColumns[0]).getValue(); // if it hasn't already been initialized...
      dbColumns[1] = new ServletIntColumn( aDbData, "REGION.GROUP", "REGION", "group" );
      dbColumns[2] = new ServletIntColumn( aDbData, "REGION.FEATUREDVENDORGROUPID", "REGION", "featuredVendorGroupId" );
      dbColumns[3] = new ServletIntColumn( aDbData, "REGION.BUSINESSID", "REGION", "businessId" );
      dbColumns[4] = new ServletIntColumn( aDbData, "REGION.TEXASWEDDINGSBUSINESSID", "REGION", "texasWeddingsBusinessId" );
      dbColumns[5] = new ServletIntColumn( aDbData, "REGION.TEXASWEDDINGSGROUP", "REGION", "texasWeddingsGroup" );
      dbColumns[6] = new ServletStringColumn( aDbData, "REGION.MOBILEDOMAIN", "REGION", "mobileDomain" );
      if ( mobileDomain == null ) mobileDomain = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
      dbColumns[7] = new ServletStringColumn( aDbData, "REGION.FACEBOOK", "REGION", "faceBook" );
      if ( faceBook == null ) faceBook = ((ServletStringColumn)dbColumns[7]).getValue(); // if it hasn't already been initialized...
      dbColumns[8] = new ServletStringColumn( aDbData, "REGION.TWITTER", "REGION", "twitter" );
      if ( twitter == null ) twitter = ((ServletStringColumn)dbColumns[8]).getValue(); // if it hasn't already been initialized...
      dbColumns[9] = new ServletStringColumn( aDbData, "REGION.MYSPACE", "REGION", "mySpace" );
      if ( mySpace == null ) mySpace = ((ServletStringColumn)dbColumns[9]).getValue(); // if it hasn't already been initialized...
      dbColumns[10] = new ServletStringColumn( aDbData, "REGION.PINTEREST", "REGION", "pinterest" );
      if ( pinterest == null ) pinterest = ((ServletStringColumn)dbColumns[10]).getValue(); // if it hasn't already been initialized...
      dbColumns[11] = new ServletStringColumn( aDbData, "REGION.PHONE", "REGION", "phone" );
      if ( phone == null ) phone = ((ServletStringColumn)dbColumns[11]).getValue(); // if it hasn't already been initialized...
      dbColumns[12] = new ServletStringColumn( aDbData, "REGION.EMAIL", "REGION", "email" );
      if ( email == null ) email = ((ServletStringColumn)dbColumns[12]).getValue(); // if it hasn't already been initialized...
      dbColumns[13] = new ServletStringColumn( aDbData, "REGION.VIRTUALBOOKLINK", "REGION", "virtualBookLink" );
      if ( virtualBookLink == null ) virtualBookLink = ((ServletStringColumn)dbColumns[13]).getValue(); // if it hasn't already been initialized...
      dbColumns[14] = new ServletIntColumn( aDbData, "REGION.SITESPECIFICATTRIBUTESUBID", "REGION", "siteSpecificAttributeSubId" );
      dbColumns[15] = new ServletStringColumn( aDbData, "REGION.BLOG", "REGION", "blog" );
      if ( blog == null ) blog = ((ServletStringColumn)dbColumns[15]).getValue(); // if it hasn't already been initialized...
      dbColumns[16] = new ServletStringColumn( aDbData, "REGION.BRIDALEXTRAVAGANZA", "REGION", "bridalExtravaganza" );
      if ( bridalExtravaganza == null ) bridalExtravaganza = ((ServletStringColumn)dbColumns[16]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      name = ((ServletStringColumn)dbColumns[0]).getValue();
      group = ((ServletIntColumn)dbColumns[1]).getValue();
      featuredVendorGroupId = ((ServletIntColumn)dbColumns[2]).getValue();
      businessId = ((ServletIntColumn)dbColumns[3]).getValue();
      texasWeddingsBusinessId = ((ServletIntColumn)dbColumns[4]).getValue();
      texasWeddingsGroup = ((ServletIntColumn)dbColumns[5]).getValue();
      mobileDomain = ((ServletStringColumn)dbColumns[6]).getValue();
      faceBook = ((ServletStringColumn)dbColumns[7]).getValue();
      twitter = ((ServletStringColumn)dbColumns[8]).getValue();
      mySpace = ((ServletStringColumn)dbColumns[9]).getValue();
      pinterest = ((ServletStringColumn)dbColumns[10]).getValue();
      phone = ((ServletStringColumn)dbColumns[11]).getValue();
      email = ((ServletStringColumn)dbColumns[12]).getValue();
      virtualBookLink = ((ServletStringColumn)dbColumns[13]).getValue();
      siteSpecificAttributeSubId = ((ServletIntColumn)dbColumns[14]).getValue();
      blog = ((ServletStringColumn)dbColumns[15]).getValue();
      bridalExtravaganza = ((ServletStringColumn)dbColumns[16]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletStringColumn)dbColumns[0]).setValue( name );
      ((ServletIntColumn)dbColumns[1]).setValue( group );
      ((ServletIntColumn)dbColumns[2]).setValue( featuredVendorGroupId );
      ((ServletIntColumn)dbColumns[3]).setValue( businessId );
      ((ServletIntColumn)dbColumns[4]).setValue( texasWeddingsBusinessId );
      ((ServletIntColumn)dbColumns[5]).setValue( texasWeddingsGroup );
      ((ServletStringColumn)dbColumns[6]).setValue( mobileDomain );
      ((ServletStringColumn)dbColumns[7]).setValue( faceBook );
      ((ServletStringColumn)dbColumns[8]).setValue( twitter );
      ((ServletStringColumn)dbColumns[9]).setValue( mySpace );
      ((ServletStringColumn)dbColumns[10]).setValue( pinterest );
      ((ServletStringColumn)dbColumns[11]).setValue( phone );
      ((ServletStringColumn)dbColumns[12]).setValue( email );
      ((ServletStringColumn)dbColumns[13]).setValue( virtualBookLink );
      ((ServletIntColumn)dbColumns[14]).setValue( siteSpecificAttributeSubId );
      ((ServletStringColumn)dbColumns[15]).setValue( blog );
      ((ServletStringColumn)dbColumns[16]).setValue( bridalExtravaganza );
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
      String retString = "\n" + prefix + "Region Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    name (REGION.NAME) -- ";
         retString += "localVar=\"" + name.toString() + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    group (REGION.GROUP) -- ";
         retString += "localVar=\"" + Integer.toString( group) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    featuredVendorGroupId (REGION.FEATUREDVENDORGROUPID) -- ";
         retString += "localVar=\"" + Integer.toString( featuredVendorGroupId) + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    businessId (REGION.BUSINESSID) -- ";
         retString += "localVar=\"" + Integer.toString( businessId) + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    texasWeddingsBusinessId (REGION.TEXASWEDDINGSBUSINESSID) -- ";
         retString += "localVar=\"" + Integer.toString( texasWeddingsBusinessId) + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    texasWeddingsGroup (REGION.TEXASWEDDINGSGROUP) -- ";
         retString += "localVar=\"" + Integer.toString( texasWeddingsGroup) + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    mobileDomain (REGION.MOBILEDOMAIN) -- ";
         retString += "localVar=\"" + mobileDomain.toString() + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    faceBook (REGION.FACEBOOK) -- ";
         retString += "localVar=\"" + faceBook.toString() + "\";  ";
         retString += dbColumns[7].toString();
         retString += "\n"+ prefix +   "    twitter (REGION.TWITTER) -- ";
         retString += "localVar=\"" + twitter.toString() + "\";  ";
         retString += dbColumns[8].toString();
         retString += "\n"+ prefix +   "    mySpace (REGION.MYSPACE) -- ";
         retString += "localVar=\"" + mySpace.toString() + "\";  ";
         retString += dbColumns[9].toString();
         retString += "\n"+ prefix +   "    pinterest (REGION.PINTEREST) -- ";
         retString += "localVar=\"" + pinterest.toString() + "\";  ";
         retString += dbColumns[10].toString();
         retString += "\n"+ prefix +   "    phone (REGION.PHONE) -- ";
         retString += "localVar=\"" + phone.toString() + "\";  ";
         retString += dbColumns[11].toString();
         retString += "\n"+ prefix +   "    email (REGION.EMAIL) -- ";
         retString += "localVar=\"" + email.toString() + "\";  ";
         retString += dbColumns[12].toString();
         retString += "\n"+ prefix +   "    virtualBookLink (REGION.VIRTUALBOOKLINK) -- ";
         retString += "localVar=\"" + virtualBookLink.toString() + "\";  ";
         retString += dbColumns[13].toString();
         retString += "\n"+ prefix +   "    siteSpecificAttributeSubId (REGION.SITESPECIFICATTRIBUTESUBID) -- ";
         retString += "localVar=\"" + Integer.toString( siteSpecificAttributeSubId) + "\";  ";
         retString += dbColumns[14].toString();
         retString += "\n"+ prefix +   "    blog (REGION.BLOG) -- ";
         retString += "localVar=\"" + blog.toString() + "\";  ";
         retString += dbColumns[15].toString();
         retString += "\n"+ prefix +   "    bridalExtravaganza (REGION.BRIDALEXTRAVAGANZA) -- ";
         retString += "localVar=\"" + bridalExtravaganza.toString() + "\";  ";
         retString += dbColumns[16].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(RegionViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showName ) retString += commaSeparator(retString) + "name" + ndxSuffix;
         if( viewDef.showGroup ) retString += commaSeparator(retString) + "group" + ndxSuffix;
         if( viewDef.showFeaturedVendorGroupId ) retString += commaSeparator(retString) + "featuredVendorGroupId" + ndxSuffix;
         if( viewDef.showBusinessId ) retString += commaSeparator(retString) + "businessId" + ndxSuffix;
         if( viewDef.showTexasWeddingsBusinessId ) retString += commaSeparator(retString) + "texasWeddingsBusinessId" + ndxSuffix;
         if( viewDef.showTexasWeddingsGroup ) retString += commaSeparator(retString) + "texasWeddingsGroup" + ndxSuffix;
         if( viewDef.showMobileDomain ) retString += commaSeparator(retString) + "mobileDomain" + ndxSuffix;
         if( viewDef.showFaceBook ) retString += commaSeparator(retString) + "faceBook" + ndxSuffix;
         if( viewDef.showTwitter ) retString += commaSeparator(retString) + "twitter" + ndxSuffix;
         if( viewDef.showMySpace ) retString += commaSeparator(retString) + "mySpace" + ndxSuffix;
         if( viewDef.showPinterest ) retString += commaSeparator(retString) + "pinterest" + ndxSuffix;
         if( viewDef.showPhone ) retString += commaSeparator(retString) + "phone" + ndxSuffix;
         if( viewDef.showEmail ) retString += commaSeparator(retString) + "email" + ndxSuffix;
         if( viewDef.showVirtualBookLink ) retString += commaSeparator(retString) + "virtualBookLink" + ndxSuffix;
         if( viewDef.showSiteSpecificAttributeSubId ) retString += commaSeparator(retString) + "siteSpecificAttributeSubId" + ndxSuffix;
         if( viewDef.showBlog ) retString += commaSeparator(retString) + "blog" + ndxSuffix;
         if( viewDef.showBridalExtravaganza ) retString += commaSeparator(retString) + "bridalExtravaganza" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(RegionViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showName ) retString += commaSeparator(retString) + CSVCell( name);
         if( viewDef.showGroup ) retString += commaSeparator(retString) + CSVCell( group);
         if( viewDef.showFeaturedVendorGroupId ) retString += commaSeparator(retString) + CSVCell( featuredVendorGroupId);
         if( viewDef.showBusinessId ) retString += commaSeparator(retString) + CSVCell( businessId);
         if( viewDef.showTexasWeddingsBusinessId ) retString += commaSeparator(retString) + CSVCell( texasWeddingsBusinessId);
         if( viewDef.showTexasWeddingsGroup ) retString += commaSeparator(retString) + CSVCell( texasWeddingsGroup);
         if( viewDef.showMobileDomain ) retString += commaSeparator(retString) + CSVCell( mobileDomain);
         if( viewDef.showFaceBook ) retString += commaSeparator(retString) + CSVCell( faceBook);
         if( viewDef.showTwitter ) retString += commaSeparator(retString) + CSVCell( twitter);
         if( viewDef.showMySpace ) retString += commaSeparator(retString) + CSVCell( mySpace);
         if( viewDef.showPinterest ) retString += commaSeparator(retString) + CSVCell( pinterest);
         if( viewDef.showPhone ) retString += commaSeparator(retString) + CSVCell( phone);
         if( viewDef.showEmail ) retString += commaSeparator(retString) + CSVCell( email);
         if( viewDef.showVirtualBookLink ) retString += commaSeparator(retString) + CSVCell( virtualBookLink);
         if( viewDef.showSiteSpecificAttributeSubId ) retString += commaSeparator(retString) + CSVCell( siteSpecificAttributeSubId);
         if( viewDef.showBlog ) retString += commaSeparator(retString) + CSVCell( blog);
         if( viewDef.showBridalExtravaganza ) retString += commaSeparator(retString) + CSVCell( bridalExtravaganza);
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
      sysLogger.info( "DROP TABLE REGION;" );
      sysLogger.info( "CREATE TABLE REGION ( REGION.NAME char, REGION.GROUP integer, REGION.FEATUREDVENDORGROUPID integer, REGION.BUSINESSID integer, REGION.TEXASWEDDINGSBUSINESSID integer, REGION.TEXASWEDDINGSGROUP integer, REGION.MOBILEDOMAIN char, REGION.FACEBOOK char, REGION.TWITTER char, REGION.MYSPACE char, REGION.PINTEREST char, REGION.PHONE char, REGION.EMAIL char, REGION.VIRTUALBOOKLINK char, REGION.SITESPECIFICATTRIBUTESUBID integer, REGION.BLOG char, REGION.BRIDALEXTRAVAGANZA char );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "Region Object:";
      retString += "\n    name (REGION.NAME) -- ";
      retString += "localVar=\"" + name.toString() + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    group (REGION.GROUP) -- ";
      retString += "localVar=\"" + Integer.toString( group) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    featuredVendorGroupId (REGION.FEATUREDVENDORGROUPID) -- ";
      retString += "localVar=\"" + Integer.toString( featuredVendorGroupId) + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    businessId (REGION.BUSINESSID) -- ";
      retString += "localVar=\"" + Integer.toString( businessId) + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    texasWeddingsBusinessId (REGION.TEXASWEDDINGSBUSINESSID) -- ";
      retString += "localVar=\"" + Integer.toString( texasWeddingsBusinessId) + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    texasWeddingsGroup (REGION.TEXASWEDDINGSGROUP) -- ";
      retString += "localVar=\"" + Integer.toString( texasWeddingsGroup) + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    mobileDomain (REGION.MOBILEDOMAIN) -- ";
      retString += "localVar=\"" + mobileDomain.toString() + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    faceBook (REGION.FACEBOOK) -- ";
      retString += "localVar=\"" + faceBook.toString() + "\";  ";
      retString += dbColumns[7].toString();
      retString += "\n    twitter (REGION.TWITTER) -- ";
      retString += "localVar=\"" + twitter.toString() + "\";  ";
      retString += dbColumns[8].toString();
      retString += "\n    mySpace (REGION.MYSPACE) -- ";
      retString += "localVar=\"" + mySpace.toString() + "\";  ";
      retString += dbColumns[9].toString();
      retString += "\n    pinterest (REGION.PINTEREST) -- ";
      retString += "localVar=\"" + pinterest.toString() + "\";  ";
      retString += dbColumns[10].toString();
      retString += "\n    phone (REGION.PHONE) -- ";
      retString += "localVar=\"" + phone.toString() + "\";  ";
      retString += dbColumns[11].toString();
      retString += "\n    email (REGION.EMAIL) -- ";
      retString += "localVar=\"" + email.toString() + "\";  ";
      retString += dbColumns[12].toString();
      retString += "\n    virtualBookLink (REGION.VIRTUALBOOKLINK) -- ";
      retString += "localVar=\"" + virtualBookLink.toString() + "\";  ";
      retString += dbColumns[13].toString();
      retString += "\n    siteSpecificAttributeSubId (REGION.SITESPECIFICATTRIBUTESUBID) -- ";
      retString += "localVar=\"" + Integer.toString( siteSpecificAttributeSubId) + "\";  ";
      retString += dbColumns[14].toString();
      retString += "\n    blog (REGION.BLOG) -- ";
      retString += "localVar=\"" + blog.toString() + "\";  ";
      retString += dbColumns[15].toString();
      retString += "\n    bridalExtravaganza (REGION.BRIDALEXTRAVAGANZA) -- ";
      retString += "localVar=\"" + bridalExtravaganza.toString() + "\";  ";
      retString += dbColumns[16].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "name", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "mobileDomain", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "faceBook", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "twitter", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "mySpace", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "pinterest", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "phone", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "email", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "virtualBookLink", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "blog", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "bridalExtravaganza", label ); 
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
