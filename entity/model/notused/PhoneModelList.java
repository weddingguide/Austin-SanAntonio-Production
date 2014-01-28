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

public class PhoneModelList extends PhoneList
{
   protected PersonDataAccessCtrl view = null;
   private Document doc;


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PhoneModelList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PhoneModelList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "PHONEMODEL", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public PhoneModelList( DBData dbData )
   {
      super( dbData );
   }
}
