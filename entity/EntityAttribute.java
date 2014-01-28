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
import org.w3c.dom.*;

public class EntityAttribute extends EntityAttributeDBRecordBase
{

   public static final int OWNERTYPE_PERSON = 1;
   public static final int OWNERTYPE_GROUP  = 2;
   public static final int OWNERTYPE_WGBE = 4;
   public static final int OWNERTYPE_WGBEVENDORCATEGORY  = 6;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityAttribute( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityAttribute( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityAttribute( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityAttribute( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityAttribute( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityAttribute( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }


   public EntityAttribute( DBData dbData, int aOwnerType, int aOwnerId, int aAttributeDefId, int aAttributeDefSubId, int aNdx )
   {
      super( dbData );
      populateObject( "ENTITYATTRIBUTE", "OWNERID = " + aOwnerId + " AND OWNERTYPE = " + aOwnerType + " AND VERSION = " + dbData.getVersionHandler().getVersion( ownerType, ownerId ) + " AND ATTRIBUTEDEFID = " + aAttributeDefId + " AND ATTRIBUTEDEFSUBID = " + aAttributeDefSubId + " AND NDX = " + aNdx, "" );
      ownerType = aOwnerType;
      ownerId = aOwnerId;
      attributeDefId = aAttributeDefId;
      attributeDefSubId = aAttributeDefSubId;
      ndx = aNdx;
   }

   // this constructor ignores ndx; return first one found of any ndx
   public EntityAttribute( DBData dbData, int aOwnerType, int aOwnerId, int aAttributeDefId, int aAttributeDefSubId )
   {
      super( dbData );
      populateObject( "ENTITYATTRIBUTE", "OWNERID = " + aOwnerId + " AND OWNERTYPE = " + aOwnerType + " AND VERSION = " + dbData.getVersionHandler().getVersion( ownerType, ownerId ) + " AND ATTRIBUTEDEFID = " + aAttributeDefId + " AND ATTRIBUTEDEFSUBID = " + aAttributeDefSubId, "" );
      ownerType = aOwnerType;
      ownerId = aOwnerId;
      attributeDefId = aAttributeDefId;
      attributeDefSubId = aAttributeDefSubId;
   }

   // this constructor finds the attribute based on attribute data when ownerId is not known.  Typically used for finding ownerId from filename in gallery
   public EntityAttribute( DBData dbData, String anAttributeData, int anOwnerType, int aAttributeDefId, int aAttributeDefSubId )
   {
      super( dbData );
      populateObject( "ENTITYATTRIBUTE", "ATTRIBUTEDATA = '" + anAttributeData.replace("\\","\\\\") + "' AND OWNERTYPE = " + anOwnerType + " AND VERSION = " + dbData.getVersionHandler().getVersion( ownerType, ownerId ) + " AND ATTRIBUTEDEFID = " + aAttributeDefId + " AND ATTRIBUTEDEFSUBID = " + aAttributeDefSubId, "" );
      ownerType = anOwnerType;
      attributeDefId = aAttributeDefId;
      attributeDefSubId = aAttributeDefSubId;
      attributeData = anAttributeData;
   }

   public EntityAttribute( DBData dbData, int aOwnerType, int aOwnerId, int aAttributeDefId, int aAttributeDefSubId, int aNdx, int  version )
   {
      super( dbData );
      populateObject( "ENTITYATTRIBUTE", "OWNERID = " + aOwnerId + " AND OWNERTYPE = " + aOwnerType + " AND VERSION = " + version  + " AND ATTRIBUTEDEFID = " + aAttributeDefId + " AND ATTRIBUTEDEFSUBID = " + aAttributeDefSubId + " AND NDX = " + aNdx, "" );
      ownerType = aOwnerType;
      ownerId = aOwnerId;
      attributeDefId = aAttributeDefId;
      attributeDefSubId = aAttributeDefSubId;
      ndx = aNdx;
   }

   public boolean createOrUpdateRecord( String tableName )
   {
      boolean rc = true;
      if ( version == 0) version = 1;  // set default
      if ((recordFound) || ( !attributeData.equals("")))
      {
         rc = super.createOrUpdateRecord( tableName ); //  don't create empty attributes
      }
      return(rc);
   }

   public boolean createRecord( String tableName )
   {
      boolean rc = true;
      if ( version == 0) version = 1;  // set default
      if ((recordFound) || ( !attributeData.equals("")))
      {
         if ( ownerId == -1 ) // used by gallery... this means a new gallery file... need to generate a new id for this gallery item
         {
            ResultSet results = processQuery( "SELECT max( OWNERID ) FROM ENTITYATTRIBUTE WHERE OWNERTYPE="+ownerType);
            int generatedValue = 0;
            try
            {
               if ( results.next() )
               {
                  ownerId = results.getInt( 1 ) + 1;
               }
            }
            catch( Exception e)
            {
               dbData.getLog().logEvent( Log.WARNING,  "Exception generating EntityAttribute OwnerId " + e.toString() );
            }
         }
         rc = super.createRecord( tableName ); //  don't create empty attributes
      }
      return(rc);
   }

   public void addToElement( Document doc, Element docElement )
   {
      EntityAttributeDef attributeDef = new EntityAttributeDef( dbData, attributeDefId, attributeDefSubId );

      if ( attributeDef.getType() == EntityAttributeDef.TYPE_PARAGRAPHTEXT )
      {
         Element paragraphElement = doc.createElement(attributeDef.getName());
         paragraphElement.appendChild(doc.createTextNode(attributeData));
         docElement.appendChild(paragraphElement);
      }

      else if ( attributeDef.getType() == EntityAttributeDef.TYPE_URL )
      {
         Element urlElement = doc.createElement(attributeDef.getName());
         urlElement.appendChild(doc.createCDATASection(attributeData));
         docElement.appendChild(urlElement);
      }
      else
      {
         docElement.setAttribute( attributeDef.getName(), attributeData );
      }
   }

}
