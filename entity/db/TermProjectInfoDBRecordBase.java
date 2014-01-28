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
 
public class TermProjectInfoDBRecordBase extends ServletRecord
{
 
   public static final int OWNERTYPE = 0;
   public static final int OWNERID = 1;
   public static final int TITLE = 2;
   public static final int OVERVIEW = 3;
   public static final int SCENARIO = 4;
   public static final int PROFROLE = 5;
   public static final int TEAMROLE = 6;
   public static final int ACTIONREQUEST = 7;
   public static final int REPORTURL = 8;
   public static final int FEEDBACK = 9;
   public static final int EVALUATION = 10;
   public static final int PRESENTATIONSECTION = 11;
   public static final int REPORTDOC = 12;
   public static final int GRADE = 13;
   public static final int CREATEDATE = 14;
 
   public static final String[] COLNAME = {
                                             "TERMPROJECTINFO.OWNERTYPE",
                                             "TERMPROJECTINFO.OWNERID",
                                             "TERMPROJECTINFO.TTTLE",
                                             "TERMPROJECTINFO.OVERVIEW",
                                             "TERMPROJECTINFO.SCENARIO",
                                             "TERMPROJECTINFO.PROFROLE",
                                             "TERMPROJECTINFO.TEAMROLE",
                                             "TERMPROJECTINFO.ACTIONREQUEST",
                                             "TERMPROJECTINFO.REPORTURL",
                                             "TERMPROJECTINFO.FEEDBACK",
                                             "TERMPROJECTINFO.EVALUATION",
                                             "TERMPROJECTINFO.PRESENTATIONSECTION",
                                             "TERMPROJECTINFO.REPORTDOC",
                                             "TERMPROJECTINFO.GRADE",
                                             "TERMPROJECTINFO.CREATEDATE"
                                                    };
 
   protected int ownerType;
   public    int getOwnerType() { return( ownerType ); }
   public     void setOwnerType( int aOwnerType ) { ownerType = aOwnerType; }
 
   protected int ownerId;
   public    int getOwnerId() { return( ownerId ); }
   public     void setOwnerId( int aOwnerId ) { ownerId = aOwnerId; }
 
   protected String title = "";
   public    String getTitle() { return( title ); }
   public     void setTitle( String aTitle ) { title = aTitle; }
 
   protected String overview = "";
   public    String getOverview() { return( overview ); }
   public     void setOverview( String aOverview ) { overview = aOverview; }
 
   protected String scenario = "";
   public    String getScenario() { return( scenario ); }
   public     void setScenario( String aScenario ) { scenario = aScenario; }
 
   protected String profRole = "";
   public    String getProfRole() { return( profRole ); }
   public     void setProfRole( String aProfRole ) { profRole = aProfRole; }
 
   protected String teamRole = "";
   public    String getTeamRole() { return( teamRole ); }
   public     void setTeamRole( String aTeamRole ) { teamRole = aTeamRole; }
 
   protected String actionRequest = "";
   public    String getActionRequest() { return( actionRequest ); }
   public     void setActionRequest( String aActionRequest ) { actionRequest = aActionRequest; }
 
   protected String reportURL = "";
   public    String getReportURL() { return( reportURL ); }
   public     void setReportURL( String aReportURL ) { reportURL = aReportURL; }
 
   protected String feedback = "";
   public    String getFeedback() { return( feedback ); }
   public     void setFeedback( String aFeedback ) { feedback = aFeedback; }
 
   protected String evaluation = "";
   public    String getEvaluation() { return( evaluation ); }
   public     void setEvaluation( String aEvaluation ) { evaluation = aEvaluation; }
 
   protected int presentationSection;
   public    int getPresentationSection() { return( presentationSection ); }
   public     void setPresentationSection( int aPresentationSection ) { presentationSection = aPresentationSection; }
 
   protected String reportDoc = "";
   public    String getReportDoc() { return( reportDoc ); }
   public     void setReportDoc( String aReportDoc ) { reportDoc = aReportDoc; }
 
   protected String grade = "";
   public    String getGrade() { return( grade ); }
   public     void setGrade( String aGrade ) { grade = aGrade; }
 
   protected java.sql.Date createDate;
   public    java.sql.Date getCreateDate() { return( createDate ); }
   public     void setCreateDate( java.sql.Date aCreateDate ) { createDate = aCreateDate; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public TermProjectInfoDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "TermProjectInfoDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public TermProjectInfoDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "TermProjectInfoDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public TermProjectInfoDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "TermProjectInfoDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public TermProjectInfoDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "TermProjectInfoDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public TermProjectInfoDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "TermProjectInfoDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public TermProjectInfoDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "TermProjectInfoDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 15 ];
      dbColumns[0] = new ServletIntColumn( aDbData, "TERMPROJECTINFO.OWNERTYPE", "TERMPROJECTINFO", "ownerType" );
      dbColumns[1] = new ServletIntColumn( aDbData, "TERMPROJECTINFO.OWNERID", "TERMPROJECTINFO", "ownerId" );
      dbColumns[2] = new ServletStringColumn( aDbData, "TERMPROJECTINFO.TTTLE", "TERMPROJECTINFO", "title" );
      if ( title == null ) title = ((ServletStringColumn)dbColumns[2]).getValue(); // if it hasn't already been initialized...
      dbColumns[3] = new ServletStringColumn( aDbData, "TERMPROJECTINFO.OVERVIEW", "TERMPROJECTINFO", "overview" );
      if ( overview == null ) overview = ((ServletStringColumn)dbColumns[3]).getValue(); // if it hasn't already been initialized...
      dbColumns[4] = new ServletStringColumn( aDbData, "TERMPROJECTINFO.SCENARIO", "TERMPROJECTINFO", "scenario" );
      if ( scenario == null ) scenario = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
      dbColumns[5] = new ServletStringColumn( aDbData, "TERMPROJECTINFO.PROFROLE", "TERMPROJECTINFO", "profRole" );
      if ( profRole == null ) profRole = ((ServletStringColumn)dbColumns[5]).getValue(); // if it hasn't already been initialized...
      dbColumns[6] = new ServletStringColumn( aDbData, "TERMPROJECTINFO.TEAMROLE", "TERMPROJECTINFO", "teamRole" );
      if ( teamRole == null ) teamRole = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
      dbColumns[7] = new ServletStringColumn( aDbData, "TERMPROJECTINFO.ACTIONREQUEST", "TERMPROJECTINFO", "actionRequest" );
      if ( actionRequest == null ) actionRequest = ((ServletStringColumn)dbColumns[7]).getValue(); // if it hasn't already been initialized...
      dbColumns[8] = new ServletStringColumn( aDbData, "TERMPROJECTINFO.REPORTURL", "TERMPROJECTINFO", "reportURL" );
      if ( reportURL == null ) reportURL = ((ServletStringColumn)dbColumns[8]).getValue(); // if it hasn't already been initialized...
      dbColumns[9] = new ServletStringColumn( aDbData, "TERMPROJECTINFO.FEEDBACK", "TERMPROJECTINFO", "feedback" );
      if ( feedback == null ) feedback = ((ServletStringColumn)dbColumns[9]).getValue(); // if it hasn't already been initialized...
      dbColumns[10] = new ServletStringColumn( aDbData, "TERMPROJECTINFO.EVALUATION", "TERMPROJECTINFO", "evaluation" );
      if ( evaluation == null ) evaluation = ((ServletStringColumn)dbColumns[10]).getValue(); // if it hasn't already been initialized...
      dbColumns[11] = new ServletIntColumn( aDbData, "TERMPROJECTINFO.PRESENTATIONSECTION", "TERMPROJECTINFO", "presentationSection" );
      dbColumns[12] = new ServletStringColumn( aDbData, "TERMPROJECTINFO.REPORTDOC", "TERMPROJECTINFO", "reportDoc" );
      if ( reportDoc == null ) reportDoc = ((ServletStringColumn)dbColumns[12]).getValue(); // if it hasn't already been initialized...
      dbColumns[13] = new ServletStringColumn( aDbData, "TERMPROJECTINFO.GRADE", "TERMPROJECTINFO", "grade" );
      if ( grade == null ) grade = ((ServletStringColumn)dbColumns[13]).getValue(); // if it hasn't already been initialized...
      dbColumns[14] = new ServletDateColumn( aDbData, "TERMPROJECTINFO.CREATEDATE", "TERMPROJECTINFO", "createDate" );
      if ( createDate == null ) createDate = ((ServletDateColumn)dbColumns[14]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      ownerType = ((ServletIntColumn)dbColumns[0]).getValue();
      ownerId = ((ServletIntColumn)dbColumns[1]).getValue();
      title = ((ServletStringColumn)dbColumns[2]).getValue();
      overview = ((ServletStringColumn)dbColumns[3]).getValue();
      scenario = ((ServletStringColumn)dbColumns[4]).getValue();
      profRole = ((ServletStringColumn)dbColumns[5]).getValue();
      teamRole = ((ServletStringColumn)dbColumns[6]).getValue();
      actionRequest = ((ServletStringColumn)dbColumns[7]).getValue();
      reportURL = ((ServletStringColumn)dbColumns[8]).getValue();
      feedback = ((ServletStringColumn)dbColumns[9]).getValue();
      evaluation = ((ServletStringColumn)dbColumns[10]).getValue();
      presentationSection = ((ServletIntColumn)dbColumns[11]).getValue();
      reportDoc = ((ServletStringColumn)dbColumns[12]).getValue();
      grade = ((ServletStringColumn)dbColumns[13]).getValue();
      createDate = ((ServletDateColumn)dbColumns[14]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletIntColumn)dbColumns[0]).setValue( ownerType );
      ((ServletIntColumn)dbColumns[1]).setValue( ownerId );
      ((ServletStringColumn)dbColumns[2]).setValue( title );
      ((ServletStringColumn)dbColumns[3]).setValue( overview );
      ((ServletStringColumn)dbColumns[4]).setValue( scenario );
      ((ServletStringColumn)dbColumns[5]).setValue( profRole );
      ((ServletStringColumn)dbColumns[6]).setValue( teamRole );
      ((ServletStringColumn)dbColumns[7]).setValue( actionRequest );
      ((ServletStringColumn)dbColumns[8]).setValue( reportURL );
      ((ServletStringColumn)dbColumns[9]).setValue( feedback );
      ((ServletStringColumn)dbColumns[10]).setValue( evaluation );
      ((ServletIntColumn)dbColumns[11]).setValue( presentationSection );
      ((ServletStringColumn)dbColumns[12]).setValue( reportDoc );
      ((ServletStringColumn)dbColumns[13]).setValue( grade );
      ((ServletDateColumn)dbColumns[14]).setValue( createDate );
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
      String retString = "\n" + prefix + "TermProjectInfo Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    ownerType (TERMPROJECTINFO.OWNERTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    ownerId (TERMPROJECTINFO.OWNERID) -- ";
         retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    title (TERMPROJECTINFO.TTTLE) -- ";
         retString += "localVar=\"" + title.toString() + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    overview (TERMPROJECTINFO.OVERVIEW) -- ";
         retString += "localVar=\"" + overview.toString() + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    scenario (TERMPROJECTINFO.SCENARIO) -- ";
         retString += "localVar=\"" + scenario.toString() + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    profRole (TERMPROJECTINFO.PROFROLE) -- ";
         retString += "localVar=\"" + profRole.toString() + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    teamRole (TERMPROJECTINFO.TEAMROLE) -- ";
         retString += "localVar=\"" + teamRole.toString() + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    actionRequest (TERMPROJECTINFO.ACTIONREQUEST) -- ";
         retString += "localVar=\"" + actionRequest.toString() + "\";  ";
         retString += dbColumns[7].toString();
         retString += "\n"+ prefix +   "    reportURL (TERMPROJECTINFO.REPORTURL) -- ";
         retString += "localVar=\"" + reportURL.toString() + "\";  ";
         retString += dbColumns[8].toString();
         retString += "\n"+ prefix +   "    feedback (TERMPROJECTINFO.FEEDBACK) -- ";
         retString += "localVar=\"" + feedback.toString() + "\";  ";
         retString += dbColumns[9].toString();
         retString += "\n"+ prefix +   "    evaluation (TERMPROJECTINFO.EVALUATION) -- ";
         retString += "localVar=\"" + evaluation.toString() + "\";  ";
         retString += dbColumns[10].toString();
         retString += "\n"+ prefix +   "    presentationSection (TERMPROJECTINFO.PRESENTATIONSECTION) -- ";
         retString += "localVar=\"" + Integer.toString( presentationSection) + "\";  ";
         retString += dbColumns[11].toString();
         retString += "\n"+ prefix +   "    reportDoc (TERMPROJECTINFO.REPORTDOC) -- ";
         retString += "localVar=\"" + reportDoc.toString() + "\";  ";
         retString += dbColumns[12].toString();
         retString += "\n"+ prefix +   "    grade (TERMPROJECTINFO.GRADE) -- ";
         retString += "localVar=\"" + grade.toString() + "\";  ";
         retString += dbColumns[13].toString();
         retString += "\n"+ prefix +   "    createDate (TERMPROJECTINFO.CREATEDATE) -- ";
         retString += "localVar=\"" + createDate.toString() + "\";  ";
         retString += dbColumns[14].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(TermProjectInfoViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + "ownerType" + ndxSuffix;
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + "ownerId" + ndxSuffix;
         if( viewDef.showTitle ) retString += commaSeparator(retString) + "title" + ndxSuffix;
         if( viewDef.showOverview ) retString += commaSeparator(retString) + "overview" + ndxSuffix;
         if( viewDef.showScenario ) retString += commaSeparator(retString) + "scenario" + ndxSuffix;
         if( viewDef.showProfRole ) retString += commaSeparator(retString) + "profRole" + ndxSuffix;
         if( viewDef.showTeamRole ) retString += commaSeparator(retString) + "teamRole" + ndxSuffix;
         if( viewDef.showActionRequest ) retString += commaSeparator(retString) + "actionRequest" + ndxSuffix;
         if( viewDef.showReportURL ) retString += commaSeparator(retString) + "reportURL" + ndxSuffix;
         if( viewDef.showFeedback ) retString += commaSeparator(retString) + "feedback" + ndxSuffix;
         if( viewDef.showEvaluation ) retString += commaSeparator(retString) + "evaluation" + ndxSuffix;
         if( viewDef.showPresentationSection ) retString += commaSeparator(retString) + "presentationSection" + ndxSuffix;
         if( viewDef.showReportDoc ) retString += commaSeparator(retString) + "reportDoc" + ndxSuffix;
         if( viewDef.showGrade ) retString += commaSeparator(retString) + "grade" + ndxSuffix;
         if( viewDef.showCreateDate ) retString += commaSeparator(retString) + "createDate" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(TermProjectInfoViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + CSVCell( ownerType);
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + CSVCell( ownerId);
         if( viewDef.showTitle ) retString += commaSeparator(retString) + CSVCell( title);
         if( viewDef.showOverview ) retString += commaSeparator(retString) + CSVCell( overview);
         if( viewDef.showScenario ) retString += commaSeparator(retString) + CSVCell( scenario);
         if( viewDef.showProfRole ) retString += commaSeparator(retString) + CSVCell( profRole);
         if( viewDef.showTeamRole ) retString += commaSeparator(retString) + CSVCell( teamRole);
         if( viewDef.showActionRequest ) retString += commaSeparator(retString) + CSVCell( actionRequest);
         if( viewDef.showReportURL ) retString += commaSeparator(retString) + CSVCell( reportURL);
         if( viewDef.showFeedback ) retString += commaSeparator(retString) + CSVCell( feedback);
         if( viewDef.showEvaluation ) retString += commaSeparator(retString) + CSVCell( evaluation);
         if( viewDef.showPresentationSection ) retString += commaSeparator(retString) + CSVCell( presentationSection);
         if( viewDef.showReportDoc ) retString += commaSeparator(retString) + CSVCell( reportDoc);
         if( viewDef.showGrade ) retString += commaSeparator(retString) + CSVCell( grade);
         if( viewDef.showCreateDate ) retString += commaSeparator(retString) + CSVCell( createDate);
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
      sysLogger.info( "DROP TABLE TERMPROJECTINFO;" );
      sysLogger.info( "CREATE TABLE TERMPROJECTINFO ( TERMPROJECTINFO.OWNERTYPE integer, TERMPROJECTINFO.OWNERID integer, TERMPROJECTINFO.TTTLE char, TERMPROJECTINFO.OVERVIEW char, TERMPROJECTINFO.SCENARIO char, TERMPROJECTINFO.PROFROLE char, TERMPROJECTINFO.TEAMROLE char, TERMPROJECTINFO.ACTIONREQUEST char, TERMPROJECTINFO.REPORTURL char, TERMPROJECTINFO.FEEDBACK char, TERMPROJECTINFO.EVALUATION char, TERMPROJECTINFO.PRESENTATIONSECTION integer, TERMPROJECTINFO.REPORTDOC char, TERMPROJECTINFO.GRADE char, TERMPROJECTINFO.CREATEDATE Date );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "TermProjectInfo Object:";
      retString += "\n    ownerType (TERMPROJECTINFO.OWNERTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    ownerId (TERMPROJECTINFO.OWNERID) -- ";
      retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    title (TERMPROJECTINFO.TTTLE) -- ";
      retString += "localVar=\"" + title.toString() + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    overview (TERMPROJECTINFO.OVERVIEW) -- ";
      retString += "localVar=\"" + overview.toString() + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    scenario (TERMPROJECTINFO.SCENARIO) -- ";
      retString += "localVar=\"" + scenario.toString() + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    profRole (TERMPROJECTINFO.PROFROLE) -- ";
      retString += "localVar=\"" + profRole.toString() + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    teamRole (TERMPROJECTINFO.TEAMROLE) -- ";
      retString += "localVar=\"" + teamRole.toString() + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    actionRequest (TERMPROJECTINFO.ACTIONREQUEST) -- ";
      retString += "localVar=\"" + actionRequest.toString() + "\";  ";
      retString += dbColumns[7].toString();
      retString += "\n    reportURL (TERMPROJECTINFO.REPORTURL) -- ";
      retString += "localVar=\"" + reportURL.toString() + "\";  ";
      retString += dbColumns[8].toString();
      retString += "\n    feedback (TERMPROJECTINFO.FEEDBACK) -- ";
      retString += "localVar=\"" + feedback.toString() + "\";  ";
      retString += dbColumns[9].toString();
      retString += "\n    evaluation (TERMPROJECTINFO.EVALUATION) -- ";
      retString += "localVar=\"" + evaluation.toString() + "\";  ";
      retString += dbColumns[10].toString();
      retString += "\n    presentationSection (TERMPROJECTINFO.PRESENTATIONSECTION) -- ";
      retString += "localVar=\"" + Integer.toString( presentationSection) + "\";  ";
      retString += dbColumns[11].toString();
      retString += "\n    reportDoc (TERMPROJECTINFO.REPORTDOC) -- ";
      retString += "localVar=\"" + reportDoc.toString() + "\";  ";
      retString += dbColumns[12].toString();
      retString += "\n    grade (TERMPROJECTINFO.GRADE) -- ";
      retString += "localVar=\"" + grade.toString() + "\";  ";
      retString += dbColumns[13].toString();
      retString += "\n    createDate (TERMPROJECTINFO.CREATEDATE) -- ";
      retString += "localVar=\"" + createDate.toString() + "\";  ";
      retString += dbColumns[14].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "title", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "overview", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "scenario", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "profRole", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "teamRole", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "actionRequest", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "reportURL", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "feedback", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "evaluation", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "reportDoc", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "grade", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "createDate", label ); 
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
