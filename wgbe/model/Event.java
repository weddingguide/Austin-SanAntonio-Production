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

public class Event extends EventDBRecordBase
{
   private Document doc;

   private  EntityGroupList vCategories = null;
   private  String          primaryvCategoryName = "";
   private  String          phone = "";
   private  int             ownerId = 0;
   private  String          category = "";
   private  String          ownerName = "";
   private  String          name  = "";
   private  String          title = "";
   private  java.sql.Date   start = null;
   private  java.sql.Date   end     = null;
   private  String          imageURL = "";
   private  String          eventURL = "";
   private  String          eventPhone = "";
   private  String          description = "";
   private  String          eventImageFile = "";
   private  boolean         imageCacheScaleOnlyFlag = false;
   private  String[]        images;

   private  int             vendorStatus = -1;
   public  void             setVendorStatus( int aVendorStatus ) { vendorStatus = aVendorStatus; }
   public  int              getVendorStatus()        { return(vendorStatus); }


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Event( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Event( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Event( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Event( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Event( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Event( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public Event( DBData aDbData, Document aDoc, int ndx, EntityAttribute eventAttr )
   {
      super( aDbData );
      doc = aDoc;

      ImageCacheHandler imageCacheHandler = new ImageCacheHandler( dbData );

      EntityAttribute eventImage = new EntityAttribute( dbData, eventAttr.getOwnerType(), eventAttr.getOwnerId(), 49, 1, eventAttr.getNdx() );
      eventImageFile = eventImage.getAttributeData();
      imageCacheScaleOnlyFlag = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, eventAttr.getOwnerId(), 44, 10).equals( "checked");

      // if no image defined for event, use thumbnail attribute
      if (eventImageFile.equals(""))
      {
         eventImageFile = EntityAttributeList.getAttributeValue(dbData, eventAttr.getOwnerType(), eventAttr.getOwnerId(), 44, 0);
         imageCacheScaleOnlyFlag = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, eventAttr.getOwnerId(), 44, 10).equals( "checked");
      }

      images=EntityAttributeList.getAttributeValues(dbData, eventAttr.getOwnerType(), eventAttr.getOwnerId(), 7, 0);

      // now if thumbnail also not defined, use first profile image if exists
      if (  ( eventImageFile.equals( "" ))
            &&
            ( images.length > 0 )) eventImageFile = images[0];

      imageURL = imageCacheHandler.getCachedImageURL( eventAttr.getOwnerId(),
                                                      eventImageFile,
                                                      "",
                                                      "event",
                                                      150,
                                                      150,
                                                      false);


      vCategories = new EntityGroupList( dbData, "Vendor Category", eventAttr.getOwnerId() );

      if ( vCategories.getRecordList().length > 0 )
      {
         EntityGroup primaryvCategory = (EntityGroup) vCategories.getRecordList()[0];
         primaryvCategoryName = primaryvCategory.getName();
      }

      phone = EntityAttributeList.getAttributeValue(dbData, eventAttr.getOwnerType(), eventAttr.getOwnerId(), 3, 0);
      ownerId = eventAttr.getOwnerId();
      ownerName = EntityAttributeList.getAttributeValue(dbData, eventAttr.getOwnerType(), eventAttr.getOwnerId(), 1, 0 );
      title = EntityAttributeList.getAttributeValue(dbData, eventAttr.getOwnerType(), eventAttr.getOwnerId(), 49, 2, eventAttr.getNdx() );
      start = eventAttr.getBgnDate();
      end     = eventAttr.getEndDate();
      description = EntityAttributeList.getAttributeValue(dbData, eventAttr.getOwnerType(), eventAttr.getOwnerId(), 49, 0, eventAttr.getNdx() );

      name = EntityAttributeList.getAttributeValue(dbData, eventAttr.getOwnerType(), eventAttr.getOwnerId(), 49, 12, eventAttr.getNdx() );
      if ( name.equals("")) name = EntityAttributeList.getAttributeValue(dbData, eventAttr.getOwnerType(), eventAttr.getOwnerId(), 1, 0 );

      Person vendor = new Person( dbData, eventAttr.getOwnerId() );
      vendorStatus = vendor.getStatus();

      eventURL = EntityAttributeList.getAttributeValue(dbData, eventAttr.getOwnerType(), eventAttr.getOwnerId(), 49, 11, eventAttr.getNdx() );
      if ( eventURL.equals("")) eventURL = "/profile_events.jsp?businessEntityId="+eventAttr.getOwnerId();

      eventPhone = EntityAttributeList.getAttributeValue(dbData, eventAttr.getOwnerType(), eventAttr.getOwnerId(), 49, 13, eventAttr.getNdx() );
      if ( eventPhone.equals("")) eventPhone = EntityAttributeList.getAttributeValue(dbData, eventAttr.getOwnerType(), eventAttr.getOwnerId(), 3, 0 );
   }

   public Element getElement()
   {
      SimpleDateFormat formatter = new SimpleDateFormat ("MM-dd-yy");
      Element eventElement = doc.createElement( "event" );
      eventElement.setAttribute( "phone", phone );
      eventElement.setAttribute( "ownerId", new Integer(ownerId).toString() );
      eventElement.setAttribute( "category",primaryvCategoryName);
      eventElement.setAttribute( "ownerName", ownerName );
      eventElement.setAttribute( "title", title );
      eventElement.setAttribute( "name", name );
      eventElement.setAttribute( "start", formatter.format(start));
      eventElement.setAttribute( "end",formatter.format(end));
      eventElement.setAttribute( "imageURL",imageURL);
      eventElement.setAttribute( "eventURL",eventURL);
      eventElement.setAttribute( "eventPhone",eventPhone);

      Element descrElement = doc.createElement("description");
      eventElement.appendChild(doc.createCDATASection(description));

      return( eventElement );
   }
}
