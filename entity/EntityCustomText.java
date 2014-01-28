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

public class EntityCustomText extends EntityCustomTextDBRecordBase
{
   public static int OBJECTTYPE_ADDRESS = 1;
   public static int OBJECTTYPE_PHONE   = 2;
   public static int OBJECTTYPE_EMAIL   = 3;
   public static int OBJECTTYPE_BIRTHDAY= 4;
   public static int OBJECTTYPE_SEX     = 5;

   public static int TEXTTYPE_LONG = 0;
   public static int TEXTTYPE_SHORT = 1;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityCustomText( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityCustomText( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityCustomText( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityCustomText( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityCustomText( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityCustomText( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }


   public EntityCustomText( DBData dbData, int anEntityType, int anObjectType, int anInstance )
   {
      super( dbData );

      String queryString = "ENTITYTYPE = "
                         + anEntityType
                         + " AND OBJECTTYPE = "
                         + anObjectType
                         + " AND INSTANCE = "
                         + anInstance;

      populateObject( "ENTITYCUSTOMTEXT", queryString, "" );
   }
}
