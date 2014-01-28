package jwm.entity;
 
import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
 
public class CoupleGroupInfoList extends CoupleGroupInfoDBRecordListBase
{
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public CoupleGroupInfoList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public CoupleGroupInfoList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "COUPLEGROUPINFO", "ID = " + Integer.toString(aId) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public CoupleGroupInfoList( DBData dbData )
   {
      super( dbData );
   }
}
