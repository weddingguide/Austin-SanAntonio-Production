package jwm.wgbe;

import jwm.db.*;
import jwm.entity.*;
import jwm.image.*;
import jwm.wgbe.*;
import jwm.wgbe.model.*;
import jwm.logger.*;
import jwm.servletdb.*;
import org.w3c.dom.*;


public class WGBEXMLDataAccess extends WGBEDataAccess
{
   public WGBEXMLDataAccess( DBData dbData, WGBEDataAccessCtrl aWGBEDataAccessCtrl )
   {
      super( dbData, aWGBEDataAccessCtrl );
   }

   public String export()
   {
      buildDOM();
      return( super.toXML() );
   }

   public void buildDOM()
   {
      doc.appendChild( doc.createElement("WGBE") );

      dbData.getLog().logEvent( "buildDOM()" + doc );

      if ( ctrl.inclRegion )                appendChild(region.getElement(), "WGBE");

      if ( ctrl.inclMobileHome )            appendChild( mobileHome.getElement(), "region" );
      if ( ctrl.inclPageData   )            appendChild( pageData.getElement(), "region" );
      if ( ctrl.inclBanners    )            appendChild( banners.getElement(), "region" );
      if ( ctrl.inclBlog       )            appendChild( blogPostList.getElement(), "region" );
      if ( ctrl.inclStaticContent )         appendChild( staticContentList.getElement(), "region" );
      if ( ctrl.inclMobileMore )            appendChild( mobileMoreList.getElement(), "region" );
      if ( ctrl.inclSpecials)               appendChild( specialList.getElement(), "region" );
      if ( ctrl.inclEvents )                appendChild( eventList.getElement(), "region" );
      if ( ctrl.inclCategories )            appendChild( categoryList.getElement("categories" ), "region" );
      if ( ctrl.inclFeaturedCategories )    appendChild( featuredCategoryList.getElement("featuredcategories" ), "region" );
      if ( ctrl.inclFeaturedProfiles   )    appendChild( featuredProfileList.getElement("featuredprofiles" ), "region" );
      if ( ctrl.inclCategorySummary )       appendChild( summaryCategoryList.getElement("categorysummary" ), "region" );
      if ( ctrl.inclLeads )                 appendChild( leadList.getElement(), "WGBE" );
      if ( ctrl.inclArticles )              appendChild( articleSets.getElement(), "region" );
   }
}
