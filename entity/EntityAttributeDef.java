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

public class EntityAttributeDef extends EntityAttributeDefDBRecordBase
{
   public static final int TYPE_INT = 1;
   public static final int TYPE_STRING = 2;
   public static final int TYPE_IMAGE = 3;
   public static final int TYPE_PARAGRAPHTEXT = 4;
   public static final int TYPE_URL = 5;
   public static final int TYPE_VIDEO = 6;
   public static final int TYPE_BOOLEAN = 7;
   public static final int TYPE_SELECTION = 8; // values defined in attributes only using special ownertype
   public static final int TYPE_DATE = 9;

   public static final String[] TYPETEXT = { "--0--",
                                             "Integer",
                                             "Text String",
                                             "Image",
                                             "Paragraph Text",
                                             "URL",
                                             "Video",
                                             "Boolean",
                                             "Selection",
                                             "Date" };

   public static final int OWNERTYPE_GLOBAL = 0;
   public static final int OWNERTYPE_GROUP  = 2;
   public static final int OWNERTYPE_ATTRIBUTEDEF   =  3;  // These values are used to define the values for multiselect attributes
   public static final int OWNERTYPE_SPECIAL_GROUP  =  4; // specifically used for WGBE main site 'business' groups (austinweddings, saweddings, texasweddings)
   public static final int OWNERTYPE_GROUP_CONTROL  =  5; // non-display attribute; used specifically for omit-details attributes on vendor groups
   public static final int OWNERTYPE_VENDORCATEGORY =  6; // for WGBE
   public static final int OWNERTYPE_CMS_STATIC_PAGE=  7; //
   public static final int OWNERTYPE_GALLERYITEM    = 16; // matches ObjClassID def ... trying to converge these two name spaces...

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityAttributeDef( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityAttributeDef( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityAttributeDef( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityAttributeDef( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityAttributeDef( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityAttributeDef( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public EntityAttributeDef( DBData dbData, int ownerId, String name)
   {
      super( dbData );
      populateObject( "ENTITYATTRIBUTEDEF", "OWNERID = " + ownerId + " AND NAME = '" + name + "'", "" );
   }

   public EntityAttributeDef( DBData dbData, int ownerType, String name, boolean signatureFlag)
   {
      super( dbData );
      populateObject( "ENTITYATTRIBUTEDEF", "OWNERTYPE = " + ownerType + " AND NAME = '" + name + "'", "" );
   }


   public EntityAttributeDef( DBData dbData, int id, int subId )
   {
      super( dbData );
      populateObject( "ENTITYATTRIBUTEDEF", "ID = " + id + " AND SUBID = " + subId, "" );
   }

   public int generateSubId()
   {
      ResultSet results = processQuery( "SELECT max(subid) FROM EntityAttributeDef where ID = " + id );
      int generatedValue = 0;
      try
      {
         if ( results.next() )
         {
            generatedValue = results.getInt( 1 ) + 1;
         }
      }
      catch( Exception e)
      {
         dbData.getLog().logEvent( Log.ERROR,  "Error generating new subid for attribute" );
         dbData.getLog().logEvent( Log.ERROR,  e.toString() );
      }
      return( generatedValue );
   }

   public int generateId()
   {
      ResultSet results = processQuery( "SELECT max(id) FROM EntityAttributeDef ");
      int generatedValue = 0;
      try
      {
         if ( results.next() )
         {
            generatedValue = results.getInt( 1 ) + 1;
         }
      }
      catch( Exception e)
      {
         dbData.getLog().logEvent( Log.ERROR,  "Error generating new id for attribute" );
         dbData.getLog().logEvent( Log.ERROR,  e.toString() );
      }
      return( generatedValue );
   }

}
