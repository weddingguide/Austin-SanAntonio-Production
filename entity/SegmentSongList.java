package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class SegmentSongList extends SegmentSongDBRecordListBase
{

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SegmentSongList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   public SegmentSongList( DBData aDbData, int ownerType, int ownerId  )
   {
      super( aDbData, "OWNERTYPE="+ownerType + " AND OWNERID="+ownerId, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SegmentSongList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "SEGMENTSONG", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SegmentSongList( DBData dbData )
   {
      super( dbData );
   }
}
