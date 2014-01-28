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
 
public class SegmentSongDBRecordBase extends ServletRecord
{
 
   public static final int ID = 0;
   public static final int OWNERTYPE = 1;
   public static final int OWNERID = 2;
   public static final int SEGMENT = 3;
   public static final int SONGLENGTH = 4;
   public static final int SONG = 5;
   public static final int ARTIST = 6;
   public static final int DETAILS = 7;
   public static final int LOCATION = 8;
 
   public static final String[] COLNAME = {
                                             "SEGMENTSONG.ID",
                                             "SEGMENTSONG.OWNERTYPE",
                                             "SEGMENTSONG.OWNERID",
                                             "SEGMENTSONG.SEGMENT",
                                             "SEGMENTSONG.SONGLENGTH",
                                             "SEGMENTSONG.SONG",
                                             "SEGMENTSONG.ARTIST",
                                             "SEGMENTSONG.DETAILS",
                                             "SEGMENTSONG.LOCATION"
                                                    };
 
   protected int id;
   public    int getId() { return( id ); }
   public     void setId( int aId ) { id = aId; }
 
   protected int ownerType;
   public    int getOwnerType() { return( ownerType ); }
   public     void setOwnerType( int aOwnerType ) { ownerType = aOwnerType; }
 
   protected int ownerId;
   public    int getOwnerId() { return( ownerId ); }
   public     void setOwnerId( int aOwnerId ) { ownerId = aOwnerId; }
 
   protected String segment = "";
   public    String getSegment() { return( segment ); }
   public     void setSegment( String aSegment ) { segment = aSegment; }
 
   protected String songLength = "";
   public    String getSongLength() { return( songLength ); }
   public     void setSongLength( String aSongLength ) { songLength = aSongLength; }
 
   protected String song = "";
   public    String getSong() { return( song ); }
   public     void setSong( String aSong ) { song = aSong; }
 
   protected String artist = "";
   public    String getArtist() { return( artist ); }
   public     void setArtist( String aArtist ) { artist = aArtist; }
 
   protected String details = "";
   public    String getDetails() { return( details ); }
   public     void setDetails( String aDetails ) { details = aDetails; }
 
   protected String location = "";
   public    String getLocation() { return( location ); }
   public     void setLocation( String aLocation ) { location = aLocation; }
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SegmentSongDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "SegmentSongDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SegmentSongDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "SegmentSongDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SegmentSongDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "SegmentSongDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SegmentSongDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "SegmentSongDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SegmentSongDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "SegmentSongDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SegmentSongDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "SegmentSongDBRecordBase constructor from array");
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
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "SEGMENTSONG.ID", "SEGMENTSONG", "id" );
      dbColumns[1] = new ServletIntColumn( aDbData, "SEGMENTSONG.OWNERTYPE", "SEGMENTSONG", "ownerType" );
      dbColumns[2] = new ServletIntColumn( aDbData, "SEGMENTSONG.OWNERID", "SEGMENTSONG", "ownerId" );
      dbColumns[3] = new ServletStringColumn( aDbData, "SEGMENTSONG.SEGMENT", "SEGMENTSONG", "segment" );
      if ( segment == null ) segment = ((ServletStringColumn)dbColumns[3]).getValue(); // if it hasn't already been initialized...
      dbColumns[4] = new ServletStringColumn( aDbData, "SEGMENTSONG.SONGLENGTH", "SEGMENTSONG", "songLength" );
      if ( songLength == null ) songLength = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
      dbColumns[5] = new ServletStringColumn( aDbData, "SEGMENTSONG.SONG", "SEGMENTSONG", "song" );
      if ( song == null ) song = ((ServletStringColumn)dbColumns[5]).getValue(); // if it hasn't already been initialized...
      dbColumns[6] = new ServletStringColumn( aDbData, "SEGMENTSONG.ARTIST", "SEGMENTSONG", "artist" );
      if ( artist == null ) artist = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
      dbColumns[7] = new ServletStringColumn( aDbData, "SEGMENTSONG.DETAILS", "SEGMENTSONG", "details" );
      if ( details == null ) details = ((ServletStringColumn)dbColumns[7]).getValue(); // if it hasn't already been initialized...
      dbColumns[8] = new ServletStringColumn( aDbData, "SEGMENTSONG.LOCATION", "SEGMENTSONG", "location" );
      if ( location == null ) location = ((ServletStringColumn)dbColumns[8]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      id = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      ownerType = ((ServletIntColumn)dbColumns[1]).getValue();
      ownerId = ((ServletIntColumn)dbColumns[2]).getValue();
      segment = ((ServletStringColumn)dbColumns[3]).getValue();
      songLength = ((ServletStringColumn)dbColumns[4]).getValue();
      song = ((ServletStringColumn)dbColumns[5]).getValue();
      artist = ((ServletStringColumn)dbColumns[6]).getValue();
      details = ((ServletStringColumn)dbColumns[7]).getValue();
      location = ((ServletStringColumn)dbColumns[8]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( id );
      ((ServletIntColumn)dbColumns[1]).setValue( ownerType );
      ((ServletIntColumn)dbColumns[2]).setValue( ownerId );
      ((ServletStringColumn)dbColumns[3]).setValue( segment );
      ((ServletStringColumn)dbColumns[4]).setValue( songLength );
      ((ServletStringColumn)dbColumns[5]).setValue( song );
      ((ServletStringColumn)dbColumns[6]).setValue( artist );
      ((ServletStringColumn)dbColumns[7]).setValue( details );
      ((ServletStringColumn)dbColumns[8]).setValue( location );
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
      String retString = "\n" + prefix + "SegmentSong Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    id (SEGMENTSONG.ID) -- ";
         retString += "localVar=\"" + Integer.toString( id) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    ownerType (SEGMENTSONG.OWNERTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    ownerId (SEGMENTSONG.OWNERID) -- ";
         retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    segment (SEGMENTSONG.SEGMENT) -- ";
         retString += "localVar=\"" + segment.toString() + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    songLength (SEGMENTSONG.SONGLENGTH) -- ";
         retString += "localVar=\"" + songLength.toString() + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    song (SEGMENTSONG.SONG) -- ";
         retString += "localVar=\"" + song.toString() + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    artist (SEGMENTSONG.ARTIST) -- ";
         retString += "localVar=\"" + artist.toString() + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    details (SEGMENTSONG.DETAILS) -- ";
         retString += "localVar=\"" + details.toString() + "\";  ";
         retString += dbColumns[7].toString();
         retString += "\n"+ prefix +   "    location (SEGMENTSONG.LOCATION) -- ";
         retString += "localVar=\"" + location.toString() + "\";  ";
         retString += dbColumns[8].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(SegmentSongViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + "id" + ndxSuffix;
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + "ownerType" + ndxSuffix;
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + "ownerId" + ndxSuffix;
         if( viewDef.showSegment ) retString += commaSeparator(retString) + "segment" + ndxSuffix;
         if( viewDef.showSongLength ) retString += commaSeparator(retString) + "songLength" + ndxSuffix;
         if( viewDef.showSong ) retString += commaSeparator(retString) + "song" + ndxSuffix;
         if( viewDef.showArtist ) retString += commaSeparator(retString) + "artist" + ndxSuffix;
         if( viewDef.showDetails ) retString += commaSeparator(retString) + "details" + ndxSuffix;
         if( viewDef.showLocation ) retString += commaSeparator(retString) + "location" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(SegmentSongViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + CSVCell( id);
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + CSVCell( ownerType);
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + CSVCell( ownerId);
         if( viewDef.showSegment ) retString += commaSeparator(retString) + CSVCell( segment);
         if( viewDef.showSongLength ) retString += commaSeparator(retString) + CSVCell( songLength);
         if( viewDef.showSong ) retString += commaSeparator(retString) + CSVCell( song);
         if( viewDef.showArtist ) retString += commaSeparator(retString) + CSVCell( artist);
         if( viewDef.showDetails ) retString += commaSeparator(retString) + CSVCell( details);
         if( viewDef.showLocation ) retString += commaSeparator(retString) + CSVCell( location);
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
      sysLogger.info( "DROP TABLE SEGMENTSONG;" );
      sysLogger.info( "CREATE TABLE SEGMENTSONG ( SEGMENTSONG.ID integer, SEGMENTSONG.OWNERTYPE integer, SEGMENTSONG.OWNERID integer, SEGMENTSONG.SEGMENT char, SEGMENTSONG.SONGLENGTH char, SEGMENTSONG.SONG char, SEGMENTSONG.ARTIST char, SEGMENTSONG.DETAILS char, SEGMENTSONG.LOCATION char );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "SegmentSong Object:";
      retString += "\n    id (SEGMENTSONG.ID) -- ";
      retString += "localVar=\"" + Integer.toString( id) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    ownerType (SEGMENTSONG.OWNERTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    ownerId (SEGMENTSONG.OWNERID) -- ";
      retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    segment (SEGMENTSONG.SEGMENT) -- ";
      retString += "localVar=\"" + segment.toString() + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    songLength (SEGMENTSONG.SONGLENGTH) -- ";
      retString += "localVar=\"" + songLength.toString() + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    song (SEGMENTSONG.SONG) -- ";
      retString += "localVar=\"" + song.toString() + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    artist (SEGMENTSONG.ARTIST) -- ";
      retString += "localVar=\"" + artist.toString() + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    details (SEGMENTSONG.DETAILS) -- ";
      retString += "localVar=\"" + details.toString() + "\";  ";
      retString += dbColumns[7].toString();
      retString += "\n    location (SEGMENTSONG.LOCATION) -- ";
      retString += "localVar=\"" + location.toString() + "\";  ";
      retString += dbColumns[8].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "segment", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "songLength", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "song", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "artist", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "details", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "location", label ); 
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
