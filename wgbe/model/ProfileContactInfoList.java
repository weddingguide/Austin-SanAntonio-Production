package jwm.wgbe.model;

import jwm.db.*;
import jwm.wgbe.model.db.*;
import jwm.entity.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;

public class ProfileContactInfoList extends ProfileContactInfoDBRecordListBase
{
   private Region region;
   private Document doc;


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ProfileContactInfoList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ProfileContactInfoList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "PROFILECONTACTINFO", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ProfileContactInfoList( DBData dbData )
   {
      super( dbData );
   }

   public ProfileContactInfoList( DBData aDbData, Document aDoc, int ownerId )
   {
      super( aDbData );
      doc = aDoc;

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      String[] addresses = EntityAttributeList.getAttributeValues(dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 2, 0);

      int addressCount = 0;
      for (addressCount=0; addressCount < addresses.length; addressCount++ )
      {
         if ( addresses[addressCount].trim().equals("") ) break; // stop on first blank addr attribute
      }
      if ( addressCount ==0 ) addressCount = 1; // always need at least one

      for ( int i = 0; i < addressCount; i++ )
      {
         ProfileContactInfo profileContactInfo = new ProfileContactInfo( dbData, doc, ownerId, i, addressCount);
         add( profileContactInfo ); //add it to the list
      }
   }

   public Element getElement()
   {
      Element contactInfoListElement = doc.createElement( "ContactInfoSets" );
      contactInfoListElement.setAttribute( "count", iString( recordList.length ));
      for ( int i = 0; i < recordList.length; i++ )
      {
         ProfileContactInfo contactInfo = (ProfileContactInfo) recordList[i];
         contactInfoListElement.appendChild( contactInfo.getElement() );
      }
      return( contactInfoListElement );
   }

}
