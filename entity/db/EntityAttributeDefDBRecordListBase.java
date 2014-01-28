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
 
public class EntityAttributeDefDBRecordListBase extends ServletRecordList
{
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDefDBRecordListBase( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData );
      buildList("ENTITYATTRIBUTEDEF", criteriaString, orderString );
//    log.logEvent( log.TRACE, "EntityAttributeDefDBRecordListBase constructor: criteriaString: " + criteriaString + "orderString: " + orderString );
   }
   public EntityAttributeDefDBRecordListBase( DBData dbData )
   {
      super( dbData );
//    log.logEvent( log.TRACE, "EntityAttributeDefDBRecordListBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
      public EntityAttributeDefDBRecordListBase( String aTableName, DBData aDbData, HttpServletRequest request, String label, int typeCol, int typeValue, int logic )
      {
         super( aDbData );
         DBQuery dBQuery =  EntityAttributeDef.getDBQuery( aTableName, aDbData, request, label, typeCol, typeValue, logic );
         if ( !dBQuery.isNull() )
         {
            String queryString = "SELECT * FROM " + dBQuery.getTableNameString() + " WHERE " + dBQuery.toString();
            buildList( queryString, 999 );
         }
         else
         {
            recordList = new DBRecord[0];
         }
         log.logEvent( "EntityAttributeDefDBRecordListBase constructor from search form" ) ;
      }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDefDBRecordListBase( DBData aDbData, HttpServletRequest request, String label, String parmName )
   {
      super( aDbData, request, label, parmName );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord[] getListInstance( int size )
   {
      return( new EntityAttributeDef[ size ] );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord getRecordInstance( DBData aDbData )
   {
      return( new EntityAttributeDef( aDbData ) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord getRecordInstance( DBData aDbData, ResultSet resultSet )
   {
      return( new EntityAttributeDef( aDbData, resultSet ) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord getRecordInstance( DBData aDbData, HttpServletRequest request, String label )
   {
      return( new EntityAttributeDef( aDbData, request, label ) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public DBRecord getRecordInstance( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      return( new EntityAttributeDef( aDbData, request, label, aId ) );
   }
}
