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
 
public class PersonDBRecordBase extends ServletRecord
{
 
   public static final int PERSONID = 0;
   public static final int OWNERID = 1;
   public static final int OWNERTYPE = 2;
   public static final int LASTNAME = 3;
   public static final int FIRSTNAME = 4;
   public static final int MIDDLENAME = 5;
   public static final int TITLE = 6;
   public static final int NICKNAME = 7;
   public static final int SUFFIX = 8;
   public static final int PREFERREDNAME = 9;
   public static final int SEX = 10;
   public static final int AGE = 11;
   public static final int CREATEDATE = 12;
   public static final int LASTUPDATE = 13;
   public static final int STATUS = 14;
   public static final int RECORDTYPE = 15;
   public static final int COMMENT = 16;
   public static final int URL = 17;
   public static final int SITEDEFENTITYTYPE = 18;
   public static final int BIRTHDATE = 19;
 
   public static final String[] COLNAME = {
                                             "PERSON.PERSONID",
                                             "PERSON.OWNERID",
                                             "PERSON.OWNERTYPE",
                                             "PERSON.LASTNAME",
                                             "PERSON.FIRSTNAME",
                                             "PERSON.MIDDLENAME",
                                             "PERSON.TITLE",
                                             "PERSON.NICKNAME",
                                             "PERSON.SUFFIX",
                                             "PERSON.PREFERREDNAME",
                                             "PERSON.SEX",
                                             "PERSON.AGE",
                                             "PERSON.CREATEDATE",
                                             "PERSON.LASTUPDATE",
                                             "PERSON.STATUS",
                                             "PERSON.RECORDTYPE",
                                             "PERSON.COMMENT",
                                             "PERSON.URL",
                                             "PERSON.SITEDEFENTITYTYPE",
                                             "PERSON.BIRTHDATE"
                                                    };
 
   protected int personId;
   public    int getPersonId() { return( personId ); }
   public     void setPersonId( int aPersonId ) { personId = aPersonId; }
 
   protected int ownerId;
   public    int getOwnerId() { return( ownerId ); }
   public     void setOwnerId( int aOwnerId ) { ownerId = aOwnerId; }
 
   protected int ownerType;
   public    int getOwnerType() { return( ownerType ); }
   public     void setOwnerType( int aOwnerType ) { ownerType = aOwnerType; }
 
   protected String lastName = "";
   public    String getLastName() { return( lastName ); }
   public     void setLastName( String aLastName ) { lastName = aLastName; }
 
   protected String firstName = "";
   public    String getFirstName() { return( firstName ); }
   public     void setFirstName( String aFirstName ) { firstName = aFirstName; }
 
   protected String middleName = "";
   public    String getMiddleName() { return( middleName ); }
   public     void setMiddleName( String aMiddleName ) { middleName = aMiddleName; }
 
   protected String title = "";
   public    String getTitle() { return( title ); }
   public     void setTitle( String aTitle ) { title = aTitle; }
 
   protected String nickName = "";
   public    String getNickName() { return( nickName ); }
   public     void setNickName( String aNickName ) { nickName = aNickName; }
 
   protected String suffix = "";
   public    String getSuffix() { return( suffix ); }
   public     void setSuffix( String aSuffix ) { suffix = aSuffix; }
 
   protected String preferredName = "";
   public    String getPreferredName() { return( preferredName ); }
   public     void setPreferredName( String aPreferredName ) { preferredName = aPreferredName; }
 
   protected int sex;
   public    int getSex() { return( sex ); }
   public     void setSex( int aSex ) { sex = aSex; }
 
   protected int age;
   public    int getAge() { return( age ); }
   public     void setAge( int aAge ) { age = aAge; }
 
   protected java.sql.Date createDate;
   public    java.sql.Date getCreateDate() { return( createDate ); }
   public     void setCreateDate( java.sql.Date aCreateDate ) { createDate = aCreateDate; }
 
   protected java.sql.Date lastUpdate;
   public    java.sql.Date getLastUpdate() { return( lastUpdate ); }
   public     void setLastUpdate( java.sql.Date aLastUpdate ) { lastUpdate = aLastUpdate; }
 
   protected int status;
   public    int getStatus() { return( status ); }
   public     void setStatus( int aStatus ) { status = aStatus; }
 
   protected int recordType;
   public    int getRecordType() { return( recordType ); }
   public     void setRecordType( int aRecordType ) { recordType = aRecordType; }
 
   protected String comment = "";
   public    String getComment() { return( comment ); }
   public     void setComment( String aComment ) { comment = aComment; }
 
   protected String url = "";
   public    String getUrl() { return( url ); }
   public     void setUrl( String aUrl ) { url = aUrl; }
 
   protected int siteDefEntityType;
   public    int getSiteDefEntityType() { return( siteDefEntityType ); }
   public     void setSiteDefEntityType( int aSiteDefEntityType ) { siteDefEntityType = aSiteDefEntityType; }
 
   protected java.sql.Date birthDate;
   public    java.sql.Date getBirthDate() { return( birthDate ); }
   public     void setBirthDate( java.sql.Date aBirthDate ) { birthDate = aBirthDate; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PersonDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "PersonDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PersonDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "PersonDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PersonDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "PersonDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PersonDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "PersonDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PersonDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "PersonDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PersonDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "PersonDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 20 ];
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "PERSON.PERSONID", "PERSON", "personId" );
      dbColumns[1] = new ServletIntColumn( aDbData, "PERSON.OWNERID", "PERSON", "ownerId" );
      dbColumns[2] = new ServletIntColumn( aDbData, "PERSON.OWNERTYPE", "PERSON", "ownerType" );
      dbColumns[3] = new ServletStringColumn( aDbData, "PERSON.LASTNAME", "PERSON", "lastName" );
      if ( lastName == null ) lastName = ((ServletStringColumn)dbColumns[3]).getValue(); // if it hasn't already been initialized...
      dbColumns[4] = new ServletStringColumn( aDbData, "PERSON.FIRSTNAME", "PERSON", "firstName" );
      if ( firstName == null ) firstName = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
      dbColumns[5] = new ServletStringColumn( aDbData, "PERSON.MIDDLENAME", "PERSON", "middleName" );
      if ( middleName == null ) middleName = ((ServletStringColumn)dbColumns[5]).getValue(); // if it hasn't already been initialized...
      dbColumns[6] = new ServletStringColumn( aDbData, "PERSON.TITLE", "PERSON", "title" );
      if ( title == null ) title = ((ServletStringColumn)dbColumns[6]).getValue(); // if it hasn't already been initialized...
      dbColumns[7] = new ServletStringColumn( aDbData, "PERSON.NICKNAME", "PERSON", "nickName" );
      if ( nickName == null ) nickName = ((ServletStringColumn)dbColumns[7]).getValue(); // if it hasn't already been initialized...
      dbColumns[8] = new ServletStringColumn( aDbData, "PERSON.SUFFIX", "PERSON", "suffix" );
      if ( suffix == null ) suffix = ((ServletStringColumn)dbColumns[8]).getValue(); // if it hasn't already been initialized...
      dbColumns[9] = new ServletStringColumn( aDbData, "PERSON.PREFERREDNAME", "PERSON", "preferredName" );
      if ( preferredName == null ) preferredName = ((ServletStringColumn)dbColumns[9]).getValue(); // if it hasn't already been initialized...
      dbColumns[10] = new ServletIntColumn( aDbData, "PERSON.SEX", "PERSON", "sex" );
      dbColumns[11] = new ServletIntColumn( aDbData, "PERSON.AGE", "PERSON", "age" );
      dbColumns[12] = new ServletDateColumn( aDbData, "PERSON.CREATEDATE", "PERSON", "createDate" );
      if ( createDate == null ) createDate = ((ServletDateColumn)dbColumns[12]).getValue(); // if it hasn't already been initialized...
      dbColumns[13] = new ServletDateColumn( aDbData, "PERSON.LASTUPDATE", "PERSON", "lastUpdate" );
      if ( lastUpdate == null ) lastUpdate = ((ServletDateColumn)dbColumns[13]).getValue(); // if it hasn't already been initialized...
      dbColumns[14] = new ServletIntColumn( aDbData, "PERSON.STATUS", "PERSON", "status" );
      dbColumns[15] = new ServletIntColumn( aDbData, "PERSON.RECORDTYPE", "PERSON", "recordType" );
      dbColumns[16] = new ServletStringColumn( aDbData, "PERSON.COMMENT", "PERSON", "comment" );
      if ( comment == null ) comment = ((ServletStringColumn)dbColumns[16]).getValue(); // if it hasn't already been initialized...
      dbColumns[17] = new ServletStringColumn( aDbData, "PERSON.URL", "PERSON", "url" );
      if ( url == null ) url = ((ServletStringColumn)dbColumns[17]).getValue(); // if it hasn't already been initialized...
      dbColumns[18] = new ServletIntColumn( aDbData, "PERSON.SITEDEFENTITYTYPE", "PERSON", "siteDefEntityType" );
      dbColumns[19] = new ServletDateColumn( aDbData, "PERSON.BIRTHDATE", "PERSON", "birthDate" );
      if ( birthDate == null ) birthDate = ((ServletDateColumn)dbColumns[19]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      personId = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      ownerId = ((ServletIntColumn)dbColumns[1]).getValue();
      ownerType = ((ServletIntColumn)dbColumns[2]).getValue();
      lastName = ((ServletStringColumn)dbColumns[3]).getValue();
      firstName = ((ServletStringColumn)dbColumns[4]).getValue();
      middleName = ((ServletStringColumn)dbColumns[5]).getValue();
      title = ((ServletStringColumn)dbColumns[6]).getValue();
      nickName = ((ServletStringColumn)dbColumns[7]).getValue();
      suffix = ((ServletStringColumn)dbColumns[8]).getValue();
      preferredName = ((ServletStringColumn)dbColumns[9]).getValue();
      sex = ((ServletIntColumn)dbColumns[10]).getValue();
      age = ((ServletIntColumn)dbColumns[11]).getValue();
      createDate = ((ServletDateColumn)dbColumns[12]).getValue();
      lastUpdate = ((ServletDateColumn)dbColumns[13]).getValue();
      status = ((ServletIntColumn)dbColumns[14]).getValue();
      recordType = ((ServletIntColumn)dbColumns[15]).getValue();
      comment = ((ServletStringColumn)dbColumns[16]).getValue();
      url = ((ServletStringColumn)dbColumns[17]).getValue();
      siteDefEntityType = ((ServletIntColumn)dbColumns[18]).getValue();
      birthDate = ((ServletDateColumn)dbColumns[19]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( personId );
      ((ServletIntColumn)dbColumns[1]).setValue( ownerId );
      ((ServletIntColumn)dbColumns[2]).setValue( ownerType );
      ((ServletStringColumn)dbColumns[3]).setValue( lastName );
      ((ServletStringColumn)dbColumns[4]).setValue( firstName );
      ((ServletStringColumn)dbColumns[5]).setValue( middleName );
      ((ServletStringColumn)dbColumns[6]).setValue( title );
      ((ServletStringColumn)dbColumns[7]).setValue( nickName );
      ((ServletStringColumn)dbColumns[8]).setValue( suffix );
      ((ServletStringColumn)dbColumns[9]).setValue( preferredName );
      ((ServletIntColumn)dbColumns[10]).setValue( sex );
      ((ServletIntColumn)dbColumns[11]).setValue( age );
      ((ServletDateColumn)dbColumns[12]).setValue( createDate );
      ((ServletDateColumn)dbColumns[13]).setValue( lastUpdate );
      ((ServletIntColumn)dbColumns[14]).setValue( status );
      ((ServletIntColumn)dbColumns[15]).setValue( recordType );
      ((ServletStringColumn)dbColumns[16]).setValue( comment );
      ((ServletStringColumn)dbColumns[17]).setValue( url );
      ((ServletIntColumn)dbColumns[18]).setValue( siteDefEntityType );
      ((ServletDateColumn)dbColumns[19]).setValue( birthDate );
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
      String retString = "\n" + prefix + "Person Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    personId (PERSON.PERSONID) -- ";
         retString += "localVar=\"" + Integer.toString( personId) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    ownerId (PERSON.OWNERID) -- ";
         retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    ownerType (PERSON.OWNERTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    lastName (PERSON.LASTNAME) -- ";
         retString += "localVar=\"" + lastName.toString() + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    firstName (PERSON.FIRSTNAME) -- ";
         retString += "localVar=\"" + firstName.toString() + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    middleName (PERSON.MIDDLENAME) -- ";
         retString += "localVar=\"" + middleName.toString() + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    title (PERSON.TITLE) -- ";
         retString += "localVar=\"" + title.toString() + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    nickName (PERSON.NICKNAME) -- ";
         retString += "localVar=\"" + nickName.toString() + "\";  ";
         retString += dbColumns[7].toString();
         retString += "\n"+ prefix +   "    suffix (PERSON.SUFFIX) -- ";
         retString += "localVar=\"" + suffix.toString() + "\";  ";
         retString += dbColumns[8].toString();
         retString += "\n"+ prefix +   "    preferredName (PERSON.PREFERREDNAME) -- ";
         retString += "localVar=\"" + preferredName.toString() + "\";  ";
         retString += dbColumns[9].toString();
         retString += "\n"+ prefix +   "    sex (PERSON.SEX) -- ";
         retString += "localVar=\"" + Integer.toString( sex) + "\";  ";
         retString += dbColumns[10].toString();
         retString += "\n"+ prefix +   "    age (PERSON.AGE) -- ";
         retString += "localVar=\"" + Integer.toString( age) + "\";  ";
         retString += dbColumns[11].toString();
         retString += "\n"+ prefix +   "    createDate (PERSON.CREATEDATE) -- ";
         retString += "localVar=\"" + createDate.toString() + "\";  ";
         retString += dbColumns[12].toString();
         retString += "\n"+ prefix +   "    lastUpdate (PERSON.LASTUPDATE) -- ";
         retString += "localVar=\"" + lastUpdate.toString() + "\";  ";
         retString += dbColumns[13].toString();
         retString += "\n"+ prefix +   "    status (PERSON.STATUS) -- ";
         retString += "localVar=\"" + Integer.toString( status) + "\";  ";
         retString += dbColumns[14].toString();
         retString += "\n"+ prefix +   "    recordType (PERSON.RECORDTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( recordType) + "\";  ";
         retString += dbColumns[15].toString();
         retString += "\n"+ prefix +   "    comment (PERSON.COMMENT) -- ";
         retString += "localVar=\"" + comment.toString() + "\";  ";
         retString += dbColumns[16].toString();
         retString += "\n"+ prefix +   "    url (PERSON.URL) -- ";
         retString += "localVar=\"" + url.toString() + "\";  ";
         retString += dbColumns[17].toString();
         retString += "\n"+ prefix +   "    siteDefEntityType (PERSON.SITEDEFENTITYTYPE) -- ";
         retString += "localVar=\"" + Integer.toString( siteDefEntityType) + "\";  ";
         retString += dbColumns[18].toString();
         retString += "\n"+ prefix +   "    birthDate (PERSON.BIRTHDATE) -- ";
         retString += "localVar=\"" + birthDate.toString() + "\";  ";
         retString += dbColumns[19].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(PersonViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showPersonId ) retString += commaSeparator(retString) + "personId" + ndxSuffix;
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + "ownerId" + ndxSuffix;
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + "ownerType" + ndxSuffix;
         if( viewDef.showLastName ) retString += commaSeparator(retString) + "lastName" + ndxSuffix;
         if( viewDef.showFirstName ) retString += commaSeparator(retString) + "firstName" + ndxSuffix;
         if( viewDef.showMiddleName ) retString += commaSeparator(retString) + "middleName" + ndxSuffix;
         if( viewDef.showTitle ) retString += commaSeparator(retString) + "title" + ndxSuffix;
         if( viewDef.showNickName ) retString += commaSeparator(retString) + "nickName" + ndxSuffix;
         if( viewDef.showSuffix ) retString += commaSeparator(retString) + "suffix" + ndxSuffix;
         if( viewDef.showPreferredName ) retString += commaSeparator(retString) + "preferredName" + ndxSuffix;
         if( viewDef.showSex ) retString += commaSeparator(retString) + "sex" + ndxSuffix;
         if( viewDef.showAge ) retString += commaSeparator(retString) + "age" + ndxSuffix;
         if( viewDef.showCreateDate ) retString += commaSeparator(retString) + "createDate" + ndxSuffix;
         if( viewDef.showLastUpdate ) retString += commaSeparator(retString) + "lastUpdate" + ndxSuffix;
         if( viewDef.showStatus ) retString += commaSeparator(retString) + "status" + ndxSuffix;
         if( viewDef.showRecordType ) retString += commaSeparator(retString) + "recordType" + ndxSuffix;
         if( viewDef.showComment ) retString += commaSeparator(retString) + "comment" + ndxSuffix;
         if( viewDef.showUrl ) retString += commaSeparator(retString) + "url" + ndxSuffix;
         if( viewDef.showSiteDefEntityType ) retString += commaSeparator(retString) + "siteDefEntityType" + ndxSuffix;
         if( viewDef.showBirthDate ) retString += commaSeparator(retString) + "birthDate" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(PersonViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showPersonId ) retString += commaSeparator(retString) + CSVCell( personId);
         if( viewDef.showOwnerId ) retString += commaSeparator(retString) + CSVCell( ownerId);
         if( viewDef.showOwnerType ) retString += commaSeparator(retString) + CSVCell( ownerType);
         if( viewDef.showLastName ) retString += commaSeparator(retString) + CSVCell( lastName);
         if( viewDef.showFirstName ) retString += commaSeparator(retString) + CSVCell( firstName);
         if( viewDef.showMiddleName ) retString += commaSeparator(retString) + CSVCell( middleName);
         if( viewDef.showTitle ) retString += commaSeparator(retString) + CSVCell( title);
         if( viewDef.showNickName ) retString += commaSeparator(retString) + CSVCell( nickName);
         if( viewDef.showSuffix ) retString += commaSeparator(retString) + CSVCell( suffix);
         if( viewDef.showPreferredName ) retString += commaSeparator(retString) + CSVCell( preferredName);
         if( viewDef.showSex ) retString += commaSeparator(retString) + CSVCell( sex);
         if( viewDef.showAge ) retString += commaSeparator(retString) + CSVCell( age);
         if( viewDef.showCreateDate ) retString += commaSeparator(retString) + CSVCell( createDate);
         if( viewDef.showLastUpdate ) retString += commaSeparator(retString) + CSVCell( lastUpdate);
         if( viewDef.showStatus ) retString += commaSeparator(retString) + CSVCell( status);
         if( viewDef.showRecordType ) retString += commaSeparator(retString) + CSVCell( recordType);
         if( viewDef.showComment ) retString += commaSeparator(retString) + CSVCell( comment);
         if( viewDef.showUrl ) retString += commaSeparator(retString) + CSVCell( url);
         if( viewDef.showSiteDefEntityType ) retString += commaSeparator(retString) + CSVCell( siteDefEntityType);
         if( viewDef.showBirthDate ) retString += commaSeparator(retString) + CSVCell( birthDate);
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
      if ( !((ServletStringColumn)dbColumns[3]).isDbUpdateRequired() ) return(false); // column not changed, meaning it is still default value
      if ( !((ServletStringColumn)dbColumns[4]).isDbUpdateRequired() ) return(false); // column not changed, meaning it is still default value
      return( true );
   }
   public void getSQLCreateStatement()
   {
      sysLogger.info( "DROP TABLE PERSON;" );
      sysLogger.info( "CREATE TABLE PERSON ( PERSON.PERSONID integer, PERSON.OWNERID integer, PERSON.OWNERTYPE integer, PERSON.LASTNAME char(40), PERSON.FIRSTNAME char(40), PERSON.MIDDLENAME char(40), PERSON.TITLE char(10), PERSON.NICKNAME char(40), PERSON.SUFFIX char(10), PERSON.PREFERREDNAME char(100), PERSON.SEX integer, PERSON.AGE integer, PERSON.CREATEDATE Date, PERSON.LASTUPDATE Date, PERSON.STATUS integer, PERSON.RECORDTYPE integer, PERSON.COMMENT char, PERSON.URL char, PERSON.SITEDEFENTITYTYPE integer, PERSON.BIRTHDATE Date );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "Person Object:";
      retString += "\n    personId (PERSON.PERSONID) -- ";
      retString += "localVar=\"" + Integer.toString( personId) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    ownerId (PERSON.OWNERID) -- ";
      retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    ownerType (PERSON.OWNERTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( ownerType) + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    lastName (PERSON.LASTNAME) -- ";
      retString += "localVar=\"" + lastName.toString() + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    firstName (PERSON.FIRSTNAME) -- ";
      retString += "localVar=\"" + firstName.toString() + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    middleName (PERSON.MIDDLENAME) -- ";
      retString += "localVar=\"" + middleName.toString() + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    title (PERSON.TITLE) -- ";
      retString += "localVar=\"" + title.toString() + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    nickName (PERSON.NICKNAME) -- ";
      retString += "localVar=\"" + nickName.toString() + "\";  ";
      retString += dbColumns[7].toString();
      retString += "\n    suffix (PERSON.SUFFIX) -- ";
      retString += "localVar=\"" + suffix.toString() + "\";  ";
      retString += dbColumns[8].toString();
      retString += "\n    preferredName (PERSON.PREFERREDNAME) -- ";
      retString += "localVar=\"" + preferredName.toString() + "\";  ";
      retString += dbColumns[9].toString();
      retString += "\n    sex (PERSON.SEX) -- ";
      retString += "localVar=\"" + Integer.toString( sex) + "\";  ";
      retString += dbColumns[10].toString();
      retString += "\n    age (PERSON.AGE) -- ";
      retString += "localVar=\"" + Integer.toString( age) + "\";  ";
      retString += dbColumns[11].toString();
      retString += "\n    createDate (PERSON.CREATEDATE) -- ";
      retString += "localVar=\"" + createDate.toString() + "\";  ";
      retString += dbColumns[12].toString();
      retString += "\n    lastUpdate (PERSON.LASTUPDATE) -- ";
      retString += "localVar=\"" + lastUpdate.toString() + "\";  ";
      retString += dbColumns[13].toString();
      retString += "\n    status (PERSON.STATUS) -- ";
      retString += "localVar=\"" + Integer.toString( status) + "\";  ";
      retString += dbColumns[14].toString();
      retString += "\n    recordType (PERSON.RECORDTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( recordType) + "\";  ";
      retString += dbColumns[15].toString();
      retString += "\n    comment (PERSON.COMMENT) -- ";
      retString += "localVar=\"" + comment.toString() + "\";  ";
      retString += dbColumns[16].toString();
      retString += "\n    url (PERSON.URL) -- ";
      retString += "localVar=\"" + url.toString() + "\";  ";
      retString += dbColumns[17].toString();
      retString += "\n    siteDefEntityType (PERSON.SITEDEFENTITYTYPE) -- ";
      retString += "localVar=\"" + Integer.toString( siteDefEntityType) + "\";  ";
      retString += dbColumns[18].toString();
      retString += "\n    birthDate (PERSON.BIRTHDATE) -- ";
      retString += "localVar=\"" + birthDate.toString() + "\";  ";
      retString += dbColumns[19].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "lastName", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "firstName", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "middleName", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "title", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "nickName", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "suffix", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "preferredName", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "createDate", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "lastUpdate", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "comment", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "url", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "birthDate", label ); 
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
