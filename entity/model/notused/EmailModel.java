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

public class EmailModel extends Email
{
   private Document doc;

   private PersonDataAccessCtrl view = null;
   public  void                  setView( PersonDataAccessCtrl aCtrl ) { view = aCtrl; }
   public  PersonDataAccessCtrl getView()                     { return(view); }


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EmailModel( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EmailModel( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EmailModel( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EmailModel( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EmailModel( DBData dbData )
   {
      super( dbData );
   }

   public EmailModel( DBData dbData, int anId, Document aDoc, PersonDataAccessCtrl aCtrl )
   {
      super( dbData, anId );
      doc = aDoc;
      view = aCtrl;
   }
}
