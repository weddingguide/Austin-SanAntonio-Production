package jwm.wgbe;

import jwm.entity.*;
import jwm.db.*;
import jwm.servletdb.*;
import jwm.wgbe.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Ad extends AdDBRecordBase
{
   public static final int TYPE_QUARTERPAGECOLOR = 1;
   public static final int TYPE_HALFPAGECOLOR    = 2;
   public static final int TYPE_FULLPAGECOLOR    = 3;
   public static final int TYPE_2PAGECOLOR       = 4;
   public static final int TYPE_HALFPAGEBW       = 5;
   public static final int TYPE_FULLPAGEBW       = 6;
   public static final int TYPE_SHOWCASE         = 7;

   public static final int STATUS_NOTSTARTED           = 0;
   public static final int STATUS_PENDINGDIGITALCOPY   = 1;
   public static final int STATUS_PENDINGROUGHCOPY     = 2;
   public static final int STATUS_ATPRINTER            = 3;
   public static final int STATUS_PENDINGPROOFAPPROVAL = 4;
   public static final int STATUS_APPROVED             = 5;

   public static final int PREMIUM_PLACEMENT_NONE                 = 0;
   public static final int PREMIUM_PLACEMENT_INSIDEFRONTCOVER     = 1;
   public static final int PREMIUM_PLACEMENT_INSIDEBACKCOVER      = 2;
   public static final int PREMIUM_PLACEMENT_OUTSIDEBACKCOVER     = 3;
   public static final int PREMIUM_PLACEMENT_FIRST_10_PAGES       = 4;

   public static final int OPTIONAL_PLACEMENT_NONE                 = 0;
   public static final int OPTIONAL_PLACEMENT_RIGHTPAGE            = 1;
   public static final int OPTIONAL_PLACEMENT_LEFTPAGE             = 2;
   public static final int OPTIONAL_PLACEMENT_OTHER                = 3;

   public static final String[] adTypeText = {"", "1/4 Page Color", "1/2 Page Color", "Full Page Color", "2 Page Color", "1/2 Page B/W", "Full Page B/W" };

   public static final String[] adStatusText = {"Not Started", "Pending Digital Copy", "Pending Rough Copy", "At Printer", "Pending Proof Approval", "Approved" };

   public static final String[] premiumPlacementText = {"None", "Inside Front Cover", "Inside Back Cover", "Outside Back Cover", "First 10 Pages"};

   public static final String[] optionalPlacementText = {"None", "Right Page", "Left Page", "Other"};


   private HistoryList historyList;
   public  void        setHistoryList( HistoryList aHistoryList ) { historyList = aHistoryList; }
   public  HistoryList getHistoryList()    { return(historyList); }



   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Ad( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Ad( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Ad( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Ad( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Ad( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Ad( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public Ad( DBData dbData, int aParentGroup, int aOwnerId )
   {
      super( dbData );
      populateObject( "AD", " PARENTGROUP="+ aParentGroup + " AND OWNERID = " + aOwnerId, "" );
      historyList = new HistoryList( dbData, History.OWNERTYPE_WG_AD, id );
   }

   public Ad( DBData dbData, String bookName, String categoryName, int aBusinessId, int anOrderNumber, int contractId, String theAdNotes )
   {
      super( dbData );
      createOrUpdateRecord( "AD" );

      EntityGroup adGroup = new EntityGroup( dbData, bookName, categoryName, EntityGroup.TYPE_GENERAL, aBusinessId, GroupMemberMap.ASSOCIATED_WITH_WG_CONTRACT, contractId );

      orderNumber = anOrderNumber;
      parentGroup = adGroup.getGroupNum();
      ownerId = aBusinessId;
      adNotes = theAdNotes;
      createOrUpdateRecord( "AD" );

   }
}
