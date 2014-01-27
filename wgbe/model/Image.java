package jwm.wgbe.model;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.*;
import jwm.wgbe.model.db.*;
import jwm.wgbe.*;
import jwm.idmanager.*;
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

public class Image extends ImageDBRecordBase
{
   private Document doc;
   String imagePrefix = "";
   boolean scaleOnlyNoCrop = false;

   private String url = "";
   public  void   setUrl( String aUrl ) { url = aUrl; }
   public  String getUrl()       { return(url); }

   private String name = "";
   public  void   setName( String aName ) { name = aName; }
   public  String getName()      { return(name); }

   private int width = -1;
   public  void setWidth( int aWidth ) { width = aWidth; }
   public  int getWidth()  { return(width); }

   private int height = -1;
   public  void setHeight( int aHeight ) { height = aHeight; }
   public  int getHeight() { return(height); }


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Image( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Image( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Image( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Image( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Image( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Image( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public Image( DBData aDbData, Document aDoc, int attributeDefId, int ndx, int ownerType, int ownerId, String aPrefix, String subFolder, int aWidth, int aHeight )
   {
      super( aDbData );
      doc = aDoc;
      width = aWidth;
      height = aHeight;

      ImageCacheHandler imageCacheHandler = new ImageCacheHandler( dbData );

      EntityAttribute imageAttr = new EntityAttribute( dbData, ownerType, ownerId, attributeDefId, 0, ndx);
      name = imageAttr.getAttributeData();


      dbData.getLog().logEvent( "Image Name: " + name );
      url = imageCacheHandler.getCachedImageURL( imageAttr.getOwnerId(),
                                                  name,
                                                  aPrefix,
                                                  subFolder,
                                                  width,
                                                  height,
                                                  EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, imageAttr.getOwnerId(), imageAttr.getAttributeDefId(), 10, imageAttr.getNdx()).equals( "checked"));
   }

   public Element getElement()
   {
      Element imageElement = doc.createElement( "image" );
      imageElement.setAttribute( "url", url );
      imageElement.setAttribute( "width",  new Integer(width).toString() );
      imageElement.setAttribute( "height", new Integer(height).toString() );
      return( imageElement );
   }
}
