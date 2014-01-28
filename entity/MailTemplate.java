package jwm.entity;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;

public class MailTemplate extends MailTemplateDBRecordBase
{

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MailTemplate( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MailTemplate( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MailTemplate( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MailTemplate( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MailTemplate( DBData dbData, int aId)
   {
      super( dbData);
      if ( aId != -1 )
      {
         populateObject( "MAILTEMPLATE", "ID", aId );
      }
   }

   public MailTemplate( DBData dbData, String aName)
   {
      super( dbData);
      populateObject( "MAILTEMPLATE", "NAME = '" + aName+ "'", "" );
   }

   public MailTemplate( DBData dbData)
   {
      super( dbData);
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MailTemplate( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }
}
