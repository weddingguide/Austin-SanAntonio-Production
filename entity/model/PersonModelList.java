package jwm.entity.model;

import jwm.db.*;
import jwm.entity.model.db.*;
import jwm.entity.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;

public class PersonModelList extends PersonList
{
   protected PersonDataAccessCtrl view = null;
   private Document doc;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PersonModelList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PersonModelList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "PERSONMODEL", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PersonModelList( DBData dbData )
   {
      super( dbData );
   }

   public PersonModelList( DBData dbData, Document aDoc, PersonDataAccessCtrl aCtrl, PersonList personList )
   {
      super( dbData );
      doc = aDoc;
      view = aCtrl;

      if ( view.inclFromPersonList )
      {
         buildPersonModelList( personList );
      }
   }



   private void buildPersonModelList( PersonList personList )
   {
      recordList = getListInstance(0);  // initialize personModel recordList to size 0; preparing to build the list
      for ( int i=0; i < personList.getRecordList().length; i++ )
      {
         Person person = (Person) personList.getRecordList()[i];
         PersonModel aPersonModel = new PersonModel( dbData, person.getPersonId(), doc, view ); // build a person from each person group
         aPersonModel.setRole( person.getRole() );
         aPersonModel.setPrimaryMember( person.getPrimaryMember() );

         add( aPersonModel ); //add it to the list
      }
   }

   public Element getElement()
   {
      return( getElement( "members", "member" ));
   }

   public Element getElement(String tag, String subTag )
   {
      Element personListElement = doc.createElement( tag );

      for ( int i = 0; i < recordList.length; i++ )
      {
         PersonModel personModel = (PersonModel) recordList[i];
         personListElement.appendChild( personModel.getElement( subTag ) );
      }
      return( personListElement );
   }
}
