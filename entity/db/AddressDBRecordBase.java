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
 
public class AddressDBRecordBase extends ServletRecord
{
 
   public static final int ADDRESSID = 0;
   public static final int OWNERID = 1;
   public static final int OWNERTYPE = 2;
   public static final int ADDRESSTYPE = 3;
   public static final int ADDRESSLINE1 = 4;
   public static final int ADDRESSLINE2 = 5;
   public static final int ADDRESSLINE3 = 6;
   public static final int CITY = 7;
   public static final int STATE = 8;
   public static final int COUNTRY = 9;
   public static final int POSTALCODE = 10;
 
   public static final String[] COLNAME = {
                                             "ADDRESS.ADDRESSID",
                                             "ADDRESS.OWNERID",
                                             "ADDRESS.OWNERTYPE",
                                             "ADDRESS.ADDRESSTYPE",
                                             "ADDRESS.ADDRESSLINE1",
                                             "ADDRESS.ADDRESSLINE2",
                                             "ADDRESS.ADDRESSLINE3",
                                             "ADDRESS.CITY",
                                             "ADDRESS.STATE",
                                             "ADDRESS.COUNTRY",
                                             "ADDRESS.POSTALCODE"
                                                    };
 
   protected int addressId;
   public    int getAddressId() { return( addressId ); }
   public     void setAddressId( int aAddressId ) { addressId = aAddressId; }
 
   protected int ownerId;
   public    int getOwnerId() { return( ownerId ); }
   public     void setOwnerId( int aOwnerId ) { ownerId = aOwnerId; }
 
   protected int ownerType;
   public    int getOwnerType() { return( ownerType ); }
   public     void setOwnerType( int aOwnerType ) { ownerType = aOwnerType; }
 
   protected int addressType;
   public    int getAddressType() { return( addressType ); }
   public     void setAddressType( int aAddressType ) { addressType = aAddressType; }
 
   protected String addressLine1 = "";
   public    String getAddressLine1() { return( addressLine1 ); }
   public     void setAddressLine1( String aAddressLine1 ) { addressLine1 = aAddressLine1; }
 
   protected String addressLine2 = "";
   public    String getAddressLine2() { return( addressLine2 ); }
   public     void setAddressLine2( String aAddressLine2 ) { addressLine2 = aAddressLine2; }
 
   protected String addressLine3 = "";
   public    String getAddressLine3() { return( addressLine3 ); }
   public     void setAddressLine3( String aAddressLine3 ) { addressLine3 = aAddressLine3; }
 
   protected String city = "";
   public    String getCity() { return( city ); }
   public     void setCity( String aCity ) { city = aCity; }
 
   protected String state = "";
   public    String getState() { return( state ); }
   public     void setState( String aState ) { state = aState; }
 
   protected String country = "";
   public    String getCountry() { return( country ); }
   public     void setCountry( String aCountry ) { country = aCountry; }
 
   protected String postalCode = "";
   public    String getPostalCode() { return( postalCode ); }
   public     void setPostalCode( String aPostalCode ) { postalCode = aPostalCode; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public AddressDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "AddressDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public AddressDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "AddressDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public AddressDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "AddressDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public AddressDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "AddressDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public AddressDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "AddressDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public AddressDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "AddressDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 11 ];
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "ADDRESS.ADDRESSID", "ADDRESS", "addressId" );
      dbColumns[1] = new ServletIntColumn( aDbData, "ADDRESS.OWNERID", "ADDRESS", "ownerId" );
      dbColumns[2] = new ServletIntColumn( aDbData, "ADDRESS.OWNERTYPE", "ADDRESS", "ownerType" );
      dbColumns[3] = new ServletIntColumn( aDbData, "ADDRESS.ADDRESSTYPE", "ADDRESS", "addressType" );
      dbColumns[4] = new ServletStringColumn( aDbData, "ADDRESS.ADDRESSLINE1", "ADDRESS", "addressLine1" );
      if ( addressLine1 == null ) addressLine1 = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
      dbColumns[5] = new ServletStringColumn( aDbData, "ADDRESS.ADDRESSLINE2", "ADDRESS", "addressLine2" );
      if ( addressLine2 == null ) addressLine2 = ((ServletStringColumn)dbColumns[5]).getValue(); // if it hasn't already been initialized...
      dbColumns[6] = new ServletStringColumn( aDbData, "ADDRESS.ADDRESSLINE3", "ADDRESS", "addressLine3" );
      if ( addressLine3 == null ) addressLine3 = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
      dbColumns[7] = new ServletStringColumn( aDbData, "ADDRESS.CITY", "ADDRESS", "city" );
      if ( city == null ) city = ((ServletStringColumn)dbColumns[7]).getValue(); // if it hasn't already been initialized...
      dbColumns[8] = new ServletStringColumn( aDbData, "ADDRESS.STATE", "ADDRESS", "state" );
      if ( state == null ) state = ((ServletStringColumn)dbColumns[8]).getValue(); // if it hasn't already been initialized...
      dbColumns[9] = new ServletStringColumn( aDbData, "ADDRESS.COUNTRY", "ADDRESS", "country" );
      if ( country == null ) country = ((ServletStringColumn)dbColumns[9]).getValue(); // if it hasn't already been initialized...
      dbColumns[10] = new ServletStringColumn( aDbData, "ADDRESS.POSTALCODE", "ADDRESS", "postalCode" );
      if ( postalCode == null ) postalCode = ((ServletStringColumn)dbColumns[10]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      addressId = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      ownerId = ((ServletIntColumn)dbColumns[1]).getValue();
      ownerType = ((ServletIntColumn)dbColumns[2]).getValue();
      addressType = ((ServletIntColumn)dbColumns[3]).getValue();
      addressLine1 = ((ServletStringColumn)dbColumns[4]).getValue();
      addressLine2 = ((ServletStringColumn)dbColumns[5]).getValue();
      addressLine3 = ((ServletStringColumn)dbColumns[6]).getValue();
      city = ((ServletStringColumn)dbColumns[7]).getValue();
      state = ((ServletStringColumn)dbColumns[8]).getValue();
      country = ((ServletStringColumn)dbColumns[9]).getValue();
      postalCode = ((ServletStringColumn)dbColumns[10]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( addressId );
      ((ServletIntColumn)dbColumns[1]).setValue( ownerId );
      ((ServletIntColumn)dbColumns[2]).setValue( ownerType );
      ((ServletIntColumn)dbColumns[3]).setValue( addressType );
      ((ServletStringColumn)dbColumns[4]).setValue( addressLine1 );
      ((ServletStringColumn)dbColumns[5]).setValue( addressLine2 );
      ((ServletStringColumn)dbColumns[6]).setValue( addressLine3 );
      ((ServletStringColumn)dbColumns[7]).setValue( city );
      ((ServletStringColumn)dbColumns[8]).setValue( state );
      ((ServletStringColumn)dbColumns[9]).setValue( country );
      ((ServletStringColumn)dbColumns[10]).setValue( postalCode );
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
      String retString = "\n" + prefix + "Address Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    addressId (ADDRESS.ADDRESSID) -- ";
         retString += "localVar=\"" + Integer.toString( addressId) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    ownerId (ADDRESS.OWNERID) -- ";
         retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    ownerType (ADDRESS.OWNERTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    addressType (ADDRESS.ADDRESSTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( addressType) + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    addressLine1 (ADDRESS.ADDRESSLINE1) -- ";
         retString += "localVar=\"" + addressLine1.toString() + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    addressLine2 (ADDRESS.ADDRESSLINE2) -- ";
         retString += "localVar=\"" + addressLine2.toString() + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    addressLine3 (ADDRESS.ADDRESSLINE3) -- ";
         retString += "localVar=\"" + addressLine3.toString() + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    city (ADDRESS.CITY) -- ";
         retString += "localVar=\"" + city.toString() + "\";  ";
         retString += dbColumns[7].toString();
         retString += "\n"+ prefix +   "    state (ADDRESS.STATE) -- ";
         retString += "localVar=\"" + state.toString() + "\";  ";
         retString += dbColumns[8].toString();
         retString += "\n"+ prefix +   "    country (ADDRESS.COUNTRY) -- ";
         retString += "localVar=\"" + country.toString() + "\";  ";
         retString += dbColumns[9].toString();
         retString += "\n"+ prefix +   "    postalCode (ADDRESS.POSTALCODE) -- ";
         retString += "localVar=\"" + postalCode.toString() + "\";  ";
         retString += dbColumns[10].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(AddressViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showAddressId ) retString += commaSeparator(retString) + "addressId" + ndxSuffix;
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + "ownerId" + ndxSuffix;
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + "ownerType" + ndxSuffix;
         if( viewDef.showAddressType ) retString += commaSeparator(retString) + "addressType" + ndxSuffix;
         if( viewDef.showAddressLine1 ) retString += commaSeparator(retString) + "addressLine1" + ndxSuffix;
         if( viewDef.showAddressLine2 ) retString += commaSeparator(retString) + "addressLine2" + ndxSuffix;
         if( viewDef.showAddressLine3 ) retString += commaSeparator(retString) + "addressLine3" + ndxSuffix;
         if( viewDef.showCity ) retString += commaSeparator(retString) + "city" + ndxSuffix;
         if( viewDef.showState ) retString += commaSeparator(retString) + "state" + ndxSuffix;
         if( viewDef.showCountry ) retString += commaSeparator(retString) + "country" + ndxSuffix;
         if( viewDef.showPostalCode ) retString += commaSeparator(retString) + "postalCode" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(AddressViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showAddressId ) retString += commaSeparator(retString) + CSVCell( addressId);
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + CSVCell( ownerId);
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + CSVCell( ownerType);
         if( viewDef.showAddressType ) retString += commaSeparator(retString) + CSVCell( addressType);
         if( viewDef.showAddressLine1 ) retString += commaSeparator(retString) + CSVCell( addressLine1);
         if( viewDef.showAddressLine2 ) retString += commaSeparator(retString) + CSVCell( addressLine2);
         if( viewDef.showAddressLine3 ) retString += commaSeparator(retString) + CSVCell( addressLine3);
         if( viewDef.showCity ) retString += commaSeparator(retString) + CSVCell( city);
         if( viewDef.showState ) retString += commaSeparator(retString) + CSVCell( state);
         if( viewDef.showCountry ) retString += commaSeparator(retString) + CSVCell( country);
         if( viewDef.showPostalCode ) retString += commaSeparator(retString) + CSVCell( postalCode);
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
      if ( !((ServletStringColumn)dbColumns[4]).isDbUpdateRequired() ) return(false); // column not changed, meaning it is still default value
      return( true );
   }
   public void getSQLCreateStatement()
   {
      sysLogger.info( "DROP TABLE ADDRESS;" );
      sysLogger.info( "CREATE TABLE ADDRESS ( ADDRESS.ADDRESSID integer, ADDRESS.OWNERID integer, ADDRESS.OWNERTYPE integer, ADDRESS.ADDRESSTYPE integer, ADDRESS.ADDRESSLINE1 char(100), ADDRESS.ADDRESSLINE2 char(100), ADDRESS.ADDRESSLINE3 char(100), ADDRESS.CITY char(50), ADDRESS.STATE char(20), ADDRESS.COUNTRY char(20), ADDRESS.POSTALCODE char(20) );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "Address Object:";
      retString += "\n    addressId (ADDRESS.ADDRESSID) -- ";
      retString += "localVar=\"" + Integer.toString( addressId) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    ownerId (ADDRESS.OWNERID) -- ";
      retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    ownerType (ADDRESS.OWNERTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    addressType (ADDRESS.ADDRESSTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( addressType) + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    addressLine1 (ADDRESS.ADDRESSLINE1) -- ";
      retString += "localVar=\"" + addressLine1.toString() + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    addressLine2 (ADDRESS.ADDRESSLINE2) -- ";
      retString += "localVar=\"" + addressLine2.toString() + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    addressLine3 (ADDRESS.ADDRESSLINE3) -- ";
      retString += "localVar=\"" + addressLine3.toString() + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    city (ADDRESS.CITY) -- ";
      retString += "localVar=\"" + city.toString() + "\";  ";
      retString += dbColumns[7].toString();
      retString += "\n    state (ADDRESS.STATE) -- ";
      retString += "localVar=\"" + state.toString() + "\";  ";
      retString += dbColumns[8].toString();
      retString += "\n    country (ADDRESS.COUNTRY) -- ";
      retString += "localVar=\"" + country.toString() + "\";  ";
      retString += dbColumns[9].toString();
      retString += "\n    postalCode (ADDRESS.POSTALCODE) -- ";
      retString += "localVar=\"" + postalCode.toString() + "\";  ";
      retString += dbColumns[10].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "addressLine1", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "addressLine2", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "addressLine3", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "city", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "state", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "country", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "postalCode", label ); 
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
