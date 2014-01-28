package jwm.entity;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.db.*;
import jwm.jsputils.*;
import jwm.logger.*;
import jwm.idmanager.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StdPersonListViewHandler extends ListViewHandler
{
  protected PersonList aPersonList;
  protected int recordType = Person.RECORDTYPE_PERSON;
  protected JSPUtils jspUtils;
  protected SiteDefEntityTypeList statusList;
  protected String statusText[];

  protected Person userPerson;
  public  void    setUserPerson( Person aUserPerson ) { userPerson = aUserPerson; }
  public  Person  getUserPerson() { return(userPerson); }

  protected String pageGroupPrefix;
  public  void    setPageGroupPrefix( String aPageGroupPrefix ) { pageGroupPrefix = aPageGroupPrefix; }
  public  String  getPageGroupPrefix() { return(pageGroupPrefix); }

  protected String entityType;
  public  void    setEntityType( String aEntityType ) { entityType = aEntityType; }
  public  String  getEntityType() { return(entityType); }

  protected EntityCustomTextList customText;
  public  void                  setCustomText( EntityCustomTextList aCustomText ) { customText = aCustomText; }
  public  EntityCustomTextList  getCustomText()               { return(customText); }




   //===========================================================================
   //===========================================================================


   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param firstEntry
   *  @param entriesPerPage
   */
   //---------------------------------------------------------------------------

  public DBRecordList doQuery( int firstEntry, int entriesPerPage )
  {
     aPersonList.doQuery( firstEntry, entriesPerPage );
     return( aPersonList );
  }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   */
   //---------------------------------------------------------------------------

  public String getActionButtonString()
  {
      String output = "";

      if (( request.isUserInRole( "CISOperator" ))
         ||( request.isUserInRole( "CISViewer" )) )
      {
         if( request.getParameter( "business" ) == null )
         {
            if ( request.isUserInRole( "CISOperator" ))
            {
               output +=  "<form name='form1' method='post' action='"+pageGroupPrefix+"entry.jsp'>";
               output +=     "<input type=hidden name=personId value='-1' >";
               output +=  "   <input name='cisaction' type='submit' id='cisaction' value='Add " + entityType + "'>";
               output +=  "</form>";
            }
         }
         else
         {
           if ( request.isUserInRole( "CISOperator" ))
           {
              output += "<form name='form1' method='post' action='businessentry.jsp'>";
              output += "   <input type=hidden name=businessEGId value='-1' >";
              output += "   <input name='cisaction' type='submit' id='cisaction' value='Add Business'>";
              output += "</form>";
           }
         }


         String formAction = pageGroupPrefix + "search.jsp";
         if ( request.getParameter( "business" ) != null ) formAction = "businesssearch.jsp";

         output += "<form name='form2' method='post' action="+formAction+">";
         output += "   <input name='search' type='hidden' value='true'>";

         if ( request.getParameter( "business" ) != null )
         {
            output += "   <input type=hidden name=business value=true>";
         }
         output += "   <input name='cisaction' type='submit' id='cisaction' value='New Search'>";
         output += "</form>";


         formAction = pageGroupPrefix + "list.jsp";
         if ( request.getParameter( "business" ) != null ) formAction = "businesslist.jsp";

         if ( request.isUserInRole( "CISOperator" ))
         {
            output += "<form name='form3' method='post' action='"+formAction+"'>";
            output += "   <input type=hidden name=formInstanceId value='"+formInstanceId+"' >";
            output += "   <input type=hidden name=refreshquery value=true >";
            output += "   <font class=prompt>Save Query As:</font> <input name='queryname' type='text'>";
            output += "   <input name='cisaction' type='submit' id='cisaction' value='Save This Query'>";

            if ( request.getParameter( "business" ) != null )
            {
               output += "<input type=hidden name=business value=true>";
            }
            output += "</form>";
         }
      }
      return( output );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aPerson
   */
   //---------------------------------------------------------------------------

   public String getActionsCell(Person aPerson)
   {
      String output = "<ul>";
      if ( request.isUserInRole( "CISOperator" ))
      {
         if ( aPerson.getRecordType() == Person.RECORDTYPE_PERSON )
         {
            output += "<li>";
            output += "  <a class=smalltextlink href=/cis/jsp/operator/"+pageGroupPrefix+"entry.jsp?personId="+ aPerson.getPersonId() +"&amp;clone=true> Clone Record</a>";
            output += "</li>";
         }
         if ( request.isUserInRole( "CISManager" ) ) // change 12/5/08 per Pam Teich at JBF
         {
            output += "<li>";
            output += "   <a class=smalltextlink href=/cis/jsp/operator/"+pageGroupPrefix+"list.jsp?personId="+ aPerson.getPersonId() +"&amp;cisaction=Remove&amp;refreshQuery=true&amp;formInstanceId="+formInstanceId+" onClick='return(validateRemove());'>Remove</a>";
         }
         output += "</li>";
      }

      if ( request.isUserInRole( "IDManagerAdministrator" ))
      {
         if ( aPerson.getRecordType() == Person.RECORDTYPE_PERSON )
         {
             output += "<li>";
             Users userId = new Users( dbData, Person.OWNERTYPE_CLIENT, aPerson.getPersonId() );
             if (userId.isRecordFound() )
             {
                output += "   <a class=smalltextlink href=/idmanager/jsp/administrator/modifyuser.jsp?userName="+ userId.getUserName()+">Show UserId</a>";
             }
             else
             {
                output += "   <a class=smalltextlink href=/idmanager/jsp/administrator/createuser.jsp?ownerId="+ aPerson.getPersonId() +"&ownerType="+Person.OWNERTYPE_CLIENT+">Create UserId</a>";
             }
             output += "</li>";
         }
      }
      if ( request.isUserInRole( "GeneralLedgerOwner" ))
      {
         output += "<li>";
         output += "   <a class=smalltextlink href=/gl/jsp/user/userinvoicelist.jsp?clientId="+ aPerson.getPersonId() +">View Invoices</a>";
         output += "</li>";
      }
      if ( request.isUserInRole( "OrderOperator" ))
      {
         output += "<li>";
         output += "   <a class=smalltextlink href=/order/jsp/guest/catalog.jsp?clientId="+ aPerson.getPersonId() +"&clientType="+Person.OWNERTYPE_CLIENT+"&productGroupId=2&newcart=true>Place Order</a>";
         output += "</li>";
      }
//    output += "</ul>";
      return( tableCell(output) );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aPerson
   */
   //---------------------------------------------------------------------------

   public String getAddressCell( Person aPerson )
   {
      String output = "";
      try
      {
         if (aPerson.getPersonId() > 0 )
         {
            output += aPerson.getAddress().getAddressLine1() ;

            if (!aPerson.getAddress().getAddressLine2().equals(""))
            {
               output += "   <br>"+ aPerson.getAddress().getAddressLine2() ;
            }
            output += "   <br>"+ aPerson.getAddress().getCity() +", "+ aPerson.getAddress().getState() ;
            output += "   <br>"+ aPerson.getAddress().getPostalCode() ;
         }
      }
      catch (Exception e)
      {
      }
      return( tableCell(output) );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aPerson
   */
   //---------------------------------------------------------------------------

   public String getCheckBoxCell( Person aPerson )
   {
      String output = "";
      if ( request.isUserInRole( "CISOperator" ))
      {
         output += "   <input type=checkbox name=entityselect id=entityselect value="+aPerson.getPersonId()+">";
      }
      return( tableCell(output) );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aPerson
   */
   //---------------------------------------------------------------------------

   public String getEmailCell( Person aPerson )
   {
      String output = "";
      try
      {
         if (aPerson.getPersonId() > 0 )
         {
            String emailName = aPerson.getFirstName() + " " + aPerson.getLastName();
      //    emailName = emailName.replaceAll( "\\", "");
            emailName = emailName.replaceAll( ";", "");
            emailName = emailName.replaceAll( ",", "");

            boolean first = true;
            for ( int jj = 0; jj < customText.getInstanceCount(recordType, EntityCustomText.OBJECTTYPE_EMAIL); jj++ )
            {
               String shortText = customText.text [recordType]  [EntityCustomText.OBJECTTYPE_EMAIL]  [jj]  [EntityCustomText.TEXTTYPE_SHORT];
               if( !aPerson.getEmail(jj).getEmailAddress().equals(""))
               {
                  if ( !first) output +="<br>";
                  first = false;

                  output += "<b><i><font size=-2>("+shortText+")</font></i></b>";
                  output += "<a href='mailto:"+emailName+" <"+aPerson.getEmail(jj).getEmailAddress()+">'>"+aPerson.getEmail(jj).getEmailAddress()+"</a>";
               }
            }
         }
      }
      catch (Exception e)
      {
      }
      return( tableCell(output) );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   */
   //---------------------------------------------------------------------------

  public String getLastRowString()
  {
     String output = "";
     if ( request.isUserInRole( "MailListOperator" ))
     {
        output += "<tr>";
        output += "  <td colspan=6>";
        output += "    <img name=arrow id=arrow src='../../images/arrow_ltr.gif'><input type=submit name=personselect id=personselect value='Send Email to Selected Names'>";
        output += "  </td>";
        output += "</tr>";
     }
     return( output );
  }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aPerson
   */
   //---------------------------------------------------------------------------

   public String getNameCell( Person aPerson )
   {
      String output = "";
      if ( request.isUserInRole( "CISOperator" ))
      {
         if ( aPerson.getRecordType() == Person.RECORDTYPE_PERSON )
         {
            output += "<a class=normallink href=/cis/jsp/operator/"+pageGroupPrefix+"entry.jsp?personId="+ aPerson.getPersonId() + "&formAction=/cis/jsp/operator/"+pageGroupPrefix+"list.jsp>";
            output +=      aPerson.getLastName() + ", " + aPerson.getFirstName();
            output += "</a>";
         }
         else
         {
            output += "<a class=normallink href=/cis/jsp/operator/businessentry.jsp?businessEGId="+ aPerson.getOwnerId() +">";
            output += aPerson.getLastName();
            output += "</a>";
         }
      }
      else if ( !request.isUserInRole( "CISViewer" ))  //  NOT Operator and NOT Viewer... just valid for user's own stuff
      {
         if ( aPerson.getRecordType() == Person.RECORDTYPE_PERSON )
         {
            output += "<a class=normallink href=/cis/jsp/operator/"+pageGroupPrefix+"entry.jsp?personId="+ aPerson.getPersonId() +">";
            output +=     aPerson.getLastName() + ", " + aPerson.getFirstName();
            output += "</a>";
         }
         else
         {
            output += "<a class=normallink href=/cis/jsp/operator/businessentry.jsp?businessEGId="+ aPerson.getOwnerId() +">";
            output +=     aPerson.getLastName();
            output += "</a>";
         }
      }
      else // this should be VIEWER only
      {
         if ( aPerson.getRecordType() == Person.RECORDTYPE_PERSON )
         {
            output += "<a class=normallink href=/cis/jsp/operator/"+pageGroupPrefix+"view.jsp?personId="+ aPerson.getPersonId() +">";
            output +=     aPerson.getLastName() + ", " + aPerson.getFirstName();
            output += "</a>";
         }
         else
         {
            output += "<a class=normallink href=/cis/jsp/operator/businessview.jsp?businessEGId="+ aPerson.getOwnerId() +">";
            output +=     aPerson.getLastName();
            output += "</a>";
         }
      }
      return( tableCell(output) );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aPerson
   */
   //---------------------------------------------------------------------------

   public String getPhoneCell( Person aPerson )
   {
      String output = "";
      try
      {
         if (aPerson.getPersonId() > 0 )
         {
            boolean first = true;
            for ( int jj = 0; jj < customText.getInstanceCount(recordType, EntityCustomText.OBJECTTYPE_PHONE); jj++ )
            {
               String shortText = customText.text [recordType]  [EntityCustomText.OBJECTTYPE_PHONE]  [jj]  [EntityCustomText.TEXTTYPE_SHORT];
               if( !aPerson.getPhone(jj).getPhoneNumber().equals(""))
               {
                  if ( !first) output +="<br>";
                  first = false;

                  output += "<b><i><font size=-2>("+shortText+")</font></i></b>";
                  output += aPerson.getPhone(jj).getPhoneNumber() ;
               }
            }
         }
      }
      catch (Exception e)
      {
      }
      return( tableCell(output) );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   */
   //---------------------------------------------------------------------------

  public String getQueryString()
  {
     if (( !request.isUserInRole( "CISOperator" ))         // this is user-level... only show user's asso businesses
        ||( jspUtils.getIntParm( "personId") == -2 ))        // if operator auth, still need a way to force 'mine only'
     {
        aPersonList = new PersonList( dbData, userPerson.getPersonId(), true, false ); // just set up query... this constructor will not execute it
     }
     else if ( additionalQueryData != -1 )  // 1-30-07 -- this is a way to pass a personId in that was created from form
     {
        aPersonList = new PersonList( dbData, false, additionalQueryData); // just set up query... this constructor will not execute it
     }
     else if ( request.getParameter( "personId" ) != null )  // 12-30-06 -- if refreshing after a contact entry create/change, just list the one that was being worked on
     {
        aPersonList = new PersonList( dbData, false, jspUtils.getIntParm( "personId" ) ); // just set up query... this constructor will not execute it
     }
     else if ( request.getParameter( "search" ) != null )  // 1/15/12 -- v2 sidebar person search
     {
        aPersonList = new PersonList( dbData, request.getParameter( "search" ));
     }
     else if ( request.getParameter( "GroupList" ) != null )
     {
        aPersonList = new PersonList( dbData, EntityGroup.TYPE_GENERAL, jspUtils.getIntParm( "groupNum" ), recordType, request, false ); // just set up query... this constructor will not execute it
     }
     else if ( request.getParameter( "SearchByCreateDate" ) != null )
     {
        String theDate = request.getParameter( "createDateYear")+"-"+request.getParameter( "createDateMonth")+"-"+request.getParameter( "createDateDay");
        aPersonList = new PersonList( dbData, theDate, recordType, false ); // just set up query... this constructor will not execute it
     }
     else if ( request.getParameter( "SearchByLastUpdate" ) != null )
     {
        String theDate = request.getParameter( "lastUpdateYear")+"-"+request.getParameter( "lastUpdateMonth")+"-"+request.getParameter( "lastUpdateDay");
        aPersonList = new PersonList( dbData, theDate, recordType, false ); // just set up query... this constructor will not execute it
     }
     else if ( request.getParameter( "Search2011ChristmasCardList" ) != null )
     {
        EntityGroupList groupList = new EntityGroupList( dbData, "Christmas Card List 2011", true );
        aPersonList = new PersonList( dbData, groupList, false ); // just set up query... this constructor will not execute it
     }
     else if ( request.getParameter( "SavedSearch" ) != null )
     {
        SavedQuery savedQuery = new SavedQuery( dbData, request.getParameter( "savedquery")  );
        aPersonList.setQueryString( savedQuery.getQueryString() );
     }
     else
     {

        int status = Person.STATUS_ACTIVE;
        if (request.getParameter( "removed") != null ) status = Person.STATUS_REMOVED;
        aPersonList = new PersonList( dbData, request, pageGroupPrefix, -1, -1, -1, recordType, false, status);  // just set up query... this constructor will not execute it
     }
     return( aPersonList.getQueryString() );
  }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param aPerson
   */
   //---------------------------------------------------------------------------

   public String getStatusCell( Person aPerson )
   {
      String output = "";
      if ( request.isUserInRole( "CISOperator" ))
      {
         if ( statusList.getRecordList().length > 0 )
         {
            output += "<td>";
            output += "<li>"+statusText[ aPerson.getSiteDefEntityType() ];
            output += "<li>Created: " + aPerson.getCreateDate();
            output += "<li>Updated: " + aPerson.getLastUpdate();
            output += "</td>";
         }
      }
      return( output );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   */
   //---------------------------------------------------------------------------

  public String getTableHeaderString()
  {
     String output = "";
     if ( request.isUserInRole( "CISOperator" ))
     {
        output += "<th>&nbsp;</th>";
        if ( statusList.getRecordList().length > 0 )
        {
           output += "<th>Status</th>";
        }
     }
     output += "<th>Name</th>";
     output += "<th>"+customText.text [recordType]  [EntityCustomText.OBJECTTYPE_ADDRESS]  [0]  [EntityCustomText.TEXTTYPE_LONG]+"</th>";

     output += "<th>Phone</th>";
     output += "<th>Email Address</th>";
     output += "<th>&nbsp;</th>";
     return( output );
  }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param ndx
   */
   //---------------------------------------------------------------------------

   public String getTableRowString(int ndx)
   {
      Person aPerson = (Person)aPersonList.getRecordList()[ndx];
      String output = "";

      output += getCheckBoxCell( aPerson );
      output += getStatusCell( aPerson );
      output += getNameCell( aPerson );
      output += getAddressCell( aPerson );
      output += getPhoneCell( aPerson );
      output += getEmailCell( aPerson );
      output += getActionsCell( aPerson );

      return( output );
   }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @param DBData
   *  @param aDbData
   *  @param aRequest
   */
   //---------------------------------------------------------------------------

  public void init( DBData aDbData, HttpServletRequest aRequest )
  {
     dbData = aDbData;
     request = aRequest;
     jspUtils = new JSPUtils( request );

     aPersonList = new PersonList( dbData );

     if ( request.getParameter( "business" ) != null ) recordType = Person.RECORDTYPE_BUSINESS_ORG;


     statusList = new SiteDefEntityTypeList( dbData, recordType );
     if ( statusList.getRecordList().length > 0 )
     {
        statusText = new String[ statusList.getRecordList().length + 1 ];
        statusText[0] = "<unknown>";
     }

     for ( int i = 0; i < statusList.getRecordList().length; i++ )
     {
         SiteDefEntityType aType = (SiteDefEntityType) statusList.getRecordList()[i];
         statusText[ aType.getId() ] = aType.getName();
     }
  }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @return ...
   *  @param ndx
   */
   //---------------------------------------------------------------------------

  public boolean RemoveRecord(int ndx)
  {
     return(true);
  }


   //===========================================================================
   //===========================================================================



   //---------------------------------------------------------------------------
   /**
   *  ...
   *  @author Jerry Malcolm
   *  @param aQueryString
   */
   //---------------------------------------------------------------------------

  public void setQueryString( String aQueryString )
  {
     queryString = aQueryString;
     aPersonList.setQueryString( queryString );
  }

  public String getFormURLExtension()
  {
     if (recordType==Person.RECORDTYPE_BUSINESS_ORG) return( "&business=*");
     else return( "" );
  }

  public int getTotalRecordCount()
  {
     return( aPersonList.getTotalRecordCount());
  }

  public String tableCell( String data )
  {
     if ( data.equals( "" ) ) return( "<td>&nbsp;</td>" );
     else return( "<td>"+data+"</td>");
  }

  public String tableCell( int data )
  {
     return( tableCell( new Integer( data ).toString() ));
  }

}
