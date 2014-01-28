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
 
public class CoupleGroupInfoDBRecordBase extends ServletRecord
{
 
   public static final int OWNERTYPE = 0;
   public static final int OWNERID = 1;
   public static final int STATUS = 2;
   public static final int MUSICRECEIVED = 3;
   public static final int MUSICINFODETAILS = 4;
   public static final int INVITATIONRECEIVED = 5;
   public static final int INVITATIONINFODETAILS = 6;
   public static final int PROGRAMRECEIVED = 7;
   public static final int PROGRAMINFODETAILS = 8;
   public static final int PRICELISTVERSION = 9;
   public static final int HOURSONSITE = 10;
   public static final int LOVESTORY = 11;
   public static final int PHOTOMONTAGE = 12;
   public static final int COMPLETECEREMONY = 13;
   public static final int NUMBEROFDVDS = 14;
   public static final int NEGOTIATEDITEMS = 15;
   public static final int WEBPUBLICATION = 16;
   public static final int CATALOG = 17;
   public static final int CREATEDATE = 18;
   public static final int REGISTRYCATALOG = 19;
   public static final int PROJECT = 20;
   public static final int TITLETEXT = 21;
 
   public static final String[] COLNAME = {
                                             "COUPLEGROUPINFO.OWNERTYPE",
                                             "COUPLEGROUPINFO.OWNERID",
                                             "COUPLEGROUPINFO.STATUS",
                                             "COUPLEGROUPINFO.MUSICRECEIVED",
                                             "COUPLEGROUPINFO.MUSICINFODETAILS",
                                             "COUPLEGROUPINFO.INVITATIONRECEIVED",
                                             "COUPLEGROUPINFO.INVITATIONINFODETAILS",
                                             "COUPLEGROUPINFO.PROGRAMRECEIVED",
                                             "COUPLEGROUPINFO.PROGRAMINFODETAILS",
                                             "COUPLEGROUPINFO.PriceListVersion",
                                             "COUPLEGROUPINFO.HoursOnSite",
                                             "COUPLEGROUPINFO.LoveStory",
                                             "COUPLEGROUPINFO.PhotoMontage",
                                             "COUPLEGROUPINFO.CompleteCeremony",
                                             "COUPLEGROUPINFO.NumberOfDVDs",
                                             "COUPLEGROUPINFO.NegotiatedItems",
                                             "COUPLEGROUPINFO.WebPublication",
                                             "COUPLEGROUPINFO.Catalog",
                                             "COUPLEGROUPINFO.createDate",
                                             "COUPLEGROUPINFO.registryCatalog",
                                             "COUPLEGROUPINFO.project",
                                             "COUPLEGROUPINFO.titletext"
                                                    };
 
   protected int ownerType;
   public    int getOwnerType() { return( ownerType ); }
   public     void setOwnerType( int aOwnerType ) { ownerType = aOwnerType; }
 
   protected int ownerId;
   public    int getOwnerId() { return( ownerId ); }
   public     void setOwnerId( int aOwnerId ) { ownerId = aOwnerId; }
 
   protected int status;
   public    int getStatus() { return( status ); }
   public     void setStatus( int aStatus ) { status = aStatus; }
 
   protected int musicReceived;
   public    int getMusicReceived() { return( musicReceived ); }
   public     void setMusicReceived( int aMusicReceived ) { musicReceived = aMusicReceived; }
 
   protected String musicInfoDetails = "";
   public    String getMusicInfoDetails() { return( musicInfoDetails ); }
   public     void setMusicInfoDetails( String aMusicInfoDetails ) { musicInfoDetails = aMusicInfoDetails; }
 
   protected int invitationReceived;
   public    int getInvitationReceived() { return( invitationReceived ); }
   public     void setInvitationReceived( int aInvitationReceived ) { invitationReceived = aInvitationReceived; }
 
   protected String invitationInfoDetails = "";
   public    String getInvitationInfoDetails() { return( invitationInfoDetails ); }
   public     void setInvitationInfoDetails( String aInvitationInfoDetails ) { invitationInfoDetails = aInvitationInfoDetails; }
 
   protected int programReceived;
   public    int getProgramReceived() { return( programReceived ); }
   public     void setProgramReceived( int aProgramReceived ) { programReceived = aProgramReceived; }
 
   protected String programInfoDetails = "";
   public    String getProgramInfoDetails() { return( programInfoDetails ); }
   public     void setProgramInfoDetails( String aProgramInfoDetails ) { programInfoDetails = aProgramInfoDetails; }
 
   protected String priceListVersion = "";
   public    String getPriceListVersion() { return( priceListVersion ); }
   public     void setPriceListVersion( String aPriceListVersion ) { priceListVersion = aPriceListVersion; }
 
   protected int hoursOnSite;
   public    int getHoursOnSite() { return( hoursOnSite ); }
   public     void setHoursOnSite( int aHoursOnSite ) { hoursOnSite = aHoursOnSite; }
 
   protected int loveStory;
   public    int getLoveStory() { return( loveStory ); }
   public     void setLoveStory( int aLoveStory ) { loveStory = aLoveStory; }
 
   protected int photoMontage;
   public    int getPhotoMontage() { return( photoMontage ); }
   public     void setPhotoMontage( int aPhotoMontage ) { photoMontage = aPhotoMontage; }
 
   protected int completeCeremony;
   public    int getCompleteCeremony() { return( completeCeremony ); }
   public     void setCompleteCeremony( int aCompleteCeremony ) { completeCeremony = aCompleteCeremony; }
 
   protected int numberOfDVDs;
   public    int getNumberOfDVDs() { return( numberOfDVDs ); }
   public     void setNumberOfDVDs( int aNumberOfDVDs ) { numberOfDVDs = aNumberOfDVDs; }
 
   protected String negotiatedItems = "";
   public    String getNegotiatedItems() { return( negotiatedItems ); }
   public     void setNegotiatedItems( String aNegotiatedItems ) { negotiatedItems = aNegotiatedItems; }
 
   protected int webPublication;
   public    int getWebPublication() { return( webPublication ); }
   public     void setWebPublication( int aWebPublication ) { webPublication = aWebPublication; }
 
   protected int catalog;
   public    int getCatalog() { return( catalog ); }
   public     void setCatalog( int aCatalog ) { catalog = aCatalog; }
 
   protected java.sql.Date createDate;
   public    java.sql.Date getCreateDate() { return( createDate ); }
   public     void setCreateDate( java.sql.Date aCreateDate ) { createDate = aCreateDate; }
 
   protected int registryCatalog;
   public    int getRegistryCatalog() { return( registryCatalog ); }
   public     void setRegistryCatalog( int aRegistryCatalog ) { registryCatalog = aRegistryCatalog; }
 
   protected int project;
   public    int getProject() { return( project ); }
   public     void setProject( int aProject ) { project = aProject; }
 
   protected String titleText = "";
   public    String getTitleText() { return( titleText ); }
   public     void setTitleText( String aTitleText ) { titleText = aTitleText; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public CoupleGroupInfoDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "CoupleGroupInfoDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public CoupleGroupInfoDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "CoupleGroupInfoDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public CoupleGroupInfoDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "CoupleGroupInfoDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public CoupleGroupInfoDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "CoupleGroupInfoDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public CoupleGroupInfoDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "CoupleGroupInfoDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public CoupleGroupInfoDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "CoupleGroupInfoDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 22 ];
      dbColumns[0] = new ServletIntColumn( aDbData, "COUPLEGROUPINFO.OWNERTYPE", "COUPLEGROUPINFO", "ownerType" );
      dbColumns[1] = new ServletIntColumn( aDbData, "COUPLEGROUPINFO.OWNERID", "COUPLEGROUPINFO", "ownerId" );
      dbColumns[2] = new ServletIntColumn( aDbData, "COUPLEGROUPINFO.STATUS", "COUPLEGROUPINFO", "status" );
      dbColumns[3] = new ServletIntColumn( aDbData, "COUPLEGROUPINFO.MUSICRECEIVED", "COUPLEGROUPINFO", "musicReceived" );
      dbColumns[4] = new ServletStringColumn( aDbData, "COUPLEGROUPINFO.MUSICINFODETAILS", "COUPLEGROUPINFO", "musicInfoDetails" );
      if ( musicInfoDetails == null ) musicInfoDetails = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
      dbColumns[5] = new ServletIntColumn( aDbData, "COUPLEGROUPINFO.INVITATIONRECEIVED", "COUPLEGROUPINFO", "invitationReceived" );
      dbColumns[6] = new ServletStringColumn( aDbData, "COUPLEGROUPINFO.INVITATIONINFODETAILS", "COUPLEGROUPINFO", "invitationInfoDetails" );
      if ( invitationInfoDetails == null ) invitationInfoDetails = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
      dbColumns[7] = new ServletIntColumn( aDbData, "COUPLEGROUPINFO.PROGRAMRECEIVED", "COUPLEGROUPINFO", "programReceived" );
      dbColumns[8] = new ServletStringColumn( aDbData, "COUPLEGROUPINFO.PROGRAMINFODETAILS", "COUPLEGROUPINFO", "programInfoDetails" );
      if ( programInfoDetails == null ) programInfoDetails = ((ServletStringColumn)dbColumns[8]).getValue(); // if it hasn't already been initialized...
      dbColumns[9] = new ServletStringColumn( aDbData, "COUPLEGROUPINFO.PriceListVersion", "COUPLEGROUPINFO", "priceListVersion" );
      if ( priceListVersion == null ) priceListVersion = ((ServletStringColumn)dbColumns[9]).getValue(); // if it hasn't already been initialized...
      dbColumns[10] = new ServletIntColumn( aDbData, "COUPLEGROUPINFO.HoursOnSite", "COUPLEGROUPINFO", "hoursOnSite" );
      dbColumns[11] = new ServletBoolIntColumn( aDbData, "COUPLEGROUPINFO.LoveStory", "COUPLEGROUPINFO", "loveStory" );
      dbColumns[12] = new ServletBoolIntColumn( aDbData, "COUPLEGROUPINFO.PhotoMontage", "COUPLEGROUPINFO", "photoMontage" );
      dbColumns[13] = new ServletBoolIntColumn( aDbData, "COUPLEGROUPINFO.CompleteCeremony", "COUPLEGROUPINFO", "completeCeremony" );
      dbColumns[14] = new ServletIntColumn( aDbData, "COUPLEGROUPINFO.NumberOfDVDs", "COUPLEGROUPINFO", "numberOfDVDs" );
      dbColumns[15] = new ServletStringColumn( aDbData, "COUPLEGROUPINFO.NegotiatedItems", "COUPLEGROUPINFO", "negotiatedItems" );
      if ( negotiatedItems == null ) negotiatedItems = ((ServletStringColumn)dbColumns[15]).getValue(); // if it hasn't already been initialized...
      dbColumns[16] = new ServletBoolIntColumn( aDbData, "COUPLEGROUPINFO.WebPublication", "COUPLEGROUPINFO", "webPublication" );
      dbColumns[17] = new ServletIntColumn( aDbData, "COUPLEGROUPINFO.Catalog", "COUPLEGROUPINFO", "catalog" );
      dbColumns[18] = new ServletDateColumn( aDbData, "COUPLEGROUPINFO.createDate", "COUPLEGROUPINFO", "createDate" );
      if ( createDate == null ) createDate = ((ServletDateColumn)dbColumns[18]).getValue(); // if it hasn't already been initialized...
      dbColumns[19] = new ServletIntColumn( aDbData, "COUPLEGROUPINFO.registryCatalog", "COUPLEGROUPINFO", "registryCatalog" );
      dbColumns[20] = new ServletIntColumn( aDbData, "COUPLEGROUPINFO.project", "COUPLEGROUPINFO", "project" );
      dbColumns[21] = new ServletStringColumn( aDbData, "COUPLEGROUPINFO.titletext", "COUPLEGROUPINFO", "titleText" );
      if ( titleText == null ) titleText = ((ServletStringColumn)dbColumns[21]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      ownerType = ((ServletIntColumn)dbColumns[0]).getValue();
      ownerId = ((ServletIntColumn)dbColumns[1]).getValue();
      status = ((ServletIntColumn)dbColumns[2]).getValue();
      musicReceived = ((ServletIntColumn)dbColumns[3]).getValue();
      musicInfoDetails = ((ServletStringColumn)dbColumns[4]).getValue();
      invitationReceived = ((ServletIntColumn)dbColumns[5]).getValue();
      invitationInfoDetails = ((ServletStringColumn)dbColumns[6]).getValue();
      programReceived = ((ServletIntColumn)dbColumns[7]).getValue();
      programInfoDetails = ((ServletStringColumn)dbColumns[8]).getValue();
      priceListVersion = ((ServletStringColumn)dbColumns[9]).getValue();
      hoursOnSite = ((ServletIntColumn)dbColumns[10]).getValue();
      loveStory = ((ServletBoolIntColumn)dbColumns[11]).getValue();
      photoMontage = ((ServletBoolIntColumn)dbColumns[12]).getValue();
      completeCeremony = ((ServletBoolIntColumn)dbColumns[13]).getValue();
      numberOfDVDs = ((ServletIntColumn)dbColumns[14]).getValue();
      negotiatedItems = ((ServletStringColumn)dbColumns[15]).getValue();
      webPublication = ((ServletBoolIntColumn)dbColumns[16]).getValue();
      catalog = ((ServletIntColumn)dbColumns[17]).getValue();
      createDate = ((ServletDateColumn)dbColumns[18]).getValue();
      registryCatalog = ((ServletIntColumn)dbColumns[19]).getValue();
      project = ((ServletIntColumn)dbColumns[20]).getValue();
      titleText = ((ServletStringColumn)dbColumns[21]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletIntColumn)dbColumns[0]).setValue( ownerType );
      ((ServletIntColumn)dbColumns[1]).setValue( ownerId );
      ((ServletIntColumn)dbColumns[2]).setValue( status );
      ((ServletIntColumn)dbColumns[3]).setValue( musicReceived );
      ((ServletStringColumn)dbColumns[4]).setValue( musicInfoDetails );
      ((ServletIntColumn)dbColumns[5]).setValue( invitationReceived );
      ((ServletStringColumn)dbColumns[6]).setValue( invitationInfoDetails );
      ((ServletIntColumn)dbColumns[7]).setValue( programReceived );
      ((ServletStringColumn)dbColumns[8]).setValue( programInfoDetails );
      ((ServletStringColumn)dbColumns[9]).setValue( priceListVersion );
      ((ServletIntColumn)dbColumns[10]).setValue( hoursOnSite );
      ((ServletBoolIntColumn)dbColumns[11]).setValue( loveStory );
      ((ServletBoolIntColumn)dbColumns[12]).setValue( photoMontage );
      ((ServletBoolIntColumn)dbColumns[13]).setValue( completeCeremony );
      ((ServletIntColumn)dbColumns[14]).setValue( numberOfDVDs );
      ((ServletStringColumn)dbColumns[15]).setValue( negotiatedItems );
      ((ServletBoolIntColumn)dbColumns[16]).setValue( webPublication );
      ((ServletIntColumn)dbColumns[17]).setValue( catalog );
      ((ServletDateColumn)dbColumns[18]).setValue( createDate );
      ((ServletIntColumn)dbColumns[19]).setValue( registryCatalog );
      ((ServletIntColumn)dbColumns[20]).setValue( project );
      ((ServletStringColumn)dbColumns[21]).setValue( titleText );
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
      String retString = "\n" + prefix + "CoupleGroupInfo Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    ownerType (COUPLEGROUPINFO.OWNERTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    ownerId (COUPLEGROUPINFO.OWNERID) -- ";
         retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    status (COUPLEGROUPINFO.STATUS) -- ";
         retString += "localVar=\"" + Integer.toString( status) + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    musicReceived (COUPLEGROUPINFO.MUSICRECEIVED) -- ";
         retString += "localVar=\"" + Integer.toString( musicReceived) + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    musicInfoDetails (COUPLEGROUPINFO.MUSICINFODETAILS) -- ";
         retString += "localVar=\"" + musicInfoDetails.toString() + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    invitationReceived (COUPLEGROUPINFO.INVITATIONRECEIVED) -- ";
         retString += "localVar=\"" + Integer.toString( invitationReceived) + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    invitationInfoDetails (COUPLEGROUPINFO.INVITATIONINFODETAILS) -- ";
         retString += "localVar=\"" + invitationInfoDetails.toString() + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    programReceived (COUPLEGROUPINFO.PROGRAMRECEIVED) -- ";
         retString += "localVar=\"" + Integer.toString( programReceived) + "\";  ";
         retString += dbColumns[7].toString();
         retString += "\n"+ prefix +   "    programInfoDetails (COUPLEGROUPINFO.PROGRAMINFODETAILS) -- ";
         retString += "localVar=\"" + programInfoDetails.toString() + "\";  ";
         retString += dbColumns[8].toString();
         retString += "\n"+ prefix +   "    priceListVersion (COUPLEGROUPINFO.PriceListVersion) -- ";
         retString += "localVar=\"" + priceListVersion.toString() + "\";  ";
         retString += dbColumns[9].toString();
         retString += "\n"+ prefix +   "    hoursOnSite (COUPLEGROUPINFO.HoursOnSite) -- ";
         retString += "localVar=\"" + Integer.toString( hoursOnSite) + "\";  ";
         retString += dbColumns[10].toString();
         retString += "\n"+ prefix +   "    loveStory (COUPLEGROUPINFO.LoveStory) -- ";
         retString += "localVar=\"" + Integer.toString( loveStory) + "\";  ";
         retString += dbColumns[11].toString();
         retString += "\n"+ prefix +   "    photoMontage (COUPLEGROUPINFO.PhotoMontage) -- ";
         retString += "localVar=\"" + Integer.toString( photoMontage) + "\";  ";
         retString += dbColumns[12].toString();
         retString += "\n"+ prefix +   "    completeCeremony (COUPLEGROUPINFO.CompleteCeremony) -- ";
         retString += "localVar=\"" + Integer.toString( completeCeremony) + "\";  ";
         retString += dbColumns[13].toString();
         retString += "\n"+ prefix +   "    numberOfDVDs (COUPLEGROUPINFO.NumberOfDVDs) -- ";
         retString += "localVar=\"" + Integer.toString( numberOfDVDs) + "\";  ";
         retString += dbColumns[14].toString();
         retString += "\n"+ prefix +   "    negotiatedItems (COUPLEGROUPINFO.NegotiatedItems) -- ";
         retString += "localVar=\"" + negotiatedItems.toString() + "\";  ";
         retString += dbColumns[15].toString();
         retString += "\n"+ prefix +   "    webPublication (COUPLEGROUPINFO.WebPublication) -- ";
         retString += "localVar=\"" + Integer.toString( webPublication) + "\";  ";
         retString += dbColumns[16].toString();
         retString += "\n"+ prefix +   "    catalog (COUPLEGROUPINFO.Catalog) -- ";
         retString += "localVar=\"" + Integer.toString( catalog) + "\";  ";
         retString += dbColumns[17].toString();
         retString += "\n"+ prefix +   "    createDate (COUPLEGROUPINFO.createDate) -- ";
         retString += "localVar=\"" + createDate.toString() + "\";  ";
         retString += dbColumns[18].toString();
         retString += "\n"+ prefix +   "    registryCatalog (COUPLEGROUPINFO.registryCatalog) -- ";
         retString += "localVar=\"" + Integer.toString( registryCatalog) + "\";  ";
         retString += dbColumns[19].toString();
         retString += "\n"+ prefix +   "    project (COUPLEGROUPINFO.project) -- ";
         retString += "localVar=\"" + Integer.toString( project) + "\";  ";
         retString += dbColumns[20].toString();
         retString += "\n"+ prefix +   "    titleText (COUPLEGROUPINFO.titletext) -- ";
         retString += "localVar=\"" + titleText.toString() + "\";  ";
         retString += dbColumns[21].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(CoupleGroupInfoViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + "ownerType" + ndxSuffix;
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + "ownerId" + ndxSuffix;
         if( viewDef.showStatus ) retString += commaSeparator(retString) + "status" + ndxSuffix;
         if( viewDef.showMusicReceived ) retString += commaSeparator(retString) + "musicReceived" + ndxSuffix;
         if( viewDef.showMusicInfoDetails ) retString += commaSeparator(retString) + "musicInfoDetails" + ndxSuffix;
         if( viewDef.showInvitationReceived ) retString += commaSeparator(retString) + "invitationReceived" + ndxSuffix;
         if( viewDef.showInvitationInfoDetails ) retString += commaSeparator(retString) + "invitationInfoDetails" + ndxSuffix;
         if( viewDef.showProgramReceived ) retString += commaSeparator(retString) + "programReceived" + ndxSuffix;
         if( viewDef.showProgramInfoDetails ) retString += commaSeparator(retString) + "programInfoDetails" + ndxSuffix;
         if( viewDef.showPriceListVersion ) retString += commaSeparator(retString) + "priceListVersion" + ndxSuffix;
         if( viewDef.showHoursOnSite ) retString += commaSeparator(retString) + "hoursOnSite" + ndxSuffix;
         if( viewDef.showLoveStory ) retString += commaSeparator(retString) + "loveStory" + ndxSuffix;
         if( viewDef.showPhotoMontage ) retString += commaSeparator(retString) + "photoMontage" + ndxSuffix;
         if( viewDef.showCompleteCeremony ) retString += commaSeparator(retString) + "completeCeremony" + ndxSuffix;
         if( viewDef.showNumberOfDVDs ) retString += commaSeparator(retString) + "numberOfDVDs" + ndxSuffix;
         if( viewDef.showNegotiatedItems ) retString += commaSeparator(retString) + "negotiatedItems" + ndxSuffix;
         if( viewDef.showWebPublication ) retString += commaSeparator(retString) + "webPublication" + ndxSuffix;
         if( viewDef.showCatalog ) retString += commaSeparator(retString) + "catalog" + ndxSuffix;
         if( viewDef.showCreateDate ) retString += commaSeparator(retString) + "createDate" + ndxSuffix;
         if( viewDef.showRegistryCatalog ) retString += commaSeparator(retString) + "registryCatalog" + ndxSuffix;
         if( viewDef.showProject ) retString += commaSeparator(retString) + "project" + ndxSuffix;
         if( viewDef.showTitleText ) retString += commaSeparator(retString) + "titleText" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(CoupleGroupInfoViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + CSVCell( ownerType);
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + CSVCell( ownerId);
         if( viewDef.showStatus ) retString += commaSeparator(retString) + CSVCell( status);
         if( viewDef.showMusicReceived ) retString += commaSeparator(retString) + CSVCell( musicReceived);
         if( viewDef.showMusicInfoDetails ) retString += commaSeparator(retString) + CSVCell( musicInfoDetails);
         if( viewDef.showInvitationReceived ) retString += commaSeparator(retString) + CSVCell( invitationReceived);
         if( viewDef.showInvitationInfoDetails ) retString += commaSeparator(retString) + CSVCell( invitationInfoDetails);
         if( viewDef.showProgramReceived ) retString += commaSeparator(retString) + CSVCell( programReceived);
         if( viewDef.showProgramInfoDetails ) retString += commaSeparator(retString) + CSVCell( programInfoDetails);
         if( viewDef.showPriceListVersion ) retString += commaSeparator(retString) + CSVCell( priceListVersion);
         if( viewDef.showHoursOnSite ) retString += commaSeparator(retString) + CSVCell( hoursOnSite);
         if( viewDef.showLoveStory ) retString += commaSeparator(retString) + CSVCell( loveStory);
         if( viewDef.showPhotoMontage ) retString += commaSeparator(retString) + CSVCell( photoMontage);
         if( viewDef.showCompleteCeremony ) retString += commaSeparator(retString) + CSVCell( completeCeremony);
         if( viewDef.showNumberOfDVDs ) retString += commaSeparator(retString) + CSVCell( numberOfDVDs);
         if( viewDef.showNegotiatedItems ) retString += commaSeparator(retString) + CSVCell( negotiatedItems);
         if( viewDef.showWebPublication ) retString += commaSeparator(retString) + CSVCell( webPublication);
         if( viewDef.showCatalog ) retString += commaSeparator(retString) + CSVCell( catalog);
         if( viewDef.showCreateDate ) retString += commaSeparator(retString) + CSVCell( createDate);
         if( viewDef.showRegistryCatalog ) retString += commaSeparator(retString) + CSVCell( registryCatalog);
         if( viewDef.showProject ) retString += commaSeparator(retString) + CSVCell( project);
         if( viewDef.showTitleText ) retString += commaSeparator(retString) + CSVCell( titleText);
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
      sysLogger.info( "DROP TABLE COUPLEGROUPINFO;" );
      sysLogger.info( "CREATE TABLE COUPLEGROUPINFO ( COUPLEGROUPINFO.OWNERTYPE integer, COUPLEGROUPINFO.OWNERID integer, COUPLEGROUPINFO.STATUS integer, COUPLEGROUPINFO.MUSICRECEIVED integer, COUPLEGROUPINFO.MUSICINFODETAILS char, COUPLEGROUPINFO.INVITATIONRECEIVED integer, COUPLEGROUPINFO.INVITATIONINFODETAILS char, COUPLEGROUPINFO.PROGRAMRECEIVED integer, COUPLEGROUPINFO.PROGRAMINFODETAILS char, COUPLEGROUPINFO.PriceListVersion char, COUPLEGROUPINFO.HoursOnSite integer, COUPLEGROUPINFO.LoveStory integer, COUPLEGROUPINFO.PhotoMontage integer, COUPLEGROUPINFO.CompleteCeremony integer, COUPLEGROUPINFO.NumberOfDVDs integer, COUPLEGROUPINFO.NegotiatedItems char, COUPLEGROUPINFO.WebPublication integer, COUPLEGROUPINFO.Catalog integer, COUPLEGROUPINFO.createDate Date, COUPLEGROUPINFO.registryCatalog integer, COUPLEGROUPINFO.project integer, COUPLEGROUPINFO.titletext char );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "CoupleGroupInfo Object:";
      retString += "\n    ownerType (COUPLEGROUPINFO.OWNERTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    ownerId (COUPLEGROUPINFO.OWNERID) -- ";
      retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    status (COUPLEGROUPINFO.STATUS) -- ";
      retString += "localVar=\"" + Integer.toString( status) + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    musicReceived (COUPLEGROUPINFO.MUSICRECEIVED) -- ";
      retString += "localVar=\"" + Integer.toString( musicReceived) + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    musicInfoDetails (COUPLEGROUPINFO.MUSICINFODETAILS) -- ";
      retString += "localVar=\"" + musicInfoDetails.toString() + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    invitationReceived (COUPLEGROUPINFO.INVITATIONRECEIVED) -- ";
      retString += "localVar=\"" + Integer.toString( invitationReceived) + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    invitationInfoDetails (COUPLEGROUPINFO.INVITATIONINFODETAILS) -- ";
      retString += "localVar=\"" + invitationInfoDetails.toString() + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    programReceived (COUPLEGROUPINFO.PROGRAMRECEIVED) -- ";
      retString += "localVar=\"" + Integer.toString( programReceived) + "\";  ";
      retString += dbColumns[7].toString();
      retString += "\n    programInfoDetails (COUPLEGROUPINFO.PROGRAMINFODETAILS) -- ";
      retString += "localVar=\"" + programInfoDetails.toString() + "\";  ";
      retString += dbColumns[8].toString();
      retString += "\n    priceListVersion (COUPLEGROUPINFO.PriceListVersion) -- ";
      retString += "localVar=\"" + priceListVersion.toString() + "\";  ";
      retString += dbColumns[9].toString();
      retString += "\n    hoursOnSite (COUPLEGROUPINFO.HoursOnSite) -- ";
      retString += "localVar=\"" + Integer.toString( hoursOnSite) + "\";  ";
      retString += dbColumns[10].toString();
      retString += "\n    loveStory (COUPLEGROUPINFO.LoveStory) -- ";
      retString += "localVar=\"" + Integer.toString( loveStory) + "\";  ";
      retString += dbColumns[11].toString();
      retString += "\n    photoMontage (COUPLEGROUPINFO.PhotoMontage) -- ";
      retString += "localVar=\"" + Integer.toString( photoMontage) + "\";  ";
      retString += dbColumns[12].toString();
      retString += "\n    completeCeremony (COUPLEGROUPINFO.CompleteCeremony) -- ";
      retString += "localVar=\"" + Integer.toString( completeCeremony) + "\";  ";
      retString += dbColumns[13].toString();
      retString += "\n    numberOfDVDs (COUPLEGROUPINFO.NumberOfDVDs) -- ";
      retString += "localVar=\"" + Integer.toString( numberOfDVDs) + "\";  ";
      retString += dbColumns[14].toString();
      retString += "\n    negotiatedItems (COUPLEGROUPINFO.NegotiatedItems) -- ";
      retString += "localVar=\"" + negotiatedItems.toString() + "\";  ";
      retString += dbColumns[15].toString();
      retString += "\n    webPublication (COUPLEGROUPINFO.WebPublication) -- ";
      retString += "localVar=\"" + Integer.toString( webPublication) + "\";  ";
      retString += dbColumns[16].toString();
      retString += "\n    catalog (COUPLEGROUPINFO.Catalog) -- ";
      retString += "localVar=\"" + Integer.toString( catalog) + "\";  ";
      retString += dbColumns[17].toString();
      retString += "\n    createDate (COUPLEGROUPINFO.createDate) -- ";
      retString += "localVar=\"" + createDate.toString() + "\";  ";
      retString += dbColumns[18].toString();
      retString += "\n    registryCatalog (COUPLEGROUPINFO.registryCatalog) -- ";
      retString += "localVar=\"" + Integer.toString( registryCatalog) + "\";  ";
      retString += dbColumns[19].toString();
      retString += "\n    project (COUPLEGROUPINFO.project) -- ";
      retString += "localVar=\"" + Integer.toString( project) + "\";  ";
      retString += dbColumns[20].toString();
      retString += "\n    titleText (COUPLEGROUPINFO.titletext) -- ";
      retString += "localVar=\"" + titleText.toString() + "\";  ";
      retString += dbColumns[21].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "musicInfoDetails", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "invitationInfoDetails", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "programInfoDetails", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "priceListVersion", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "negotiatedItems", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "createDate", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "titleText", label ); 
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
