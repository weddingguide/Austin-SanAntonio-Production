package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import jwm.idmanager.*;
import jwm.project.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class SegmentDefList extends SegmentDefDBRecordListBase
{
   public boolean containsWMV = false;
   public boolean containsMP4 = false;
   public boolean containsFLV = false;


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SegmentDefList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   public SegmentDefList( DBData aDbData, int ownerType, int ownerId  )
   {
      super( aDbData, "OWNERTYPE="+ownerType + " AND OWNERID="+ownerId , "NDX ASC" );
      deepPopulate(ownerType, ownerId);
   }

   public SegmentDefList( DBData aDbData, int ownerType, int ownerId, int aStatus  )
   {
      super( aDbData, "OWNERTYPE="+ownerType + " AND OWNERID="+ownerId + " AND STATUS = " + aStatus, "NDX ASC" );
      deepPopulate(ownerType, ownerId);
   }

   public SegmentDefList( DBData aDbData, int ownerType, int ownerId, boolean inclProof  )
   {
      super( aDbData, "OWNERTYPE="+ownerType + " AND OWNERID="+ownerId + " AND (STATUS = " + SegmentDef.STATUS_ACTIVE + " OR STATUS = " + SegmentDef.STATUS_PROOF + ")", "NDX ASC" );
      deepPopulate(ownerType, ownerId);
   }


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SegmentDefList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "SEGMENTDEF", "ID = " + Integer.toString(aId) );
      deepPopulate(-1, aId);
   }

   public void deepPopulate(int ownerType, int aId )
   {
      if (ownerType != ObjectClassID.PROJECT)
      {
         CoupleGroupInfo coupleInfo = new CoupleGroupInfo( dbData, 3, aId );
         coupleInfo.deepPopulate();

         for ( int i = 0; i < recordList.length; i++ )
         {
             SegmentDef aSegment = (SegmentDef) recordList[i];

             dbData.getLog().logEvent( "checking for files for segment: " + aSegment.getName() );
             File aFile = new File( coupleInfo.getVideoRoot() + "\\" + aSegment.getName() + ".wmv" );
             dbData.getLog().logEvent( aFile.getAbsolutePath() );
             if ( aFile.exists() ) containsWMV = true;

             aFile = new File( coupleInfo.getVideoRoot() + "\\" + aSegment.getName() + ".mp4" );
             dbData.getLog().logEvent( aFile.getAbsolutePath() );
             if ( aFile.exists() ) containsMP4 = true;

             aFile = new File( coupleInfo.getVideoRoot() + "\\" + aSegment.getName() + ".flv" );
             dbData.getLog().logEvent( aFile.getAbsolutePath() );
             if ( aFile.exists() ) containsFLV = true;

         }
      }
      else
      {
         Project project = new Project( dbData, aId );

         String  videoRoot = SiteProperty.valueOf( dbData, "videoRoot");

         for ( int i = 0; i < recordList.length; i++ )
         {
             SegmentDef aSegment = (SegmentDef) recordList[i];
             String fileName = videoRoot + "\\" + project.getShortName() + "\\" + aSegment.getName();

             dbData.getLog().logEvent( "checking for files for segment: " + aSegment.getName() );
             File aFile = new File(  fileName + ".wmv" );
             dbData.getLog().logEvent( aFile.getAbsolutePath() );
             if ( aFile.exists() ) containsWMV = true;

             aFile = new File(  fileName + ".mp4" );
             dbData.getLog().logEvent( aFile.getAbsolutePath() );
             if ( aFile.exists() ) containsMP4 = true;

             aFile = new File(  fileName + ".flv" );
             dbData.getLog().logEvent( aFile.getAbsolutePath() );
             if ( aFile.exists() ) containsFLV = true;

         }
      }
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public SegmentDefList( DBData dbData )
   {
      super( dbData );
   }
}
