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


public class AudioList extends AudioDBRecordListBase
{
   private Region region;
   private Document doc;


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AudioList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AudioList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "AUDIO", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AudioList( DBData dbData )
   {
      super( dbData );
   }

   public AudioList( DBData aDbData, Document aDoc, int ownerId )
   {
      super( aDbData );
      doc = aDoc;

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      EntityAttributeList audioAttrList = new EntityAttributeList( dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 47, 0);
      for ( int i=0; i < audioAttrList.getRecordList().length; i++ )
      {
         EntityAttribute audioAttr = (EntityAttribute) audioAttrList.getRecordList()[i];
         Audio audio = new Audio( dbData, doc, i, audioAttr);
         add( audio ); //add it to the list
      }
   }

   public Element getElement()
   {
      Element audioListElement = doc.createElement( "audioclips" );
      for ( int i = 0; i < recordList.length; i++ )
      {
         Audio audio = (Audio) recordList[i];
         audioListElement.appendChild( audio.getElement() );
      }
      return( audioListElement );
   }
}
