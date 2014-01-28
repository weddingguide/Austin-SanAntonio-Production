package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;


public class EntityCustomTextList extends EntityCustomTextDBRecordListBase
{
   public String[][][][] text = new String[3][6][10][2];    // recordType / addr-ph-email / instance / long-short


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityCustomTextList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityCustomTextList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "ENTITYCUSTOMTEXT", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityCustomTextList( DBData dbData )
   {
      super( dbData, "", "" );

      // populate array
      for ( int i = 0; i < recordList.length; i++ )
      {
         EntityCustomText ct = (EntityCustomText) recordList[i];

         text[ ct.getEntityType() ][ ct.getObjectType() ][ ct.getInstance() ] [ EntityCustomText.TEXTTYPE_LONG ] = ct.getLongName();
         text[ ct.getEntityType() ][ ct.getObjectType() ][ ct.getInstance() ] [ EntityCustomText.TEXTTYPE_SHORT ] = ct.getShortName();
      }
   }

   public int getInstanceCount( int entityType, int objectType )
   {
      int i;
      for ( i = 0; i < 10; i++ )
      {
         if ( text[ entityType ][ objectType ][ i ][0] == null ) return(i);
      }
      return(i);
   }
}
