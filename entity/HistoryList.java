package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import org.w3c.dom.*;

public class HistoryList extends HistoryDBRecordListBase
{
   protected Document doc;
   public  void       setDoc( Document aDoc ) { doc = aDoc; }
   public  Document   getDoc()           { return(doc); }


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public HistoryList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public HistoryList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "HISTORY", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public HistoryList( DBData aDbData, int aOwnerType, int aOwnerId  )
   {
       this( aDbData, aOwnerType, aOwnerId, 99999 );
   }

   public HistoryList( DBData aDbData, int aOwnerType, int aOwnerId, int limitCount  )
   {
      super( aDbData );
      buildList( "HISTORY", "OWNERID = " + aOwnerId + " AND OWNERTYPE = " + aOwnerType + " AND EVENTTYPE NOT IN (" + History.TYPE_CLOCK_IN +","+History.TYPE_CLOCK_OUT+","+History.TYPE_END_PAY_PERIOD+")" , "DATE DESC LIMIT 0,"+limitCount);
   }

   public HistoryList( DBData aDbData, int aOwnerType, int aOwnerId, int aType, int limitCount  )
   {
      super( aDbData );
      buildList( "HISTORY", "OWNERID = " + aOwnerId + " AND OWNERTYPE = " + aOwnerType + " AND EVENTTYPE = " + aType , "DATE DESC LIMIT 0,"+limitCount);
   }

   public HistoryList( DBData aDbData, int aOwnerType, int aOwnerId, int aType, boolean signatureFlag, int limitCount  )
   {
      super( aDbData );
      buildList( "HISTORY", "OWNERID = " + aOwnerId + " AND OWNERTYPE = " + aOwnerType + " AND EVENTTYPE != " + aType , "DATE DESC LIMIT 0,"+limitCount);
   }

   public HistoryList( DBData aDbData, int limitCount, boolean signatureFlag  )
   {
      super( aDbData );
      buildList( "HISTORY", "", "DATE DESC LIMIT 0,"+limitCount);
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public HistoryList( DBData dbData )
   {
      super( dbData );
   }

}
