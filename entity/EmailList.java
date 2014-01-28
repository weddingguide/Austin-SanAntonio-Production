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

public class EmailList extends EmailDBRecordListBase
{
   protected PersonDataAccessCtrl view = null;
   public  void                   setView( PersonDataAccessCtrl aView ) { view = aView; }
   public  PersonDataAccessCtrl   getView()                      { return(view); }

   protected Document doc;
   public  void       setDoc( Document aDoc ) { doc = aDoc; }
   public  Document   getDoc()           { return(doc); }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EmailList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EmailList( DBData aDbData, int aId  )
   {
      super( aDbData );
      String queryString = "SELECT * FROM EMAIL, PERSONEMAILMAP WHERE PERSONEMAILMAP.PERSONID=" + aId + " AND PERSONEMAILMAP.EMAILID = EMAIL.EMAILID";
      buildList( queryString, 999 );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EmailList( DBData dbData )
   {
      super( dbData );
   }

   public EmailList( DBData aDbData, String emailAddress  )
   {
      super( aDbData );
      String queryString = "SELECT * FROM EMAIL WHERE EMAILADDRSS = '" + emailAddress + "'";
      buildList( queryString, 999 );
   }

   public void deepPopulate()
   {
      for ( int i = 0; i < recordList.length; i++ )
      {
         Email email = (Email) recordList[i];
         email.deepPopulate();
      }
   }

   public Element getElement(Document aDoc, PersonDataAccessCtrl aView)
   {
      doc = aDoc;
      view = aView;

      Element emailListElement = doc.createElement( "emailAddresses" );

      for ( int i = 0; i < recordList.length; i++ )
      {
         Email email = (Email) recordList[i];
         emailListElement.appendChild( email.getElement(doc, view) );
      }
      return( emailListElement );
   }
}
