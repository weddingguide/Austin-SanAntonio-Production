package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.entity.model.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.w3c.dom.*;

public class AddressList extends AddressDBRecordListBase
{
   protected PersonDataAccessCtrl view = null;
   public  void                   setView( PersonDataAccessCtrl aView ) { view = aView; }
   public  PersonDataAccessCtrl   getView()                      { return(view); }

   protected Document doc;
   public  void       setDoc( Document aDoc ) { doc = aDoc; }
   public  Document   getDoc()           { return(doc); }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AddressList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AddressList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "ADDRESS", "OWNERID = " + Integer.toString(aId) );
   }

   public AddressList( DBData aDbData, int ownerId, int aId  )
   {
      super( aDbData );
      buildList( "ADDRESS", "OWNERID = " + Integer.toString(aId) + " AND OWNERTYPE = " + Integer.toString(ownerId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AddressList( DBData dbData )
   {
      super( dbData );
   }

   public void deepPopulate()
   {
      for ( int i = 0; i < recordList.length; i++ )
      {
         Address address = (Address) recordList[i];
         address.deepPopulate();
      }
   }

   public Element getElement(Document aDoc, PersonDataAccessCtrl aView)
   {
      doc = aDoc;
      view = aView;

      removeEmptyAddresses();

      Element addressListElement = doc.createElement( "addresses" );

      for ( int i = 0; i < recordList.length; i++ )
      {
         Address address = (Address) recordList[i];
         addressListElement.appendChild( address.getElement(doc, view) );
      }
      return( addressListElement );
   }

   public void removeEmptyAddresses()
   {
      for ( int i = 0; i < recordList.length; i++ )
      {
         Address address = (Address) recordList[i];
         if ( address.getAddressLine1().equals( "" ) ) removeRecord(address);
      }
   }
}
