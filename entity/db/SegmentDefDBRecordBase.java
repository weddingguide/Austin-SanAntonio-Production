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
 
public class SegmentDefDBRecordBase extends ServletRecord
{
 
   public static final int ID = 0;
   public static final int OWNERTYPE = 1;
   public static final int OWNERID = 2;
   public static final int NAME = 3;
   public static final int STATUS = 4;
   public static final int NDX = 5;
   public static final int DISPLAYNAME = 6;
   public static final int DESCRIPTION = 7;
   public static final int TYPE = 8;
 
   public static final String[] COLNAME = {
                                             "SEGMENTDEF.ID",
                                             "SEGMENTDEF.OWNERTYPE",
                                             "SEGMENTDEF.OWNERID",
                                             "SEGMENTDEF.NAME",
                                             "SEGMENTDEF.STATUS",
                                             "SEGMENTDEF.NDX",
                                             "SEGMENTDEF.DISPLAYNAME",
                                             "SEGMENTDEF.DESCRIPTION",
                                             "SEGMENTDEF.TYPE"
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
 
   protected String name = "";
   public    String getName() { return( name ); }
   public     void setName( String aName ) { name = aName; }
 
   protected int status;
   public    int getStatus() { return( status ); }
   public     void setStatus( int aStatus ) { status = aStatus; }
 
   protected int ndx;
   public    int getNdx() { return( ndx ); }
   public     void setNdx( int aNdx ) { ndx = aNdx; }
 
   protected String displayName = "";
   public    String getDisplayName() { return( displayName ); }
   public     void setDisplayName( String aDisplayName ) { displayName = aDisplayName; }
 
   protected String description = "";
   public    String getDescription() { return( description ); }
   public     void setDescription( String aDescription ) { description = aDescription; }
 
   protected int type;
   public    int getType() { return( type ); }
   public     void setType( int aType ) { type = aType; }
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SegmentDefDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "SegmentDefDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SegmentDefDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "SegmentDefDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SegmentDefDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "SegmentDefDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SegmentDefDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "SegmentDefDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SegmentDefDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "SegmentDefDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public SegmentDefDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "SegmentDefDBRecordBase constructor from array");
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
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "SEGMENTDEF.ID", "SEGMENTDEF", "id" );
      dbColumns[1] = new ServletIntColumn( aDbData, "SEGMENTDEF.OWNERTYPE", "SEGMENTDEF", "ownerType" );
      dbColumns[2] = new ServletIntColumn( aDbData, "SEGMENTDEF.OWNERID", "SEGMENTDEF", "ownerId" );
      dbColumns[3] = new ServletStringColumn( aDbData, "SEGMENTDEF.NAME", "SEGMENTDEF", "name" );
      if ( name == null ) name = ((ServletStringColumn)dbColumns[3]).getValue(); // if it hasn't already been initialized...
      dbColumns[4] = new ServletIntColumn( aDbData, "SEGMENTDEF.STATUS", "SEGMENTDEF", "status" );
      dbColumns[5] = new ServletIntColumn( aDbData, "SEGMENTDEF.NDX", "SEGMENTDEF", "ndx" );
      dbColumns[6] = new ServletStringColumn( aDbData, "SEGMENTDEF.DISPLAYNAME", "SEGMENTDEF", "displayName" );
      if ( displayName == null ) displayName = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
      dbColumns[7] = new ServletStringColumn( aDbData, "SEGMENTDEF.DESCRIPTION", "SEGMENTDEF", "description" );
      if ( description == null ) description = ((ServletStringColumn)dbColumns[7]).getValue(); // if it hasn't already been initialized...
      dbColumns[8] = new ServletIntColumn( aDbData, "SEGMENTDEF.TYPE", "SEGMENTDEF", "type" );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      id = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      ownerType = ((ServletIntColumn)dbColumns[1]).getValue();
      ownerId = ((ServletIntColumn)dbColumns[2]).getValue();
      name = ((ServletStringColumn)dbColumns[3]).getValue();
      status = ((ServletIntColumn)dbColumns[4]).getValue();
      ndx = ((ServletIntColumn)dbColumns[5]).getValue();
      displayName = ((ServletStringColumn)dbColumns[6]).getValue();
      description = ((ServletStringColumn)dbColumns[7]).getValue();
      type = ((ServletIntColumn)dbColumns[8]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( id );
      ((ServletIntColumn)dbColumns[1]).setValue( ownerType );
      ((ServletIntColumn)dbColumns[2]).setValue( ownerId );
      ((ServletStringColumn)dbColumns[3]).setValue( name );
      ((ServletIntColumn)dbColumns[4]).setValue( status );
      ((ServletIntColumn)dbColumns[5]).setValue( ndx );
      ((ServletStringColumn)dbColumns[6]).setValue( displayName );
      ((ServletStringColumn)dbColumns[7]).setValue( description );
      ((ServletIntColumn)dbColumns[8]).setValue( type );
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
      String retString = "\n" + prefix + "SegmentDef Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    id (SEGMENTDEF.ID) -- ";
         retString += "localVar=\"" + Integer.toString( id) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    ownerType (SEGMENTDEF.OWNERTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    ownerId (SEGMENTDEF.OWNERID) -- ";
         retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    name (SEGMENTDEF.NAME) -- ";
         retString += "localVar=\"" + name.toString() + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    status (SEGMENTDEF.STATUS) -- ";
         retString += "localVar=\"" + Integer.toString( status) + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    ndx (SEGMENTDEF.NDX) -- ";
         retString += "localVar=\"" + Integer.toString( ndx) + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    displayName (SEGMENTDEF.DISPLAYNAME) -- ";
         retString += "localVar=\"" + displayName.toString() + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    description (SEGMENTDEF.DESCRIPTION) -- ";
         retString += "localVar=\"" + description.toString() + "\";  ";
         retString += dbColumns[7].toString();
         retString += "\n"+ prefix +   "    type (SEGMENTDEF.TYPE) -- ";
         retString += "localVar=\"" + Integer.toString( type) + "\";  ";
         retString += dbColumns[8].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(SegmentDefViewBase viewDef, int ndx )
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
         if( viewDef.showName ) retString += commaSeparator(retString) + "name" + ndxSuffix;
         if( viewDef.showStatus ) retString += commaSeparator(retString) + "status" + ndxSuffix;
         if( viewDef.showNdx ) retString += commaSeparator(retString) + "ndx" + ndxSuffix;
         if( viewDef.showDisplayName ) retString += commaSeparator(retString) + "displayName" + ndxSuffix;
         if( viewDef.showDescription ) retString += commaSeparator(retString) + "description" + ndxSuffix;
         if( viewDef.showType ) retString += commaSeparator(retString) + "type" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(SegmentDefViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + CSVCell( id);
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + CSVCell( ownerType);
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + CSVCell( ownerId);
         if( viewDef.showName ) retString += commaSeparator(retString) + CSVCell( name);
         if( viewDef.showStatus ) retString += commaSeparator(retString) + CSVCell( status);
         if( viewDef.showNdx ) retString += commaSeparator(retString) + CSVCell( ndx);
         if( viewDef.showDisplayName ) retString += commaSeparator(retString) + CSVCell( displayName);
         if( viewDef.showDescription ) retString += commaSeparator(retString) + CSVCell( description);
         if( viewDef.showType ) retString += commaSeparator(retString) + CSVCell( type);
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
      sysLogger.info( "DROP TABLE SEGMENTDEF;" );
      sysLogger.info( "CREATE TABLE SEGMENTDEF ( SEGMENTDEF.ID integer, SEGMENTDEF.OWNERTYPE integer, SEGMENTDEF.OWNERID integer, SEGMENTDEF.NAME char, SEGMENTDEF.STATUS integer, SEGMENTDEF.NDX integer, SEGMENTDEF.DISPLAYNAME char, SEGMENTDEF.DESCRIPTION char, SEGMENTDEF.TYPE integer );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "SegmentDef Object:";
      retString += "\n    id (SEGMENTDEF.ID) -- ";
      retString += "localVar=\"" + Integer.toString( id) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    ownerType (SEGMENTDEF.OWNERTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    ownerId (SEGMENTDEF.OWNERID) -- ";
      retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    name (SEGMENTDEF.NAME) -- ";
      retString += "localVar=\"" + name.toString() + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    status (SEGMENTDEF.STATUS) -- ";
      retString += "localVar=\"" + Integer.toString( status) + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    ndx (SEGMENTDEF.NDX) -- ";
      retString += "localVar=\"" + Integer.toString( ndx) + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    displayName (SEGMENTDEF.DISPLAYNAME) -- ";
      retString += "localVar=\"" + displayName.toString() + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    description (SEGMENTDEF.DESCRIPTION) -- ";
      retString += "localVar=\"" + description.toString() + "\";  ";
      retString += dbColumns[7].toString();
      retString += "\n    type (SEGMENTDEF.TYPE) -- ";
      retString += "localVar=\"" + Integer.toString( type) + "\";  ";
      retString += dbColumns[8].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "name", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "displayName", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "description", label ); 
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
