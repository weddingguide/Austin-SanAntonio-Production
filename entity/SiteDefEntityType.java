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

public class SiteDefEntityType extends SiteDefEntityTypeDBRecordBase
{

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SiteDefEntityType( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SiteDefEntityType( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SiteDefEntityType( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SiteDefEntityType( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SiteDefEntityType( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SiteDefEntityType( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public SiteDefEntityType( DBData dbData, int aStatus )
   {
      super( dbData );
      populateObject( "SITEDEFENTITYTYPE","MATCHENTITYSTATUS", aStatus );
   }

   public SiteDefEntityType( DBData dbData, int aStatus, boolean signatureFlag )
   {
      super( dbData );
      populateObject( "SITEDEFENTITYTYPE","ID", aStatus );
   }


}
