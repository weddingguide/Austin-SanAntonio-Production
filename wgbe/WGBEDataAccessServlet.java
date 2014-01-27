package jwm.wgbe;

import java.io.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import jwm.db.*;
import jwm.entity.*;
import jwm.jsputils.*;
import jwm.image.*;
import jwm.wgbe.*;
import jwm.wgbe.model.*;
import jwm.logger.*;
import jwm.servletdb.*;

public abstract class WGBEDataAccessServlet extends DataAccessServlet
{
   protected WGBEDataAccess dataAccess = null;

   public abstract WGBEDataAccess createDataAccessModel( DBData dbData, WGBEDataAccessCtrl dataAccessCtrl );
   public abstract String         export();
   public abstract String getContentType();



   public String getJNDIContext()
   {
      return( "jdbc/wgbe" );
   }

   public DataVersionHandler getVersionHandler( HttpServletRequest request )
   {
      return( new WGBEDataVersionHandler( request ) );
   }

   public String getResponseData( DBData dbData, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
   {
      if ( request.getParameter( "cached" ) != null ) return( export(request) ); // return data that has been cached in the session object from a prev call


      JSPUtils jspUtils = new JSPUtils(request);

      // define the view object that will be used to populate the model objects and to control what tags are exported

      WGBEDataAccessCtrl wgbeDataAccessCtrl = new WGBEDataAccessCtrl(); // note -- this constructor builds all additional view objects

      wgbeDataAccessCtrl.contactFormData = (ContactFormData) request.getSession().getAttribute("contactFormData");
      if (wgbeDataAccessCtrl.contactFormData == null)
      {
         wgbeDataAccessCtrl.contactFormData = new ContactFormData();
      }

      wgbeDataAccessCtrl.setRegion( request.getParameter( "region" ));

      wgbeDataAccessCtrl.inclRegion = true;  // set true by default... but may be turned off below, such as with LeadList

      if ( request.getParameter( "mobilehome" )         != null ) wgbeDataAccessCtrl.inclMobileHome = true;
      if ( request.getParameter( "mobilemore" )         != null ) wgbeDataAccessCtrl.inclMobileMore  = true;
      if ( request.getParameter( "specials" )           != null ) wgbeDataAccessCtrl.inclSpecials = true;
      if ( request.getParameter( "events" )             != null ) wgbeDataAccessCtrl.inclEvents = true;
      if ( request.getParameter( "pagedata" )           != null ) wgbeDataAccessCtrl.inclPageData = true;
      if ( request.getParameter( "contactFormData" )    != null ) wgbeDataAccessCtrl.inclContactFormData = true;
      if ( request.getParameter( "banners" )            != null ) wgbeDataAccessCtrl.inclBanners  = true;
      if ( request.getParameter( "categorysummary" )    != null ) wgbeDataAccessCtrl.inclCategorySummary  = true;
      if ( request.getParameter( "featuredcategories" ) != null ) wgbeDataAccessCtrl.inclFeaturedCategories  = true;

      if ( request.getParameter( "featuredprofiles"   ) != null )
      {
         wgbeDataAccessCtrl.inclFeaturedProfiles    = true;
         wgbeDataAccessCtrl.getFeaturedVendorProfileCtrl().inclContactInfo  = true;
         wgbeDataAccessCtrl.getFeaturedVendorProfileCtrl().inclAvatar       = true;
         wgbeDataAccessCtrl.getFeaturedVendorProfileCtrl().inclAbstract     = true;
         wgbeDataAccessCtrl.getFeaturedVendorProfileCtrl().inclNdxId        = true;
         wgbeDataAccessCtrl.getFeaturedVendorProfileCtrl().truncateAbstract = 85;
         wgbeDataAccessCtrl.getFeaturedVendorProfileCtrl().profileSetSize   = 8;
      }

      if ( request.getParameter( "blog" )               != null ) wgbeDataAccessCtrl.inclBlog                = true;
      if ( request.getParameter( "debug"  )             != null )
      {
         wgbeDataAccessCtrl.inclDebug  = true;
         wgbeDataAccessCtrl.getCategoryCtrl().inclDebug = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclDebug = true;
      }

      if ( request.getParameter( "homepage"  )             != null )
      {
         wgbeDataAccessCtrl.inclStaticContent       = true;
         String[] staticContentNames                = { "Home Page Main",
                                                        "Promo Block 1",
                                                        "Promo Block 2",
                                                        "Promo Block 3",
                                                        "BrideTalk"
                                                      };
         wgbeDataAccessCtrl.staticContentNames      = staticContentNames;

      }

      if ( request.getParameter( "categories" ) != null )
      {
         wgbeDataAccessCtrl.getCategoryCtrl().inclProfiles = true;
         wgbeDataAccessCtrl.inclCategories  = true;
      }

      if ( request.getParameter( "category" ) != null )
      {
         wgbeDataAccessCtrl.getCategoryCtrl().singleCategory = jspUtils.getIntParm( "category" );
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().singleCategoryId = jspUtils.getIntParm( "category" ); // needs to be passed to profilelist as well
         wgbeDataAccessCtrl.getCategoryCtrl().getSpotlightProfileCtrl().singleCategoryId = jspUtils.getIntParm( "category" ); // needs to be passed to profilelist as well

         String search = request.getParameter( "search" );
         if ( search != null )
         {
            wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().doSearch = true;
            wgbeDataAccessCtrl.getCategoryCtrl().getSpotlightProfileCtrl().doSearch = true;

            wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().searchString = search;
            wgbeDataAccessCtrl.getCategoryCtrl().getSpotlightProfileCtrl().searchString = search;
         }


         wgbeDataAccessCtrl.inclCategories  = true;
         wgbeDataAccessCtrl.getCategoryCtrl().inclProfiles = true;


         if ( request.getParameter( "page" ) != null )
         {
            wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().useProfileSets  = true;
            wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().profileSetSize  = 14;
            wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().profileSetId  = jspUtils.getIntParm( "page" );
         }
         if ( request.getParameter( "spotlight" ) != null )
         {
            wgbeDataAccessCtrl.getCategoryCtrl().inclSpotlightProfiles = true;
            wgbeDataAccessCtrl.getCategoryCtrl().getSpotlightProfileCtrl().useProfileSets  = false;
            wgbeDataAccessCtrl.getCategoryCtrl().getSpotlightProfileCtrl().profileSetSize  = 5;
            wgbeDataAccessCtrl.getCategoryCtrl().getSpotlightProfileCtrl().randomize = true;
            wgbeDataAccessCtrl.getCategoryCtrl().getSpotlightProfileCtrl().profileSetMinimum  = 8; // if less that 8 total profiles, do not include any spotlights
            wgbeDataAccessCtrl.getCategoryCtrl().getSpotlightProfileCtrl().profileSetId  = 0;
            wgbeDataAccessCtrl.getCategoryCtrl().getSpotlightProfileCtrl().inclAvatar       = true;
            wgbeDataAccessCtrl.getCategoryCtrl().getSpotlightProfileCtrl().inclCategories   = true;
            wgbeDataAccessCtrl.getCategoryCtrl().getSpotlightProfileCtrl().inclContactInfo  = true;
         }

         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclContactInfo  = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclAddress = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclDescription = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclAvatar       = true;
      }

      if ( request.getParameter( "details" ) != null ) // details view
      {
         wgbeDataAccessCtrl.getCategoryCtrl().inclDetails = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclDetails  = true;
      }

      if ( request.getParameter( "profile" ) != null ) // single profile requested?
      {
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().singleProfile = jspUtils.getIntParm( "profile" );

         wgbeDataAccessCtrl.inclCategories  = true;
         wgbeDataAccessCtrl.getCategoryCtrl().inclProfiles = true;

         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclAddress      = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclAudio        = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclAvatar       = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclCategories   = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclContactInfo  = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclDescription  = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclDetails      = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclEvents       = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclImages       = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclMap          = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclSocialMedia  = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclSpecials     = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclTestimonials = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclVirtualTours = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclVideo        = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclDescription  = true;
         wgbeDataAccessCtrl.getCategoryCtrl().getProfileCtrl().inclAbstract     = true;
      }

      if ( request.getParameter( "leads" ) != null ) // lead list for vendors
      {
         dbData.getLog().logEvent( "Get lead list - contactId - " + currUser.getOwnerId() );

         wgbeDataAccessCtrl.inclRegion = false;  // no need for a region tag in lead list xml

         wgbeDataAccessCtrl.inclLeads = true;

         wgbeDataAccessCtrl.setLeadCtrl( new LeadCtrl() );
         wgbeDataAccessCtrl.getLeadCtrl().afterDate = request.getParameter( "since" );
         wgbeDataAccessCtrl.getLeadCtrl().firstLabel = jspUtils.getIntParm( "firstLabel" ) -1; // 1-based numbering on parameter... need zero-based numbering
         wgbeDataAccessCtrl.getLeadCtrl().contactId = currUser.getOwnerId();

      }

      // build the entire model data tree
      dataAccess = createDataAccessModel( dbData, wgbeDataAccessCtrl );

      // export the model
      dbData.getLog().logEvent( "WGBEDataAccessServlet - export()" );
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

