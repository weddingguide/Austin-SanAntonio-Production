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

public class SegmentDef extends SegmentDefDBRecordBase
{
   public static int STATUS_INACTIVE = 0;
   public static int STATUS_ACTIVE = 1;
   public static int STATUS_PROOF = 2;

   public static int TYPE_GALLERY_VIDEO = 1;
   public static int TYPE_LIVE_STREAM = 2;
   public static int TYPE_VIMEO = 3;
   public static int TYPE_YOUTUBE = 4;

   public static String[] STATUSTEXT = {"Inactive", "Active", "Proof" };
   public static String[] TYPETEXT   = {"--", "Gallery Video", "Live Stream", "Vimeo", "YouTube"  };



   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SegmentDef( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SegmentDef( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SegmentDef( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SegmentDef( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SegmentDef( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SegmentDef( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public SegmentDef( DBData aDbData, int ownerType, int ownerId )
   {
      super( aDbData );
      populateObject( "SegmentDef",  "ownertype = " + ownerType + " AND ownerid = " + ownerId, "" );
   }

   public SegmentDef( DBData aDbData, int songId )
   {
      super( aDbData );
      populateObject( "SegmentDef",  "id = " + songId, "" );
   }

   public SegmentDef( DBData aDbData, int ownerType, int ownerId, String name )
   {
      super( aDbData );
      populateObject( "SegmentDef",  "ownertype = " + ownerType + " AND ownerid = " + ownerId + " AND name = '" + name + "'", "" );
   }
}
