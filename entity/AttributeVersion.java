package jwm.entity;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AttributeVersion extends AttributeVersionDBRecordBase
{
   public static final int STATUS_WORKING =  1;
   public static final int STATUS_PROOF =  2;
   public static final int STATUS_QUEUED_FOR_PUBLISH =  3;
   public static final int STATUS_CURRENT_PUBLISHED =  4;
   public static final int STATUS_ARCHIVED =  5;

   public static final String[] STATENAMES = { "", "Working", "Proof", "Queued for Publish", "Current Publish", "Archived" };



   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AttributeVersion( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AttributeVersion( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AttributeVersion( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AttributeVersion( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AttributeVersion( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public AttributeVersion( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }


   public AttributeVersion( DBData dbData, int aOwnerType, int aOwnerId, int aVersion )
   {
      super( dbData );
      populateObject( "ATTRIBUTEVERSION", "OWNERID = " + aOwnerId + " AND OWNERTYPE = " + aOwnerType + " AND VERSION = " + aVersion, "");
      ownerId = aOwnerId;
      ownerType= aOwnerType;
      id = aVersion;
   }
}
