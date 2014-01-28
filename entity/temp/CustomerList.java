package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class CustomerList extends CustomerDBRecordListBase
{

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public CustomerList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

  public CustomerList( DBData aDbData, int aPersonId  )
   {
      super( aDbData );
      String queryString = "SELECT * FROM CUSTOMER, ENTITYGROUP, GROUPMEMBERMAP WHERE "
                          + "( ENTITYGROUP.TYPE = " + EntityGroup.TYPE_CUSTOMERCONTACT
                          + " OR ENTITYGROUP.TYPE = " + EntityGroup.TYPE_COUPLE + ")"
                          + " AND GROUPMEMBERMAP.MEMBERID=" + aPersonId
                          + " AND GROUPMEMBERMAP.GROUPNUM = ENTITYGROUP.GROUPNUM"
                          + " AND GROUPMEMBERMAP.GROUPNUM = CUSTOMER.GROUPID"
                          + ";";
      buildList( queryString, 999 );

   }

  public CustomerList( DBData aDbData, String name)
   {
      super( aDbData );
      String queryString = "SELECT * FROM CUSTOMER, ENTITYGROUP WHERE "
                          + "( ENTITYGROUP.TYPE = " + EntityGroup.TYPE_CUSTOMERCONTACT
                          + " OR ENTITYGROUP.TYPE = " + EntityGroup.TYPE_COUPLE + ")"
                          + " AND ENTITYGROUP.NAME LIKE '%"+name+"%'"
                          + " AND ENTITYGROUP.GROUPNUM LIKE CUSTOMER.GROUPID"
                          + ";";
      buildList( queryString, 999 );

   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public CustomerList( DBData dbData )
   {
      super( dbData );
   }
}
