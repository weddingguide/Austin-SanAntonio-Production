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
 
public class PhoneDBRecordBase extends ServletRecord
{
 
   public static final int PHONEID = 0;
   public static final int OWNERID = 1;
   public static final int OWNERTYPE = 2;
   public static final int PHONENUMBER = 3;
   public static final int PHONENUMBERTYPE = 4;
 
   public static final String[] COLNAME = {
                                             "PHONE.PHONEID",
                                             "PHONE.OWNERID",
                                             "PHONE.OWNERTYPE",
                                             "PHONE.PHONENUMBER",
                                             "PHONE.PHONENUMBERTYPE"
                                                    };
 
   protected int phoneId;
   public    int getPhoneId() { return( phoneId ); }
   public     void setPhoneId( int aPhoneId ) { phoneId = aPhoneId; }
 
   protected int ownerId;
   public    int getOwnerId() { return( ownerId ); }
   public     void setOwnerId( int aOwnerId ) { ownerId = aOwnerId; }
 
   protected int ownerType;
   public    int getOwnerType() { return( ownerType ); }
   public     void setOwnerType( int aOwnerType ) { ownerType = aOwnerType; }
 
   protected String phoneNumber = "";
   public    String getPhoneNumber() { return( phoneNumber ); }
   public     void setPhoneNumber( String aPhoneNumber ) { phoneNumber = aPhoneNumber; }
 
   protected int phoneNumberType;
   public    int getPhoneNumberType() { return( phoneNumberType ); }
   public     void setPhoneNumberType( int aPhoneNumberType ) { phoneNumberType = aPhoneNumberType; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PhoneDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "PhoneDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PhoneDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "PhoneDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PhoneDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "PhoneDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PhoneDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "PhoneDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PhoneDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "PhoneDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PhoneDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "PhoneDBRecordBase constructor from array");
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
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "PHONE.PHONEID", "PHONE", "phoneId" );
      dbColumns[1] = new ServletIntColumn( aDbData, "PHONE.OWNERID", "PHONE", "ownerId" );
      dbColumns[2] = new ServletIntColumn( aDbData, "PHONE.OWNERTYPE", "PHONE", "ownerType" );
      dbColumns[3] = new ServletStringColumn( aDbData, "PHONE.PHONENUMBER", "PHONE", "phoneNumber" );
      if ( phoneNumber == null ) phoneNumber = ((ServletStringColumn)dbColumns[3]).getValue(); // if it hasn't already been initialized...
      dbColumns[4] = new ServletIntColumn( aDbData, "PHONE.PHONENUMBERTYPE", "PHONE", "phoneNumberType" );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      phoneId = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      ownerId = ((ServletIntColumn)dbColumns[1]).getValue();
      ownerType = ((ServletIntColumn)dbColumns[2]).getValue();
      phoneNumber = ((ServletStringColumn)dbColumns[3]).getValue();
      phoneNumberType = ((ServletIntColumn)dbColumns[4]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( phoneId );
      ((ServletIntColumn)dbColumns[1]).setValue( ownerId );
      ((ServletIntColumn)dbColumns[2]).setValue( ownerType );
      ((ServletStringColumn)dbColumns[3]).setValue( phoneNumber );
      ((ServletIntColumn)dbColumns[4]).setValue( phoneNumberType );
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
      String retString = "\n" + prefix + "Phone Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    phoneId (PHONE.PHONEID) -- ";
         retString += "localVar=\"" + Integer.toString( phoneId) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    ownerId (PHONE.OWNERID) -- ";
         retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    ownerType (PHONE.OWNERTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    phoneNumber (PHONE.PHONENUMBER) -- ";
         retString += "localVar=\"" + phoneNumber.toString() + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    phoneNumberType (PHONE.PHONENUMBERTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( phoneNumberType) + "\";  ";
         retString += dbColumns[4].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(PhoneViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showPhoneId ) retString += commaSeparator(retString) + "phoneId" + ndxSuffix;
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + "ownerId" + ndxSuffix;
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + "ownerType" + ndxSuffix;
         if( viewDef.showPhoneNumber ) retString += commaSeparator(retString) + "phoneNumber" + ndxSuffix;
         if( viewDef.showPhoneNumberType ) retString += commaSeparator(retString) + "phoneNumberType" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(PhoneViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showPhoneId ) retString += commaSeparator(retString) + CSVCell( phoneId);
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + CSVCell( ownerId);
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + CSVCell( ownerType);
         if( viewDef.showPhoneNumber ) retString += commaSeparator(retString) + CSVCell( phoneNumber);
         if( viewDef.showPhoneNumberType ) retString += commaSeparator(retString) + CSVCell( phoneNumberType);
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
      if ( !((ServletStringColumn)dbColumns[3]).isDbUpdateRequired() ) return(false); // column not changed, meaning it is still default value
      return( true );
   }
   public void getSQLCreateStatement()
   {
      sysLogger.info( "DROP TABLE PHONE;" );
      sysLogger.info( "CREATE TABLE PHONE ( PHONE.PHONEID integer, PHONE.OWNERID integer, PHONE.OWNERTYPE integer, PHONE.PHONENUMBER char(20), PHONE.PHONENUMBERTYPE integer );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "Phone Object:";
      retString += "\n    phoneId (PHONE.PHONEID) -- ";
      retString += "localVar=\"" + Integer.toString( phoneId) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    ownerId (PHONE.OWNERID) -- ";
      retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    ownerType (PHONE.OWNERTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    phoneNumber (PHONE.PHONENUMBER) -- ";
      retString += "localVar=\"" + phoneNumber.toString() + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    phoneNumberType (PHONE.PHONENUMBERTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( phoneNumberType) + "\";  ";
      retString += dbColumns[4].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "phoneNumber", label ); 
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
