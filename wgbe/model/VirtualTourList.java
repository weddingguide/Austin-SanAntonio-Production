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

public class VirtualTourList extends VirtualTourDBRecordListBase
{
   private Region region;
   private Document doc;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public VirtualTourList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public VirtualTourList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "VIRTUALTOUR", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public VirtualTourList( DBData dbData )
   {
      super( dbData );
   }


   // get virtualTours for a single vendor
   public VirtualTourList( DBData aDbData, Document aDoc, int ownerId )
   {
      super( aDbData );
      doc = aDoc;

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      dbData.getLog().logEvent( "Virtual Tours for a single vendor" );
      EntityAttributeList virtualTourAttrList =  new EntityAttributeList( dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 9, 0 );
      for ( int i=0; i < virtualTourAttrList.getRecordList().length; i++ )
      {
         EntityAttribute virtualTourAttr = (EntityAttribute) virtualTourAttrList.getRecordList()[i];
         VirtualTour virtualTour = new VirtualTour( dbData, doc, i, virtualTourAttr);
         add( virtualTour ); //add it to the list
      }
   }

   public Element getElement()
   {
      Element virtualTourListElement = doc.createElement( "virtualTours" );
      for ( int i = 0; i < recordList.length; i++ )
      {
         VirtualTour virtualTour = (VirtualTour) recordList[i];
         virtualTourListElement.appendChild( virtualTour.getElement() );
      }
      return( virtualTourListElement );
   }
}
