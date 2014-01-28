package jwm.entity;
 
import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
 
public class TermProjectInfoList extends TermProjectInfoDBRecordListBase
{
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public TermProjectInfoList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public TermProjectInfoList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "TERMPROJECTINFO", "ID = " + Integer.toString(aId) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public TermProjectInfoList( DBData dbData )
   {
      super( dbData );
   }
}
