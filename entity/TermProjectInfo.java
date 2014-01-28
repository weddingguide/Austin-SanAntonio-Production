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

public class TermProjectInfo extends TermProjectInfoDBRecordBase
{
   public static final int PRESENT_SECTION_1 = 1;
   public static final int PRESENT_SECTION_2 = 2;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public TermProjectInfo( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public TermProjectInfo( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public TermProjectInfo( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public TermProjectInfo( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public TermProjectInfo( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public TermProjectInfo( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public TermProjectInfo( DBData dbData, int groupId )
   {
      super( dbData );
      populateObject( "TERMPROJECTINFO", "OWNERID", groupId );
   }

   public boolean createRecord( String tableName )
   {
      createDate = new java.sql.Date( new java.util.Date().getTime() );
      return( super.createRecord( tableName ) );
   }


}
