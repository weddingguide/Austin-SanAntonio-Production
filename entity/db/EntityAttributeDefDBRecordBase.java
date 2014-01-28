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
 
public class EntityAttributeDefDBRecordBase extends ServletRecord
{
 
   public static final int ID = 0;
   public static final int SUBID = 1;
   public static final int SORTWEIGHT = 2;
   public static final int OWNERTYPE = 3;
   public static final int OWNERID = 4;
   public static final int NAME = 5;
   public static final int PROMPT = 6;
   public static final int TYPE = 7;
   public static final int CARDINALITY = 8;
   public static final int DATERESTRICTED = 9;
   public static final int USERDEFINED = 10;
 
   public static final String[] COLNAME = {
                                             "ENTITYATTRIBUTEDEF.ID",
                                             "ENTITYATTRIBUTEDEF.SUBID",
                                             "ENTITYATTRIBUTEDEF.SORTWEIGHT",
                                             "ENTITYATTRIBUTEDEF.OWNERTYPE",
                                             "ENTITYATTRIBUTEDEF.OWNERID",
                                             "ENTITYATTRIBUTEDEF.NAME",
                                             "ENTITYATTRIBUTEDEF.PROMPT",
                                             "ENTITYATTRIBUTEDEF.TYPE",
                                             "ENTITYATTRIBUTEDEF.CARDINALITY",
                                             "ENTITYATTRIBUTEDEF.DATERESTRICTED",
                                             "ENTITYATTRIBUTEDEF.USERDEFINED"
                                                    };
 
   protected int id;
   public    int getId() { return( id ); }
   public     void setId( int aId ) { id = aId; }
 
   protected int subId;
   public    int getSubId() { return( subId ); }
   public     void setSubId( int aSubId ) { subId = aSubId; }
 
   protected int sortWeight;
   public    int getSortWeight() { return( sortWeight ); }
   public     void setSortWeight( int aSortWeight ) { sortWeight = aSortWeight; }
 
   protected int ownerType;
   public    int getOwnerType() { return( ownerType ); }
   public     void setOwnerType( int aOwnerType ) { ownerType = aOwnerType; }
 
   protected int ownerId;
   public    int getOwnerId() { return( ownerId ); }
   public     void setOwnerId( int aOwnerId ) { ownerId = aOwnerId; }
 
   protected String name = "";
   public    String getName() { return( name ); }
   public     void setName( String aName ) { name = aName; }
 
   protected String prompt = "";
   public    String getPrompt() { return( prompt ); }
   public     void setPrompt( String aPrompt ) { prompt = aPrompt; }
 
   protected int type;
   public    int getType() { return( type ); }
   public     void setType( int aType ) { type = aType; }
 
   protected int cardinality;
   public    int getCardinality() { return( cardinality ); }
   public     void setCardinality( int aCardinality ) { cardinality = aCardinality; }
 
   protected int dateRestricted;
   public    int getDateRestricted() { return( dateRestricted ); }
   public     void setDateRestricted( int aDateRestricted ) { dateRestricted = aDateRestricted; }
 
   protected int userDefined;
   public    int getUserDefined() { return( userDefined ); }
   public     void setUserDefined( int aUserDefined ) { userDefined = aUserDefined; }
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDefDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "EntityAttributeDefDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDefDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "EntityAttributeDefDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDefDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "EntityAttributeDefDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDefDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "EntityAttributeDefDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDefDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "EntityAttributeDefDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDefDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "EntityAttributeDefDBRecordBase constructor from array");
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
      dbColumns[0] = new ServletIntColumn( aDbData, "ENTITYATTRIBUTEDEF.ID", "ENTITYATTRIBUTEDEF", "id" );
      dbColumns[1] = new ServletIntColumn( aDbData, "ENTITYATTRIBUTEDEF.SUBID", "ENTITYATTRIBUTEDEF", "subId" );
      dbColumns[2] = new ServletIntColumn( aDbData, "ENTITYATTRIBUTEDEF.SORTWEIGHT", "ENTITYATTRIBUTEDEF", "sortWeight" );
      dbColumns[3] = new ServletIntColumn( aDbData, "ENTITYATTRIBUTEDEF.OWNERTYPE", "ENTITYATTRIBUTEDEF", "ownerType" );
      dbColumns[4] = new ServletIntColumn( aDbData, "ENTITYATTRIBUTEDEF.OWNERID", "ENTITYATTRIBUTEDEF", "ownerId" );
      dbColumns[5] = new ServletStringColumn( aDbData, "ENTITYATTRIBUTEDEF.NAME", "ENTITYATTRIBUTEDEF", "name" );
      if ( name == null ) name = ((ServletStringColumn)dbColumns[5]).getValue(); // if it hasn't already been initialized...
      dbColumns[6] = new ServletStringColumn( aDbData, "ENTITYATTRIBUTEDEF.PROMPT", "ENTITYATTRIBUTEDEF", "prompt" );
      if ( prompt == null ) prompt = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
      dbColumns[7] = new ServletIntColumn( aDbData, "ENTITYATTRIBUTEDEF.TYPE", "ENTITYATTRIBUTEDEF", "type" );
      dbColumns[8] = new ServletIntColumn( aDbData, "ENTITYATTRIBUTEDEF.CARDINALITY", "ENTITYATTRIBUTEDEF", "cardinality" );
      dbColumns[9] = new ServletIntColumn( aDbData, "ENTITYATTRIBUTEDEF.DATERESTRICTED", "ENTITYATTRIBUTEDEF", "dateRestricted" );
      dbColumns[10] = new ServletIntColumn( aDbData, "ENTITYATTRIBUTEDEF.USERDEFINED", "ENTITYATTRIBUTEDEF", "userDefined" );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      id = ((ServletIntColumn)dbColumns[0]).getValue();
      subId = ((ServletIntColumn)dbColumns[1]).getValue();
      sortWeight = ((ServletIntColumn)dbColumns[2]).getValue();
      ownerType = ((ServletIntColumn)dbColumns[3]).getValue();
      ownerId = ((ServletIntColumn)dbColumns[4]).getValue();
      name = ((ServletStringColumn)dbColumns[5]).getValue();
      prompt = ((ServletStringColumn)dbColumns[6]).getValue();
      type = ((ServletIntColumn)dbColumns[7]).getValue();
      cardinality = ((ServletIntColumn)dbColumns[8]).getValue();
      dateRestricted = ((ServletIntColumn)dbColumns[9]).getValue();
      userDefined = ((ServletIntColumn)dbColumns[10]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletIntColumn)dbColumns[0]).setValue( id );
      ((ServletIntColumn)dbColumns[1]).setValue( subId );
      ((ServletIntColumn)dbColumns[2]).setValue( sortWeight );
      ((ServletIntColumn)dbColumns[3]).setValue( ownerType );
      ((ServletIntColumn)dbColumns[4]).setValue( ownerId );
      ((ServletStringColumn)dbColumns[5]).setValue( name );
      ((ServletStringColumn)dbColumns[6]).setValue( prompt );
      ((ServletIntColumn)dbColumns[7]).setValue( type );
      ((ServletIntColumn)dbColumns[8]).setValue( cardinality );
      ((ServletIntColumn)dbColumns[9]).setValue( dateRestricted );
      ((ServletIntColumn)dbColumns[10]).setValue( userDefined );
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
      String retString = "\n" + prefix + "EntityAttributeDef Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    id (ENTITYATTRIBUTEDEF.ID) -- ";
         retString += "localVar=\"" + Integer.toString( id) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    subId (ENTITYATTRIBUTEDEF.SUBID) -- ";
         retString += "localVar=\"" + Integer.toString( subId) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    sortWeight (ENTITYATTRIBUTEDEF.SORTWEIGHT) -- ";
         retString += "localVar=\"" + Integer.toString( sortWeight) + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    ownerType (ENTITYATTRIBUTEDEF.OWNERTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    ownerId (ENTITYATTRIBUTEDEF.OWNERID) -- ";
         retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    name (ENTITYATTRIBUTEDEF.NAME) -- ";
         retString += "localVar=\"" + name.toString() + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    prompt (ENTITYATTRIBUTEDEF.PROMPT) -- ";
         retString += "localVar=\"" + prompt.toString() + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    type (ENTITYATTRIBUTEDEF.TYPE) -- ";
         retString += "localVar=\"" + Integer.toString( type) + "\";  ";
         retString += dbColumns[7].toString();
         retString += "\n"+ prefix +   "    cardinality (ENTITYATTRIBUTEDEF.CARDINALITY) -- ";
         retString += "localVar=\"" + Integer.toString( cardinality) + "\";  ";
         retString += dbColumns[8].toString();
         retString += "\n"+ prefix +   "    dateRestricted (ENTITYATTRIBUTEDEF.DATERESTRICTED) -- ";
         retString += "localVar=\"" + Integer.toString( dateRestricted) + "\";  ";
         retString += dbColumns[9].toString();
         retString += "\n"+ prefix +   "    userDefined (ENTITYATTRIBUTEDEF.USERDEFINED) -- ";
         retString += "localVar=\"" + Integer.toString( userDefined) + "\";  ";
         retString += dbColumns[10].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(EntityAttributeDefViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + "id" + ndxSuffix;
         if( viewDef.showSubId ) retString += commaSeparator(retString) + "subId" + ndxSuffix;
         if( viewDef.showSortWeight ) retString += commaSeparator(retString) + "sortWeight" + ndxSuffix;
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + "ownerType" + ndxSuffix;
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + "ownerId" + ndxSuffix;
         if( viewDef.showName ) retString += commaSeparator(retString) + "name" + ndxSuffix;
         if( viewDef.showPrompt ) retString += commaSeparator(retString) + "prompt" + ndxSuffix;
         if( viewDef.showType ) retString += commaSeparator(retString) + "type" + ndxSuffix;
         if( viewDef.showCardinality ) retString += commaSeparator(retString) + "cardinality" + ndxSuffix;
         if( viewDef.showDateRestricted ) retString += commaSeparator(retString) + "dateRestricted" + ndxSuffix;
         if( viewDef.showUserDefined ) retString += commaSeparator(retString) + "userDefined" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(EntityAttributeDefViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + CSVCell( id);
         if( viewDef.showSubId ) retString += commaSeparator(retString) + CSVCell( subId);
         if( viewDef.showSortWeight ) retString += commaSeparator(retString) + CSVCell( sortWeight);
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + CSVCell( ownerType);
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + CSVCell( ownerId);
         if( viewDef.showName ) retString += commaSeparator(retString) + CSVCell( name);
         if( viewDef.showPrompt ) retString += commaSeparator(retString) + CSVCell( prompt);
         if( viewDef.showType ) retString += commaSeparator(retString) + CSVCell( type);
         if( viewDef.showCardinality ) retString += commaSeparator(retString) + CSVCell( cardinality);
         if( viewDef.showDateRestricted ) retString += commaSeparator(retString) + CSVCell( dateRestricted);
         if( viewDef.showUserDefined ) retString += commaSeparator(retString) + CSVCell( userDefined);
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
      sysLogger.info( "DROP TABLE ENTITYATTRIBUTEDEF;" );
      sysLogger.info( "CREATE TABLE ENTITYATTRIBUTEDEF ( ENTITYATTRIBUTEDEF.ID integer, ENTITYATTRIBUTEDEF.SUBID integer, ENTITYATTRIBUTEDEF.SORTWEIGHT integer, ENTITYATTRIBUTEDEF.OWNERTYPE integer, ENTITYATTRIBUTEDEF.OWNERID integer, ENTITYATTRIBUTEDEF.NAME char, ENTITYATTRIBUTEDEF.PROMPT char, ENTITYATTRIBUTEDEF.TYPE integer, ENTITYATTRIBUTEDEF.CARDINALITY integer, ENTITYATTRIBUTEDEF.DATERESTRICTED integer, ENTITYATTRIBUTEDEF.USERDEFINED integer );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "EntityAttributeDef Object:";
      retString += "\n    id (ENTITYATTRIBUTEDEF.ID) -- ";
      retString += "localVar=\"" + Integer.toString( id) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    subId (ENTITYATTRIBUTEDEF.SUBID) -- ";
      retString += "localVar=\"" + Integer.toString( subId) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    sortWeight (ENTITYATTRIBUTEDEF.SORTWEIGHT) -- ";
      retString += "localVar=\"" + Integer.toString( sortWeight) + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    ownerType (ENTITYATTRIBUTEDEF.OWNERTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    ownerId (ENTITYATTRIBUTEDEF.OWNERID) -- ";
      retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    name (ENTITYATTRIBUTEDEF.NAME) -- ";
      retString += "localVar=\"" + name.toString() + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    prompt (ENTITYATTRIBUTEDEF.PROMPT) -- ";
      retString += "localVar=\"" + prompt.toString() + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    type (ENTITYATTRIBUTEDEF.TYPE) -- ";
      retString += "localVar=\"" + Integer.toString( type) + "\";  ";
      retString += dbColumns[7].toString();
      retString += "\n    cardinality (ENTITYATTRIBUTEDEF.CARDINALITY) -- ";
      retString += "localVar=\"" + Integer.toString( cardinality) + "\";  ";
      retString += dbColumns[8].toString();
      retString += "\n    dateRestricted (ENTITYATTRIBUTEDEF.DATERESTRICTED) -- ";
      retString += "localVar=\"" + Integer.toString( dateRestricted) + "\";  ";
      retString += dbColumns[9].toString();
      retString += "\n    userDefined (ENTITYATTRIBUTEDEF.USERDEFINED) -- ";
      retString += "localVar=\"" + Integer.toString( userDefined) + "\";  ";
      retString += dbColumns[10].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "name", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "prompt", label ); 
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
