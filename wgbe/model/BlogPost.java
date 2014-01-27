package jwm.wgbe.model;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.*;
import jwm.wgbe.model.db.*;
import jwm.wgbe.*;
import jwm.logger.*;
import jwm.common.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;

public class BlogPost extends BlogPostDBRecordBase
{
   private Document doc;

   private String title = "";
   private String link = "";
   private String blogPostAbstract = "";
   private String pubDate = "";


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BlogPost( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BlogPost( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BlogPost( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BlogPost( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BlogPost( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BlogPost( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public BlogPost( DBData aDbData, Document aDoc, Document blogPostDOM, int ndx )
   {
      super( aDbData );
      doc = aDoc;

      try
      {
         Element itemNode   = (Element) DOMManager.getNthMatchingTag( blogPostDOM, "item", ndx );
         Element titleNode  = (Element) DOMManager.getNthMatchingTag( itemNode, "title", 1 );
         Element descrNode  = (Element) DOMManager.getNthMatchingTag( itemNode, "description", 1 );
         Element linkNode   = (Element) DOMManager.getNthMatchingTag( itemNode, "link", 1 );
         Element dateNode   = (Element) DOMManager.getNthMatchingTag( itemNode, "pubDate", 1 );

         title = DOMManager.getData( titleNode );
         link  = DOMManager.getData( linkNode );
         blogPostAbstract = DOMManager.getData( descrNode );
         String[] blogPostDate= DOMManager.getData( dateNode ).split(" ");
         pubDate = blogPostDate[0] + " " + blogPostDate[1] + " " + blogPostDate[2] + " " + blogPostDate[3];
      }
      catch( Exception e)
      {
         System.out.println( "Exception in BlogPost.java " + e );
      }
   }

   public Element getElement()
   {
      Element blogPostElement = doc.createElement( "blogPost" );
      blogPostElement.setAttribute( "title", title );
      blogPostElement.setAttribute( "link",  link );
      blogPostElement.setAttribute( "pubdate",  pubDate );

      Element abstractElement = doc.createElement("abstract");
      abstractElement.appendChild(doc.createCDATASection(blogPostAbstract));
      blogPostElement.appendChild(abstractElement);

      return( blogPostElement );
   }
}
