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


public class Video extends VideoDBRecordBase
{
   private Document doc;

   String name        = "";
   String mediaSource = "";
   String videoTitle  = "";
   String description = "";
   String vThumbnail  = "";
   int    ndx         = -1;
   int    ownerId     = -1;
   String url         = "";

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Video( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Video( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Video( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Video( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Video( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Video( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public Video( DBData aDbData, Document aDoc, int aNdx, EntityAttribute videoAttr )
   {
      super( aDbData );
      doc = aDoc;
      ndx = aNdx;
      ownerId = videoAttr.getOwnerId();

      mediaSource = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 10, 1, ndx);
      if ((mediaSource.equals( "Uploaded video" )) || (mediaSource.equals( "checked" ))) //'checked' is legacy value
      {
         mediaSource = "Upload";
      }

      String nameAttr = videoAttr.getAttributeData();
      url = name = nameAttr;

      if (mediaSource.equals( "Upload" ))
      {
         name = "/galleries/"+ownerId+"/"+nameAttr;
         url = name;
      }

      if (mediaSource.equals( "YouTube" ))
      {
          if ( !name.toUpperCase().startsWith( "HTTP://" )) name="http://www.youtube.com/embed/"+name;
          url = "<iframe width=\"398\" height=\"224\" src=\""+name+"\" frameborder=\"0\" allowfullscreen></iframe>";
      }

      if (mediaSource.equals( "Vimeo" ))
      {
          if ( !name.toUpperCase().startsWith( "HTTP://" )) name="http://player.vimeo.com/video/"+name;
          url = "<iframe src=\""+name+"?title=0&amp;byline=0&amp;portrait=0\" width=\"469\" height=\"264\" frameborder=\"0\" webkitAllowFullScreen allowFullScreen></iframe>";
      }

      videoTitle = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 10, 11, ndx);
      description = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 10, 12, ndx);
      vThumbnail = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 10, 2, ndx);
   }

   public Element getElement()
   {
      Element videoElement = doc.createElement( "video" );
      videoElement.setAttribute( "id", name );
      videoElement.setAttribute( "source", mediaSource );
      videoElement.setAttribute( "title", videoTitle );
      videoElement.setAttribute( "url", url );
      videoElement.setAttribute( "thumbnail", "/galleries/"+ownerId+"/"+vThumbnail );
      Element vDescr = doc.createElement( "description" );
      videoElement.appendChild( vDescr );
      vDescr.appendChild( doc.createTextNode( description ));
      return( videoElement );
   }
}
