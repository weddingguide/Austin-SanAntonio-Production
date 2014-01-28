package jwm.entity;

import jwm.gl2.*;
import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ContactStatusList extends ContactStatusDBRecordListBase
{

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactStatusList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactStatusList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "ContactStatus", "ID = " + Integer.toString(aId) );
   }


   public ContactStatusList( DBData dbData )
   {
      super( dbData );
      buildList( "ContactStatus", "", "SORTWEIGHT ASC" );
   }

   public ContactStatusList( DBData dbData, boolean report )
   {
      super( dbData );
      buildList( "ContactStatus", "DISPLAYINREPORT = 1", "SORTWEIGHT ASC" );
   }
}
