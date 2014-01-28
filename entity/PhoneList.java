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

public class PhoneList extends PhoneDBRecordListBase
{
   protected PersonDataAccessCtrl view = null;
   public  void                   setView( PersonDataAccessCtrl aView ) { view = aView; }
   public  PersonDataAccessCtrl   getView()                      { return(view); }

   protected Document doc;
   public  void       setDoc( Document aDoc ) { doc = aDoc; }
   public  Document   getDoc()           { return(doc); }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PhoneList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PhoneList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "PHONE", "OWNERID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PhoneList( DBData dbData )
   {
      super( dbData );
   }

   public void deepPopulate()
   {
      for ( int i = 0; i < recordList.length; i++ )
      {
         Phone phone = (Phone) recordList[i];
         phone.deepPopulate();
      }
   }

   public Element getElement(Document aDoc, PersonDataAccessCtrl aView)
   {
      doc = aDoc;
      view = aView;

      Element phoneListElement = doc.createElement( "phoneNumbers" );

      for ( int i = 0; i < recordList.length; i++ )
      {
         Phone phone = (Phone) recordList[i];
         if ( !phone.getPhoneNumber().equals("") ) // there are some empty phone records in the db... don't need to include them here
         {
            phoneListElement.appendChild( phone.getElement(doc, view) );
         }
      }
      return( phoneListElement );
   }

}
