package jwm.wgbe.model;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.wgbe.model.db.*;
import jwm.entity.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;

public class ProfileContactInfo extends ProfileContactInfoDBRecordBase
{
   private Document doc;

   private String   address               = "";
   private String   url                   = "";
   private boolean  embedMap              = false;
   private String   mapURL                = "";
   private String[] phoneNumbers          = new String[1];
   private String[] emailAddresses        = new String[1];


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ProfileContactInfo( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ProfileContactInfo( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ProfileContactInfo( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ProfileContactInfo( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ProfileContactInfo( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ProfileContactInfo( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }


   public ProfileContactInfo( DBData aDbData, Document aDoc, int ownerId, int ndx, int totalCount )
   {
      super( aDbData );
      doc = aDoc;

      address  = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 2, 0, ndx);
      url      = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 5, 0, ndx);
      mapURL   = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 45, 0, ndx);
      embedMap = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 45, 0, ndx).equals( "checked");

      String[] attrPhoneNumbers = EntityAttributeList.getAttributeValues(dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 3, 0);
      String[] attrEmailAddresses = EntityAttributeList.getAttributeValues(dbData, EntityAttribute.OWNERTYPE_PERSON, ownerId, 4, 0);

      if ( totalCount == 1 ) // if this instance is 1 of 1 total, put all emails and phone numbers in it
      {
        phoneNumbers = attrPhoneNumbers;
        emailAddresses= attrEmailAddresses;
      }
      else // by business rule.... if more than one instance, instance '1' gets phoneNumber[1] and emailAddress[1], etc
      {
        if ( attrPhoneNumbers.length > ndx ) phoneNumbers[0] = attrPhoneNumbers[ndx];
        if ( attrEmailAddresses.length > ndx ) emailAddresses[0]= attrEmailAddresses[ndx];
      }
   }

   public Element getElement()
   {
      Element profileContactInfoElement = doc.createElement( "ContactInfo" );

      Element addressElement = doc.createElement("address");
      addressElement.appendChild(doc.createCDATASection(address));
      profileContactInfoElement.appendChild(addressElement);

      profileContactInfoElement.setAttribute( "url" , url );

      Element emailAddressesElement = doc.createElement("emailAddresses");
      profileContactInfoElement.appendChild(emailAddressesElement);
      for ( int i = 0; i < emailAddresses.length; i++ )
      {
         Element emailAddressElement = doc.createElement("emailAddress");
         emailAddressesElement.appendChild(emailAddressElement);
         emailAddressElement.setAttribute( "address", emailAddresses[i] );
      }

      Element phoneNumbersElement = doc.createElement("phoneNumbers");
      profileContactInfoElement.appendChild(phoneNumbersElement);
      for ( int i = 0; i < phoneNumbers.length; i++ )
      {
         Element phoneNumberElement = doc.createElement("phoneNumber");
         phoneNumbersElement.appendChild(phoneNumberElement);
         phoneNumberElement.setAttribute( "number", phoneNumbers[i] );
      }

      Element mapElement = doc.createElement("map");
      mapElement.setAttribute( "url", mapURL );
      String embedMapText = "false";
      if ( embedMap ) embedMapText = "true";
      mapElement.setAttribute( "embed", embedMapText );
      profileContactInfoElement.appendChild(mapElement);

      return( profileContactInfoElement );
   }
}
