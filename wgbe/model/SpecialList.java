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

public class SpecialList extends SpecialDBRecordListBase
{
   private Region region;
   private Document doc;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SpecialList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SpecialList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "SPECIAL", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SpecialList( DBData dbData )
   {
      super( dbData );
   }

   // get all specials for a region
   public SpecialList( DBData aDbData, Document aDoc, Region aRegion, WGBEDataAccessCtrl ctrl )
   {
      super( aDbData );
      region = aRegion;
      doc = aDoc;

      String suffix = " BGNDATE DESC";
      if (ctrl.randomizeSpecials ) suffix = " RAND() ";

      suffix += " LIMIT " + ctrl.specialsCount;

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      EntityAttributeList specialAttrList = new EntityAttributeList( dbData, 48, region.getGroup(), suffix ); // get primary attributes of "special" type for this region
      for ( int i=0; i < specialAttrList.getRecordList().length; i++ )
      {
         EntityAttribute specialAttr = (EntityAttribute) specialAttrList.getRecordList()[i];
         Special special = new Special( dbData, doc, i, specialAttr);
         add( special ); //add it to the list
      }
   }

   // get specials for a single vendor
   public SpecialList( DBData aDbData, Document aDoc, int ownerId )
   {
      super( aDbData );
      doc = aDoc;

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      EntityAttributeList specialAttrList =  new EntityAttributeList( dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 48, 0, true, true );
      for ( int i=0; i < specialAttrList.getRecordList().length; i++ )
      {
         EntityAttribute specialAttr = (EntityAttribute) specialAttrList.getRecordList()[i];
         Special special = new Special( dbData, doc, i, specialAttr);
         add( special ); //add it to the list
      }
   }

   public Element getElement()
   {
      Element specialListElement = doc.createElement( "specials" );
      for ( int i = 0; i < recordList.length; i++ )
      {
         Special special = (Special) recordList[i];
         if ( special.getVendorStatus() == Person.STATUS_ACTIVE )
         {
            specialListElement.appendChild( special.getElement() );
         }
      }
      return( specialListElement );
   }
}
