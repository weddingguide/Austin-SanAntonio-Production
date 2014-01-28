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
 
public class MailTemplateDBRecordBase extends ServletRecord
{
 
   public static final int ID = 0;
   public static final int NAME = 1;
   public static final int DESCRIPTION = 2;
   public static final int BODY = 3;
   public static final int SUBJECT = 4;
   public static final int QUALIFIER = 5;
   public static final int TOSTATUS = 6;
   public static final int TOFOLLOWUP = 7;
   public static final int STATUSBATCH = 8;
   public static final int GROUPBATCH = 9;
   public static final int INDIVIDUAL = 10;
   public static final int PREVENTDUPLICATES = 11;
   public static final int ONLYTORESPONSEDUE = 12;
 
   public static final String[] COLNAME = {
                                             "MAILTEMPLATE.id",
                                             "MAILTEMPLATE.name",
                                             "MAILTEMPLATE.description",
                                             "MAILTEMPLATE.body",
                                             "MAILTEMPLATE.subject",
                                             "MAILTEMPLATE.Qualifier",
                                             "MAILTEMPLATE.toStatus",
                                             "MAILTEMPLATE.toFollowup",
                                             "MAILTEMPLATE.statusbatch",
                                             "MAILTEMPLATE.groupbatch",
                                             "MAILTEMPLATE.individual",
                                             "MAILTEMPLATE.preventDuplicates",
                                             "MAILTEMPLATE.onlyToResponseDue"
                                                    };
 
   protected int id;
   public    int getId() { return( id ); }
   public     void setId( int aId ) { id = aId; }
 
   protected String name = "";
   public    String getName() { return( name ); }
   public     void setName( String aName ) { name = aName; }
 
   protected String description = "";
   public    String getDescription() { return( description ); }
   public     void setDescription( String aDescription ) { description = aDescription; }
 
   protected String body = "";
   public    String getBody() { return( body ); }
   public     void setBody( String aBody ) { body = aBody; }
 
   protected String subject = "";
   public    String getSubject() { return( subject ); }
   public     void setSubject( String aSubject ) { subject = aSubject; }
 
   protected String qualifier = "";
   public    String getQualifier() { return( qualifier ); }
   public     void setQualifier( String aQualifier ) { qualifier = aQualifier; }
 
   protected String toStatus = "";
   public    String getToStatus() { return( toStatus ); }
   public     void setToStatus( String aToStatus ) { toStatus = aToStatus; }
 
   protected int toFollowup;
   public    int getToFollowup() { return( toFollowup ); }
   public     void setToFollowup( int aToFollowup ) { toFollowup = aToFollowup; }
 
   protected int statusBatch;
   public    int getStatusBatch() { return( statusBatch ); }
   public     void setStatusBatch( int aStatusBatch ) { statusBatch = aStatusBatch; }
 
   protected int groupBatch;
   public    int getGroupBatch() { return( groupBatch ); }
   public     void setGroupBatch( int aGroupBatch ) { groupBatch = aGroupBatch; }
 
   protected int individual;
   public    int getIndividual() { return( individual ); }
   public     void setIndividual( int aIndividual ) { individual = aIndividual; }
 
   protected int preventDuplicates;
   public    int getPreventDuplicates() { return( preventDuplicates ); }
   public     void setPreventDuplicates( int aPreventDuplicates ) { preventDuplicates = aPreventDuplicates; }
 
   protected int onlyToResponseDue;
   public    int getOnlyToResponseDue() { return( onlyToResponseDue ); }
   public     void setOnlyToResponseDue( int aOnlyToResponseDue ) { onlyToResponseDue = aOnlyToResponseDue; }
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MailTemplateDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "MailTemplateDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MailTemplateDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "MailTemplateDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MailTemplateDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "MailTemplateDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MailTemplateDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "MailTemplateDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MailTemplateDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "MailTemplateDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MailTemplateDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "MailTemplateDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 13 ];
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "MAILTEMPLATE.id", "MAILTEMPLATE", "id" );
      dbColumns[1] = new ServletStringColumn( aDbData, "MAILTEMPLATE.name", "MAILTEMPLATE", "name" );
      if ( name == null ) name = ((ServletStringColumn)dbColumns[1]).getValue(); // if it hasn't already been initialized...
      dbColumns[2] = new ServletStringColumn( aDbData, "MAILTEMPLATE.description", "MAILTEMPLATE", "description" );
      if ( description == null ) description = ((ServletStringColumn)dbColumns[2]).getValue(); // if it hasn't already been initialized...
      dbColumns[3] = new ServletStringColumn( aDbData, "MAILTEMPLATE.body", "MAILTEMPLATE", "body" );
      if ( body == null ) body = ((ServletStringColumn)dbColumns[3]).getValue(); // if it hasn't already been initialized...
      dbColumns[4] = new ServletStringColumn( aDbData, "MAILTEMPLATE.subject", "MAILTEMPLATE", "subject" );
      if ( subject == null ) subject = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
      dbColumns[5] = new ServletStringColumn( aDbData, "MAILTEMPLATE.Qualifier", "MAILTEMPLATE", "qualifier" );
      if ( qualifier == null ) qualifier = ((ServletStringColumn)dbColumns[5]).getValue(); // if it hasn't already been initialized...
      dbColumns[6] = new ServletStringColumn( aDbData, "MAILTEMPLATE.toStatus", "MAILTEMPLATE", "toStatus" );
      if ( toStatus == null ) toStatus = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
      dbColumns[7] = new ServletIntColumn( aDbData, "MAILTEMPLATE.toFollowup", "MAILTEMPLATE", "toFollowup" );
      dbColumns[8] = new ServletBoolIntColumn( aDbData, "MAILTEMPLATE.statusbatch", "MAILTEMPLATE", "statusBatch" );
      dbColumns[9] = new ServletBoolIntColumn( aDbData, "MAILTEMPLATE.groupbatch", "MAILTEMPLATE", "groupBatch" );
      dbColumns[10] = new ServletBoolIntColumn( aDbData, "MAILTEMPLATE.individual", "MAILTEMPLATE", "individual" );
      dbColumns[11] = new ServletBoolIntColumn( aDbData, "MAILTEMPLATE.preventDuplicates", "MAILTEMPLATE", "preventDuplicates" );
      dbColumns[12] = new ServletBoolIntColumn( aDbData, "MAILTEMPLATE.onlyToResponseDue", "MAILTEMPLATE", "onlyToResponseDue" );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      id = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      name = ((ServletStringColumn)dbColumns[1]).getValue();
      description = ((ServletStringColumn)dbColumns[2]).getValue();
      body = ((ServletStringColumn)dbColumns[3]).getValue();
      subject = ((ServletStringColumn)dbColumns[4]).getValue();
      qualifier = ((ServletStringColumn)dbColumns[5]).getValue();
      toStatus = ((ServletStringColumn)dbColumns[6]).getValue();
      toFollowup = ((ServletIntColumn)dbColumns[7]).getValue();
      statusBatch = ((ServletBoolIntColumn)dbColumns[8]).getValue();
      groupBatch = ((ServletBoolIntColumn)dbColumns[9]).getValue();
      individual = ((ServletBoolIntColumn)dbColumns[10]).getValue();
      preventDuplicates = ((ServletBoolIntColumn)dbColumns[11]).getValue();
      onlyToResponseDue = ((ServletBoolIntColumn)dbColumns[12]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( id );
      ((ServletStringColumn)dbColumns[1]).setValue( name );
      ((ServletStringColumn)dbColumns[2]).setValue( description );
      ((ServletStringColumn)dbColumns[3]).setValue( body );
      ((ServletStringColumn)dbColumns[4]).setValue( subject );
      ((ServletStringColumn)dbColumns[5]).setValue( qualifier );
      ((ServletStringColumn)dbColumns[6]).setValue( toStatus );
      ((ServletIntColumn)dbColumns[7]).setValue( toFollowup );
      ((ServletBoolIntColumn)dbColumns[8]).setValue( statusBatch );
      ((ServletBoolIntColumn)dbColumns[9]).setValue( groupBatch );
      ((ServletBoolIntColumn)dbColumns[10]).setValue( individual );
      ((ServletBoolIntColumn)dbColumns[11]).setValue( preventDuplicates );
      ((ServletBoolIntColumn)dbColumns[12]).setValue( onlyToResponseDue );
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
      String retString = "\n" + prefix + "MailTemplate Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    id (MAILTEMPLATE.id) -- ";
         retString += "localVar=\"" + Integer.toString( id) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    name (MAILTEMPLATE.name) -- ";
         retString += "localVar=\"" + name.toString() + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    description (MAILTEMPLATE.description) -- ";
         retString += "localVar=\"" + description.toString() + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    body (MAILTEMPLATE.body) -- ";
         retString += "localVar=\"" + body.toString() + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    subject (MAILTEMPLATE.subject) -- ";
         retString += "localVar=\"" + subject.toString() + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    qualifier (MAILTEMPLATE.Qualifier) -- ";
         retString += "localVar=\"" + qualifier.toString() + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    toStatus (MAILTEMPLATE.toStatus) -- ";
         retString += "localVar=\"" + toStatus.toString() + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    toFollowup (MAILTEMPLATE.toFollowup) -- ";
         retString += "localVar=\"" + Integer.toString( toFollowup) + "\";  ";
         retString += dbColumns[7].toString();
         retString += "\n"+ prefix +   "    statusBatch (MAILTEMPLATE.statusbatch) -- ";
         retString += "localVar=\"" + Integer.toString( statusBatch) + "\";  ";
         retString += dbColumns[8].toString();
         retString += "\n"+ prefix +   "    groupBatch (MAILTEMPLATE.groupbatch) -- ";
         retString += "localVar=\"" + Integer.toString( groupBatch) + "\";  ";
         retString += dbColumns[9].toString();
         retString += "\n"+ prefix +   "    individual (MAILTEMPLATE.individual) -- ";
         retString += "localVar=\"" + Integer.toString( individual) + "\";  ";
         retString += dbColumns[10].toString();
         retString += "\n"+ prefix +   "    preventDuplicates (MAILTEMPLATE.preventDuplicates) -- ";
         retString += "localVar=\"" + Integer.toString( preventDuplicates) + "\";  ";
         retString += dbColumns[11].toString();
         retString += "\n"+ prefix +   "    onlyToResponseDue (MAILTEMPLATE.onlyToResponseDue) -- ";
         retString += "localVar=\"" + Integer.toString( onlyToResponseDue) + "\";  ";
         retString += dbColumns[12].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(MailTemplateViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + "id" + ndxSuffix;
         if( viewDef.showName ) retString += commaSeparator(retString) + "name" + ndxSuffix;
         if( viewDef.showDescription ) retString += commaSeparator(retString) + "description" + ndxSuffix;
         if( viewDef.showBody ) retString += commaSeparator(retString) + "body" + ndxSuffix;
         if( viewDef.showSubject ) retString += commaSeparator(retString) + "subject" + ndxSuffix;
         if( viewDef.showQualifier ) retString += commaSeparator(retString) + "qualifier" + ndxSuffix;
         if( viewDef.showToStatus ) retString += commaSeparator(retString) + "toStatus" + ndxSuffix;
         if( viewDef.showToFollowup ) retString += commaSeparator(retString) + "toFollowup" + ndxSuffix;
         if( viewDef.showStatusBatch ) retString += commaSeparator(retString) + "statusBatch" + ndxSuffix;
         if( viewDef.showGroupBatch ) retString += commaSeparator(retString) + "groupBatch" + ndxSuffix;
         if( viewDef.showIndividual ) retString += commaSeparator(retString) + "individual" + ndxSuffix;
         if( viewDef.showPreventDuplicates ) retString += commaSeparator(retString) + "preventDuplicates" + ndxSuffix;
         if( viewDef.showOnlyToResponseDue ) retString += commaSeparator(retString) + "onlyToResponseDue" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(MailTemplateViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showId ) retString += commaSeparator(retString) + CSVCell( id);
         if( viewDef.showName ) retString += commaSeparator(retString) + CSVCell( name);
         if( viewDef.showDescription ) retString += commaSeparator(retString) + CSVCell( description);
         if( viewDef.showBody ) retString += commaSeparator(retString) + CSVCell( body);
         if( viewDef.showSubject ) retString += commaSeparator(retString) + CSVCell( subject);
         if( viewDef.showQualifier ) retString += commaSeparator(retString) + CSVCell( qualifier);
         if( viewDef.showToStatus ) retString += commaSeparator(retString) + CSVCell( toStatus);
         if( viewDef.showToFollowup ) retString += commaSeparator(retString) + CSVCell( toFollowup);
         if( viewDef.showStatusBatch ) retString += commaSeparator(retString) + CSVCell( statusBatch);
         if( viewDef.showGroupBatch ) retString += commaSeparator(retString) + CSVCell( groupBatch);
         if( viewDef.showIndividual ) retString += commaSeparator(retString) + CSVCell( individual);
         if( viewDef.showPreventDuplicates ) retString += commaSeparator(retString) + CSVCell( preventDuplicates);
         if( viewDef.showOnlyToResponseDue ) retString += commaSeparator(retString) + CSVCell( onlyToResponseDue);
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
      sysLogger.info( "DROP TABLE MAILTEMPLATE;" );
      sysLogger.info( "CREATE TABLE MAILTEMPLATE ( MAILTEMPLATE.id integer, MAILTEMPLATE.name char, MAILTEMPLATE.description char, MAILTEMPLATE.body char, MAILTEMPLATE.subject char, MAILTEMPLATE.Qualifier char, MAILTEMPLATE.toStatus char, MAILTEMPLATE.toFollowup integer, MAILTEMPLATE.statusbatch integer, MAILTEMPLATE.groupbatch integer, MAILTEMPLATE.individual integer, MAILTEMPLATE.preventDuplicates integer, MAILTEMPLATE.onlyToResponseDue integer );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "MailTemplate Object:";
      retString += "\n    id (MAILTEMPLATE.id) -- ";
      retString += "localVar=\"" + Integer.toString( id) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    name (MAILTEMPLATE.name) -- ";
      retString += "localVar=\"" + name.toString() + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    description (MAILTEMPLATE.description) -- ";
      retString += "localVar=\"" + description.toString() + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    body (MAILTEMPLATE.body) -- ";
      retString += "localVar=\"" + body.toString() + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    subject (MAILTEMPLATE.subject) -- ";
      retString += "localVar=\"" + subject.toString() + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    qualifier (MAILTEMPLATE.Qualifier) -- ";
      retString += "localVar=\"" + qualifier.toString() + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    toStatus (MAILTEMPLATE.toStatus) -- ";
      retString += "localVar=\"" + toStatus.toString() + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    toFollowup (MAILTEMPLATE.toFollowup) -- ";
      retString += "localVar=\"" + Integer.toString( toFollowup) + "\";  ";
      retString += dbColumns[7].toString();
      retString += "\n    statusBatch (MAILTEMPLATE.statusbatch) -- ";
      retString += "localVar=\"" + Integer.toString( statusBatch) + "\";  ";
      retString += dbColumns[8].toString();
      retString += "\n    groupBatch (MAILTEMPLATE.groupbatch) -- ";
      retString += "localVar=\"" + Integer.toString( groupBatch) + "\";  ";
      retString += dbColumns[9].toString();
      retString += "\n    individual (MAILTEMPLATE.individual) -- ";
      retString += "localVar=\"" + Integer.toString( individual) + "\";  ";
      retString += dbColumns[10].toString();
      retString += "\n    preventDuplicates (MAILTEMPLATE.preventDuplicates) -- ";
      retString += "localVar=\"" + Integer.toString( preventDuplicates) + "\";  ";
      retString += dbColumns[11].toString();
      retString += "\n    onlyToResponseDue (MAILTEMPLATE.onlyToResponseDue) -- ";
      retString += "localVar=\"" + Integer.toString( onlyToResponseDue) + "\";  ";
      retString += dbColumns[12].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "name", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "description", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "body", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "subject", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "qualifier", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "toStatus", label ); 
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
