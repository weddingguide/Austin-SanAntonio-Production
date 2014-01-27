package jwm.wgbe.model;
 
import jwm.db.*;
import jwm.wgbe.model.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import org.apache.juli.*;
 
public class MobileHomeList extends MobileHomeDBRecordListBase
{
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MobileHomeList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MobileHomeList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "MOBILEHOME", "ID = " + Integer.toString(aId) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public MobileHomeList( DBData dbData )
   {
      super( dbData );
   }
}
