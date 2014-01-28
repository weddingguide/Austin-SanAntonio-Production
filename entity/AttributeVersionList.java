package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class AttributeVersionList extends AttributeVersionDBRecordListBase
{

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AttributeVersionList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AttributeVersionList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "ATTRIBUTEVERSION", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AttributeVersionList( DBData dbData )
   {
      super( dbData );
   }


   public AttributeVersionList( DBData aDbData, int ownerType, int ownerId  )
   {
      super( aDbData );
      buildList( "ATTRIBUTEVERSION", "OWNERTYPE = " + ownerType + " and OWNERID = " + ownerId, "VERSION ASC" );
   }
}
