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
 
public class PersonEmailMapDBRecordBase extends ServletRecord
{
 
   public static final int PERSONID = 0;
   public static final int EMAILID = 1;
 
   public static final String[] COLNAME = {
                                             "PERSONEMAILMAP.PERSONID",
                                             "PERSONEMAILMAP.EMAILID"
                                                    };
 
   protected int personId;
   public    int getPersonId() { return( personId ); }
   public     void setPersonId( int aPersonId ) { personId = aPersonId; }
 
   protected int emailId;
   public    int getEmailId() { return( emailId ); }
   public     void setEmailId( int aEmailId ) { emailId = aEmailId; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PersonEmailMapDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "PersonEmailMapDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PersonEmailMapDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "PersonEmailMapDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PersonEmailMapDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "PersonEmailMapDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PersonEmailMapDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "PersonEmailMapDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PersonEmailMapDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "PersonEmailMapDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PersonEmailMapDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "PersonEmailMapDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 2 ];
      dbColumns[0] = new ServletIntColumn( aDbData, "PERSONEMAILMAP.PERSONID", "PERSONEMAILMAP", "personId" );
      dbColumns[1] = new ServletIntColumn( aDbData, "PERSONEMAILMAP.EMAILID", "PERSONEMAILMAP", "emailId" );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      personId = ((ServletIntColumn)dbColumns[0]).getValue();
      emailId = ((ServletIntColumn)dbColumns[1]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletIntColumn)dbColumns[0]).setValue( personId );
      ((ServletIntColumn)dbColumns[1]).setValue( emailId );
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
      String retString = "\n" + prefix + "PersonEmailMap Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    personId (PERSONEMAILMAP.PERSONID) -- ";
         retString += "localVar=\"" + Integer.toString( personId) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    emailId (PERSONEMAILMAP.EMAILID) -- ";
         retString += "localVar=\"" + Integer.toString( emailId) + "\";  ";
         retString += dbColumns[1].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(PersonEmailMapViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showPersonId ) retString += commaSeparator(retString) + "personId" + ndxSuffix;
         if( viewDef.showEmailId ) retString += commaSeparator(retString) + "emailId" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(PersonEmailMapViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showPersonId ) retString += commaSeparator(retString) + CSVCell( personId);
         if( viewDef.showEmailId ) retString += commaSeparator(retString) + CSVCell( emailId);
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
      sysLogger.info( "DROP TABLE PERSONEMAILMAP;" );
      sysLogger.info( "CREATE TABLE PERSONEMAILMAP ( PERSONEMAILMAP.PERSONID integer, PERSONEMAILMAP.EMAILID integer );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "PersonEmailMap Object:";
      retString += "\n    personId (PERSONEMAILMAP.PERSONID) -- ";
      retString += "localVar=\"" + Integer.toString( personId) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    emailId (PERSONEMAILMAP.EMAILID) -- ";
      retString += "localVar=\"" + Integer.toString( emailId) + "\";  ";
      retString += dbColumns[1].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
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
