package jwm.entity;

import jwm.gl2.*;
import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ContactStatusCategoryList extends ContactStatusCategoryDBRecordListBase
{

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactStatusCategoryList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactStatusCategoryList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "ContactStatusCATEGORY", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactStatusCategoryList( DBData dbData )
   {
      super( dbData );
   }
}
