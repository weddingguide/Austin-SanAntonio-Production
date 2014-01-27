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

public class CategoryList extends CategoryDBRecordListBase
{
   private Region region;
   private Document doc;

   public boolean categorySelected = false;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public CategoryList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public CategoryList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "CATEGORY", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public CategoryList( DBData dbData )
   {
      super( dbData );
   }

   public CategoryList( DBData aDbData, Document aDoc, Region aRegion, CategoryCtrl categoryCtrl )
   {
      super( aDbData );
      init( aDoc, aRegion, categoryCtrl );
   }

   // this constructor is for the vendor search dropdown list.  Just a summary of all of the vendor categories
   public CategoryList( DBData aDbData, Document aDoc, Region aRegion, CategoryCtrl categoryCtrl, boolean signatureFlag1 )
   {
      super( aDbData );
      region = aRegion;
      doc = aDoc;

      if (categoryCtrl.singleCategory > 0 ) categorySelected = true;

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      categoryCtrl.inclDetails = false;
      categoryCtrl.inclProfiles = false;

      EntityGroupList vendorTypes = new EntityGroupList( dbData, aRegion.getGroup(), "Vendor Category", Person.RECORDTYPE_BUSINESS_ORG, 1);
      for (int i=0; i<vendorTypes.getRecordList().length; i++ )
      {
          EntityGroup vendorType = (EntityGroup) vendorTypes.getRecordList()[i];
          Category category = new Category( dbData, doc, region, i, vendorType, categoryCtrl );
          add( category ); //add it to the list
      }
   }

   // this contstructor is for the 8-category sidebar on the home page.  8 random categories
   public CategoryList( DBData aDbData, Document aDoc, Region aRegion, CategoryCtrl categoryCtrl, boolean signatureFlag1, boolean signatureFlag2  )
   {
      super( aDbData );
      region = aRegion;
      doc = aDoc;

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      categoryCtrl.inclImage = true;
      categoryCtrl.inclDetails = false;
      categoryCtrl.inclProfiles = false;

      categoryCtrl.imageWidth = 125;
      categoryCtrl.imageHeight = 125;

      EntityGroupList vendorTypes = new EntityGroupList( dbData, aRegion.getGroup(), "Vendor Category", Person.RECORDTYPE_BUSINESS_ORG, 1, 8);
      for (int i=0; i<vendorTypes.getRecordList().length; i++ )
      {
          EntityGroup vendorType = (EntityGroup) vendorTypes.getRecordList()[i];
          Category category = new Category( dbData, doc, region, i, vendorType, categoryCtrl );
          add( category ); //add it to the list
      }
   }

   public void init( Document aDoc, Region aRegion, CategoryCtrl categoryCtrl )
   {
      region = aRegion;
      doc = aDoc;

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      if ( categoryCtrl.singleCategory != -1 ) // single category requested
      {
         EntityGroup categoryEG = new EntityGroup( dbData, categoryCtrl.singleCategory );
         Category category = new Category( dbData, doc, region, 0, categoryEG, categoryCtrl );
         add( category ); //add it to the list (always have a list.... even if one entry... simpler code
      }

      else if ( categoryCtrl.getProfileCtrl().singleProfile != -1 ) // single profile requested... figure out the categories associated with it
      {
         EntityGroupList vendorCategories = new EntityGroupList( dbData, "Vendor Category", categoryCtrl.getProfileCtrl().singleProfile );

         for (int i=0; i<vendorCategories.getRecordList().length; i++ )
         {
            if ( i == categoryCtrl.maxCategories ) break;
            EntityGroup vendorCategory = (EntityGroup) vendorCategories.getRecordList()[i];
            if ( vendorCategory.getAliasOf() == -1 ) // don't include alias group names (e.g. facilities )
            {
               Category category = new Category( dbData, doc, region, 0, vendorCategory, categoryCtrl );
               add( category ); //add it to the list (always have a list.... even if one entry... simpler code
            }
         }
      }

      else if ( categoryCtrl.singleCategory == -2 ) // special 'single category id' that means we are doing a search (a 'search returns a list that looks just like a profile list for a cateory and goes on the same page)
      {
         EntityGroup categoryEG = new EntityGroup( dbData, categoryCtrl.singleCategory );
         Category category = new Category( dbData, doc, region, 0, categoryEG, categoryCtrl );
         add( category ); //add it to the list (always have a list.... even if one entry... simpler code
      }
      else // all categories for region
      {
         EntityGroupList categories = new EntityGroupList( dbData, region.getGroup(), "Vendor Category", Person.RECORDTYPE_BUSINESS_ORG, 1);
         for (int i=0; i<categories.getRecordList().length; i++ )
         {
             // one category
             EntityGroup categoryEG = (EntityGroup) categories.getRecordList()[i];
             Category category = new Category( dbData, doc, region, i, categoryEG, categoryCtrl );
             add( category ); //add it to the list
         }
      }
   }

   public Element getElement(String tag )
   {
      Element categoryListElement = doc.createElement( tag );
      categoryListElement.setAttribute( "categoryselected", new Boolean( categorySelected ).toString() );

      for ( int i = 0; i < recordList.length; i++ )
      {
         Category category = (Category) recordList[i];
         categoryListElement.appendChild( category.getElement() );
      }
      return( categoryListElement );
   }
}
