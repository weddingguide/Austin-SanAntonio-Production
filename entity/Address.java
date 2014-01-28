package jwm.entity;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.db.*;
import jwm.entity.model.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.w3c.dom.*;

public class Address extends AddressDBRecordBase
{
   protected PersonDataAccessCtrl view = null;
   public  void                   setView( PersonDataAccessCtrl aView ) { view = aView; }
   public  PersonDataAccessCtrl   getView()                      { return(view); }

   protected Document doc;
   public  void       setDoc( Document aDoc ) { doc = aDoc; }
   public  Document   getDoc()           { return(doc); }

   private EntityCustomText customText = null;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Address( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Address( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Address( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Address( DBData dbData )
   {
      super( dbData );
   }

   public Address( DBData aDbData, int aAddressType, int aOwnerType, int aOwnerId )
   {
      super( aDbData );
      populateObject( "ADDRESS", "ADDRESSTYPE ="+aAddressType + " AND OWNERTYPE = " + aOwnerType + " AND OWNERID = " + aOwnerId, "" );
      addressType = aAddressType;
      ownerType = aOwnerType;
      ownerId = aOwnerId;
   }

   public void deepPopulate()
   {
      int anOwnerType = ownerType;
      if (anOwnerType == -1 ) anOwnerType = Person.RECORDTYPE_PERSON;
      customText = new EntityCustomText( dbData, anOwnerType, EntityCustomText.OBJECTTYPE_ADDRESS, addressType );
   }

   public String toHTML()
   {
      String theAddress = addressLine1;
      if ( !addressLine2.equals("")) theAddress += "<br>"+addressLine2;
      if ( !addressLine3.equals("")) theAddress += "<br>"+addressLine3;
      theAddress += "<br>"+city;
      theAddress += ", "+state;
      theAddress += " "+postalCode;
      if ( !country.equals("")) theAddress += "<br>"+country;
      return( theAddress );
   }


   public Element getElement(Document aDoc, PersonDataAccessCtrl aView)
   {
      doc = aDoc;
      view = aView;

      Element addressElement = doc.createElement( "address" );
      addressElement.setAttribute( "address"             , addressLine1               );
      addressElement.setAttribute( "line2"               , addressLine2               );
      addressElement.setAttribute( "line3"               , addressLine3               );
      addressElement.setAttribute( "type"                , iString(addressType)       );
      addressElement.setAttribute( "city"                , city                       );
      addressElement.setAttribute( "state"               , state                      );
      addressElement.setAttribute( "postalcode"          , postalCode                 );
      addressElement.setAttribute( "country"             , country                    );
      addressElement.setAttribute( "name"                , customText.getLongName()   );
      addressElement.setAttribute( "shortname"           , customText.getShortName()  );
      return( addressElement );
   }
}
