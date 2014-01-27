package jwm.wgbe;

import jwm.db.*;
import jwm.wgbe.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class BGContractList extends BGContractDBRecordListBase
{

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BGContractList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BGContractList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "BGCONTRACT", "OWNERID = " + aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public BGContractList( DBData dbData )
   {
      super( dbData );
   }
}
