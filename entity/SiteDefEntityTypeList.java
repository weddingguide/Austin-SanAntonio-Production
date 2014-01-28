package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class SiteDefEntityTypeList extends SiteDefEntityTypeDBRecordListBase
{

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SiteDefEntityTypeList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SiteDefEntityTypeList( DBData aDbData, int anEntityType  )
   {
      super( aDbData );
      buildList( "SITEDEFENTITYTYPE", "ENTITYTYPE = " + Integer.toString(anEntityType), "ID" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SiteDefEntityTypeList( DBData dbData )
   {
      super( dbData, "", "" );
   }
}
