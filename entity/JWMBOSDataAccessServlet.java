package jwm.entity;

import java.io.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import jwm.db.*;
import jwm.entity.*;
import jwm.project.*;
import jwm.jsputils.*;
import jwm.image.*;
import jwm.entity.*;
import jwm.entity.model.*;
import jwm.logger.*;
import jwm.servletdb.*;

public abstract class JWMBOSDataAccessServlet extends DataAccessServlet
{
   protected JWMBOSDataAccess dataAccess = null;

   public abstract JWMBOSDataAccess createDataAccessModel( DBData dbData, JWMBOSDataAccessCtrl dataAccessCtrl );
   public abstract String         export();
   public abstract String getContentType();



   public String getJNDIContext()
   {
      return( "jdbc/jwmbos" );
   }

   public DataVersionHandler getVersionHandler( HttpServletRequest request )
   {
      return( new DefaultDataVersionHandler( request ) );
   }

   public String getResponseData( DBData dbData, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
   {
      System.out.println( "entering JWMBOSDataAccessServlet" );

      if ( request.getParameter( "cached" ) != null ) return( export(request) ); // return data that has been cached in the session object from a prev call

      JSPUtils jspUtils = new JSPUtils(request);

      // define the view object that will be used to populate the model objects and to control what tags are exported

      JWMBOSDataAccessCtrl jwmbosDataAccessCtrl = new JWMBOSDataAccessCtrl();


// ================== Contacts

      if ( request.getParameter( "contacts" ) != null )
      {
         System.out.println( "jwmbos.xml  - contacts" );
         jwmbosDataAccessCtrl.inclContacts = true;

//       jwmbosDataAccessCtrl.contactDataAccessCtrl.inclSearch = true;
//       jwmbosDataAccessCtrl.contactDataAccessCtrl.search = "roosk";
         jwmbosDataAccessCtrl.contactDataAccessCtrl.inclByFollowUp = true;
         jwmbosDataAccessCtrl.contactDataAccessCtrl.followUpStatus = 2;

         jwmbosDataAccessCtrl.contactDataAccessCtrl.inclByEventDateRange = true;

         if ( request.getParameter( "members" ) != null )
         {
            jwmbosDataAccessCtrl.contactDataAccessCtrl.inclMembers = true;
            jwmbosDataAccessCtrl.contactDataAccessCtrl.personDataAccessCtrl.inclFromPersonList = true;
         }

         if ( request.getParameter( "projects" ) != null )
         {
            jwmbosDataAccessCtrl.contactDataAccessCtrl.inclProjects = true;
            jwmbosDataAccessCtrl.contactDataAccessCtrl.projectDataAccessCtrl.inclByOwner = true;
            jwmbosDataAccessCtrl.contactDataAccessCtrl.projectDataAccessCtrl.inclEvents = true;
            jwmbosDataAccessCtrl.contactDataAccessCtrl.projectDataAccessCtrl.eventDataAccessCtrl.inclByOwner = true;
            jwmbosDataAccessCtrl.contactDataAccessCtrl.projectDataAccessCtrl.eventDataAccessCtrl.inclDate = true;
         }

         if ( request.getParameter( "account" ) != null ) jwmbosDataAccessCtrl.contactDataAccessCtrl.inclAccountStatement = true;


         if ( request.getParameter( "omitStatus" ) != null )
         {
           jwmbosDataAccessCtrl.contactDataAccessCtrl.omitStatusArray = new int[ request.getParameterValues( "omitStatus" ).length ];
           for ( int i=0; i<jwmbosDataAccessCtrl.contactDataAccessCtrl.omitStatusArray.length; i++ )
           {
              jwmbosDataAccessCtrl.contactDataAccessCtrl.omitStatusArray[i] = new Integer( request.getParameterValues( "omitStatus" )[i]).intValue();
           }
         }
      }

      if ( request.getParameter( "statusCounts" ) != null )
      {
         ProjectStatusList pStatusList = new ProjectStatusList( dbData, 1030, true );
         jwmbosDataAccessCtrl.contactDataAccessCtrl.statusArray = new int[ pStatusList.getRecordList().length ];


         for ( int i = 0; i < pStatusList.getRecordList().length; i++ )
         {
            ProjectStatus pStatus = (ProjectStatus) pStatusList.getRecordList()[i];
            jwmbosDataAccessCtrl.contactDataAccessCtrl.statusArray[i] = pStatus.getId();
         }

         jwmbosDataAccessCtrl.inclContacts                                 = true;
         jwmbosDataAccessCtrl.contactDataAccessCtrl.separateLists          = true;

      }
// =================== Catalogs

      if ( request.getParameter( "catalogs" ) != null )
      {
         System.out.println( "jwmbos.xml  - catalogs" );
         jwmbosDataAccessCtrl.inclCatalogs = true;

         if ( request.getParameter( "productGroupId" ) != null )
         {
            System.out.println( "jwmbos.xml  - productGroupId" );
            jwmbosDataAccessCtrl.catalogDataAccessCtrl.productGroupId = jspUtils.getIntParm( "productGroupId" );
         }
      }

      if ( request.getParameter( "catalog" ) != null )
      {
         System.out.println( "jwmbos.xml  - single catalog" );
         jwmbosDataAccessCtrl.inclCatalogs = true;
         jwmbosDataAccessCtrl.catalogDataAccessCtrl.singleCategoryId = jspUtils.getIntParm( "catalog" );
      }

      if ( request.getParameter( "merchants" ) != null ) jwmbosDataAccessCtrl.catalogDataAccessCtrl.inclMerchant = true;
      if ( request.getParameter( "products"  ) != null ) jwmbosDataAccessCtrl.catalogDataAccessCtrl.inclProducts  = true;



      // build the entire model data tree
      dataAccess = createDataAccessModel( dbData, jwmbosDataAccessCtrl );

      // export the model
      dbData.getLog().logEvent( "JWMBOSDataAccessServlet - export()" );
      String data = export();

      return( data );
   }

   public String  export( HttpServletRequest request )
   {
      System.out.println( "retrieving XML doc from session-- " + request.getSession().getId() );
      String data = (String) request.getSession().getAttribute( "xmlModel" );
      return( data );
   }

}

