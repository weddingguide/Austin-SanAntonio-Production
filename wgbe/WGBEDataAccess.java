package jwm.wgbe;

import jwm.db.*;
import jwm.entity.*;
import jwm.image.*;
import jwm.wgbe.*;
import jwm.wgbe.model.*;
import jwm.article.*;
import jwm.article.model.*;
import jwm.logger.*;
import jwm.servletdb.*;
import org.w3c.dom.*;


public abstract class WGBEDataAccess extends DataAccess
{
   protected WGBEDataAccessCtrl ctrl = null;

   protected Region         region = null;
   public  void           setRegion( Region aRegion ) { region = aRegion; }
   public  Region         getRegion()    { return(region); }

   protected SpecialList    specialList = null;
   public  void           setSpecialList( SpecialList aSpecialList ) { specialList = aSpecialList; }
   public  SpecialList    getSpecialList()    { return(specialList); }

   protected EventList      eventList = null;
   public  void           setEventList( EventList aEventList ) { eventList = aEventList; }
   public  EventList      getEventList()    { return(eventList); }

   protected MobileHome     mobileHome = null;
   public  void           setMobileHome( MobileHome aMobileHome ) { mobileHome = aMobileHome; }
   public  MobileHome     getMobileHome()    { return(mobileHome); }

   protected MobileMoreList mobileMoreList = null;
   public  void           setMobileMoreList( MobileMoreList aMobileMoreList ) { mobileMoreList = aMobileMoreList; }
   public  MobileMoreList getMobileMoreList() { return(mobileMoreList); }

   protected CategoryList   categoryList = null;
   public  void           setCategoryList( CategoryList aCategoryList ) { categoryList = aCategoryList; }
   public  CategoryList   getCategoryList()      { return(categoryList); }

   protected CategoryList   featuredCategoryList = null;
   public  void             setFeaturedCategoryList( CategoryList aFeaturedCategoryList ) { featuredCategoryList = aFeaturedCategoryList; }
   public  CategoryList     getFeaturedCategoryList() { return(featuredCategoryList); }

   protected ProfileList   featuredProfileList = null;
   public  void             setFeaturedProfileList( ProfileList aFeaturedProfileList ) { featuredProfileList = aFeaturedProfileList; }
   public  ProfileList     getFeaturedProfileList() { return(featuredProfileList); }

   protected CategoryList   summaryCategoryList  = null;
   public  void             setSummaryCategoryList( CategoryList aSummaryCategoryList ) { summaryCategoryList = aSummaryCategoryList; }
   public  CategoryList     getSummaryCategoryList() { return(summaryCategoryList); }

   protected ArticleModelListSet articleSets = null;
   public  void                  setArticleSets( ArticleModelListSet aArticleSets ) { articleSets = aArticleSets; }
   public  ArticleModelListSet   getArticleSets()              { return(articleSets); }



   protected LeadList leadList = null;
   public  void       setLeadList( LeadList aLeadList ) { leadList = aLeadList; }
   public  LeadList   getLeadList()      { return(leadList); }

   protected PageData pageData = null;
   public  void       setPageData( PageData aPageData ) { pageData = aPageData; }
   public  PageData   getPageData()      { return(pageData); }

   protected BannerList  banners = null;
   public  void          setBanners( BannerList aBanners ) { banners = aBanners; }
   public  BannerList    getBanners()          { return(banners); }

   protected StaticContentList staticContentList = null;
   public  void                setStaticContentList( StaticContentList aStaticContentList ) { staticContentList = aStaticContentList; }
   public  StaticContentList   getStaticContentList()      { return(staticContentList); }

   protected BlogPostList blogPostList = null;
   public  void           setBlogPostList( BlogPostList aBlogPostList ) { blogPostList = aBlogPostList; }
   public  BlogPostList   getBlogPostList()      { return(blogPostList); }




   public abstract String export();


   public WGBEDataAccess( DBData dbData, WGBEDataAccessCtrl aWGBEDataAccessCtrl )
   {
      super(dbData);

      ctrl = aWGBEDataAccessCtrl;

      region = new Region( dbData, doc, ctrl.getRegion() );

      if ( ctrl.inclPageData   )           pageData               = new PageData( dbData, doc, region, ctrl);
      if ( ctrl.inclBanners    )           banners                = new BannerList( dbData, doc, region, ctrl);
      if ( ctrl.inclStaticContent )        staticContentList      = new StaticContentList( dbData, doc, region, ctrl);
      if ( ctrl.inclBlog )                 blogPostList           = new BlogPostList( dbData, doc, region, ctrl);
      if ( ctrl.inclMobileHome )           mobileHome             = new MobileHome( dbData, doc, region);
      if ( ctrl.inclMobileMore )           mobileMoreList         = new MobileMoreList( dbData, doc, region);
      if ( ctrl.inclSpecials )             specialList            = new SpecialList( dbData, doc, region, ctrl );
      if ( ctrl.inclEvents )               eventList              = new EventList( dbData, doc, region, ctrl );
      if ( ctrl.inclCategories )           categoryList           = new CategoryList( dbData, doc, region, ctrl.getCategoryCtrl() );
      if ( ctrl.inclCategorySummary )      summaryCategoryList    = new CategoryList( dbData, doc, region, ctrl.getCategorySummaryCtrl(), true );
      if ( ctrl.inclFeaturedCategories )   featuredCategoryList   = new CategoryList( dbData, doc, region, ctrl.getFeaturedCategoryCtrl(), true, true );
      if ( ctrl.inclFeaturedProfiles   )   featuredProfileList    = new ProfileList( dbData, doc, region,  ctrl.getFeaturedVendorProfileCtrl(), true );
      if ( ctrl.inclLeads )                leadList               = new LeadList( dbData, doc, ctrl.getLeadCtrl() );
      if ( ctrl.inclArticles)              articleSets            = new ArticleModelListSet( dbData, doc, ctrl.getArticleCtrl() );

   }

}
