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

public class HistoryModelList extends HistoryList
{
   protected PersonDataAccessCtrl view = null;
   private Document doc;

   private String lastHistoryDate = "";


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public HistoryModelList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public HistoryModelList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "HISTORYMODEL", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public HistoryModelList( DBData dbData )
   {
      super( dbData );
   }

   public HistoryModelList( DBData dbData, Document aDoc, int ownerType, int ownerId )
   {
      super( dbData );
      doc = aDoc;

      dbData.getLog().logEvent( "++++++++HistoryModelList...." );
      buildHistoryModelList( new HistoryList( dbData, ownerType, ownerId  ));
   }

   public HistoryModelList( DBData dbData, Document aDoc, int ownerType, int ownerId, int aType ) // only history of specific type (e.g. "Sticky note"
   {
      super( dbData );
      doc = aDoc;

      dbData.getLog().logEvent( "++++++++HistoryModelList.... Type = " + aType );
      buildHistoryModelList( new HistoryList( dbData, ownerType, ownerId, aType, 50  ));
   }


   private void buildHistoryModelList( HistoryList historyList )
   {
      recordList = getListInstance(0);  // initialize historyModel recordList to size 0; preparing to build the list
      for ( int i=0; i < historyList.getRecordList().length; i++ )
      {
         History history = (History) historyList.getRecordList()[i];
         HistoryModel aHistoryModel = new HistoryModel( dbData, history.getEventId(), doc, view ); // build a history from each history group
         add( aHistoryModel ); //add it to the list

         if ( i == 0 ) lastHistoryDate = aHistoryModel.getDateText();
      }
   }

   public Element getElement()
   {
      return( getElement( "history" ));
   }

   public Element getElement(String tag)
   {
      Element historyListElement = doc.createElement( tag );
      for ( int i = 0; i < recordList.length; i++ )
      {
         HistoryModel historyModel = (HistoryModel) recordList[i];
         historyListElement.appendChild( historyModel.getElement() );
      }
      return( historyListElement );
   }
}
