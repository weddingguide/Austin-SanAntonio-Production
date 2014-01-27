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

public class Banner extends BannerDBRecordBase
{
   private Document doc;

   private  EntityGroupList vCategories = null;
   private  String          primaryvCategoryName = "";
   private  String          phone = "";
   private  int             ownerId = 0;
   private  String          category = "";
   private  String          ownerName = "";
   private  String          title = "";
   private  java.sql.Date   start = null;
   private  java.sql.Date   expires = null;
   private  String          imageURL = "";
   private  String          description = "";
   private  String          bannerImageFile = "";
   private  boolean         imageCacheScaleOnlyFlag = false;
   private  String[]        images;

   private  int             vendorStatus = -1;
   public   void            setVendorStatus( int aVendorStatus ) { vendorStatus = aVendorStatus; }
   public   int             getVendorStatus()        { return(vendorStatus); }


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Banner( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Banner( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Banner( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Banner( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Banner( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Banner( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public Banner( DBData aDbData, Document aDoc, int anNdx, EntityAttribute bannerAttr )
   {
      super( aDbData );
      doc = aDoc;
      ndx = anNdx;

      link = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, bannerAttr.getOwnerId(), 60, 2, bannerAttr.getNdx());

      String theTargetAttribute = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, bannerAttr.getOwnerId(), 60, 11, bannerAttr.getNdx());
      target = "_bannernew";
      if (theTargetAttribute.equals("0")) target = ""; // if no attribute defined (legacy default), or if value is true, target is new window, else current window

      owner = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, bannerAttr.getOwnerId(), 1, 0);

      image = "/galleries/"+bannerAttr.getOwnerId()+"/"+bannerAttr.getAttributeData();

      if (link.equals(""))
      {
         link = "/"+WGBEUtils.getURLCompliantVendorName(dbData, bannerAttr.getOwnerId());
         target = "";
      }
      description = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, bannerAttr.getOwnerId(), 60, 3, bannerAttr.getNdx());
      if (description.equals(""))
      {
         description =  "Click here for more information.";
      }
   }

   public Element getElement()
   {
      Element bannerElement = doc.createElement( "banner" );
      bannerElement.setAttribute( "owner", owner );
      bannerElement.setAttribute( "description", description );
      bannerElement.setAttribute( "image", image );
      bannerElement.setAttribute( "link", link );
      bannerElement.setAttribute( "target", target );
      bannerElement.setAttribute( "ndx", new Integer(ndx).toString() );

      return( bannerElement );
   }
}
