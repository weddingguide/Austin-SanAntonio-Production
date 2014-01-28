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
 
public class NNWedCoupleListDBRecordBase extends ServletRecord
{
 
   public static final int STATUS = 0;
   public static final int COUPLEID = 1;
   public static final int HISEMILADDRESS = 2;
   public static final int HISNAME = 3;
   public static final int HEREMAILADDRESS = 4;
   public static final int HERNAME = 5;
   public static final int HISLASTNAME = 6;
   public static final int HISFIRSTNAME = 7;
   public static final int HERLASTNAME = 8;
   public static final int HERFIRSTNAME = 9;
   public static final int DATEADDED = 10;
   public static final int DATEREMOVED = 11;
   public static final int WEDDINGDATE = 12;
   public static final int HISADDRESSLINE1 = 13;
   public static final int HISADDRESSLINE2 = 14;
   public static final int HISADDRESSLINE3 = 15;
   public static final int HERADDRESSLINE1 = 16;
   public static final int HERADDRESSLINE2 = 17;
   public static final int HERADDRESSLINE3 = 18;
   public static final int HISPHONE = 19;
   public static final int HERPHONE = 20;
   public static final int NOTES = 21;
   public static final int HISWORKPHONE = 22;
   public static final int HERWORKPHONE = 23;
   public static final int HISBIRTHDATE = 24;
   public static final int HERBIRTHDATE = 25;
 
   public static final String[] COLNAME = {
                                             "NNWEDCOUPLELIST.STATUS",
                                             "NNWEDCOUPLELIST.COUPLEID",
                                             "NNWEDCOUPLELIST.HISEMAILADDRESS",
                                             "NNWEDCOUPLELIST.HISNAME",
                                             "NNWEDCOUPLELIST.HEREMAILADDRESS",
                                             "NNWEDCOUPLELIST.HERNAME",
                                             "NNWEDCOUPLELIST.HISLASTNAME",
                                             "NNWEDCOUPLELIST.HISFIRSTNAME",
                                             "NNWEDCOUPLELIST.HERLASTNAME",
                                             "NNWEDCOUPLELIST.HERFIRSTNAME",
                                             "NNWEDCOUPLELIST.DATEADDED",
                                             "NNWEDCOUPLELIST.DATEREMOVED",
                                             "NNWEDCOUPLELIST.WEDDINGDATE",
                                             "NNWEDCOUPLELIST.HISADDRESSLINE1",
                                             "NNWEDCOUPLELIST.HISADDRESSLINE2",
                                             "NNWEDCOUPLELIST.HISADDRESSLINE3",
                                             "NNWEDCOUPLELIST.HERADDRESSLINE1",
                                             "NNWEDCOUPLELIST.HERADDRESSLINE2",
                                             "NNWEDCOUPLELIST.HERADDRESSLINE3",
                                             "NNWEDCOUPLELIST.HISPHONE",
                                             "NNWEDCOUPLELIST.HERPHONE",
                                             "NNWEDCOUPLELIST.NOTES",
                                             "NNWEDCOUPLELIST.HISWORKPHONE",
                                             "NNWEDCOUPLELIST.HERWORKPHONE",
                                             "NNWEDCOUPLELIST.HISBIRTHDATE",
                                             "NNWEDCOUPLELIST.HERBIRTHDATE"
                                                    };
 
   protected int status;
   public    int getStatus() { return( status ); }
   public     void setStatus( int aStatus ) { status = aStatus; }
 
   protected int coupleId;
   public    int getCoupleId() { return( coupleId ); }
   public     void setCoupleId( int aCoupleId ) { coupleId = aCoupleId; }
 
   protected String hisEmilAddress = "";
   public    String getHisEmilAddress() { return( hisEmilAddress ); }
   public     void setHisEmilAddress( String aHisEmilAddress ) { hisEmilAddress = aHisEmilAddress; }
 
   protected String hisName = "";
   public    String getHisName() { return( hisName ); }
   public     void setHisName( String aHisName ) { hisName = aHisName; }
 
   protected String herEmailAddress = "";
   public    String getHerEmailAddress() { return( herEmailAddress ); }
   public     void setHerEmailAddress( String aHerEmailAddress ) { herEmailAddress = aHerEmailAddress; }
 
   protected String herName = "";
   public    String getHerName() { return( herName ); }
   public     void setHerName( String aHerName ) { herName = aHerName; }
 
   protected String hisLastName = "";
   public    String getHisLastName() { return( hisLastName ); }
   public     void setHisLastName( String aHisLastName ) { hisLastName = aHisLastName; }
 
   protected String hisFirstName = "";
   public    String getHisFirstName() { return( hisFirstName ); }
   public     void setHisFirstName( String aHisFirstName ) { hisFirstName = aHisFirstName; }
 
   protected String herLastName = "";
   public    String getHerLastName() { return( herLastName ); }
   public     void setHerLastName( String aHerLastName ) { herLastName = aHerLastName; }
 
   protected String herFirstName = "";
   public    String getHerFirstName() { return( herFirstName ); }
   public     void setHerFirstName( String aHerFirstName ) { herFirstName = aHerFirstName; }
 
   protected java.sql.Date dateAdded;
   public    java.sql.Date getDateAdded() { return( dateAdded ); }
   public     void setDateAdded( java.sql.Date aDateAdded ) { dateAdded = aDateAdded; }
 
   protected java.sql.Date dateRemoved;
   public    java.sql.Date getDateRemoved() { return( dateRemoved ); }
   public     void setDateRemoved( java.sql.Date aDateRemoved ) { dateRemoved = aDateRemoved; }
 
   protected java.sql.Date weddingDate;
   public    java.sql.Date getWeddingDate() { return( weddingDate ); }
   public     void setWeddingDate( java.sql.Date aWeddingDate ) { weddingDate = aWeddingDate; }
 
   protected String hisAddressLine1 = "";
   public    String getHisAddressLine1() { return( hisAddressLine1 ); }
   public     void setHisAddressLine1( String aHisAddressLine1 ) { hisAddressLine1 = aHisAddressLine1; }
 
   protected String hisAddressLine2 = "";
   public    String getHisAddressLine2() { return( hisAddressLine2 ); }
   public     void setHisAddressLine2( String aHisAddressLine2 ) { hisAddressLine2 = aHisAddressLine2; }
 
   protected String hisAddressLine3 = "";
   public    String getHisAddressLine3() { return( hisAddressLine3 ); }
   public     void setHisAddressLine3( String aHisAddressLine3 ) { hisAddressLine3 = aHisAddressLine3; }
 
   protected String herAddressLine1 = "";
   public    String getHerAddressLine1() { return( herAddressLine1 ); }
   public     void setHerAddressLine1( String aHerAddressLine1 ) { herAddressLine1 = aHerAddressLine1; }
 
   protected String herAddressLine2 = "";
   public    String getHerAddressLine2() { return( herAddressLine2 ); }
   public     void setHerAddressLine2( String aHerAddressLine2 ) { herAddressLine2 = aHerAddressLine2; }
 
   protected String herAddressLine3 = "";
   public    String getHerAddressLine3() { return( herAddressLine3 ); }
   public     void setHerAddressLine3( String aHerAddressLine3 ) { herAddressLine3 = aHerAddressLine3; }
 
   protected String hisPhone = "";
   public    String getHisPhone() { return( hisPhone ); }
   public     void setHisPhone( String aHisPhone ) { hisPhone = aHisPhone; }
 
   protected String herPhone = "";
   public    String getHerPhone() { return( herPhone ); }
   public     void setHerPhone( String aHerPhone ) { herPhone = aHerPhone; }
 
   protected String notes = "";
   public    String getNotes() { return( notes ); }
   public     void setNotes( String aNotes ) { notes = aNotes; }
 
   protected String hisWorkPhone = "";
   public    String getHisWorkPhone() { return( hisWorkPhone ); }
   public     void setHisWorkPhone( String aHisWorkPhone ) { hisWorkPhone = aHisWorkPhone; }
 
   protected String herWorkPhone = "";
   public    String getHerWorkPhone() { return( herWorkPhone ); }
   public     void setHerWorkPhone( String aHerWorkPhone ) { herWorkPhone = aHerWorkPhone; }
 
   protected java.sql.Date hisBirthDate;
   public    java.sql.Date getHisBirthDate() { return( hisBirthDate ); }
   public     void setHisBirthDate( java.sql.Date aHisBirthDate ) { hisBirthDate = aHisBirthDate; }
 
   protected java.sql.Date herBirthDate;
   public    java.sql.Date getHerBirthDate() { return( herBirthDate ); }
   public     void setHerBirthDate( java.sql.Date aHerBirthDate ) { herBirthDate = aHerBirthDate; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public NNWedCoupleListDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "NNWedCoupleListDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public NNWedCoupleListDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "NNWedCoupleListDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public NNWedCoupleListDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "NNWedCoupleListDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public NNWedCoupleListDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "NNWedCoupleListDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public NNWedCoupleListDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "NNWedCoupleListDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public NNWedCoupleListDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "NNWedCoupleListDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 26 ];
      dbColumns[0] = new ServletIntColumn( aDbData, "NNWEDCOUPLELIST.STATUS", "NNWEDCOUPLELIST", "status" );
      dbColumns[1] = new ServletIntColumn( aDbData, "NNWEDCOUPLELIST.COUPLEID", "NNWEDCOUPLELIST", "coupleId" );
      dbColumns[2] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HISEMAILADDRESS", "NNWEDCOUPLELIST", "hisEmilAddress" );
      if ( hisEmilAddress == null ) hisEmilAddress = ((ServletStringColumn)dbColumns[2]).getValue(); // if it hasn't already been initialized...
      dbColumns[3] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HISNAME", "NNWEDCOUPLELIST", "hisName" );
      if ( hisName == null ) hisName = ((ServletStringColumn)dbColumns[3]).getValue(); // if it hasn't already been initialized...
      dbColumns[4] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HEREMAILADDRESS", "NNWEDCOUPLELIST", "herEmailAddress" );
      if ( herEmailAddress == null ) herEmailAddress = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
      dbColumns[5] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HERNAME", "NNWEDCOUPLELIST", "herName" );
      if ( herName == null ) herName = ((ServletStringColumn)dbColumns[5]).getValue(); // if it hasn't already been initialized...
      dbColumns[6] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HISLASTNAME", "NNWEDCOUPLELIST", "hisLastName" );
      if ( hisLastName == null ) hisLastName = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
      dbColumns[7] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HISFIRSTNAME", "NNWEDCOUPLELIST", "hisFirstName" );
      if ( hisFirstName == null ) hisFirstName = ((ServletStringColumn)dbColumns[7]).getValue(); // if it hasn't already been initialized...
      dbColumns[8] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HERLASTNAME", "NNWEDCOUPLELIST", "herLastName" );
      if ( herLastName == null ) herLastName = ((ServletStringColumn)dbColumns[8]).getValue(); // if it hasn't already been initialized...
      dbColumns[9] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HERFIRSTNAME", "NNWEDCOUPLELIST", "herFirstName" );
      if ( herFirstName == null ) herFirstName = ((ServletStringColumn)dbColumns[9]).getValue(); // if it hasn't already been initialized...
      dbColumns[10] = new ServletDateColumn( aDbData, "NNWEDCOUPLELIST.DATEADDED", "NNWEDCOUPLELIST", "dateAdded" );
      if ( dateAdded == null ) dateAdded = ((ServletDateColumn)dbColumns[10]).getValue(); // if it hasn't already been initialized...
      dbColumns[11] = new ServletDateColumn( aDbData, "NNWEDCOUPLELIST.DATEREMOVED", "NNWEDCOUPLELIST", "dateRemoved" );
      if ( dateRemoved == null ) dateRemoved = ((ServletDateColumn)dbColumns[11]).getValue(); // if it hasn't already been initialized...
      dbColumns[12] = new ServletDateColumn( aDbData, "NNWEDCOUPLELIST.WEDDINGDATE", "NNWEDCOUPLELIST", "weddingDate" );
      if ( weddingDate == null ) weddingDate = ((ServletDateColumn)dbColumns[12]).getValue(); // if it hasn't already been initialized...
      dbColumns[13] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HISADDRESSLINE1", "NNWEDCOUPLELIST", "hisAddressLine1" );
      if ( hisAddressLine1 == null ) hisAddressLine1 = ((ServletStringColumn)dbColumns[13]).getValue(); // if it hasn't already been initialized...
      dbColumns[14] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HISADDRESSLINE2", "NNWEDCOUPLELIST", "hisAddressLine2" );
      if ( hisAddressLine2 == null ) hisAddressLine2 = ((ServletStringColumn)dbColumns[14]).getValue(); // if it hasn't already been initialized...
      dbColumns[15] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HISADDRESSLINE3", "NNWEDCOUPLELIST", "hisAddressLine3" );
      if ( hisAddressLine3 == null ) hisAddressLine3 = ((ServletStringColumn)dbColumns[15]).getValue(); // if it hasn't already been initialized...
      dbColumns[16] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HERADDRESSLINE1", "NNWEDCOUPLELIST", "herAddressLine1" );
      if ( herAddressLine1 == null ) herAddressLine1 = ((ServletStringColumn)dbColumns[16]).getValue(); // if it hasn't already been initialized...
      dbColumns[17] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HERADDRESSLINE2", "NNWEDCOUPLELIST", "herAddressLine2" );
      if ( herAddressLine2 == null ) herAddressLine2 = ((ServletStringColumn)dbColumns[17]).getValue(); // if it hasn't already been initialized...
      dbColumns[18] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HERADDRESSLINE3", "NNWEDCOUPLELIST", "herAddressLine3" );
      if ( herAddressLine3 == null ) herAddressLine3 = ((ServletStringColumn)dbColumns[18]).getValue(); // if it hasn't already been initialized...
      dbColumns[19] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HISPHONE", "NNWEDCOUPLELIST", "hisPhone" );
      if ( hisPhone == null ) hisPhone = ((ServletStringColumn)dbColumns[19]).getValue(); // if it hasn't already been initialized...
      dbColumns[20] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HERPHONE", "NNWEDCOUPLELIST", "herPhone" );
      if ( herPhone == null ) herPhone = ((ServletStringColumn)dbColumns[20]).getValue(); // if it hasn't already been initialized...
      dbColumns[21] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.NOTES", "NNWEDCOUPLELIST", "notes" );
      if ( notes == null ) notes = ((ServletStringColumn)dbColumns[21]).getValue(); // if it hasn't already been initialized...
      dbColumns[22] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HISWORKPHONE", "NNWEDCOUPLELIST", "hisWorkPhone" );
      if ( hisWorkPhone == null ) hisWorkPhone = ((ServletStringColumn)dbColumns[22]).getValue(); // if it hasn't already been initialized...
      dbColumns[23] = new ServletStringColumn( aDbData, "NNWEDCOUPLELIST.HERWORKPHONE", "NNWEDCOUPLELIST", "herWorkPhone" );
      if ( herWorkPhone == null ) herWorkPhone = ((ServletStringColumn)dbColumns[23]).getValue(); // if it hasn't already been initialized...
      dbColumns[24] = new ServletDateColumn( aDbData, "NNWEDCOUPLELIST.HISBIRTHDATE", "NNWEDCOUPLELIST", "hisBirthDate" );
      if ( hisBirthDate == null ) hisBirthDate = ((ServletDateColumn)dbColumns[24]).getValue(); // if it hasn't already been initialized...
      dbColumns[25] = new ServletDateColumn( aDbData, "NNWEDCOUPLELIST.HERBIRTHDATE", "NNWEDCOUPLELIST", "herBirthDate" );
      if ( herBirthDate == null ) herBirthDate = ((ServletDateColumn)dbColumns[25]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      status = ((ServletIntColumn)dbColumns[0]).getValue();
      coupleId = ((ServletIntColumn)dbColumns[1]).getValue();
      hisEmilAddress = ((ServletStringColumn)dbColumns[2]).getValue();
      hisName = ((ServletStringColumn)dbColumns[3]).getValue();
      herEmailAddress = ((ServletStringColumn)dbColumns[4]).getValue();
      herName = ((ServletStringColumn)dbColumns[5]).getValue();
      hisLastName = ((ServletStringColumn)dbColumns[6]).getValue();
      hisFirstName = ((ServletStringColumn)dbColumns[7]).getValue();
      herLastName = ((ServletStringColumn)dbColumns[8]).getValue();
      herFirstName = ((ServletStringColumn)dbColumns[9]).getValue();
      dateAdded = ((ServletDateColumn)dbColumns[10]).getValue();
      dateRemoved = ((ServletDateColumn)dbColumns[11]).getValue();
      weddingDate = ((ServletDateColumn)dbColumns[12]).getValue();
      hisAddressLine1 = ((ServletStringColumn)dbColumns[13]).getValue();
      hisAddressLine2 = ((ServletStringColumn)dbColumns[14]).getValue();
      hisAddressLine3 = ((ServletStringColumn)dbColumns[15]).getValue();
      herAddressLine1 = ((ServletStringColumn)dbColumns[16]).getValue();
      herAddressLine2 = ((ServletStringColumn)dbColumns[17]).getValue();
      herAddressLine3 = ((ServletStringColumn)dbColumns[18]).getValue();
      hisPhone = ((ServletStringColumn)dbColumns[19]).getValue();
      herPhone = ((ServletStringColumn)dbColumns[20]).getValue();
      notes = ((ServletStringColumn)dbColumns[21]).getValue();
      hisWorkPhone = ((ServletStringColumn)dbColumns[22]).getValue();
      herWorkPhone = ((ServletStringColumn)dbColumns[23]).getValue();
      hisBirthDate = ((ServletDateColumn)dbColumns[24]).getValue();
      herBirthDate = ((ServletDateColumn)dbColumns[25]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletIntColumn)dbColumns[0]).setValue( status );
      ((ServletIntColumn)dbColumns[1]).setValue( coupleId );
      ((ServletStringColumn)dbColumns[2]).setValue( hisEmilAddress );
      ((ServletStringColumn)dbColumns[3]).setValue( hisName );
      ((ServletStringColumn)dbColumns[4]).setValue( herEmailAddress );
      ((ServletStringColumn)dbColumns[5]).setValue( herName );
      ((ServletStringColumn)dbColumns[6]).setValue( hisLastName );
      ((ServletStringColumn)dbColumns[7]).setValue( hisFirstName );
      ((ServletStringColumn)dbColumns[8]).setValue( herLastName );
      ((ServletStringColumn)dbColumns[9]).setValue( herFirstName );
      ((ServletDateColumn)dbColumns[10]).setValue( dateAdded );
      ((ServletDateColumn)dbColumns[11]).setValue( dateRemoved );
      ((ServletDateColumn)dbColumns[12]).setValue( weddingDate );
      ((ServletStringColumn)dbColumns[13]).setValue( hisAddressLine1 );
      ((ServletStringColumn)dbColumns[14]).setValue( hisAddressLine2 );
      ((ServletStringColumn)dbColumns[15]).setValue( hisAddressLine3 );
      ((ServletStringColumn)dbColumns[16]).setValue( herAddressLine1 );
      ((ServletStringColumn)dbColumns[17]).setValue( herAddressLine2 );
      ((ServletStringColumn)dbColumns[18]).setValue( herAddressLine3 );
      ((ServletStringColumn)dbColumns[19]).setValue( hisPhone );
      ((ServletStringColumn)dbColumns[20]).setValue( herPhone );
      ((ServletStringColumn)dbColumns[21]).setValue( notes );
      ((ServletStringColumn)dbColumns[22]).setValue( hisWorkPhone );
      ((ServletStringColumn)dbColumns[23]).setValue( herWorkPhone );
      ((ServletDateColumn)dbColumns[24]).setValue( hisBirthDate );
      ((ServletDateColumn)dbColumns[25]).setValue( herBirthDate );
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
      String retString = "\n" + prefix + "NNWedCoupleList Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    status (NNWEDCOUPLELIST.STATUS) -- ";
         retString += "localVar=\"" + Integer.toString( status) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    coupleId (NNWEDCOUPLELIST.COUPLEID) -- ";
         retString += "localVar=\"" + Integer.toString( coupleId) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    hisEmilAddress (NNWEDCOUPLELIST.HISEMAILADDRESS) -- ";
         retString += "localVar=\"" + hisEmilAddress.toString() + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    hisName (NNWEDCOUPLELIST.HISNAME) -- ";
         retString += "localVar=\"" + hisName.toString() + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    herEmailAddress (NNWEDCOUPLELIST.HEREMAILADDRESS) -- ";
         retString += "localVar=\"" + herEmailAddress.toString() + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    herName (NNWEDCOUPLELIST.HERNAME) -- ";
         retString += "localVar=\"" + herName.toString() + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    hisLastName (NNWEDCOUPLELIST.HISLASTNAME) -- ";
         retString += "localVar=\"" + hisLastName.toString() + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    hisFirstName (NNWEDCOUPLELIST.HISFIRSTNAME) -- ";
         retString += "localVar=\"" + hisFirstName.toString() + "\";  ";
         retString += dbColumns[7].toString();
         retString += "\n"+ prefix +   "    herLastName (NNWEDCOUPLELIST.HERLASTNAME) -- ";
         retString += "localVar=\"" + herLastName.toString() + "\";  ";
         retString += dbColumns[8].toString();
         retString += "\n"+ prefix +   "    herFirstName (NNWEDCOUPLELIST.HERFIRSTNAME) -- ";
         retString += "localVar=\"" + herFirstName.toString() + "\";  ";
         retString += dbColumns[9].toString();
         retString += "\n"+ prefix +   "    dateAdded (NNWEDCOUPLELIST.DATEADDED) -- ";
         retString += "localVar=\"" + dateAdded.toString() + "\";  ";
         retString += dbColumns[10].toString();
         retString += "\n"+ prefix +   "    dateRemoved (NNWEDCOUPLELIST.DATEREMOVED) -- ";
         retString += "localVar=\"" + dateRemoved.toString() + "\";  ";
         retString += dbColumns[11].toString();
         retString += "\n"+ prefix +   "    weddingDate (NNWEDCOUPLELIST.WEDDINGDATE) -- ";
         retString += "localVar=\"" + weddingDate.toString() + "\";  ";
         retString += dbColumns[12].toString();
         retString += "\n"+ prefix +   "    hisAddressLine1 (NNWEDCOUPLELIST.HISADDRESSLINE1) -- ";
         retString += "localVar=\"" + hisAddressLine1.toString() + "\";  ";
         retString += dbColumns[13].toString();
         retString += "\n"+ prefix +   "    hisAddressLine2 (NNWEDCOUPLELIST.HISADDRESSLINE2) -- ";
         retString += "localVar=\"" + hisAddressLine2.toString() + "\";  ";
         retString += dbColumns[14].toString();
         retString += "\n"+ prefix +   "    hisAddressLine3 (NNWEDCOUPLELIST.HISADDRESSLINE3) -- ";
         retString += "localVar=\"" + hisAddressLine3.toString() + "\";  ";
         retString += dbColumns[15].toString();
         retString += "\n"+ prefix +   "    herAddressLine1 (NNWEDCOUPLELIST.HERADDRESSLINE1) -- ";
         retString += "localVar=\"" + herAddressLine1.toString() + "\";  ";
         retString += dbColumns[16].toString();
         retString += "\n"+ prefix +   "    herAddressLine2 (NNWEDCOUPLELIST.HERADDRESSLINE2) -- ";
         retString += "localVar=\"" + herAddressLine2.toString() + "\";  ";
         retString += dbColumns[17].toString();
         retString += "\n"+ prefix +   "    herAddressLine3 (NNWEDCOUPLELIST.HERADDRESSLINE3) -- ";
         retString += "localVar=\"" + herAddressLine3.toString() + "\";  ";
         retString += dbColumns[18].toString();
         retString += "\n"+ prefix +   "    hisPhone (NNWEDCOUPLELIST.HISPHONE) -- ";
         retString += "localVar=\"" + hisPhone.toString() + "\";  ";
         retString += dbColumns[19].toString();
         retString += "\n"+ prefix +   "    herPhone (NNWEDCOUPLELIST.HERPHONE) -- ";
         retString += "localVar=\"" + herPhone.toString() + "\";  ";
         retString += dbColumns[20].toString();
         retString += "\n"+ prefix +   "    notes (NNWEDCOUPLELIST.NOTES) -- ";
         retString += "localVar=\"" + notes.toString() + "\";  ";
         retString += dbColumns[21].toString();
         retString += "\n"+ prefix +   "    hisWorkPhone (NNWEDCOUPLELIST.HISWORKPHONE) -- ";
         retString += "localVar=\"" + hisWorkPhone.toString() + "\";  ";
         retString += dbColumns[22].toString();
         retString += "\n"+ prefix +   "    herWorkPhone (NNWEDCOUPLELIST.HERWORKPHONE) -- ";
         retString += "localVar=\"" + herWorkPhone.toString() + "\";  ";
         retString += dbColumns[23].toString();
         retString += "\n"+ prefix +   "    hisBirthDate (NNWEDCOUPLELIST.HISBIRTHDATE) -- ";
         retString += "localVar=\"" + hisBirthDate.toString() + "\";  ";
         retString += dbColumns[24].toString();
         retString += "\n"+ prefix +   "    herBirthDate (NNWEDCOUPLELIST.HERBIRTHDATE) -- ";
         retString += "localVar=\"" + herBirthDate.toString() + "\";  ";
         retString += dbColumns[25].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(NNWedCoupleListViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showStatus ) retString += commaSeparator(retString) + "status" + ndxSuffix;
         if( viewDef.showCoupleId ) retString += commaSeparator(retString) + "coupleId" + ndxSuffix;
         if( viewDef.showHisEmilAddress ) retString += commaSeparator(retString) + "hisEmilAddress" + ndxSuffix;
         if( viewDef.showHisName ) retString += commaSeparator(retString) + "hisName" + ndxSuffix;
         if( viewDef.showHerEmailAddress ) retString += commaSeparator(retString) + "herEmailAddress" + ndxSuffix;
         if( viewDef.showHerName ) retString += commaSeparator(retString) + "herName" + ndxSuffix;
         if( viewDef.showHisLastName ) retString += commaSeparator(retString) + "hisLastName" + ndxSuffix;
         if( viewDef.showHisFirstName ) retString += commaSeparator(retString) + "hisFirstName" + ndxSuffix;
         if( viewDef.showHerLastName ) retString += commaSeparator(retString) + "herLastName" + ndxSuffix;
         if( viewDef.showHerFirstName ) retString += commaSeparator(retString) + "herFirstName" + ndxSuffix;
         if( viewDef.showDateAdded ) retString += commaSeparator(retString) + "dateAdded" + ndxSuffix;
         if( viewDef.showDateRemoved ) retString += commaSeparator(retString) + "dateRemoved" + ndxSuffix;
         if( viewDef.showWeddingDate ) retString += commaSeparator(retString) + "weddingDate" + ndxSuffix;
         if( viewDef.showHisAddressLine1 ) retString += commaSeparator(retString) + "hisAddressLine1" + ndxSuffix;
         if( viewDef.showHisAddressLine2 ) retString += commaSeparator(retString) + "hisAddressLine2" + ndxSuffix;
         if( viewDef.showHisAddressLine3 ) retString += commaSeparator(retString) + "hisAddressLine3" + ndxSuffix;
         if( viewDef.showHerAddressLine1 ) retString += commaSeparator(retString) + "herAddressLine1" + ndxSuffix;
         if( viewDef.showHerAddressLine2 ) retString += commaSeparator(retString) + "herAddressLine2" + ndxSuffix;
         if( viewDef.showHerAddressLine3 ) retString += commaSeparator(retString) + "herAddressLine3" + ndxSuffix;
         if( viewDef.showHisPhone ) retString += commaSeparator(retString) + "hisPhone" + ndxSuffix;
         if( viewDef.showHerPhone ) retString += commaSeparator(retString) + "herPhone" + ndxSuffix;
         if( viewDef.showNotes ) retString += commaSeparator(retString) + "notes" + ndxSuffix;
         if( viewDef.showHisWorkPhone ) retString += commaSeparator(retString) + "hisWorkPhone" + ndxSuffix;
         if( viewDef.showHerWorkPhone ) retString += commaSeparator(retString) + "herWorkPhone" + ndxSuffix;
         if( viewDef.showHisBirthDate ) retString += commaSeparator(retString) + "hisBirthDate" + ndxSuffix;
         if( viewDef.showHerBirthDate ) retString += commaSeparator(retString) + "herBirthDate" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(NNWedCoupleListViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showStatus ) retString += commaSeparator(retString) + CSVCell( status);
         if( viewDef.showCoupleId ) retString += commaSeparator(retString) + CSVCell( coupleId);
         if( viewDef.showHisEmilAddress ) retString += commaSeparator(retString) + CSVCell( hisEmilAddress);
         if( viewDef.showHisName ) retString += commaSeparator(retString) + CSVCell( hisName);
         if( viewDef.showHerEmailAddress ) retString += commaSeparator(retString) + CSVCell( herEmailAddress);
         if( viewDef.showHerName ) retString += commaSeparator(retString) + CSVCell( herName);
         if( viewDef.showHisLastName ) retString += commaSeparator(retString) + CSVCell( hisLastName);
         if( viewDef.showHisFirstName ) retString += commaSeparator(retString) + CSVCell( hisFirstName);
         if( viewDef.showHerLastName ) retString += commaSeparator(retString) + CSVCell( herLastName);
         if( viewDef.showHerFirstName ) retString += commaSeparator(retString) + CSVCell( herFirstName);
         if( viewDef.showDateAdded ) retString += commaSeparator(retString) + CSVCell( dateAdded);
         if( viewDef.showDateRemoved ) retString += commaSeparator(retString) + CSVCell( dateRemoved);
         if( viewDef.showWeddingDate ) retString += commaSeparator(retString) + CSVCell( weddingDate);
         if( viewDef.showHisAddressLine1 ) retString += commaSeparator(retString) + CSVCell( hisAddressLine1);
         if( viewDef.showHisAddressLine2 ) retString += commaSeparator(retString) + CSVCell( hisAddressLine2);
         if( viewDef.showHisAddressLine3 ) retString += commaSeparator(retString) + CSVCell( hisAddressLine3);
         if( viewDef.showHerAddressLine1 ) retString += commaSeparator(retString) + CSVCell( herAddressLine1);
         if( viewDef.showHerAddressLine2 ) retString += commaSeparator(retString) + CSVCell( herAddressLine2);
         if( viewDef.showHerAddressLine3 ) retString += commaSeparator(retString) + CSVCell( herAddressLine3);
         if( viewDef.showHisPhone ) retString += commaSeparator(retString) + CSVCell( hisPhone);
         if( viewDef.showHerPhone ) retString += commaSeparator(retString) + CSVCell( herPhone);
         if( viewDef.showNotes ) retString += commaSeparator(retString) + CSVCell( notes);
         if( viewDef.showHisWorkPhone ) retString += commaSeparator(retString) + CSVCell( hisWorkPhone);
         if( viewDef.showHerWorkPhone ) retString += commaSeparator(retString) + CSVCell( herWorkPhone);
         if( viewDef.showHisBirthDate ) retString += commaSeparator(retString) + CSVCell( hisBirthDate);
         if( viewDef.showHerBirthDate ) retString += commaSeparator(retString) + CSVCell( herBirthDate);
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
      sysLogger.info( "DROP TABLE NNWEDCOUPLELIST;" );
      sysLogger.info( "CREATE TABLE NNWEDCOUPLELIST ( NNWEDCOUPLELIST.STATUS integer, NNWEDCOUPLELIST.COUPLEID integer, NNWEDCOUPLELIST.HISEMAILADDRESS char(80), NNWEDCOUPLELIST.HISNAME char(80), NNWEDCOUPLELIST.HEREMAILADDRESS char(80), NNWEDCOUPLELIST.HERNAME char(80), NNWEDCOUPLELIST.HISLASTNAME char(30), NNWEDCOUPLELIST.HISFIRSTNAME char(30), NNWEDCOUPLELIST.HERLASTNAME char(30), NNWEDCOUPLELIST.HERFIRSTNAME char(30), NNWEDCOUPLELIST.DATEADDED Date, NNWEDCOUPLELIST.DATEREMOVED Date, NNWEDCOUPLELIST.WEDDINGDATE Date, NNWEDCOUPLELIST.HISADDRESSLINE1 char(50), NNWEDCOUPLELIST.HISADDRESSLINE2 char(50), NNWEDCOUPLELIST.HISADDRESSLINE3 char(50), NNWEDCOUPLELIST.HERADDRESSLINE1 char(50), NNWEDCOUPLELIST.HERADDRESSLINE2 char(50), NNWEDCOUPLELIST.HERADDRESSLINE3 char(50), NNWEDCOUPLELIST.HISPHONE char(20), NNWEDCOUPLELIST.HERPHONE char(20), NNWEDCOUPLELIST.NOTES char(250), NNWEDCOUPLELIST.HISWORKPHONE char(20), NNWEDCOUPLELIST.HERWORKPHONE char(20), NNWEDCOUPLELIST.HISBIRTHDATE Date, NNWEDCOUPLELIST.HERBIRTHDATE Date );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "NNWedCoupleList Object:";
      retString += "\n    status (NNWEDCOUPLELIST.STATUS) -- ";
      retString += "localVar=\"" + Integer.toString( status) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    coupleId (NNWEDCOUPLELIST.COUPLEID) -- ";
      retString += "localVar=\"" + Integer.toString( coupleId) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    hisEmilAddress (NNWEDCOUPLELIST.HISEMAILADDRESS) -- ";
      retString += "localVar=\"" + hisEmilAddress.toString() + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    hisName (NNWEDCOUPLELIST.HISNAME) -- ";
      retString += "localVar=\"" + hisName.toString() + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    herEmailAddress (NNWEDCOUPLELIST.HEREMAILADDRESS) -- ";
      retString += "localVar=\"" + herEmailAddress.toString() + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    herName (NNWEDCOUPLELIST.HERNAME) -- ";
      retString += "localVar=\"" + herName.toString() + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    hisLastName (NNWEDCOUPLELIST.HISLASTNAME) -- ";
      retString += "localVar=\"" + hisLastName.toString() + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    hisFirstName (NNWEDCOUPLELIST.HISFIRSTNAME) -- ";
      retString += "localVar=\"" + hisFirstName.toString() + "\";  ";
      retString += dbColumns[7].toString();
      retString += "\n    herLastName (NNWEDCOUPLELIST.HERLASTNAME) -- ";
      retString += "localVar=\"" + herLastName.toString() + "\";  ";
      retString += dbColumns[8].toString();
      retString += "\n    herFirstName (NNWEDCOUPLELIST.HERFIRSTNAME) -- ";
      retString += "localVar=\"" + herFirstName.toString() + "\";  ";
      retString += dbColumns[9].toString();
      retString += "\n    dateAdded (NNWEDCOUPLELIST.DATEADDED) -- ";
      retString += "localVar=\"" + dateAdded.toString() + "\";  ";
      retString += dbColumns[10].toString();
      retString += "\n    dateRemoved (NNWEDCOUPLELIST.DATEREMOVED) -- ";
      retString += "localVar=\"" + dateRemoved.toString() + "\";  ";
      retString += dbColumns[11].toString();
      retString += "\n    weddingDate (NNWEDCOUPLELIST.WEDDINGDATE) -- ";
      retString += "localVar=\"" + weddingDate.toString() + "\";  ";
      retString += dbColumns[12].toString();
      retString += "\n    hisAddressLine1 (NNWEDCOUPLELIST.HISADDRESSLINE1) -- ";
      retString += "localVar=\"" + hisAddressLine1.toString() + "\";  ";
      retString += dbColumns[13].toString();
      retString += "\n    hisAddressLine2 (NNWEDCOUPLELIST.HISADDRESSLINE2) -- ";
      retString += "localVar=\"" + hisAddressLine2.toString() + "\";  ";
      retString += dbColumns[14].toString();
      retString += "\n    hisAddressLine3 (NNWEDCOUPLELIST.HISADDRESSLINE3) -- ";
      retString += "localVar=\"" + hisAddressLine3.toString() + "\";  ";
      retString += dbColumns[15].toString();
      retString += "\n    herAddressLine1 (NNWEDCOUPLELIST.HERADDRESSLINE1) -- ";
      retString += "localVar=\"" + herAddressLine1.toString() + "\";  ";
      retString += dbColumns[16].toString();
      retString += "\n    herAddressLine2 (NNWEDCOUPLELIST.HERADDRESSLINE2) -- ";
      retString += "localVar=\"" + herAddressLine2.toString() + "\";  ";
      retString += dbColumns[17].toString();
      retString += "\n    herAddressLine3 (NNWEDCOUPLELIST.HERADDRESSLINE3) -- ";
      retString += "localVar=\"" + herAddressLine3.toString() + "\";  ";
      retString += dbColumns[18].toString();
      retString += "\n    hisPhone (NNWEDCOUPLELIST.HISPHONE) -- ";
      retString += "localVar=\"" + hisPhone.toString() + "\";  ";
      retString += dbColumns[19].toString();
      retString += "\n    herPhone (NNWEDCOUPLELIST.HERPHONE) -- ";
      retString += "localVar=\"" + herPhone.toString() + "\";  ";
      retString += dbColumns[20].toString();
      retString += "\n    notes (NNWEDCOUPLELIST.NOTES) -- ";
      retString += "localVar=\"" + notes.toString() + "\";  ";
      retString += dbColumns[21].toString();
      retString += "\n    hisWorkPhone (NNWEDCOUPLELIST.HISWORKPHONE) -- ";
      retString += "localVar=\"" + hisWorkPhone.toString() + "\";  ";
      retString += dbColumns[22].toString();
      retString += "\n    herWorkPhone (NNWEDCOUPLELIST.HERWORKPHONE) -- ";
      retString += "localVar=\"" + herWorkPhone.toString() + "\";  ";
      retString += dbColumns[23].toString();
      retString += "\n    hisBirthDate (NNWEDCOUPLELIST.HISBIRTHDATE) -- ";
      retString += "localVar=\"" + hisBirthDate.toString() + "\";  ";
      retString += dbColumns[24].toString();
      retString += "\n    herBirthDate (NNWEDCOUPLELIST.HERBIRTHDATE) -- ";
      retString += "localVar=\"" + herBirthDate.toString() + "\";  ";
      retString += dbColumns[25].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "hisEmilAddress", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "hisName", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "herEmailAddress", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "herName", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "hisLastName", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "hisFirstName", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "herLastName", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "herFirstName", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "dateAdded", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "dateRemoved", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "weddingDate", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "hisAddressLine1", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "hisAddressLine2", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "hisAddressLine3", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "herAddressLine1", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "herAddressLine2", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "herAddressLine3", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "hisPhone", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "herPhone", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "notes", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "hisWorkPhone", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "herWorkPhone", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "hisBirthDate", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "herBirthDate", label ); 
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
