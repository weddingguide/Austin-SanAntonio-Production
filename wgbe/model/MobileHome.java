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

public class MobileHome extends MobileHomeDBRecordBase
{
   private Region region;
   private Document doc;

   private String mobileHomePageContent;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MobileHome( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MobileHome( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MobileHome( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MobileHome( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MobileHome( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MobileHome( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public MobileHome( DBData aDbData, Document aDoc, Region aRegion )
   {
      super( aDbData );
      region = aRegion;
      doc = aDoc;

      mobileHomePageContent = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, region.getBusinessId(), 135, 0);

      if (mobileHomePageContent.equals(""))
      {
         mobileHomePageContent = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, region.getTexasWeddingsBusinessId(), 135, 0);
      }
   }

   public Element getElement()
   {
      Element mobileHomeElement = doc.createElement( "mobilehome" );
      mobileHomeElement.appendChild(doc.createTextNode(mobileHomePageContent));
      return( mobileHomeElement );
   }
}
