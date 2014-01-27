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

public class Testimonial extends TestimonialDBRecordBase
{
   private Document doc;

   private String testimonialText = "";


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Testimonial( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Testimonial( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Testimonial( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Testimonial( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Testimonial( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Testimonial( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public Testimonial( DBData aDbData, Document aDoc, int ndx, EntityAttribute testimonialAttr )
   {
      super( aDbData );
      doc = aDoc;

      testimonialText = testimonialAttr.getAttributeData();

   }

   public Element getElement()
   {
      Element testimonialElement = doc.createElement( "testimonial" );
      testimonialElement.appendChild( doc.createTextNode(testimonialText));

      return( testimonialElement );
   }
}
