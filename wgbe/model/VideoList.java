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


public class VideoList extends VideoDBRecordListBase
{
   private Region region;
   private Document doc;


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public VideoList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public VideoList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "VIDEO", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public VideoList( DBData dbData )
   {
      super( dbData );
   }

   public VideoList( DBData aDbData, Document aDoc, int ownerId )
   {
      super( aDbData );
      doc = aDoc;

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      EntityAttributeList videoAttrList = new EntityAttributeList( dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 10, 0);
      for ( int i=0; i < videoAttrList.getRecordList().length; i++ )
      {
         EntityAttribute videoAttr = (EntityAttribute) videoAttrList.getRecordList()[i];
         Video video = new Video( dbData, doc, i, videoAttr);
         add( video ); //add it to the list
      }
   }

   public Element getElement()
   {
      Element videoListElement = doc.createElement( "videoclips" );
      for ( int i = 0; i < recordList.length; i++ )
      {
         Video video = (Video) recordList[i];
         videoListElement.appendChild( video.getElement() );
      }
      return( videoListElement );
   }
}
