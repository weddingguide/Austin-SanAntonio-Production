package jwm.entity.model;
import jwm.db.*;
import jwm.entity.model.db.*;
import jwm.entity.*;
import jwm.project.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import java.util.*;
import org.apache.juli.*;
import org.w3c.dom.*;

public class ContactModelListSet
{
   protected ContactDataAccessCtrl contactCtrl = null;
   public  void                    setContactDataAccessCtrl( ContactDataAccessCtrl aContactDataAccessCtrl ) { contactCtrl = aContactDataAccessCtrl; }
   public  ContactDataAccessCtrl   getContactDataAccessCtrl()                { return(contactCtrl); }


   private Document doc;


   private ContactModelList[] contactListSet = new ContactModelList[1];

   private int sendMailType = -1;

   public ContactModelListSet( DBData dbData, Document aDoc, ContactDataAccessCtrl aContactDataAccessCtrl )
   {
      contactCtrl = aContactDataAccessCtrl;
      doc = aDoc;

      ArrayList contactLists = new ArrayList();
      if ( contactCtrl.separateLists )
      {
         for ( int i = 0; i < contactCtrl.statusArray.length; i++ )
         {
            contactLists.add( new ContactModelList( dbData, doc, contactCtrl, i ));
         }
      }
      else // merge all lists into one (default)
      {
         contactLists.add( new ContactModelList( dbData, doc, contactCtrl ));
      }

      contactListSet = (ContactModelList[]) contactLists.toArray( contactListSet );
   }


   public Element getElement()
   {
      Element contactListSetElement = doc.createElement( "contactlists" );

      for ( int i = 0; i < contactListSet.length; i++ )
      {
         contactListSetElement.appendChild( contactListSet[i].getElement() );
      }
      return( contactListSetElement );
   }


}
