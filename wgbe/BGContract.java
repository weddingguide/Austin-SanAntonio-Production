package jwm.wgbe;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.*;
import jwm.wgbe.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BGContract extends BGContractDBRecordBase
{
   private HistoryList historyList;
   public  void        setHistoryList( HistoryList aHistoryList ) { historyList = aHistoryList; }
   public  HistoryList getHistoryList() { return( new HistoryList( dbData, History.OWNERTYPE_WG_CONTRACT, id )); }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BGContract( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BGContract( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BGContract( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BGContract( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BGContract( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BGContract( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public BGContract( DBData dbData, int aId )
   {
      super( dbData);
      if ( aId != -1 )
      {
         populateObject( "BGCONTRACT", "ID", aId );
      }
   }
}
