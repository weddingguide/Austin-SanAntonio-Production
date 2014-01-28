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
 
public class ContactDBRecordBase extends ServletRecord
{
 
   public static final int ID = 0;
   public static final int NAME = 1;
   public static final int CREATEDATE = 2;
   public static final int LASTUPDATE = 3;
 
   public static final String[] COLNAME = {
                                             "CONTACT.ID",
                                             "CONTACT.NAME",
                                             "CONTACT.CREATEDATE",
                                             "CONTACT.LASTUPDATE"
                                                    };
 
   protected int id;
   public    int getId() { return( id ); }
   public     void setId( int aId ) { id = aId; }
 
   protected String name = "";
   public    String getName() { return( name ); }
   public     void setName( String aName ) { name = aName; }
 
   protected java.sql.Date createDate;
   public    java.sql.Date getCreateDate() { return( createDate ); }
   public     void setCreateDate( java.sql.Date aCreateDate ) { createDate = aCreateDate; }
 
   protected Timestamp lastUpdate = new Timestamp( ( new java.util.Date()).getTime() );
   public    Timestamp getLastUpdate() { return( lastUpdate ); }
   public     void setLastUpdate( Timestamp aLastUpdate ) { lastUpdate = aLastUpdate; }
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "ContactDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "ContactDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "ContactDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "ContactDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "ContactDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ContactDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "ContactDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 4 ];
      dbColumns[0] = new ServletIntColumn( aDbData, "CONTACT.ID", "CONTACT", "id" );
      dbColumns[1] = new ServletStringColumn( aDbData, "CONTACT.NAME", "CONTACT", "name" );
      if ( name == null ) name = ((ServletStringColumn)dbColumns[1]).getValue(); // if it hasn't already been initialized...
      dbColumns[2] = new ServletDateColumn( aDbData, "CONTACT.CREATEDATE", "CONTACT", "createDate" );
      if ( createDate == null ) createDate = ((ServletDateColumn)dbColumns[2]).getValue(); // if it hasn't already been initialized...
      dbColumns[3] = new ServletTimestampColumn( aDbData, "CONTACT.LASTUPDATE", "CONTACT", "lastUpdate" );
      if ( lastUpdate == null ) lastUpdate = ((ServletTimestampColumn)dbColumns[3]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      id = ((ServletIntColumn)dbColumns[0]).getValue();
      name = ((ServletStringColumn)dbColumns[1]).getValue();
      createDate = ((ServletDateColumn)dbColumns[2]).getValue();
      lastUpdate = ((ServletTimestampColumn)dbColumns[3]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletIntColumn)dbColumns[0]).setValue( id );
      ((ServletStringColumn)dbColumns[1]).setValue( name );
      ((ServletDateColumn)dbColumns[2]).setValue( createDate );
      ((ServletTimestampColumn)dbColumns[3]).setValue( lastUpdate );
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
      String retString = "\n" + prefix + "Contact Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    id (CONTACT.ID) -- ";
         retString += "localVar=\"" + Integer.toString( id) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    name (CONTACT.NAME) -- ";
         retString += "localVar=\"" + name.toString() + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    createDate (CONTACT.CREATEDATE) -- ";
         retString += "localVar=\"" + createDate.toString() + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    lastUpdate (CONTACT.LASTUPDATE) -- ";
         retString += "localVar=\"" + lastUpdate.toString() + "\";  ";
         retString += dbColumns[3].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(ContactViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + "id" + ndxSuffix;
         if( viewDef.showName ) retString += commaSeparator(retString) + "name" + ndxSuffix;
         if( viewDef.showCreateDate ) retString += commaSeparator(retString) + "createDate" + ndxSuffix;
         if( viewDef.showLastUpdate ) retString += commaSeparator(retString) + "lastUpdate" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(ContactViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + CSVCell( id);
         if( viewDef.showName ) retString += commaSeparator(retString) + CSVCell( name);
         if( viewDef.showCreateDate ) retString += commaSeparator(retString) + CSVCell( createDate);
         if( viewDef.showLastUpdate ) retString += commaSeparator(retString) + CSVCell( lastUpdate);
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
      sysLogger.info( "DROP TABLE CONTACT;" );
      sysLogger.info( "CREATE TABLE CONTACT ( CONTACT.ID integer, CONTACT.NAME char, CONTACT.CREATEDATE Date, CONTACT.LASTUPDATE timestamp );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "Contact Object:";
      retString += "\n    id (CONTACT.ID) -- ";
      retString += "localVar=\"" + Integer.toString( id) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    name (CONTACT.NAME) -- ";
      retString += "localVar=\"" + name.toString() + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    createDate (CONTACT.CREATEDATE) -- ";
      retString += "localVar=\"" + createDate.toString() + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    lastUpdate (CONTACT.LASTUPDATE) -- ";
      retString += "localVar=\"" + lastUpdate.toString() + "\";  ";
      retString += dbColumns[3].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "name", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "createDate", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "lastUpdate", label ); 
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
