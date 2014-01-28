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
 
public class PageDataDBRecordListBase extends ServletRecordList
{
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PageDataDBRecordListBase( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData );
      buildList("PAGEDATA", criteriaString, orderString );
//    log.logEvent( log.TRACE, "PageDataDBRecordListBase constructor: criteriaString: " + criteriaString + "orderString: " + orderString );
   }
   public PageDataDBRecordListBase( DBData dbData )
   {
      super( dbData );
//    log.logEvent( log.TRACE, "PageDataDBRecordListBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
      public PageDataDBRecordListBase( String aTableName, DBData aDbData, HttpServletRequest request, String label, int typeCol, int typeValue, int logic )
      {
         super( aDbData );
         DBQuery dBQuery =  PageData.getDBQuery( aTableName, aDbData, request, label, typeCol, typeValue, logic );
         if ( !dBQuery.isNull() )
         {
            String queryString = "SELECT * FROM " + dBQuery.getTableNameString() + " WHERE " + dBQuery.toString();
            buildList( queryString, 999 );
         }
         else
         {
            recordList = new DBRecord[0];
         }
         log.logEvent( "PageDataDBRecordListBase constructor from search form" ) ;
      }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PageDataDBRecordListBase( DBData aDbData, HttpServletRequest request, String label, String parmName )
   {
      super( aDbData, request, label, parmName );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord[] getListInstance( int size )
   {
      return( new PageData[ size ] );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord getRecordInstance( DBData aDbData )
   {
      return( new PageData( aDbData ) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord getRecordInstance( DBData aDbData, ResultSet resultSet )
   {
      return( new PageData( aDbData, resultSet ) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord getRecordInstance( DBData aDbData, HttpServletRequest request, String label )
   {
      return( new PageData( aDbData, request, label ) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord getRecordInstance( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      return( new PageData( aDbData, request, label, aId ) );
   }
}
