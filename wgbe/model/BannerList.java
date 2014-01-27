package jwm.wgbe.model;

import jwm.db.*;
import jwm.wgbe.model.db.*;
import jwm.logger.*;
import jwm.entity.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;

public class BannerList extends BannerDBRecordListBase
{
   private Region region;
   private Document doc;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BannerList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BannerList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "BANNER", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BannerList( DBData dbData )
   {
      super( dbData );
   }

   public BannerList( DBData aDbData, Document aDoc, Region aRegion, WGBEDataAccessCtrl ctrl )
   {
      super( aDbData );
      region = aRegion;
      doc = aDoc;

      dbData.getLog().logEvent( "------ Banner List -----" );
      String vendorIds = "";

      // get banners for specified category... if single category not specified for this page, id will be -1 and nothing should be found, which is correct

      PersonList aVendorList = new PersonList( dbData, EntityGroup.TYPE_GENERAL, aRegion.getGroup(), ctrl.getCategoryCtrl().singleCategory, 1, Person.RECORDTYPE_BUSINESS_ORG, false ); // just set up query... this constructor will not execute it
      aVendorList.doQuery( 0, 9999 ); // get all vendors in this category
      for ( int i = 0; i < aVendorList.getRecordList().length; i++ )
      {
         vendorIds += ((Person) aVendorList.getRecordList()[i]).getPersonId() + ", ";
      }

      dbData.getLog().logEvent( "------ Banner List (Banner Attributes) -----" );
      EntityAttributeList rotateBannerList =  new EntityAttributeList( dbData, 60, aRegion.getGroup(), vendorIds + "-1", 999 ); // get banner list again, this time, get all in category

      int stillNeeded = 0;
      if ( rotateBannerList.getRecordList().length == 0 ) stillNeeded=999; // no category banners, do full rotation of wgbe
      if ( rotateBannerList.getRecordList().length == 1 ) stillNeeded=1; // just need one filler
      if ( rotateBannerList.getRecordList().length > 1 ) stillNeeded=0; // enough category banners, don't fill with wgbe

      if ( stillNeeded > 0 )
      {
         vendorIds = aRegion.getBusinessId() + ", " + aRegion.getTexasWeddingsBusinessId();
         EntityAttributeList wgbeBannerList =  new EntityAttributeList( dbData, 60, aRegion.getGroup(), vendorIds, stillNeeded );
         rotateBannerList.merge( wgbeBannerList ); // not enough for vendor rotation.  Add in wgbe banners.
      }

      // we now should have the list of rotation banners set with 0, 1, or 2 wgbe banners added in to fill out if not enough category banners

      for (int i = 0; i < rotateBannerList.getRecordList().length; i++ )
      {
         EntityAttribute bannerAttr = (EntityAttribute) rotateBannerList.getRecordList()[i];
         if ( !bannerAttr.getAttributeData().trim().equals("") )
         {
            Banner banner = new Banner( dbData, doc, i, bannerAttr );
            add( banner ); //add it to the list
         }
      }
   }

   public Element getElement()
   {
      Element bannerListElement = doc.createElement( "banners" );
      bannerListElement.setAttribute( "count", new Integer( recordList.length).toString());
      for ( int i = 0; i < recordList.length; i++ )
      {
         Banner banner = (Banner) recordList[i];
         bannerListElement.appendChild( banner.getElement() );
      }
      return( bannerListElement );
   }
}
