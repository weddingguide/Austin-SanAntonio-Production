package jwm.entity.db;
 
import jwm.db.*;
import jwm.servletdb.*;
import javax.servlet.*;
import javax.servlet.http.*;
import jwm.logger.*;
import jwm.entity.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;
 
public class MailTemplateDBRecordListBase extends ServletRecordList
{
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MailTemplateDBRecordListBase( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData );
      buildList("MAILTEMPLATE", criteriaString, orderString );
//    log.logEvent( log.TRACE, "MailTemplateDBRecordListBase constructor: criteriaString: " + criteriaString + "orderString: " + orderString );
   }
   public MailTemplateDBRecordListBase( DBData dbData )
   {
      super( dbData );
//    log.logEvent( log.TRACE, "MailTemplateDBRecordListBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
      public MailTemplateDBRecordListBase( String aTableName, DBData aDbData, HttpServletRequest request, String label, int typeCol, int typeValue, int logic )
      {
         super( aDbData );
         DBQuery dBQuery =  MailTemplate.getDBQuery( aTableName, aDbData, request, label, typeCol, typeValue, logic );
         if ( !dBQuery.isNull() )
         {
            String queryString = "SELECT * FROM " + dBQuery.getTableNameString() + " WHERE " + dBQuery.toString();
            buildList( queryString, 999 );
         }
         else
         {
            recordList = new DBRecord[0];
         }
         log.logEvent( "MailTemplateDBRecordListBase constructor from search form" ) ;
      }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MailTemplateDBRecordListBase( DBData aDbData, HttpServletRequest request, String label, String parmName )
   {
      super( aDbData, request, label, parmName );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord[] getListInstance( int size )
   {
      return( new MailTemplate[ size ] );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord getRecordInstance( DBData aDbData )
   {
      return( new MailTemplate( aDbData ) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord getRecordInstance( DBData aDbData, ResultSet resultSet )
   {
      return( new MailTemplate( aDbData, resultSet ) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord getRecordInstance( DBData aDbData, HttpServletRequest request, String label )
   {
      return( new MailTemplate( aDbData, request, label ) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord getRecordInstance( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      return( new MailTemplate( aDbData, request, label, aId ) );
   }
}
