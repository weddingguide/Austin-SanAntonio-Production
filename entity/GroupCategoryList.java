package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class GroupCategoryList extends GroupCategoryDBRecordListBase
{

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupCategoryList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupCategoryList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "GROUPCATEGORY", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public GroupCategoryList( DBData dbData )
   {
      super( dbData );
      String queryString = "SELECT * FROM GROUPCATEGORY WHERE STATUS = " + GroupCategory.STATUS_ACTIVE;
      buildList( queryString, 999 );
   }
}
