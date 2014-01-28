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

public class Email extends EmailDBRecordBase
{
   protected PersonDataAccessCtrl view = null;
   public  void                   setView( PersonDataAccessCtrl aView ) { view = aView; }
   public  PersonDataAccessCtrl   getView()                      { return(view); }

   protected Document doc;
   public  void       setDoc( Document aDoc ) { doc = aDoc; }
   public  Document   getDoc()           { return(doc); }

   private HistoryList historyList;
   public  void        setHistoryList( HistoryList aHistoryList ) { historyList = aHistoryList; }
   public  HistoryList getHistoryList()    { return(historyList); }

   private EntityCustomText customText = null;


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Email( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
      if (!recordFound) subscribe = 1;
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Email( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
      if (!recordFound) subscribe = 1;
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Email( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
      if (!recordFound) subscribe = 1;
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Email( DBData dbData )
   {
      super( dbData );
      if (!recordFound) subscribe = 1;
   }

   public Email( DBData dbData, String refkey )
   {
      super( dbData );
      populateObject( "EMAIL", "REFKEY = '" + refkey + "'", "" );
      if (!recordFound) subscribe = 1;
   }

   public void deepPopulate()
   {
      historyList = new HistoryList( dbData, "OWNERID = " + emailId + " AND OWNERTYPE = " + History.OWNERTYPE_EMAIL, "" );

// 11/2/06 the following was put in for migration when the refkey was introduced.  Pretty sure it's served its purpose now... refkeys are created as part of normal object creation now
// 1/26/08 apparently not... reactivating for a while...

      if ((refKey.equals( "" ))
         ||(refKey.equals( "0" )))
      {
         refKey = Integer.toString( Math.abs(emailAddress.hashCode()));
         updateRecord( "EMAIL" );
      }

      int anOwnerType = ownerType;
      if (anOwnerType == -1 ) anOwnerType = Person.RECORDTYPE_PERSON;
      customText = new EntityCustomText( dbData, anOwnerType, EntityCustomText.OBJECTTYPE_EMAIL, emailAddressType );
   }

   public boolean createRecord( String tableName )
   {
      try
      {
         refKey = Integer.toString( Math.abs(emailAddress.hashCode()));
         boolean rc =super.createRecord( tableName );
         if (!rc) return(rc);

         PersonEmailMap personEmailMap = new PersonEmailMap( dbData );
         personEmailMap.setPersonId( ownerId );
         personEmailMap.setEmailId( emailId );
         return( personEmailMap.createRecord( "PERSONEMAILMAP" ) );
      }
      catch( Exception e)
      {
          log.logEvent( e.toString() );
      }
      catch( Error err)
      {
          log.logEvent( err.toString() );
      }
      return(false);
   }

   public void setEmailAddress( String anEmail )
   {
      super.setEmailAddress( anEmail );
      refKey = Integer.toString( Math.abs(anEmail.hashCode()));
   }

   public Element getElement(Document aDoc, PersonDataAccessCtrl aView)
   {
      doc = aDoc;
      view = aView;

      Element emailElement = doc.createElement( "email" );
      emailElement.setAttribute( "emailaddress"          , emailAddress             );
      emailElement.setAttribute( "subscribe"           , iString(subscribe)         );
      emailElement.setAttribute( "type"                , iString(emailAddressType)  );
      emailElement.setAttribute( "refkey"              , refKey                     );
      emailElement.setAttribute( "name"                , customText.getLongName()   );
      emailElement.setAttribute( "shortname"           , customText.getShortName()  );
      return( emailElement );
   }
}
