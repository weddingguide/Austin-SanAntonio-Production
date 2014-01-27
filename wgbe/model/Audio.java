package jwm.wgbe.model;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.*;
import jwm.wgbe.model.db.*;
import jwm.wgbe.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;


public class Audio extends AudioDBRecordBase
{
   private Document doc;

   String name        = "";
   String embed       = "";
   String audioTitle  = "";
   String description = "";
   String vThumbnail  = "";
   int    ndx         = -1;
   int    ownerId     = -1;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Audio( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Audio( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Audio( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Audio( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Audio( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Audio( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public Audio( DBData aDbData, Document aDoc, int aNdx, EntityAttribute audioAttr )
   {
      super( aDbData );
      doc = aDoc;
      ndx = aNdx;
      name = audioAttr.getAttributeData();
      ownerId = audioAttr.getOwnerId();

      embed = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 47, 1, ndx);
      audioTitle = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 10, 11, ndx);
      if (audioTitle == "" )
      {
         String[] parts = name.split(".");
         try
         {
            audioTitle = parts[0];
         }
         catch( Exception e)
         {
            audioTitle = name;
         }
      }
      description = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 10, 12, ndx);
      vThumbnail = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 10, 2, ndx);
   }

   public Element getElement()
   {
      Element audioElement = doc.createElement( "audio" );
      audioElement.setAttribute( "id", "/galleries/"+ownerId+"/"+name );
      audioElement.setAttribute( "embed", embed );
      audioElement.setAttribute( "title", audioTitle );
      audioElement.setAttribute( "thumbnail", "/galleries/"+ownerId+"/"+vThumbnail );
      Element vDescr = doc.createElement( "description" );
      audioElement.appendChild( vDescr );
      vDescr.appendChild( doc.createTextNode( description ));
      return( audioElement );
   }
}
