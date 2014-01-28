package jwm.entity.model;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.model.db.*;
import jwm.entity.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;

public class HistoryModel extends History
{
   private Document doc;

   private PersonDataAccessCtrl view = null;
   public  void                  setView( PersonDataAccessCtrl aCtrl ) { view = aCtrl; }
   public  PersonDataAccessCtrl getView()                     { return(view); }

   private String timeStampText = "";

   private String dateText = "";
   public  void   setDateText( String aDateText ) { dateText = aDateText; }
   public  String getDateText()  { return(dateText); }



   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public HistoryModel( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public HistoryModel( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public HistoryModel( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public HistoryModel( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public HistoryModel( DBData dbData )
   {
      super( dbData );
   }

   public HistoryModel( DBData dbData, int anId, Document aDoc, PersonDataAccessCtrl aCtrl )
   {
      super( dbData, anId );
      doc = aDoc;
      view = aCtrl;

      SimpleDateFormat dateFormatter = new SimpleDateFormat ("MMM d, yyyy hh:mma");
      timeStampText  = dateFormatter.format( new java.sql.Date(date.getTime()));

      SimpleDateFormat dateFormatter1 = new SimpleDateFormat ("yyyy-MM-dd");
      dateText       = dateFormatter1.format( new java.sql.Date(date.getTime()));
   }

   public Element getElement()
   {
      Element HistoryElement = doc.createElement( "historyItem" );
      HistoryElement.setAttribute( "description", description );
      HistoryElement.setAttribute( "comment", comment );
      HistoryElement.setAttribute( "originator", originator );
      HistoryElement.setAttribute( "reference", reference );
      HistoryElement.setAttribute( "timestamp", timeStampText  );
      HistoryElement.setAttribute( "type", types[eventType]  );
      HistoryElement.setAttribute( "image", type_image[eventType]  );
      HistoryElement.setAttribute( "userEntry", (new Boolean( type_userEntry[eventType]).toString()));
      HistoryElement.setAttribute( "followupDays", iString( type_followupDays[eventType]));

      return( HistoryElement );
   }
}
