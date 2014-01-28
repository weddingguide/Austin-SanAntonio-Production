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

public class Phone extends PhoneDBRecordBase
{
   public static final int HOME   = 1;
   public static final int CELL   = 2;
   public static final int MOBILE = 2; // cell and mobile are the same
   public static final int WORK   = 3;
   public static final int FAX    = 4;

   protected PersonDataAccessCtrl view = null;
   public  void                   setView( PersonDataAccessCtrl aView ) { view = aView; }
   public  PersonDataAccessCtrl   getView()                      { return(view); }

   protected Document doc;
   public  void       setDoc( Document aDoc ) { doc = aDoc; }
   public  Document   getDoc()           { return(doc); }

   private EntityCustomText customText = null;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Phone( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Phone( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Phone( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Phone( DBData dbData )
   {
      super( dbData );
   }

   public void deepPopulate()
   {
      int anOwnerType = ownerType;
      if (anOwnerType == -1 ) anOwnerType = Person.RECORDTYPE_PERSON;
      customText = new EntityCustomText( dbData, anOwnerType, EntityCustomText.OBJECTTYPE_PHONE, phoneNumberType );
   }


   public Element getElement(Document aDoc, PersonDataAccessCtrl aView)
   {
      doc = aDoc;
      view = aView;

      Element phoneElement = doc.createElement( "phoneNumber" );
      phoneElement.setAttribute( "number"              , phoneNumber              );
      phoneElement.setAttribute( "type"                , iString(phoneNumberType)       );
      phoneElement.setAttribute( "name"                , customText.getLongName()   );
      phoneElement.setAttribute( "shortname"           , customText.getShortName()  );
      return( phoneElement );
   }
}
