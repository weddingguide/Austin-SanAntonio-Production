package jwm.entity.model;

import jwm.db.*;
import jwm.entity.model.db.*;
import jwm.entity.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;

public class AddressModelList extends AddressList
{
   protected PersonDataAccessCtrl view = null;
   private Document doc;


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AddressModelList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AddressModelList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "ADDRESSMODEL", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AddressModelList( DBData dbData )
   {
      super( dbData );
   }
}
