package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import org.apache.juli.*;

public class MailTemplateList extends MailTemplateDBRecordListBase
{

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MailTemplateList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public MailTemplateList( DBData dbData )
   {
      super( dbData );
      buildList( "MAILTEMPLATE", "", "NAME ASC" );
   }

   public MailTemplateList( DBData dbData, String[] qualifiers, int sendMailType )
   {
      super( dbData );
      String queryString = "";

      if ( sendMailType == ObjectClassID.CONTACTSTATUS )
      {
         queryString = "STATUSBATCH > 0";
      }
      if ( sendMailType == ObjectClassID.CONTACT )
      {
         queryString = "INDIVIDUAL > 0";
      }
      if ( sendMailType == ObjectClassID.GROUP )
      {
         queryString = "GROUPBATCH > 0";
      }

      queryString += " AND ( QUALIFIER like 'None'" ;

      for ( int i = 0; i < qualifiers.length; i++ )
      {
         queryString += " OR QUALIFIER LIKE '%" + qualifiers[i] + "%'";
      }
      queryString += ")";

      buildList( "MAILTEMPLATE", queryString, "NAME ASC" );
   }

}
