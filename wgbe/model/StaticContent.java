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

public class StaticContent extends StaticContentDBRecordBase
{
   private Document doc;

   private String content = "";
   public  void   setContent( String aContent ) { content = aContent; }
   public  String getContent()   { return(content); }

   private String name = "";
   public  void   setName( String aName ) { name = aName; }
   public  String getName()      { return(name); }

   private String pageTitle = "";
   public  void   setPageTitle( String aPageTitle ) { pageTitle = aPageTitle; }
   public  String getPageTitle() { return(pageTitle); }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public StaticContent( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public StaticContent( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public StaticContent( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public StaticContent( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public StaticContent( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public StaticContent( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public StaticContent( DBData aDbData, Document aDoc, Region aRegion, String aContentAttrName, String aPageTitleAttrName )
   {
      super( aDbData );
      doc = aDoc;
      name = aContentAttrName;
      content = getAttrData( aRegion, aContentAttrName );
   }

   public String getAttrData( Region aRegion, String attrName )
   {
      EntityAttributeDef attrDef = new EntityAttributeDef( dbData, aRegion.getTexasWeddingsGroup(), attrName );
      return( getAttrData( aRegion, attrDef.getId(), attrDef.getSubId() ));
   }


   public String getAttrData( Region aRegion, int attrId, int attrSubId)
   {
      String attrData = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, aRegion.getBusinessId(), attrId, attrSubId);
      if (content.equals(""))
      {
         content = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, aRegion.getTexasWeddingsBusinessId(), attrId, attrSubId);
      }
      return( attrData );
   }

   public Element getElement()
   {
      Element staticContentElement = doc.createElement( "staticcontent" );
      staticContentElement.setAttribute( "name", name );

      Element contentElement = doc.createElement("content");
      contentElement.appendChild(doc.createCDATASection(content));
      staticContentElement.appendChild(contentElement);

      return( staticContentElement );
   }
}
