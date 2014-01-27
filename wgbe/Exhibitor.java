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

public class Exhibitor extends ExhibitorDBRecordBase
{
   private HistoryList historyList;
   public  void        setHistoryList( HistoryList aHistoryList ) { historyList = aHistoryList; }
   public  HistoryList getHistoryList()    { return(historyList); }


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Exhibitor( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Exhibitor( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Exhibitor( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Exhibitor( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Exhibitor( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Exhibitor( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public Exhibitor( DBData dbData, int aParentGroup, int aOwnerId )
   {
      super( dbData );
      populateObject( "EXHIBITOR", " PARENTGROUP="+ aParentGroup + " AND OWNERID = " + aOwnerId, "" );
      historyList = new HistoryList( dbData, History.OWNERTYPE_BE_EXHIBITOR, id );
   }

   public Exhibitor( DBData dbData, String aParentGroup, int aOwnerId )
   {
      super( dbData );
      populateObject( "EXHIBITOR, ENTITYGROUP", " PARENTGROUP=ENTITYGROUP.GROUPNUM AND ENTITYGROUP.NAME = '"+ aParentGroup + "' AND OWNERID = " + aOwnerId, "" );
      historyList = new HistoryList( dbData, History.OWNERTYPE_BE_EXHIBITOR, id );
   }

   public Exhibitor( DBData dbData, String bookName, String categoryName, int aBusinessId, int anOrderNumber, String aBooth )
   {
      super( dbData );
      orderNumber = anOrderNumber;
      booth = aBooth;

      createOrUpdateRecord( "EXHIBITOR" );

      EntityGroup beGroup = new EntityGroup( dbData, bookName, categoryName, EntityGroup.TYPE_GENERAL, aBusinessId );
      parentGroup = beGroup.getGroupNum();
      ownerId = aBusinessId;
      createOrUpdateRecord( "EXHIBITOR" );

   }

   public void   setCarpetS(   String value ) { setCarpet( intValue( value ) ); }
   public void   setTable4FtS( String value ) { setTable4Ft( intValue( value ) ); }
   public void   setTable6FtS( String value ) { setTable6Ft( intValue( value ) ); }
   public void   setTable8FtS( String value ) { setTable8Ft( intValue( value ) ); }

   private int intValue( String value )
   {
      if ( value.trim().equals("")) return(0);
      try
      {
         return( new Integer( value ).intValue() );
      }
      catch( Exception e)
      {}
      return(-1);
   }

}
