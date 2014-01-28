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

public class SavedQuery extends SavedQueryDBRecordBase
{
   // these need to match Person.persontype_* where applicable.  Some code uses the Person constants to define query types.  But to be more versatile, need to start using these

   public static final int QUERYTYPE_PERSON = 0;
   public static final int QUERYTYPE_BUSINESS = 1;
   public static final int QUERYTYPE_COUPLE   = 3;
   public static final int QUERYTYPE_PROJECT  = 6;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SavedQuery( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SavedQuery( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SavedQuery( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SavedQuery( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SavedQuery( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SavedQuery( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public SavedQuery( DBData dbData, String queryName )
   {
      super( dbData );
      populateObject( "SAVEDQUERY", "NAME = " + prepareStringField(queryName) , "" );
   }
}
