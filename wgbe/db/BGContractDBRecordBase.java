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
 
public class BGContractDBRecordBase extends ServletRecord
{
 
   public static final int ID = 0;
   public static final int OWNERID = 1;
   public static final int CONTRACTDATE = 2;
   public static final int CONTRACTTERM = 3;
   public static final int REGIONGROUPID = 4;
   public static final int INITIALWGEDITION = 5;
   public static final int FULLMKTPKG = 6;
   public static final int ADPROD = 7;
 
   public static final String[] COLNAME = {
                                             "BGCONTRACT.ID",
                                             "BGCONTRACT.OWNERID",
                                             "BGCONTRACT.CONTRACTDATE",
                                             "BGCONTRACT.CONTRACTTERM",
                                             "BGCONTRACT.REGIONGROUPID",
                                             "BGCONTRACT.INITIALWGEDITION",
                                             "BGCONTRACT.FULLMKTPKG",
                                             "BGCONTRACT.ADPROD"
                                                    };
 
   protected int id;
   public    int getId() { return( id ); }
   public     void setId( int aId ) { id = aId; }
 
   protected int ownerId;
   public    int getOwnerId() { return( ownerId ); }
   public     void setOwnerId( int aOwnerId ) { ownerId = aOwnerId; }
 
   protected java.sql.Date contractDate;
   public    java.sql.Date getContractDate() { return( contractDate ); }
   public     void setContractDate( java.sql.Date aContractDate ) { contractDate = aContractDate; }
 
   protected int contractTerm;
   public    int getContractTerm() { return( contractTerm ); }
   public     void setContractTerm( int aContractTerm ) { contractTerm = aContractTerm; }
 
   protected int regionGroupId;
   public    int getRegionGroupId() { return( regionGroupId ); }
   public     void setRegionGroupId( int aRegionGroupId ) { regionGroupId = aRegionGroupId; }
 
   protected int initialWGEdition;
   public    int getInitialWGEdition() { return( initialWGEdition ); }
   public     void setInitialWGEdition( int aInitialWGEdition ) { initialWGEdition = aInitialWGEdition; }
 
   protected int fullMktPkg;
   public    int getFullMktPkg() { return( fullMktPkg ); }
   public     void setFullMktPkg( int aFullMktPkg ) { fullMktPkg = aFullMktPkg; }
 
   protected String adProd = "";
   public    String getAdProd() { return( adProd ); }
   public     void setAdProd( String aAdProd ) { adProd = aAdProd; }
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public BGContractDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "BGContractDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public BGContractDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "BGContractDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public BGContractDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "BGContractDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public BGContractDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "BGContractDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public BGContractDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "BGContractDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public BGContractDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "BGContractDBRecordBase constructor from array");
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
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "BGCONTRACT.ID", "BGCONTRACT", "id" );
      dbColumns[1] = new ServletIntColumn( aDbData, "BGCONTRACT.OWNERID", "BGCONTRACT", "ownerId" );
      dbColumns[2] = new ServletDateColumn( aDbData, "BGCONTRACT.CONTRACTDATE", "BGCONTRACT", "contractDate" );
      if ( contractDate == null ) contractDate = ((ServletDateColumn)dbColumns[2]).getValue(); // if it hasn't already been initialized...
      dbColumns[3] = new ServletIntColumn( aDbData, "BGCONTRACT.CONTRACTTERM", "BGCONTRACT", "contractTerm" );
      dbColumns[4] = new ServletIntColumn( aDbData, "BGCONTRACT.REGIONGROUPID", "BGCONTRACT", "regionGroupId" );
      dbColumns[5] = new ServletIntColumn( aDbData, "BGCONTRACT.INITIALWGEDITION", "BGCONTRACT", "initialWGEdition" );
      dbColumns[6] = new ServletBoolIntColumn( aDbData, "BGCONTRACT.FULLMKTPKG", "BGCONTRACT", "fullMktPkg" );
      dbColumns[7] = new ServletStringColumn( aDbData, "BGCONTRACT.ADPROD", "BGCONTRACT", "adProd" );
      if ( adProd == null ) adProd = ((ServletStringColumn)dbColumns[7]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      id = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      ownerId = ((ServletIntColumn)dbColumns[1]).getValue();
      contractDate = ((ServletDateColumn)dbColumns[2]).getValue();
      contractTerm = ((ServletIntColumn)dbColumns[3]).getValue();
      regionGroupId = ((ServletIntColumn)dbColumns[4]).getValue();
      initialWGEdition = ((ServletIntColumn)dbColumns[5]).getValue();
      fullMktPkg = ((ServletBoolIntColumn)dbColumns[6]).getValue();
      adProd = ((ServletStringColumn)dbColumns[7]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( id );
      ((ServletIntColumn)dbColumns[1]).setValue( ownerId );
      ((ServletDateColumn)dbColumns[2]).setValue( contractDate );
      ((ServletIntColumn)dbColumns[3]).setValue( contractTerm );
      ((ServletIntColumn)dbColumns[4]).setValue( regionGroupId );
      ((ServletIntColumn)dbColumns[5]).setValue( initialWGEdition );
      ((ServletBoolIntColumn)dbColumns[6]).setValue( fullMktPkg );
      ((ServletStringColumn)dbColumns[7]).setValue( adProd );
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
      String retString = "\n" + prefix + "BGContract Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    id (BGCONTRACT.ID) -- ";
         retString += "localVar=\"" + Integer.toString( id) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    ownerId (BGCONTRACT.OWNERID) -- ";
         retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    contractDate (BGCONTRACT.CONTRACTDATE) -- ";
         retString += "localVar=\"" + contractDate.toString() + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    contractTerm (BGCONTRACT.CONTRACTTERM) -- ";
         retString += "localVar=\"" + Integer.toString( contractTerm) + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    regionGroupId (BGCONTRACT.REGIONGROUPID) -- ";
         retString += "localVar=\"" + Integer.toString( regionGroupId) + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    initialWGEdition (BGCONTRACT.INITIALWGEDITION) -- ";
         retString += "localVar=\"" + Integer.toString( initialWGEdition) + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    fullMktPkg (BGCONTRACT.FULLMKTPKG) -- ";
         retString += "localVar=\"" + Integer.toString( fullMktPkg) + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    adProd (BGCONTRACT.ADPROD) -- ";
         retString += "localVar=\"" + adProd.toString() + "\";  ";
         retString += dbColumns[7].toString();
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
      System.out.println( "DROP TABLE BGCONTRACT;" );
      System.out.println( "CREATE TABLE BGCONTRACT ( BGCONTRACT.ID integer, BGCONTRACT.OWNERID integer, BGCONTRACT.CONTRACTDATE Date, BGCONTRACT.CONTRACTTERM integer, BGCONTRACT.REGIONGROUPID integer, BGCONTRACT.INITIALWGEDITION integer, BGCONTRACT.FULLMKTPKG integer, BGCONTRACT.ADPROD char );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "BGContract Object:";
      retString += "\n    id (BGCONTRACT.ID) -- ";
      retString += "localVar=\"" + Integer.toString( id) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    ownerId (BGCONTRACT.OWNERID) -- ";
      retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    contractDate (BGCONTRACT.CONTRACTDATE) -- ";
      retString += "localVar=\"" + contractDate.toString() + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    contractTerm (BGCONTRACT.CONTRACTTERM) -- ";
      retString += "localVar=\"" + Integer.toString( contractTerm) + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    regionGroupId (BGCONTRACT.REGIONGROUPID) -- ";
      retString += "localVar=\"" + Integer.toString( regionGroupId) + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    initialWGEdition (BGCONTRACT.INITIALWGEDITION) -- ";
      retString += "localVar=\"" + Integer.toString( initialWGEdition) + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    fullMktPkg (BGCONTRACT.FULLMKTPKG) -- ";
      retString += "localVar=\"" + Integer.toString( fullMktPkg) + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    adProd (BGCONTRACT.ADPROD) -- ";
      retString += "localVar=\"" + adProd.toString() + "\";  ";
      retString += dbColumns[7].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "contractDate", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "adProd", label ); 
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
