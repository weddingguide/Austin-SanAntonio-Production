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

public class EventList extends EventDBRecordListBase
{
   private Region region;
   private Document doc;


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EventList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EventList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "EVENT", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EventList( DBData dbData )
   {
      super( dbData );
   }

   // get all events for a region
   public EventList( DBData aDbData, Document aDoc, Region aRegion, WGBEDataAccessCtrl ctrl )
   {
      super( aDbData );
      region = aRegion;
      doc = aDoc;

      String suffix = " BGNDATE DESC";
      if (ctrl.randomizeEvents ) suffix = " RAND() ";

      suffix += " LIMIT " + ctrl.eventsCount;

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      EntityAttributeList eventAttrList = new EntityAttributeList( dbData, 49, region.getGroup(), suffix ); // get primary attributes of "events" type for this region
      for ( int i=0; i < eventAttrList.getRecordList().length; i++ )
      {
         EntityAttribute eventAttr = (EntityAttribute) eventAttrList.getRecordList()[i];
         Event event = new Event( dbData, doc, i, eventAttr);
         add( event ); //add it to the list
      }
   }

   // get events for a single vendor
   public EventList( DBData aDbData, Document aDoc, int ownerId )
   {
      super( aDbData );
      doc = aDoc;


      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      EntityAttributeList eventAttrList =  new EntityAttributeList( dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 49, 0, true, true );
      for ( int i=0; i < eventAttrList.getRecordList().length; i++ )
      {
         EntityAttribute eventAttr = (EntityAttribute) eventAttrList.getRecordList()[i];
         Event event = new Event( dbData, doc, i, eventAttr);
         add( event ); //add it to the list
      }
   }

   public Element getElement()
   {
      Element eventListElement = doc.createElement( "events" );
      for ( int i = 0; i < recordList.length; i++ )
      {
         Event event = (Event) recordList[i];
         if ( event.getVendorStatus() == Person.STATUS_ACTIVE )
         {
            eventListElement.appendChild( event.getElement() );
         }
      }
      return( eventListElement );
   }
}
