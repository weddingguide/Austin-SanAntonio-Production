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

public class MobileMoreList extends MobileMoreDBRecordListBase
{
   private Region region;
   private Document doc;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MobileMoreList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MobileMoreList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "MOBILEMORE", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MobileMoreList( DBData dbData )
   {
      super( dbData );
   }

   public MobileMoreList( DBData aDbData, Document aDoc, Region aRegion )
   {
      super( aDbData );
      region = aRegion;
      doc = aDoc;

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      String mobileMorePageText[] = EntityAttributeList.getAttributeValues(dbData, EntityAttribute.OWNERTYPE_PERSON, region.getBusinessId(), 136, 0);
      for ( int k = 0; k < mobileMorePageText.length; k++ )
      {
         MobileMore mobileMore = new MobileMore( dbData, doc, region, k, mobileMorePageText[k]);
         add( mobileMore ); //add it to the list
      }
   }

   public Element getElement()
   {
      Element mobileMoreListElement = doc.createElement( "mobilemorelist" );
      for ( int i = 0; i < recordList.length; i++ )
      {
         MobileMore mobileMore = (MobileMore) recordList[i];
         mobileMoreListElement.appendChild( mobileMore.getElement() );
      }
      return( mobileMoreListElement );
   }
}
