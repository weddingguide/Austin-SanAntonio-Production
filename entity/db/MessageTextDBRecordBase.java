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
 
public class MessageTextDBRecordBase extends ServletRecord
{
 
   public static final int MSGID = 0;
   public static final int LABEL = 1;
   public static final int TEXT = 2;
 
   public static final String[] COLNAME = {
                                             "MESSAGETEXT.MSGID",
                                             "MESSAGETEXT.LABEL",
                                             "MESSAGETEXT.TEXT"
                                                    };
 
   protected int msgId;
   public    int getMsgId() { return( msgId ); }
   public     void setMsgId( int aMsgId ) { msgId = aMsgId; }
 
   protected String label = "";
   public    String getLabel() { return( label ); }
   public     void setLabel( String aLabel ) { label = aLabel; }
 
   protected String text = "";
   public    String getText() { return( text ); }
   public     void setText( String aText ) { text = aText; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MessageTextDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "MessageTextDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MessageTextDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "MessageTextDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MessageTextDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "MessageTextDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MessageTextDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "MessageTextDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MessageTextDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "MessageTextDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MessageTextDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "MessageTextDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 3 ];
      dbColumns[0] = new ServletIntColumn( aDbData, "MESSAGETEXT.MSGID", "MESSAGETEXT", "msgId" );
      dbColumns[1] = new ServletStringColumn( aDbData, "MESSAGETEXT.LABEL", "MESSAGETEXT", "label" );
      if ( label == null ) label = ((ServletStringColumn)dbColumns[1]).getValue(); // if it hasn't already been initialized...
      dbColumns[2] = new ServletStringColumn( aDbData, "MESSAGETEXT.TEXT", "MESSAGETEXT", "text" );
      if ( text == null ) text = ((ServletStringColumn)dbColumns[2]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      msgId = ((ServletIntColumn)dbColumns[0]).getValue();
      label = ((ServletStringColumn)dbColumns[1]).getValue();
      text = ((ServletStringColumn)dbColumns[2]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletIntColumn)dbColumns[0]).setValue( msgId );
      ((ServletStringColumn)dbColumns[1]).setValue( label );
      ((ServletStringColumn)dbColumns[2]).setValue( text );
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
      String retString = "\n" + prefix + "MessageText Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    msgId (MESSAGETEXT.MSGID) -- ";
         retString += "localVar=\"" + Integer.toString( msgId) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    label (MESSAGETEXT.LABEL) -- ";
         retString += "localVar=\"" + label.toString() + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    text (MESSAGETEXT.TEXT) -- ";
         retString += "localVar=\"" + text.toString() + "\";  ";
         retString += dbColumns[2].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(MessageTextViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showMsgId ) retString += commaSeparator(retString) + "msgId" + ndxSuffix;
         if( viewDef.showLabel ) retString += commaSeparator(retString) + "label" + ndxSuffix;
         if( viewDef.showText ) retString += commaSeparator(retString) + "text" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(MessageTextViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showMsgId ) retString += commaSeparator(retString) + CSVCell( msgId);
         if( viewDef.showLabel ) retString += commaSeparator(retString) + CSVCell( label);
         if( viewDef.showText ) retString += commaSeparator(retString) + CSVCell( text);
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
      sysLogger.info( "DROP TABLE MESSAGETEXT;" );
      sysLogger.info( "CREATE TABLE MESSAGETEXT ( MESSAGETEXT.MSGID integer, MESSAGETEXT.LABEL char, MESSAGETEXT.TEXT char );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "MessageText Object:";
      retString += "\n    msgId (MESSAGETEXT.MSGID) -- ";
      retString += "localVar=\"" + Integer.toString( msgId) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    label (MESSAGETEXT.LABEL) -- ";
      retString += "localVar=\"" + label.toString() + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    text (MESSAGETEXT.TEXT) -- ";
      retString += "localVar=\"" + text.toString() + "\";  ";
      retString += dbColumns[2].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "label", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "text", label ); 
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
