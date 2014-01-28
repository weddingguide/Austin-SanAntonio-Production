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
 
public class EmailDBRecordBase extends ServletRecord
{
 
   public static final int EMAILID = 0;
   public static final int OWNERID = 1;
   public static final int OWNERTYPE = 2;
   public static final int SUBSCRIBE = 3;
   public static final int EMAILADDRESS = 4;
   public static final int EMAILADDRESSTYPE = 5;
   public static final int REFKEY = 6;
 
   public static final String[] COLNAME = {
                                             "EMAIL.EMAILID",
                                             "EMAIL.OWNERID",
                                             "EMAIL.OWNERTYPE",
                                             "EMAIL.SUBSCRIBE",
                                             "EMAIL.EMAILADDRESS",
                                             "EMAIL.EMAILADDRESSTYPE",
                                             "EMAIL.REFKEY"
                                                    };
 
   protected int emailId;
   public    int getEmailId() { return( emailId ); }
   public     void setEmailId( int aEmailId ) { emailId = aEmailId; }
 
   protected int ownerId;
   public    int getOwnerId() { return( ownerId ); }
   public     void setOwnerId( int aOwnerId ) { ownerId = aOwnerId; }
 
   protected int ownerType;
   public    int getOwnerType() { return( ownerType ); }
   public     void setOwnerType( int aOwnerType ) { ownerType = aOwnerType; }
 
   protected int subscribe;
   public    int getSubscribe() { return( subscribe ); }
   public     void setSubscribe( int aSubscribe ) { subscribe = aSubscribe; }
 
   protected String emailAddress = "";
   public    String getEmailAddress() { return( emailAddress ); }
   public     void setEmailAddress( String aEmailAddress ) { emailAddress = aEmailAddress; }
 
   protected int emailAddressType;
   public    int getEmailAddressType() { return( emailAddressType ); }
   public     void setEmailAddressType( int aEmailAddressType ) { emailAddressType = aEmailAddressType; }
 
   protected String refKey = "";
   public    String getRefKey() { return( refKey ); }
   public     void setRefKey( String aRefKey ) { refKey = aRefKey; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EmailDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "EmailDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EmailDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "EmailDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EmailDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "EmailDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EmailDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "EmailDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EmailDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "EmailDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EmailDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "EmailDBRecordBase constructor from array");
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
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "EMAIL.EMAILID", "EMAIL", "emailId" );
      dbColumns[1] = new ServletIntColumn( aDbData, "EMAIL.OWNERID", "EMAIL", "ownerId" );
      dbColumns[2] = new ServletIntColumn( aDbData, "EMAIL.OWNERTYPE", "EMAIL", "ownerType" );
      dbColumns[3] = new ServletBoolIntColumn( aDbData, "EMAIL.SUBSCRIBE", "EMAIL", "subscribe" );
      dbColumns[4] = new ServletStringColumn( aDbData, "EMAIL.EMAILADDRESS", "EMAIL", "emailAddress" );
      if ( emailAddress == null ) emailAddress = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
      dbColumns[5] = new ServletIntColumn( aDbData, "EMAIL.EMAILADDRESSTYPE", "EMAIL", "emailAddressType" );
      dbColumns[6] = new ServletStringColumn( aDbData, "EMAIL.REFKEY", "EMAIL", "refKey" );
      if ( refKey == null ) refKey = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      emailId = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      ownerId = ((ServletIntColumn)dbColumns[1]).getValue();
      ownerType = ((ServletIntColumn)dbColumns[2]).getValue();
      subscribe = ((ServletBoolIntColumn)dbColumns[3]).getValue();
      emailAddress = ((ServletStringColumn)dbColumns[4]).getValue();
      emailAddressType = ((ServletIntColumn)dbColumns[5]).getValue();
      refKey = ((ServletStringColumn)dbColumns[6]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( emailId );
      ((ServletIntColumn)dbColumns[1]).setValue( ownerId );
      ((ServletIntColumn)dbColumns[2]).setValue( ownerType );
      ((ServletBoolIntColumn)dbColumns[3]).setValue( subscribe );
      ((ServletStringColumn)dbColumns[4]).setValue( emailAddress );
      ((ServletIntColumn)dbColumns[5]).setValue( emailAddressType );
      ((ServletStringColumn)dbColumns[6]).setValue( refKey );
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
      String retString = "\n" + prefix + "Email Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    emailId (EMAIL.EMAILID) -- ";
         retString += "localVar=\"" + Integer.toString( emailId) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    ownerId (EMAIL.OWNERID) -- ";
         retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    ownerType (EMAIL.OWNERTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    subscribe (EMAIL.SUBSCRIBE) -- ";
         retString += "localVar=\"" + Integer.toString( subscribe) + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    emailAddress (EMAIL.EMAILADDRESS) -- ";
         retString += "localVar=\"" + emailAddress.toString() + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    emailAddressType (EMAIL.EMAILADDRESSTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( emailAddressType) + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    refKey (EMAIL.REFKEY) -- ";
         retString += "localVar=\"" + refKey.toString() + "\";  ";
         retString += dbColumns[6].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(EmailViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showEmailId ) retString += commaSeparator(retString) + "emailId" + ndxSuffix;
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + "ownerId" + ndxSuffix;
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + "ownerType" + ndxSuffix;
         if( viewDef.showSubscribe ) retString += commaSeparator(retString) + "subscribe" + ndxSuffix;
         if( viewDef.showEmailAddress ) retString += commaSeparator(retString) + "emailAddress" + ndxSuffix;
         if( viewDef.showEmailAddressType ) retString += commaSeparator(retString) + "emailAddressType" + ndxSuffix;
         if( viewDef.showRefKey ) retString += commaSeparator(retString) + "refKey" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(EmailViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showEmailId ) retString += commaSeparator(retString) + CSVCell( emailId);
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + CSVCell( ownerId);
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + CSVCell( ownerType);
         if( viewDef.showSubscribe ) retString += commaSeparator(retString) + CSVCell( subscribe);
         if( viewDef.showEmailAddress ) retString += commaSeparator(retString) + CSVCell( emailAddress);
         if( viewDef.showEmailAddressType ) retString += commaSeparator(retString) + CSVCell( emailAddressType);
         if( viewDef.showRefKey ) retString += commaSeparator(retString) + CSVCell( refKey);
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
      sysLogger.info( "DROP TABLE EMAIL;" );
      sysLogger.info( "CREATE TABLE EMAIL ( EMAIL.EMAILID integer, EMAIL.OWNERID integer, EMAIL.OWNERTYPE integer, EMAIL.SUBSCRIBE integer, EMAIL.EMAILADDRESS char(120), EMAIL.EMAILADDRESSTYPE integer, EMAIL.REFKEY char );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "Email Object:";
      retString += "\n    emailId (EMAIL.EMAILID) -- ";
      retString += "localVar=\"" + Integer.toString( emailId) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    ownerId (EMAIL.OWNERID) -- ";
      retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    ownerType (EMAIL.OWNERTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    subscribe (EMAIL.SUBSCRIBE) -- ";
      retString += "localVar=\"" + Integer.toString( subscribe) + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    emailAddress (EMAIL.EMAILADDRESS) -- ";
      retString += "localVar=\"" + emailAddress.toString() + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    emailAddressType (EMAIL.EMAILADDRESSTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( emailAddressType) + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    refKey (EMAIL.REFKEY) -- ";
      retString += "localVar=\"" + refKey.toString() + "\";  ";
      retString += dbColumns[6].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "emailAddress", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "refKey", label ); 
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
