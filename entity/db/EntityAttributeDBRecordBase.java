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
 
public class EntityAttributeDBRecordBase extends ServletRecord
{
 
   public static final int ID = 0;
   public static final int VERSION = 1;
   public static final int OWNERTYPE = 2;
   public static final int OWNERID = 3;
   public static final int ATTRIBUTEDEFID = 4;
   public static final int ATTRIBUTEDEFSUBID = 5;
   public static final int ATTRIBUTEDATA = 6;
   public static final int NDX = 7;
   public static final int BGNDATE = 8;
   public static final int ENDDATE = 9;
   public static final int LASTCHANGE = 10;
 
   public static final String[] COLNAME = {
                                             "ENTITYATTRIBUTE.ID",
                                             "ENTITYATTRIBUTE.VERSION",
                                             "ENTITYATTRIBUTE.OWNERTYPE",
                                             "ENTITYATTRIBUTE.OWNERID",
                                             "ENTITYATTRIBUTE.ATTRIBUTEDEFID",
                                             "ENTITYATTRIBUTE.ATTRIBUTEDEFSUBID",
                                             "ENTITYATTRIBUTE.ATTRIBUTEDATA",
                                             "ENTITYATTRIBUTE.NDX",
                                             "ENTITYATTRIBUTE.BGNDATE",
                                             "ENTITYATTRIBUTE.ENDDATE",
                                             "ENTITYATTRIBUTE.LASTCHANGE"
                                                    };
 
   protected int id;
   public    int getId() { return( id ); }
   public     void setId( int aId ) { id = aId; }
 
   protected int version;
   public    int getVersion() { return( version ); }
   public     void setVersion( int aVersion ) { version = aVersion; }
 
   protected int ownerType;
   public    int getOwnerType() { return( ownerType ); }
   public     void setOwnerType( int aOwnerType ) { ownerType = aOwnerType; }
 
   protected int ownerId;
   public    int getOwnerId() { return( ownerId ); }
   public     void setOwnerId( int aOwnerId ) { ownerId = aOwnerId; }
 
   protected int attributeDefId;
   public    int getAttributeDefId() { return( attributeDefId ); }
   public     void setAttributeDefId( int aAttributeDefId ) { attributeDefId = aAttributeDefId; }
 
   protected int attributeDefSubId;
   public    int getAttributeDefSubId() { return( attributeDefSubId ); }
   public     void setAttributeDefSubId( int aAttributeDefSubId ) { attributeDefSubId = aAttributeDefSubId; }
 
   protected String attributeData = "";
   public    String getAttributeData() { return( attributeData ); }
   public     void setAttributeData( String aAttributeData ) { attributeData = aAttributeData; }
 
   protected int ndx;
   public    int getNdx() { return( ndx ); }
   public     void setNdx( int aNdx ) { ndx = aNdx; }
 
   protected java.sql.Date bgnDate;
   public    java.sql.Date getBgnDate() { return( bgnDate ); }
   public     void setBgnDate( java.sql.Date aBgnDate ) { bgnDate = aBgnDate; }
 
   protected java.sql.Date endDate;
   public    java.sql.Date getEndDate() { return( endDate ); }
   public     void setEndDate( java.sql.Date aEndDate ) { endDate = aEndDate; }
 
   protected String lastChange = "";
   public    String getLastChange() { return( lastChange ); }
   public     void setLastChange( String aLastChange ) { lastChange = aLastChange; }
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "EntityAttributeDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "EntityAttributeDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "EntityAttributeDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "EntityAttributeDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "EntityAttributeDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "EntityAttributeDBRecordBase constructor from array");
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
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "ENTITYATTRIBUTE.ID", "ENTITYATTRIBUTE", "id" );
      dbColumns[1] = new ServletIntColumn( aDbData, "ENTITYATTRIBUTE.VERSION", "ENTITYATTRIBUTE", "version" );
      dbColumns[2] = new ServletIntColumn( aDbData, "ENTITYATTRIBUTE.OWNERTYPE", "ENTITYATTRIBUTE", "ownerType" );
      dbColumns[3] = new ServletIntColumn( aDbData, "ENTITYATTRIBUTE.OWNERID", "ENTITYATTRIBUTE", "ownerId" );
      dbColumns[4] = new ServletIntColumn( aDbData, "ENTITYATTRIBUTE.ATTRIBUTEDEFID", "ENTITYATTRIBUTE", "attributeDefId" );
      dbColumns[5] = new ServletIntColumn( aDbData, "ENTITYATTRIBUTE.ATTRIBUTEDEFSUBID", "ENTITYATTRIBUTE", "attributeDefSubId" );
      dbColumns[6] = new ServletStringColumn( aDbData, "ENTITYATTRIBUTE.ATTRIBUTEDATA", "ENTITYATTRIBUTE", "attributeData" );
      if ( attributeData == null ) attributeData = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
      dbColumns[7] = new ServletIntColumn( aDbData, "ENTITYATTRIBUTE.NDX", "ENTITYATTRIBUTE", "ndx" );
      dbColumns[8] = new ServletDateColumn( aDbData, "ENTITYATTRIBUTE.BGNDATE", "ENTITYATTRIBUTE", "bgnDate" );
      if ( bgnDate == null ) bgnDate = ((ServletDateColumn)dbColumns[8]).getValue(); // if it hasn't already been initialized...
      dbColumns[9] = new ServletDateColumn( aDbData, "ENTITYATTRIBUTE.ENDDATE", "ENTITYATTRIBUTE", "endDate" );
      if ( endDate == null ) endDate = ((ServletDateColumn)dbColumns[9]).getValue(); // if it hasn't already been initialized...
      dbColumns[10] = new ServletStringColumn( aDbData, "ENTITYATTRIBUTE.LASTCHANGE", "ENTITYATTRIBUTE", "lastChange" );
      if ( lastChange == null ) lastChange = ((ServletStringColumn)dbColumns[10]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      id = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      version = ((ServletIntColumn)dbColumns[1]).getValue();
      ownerType = ((ServletIntColumn)dbColumns[2]).getValue();
      ownerId = ((ServletIntColumn)dbColumns[3]).getValue();
      attributeDefId = ((ServletIntColumn)dbColumns[4]).getValue();
      attributeDefSubId = ((ServletIntColumn)dbColumns[5]).getValue();
      attributeData = ((ServletStringColumn)dbColumns[6]).getValue();
      ndx = ((ServletIntColumn)dbColumns[7]).getValue();
      bgnDate = ((ServletDateColumn)dbColumns[8]).getValue();
      endDate = ((ServletDateColumn)dbColumns[9]).getValue();
      lastChange = ((ServletStringColumn)dbColumns[10]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( id );
      ((ServletIntColumn)dbColumns[1]).setValue( version );
      ((ServletIntColumn)dbColumns[2]).setValue( ownerType );
      ((ServletIntColumn)dbColumns[3]).setValue( ownerId );
      ((ServletIntColumn)dbColumns[4]).setValue( attributeDefId );
      ((ServletIntColumn)dbColumns[5]).setValue( attributeDefSubId );
      ((ServletStringColumn)dbColumns[6]).setValue( attributeData );
      ((ServletIntColumn)dbColumns[7]).setValue( ndx );
      ((ServletDateColumn)dbColumns[8]).setValue( bgnDate );
      ((ServletDateColumn)dbColumns[9]).setValue( endDate );
      ((ServletStringColumn)dbColumns[10]).setValue( lastChange );
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
      String retString = "\n" + prefix + "EntityAttribute Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    id (ENTITYATTRIBUTE.ID) -- ";
         retString += "localVar=\"" + Integer.toString( id) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    version (ENTITYATTRIBUTE.VERSION) -- ";
         retString += "localVar=\"" + Integer.toString( version) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    ownerType (ENTITYATTRIBUTE.OWNERTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    ownerId (ENTITYATTRIBUTE.OWNERID) -- ";
         retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    attributeDefId (ENTITYATTRIBUTE.ATTRIBUTEDEFID) -- ";
         retString += "localVar=\"" + Integer.toString( attributeDefId) + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    attributeDefSubId (ENTITYATTRIBUTE.ATTRIBUTEDEFSUBID) -- ";
         retString += "localVar=\"" + Integer.toString( attributeDefSubId) + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    attributeData (ENTITYATTRIBUTE.ATTRIBUTEDATA) -- ";
         retString += "localVar=\"" + attributeData.toString() + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    ndx (ENTITYATTRIBUTE.NDX) -- ";
         retString += "localVar=\"" + Integer.toString( ndx) + "\";  ";
         retString += dbColumns[7].toString();
         retString += "\n"+ prefix +   "    bgnDate (ENTITYATTRIBUTE.BGNDATE) -- ";
         retString += "localVar=\"" + bgnDate.toString() + "\";  ";
         retString += dbColumns[8].toString();
         retString += "\n"+ prefix +   "    endDate (ENTITYATTRIBUTE.ENDDATE) -- ";
         retString += "localVar=\"" + endDate.toString() + "\";  ";
         retString += dbColumns[9].toString();
         retString += "\n"+ prefix +   "    lastChange (ENTITYATTRIBUTE.LASTCHANGE) -- ";
         retString += "localVar=\"" + lastChange.toString() + "\";  ";
         retString += dbColumns[10].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(EntityAttributeViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + "id" + ndxSuffix;
         if( viewDef.showVersion ) retString += commaSeparator(retString) + "version" + ndxSuffix;
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + "ownerType" + ndxSuffix;
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + "ownerId" + ndxSuffix;
         if( viewDef.showAttributeDefId ) retString += commaSeparator(retString) + "attributeDefId" + ndxSuffix;
         if( viewDef.showAttributeDefSubId ) retString += commaSeparator(retString) + "attributeDefSubId" + ndxSuffix;
         if( viewDef.showAttributeData ) retString += commaSeparator(retString) + "attributeData" + ndxSuffix;
         if( viewDef.showNdx ) retString += commaSeparator(retString) + "ndx" + ndxSuffix;
         if( viewDef.showBgnDate ) retString += commaSeparator(retString) + "bgnDate" + ndxSuffix;
         if( viewDef.showEndDate ) retString += commaSeparator(retString) + "endDate" + ndxSuffix;
         if( viewDef.showLastChange ) retString += commaSeparator(retString) + "lastChange" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(EntityAttributeViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + CSVCell( id);
         if( viewDef.showVersion ) retString += commaSeparator(retString) + CSVCell( version);
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + CSVCell( ownerType);
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + CSVCell( ownerId);
         if( viewDef.showAttributeDefId ) retString += commaSeparator(retString) + CSVCell( attributeDefId);
         if( viewDef.showAttributeDefSubId ) retString += commaSeparator(retString) + CSVCell( attributeDefSubId);
         if( viewDef.showAttributeData ) retString += commaSeparator(retString) + CSVCell( attributeData);
         if( viewDef.showNdx ) retString += commaSeparator(retString) + CSVCell( ndx);
         if( viewDef.showBgnDate ) retString += commaSeparator(retString) + CSVCell( bgnDate);
         if( viewDef.showEndDate ) retString += commaSeparator(retString) + CSVCell( endDate);
         if( viewDef.showLastChange ) retString += commaSeparator(retString) + CSVCell( lastChange);
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
      sysLogger.info( "DROP TABLE ENTITYATTRIBUTE;" );
      sysLogger.info( "CREATE TABLE ENTITYATTRIBUTE ( ENTITYATTRIBUTE.ID integer, ENTITYATTRIBUTE.VERSION integer, ENTITYATTRIBUTE.OWNERTYPE integer, ENTITYATTRIBUTE.OWNERID integer, ENTITYATTRIBUTE.ATTRIBUTEDEFID integer, ENTITYATTRIBUTE.ATTRIBUTEDEFSUBID integer, ENTITYATTRIBUTE.ATTRIBUTEDATA char, ENTITYATTRIBUTE.NDX integer, ENTITYATTRIBUTE.BGNDATE Date, ENTITYATTRIBUTE.ENDDATE Date, ENTITYATTRIBUTE.LASTCHANGE char );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "EntityAttribute Object:";
      retString += "\n    id (ENTITYATTRIBUTE.ID) -- ";
      retString += "localVar=\"" + Integer.toString( id) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    version (ENTITYATTRIBUTE.VERSION) -- ";
      retString += "localVar=\"" + Integer.toString( version) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    ownerType (ENTITYATTRIBUTE.OWNERTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    ownerId (ENTITYATTRIBUTE.OWNERID) -- ";
      retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    attributeDefId (ENTITYATTRIBUTE.ATTRIBUTEDEFID) -- ";
      retString += "localVar=\"" + Integer.toString( attributeDefId) + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    attributeDefSubId (ENTITYATTRIBUTE.ATTRIBUTEDEFSUBID) -- ";
      retString += "localVar=\"" + Integer.toString( attributeDefSubId) + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    attributeData (ENTITYATTRIBUTE.ATTRIBUTEDATA) -- ";
      retString += "localVar=\"" + attributeData.toString() + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    ndx (ENTITYATTRIBUTE.NDX) -- ";
      retString += "localVar=\"" + Integer.toString( ndx) + "\";  ";
      retString += dbColumns[7].toString();
      retString += "\n    bgnDate (ENTITYATTRIBUTE.BGNDATE) -- ";
      retString += "localVar=\"" + bgnDate.toString() + "\";  ";
      retString += dbColumns[8].toString();
      retString += "\n    endDate (ENTITYATTRIBUTE.ENDDATE) -- ";
      retString += "localVar=\"" + endDate.toString() + "\";  ";
      retString += dbColumns[9].toString();
      retString += "\n    lastChange (ENTITYATTRIBUTE.LASTCHANGE) -- ";
      retString += "localVar=\"" + lastChange.toString() + "\";  ";
      retString += dbColumns[10].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "attributeData", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "bgnDate", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "endDate", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "lastChange", label ); 
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
