package jwm.entity;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GroupCategory extends GroupCategoryDBRecordBase
{

   public static final int STATUS_ACTIVE = 1;
   public static final int STATUS_REMOVED = 2;

   public static final int UPDATETYPE_DEFAULT = 0;
   public static final int UPDATETYPE_AUTO_UPDATE_ONLY = 1; // means it's not ad hoc drag/drop members in via gui... membership is controlled by another object (e.g. contract)

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupCategory( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupCategory( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupCategory( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupCategory( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupCategory( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupCategory( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public GroupCategory( DBData dbData, int categoryId )
   {
      super( dbData );
      populateObject( "GROUPCATEGORY", "ID= " + categoryId, "" );
   }

   public GroupCategory( DBData dbData, String aName )
   {
      super( dbData );
      populateObject( "GROUPCATEGORY", "NAME= " + prepareStringField(aName), "" );
   }
}
