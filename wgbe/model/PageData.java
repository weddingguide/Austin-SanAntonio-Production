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

public class PageData extends PageDataDBRecordBase
{
   private Document doc;
   private WGBEDataAccessCtrl ctrl;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PageData( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PageData( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PageData( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PageData( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PageData( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PageData( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public PageData( DBData aDbData, Document aDoc, Region aRegion, WGBEDataAccessCtrl aCtrl )
   {
      super( aDbData );

      doc = aDoc;
      ctrl = aCtrl;

      cssName = "style";
      if ( aCtrl.popupPageFlag ) cssName = "popup";

      googleVerify    = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, aRegion.getBusinessId(), 145, 0);
      bingVerify      = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, aRegion.getBusinessId(), 146, 0);

      googleAnalytics = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, aRegion.getBusinessId(), 141, 0);


      keywords = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, aRegion.getBusinessId(), 119, 0);
      if (keywords.equals(""))
      {
         keywords = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, aRegion.getTexasWeddingsBusinessId(), 119, 0);
      }

      pageDescription = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, aRegion.getBusinessId(), 125, 0);
      if (pageDescription.equals(""))
      {
         pageDescription =  EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, aRegion.getTexasWeddingsBusinessId(), 6, 0);
      }

      if( EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, aRegion.getBusinessId(), 51, 1).equals( "checked" ))
      {
        homePageFeaturedSliderInt = "0";
      }
      else {
        homePageFeaturedSliderInt = "15000";
      }
   }


   public Element getElement()
   {
      Element pageDataElement = doc.createElement( "pagedata" );

      pageDataElement.setAttribute("googleanalytics", googleAnalytics );
      pageDataElement.setAttribute("cssname", cssName );
      pageDataElement.setAttribute("homepagefeaturedsliderint", homePageFeaturedSliderInt );

      Element googleVerifyElement = doc.createElement("googleverify");
      googleVerifyElement.appendChild(doc.createCDATASection(googleVerify));
      pageDataElement.appendChild(googleVerifyElement);

      Element bingVerifyElement = doc.createElement("bingverify");
      bingVerifyElement.appendChild(doc.createCDATASection(bingVerify));
      pageDataElement.appendChild(bingVerifyElement);

      Element currPageURLElement = doc.createElement("currPageURL");
      currPageURLElement.appendChild(doc.createCDATASection(ctrl.currPageURL));
      pageDataElement.appendChild(currPageURLElement);

      Element baseURLQueryStringElement = doc.createElement("baseURLQueryString");
      baseURLQueryStringElement.appendChild(doc.createCDATASection(ctrl.baseURLQueryString));
      pageDataElement.appendChild(baseURLQueryStringElement);

      Element keywordsElement = doc.createElement("keywords");
      keywordsElement.appendChild(doc.createTextNode(keywords));
      pageDataElement.appendChild(keywordsElement);

      Element pageDescriptionElement = doc.createElement("pagedescription");
      pageDescriptionElement.appendChild(doc.createTextNode(pageDescription));
      pageDataElement.appendChild(pageDescriptionElement);

      if ( ctrl.inclContactFormData ) pageDataElement.appendChild( ctrl.contactFormData.getElement( doc ) );

      return( pageDataElement );
   }
}
