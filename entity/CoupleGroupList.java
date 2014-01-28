package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CoupleGroupList extends EntityGroupList
{

   public CoupleGroupList( DBData aDbData )
   {
      // this gets a list of all couples

      super( aDbData );
      String queryString = "SELECT * FROM EntityGroup WHERE EntityGroup.TYPE = " + EntityGroup.TYPE_COUPLE + " ORDER BY NAME ASC";
      buildList( queryString, 999 );
   }

   public CoupleGroupList( DBData aDbData, boolean flag )
   {
      // this gets a list of couples sorted by wedding date

      super( aDbData );
      String queryString = "SELECT * FROM EntityGroup, EVENTS WHERE (EVENTS.OWNERTYPE=3) AND (EVENTS.OWNERID = EntityGroup.GROUPNUM) AND (EVENTS.DESCRIPTION = 'Ceremony') AND EntityGroup.TYPE = " + EntityGroup.TYPE_COUPLE + " ORDER BY EVENTS.DATE ASC";
      buildList( queryString, 999 );
   }

   public CoupleGroupList( DBData aDbData, int type, PersonList aPersonList )
   {
      super( aDbData, type, Person.RECORDTYPE_PERSON, aPersonList );
   }

   public CoupleGroupList( DBData aDbData, HttpServletRequest request, String pageGroupPrefix )
   {
      super( aDbData );

      String queryString = "SELECT * FROM EntityGroup, GROUPMEMBERMAP, COUPLEGROUPINFO ";
      if ( !request.getParameter( "weddingdatetype" ).equals( "0" )) queryString += ", EVENTS ";
      queryString += " WHERE ";

      DBQuery aDBQuery = Person.getDBQuery( "PERSON", dbData, request, pageGroupPrefix, -1, -1, Person.OWNERTYPE_CLIENT );
      boolean queryNullFlag = true;
      if ( !aDBQuery.isNull() )
      {
         // person info specified....
         PersonList aPersonList = new PersonList( dbData, request, pageGroupPrefix, -1, -1, Person.OWNERTYPE_CLIENT, -1 );
         queryString += getPersonListSubClause(aPersonList);
         queryNullFlag = false;
      }
      String status[] = request.getParameterValues( "status" );
      {
         if ( status.length > 0 )
         {
            if ( !queryNullFlag ) queryString += " AND ";
            queryString += " (";
            for ( int i = 0; i < status.length; i++ )
            {
               if ( i > 0 ) queryString += " OR ";

               if ( status[i].equals("999") )
               {
                  for ( int j = 1; j < CoupleGroupInfo.STATUSTEXT.length; j++ )
                  {
                     if ( j > 1 ) queryString += " OR ";
                     queryString += " COUPLEGROUPINFO.STATUS = " + j;
                  }
                  break;
               }
               else
               {
                  queryString += " COUPLEGROUPINFO.STATUS = " + status[i];
               }
            }
            queryString += ")";
            queryNullFlag = false;
         }
      }
      if ( (!queryNullFlag) && (!request.getParameter( "weddingdatetype" ).equals( "0" ))) queryString += " AND ";

      String theDate = request.getParameter( "createDateYear")+"-"+request.getParameter( "createDateMonth")+"-"+request.getParameter( "createDateDay");

      if ( request.getParameter( "weddingdatetype" ).equals( "1" )) queryString += " EVENTS.DATE < '"+theDate+"'";
      if ( request.getParameter( "weddingdatetype" ).equals( "2" )) queryString += " EVENTS.DATE = '"+theDate+"'";
      if ( request.getParameter( "weddingdatetype" ).equals( "3" )) queryString += " EVENTS.DATE > '"+theDate+"'";


      queryString += " AND GROUPMEMBERMAP.GROUPNUM = EntityGroup.GROUPNUM AND EntityGroup.TYPE = " + EntityGroup.TYPE_COUPLE ;
      queryString += " AND COUPLEGROUPINFO.OWNERID = EntityGroup.GROUPNUM ";
      if ( !request.getParameter( "weddingdatetype" ).equals( "0" )) queryString += " AND EVENTS.OWNERTYPE=3 AND (EVENTS.OWNERID = EntityGroup.GROUPNUM) AND (EVENTS.DESCRIPTION = 'Ceremony')";

      buildList( queryString, 999 );
      removeDuplicates( EntityGroup.GROUPNUM );
   }


   public CoupleGroupList( DBData aDbData, HttpServletRequest request, String pageGroupPrefix, boolean personOnly )
   {
      super( aDbData );

      String queryString = "SELECT * FROM EntityGroup, GROUPMEMBERMAP, COUPLEGROUPINFO ";
      queryString += " WHERE ";

      DBQuery aDBQuery = Person.getDBQuery( "PERSON", dbData, request, pageGroupPrefix, -1, -1, Person.OWNERTYPE_CLIENT );
      boolean queryNullFlag = true;
      if ( !aDBQuery.isNull() )
      {
         // person info specified....
         PersonList aPersonList = new PersonList( dbData, request, pageGroupPrefix, -1, -1, Person.OWNERTYPE_CLIENT, -1 );
         queryString += getPersonListSubClause(aPersonList);
         queryNullFlag = false;
      }

      queryString += " AND GROUPMEMBERMAP.GROUPNUM = EntityGroup.GROUPNUM AND EntityGroup.TYPE = " + EntityGroup.TYPE_COUPLE ;
      queryString += " AND COUPLEGROUPINFO.OWNERID = EntityGroup.GROUPNUM ";

      buildList( queryString, 999 );
      removeDuplicates( EntityGroup.GROUPNUM );
   }

   public CoupleGroupList( DBData aDbData, HttpServletRequest request, String pageGroupPrefix, boolean dummy, boolean dateOnly )
   {
      super( aDbData );

      String queryString = "SELECT * FROM EntityGroup, GROUPMEMBERMAP, COUPLEGROUPINFO, EVENTS WHERE ";

      String theDate = request.getParameter( "createDateYear")+"-"+request.getParameter( "createDateMonth")+"-"+request.getParameter( "createDateDay");

      if ( request.getParameter( "weddingdatetype" ).equals( "1" )) queryString += " EVENTS.DATE < '"+theDate+"'";
      if ( request.getParameter( "weddingdatetype" ).equals( "2" )) queryString += " EVENTS.DATE = '"+theDate+"'";
      if ( request.getParameter( "weddingdatetype" ).equals( "3" )) queryString += " EVENTS.DATE > '"+theDate+"'";

      queryString += " AND GROUPMEMBERMAP.GROUPNUM = EntityGroup.GROUPNUM AND EntityGroup.TYPE = " + EntityGroup.TYPE_COUPLE ;
      queryString += " AND COUPLEGROUPINFO.OWNERID = EntityGroup.GROUPNUM ";
      queryString += " AND EVENTS.OWNERTYPE=3 AND (EVENTS.OWNERID = EntityGroup.GROUPNUM) AND (EVENTS.DESCRIPTION = 'Ceremony')";

      buildList( queryString, 999 );
      removeDuplicates( EntityGroup.GROUPNUM );
   }

   public CoupleGroupList( DBData aDbData, HttpServletRequest request, String pageGroupPrefix, boolean dummy, boolean dummy2, int age )
   {
      super( aDbData );

      String queryString = "SELECT * FROM EntityGroup, GROUPMEMBERMAP, COUPLEGROUPINFO WHERE ";

      queryString += " GROUPMEMBERMAP.GROUPNUM = EntityGroup.GROUPNUM AND EntityGroup.TYPE = " + EntityGroup.TYPE_COUPLE ;
      queryString += " AND COUPLEGROUPINFO.OWNERID = EntityGroup.GROUPNUM ";
      queryString += " AND COUPLEGROUPINFO.CREATEDATE > '2009-06-01' ";

      buildList( queryString, 999 );
      removeDuplicates( EntityGroup.GROUPNUM );
   }

   public CoupleGroupList( DBData aDbData, String queryName )
   {
      super( aDbData );
      SavedQuery savedQuery = new SavedQuery( dbData, queryName );

      buildList( savedQuery.getQueryString(), 999 );
      removeDuplicates( EntityGroup.GROUPNUM );
   }
}
