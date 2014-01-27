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

public class BlogPostList extends BlogPostDBRecordListBase
{
   private Region region;
   private Document doc;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BlogPostList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BlogPostList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "BLOGPOST", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BlogPostList( DBData dbData )
   {
      super( dbData );
   }

   public BlogPostList( DBData aDbData, Document aDoc, Region aRegion, WGBEDataAccessCtrl ctrl )
   {
      super( aDbData );
      region = aRegion;
      doc = aDoc;

      dbData.getLog().logEvent( "------ BlogPost List -----" );

      Document blogPostDOM = DOMManager.loadXMLFile( "http://"+aRegion.getBlog()+"/?feed=rss2", false);
      for ( int i = 0; i < ctrl.blogPostCount; i++ )
      {
         BlogPost blogPost = new BlogPost( dbData, aDoc, blogPostDOM, i+1 );
         add( blogPost );
      }
   }

   public Element getElement()
   {
      Element blogPostListElement = doc.createElement( "blogPosts" );
      for ( int i = 0; i < recordList.length; i++ )
      {
         BlogPost blogPost = (BlogPost) recordList[i];
         blogPostListElement.appendChild( blogPost.getElement() );
      }
      return( blogPostListElement );
   }
}
