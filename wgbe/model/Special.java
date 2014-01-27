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

public class Special extends SpecialDBRecordBase
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
   private  String          specialImageFile = "";
   private  boolean         imageCacheScaleOnlyFlag = false;
   private  String[]        images;

   private  int             vendorStatus = -1;
   public  void             setVendorStatus( int aVendorStatus ) { vendorStatus = aVendorStatus; }
   public  int              getVendorStatus()        { return(vendorStatus); }

   private String           url = "";

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Special( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Special( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Special( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Special( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Special( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Special( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public Special( DBData aDbData, Document aDoc, int ndx, EntityAttribute specialAttr )
   {
      super( aDbData );
      doc = aDoc;

      ImageCacheHandler imageCacheHandler = new ImageCacheHandler( dbData );

      EntityAttribute specialImage = new EntityAttribute( dbData, specialAttr.getOwnerType(), specialAttr.getOwnerId(), 48, 1, ndx);
      specialImageFile = specialImage.getAttributeData();
      imageCacheScaleOnlyFlag = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, specialAttr.getOwnerId(), 48, 10).equals( "checked");

      // if no image defined for special, use thumbnail attribute
      if (specialImageFile.equals(""))
      {
         specialImageFile = EntityAttributeList.getAttributeValue(dbData, specialAttr.getOwnerType(), specialAttr.getOwnerId(), 44, 0);
         imageCacheScaleOnlyFlag = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, specialAttr.getOwnerId(), 44, 10).equals( "checked");
      }

      images=EntityAttributeList.getAttributeValues(dbData, specialAttr.getOwnerType(), specialAttr.getOwnerId(), 7, 0);

      // now if thumbnail also not defined, use first profile image if exists
      if (  ( specialImageFile.equals( "" ))
            &&
            ( images.length > 0 )) specialImageFile = images[0];

      imageURL = imageCacheHandler.getCachedImageURL( specialAttr.getOwnerId(),
                                                      specialImageFile,
                                                      "",
                                                      "special",
                                                      150,
                                                      150,
                                                      false);


      vCategories = new EntityGroupList( dbData, "Vendor Category", specialAttr.getOwnerId() );

      if ( vCategories.getRecordList().length > 0 )
      {
         EntityGroup primaryvCategory = (EntityGroup) vCategories.getRecordList()[0];
         primaryvCategoryName = primaryvCategory.getName();
      }

      phone = EntityAttributeList.getAttributeValue(dbData, specialAttr.getOwnerType(), specialAttr.getOwnerId(), 3, 0);
      ownerId = specialAttr.getOwnerId();
      ownerName = EntityAttributeList.getAttributeValue(dbData, specialAttr.getOwnerType(), specialAttr.getOwnerId(), 1, 0 );
      title = EntityAttributeList.getAttributeValue(dbData, specialAttr.getOwnerType(), specialAttr.getOwnerId(), 48, 2, 0 );
      start = specialAttr.getBgnDate();
      expires = specialAttr.getEndDate();
      description = EntityAttributeList.getAttributeValue(dbData, specialAttr.getOwnerType(), specialAttr.getOwnerId(), 48, 0, specialAttr.getNdx() );

      Person vendor = new Person( dbData, specialAttr.getOwnerId() );
      vendorStatus = vendor.getStatus();

      url = WGBEUtils.getURLCompliantVendorName(dbData, vendor.getPersonId());
   }

   public Element getElement()
   {
      SimpleDateFormat formatter = new SimpleDateFormat ("MM-dd-yy");
      Element specialElement = doc.createElement( "special" );
      specialElement.setAttribute( "phone", phone );
      specialElement.setAttribute( "ownerId", new Integer(ownerId).toString() );
      specialElement.setAttribute( "category",primaryvCategoryName);
      specialElement.setAttribute( "ownerName", ownerName );
      specialElement.setAttribute( "title", title );
      specialElement.setAttribute( "start", formatter.format(start));
      specialElement.setAttribute( "expires",formatter.format(expires));
      specialElement.setAttribute( "imageURL",imageURL);

      specialElement.setAttribute( "profileURL" , url );

      Element descrElement = doc.createElement("description");
      specialElement.appendChild(doc.createCDATASection(description));

      return( specialElement );
   }
}
