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
 
public class AdDBRecordBase extends ServletRecord
{
 
   public static final int ID = 0;
   public static final int OWNERID = 1;
   public static final int ORDERNUMBER = 2;
   public static final int PARENTGROUP = 3;
   public static final int ADTYPE = 4;
   public static final int APPROVAL = 5;
   public static final int ADPLACEMENT = 6;
   public static final int ADNOTES = 7;
   public static final int STATUS = 8;
   public static final int PREMIUMPLACEMENT = 9;
   public static final int OPTIONALPLACEMENT = 10;
   public static final int CURRENTSTATEDUEDATE = 11;
 
   public static final String[] COLNAME = {
                                             "AD.ID",
                                             "AD.OWNERID",
                                             "AD.ORDERNUMBER",
                                             "AD.PARENTGROUP",
                                             "AD.ADTYPE",
                                             "AD.APPROVAL",
                                             "AD.ADPLACEMENT",
                                             "AD.ADNOTES",
                                             "AD.STATUS",
                                             "AD.PREMIUMPLACEMENT",
                                             "AD.OPTIONALPLACEMENT",
                                             "AD.CURRENTSTATEDUEDATE"
                                                    };
 
   protected int id;
   public    int getId() { return( id ); }
   public     void setId( int aId ) { id = aId; }
 
   protected int ownerId;
   public    int getOwnerId() { return( ownerId ); }
   public     void setOwnerId( int aOwnerId ) { ownerId = aOwnerId; }
 
   protected int orderNumber;
   public    int getOrderNumber() { return( orderNumber ); }
   public     void setOrderNumber( int aOrderNumber ) { orderNumber = aOrderNumber; }
 
   protected int parentGroup;
   public    int getParentGroup() { return( parentGroup ); }
   public     void setParentGroup( int aParentGroup ) { parentGroup = aParentGroup; }
 
   protected int adType;
   public    int getAdType() { return( adType ); }
   public     void setAdType( int aAdType ) { adType = aAdType; }
 
   protected String approval = "";
   public    String getApproval() { return( approval ); }
   public     void setApproval( String aApproval ) { approval = aApproval; }
 
   protected String adPlacement = "";
   public    String getAdPlacement() { return( adPlacement ); }
   public     void setAdPlacement( String aAdPlacement ) { adPlacement = aAdPlacement; }
 
   protected String adNotes = "";
   public    String getAdNotes() { return( adNotes ); }
   public     void setAdNotes( String aAdNotes ) { adNotes = aAdNotes; }
 
   protected int status;
   public    int getStatus() { return( status ); }
   public     void setStatus( int aStatus ) { status = aStatus; }
 
   protected int premiumPlacement;
   public    int getPremiumPlacement() { return( premiumPlacement ); }
   public     void setPremiumPlacement( int aPremiumPlacement ) { premiumPlacement = aPremiumPlacement; }
 
   protected int optionalPlacement;
   public    int getOptionalPlacement() { return( optionalPlacement ); }
   public     void setOptionalPlacement( int aOptionalPlacement ) { optionalPlacement = aOptionalPlacement; }
 
   protected java.sql.Date currentStateDueDate;
   public    java.sql.Date getCurrentStateDueDate() { return( currentStateDueDate ); }
   public     void setCurrentStateDueDate( java.sql.Date aCurrentStateDueDate ) { currentStateDueDate = aCurrentStateDueDate; }
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public AdDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "AdDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public AdDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "AdDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public AdDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "AdDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public AdDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "AdDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public AdDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "AdDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public AdDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "AdDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 12 ];
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "AD.ID", "AD", "id" );
      dbColumns[1] = new ServletIntColumn( aDbData, "AD.OWNERID", "AD", "ownerId" );
      dbColumns[2] = new ServletIntColumn( aDbData, "AD.ORDERNUMBER", "AD", "orderNumber" );
      dbColumns[3] = new ServletIntColumn( aDbData, "AD.PARENTGROUP", "AD", "parentGroup" );
      dbColumns[4] = new ServletIntColumn( aDbData, "AD.ADTYPE", "AD", "adType" );
      dbColumns[5] = new ServletStringColumn( aDbData, "AD.APPROVAL", "AD", "approval" );
      if ( approval == null ) approval = ((ServletStringColumn)dbColumns[5]).getValue(); // if it hasn't already been initialized...
      dbColumns[6] = new ServletStringColumn( aDbData, "AD.ADPLACEMENT", "AD", "adPlacement" );
      if ( adPlacement == null ) adPlacement = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
      dbColumns[7] = new ServletStringColumn( aDbData, "AD.ADNOTES", "AD", "adNotes" );
      if ( adNotes == null ) adNotes = ((ServletStringColumn)dbColumns[7]).getValue(); // if it hasn't already been initialized...
      dbColumns[8] = new ServletIntColumn( aDbData, "AD.STATUS", "AD", "status" );
      dbColumns[9] = new ServletIntColumn( aDbData, "AD.PREMIUMPLACEMENT", "AD", "premiumPlacement" );
      dbColumns[10] = new ServletIntColumn( aDbData, "AD.OPTIONALPLACEMENT", "AD", "optionalPlacement" );
      dbColumns[11] = new ServletDateColumn( aDbData, "AD.CURRENTSTATEDUEDATE", "AD", "currentStateDueDate" );
      if ( currentStateDueDate == null ) currentStateDueDate = ((ServletDateColumn)dbColumns[11]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      id = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      ownerId = ((ServletIntColumn)dbColumns[1]).getValue();
      orderNumber = ((ServletIntColumn)dbColumns[2]).getValue();
      parentGroup = ((ServletIntColumn)dbColumns[3]).getValue();
      adType = ((ServletIntColumn)dbColumns[4]).getValue();
      approval = ((ServletStringColumn)dbColumns[5]).getValue();
      adPlacement = ((ServletStringColumn)dbColumns[6]).getValue();
      adNotes = ((ServletStringColumn)dbColumns[7]).getValue();
      status = ((ServletIntColumn)dbColumns[8]).getValue();
      premiumPlacement = ((ServletIntColumn)dbColumns[9]).getValue();
      optionalPlacement = ((ServletIntColumn)dbColumns[10]).getValue();
      currentStateDueDate = ((ServletDateColumn)dbColumns[11]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( id );
      ((ServletIntColumn)dbColumns[1]).setValue( ownerId );
      ((ServletIntColumn)dbColumns[2]).setValue( orderNumber );
      ((ServletIntColumn)dbColumns[3]).setValue( parentGroup );
      ((ServletIntColumn)dbColumns[4]).setValue( adType );
      ((ServletStringColumn)dbColumns[5]).setValue( approval );
      ((ServletStringColumn)dbColumns[6]).setValue( adPlacement );
      ((ServletStringColumn)dbColumns[7]).setValue( adNotes );
      ((ServletIntColumn)dbColumns[8]).setValue( status );
      ((ServletIntColumn)dbColumns[9]).setValue( premiumPlacement );
      ((ServletIntColumn)dbColumns[10]).setValue( optionalPlacement );
      ((ServletDateColumn)dbColumns[11]).setValue( currentStateDueDate );
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
      String retString = "\n" + prefix + "Ad Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    id (AD.ID) -- ";
         retString += "localVar=\"" + Integer.toString( id) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    ownerId (AD.OWNERID) -- ";
         retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    orderNumber (AD.ORDERNUMBER) -- ";
         retString += "localVar=\"" + Integer.toString( orderNumber) + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    parentGroup (AD.PARENTGROUP) -- ";
         retString += "localVar=\"" + Integer.toString( parentGroup) + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    adType (AD.ADTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( adType) + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    approval (AD.APPROVAL) -- ";
         retString += "localVar=\"" + approval.toString() + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    adPlacement (AD.ADPLACEMENT) -- ";
         retString += "localVar=\"" + adPlacement.toString() + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    adNotes (AD.ADNOTES) -- ";
         retString += "localVar=\"" + adNotes.toString() + "\";  ";
         retString += dbColumns[7].toString();
         retString += "\n"+ prefix +   "    status (AD.STATUS) -- ";
         retString += "localVar=\"" + Integer.toString( status) + "\";  ";
         retString += dbColumns[8].toString();
         retString += "\n"+ prefix +   "    premiumPlacement (AD.PREMIUMPLACEMENT) -- ";
         retString += "localVar=\"" + Integer.toString( premiumPlacement) + "\";  ";
         retString += dbColumns[9].toString();
         retString += "\n"+ prefix +   "    optionalPlacement (AD.OPTIONALPLACEMENT) -- ";
         retString += "localVar=\"" + Integer.toString( optionalPlacement) + "\";  ";
         retString += dbColumns[10].toString();
         retString += "\n"+ prefix +   "    currentStateDueDate (AD.CURRENTSTATEDUEDATE) -- ";
         retString += "localVar=\"" + currentStateDueDate.toString() + "\";  ";
         retString += dbColumns[11].toString();
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
      System.out.println( "DROP TABLE AD;" );
      System.out.println( "CREATE TABLE AD ( AD.ID integer, AD.OWNERID integer, AD.ORDERNUMBER integer, AD.PARENTGROUP integer, AD.ADTYPE integer, AD.APPROVAL char, AD.ADPLACEMENT char, AD.ADNOTES char, AD.STATUS integer, AD.PREMIUMPLACEMENT integer, AD.OPTIONALPLACEMENT integer, AD.CURRENTSTATEDUEDATE Date );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "Ad Object:";
      retString += "\n    id (AD.ID) -- ";
      retString += "localVar=\"" + Integer.toString( id) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    ownerId (AD.OWNERID) -- ";
      retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    orderNumber (AD.ORDERNUMBER) -- ";
      retString += "localVar=\"" + Integer.toString( orderNumber) + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    parentGroup (AD.PARENTGROUP) -- ";
      retString += "localVar=\"" + Integer.toString( parentGroup) + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    adType (AD.ADTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( adType) + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    approval (AD.APPROVAL) -- ";
      retString += "localVar=\"" + approval.toString() + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    adPlacement (AD.ADPLACEMENT) -- ";
      retString += "localVar=\"" + adPlacement.toString() + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    adNotes (AD.ADNOTES) -- ";
      retString += "localVar=\"" + adNotes.toString() + "\";  ";
      retString += dbColumns[7].toString();
      retString += "\n    status (AD.STATUS) -- ";
      retString += "localVar=\"" + Integer.toString( status) + "\";  ";
      retString += dbColumns[8].toString();
      retString += "\n    premiumPlacement (AD.PREMIUMPLACEMENT) -- ";
      retString += "localVar=\"" + Integer.toString( premiumPlacement) + "\";  ";
      retString += dbColumns[9].toString();
      retString += "\n    optionalPlacement (AD.OPTIONALPLACEMENT) -- ";
      retString += "localVar=\"" + Integer.toString( optionalPlacement) + "\";  ";
      retString += dbColumns[10].toString();
      retString += "\n    currentStateDueDate (AD.CURRENTSTATEDUEDATE) -- ";
      retString += "localVar=\"" + currentStateDueDate.toString() + "\";  ";
      retString += dbColumns[11].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "approval", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "adPlacement", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "adNotes", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "currentStateDueDate", label ); 
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
