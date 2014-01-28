package jwm.entity;
 
import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
 
public class PersonEmailMapList extends PersonEmailMapDBRecordListBase
{
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PersonEmailMapList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PersonEmailMapList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "PERSONEMAILMAP", "ID = " + Integer.toString(aId) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public PersonEmailMapList( DBData dbData )
   {
      super( dbData );
   }
}
