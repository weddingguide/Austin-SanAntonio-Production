package jwm.wgbe.model;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.*;
import jwm.wgbe.model.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;


public class MobileMore extends MobileMoreDBRecordBase
{
   private Region region;
   private Document doc;

   String text;
   String url;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MobileMore( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MobileMore( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MobileMore( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MobileMore( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MobileMore( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MobileMore( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public MobileMore( DBData aDbData, Document aDoc, Region aRegion, int ndx, String aText )
   {
      super( aDbData );
      region = aRegion;
      doc = aDoc;

      text = aText;
      url = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, region.getBusinessId(), 136, 1, ndx);
   }

   public Element getElement()
   {
      Element mobileMoreElement = doc.createElement( "mobilemore" );
      mobileMoreElement.setAttribute( "text", text );
      mobileMoreElement.setAttribute( "url", url );
      return( mobileMoreElement );
   }
}
