package jwm.entity.model.db;
 
import jwm.db.*;
import jwm.servletdb.*;
import javax.servlet.*;
import javax.servlet.http.*;
import jwm.logger.*;
import jwm.entity.model.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;
 
public class EmailModelDBRecordListBase extends ServletRecordList
{
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EmailModelDBRecordListBase( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData );
      buildList("EMAILMODEL", criteriaString, orderString );
//    log.logEvent( log.TRACE, "EmailModelDBRecordListBase constructor: criteriaString: " + criteriaString + "orderString: " + orderString );
   }
   public EmailModelDBRecordListBase( DBData dbData )
   {
      super( dbData );
//    log.logEvent( log.TRACE, "EmailModelDBRecordListBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
      public EmailModelDBRecordListBase( String aTableName, DBData aDbData, HttpServletRequest request, String label, int typeCol, int typeValue, int logic )
      {
         super( aDbData );
         DBQuery dBQuery =  EmailModel.getDBQuery( aTableName, aDbData, request, label, typeCol, typeValue, logic );
         if ( !dBQuery.isNull() )
         {
            String queryString = "SELECT * FROM " + dBQuery.getTableNameString() + " WHERE " + dBQuery.toString();
            buildList( queryString, 999 );
         }
         else
         {
            recordList = new DBRecord[0];
         }
         log.logEvent( "EmailModelDBRecordListBase constructor from search form" ) ;
      }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EmailModelDBRecordListBase( DBData aDbData, HttpServletRequest request, String label, String parmName )
   {
      super( aDbData, request, label, parmName );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord[] getListInstance( int size )
   {
      return( new EmailModel[ size ] );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord getRecordInstance( DBData aDbData )
   {
      return( new EmailModel( aDbData ) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord getRecordInstance( DBData aDbData, ResultSet resultSet )
   {
      return( new EmailModel( aDbData, resultSet ) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord getRecordInstance( DBData aDbData, HttpServletRequest request, String label )
   {
      return( new EmailModel( aDbData, request, label ) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord getRecordInstance( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      return( new EmailModel( aDbData, request, label, aId ) );
   }
}
