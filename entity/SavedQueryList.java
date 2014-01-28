package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class SavedQueryList extends SavedQueryDBRecordListBase
{

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SavedQueryList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SavedQueryList( DBData aDbData, int queryType  )
   {
      super( aDbData );
      buildList( "SAVEDQUERY", "queryType = " + queryType,  "SORTWEIGHT, NAME ASC" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SavedQueryList( DBData dbData )
   {
      super( dbData, "", "NAME ASC" );

   }
}
