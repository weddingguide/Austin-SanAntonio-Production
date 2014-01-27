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

public class TestimonialList extends TestimonialDBRecordListBase
{
   private Region region;
   private Document doc;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public TestimonialList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public TestimonialList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "TESTIMONIAL", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public TestimonialList( DBData dbData )
   {
      super( dbData );
   }


   // get testimonials for a single vendor
   public TestimonialList( DBData aDbData, Document aDoc, int ownerId )
   {
      super( aDbData );
      doc = aDoc;

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      EntityAttributeList testimonialAttrList =  new EntityAttributeList( dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 124, 0, true, true );
      for ( int i=0; i < testimonialAttrList.getRecordList().length; i++ )
      {
         EntityAttribute testimonialAttr = (EntityAttribute) testimonialAttrList.getRecordList()[i];
         Testimonial testimonial = new Testimonial( dbData, doc, i, testimonialAttr);
         add( testimonial ); //add it to the list
      }
   }

   public Element getElement()
   {
      Element testimonialListElement = doc.createElement( "testimonials" );
      for ( int i = 0; i < recordList.length; i++ )
      {
         Testimonial testimonial = (Testimonial) recordList[i];
         testimonialListElement.appendChild( testimonial.getElement() );
      }
      return( testimonialListElement );
   }
}
