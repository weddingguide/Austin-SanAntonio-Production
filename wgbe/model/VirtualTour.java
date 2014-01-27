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
import java.net.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;

public class VirtualTour extends VirtualTourDBRecordBase
{
   private Document doc;

   private String tourURL = "";
   private String embedText = "false";

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public VirtualTour( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public VirtualTour( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public VirtualTour( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public VirtualTour( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public VirtualTour( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public VirtualTour( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public VirtualTour( DBData aDbData, Document aDoc, int ndx, EntityAttribute virtualTourAttr )
   {
      super( aDbData );
      doc = aDoc;
      try
      {
         tourURL = URLEncoder.encode( virtualTourAttr.getAttributeData(), "UTF-8");
      }
      catch( Exception e)
      {
        tourURL = "Exception converting URL ("+tourURL+") to UTF-8 -- " + e;
      }
      if ( EntityAttributeList.getAttributeValue(dbData, virtualTourAttr.getOwnerType(), virtualTourAttr.getOwnerId(), 9, 1, ndx ).equals( "checked" )) embedText = "true";
   }

   public Element getElement()
   {
      Element virtualTourElement = doc.createElement( "virtualTour" );
      virtualTourElement.setAttribute( "url", tourURL );
      virtualTourElement.setAttribute( "embed", embedText );

      return( virtualTourElement );
   }
}
