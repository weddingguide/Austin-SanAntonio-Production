package jwm.entity;
 
import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
 
public class EntityAttributeDefList extends EntityAttributeDefDBRecordListBase
{
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDefList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDefList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "ENTITYATTRIBUTEDEF", "ID = " + Integer.toString(aId) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public EntityAttributeDefList( DBData dbData )
   {
      super( dbData );
   }
}
