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


public class Category extends CategoryDBRecordBase
{
   private Region region;
   private Document doc;

   private CategoryCtrl categoryCtrl = null;

   private Hashtable detailsNames = null;
   public  void      setDetailsNames( Hashtable aDetailsNames ) { detailsNames = aDetailsNames; }
   public  Hashtable getDetailsNames() { return(detailsNames); }

   private ProfileList profileList = null;
   public  void        setProfileList( ProfileList aProfileList ) { profileList = aProfileList; }
   public  ProfileList getProfileList()    { return(profileList); }

   private ProfileList spotlightProfileList = null;
   public  void        setSpotlightProfileList( ProfileList aSpotlightProfileList ) { spotlightProfileList = aSpotlightProfileList; }
   public  ProfileList getSpotlightProfileList() { return(spotlightProfileList); }

   private String description = "";
   public  void   setDescription( String aDescription ) { description = aDescription; }
   public  String getDescription() { return(description); }

   private int id = -1;
   public  void setId( int aId ) { id = aId; }
   public  int getId()     { return(id); }

   public boolean selected = false;
   public boolean search   = false;

   public boolean detailsIncluded = false;

   //added 11/14/13 for portal page based on portal page request
   public String thumbnails = "";
   public String icon = "";
   public String usePortalPage = "false";
   //end 11-14-13



   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Category( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Category( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Category( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Category( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Category( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Category( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public Category( DBData aDbData, Document aDoc, Region aRegion, int ndx, EntityGroup aCategoryEG, CategoryCtrl aCategoryCtrl )
   {
      super( aDbData );
      region = aRegion;
      doc = aDoc;
      categoryCtrl = aCategoryCtrl;

      selected = false;
      selectedText = "";
      if ( aCategoryEG.getId() == aCategoryCtrl.singleCategory )
      {
         selected = true;
         selectedText = "selected";
      }

      name = aCategoryEG.getName();
      id = aCategoryEG.getId();

      if ( id == 0 ) search = true;

      keywords = EntityAttributeList.getAttributeValue(dbData, 6, id, 101, 0);

      //added 11/14/13 for portal page based on portal page request

      thumbnails = EntityAttributeList.getAttributeValue(dbData, 6, id, 121, 0);
      icon       = EntityAttributeList.getAttributeValue(dbData, 6, id, 122, 0);

      if ( EntityAttributeList.getAttributeValue(dbData, 6, id, 164, 0).equals( "checked" )) usePortalPage = "true";

      // end 11-14-13


      if (categoryCtrl.inclDetails)
      {
         detailsNames = new Hashtable();

         EntityAttributeDefList attributeDefList = new EntityAttributeDefList(dbData, "OWNERTYPE = " + EntityAttributeDef.OWNERTYPE_GROUP + " AND OWNERID = " + aCategoryEG.getGroupNum() + " AND SUBID=0", "SORTWEIGHT ASC");

         for (int k=0; k< attributeDefList.getRecordList().length; k++ )
         {
            detailsIncluded = true;
            EntityAttributeDef attributeDef = (EntityAttributeDef) attributeDefList.getRecordList()[k];
            detailsNames.put(  attributeDef.getName(), attributeDef.getPrompt() );
         }

      }

      if (categoryCtrl.inclDescription)
      {
         description =  EntityAttributeList.getAttributeValue(dbData, 6, id, 123, region.getSiteSpecificAttributeSubId() );

         if (description.equals(""))
         {
              description = EntityAttributeList.getAttributeValue(dbData, 6, id, 123, 0);
         }
      }

      if (categoryCtrl.inclImage)
      {
         ImageCacheHandler imageCacheHandler = new ImageCacheHandler( dbData );
         String imageFileName = aCategoryEG.getName().replace( '&', '_' ).replace( ':', '_' )+".jpg";
         imageTag =imageCacheHandler.cachedImageTag( 0,
                                                              imageFileName,
                                                              "",
                                                              "Vendor Categories",
                                                              categoryCtrl.imageWidth,
                                                              categoryCtrl.imageHeight,
                                                              "",
                                                              false );
      }

      url = "/"+WGBEUtils.getURLCompliantCategoryName(dbData, aCategoryEG.getGroupNum());

      if (categoryCtrl.inclProfiles )
      {
         dbData.getLog().logEvent( "....Getting profile list for category" );
         profileList = new ProfileList( dbData, doc, region, categoryCtrl.getProfileCtrl(), id);
      }

      if (categoryCtrl.inclSpotlightProfiles )
      {
         dbData.getLog().logEvent( "....Getting spotlight profile list for category" );
         spotlightProfileList = new ProfileList( dbData, doc, region, categoryCtrl.getSpotlightProfileCtrl(), id, true);
      }
   }

   public Element getElement()
   {
      Element categoryElement = doc.createElement( "category" );
      categoryElement.setAttribute( "id", new Integer( id ).toString() );
      categoryElement.setAttribute( "selected", new Boolean( selected ).toString() );
      categoryElement.setAttribute( "selectedtext", selectedText );
      categoryElement.setAttribute( "search", new Boolean( search ).toString() ); // means the category is not a 'real' category, rather being used as a container for search results
      categoryElement.setAttribute( "detailsIncluded", new Boolean( detailsIncluded ).toString() );

      //added 11/14/13 for portal page based on portal page request
      categoryElement.setAttribute( "usePortalPage", usePortalPage );

      Element thumbnailsElement = doc.createElement( "thumbnails" );
      thumbnailsElement.appendChild( doc.createCDATASection(thumbnails));
      categoryElement.appendChild( thumbnailsElement );

      Element iconElement = doc.createElement( "icon" );
      iconElement.appendChild( doc.createCDATASection(icon));
      categoryElement.appendChild( iconElement );
      //end 11-14-13


      Element categoryNamesElement = doc.createElement( "categorynames" );
      categoryElement.appendChild( categoryNamesElement );
      Element categoryNameElement = doc.createElement( "categoryname" );
      categoryNamesElement.appendChild( categoryNameElement );
      categoryNameElement.setAttribute( "name",name );

      Element keywordsElement = doc.createElement( "keywords" );
      categoryElement.appendChild( keywordsElement );

      if (categoryCtrl.inclDescription)
      {
         Element descriptionElement = doc.createElement( "description" );
         descriptionElement.appendChild( doc.createCDATASection(description));
         categoryElement.appendChild( descriptionElement );
      }

      if (categoryCtrl.inclImage)
      {
         Element imageElement = doc.createElement("imagetag");
         imageElement.appendChild(doc.createCDATASection(imageTag));
         categoryElement.appendChild(imageElement);
      }
      categoryElement.setAttribute( "url", url );

      dbData.getLog().logEvent( "Category.getElement() --> inclDetails? " + categoryCtrl.inclDetails );
      if (categoryCtrl.inclDetails)
      {
         Element detailsNamesElement = doc.createElement( "detailsnames" );
         categoryElement.appendChild( detailsNamesElement );

         for (Enumeration enum1 = detailsNames.keys(); enum1.hasMoreElements();)
         {
            String detailsName = (String) enum1.nextElement();
            String detailsNameText = (String) detailsNames.get( detailsName );

            Element detailsNameElement = doc.createElement( "detailsname" );
            detailsNamesElement.appendChild( detailsNameElement );
            detailsNameElement.setAttribute( "name", detailsName );
            detailsNameElement.setAttribute( "text", detailsNameText );

         }
      }
      if (categoryCtrl.inclSpotlightProfiles )  categoryElement.appendChild( spotlightProfileList.getElement("spotlightProfiles") );

      if (categoryCtrl.inclProfiles )  categoryElement.appendChild( profileList.getElement("profiles") );


      return( categoryElement );
   }
}
