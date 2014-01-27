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

public class StaticContentList extends StaticContentDBRecordListBase
{
   private Region region;
   private Document doc;


   // get all staticContents for a region
   public StaticContentList( DBData aDbData, Document aDoc, Region aRegion, WGBEDataAccessCtrl ctrl )
   {
      super( aDbData );
      region = aRegion;
      doc = aDoc;

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      for ( int i=0; i < ctrl.staticContentNames.length; i++ )
      {
         StaticContent staticContent = new StaticContent( aDbData, doc, aRegion, ctrl.staticContentNames[i], "" );
         add( staticContent ); //add it to the list
      }
   }

   public Element getElement()
   {
      Element staticContentListElement = doc.createElement( "staticcontentitems" );
      for ( int i = 0; i < recordList.length; i++ )
      {
         StaticContent staticContent = (StaticContent) recordList[i];
         staticContentListElement.appendChild( staticContent.getElement() );
      }
      return( staticContentListElement );
   }
}
