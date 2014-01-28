package jwm.entity.model;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.model.db.*;
import jwm.logger.*;
import jwm.entity.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;

public class PageData extends PageDataDBRecordBase
{
   private Document doc;
   private JWMBOSDataAccessCtrl ctrl;


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PageData( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PageData( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PageData( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PageData( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PageData( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PageData( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public PageData( DBData aDbData, Document aDoc, JWMBOSDataAccessCtrl aCtrl )
   {
      super( aDbData );

      doc = aDoc;
      ctrl = aCtrl;
   }


   public Element getElement()
   {
      Element pageDataElement = doc.createElement( "pagedata" );
      Element callBackElement = doc.createElement( "callBack" );
      callBackElement.appendChild( doc.createCDATASection( ctrl.callBack ));
      pageDataElement.appendChild( callBackElement );

      Element selfElement = doc.createElement( "self" );
      selfElement.appendChild( doc.createCDATASection( ctrl.self ));
      pageDataElement.appendChild( selfElement );

      return( pageDataElement );
   }
}
