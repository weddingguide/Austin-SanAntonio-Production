package jwm.wgbe.model;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.wgbe.model.db.*;
import jwm.logger.*;
import jwm.entity.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;

public class Region extends RegionDBRecordBase
{
   private Document doc;

   private String otherSite = "";
   public  void   setOtherSite( String aOtherSite ) { otherSite = aOtherSite; }
   public  String getOtherSite() { return(otherSite); }

   private String otherSiteURL = "";
   public  void   setOtherSiteURL( String aOtherSiteURL ) { otherSiteURL = aOtherSiteURL; }
   public  String getOtherSiteURL() { return(otherSiteURL); }

   private Image headerMag = null;
   private Image headerLogo = null;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Region( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Region( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Region( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Region( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Region( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Region( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public Region( DBData aDbData, Document aDoc, String aRegion )
   {
      super( aDbData );

      try
      {
         doc = aDoc;

         if ( aRegion == null ) aRegion = "";

         if (aRegion.toUpperCase().equals( "AUSTIN" ) )   businessId = 8671;
         else if (aRegion.toUpperCase().equals( "SA" ) )   businessId = 8672;
         else throw new Exception( "Region.java -- invalid region specified - " + aRegion );

         texasWeddingsBusinessId = 8673;
         texasWeddingsGroup      = 4405;

         faceBook           = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessId, 147, 0);
         mySpace            = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessId, 148, 0);
         twitter            = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessId, 149, 0);
         pinterest          = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessId, 150, 0);

         name               = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessId, 139, 0);
         phone              = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessId, 144, 0);
         email              = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessId, 151, 0);
         mobileDomain       = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessId, 152, 0);
         virtualBookLink    = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessId, 133, 0);
         blog               = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessId, 153, 0);
         bridalExtravaganza = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessId, 154, 0);
         otherSite          = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessId, 157, 0);
         featuredVendorGroupId = new Integer(EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessId, 138, 0)).intValue();

         otherSiteURL       = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessId, 157, 1);

         siteSpecificAttributeSubId = Integer.parseInt( EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessId, 143, 0));
         group           = Integer.parseInt( EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessId, 137, 0));

         headerMag = new Image( dbData,
                             doc,
                             155, // attrDefId
                             0,
                             EntityAttribute.OWNERTYPE_PERSON,
                             businessId,
                             "",
                             "headerMag",
                             125,
                             190 );

         headerLogo= new Image( dbData,
                             doc,
                             156, // attrDefId
                             0,
                             EntityAttribute.OWNERTYPE_PERSON,
                             businessId,
                             "",
                             "headerLogo",
                             398,
                             91  );


         dbData.getLog().logEvent( "Region GroupId: " + group );
      }
      catch( Exception e)
      {
         System.out.println( e );
      }
   }


   public Element getElement()
   {
      Element regionElement = doc.createElement( "region" );
      regionElement.setAttribute("name", name);
      regionElement.setAttribute("phone", phone );
      regionElement.setAttribute("email", email );
      regionElement.setAttribute("mobiledomain", mobileDomain );
      regionElement.setAttribute("virtualbooklink", virtualBookLink );
      regionElement.setAttribute("bridalextravaganza", bridalExtravaganza );
      regionElement.setAttribute("blog", blog );
      regionElement.setAttribute("headermag", headerMag.getUrl() );
      regionElement.setAttribute("headerlogo", headerLogo.getUrl() );

      Element socialMediaElement = doc.createElement("socialmedia");
      regionElement.appendChild(socialMediaElement);

      socialMediaElement.setAttribute( "facebook" , faceBook );
      socialMediaElement.setAttribute( "twitter"  , twitter  );
      socialMediaElement.setAttribute( "myspace"  , mySpace  );
      socialMediaElement.setAttribute( "pinterest", pinterest);

      Element otherSiteElement = doc.createElement("othersite");
      regionElement.appendChild( otherSiteElement );
      otherSiteElement.setAttribute( "name" , otherSite );
      otherSiteElement.setAttribute( "url" , otherSiteURL );

      return( regionElement );
   }
}
