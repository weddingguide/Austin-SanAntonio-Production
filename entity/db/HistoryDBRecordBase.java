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
 
public class HistoryDBRecordBase extends ServletRecord
{
 
   public static final int EVENTID = 0;
   public static final int EVENTTYPE = 1;
   public static final int DATE = 2;
   public static final int OWNERID = 3;
   public static final int OWNERTYPE = 4;
   public static final int DESCRIPTION = 5;
   public static final int COMMENT = 6;
   public static final int ORIGINATOR = 7;
   public static final int REFERENCE = 8;
 
   public static final String[] COLNAME = {
                                             "HISTORY.EVENTID",
                                             "HISTORY.EVENTTYPE",
                                             "HISTORY.DATE",
                                             "HISTORY.OWNERID",
                                             "HISTORY.OWNERTYPE",
                                             "HISTORY.DESCRIPTION",
                                             "HISTORY.COMMENT",
                                             "HISTORY.ORIGINATOR",
                                             "HISTORY.REFERENCE"
                                                    };
 
   protected int eventId;
   public    int getEventId() { return( eventId ); }
   public     void setEventId( int aEventId ) { eventId = aEventId; }
 
   protected int eventType;
   public    int getEventType() { return( eventType ); }
   public     void setEventType( int aEventType ) { eventType = aEventType; }
 
   protected Timestamp date = new Timestamp( ( new java.util.Date()).getTime() );
   public    Timestamp getDate() { return( date ); }
   public     void setDate( Timestamp aDate ) { date = aDate; }
 
   protected int ownerId;
   public    int getOwnerId() { return( ownerId ); }
   public     void setOwnerId( int aOwnerId ) { ownerId = aOwnerId; }
 
   protected int ownerType;
   public    int getOwnerType() { return( ownerType ); }
   public     void setOwnerType( int aOwnerType ) { ownerType = aOwnerType; }
 
   protected String description = "";
   public    String getDescription() { return( description ); }
   public     void setDescription( String aDescription ) { description = aDescription; }
 
   protected String comment = "";
   public    String getComment() { return( comment ); }
   public     void setComment( String aComment ) { comment = aComment; }
 
   protected String originator = "";
   public    String getOriginator() { return( originator ); }
   public     void setOriginator( String aOriginator ) { originator = aOriginator; }
 
   protected String reference = "";
   public    String getReference() { return( reference ); }
   public     void setReference( String aReference ) { reference = aReference; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public HistoryDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "HistoryDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public HistoryDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "HistoryDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public HistoryDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "HistoryDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public HistoryDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "HistoryDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public HistoryDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "HistoryDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public HistoryDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "HistoryDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 9 ];
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "HISTORY.EVENTID", "HISTORY", "eventId" );
      dbColumns[1] = new ServletIntColumn( aDbData, "HISTORY.EVENTTYPE", "HISTORY", "eventType" );
      dbColumns[2] = new ServletTimestampColumn( aDbData, "HISTORY.DATE", "HISTORY", "date" );
      if ( date == null ) date = ((ServletTimestampColumn)dbColumns[2]).getValue(); // if it hasn't already been initialized...
      dbColumns[3] = new ServletIntColumn( aDbData, "HISTORY.OWNERID", "HISTORY", "ownerId" );
      dbColumns[4] = new ServletIntColumn( aDbData, "HISTORY.OWNERTYPE", "HISTORY", "ownerType" );
      dbColumns[5] = new ServletStringColumn( aDbData, "HISTORY.DESCRIPTION", "HISTORY", "description" );
      if ( description == null ) description = ((ServletStringColumn)dbColumns[5]).getValue(); // if it hasn't already been initialized...
      dbColumns[6] = new ServletStringColumn( aDbData, "HISTORY.COMMENT", "HISTORY", "comment" );
      if ( comment == null ) comment = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
      dbColumns[7] = new ServletStringColumn( aDbData, "HISTORY.ORIGINATOR", "HISTORY", "originator" );
      if ( originator == null ) originator = ((ServletStringColumn)dbColumns[7]).getValue(); // if it hasn't already been initialized...
      dbColumns[8] = new ServletStringColumn( aDbData, "HISTORY.REFERENCE", "HISTORY", "reference" );
      if ( reference == null ) reference = ((ServletStringColumn)dbColumns[8]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      eventId = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      eventType = ((ServletIntColumn)dbColumns[1]).getValue();
      date = ((ServletTimestampColumn)dbColumns[2]).getValue();
      ownerId = ((ServletIntColumn)dbColumns[3]).getValue();
      ownerType = ((ServletIntColumn)dbColumns[4]).getValue();
      description = ((ServletStringColumn)dbColumns[5]).getValue();
      comment = ((ServletStringColumn)dbColumns[6]).getValue();
      originator = ((ServletStringColumn)dbColumns[7]).getValue();
      reference = ((ServletStringColumn)dbColumns[8]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( eventId );
      ((ServletIntColumn)dbColumns[1]).setValue( eventType );
      ((ServletTimestampColumn)dbColumns[2]).setValue( date );
      ((ServletIntColumn)dbColumns[3]).setValue( ownerId );
      ((ServletIntColumn)dbColumns[4]).setValue( ownerType );
      ((ServletStringColumn)dbColumns[5]).setValue( description );
      ((ServletStringColumn)dbColumns[6]).setValue( comment );
      ((ServletStringColumn)dbColumns[7]).setValue( originator );
      ((ServletStringColumn)dbColumns[8]).setValue( reference );
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
      String retString = "\n" + prefix + "History Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    eventId (HISTORY.EVENTID) -- ";
         retString += "localVar=\"" + Integer.toString( eventId) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    eventType (HISTORY.EVENTTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( eventType) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    date (HISTORY.DATE) -- ";
         retString += "localVar=\"" + date.toString() + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    ownerId (HISTORY.OWNERID) -- ";
         retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    ownerType (HISTORY.OWNERTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    description (HISTORY.DESCRIPTION) -- ";
         retString += "localVar=\"" + description.toString() + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    comment (HISTORY.COMMENT) -- ";
         retString += "localVar=\"" + comment.toString() + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    originator (HISTORY.ORIGINATOR) -- ";
         retString += "localVar=\"" + originator.toString() + "\";  ";
         retString += dbColumns[7].toString();
         retString += "\n"+ prefix +   "    reference (HISTORY.REFERENCE) -- ";
         retString += "localVar=\"" + reference.toString() + "\";  ";
         retString += dbColumns[8].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(HistoryViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showEventId ) retString += commaSeparator(retString) + "eventId" + ndxSuffix;
         if( viewDef.showEventType ) retString += commaSeparator(retString) + "eventType" + ndxSuffix;
         if( viewDef.showDate ) retString += commaSeparator(retString) + "date" + ndxSuffix;
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + "ownerId" + ndxSuffix;
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + "ownerType" + ndxSuffix;
         if( viewDef.showDescription ) retString += commaSeparator(retString) + "description" + ndxSuffix;
         if( viewDef.showComment ) retString += commaSeparator(retString) + "comment" + ndxSuffix;
         if( viewDef.showOriginator ) retString += commaSeparator(retString) + "originator" + ndxSuffix;
         if( viewDef.showReference ) retString += commaSeparator(retString) + "reference" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(HistoryViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showEventId ) retString += commaSeparator(retString) + CSVCell( eventId);
         if( viewDef.showEventType ) retString += commaSeparator(retString) + CSVCell( eventType);
         if( viewDef.showDate ) retString += commaSeparator(retString) + CSVCell( date);
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + CSVCell( ownerId);
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + CSVCell( ownerType);
         if( viewDef.showDescription ) retString += commaSeparator(retString) + CSVCell( description);
         if( viewDef.showComment ) retString += commaSeparator(retString) + CSVCell( comment);
         if( viewDef.showOriginator ) retString += commaSeparator(retString) + CSVCell( originator);
         if( viewDef.showReference ) retString += commaSeparator(retString) + CSVCell( reference);
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
      sysLogger.info( "DROP TABLE HISTORY;" );
      sysLogger.info( "CREATE TABLE HISTORY ( HISTORY.EVENTID integer, HISTORY.EVENTTYPE integer, HISTORY.DATE timestamp, HISTORY.OWNERID integer, HISTORY.OWNERTYPE integer, HISTORY.DESCRIPTION char(254), HISTORY.COMMENT char(254), HISTORY.ORIGINATOR char, HISTORY.REFERENCE char );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "History Object:";
      retString += "\n    eventId (HISTORY.EVENTID) -- ";
      retString += "localVar=\"" + Integer.toString( eventId) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    eventType (HISTORY.EVENTTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( eventType) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    date (HISTORY.DATE) -- ";
      retString += "localVar=\"" + date.toString() + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    ownerId (HISTORY.OWNERID) -- ";
      retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    ownerType (HISTORY.OWNERTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    description (HISTORY.DESCRIPTION) -- ";
      retString += "localVar=\"" + description.toString() + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    comment (HISTORY.COMMENT) -- ";
      retString += "localVar=\"" + comment.toString() + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    originator (HISTORY.ORIGINATOR) -- ";
      retString += "localVar=\"" + originator.toString() + "\";  ";
      retString += dbColumns[7].toString();
      retString += "\n    reference (HISTORY.REFERENCE) -- ";
      retString += "localVar=\"" + reference.toString() + "\";  ";
      retString += dbColumns[8].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "date", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "description", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "comment", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "originator", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "reference", label ); 
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
