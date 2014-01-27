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


public class ImageList extends ImageDBRecordListBase
{
   private Document doc;

   private String profileLayout = "";
   public  void   setProfileLayout( String aProfileLayout ) { profileLayout = aProfileLayout; }
   public  String getProfileLayout() { return(profileLayout); }

   private String cacheFolderSuffix = "";
   public  void   setCacheFolderSuffix( String aCacheFolderSuffix ) { cacheFolderSuffix = aCacheFolderSuffix; }
   public  String getCacheFolderSuffix() { return(cacheFolderSuffix); }

   private int ownerId = -1;
   private int layoutsArrayOffset = -1;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ImageList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ImageList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "IMAGE", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ImageList( DBData dbData )
   {
      super( dbData );
   }

   public ImageList( DBData aDbData, Document aDoc, int aOwnerId )
   {
      super( aDbData );
      doc = aDoc;
      ownerId = aOwnerId;

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      String[][][] layouts = getLayouts();

      layoutsArrayOffset = 0;
      cacheFolderSuffix = "";

      int pictureCount = getPictureCount(ownerId);

      for (int i = 0; i <  pictureCount; i++ )
      {
         Image image = new Image( dbData,
                                  doc,
                                  7,  // attrDefId
                                  i,
                                  EntityAttribute.OWNERTYPE_PERSON,
                                  ownerId,
                                  i+"_",
                                  profileLayout+cacheFolderSuffix,
                                  new Integer(layouts[ layoutsArrayOffset + pictureCount-1 ][ i ][ 1 ]).intValue(),
                                  new Integer(layouts[ layoutsArrayOffset + pictureCount-1 ][ i ][ 2 ]).intValue() );
         add( image ); //add it to the list
      }
   }

   public Element getElement()
   {
      Element imageListElement = doc.createElement( "images" );
      imageListElement.setAttribute( "layout", profileLayout );
      for ( int i = 0; i < recordList.length; i++ )
      {
         Image image = (Image) recordList[i];
         imageListElement.appendChild( image.getElement() );
      }
      return( imageListElement );
   }

   private String[][][] getLayouts()
   {
      String[][][] layouts = {
         {
         { "a", "540", "570"}
         },
         {
         { "a", "540", "284"},
         { "b", "540", "284"}
         },
         {
         { "a", "540", "284"},
         { "b", "269", "284"},
         { "c", "269", "284"}
         },
         {
         { "a", "269", "284"},
         { "b", "269", "284"},
         { "c", "269", "284"},
         { "d", "269", "284"}
         },
         {
         { "a", "269", "284"},
         { "b", "269", "284"},
         { "c", "178", "284"},
         { "d", "180", "284"},
         { "e", "178", "284"}
         },
         {
         { "a", "269", "188"},
         { "b", "269", "188"},
         { "c", "269", "190"},
         { "d", "269", "190"},
         { "e", "269", "188"},
         { "f", "269", "188"}
         },
         {
         { "a", "269", "188"},
         { "b", "269", "188"},
         { "c", "178", "190"},
         { "d", "180", "190"},
         { "e", "178", "190"},
         { "f", "269", "188"},
         { "g", "269", "188"}
         },
         {
         { "a", "178", "188"},
         { "b", "180", "188"},
         { "c", "178", "188"},
         { "d", "269", "190"},
         { "e", "269", "190"},
         { "f", "178", "188"},
         { "g", "180", "188"},
         { "h", "178", "188"}
         },
         {
         { "a", "178", "188"},
         { "b", "180", "188"},
         { "c", "178", "188"},
         { "d", "178", "190"},
         { "e", "180", "190"},
         { "f", "178", "188"},
         { "g", "178", "188"},
         { "h", "180", "188"},
         { "i", "178", "188"}
         },
         {
         { "a", "178", "141"},
         { "b", "180", "141"},
         { "c", "178", "141"},
         { "d", "269", "141"},
         { "e", "269", "141"},
         { "f", "178", "141"},
         { "g", "180", "141"},
         { "h", "178", "141"},
         { "i", "269", "141"},
         { "j", "269", "141"}
         },
         {
         { "a", "540", "810"}
         },
         {
         { "a", "540", "404"},
         { "b", "540", "404"}
         },
         {
         { "a", "540", "404"},
         { "b", "269", "404"},
         { "c", "269", "404"}
         },
         {
         { "a", "269", "404"},
         { "b", "269", "404"},
         { "c", "269", "404"},
         { "d", "269", "404"}
         },
         {
         { "a", "269", "404"},
         { "b", "269", "404"},
         { "c", "178", "404"},
         { "d", "180", "404"},
         { "e", "178", "404"}
         },
         {
         { "a", "269", "188"},
         { "b", "269", "188"},
         { "c", "269", "430"},
         { "d", "269", "430"},
         { "e", "269", "188"},
         { "f", "269", "188"}
         },
         {
         { "a", "269", "188"},
         { "b", "269", "188"},
         { "c", "178", "190"},
         { "d", "180", "190"},
         { "e", "178", "190"},
         { "f", "269", "428"},
         { "g", "269", "428"}
         },
         {
         { "a", "178", "188"},
         { "b", "180", "188"},
         { "c", "178", "188"},
         { "d", "269", "430"},
         { "e", "269", "430"},
         { "f", "178", "188"},
         { "g", "180", "188"},
         { "h", "178", "188"}
         },
         {
         { "a", "178", "268"},
         { "b", "180", "268"},
         { "c", "178", "268"},
         { "d", "178", "270"},
         { "e", "180", "270"},
         { "f", "178", "270"},
         { "g", "178", "268"},
         { "h", "180", "268"},
         { "i", "178", "268"}
         },
         {
         { "a", "178", "250"},
         { "b", "180", "250"},
         { "c", "178", "250"},
         { "d", "269", "152"},
         { "e", "269", "152"},
         { "f", "178", "250"},
         { "g", "180", "250"},
         { "h", "178", "250"},
         { "i", "269", "152"},
         { "j", "269", "152"}
         }
      };
      return( layouts );
   }

   private int getPictureCount(int ownerId)
   {
      profileLayout = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 42, 0);
      if (profileLayout.indexOf("t") > 0 )
      {
         cacheFolderSuffix = "t";
         layoutsArrayOffset = 10;
         profileLayout = profileLayout.substring( 0, profileLayout.length()-1);
      }
      String[] parts = profileLayout.split("-");
      try
      {
         return( new Integer( parts[1] ).intValue() );
      }
      catch (Exception e)
      {
         return(1);
      }
   }
}
