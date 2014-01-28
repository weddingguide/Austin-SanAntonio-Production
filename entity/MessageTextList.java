package jwm.entity;
 
import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
 
public class MessageTextList extends MessageTextDBRecordListBase
{
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MessageTextList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MessageTextList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "MESSAGETEXT", "ID = " + Integer.toString(aId) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MessageTextList( DBData dbData )
   {
      super( dbData );
   }
}
