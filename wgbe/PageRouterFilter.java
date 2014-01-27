package jwm.wgbe;
import java.io.*;
import java.sql.*;
import java.text.*;
import javax.naming.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import jwm.db.*;
import jwm.jsputils.*;
import jwm.servletdb.*;
import jwm.entity.*;
import java.text.DateFormat;
import java.util.*;
import java.util.Date;

public class PageRouterFilter implements Filter {

   DataSource dataSource;
   private static final int businessEntityIdOffset = 0;
   private static final int businessEGIdOffset = 1;
   ServletContext servletContext = null;

   protected     DateFormat    dateFormat;
   public        void          setDateFormat( DateFormat aDateFormat ) { dateFormat = aDateFormat; }
   public        DateFormat    getDateFormat()       { return(dateFormat); }

   protected     DateFormat    timeFormat;
   public        void          setTimeFormat( DateFormat aTimeFormat ) { timeFormat = aTimeFormat; }
   public        DateFormat    getTimeFormat()       { return(timeFormat); }

   public void init(FilterConfig filterConfig) throws javax.servlet.ServletException
   {
      try
      {
         Context initContext = new InitialContext();
         Context envContext  = (Context)initContext.lookup("java:/comp/env");
         String dataSourceName = filterConfig.getInitParameter("dataSource");
         dataSource = (DataSource)envContext.lookup( dataSourceName );
         servletContext = filterConfig.getServletContext();


      }
      catch (Exception e)
      {
         System.out.println( "Page Router Filter Exception:" + e );
      }
   }

   public void destroy()
   {
       System.out.println( "Page Router Filter - destroy()");
   }


    public void doFilter(ServletRequest aRequest, ServletResponse aResponse, FilterChain filterChain)
    throws IOException, ServletException
    {

       HttpServletRequest request = (HttpServletRequest) aRequest;
       HttpServletResponse response = (HttpServletResponse) aResponse;


       TimeZone timeZone = TimeZone.getDefault();
       dateFormat = DateFormat.getDateInstance();
       dateFormat.setTimeZone(timeZone);
       timeFormat = DateFormat.getTimeInstance();
       timeFormat.setTimeZone(timeZone);

       Date currDate = new Date();
       String prefix =  dateFormat.format( currDate ) + " " + timeFormat.format( currDate ) + " ";

       int sessionKeyInt = Math.abs( request.getSession().getId().hashCode() );

       Connection connection = null;

       try
       {


          System.out.println( prefix + " " + Integer.toString(sessionKeyInt) + " Enter Page Router Filter: " + request.getRequestURI() +"?" + request.getQueryString() );

          // first decide if the url qualifies for rewrite.  If ".jsp", it is definitely a passthru
          if (( request.getRequestURI().toUpperCase().indexOf( ".JSP" ) > -1 )
              || ( request.getRequestURI().equals("/")))
          {
             System.out.println( prefix + " " + Integer.toString(sessionKeyInt) +" Page Router Filter: no rewrite -- " + request.getRequestURI() );
             filterChain.doFilter(request, response); // exit this filter and continue on...
          }
          else  // not a passthru... need to build the correct url from the aliased url and forward
          {

             int category = -1;
             int[] vendor = new int[2];
             vendor[businessEntityIdOffset]=-1;
             vendor[businessEGIdOffset]=-1;


             String rawURI = removePrefix( request.getRequestURI(), "/austin-weddings");
             rawURI = removePrefix( rawURI, "/sa-weddings");
             rawURI = removePrefix( rawURI, "/san-antonio-weddings");

             String[] parts = rawURI.substring(1).split("/");

             connection = dataSource.getConnection();

             String profileType = "";

             vendor = lookupVendor( parts[0], connection );  // check first field for vendor name
             if ( vendor[0] != -1 ) // vendor found
             {
                if (parts.length > 1) profileType = parts[1]; // this defines the _details, _video, etc. for the jsp name
             }
             else // no match on first try
             {
                if (parts.length > 1)
                {
                   vendor = lookupVendor( parts[1], connection ); // see if it matches the second field (/category/vendor)
                   if ( vendor[0] != -1 ) // vendor found
                   {
                      if (parts.length > 2) profileType = parts[2]; // this defines the _details, _video, etc. for the jsp name
                   }
                }
             }
             category = lookupCategory( parts[0], connection); // category will only be in first field

             // note the next code was added 7/29/11 due to favicon.ico request coming though and being translated to a bogus category page call (re: Anton)
             // could just check for .ico files.  But safer to do it the following way to catch everything

             if (( category == -1) && (vendor[0] == -1 )) // this can't be a category or profile page
             {
                System.out.println( prefix + " " + Integer.toString(sessionKeyInt) +" Page Router Filter: no rewrite -- " + request.getRequestURI() );
                filterChain.doFilter(request, response); // exit this filter and continue on...
             }
             else
             {
                //=======================================

                String jspName= "";
                if (vendor[0] != -1 ) // vendor found; must use profile.jsp
                {
                   jspName = "/profile";
                   if ( !profileType.equals("")) jspName += "_" + profileType;
                   jspName += ".jsp";
                   jspName += "?businssEGId="+vendor[businessEGIdOffset]+"&businessEntityId="+vendor[businessEntityIdOffset];
                   if ( category != -1 ) jspName += "&category="+category;
                }
                else // it must be a category page
                {
                   // 11-14-13 -- add support for portal page
                   DBData dbData = ServletDBData.getInstance( servletContext, "jdbc/wgbe");
                   dbData.setVersionHandler( new DefaultDataVersionHandler( request ) );

                   if (( EntityAttributeList.getAttributeValue(dbData, 6, category, 164, 0).equals( "checked" ))
                      && ( request.getParameter( "noportal" ) == null ))
                   {
                      jspName= "/category-portal.jsp?category="+category;
                   }
                   else
                   {
                      jspName= "/category.jsp?category="+category;
                   }
                }

                jspName += "&alias=true&"+request.getQueryString();
                System.out.println( prefix + " " + Integer.toString(sessionKeyInt) +" Page Router Filter fowarding to: " + jspName );
                RequestDispatcher reqDisp = servletContext.getRequestDispatcher( jspName );
                reqDisp.forward( request, response );
             }
          }
       }
       catch (Exception e)
       {
          System.out.println( prefix + " " + Integer.toString(sessionKeyInt) +" Exception in PageRouterFilter " + e);
          e.printStackTrace( System.out );
       }
       finally
       {
          try
          {
             connection.close();
          }
          catch( Exception e )
          {
             System.out.println( prefix + " " + Integer.toString(sessionKeyInt) +" Exception closing connection in PageRouterFilter " + e);
          }
       }

    }

    protected String removePrefix( String theString, String prefix )
    {
       if ( theString.indexOf( prefix ) == -1 ) return( theString);
       return( theString.substring( prefix.length() ) );
    }



    protected int lookupCategory( String name, Connection connection ) throws SQLException
    {
       ResultSet results = null;
       Statement statement = connection.createStatement();
       int rc = -1;
       String queryString = "SELECT GROUPNUM, ALIASOF from ENTITYGROUP WHERE CATEGORY=1 AND NAME like '"+name.replace('-',' ').replaceAll("'","''")+"'";
       System.out.println( "queryString: " + queryString );
       results = statement.executeQuery( queryString );

       while( results.next() )
       {
          rc = results.getInt("ALIASOF");                 // check to see if it's an alias name
          if (rc < 1) rc = results.getInt("GROUPNUM");  // no, then it's a main group name
       }
       if (rc > 0) return(rc); // found category as standard category name
        // 8/18/11 -- not found... try looking up URL-compliant vendor name attribute

       results = null;
       statement = connection.createStatement();

       queryString = "SELECT OWNERID from ENTITYATTRIBUTE WHERE "
                     + " ATTRIBUTEDATA like '"+name+"'"
                     + " AND ENTITYATTRIBUTE.OWNERTYPE = " + EntityAttribute.OWNERTYPE_WGBEVENDORCATEGORY
                     + " AND ENTITYATTRIBUTE.ATTRIBUTEDEFID = 126"
                     + " AND ENTITYATTRIBUTE.ATTRIBUTEDEFSUBID = 0;";
       results = statement.executeQuery( queryString );

       while( results.next() )
       {
          rc = results.getInt("OWNERID");
       }
       return( rc );

    }

    protected int[] lookupVendor( String name, Connection connection )  throws SQLException
    {
      int[] rc = lookupVendor1( name, 73, connection );
      if (rc[0] == -1) // url-compliant name not matched
      {
         rc = lookupVendor1( name.replace('-',' '), 1, connection); // try normal name lookup
      }
      return( rc );
    }


    protected int[] lookupVendor1( String name, int attributeId, Connection connection )  throws SQLException
    {
       ResultSet results = null;
       Statement statement = connection.createStatement();
       int[] rc = new int[2];
       rc[businessEntityIdOffset]=-1;
       rc[businessEGIdOffset]=-1;

       String queryString = "SELECT PERSONID,PERSON.OWNERID from PERSON,ENTITYATTRIBUTE WHERE " // check if it matches a base name first
                     + " ATTRIBUTEDATA like '"+name.replaceAll("'","''")+"'"
                     + " AND SITEDEFENTITYTYPE = 1"   // 3-11-11 -- Only find 'active' vendors
                     + " AND PERSONID = ENTITYATTRIBUTE.OWNERID"
                     + " AND ENTITYATTRIBUTE.OWNERTYPE = 1"
                     + " AND ENTITYATTRIBUTE.ATTRIBUTEDEFID = " + attributeId
                     + " AND ENTITYATTRIBUTE.ATTRIBUTEDEFSUBID = 0;";
       results = statement.executeQuery( queryString );

       while( results.next() )
       {
          rc[businessEntityIdOffset] = results.getInt("PERSONID");
          rc[businessEGIdOffset] = results.getInt("OWNERID");
       }
       return( rc );
    }

}

