package jwm.entity.model;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.model.db.*;
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

public class PersonModel extends Person
{
   private Document doc;

   private PersonDataAccessCtrl view = null;
   public  void                  setView( PersonDataAccessCtrl aCtrl ) { view = aCtrl; }
   public  PersonDataAccessCtrl getView()                     { return(view); }

   protected String siteDefEntityTypeText = "";
   public  void     setSiteDefEntityTypeText( String aSiteDefEntityTypeText ) { siteDefEntityTypeText = aSiteDefEntityTypeText; }
   public  String   getSiteDefEntityTypeText() { return(siteDefEntityTypeText); }



   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PersonModel( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PersonModel( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PersonModel( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PersonModel( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PersonModel( DBData dbData )
   {
      super( dbData );
   }

   public PersonModel( DBData dbData, int anId, Document aDoc, PersonDataAccessCtrl aCtrl )
   {
      super( dbData, anId );
      doc = aDoc;
      view = aCtrl;
      deepPopulate();

      SiteDefEntityType siteDefEntityTypeInfo = new SiteDefEntityType( dbData, siteDefEntityType, true );
      siteDefEntityTypeText = siteDefEntityTypeInfo.getName();

      addresses.deepPopulate();
      emailAddresses.deepPopulate();
      phoneNumbers.deepPopulate();

   }

   public Element getElement()
   {
      return( getElement( "member" ));
   }

   public Element getElement( String tag )
   {
      Element personElement = doc.createElement( tag );
      personElement.setAttribute( "name"                , getName()                  );
      personElement.setAttribute( "id"                  , iString(personId)          );
      personElement.setAttribute( "ownerid"             , iString(ownerId)           );
      personElement.setAttribute( "ownertype"           , OWNERTYPE_TEXT[ownerType]  );
      personElement.setAttribute( "lastname"            , lastName                   );
      personElement.setAttribute( "firstname"           , firstName                  );
      personElement.setAttribute( "middlename"          , middleName                 );

      personElement.setAttribute( "status"              , STATUS_TEXT[status]        );
      personElement.setAttribute( "recordtype"          , RECORDTYPE_TEXT[recordType]        );
      personElement.setAttribute( "sitedefentitytype"   , siteDefEntityTypeText      );

      personElement.setAttribute( "title"               , title                      );
      personElement.setAttribute( "nickname"            , nickName                   );
      personElement.setAttribute( "suffix"              , suffix                     );
      personElement.setAttribute( "preferredname"       , preferredName              );
      personElement.setAttribute( "sex"                 , SEX_TEXT[sex]              );
      personElement.setAttribute( "age"                 , iString(age)               );
      personElement.setAttribute( "birthdate"           , birthDate.toString()       );

      personElement.setAttribute( "createdate"          , createDate.toString()      );
      personElement.setAttribute( "lastupdate"          , lastUpdate.toString()      );
      personElement.setAttribute( "comment"             , comment                    );
      personElement.setAttribute( "url"                 , url                        );

      personElement.setAttribute( "primary"             , (new Boolean( primaryMember )).toString() );
      personElement.setAttribute( "role"                , role                        );

      personElement.appendChild( addresses.getElement(doc, view) );  // need to pass these for secondary objects that don't have separate model classes
      personElement.appendChild( emailAddresses.getElement(doc, view) );
      personElement.appendChild( phoneNumbers.getElement(doc, view) );

      return( personElement );
   }

}
