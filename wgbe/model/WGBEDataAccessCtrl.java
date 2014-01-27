package jwm.wgbe.model;
import jwm.wgbe.model.db.*;
import jwm.wgbe.*;
import jwm.article.*;
import jwm.article.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;

public class WGBEDataAccessCtrl extends ProfileViewBase
{
   public boolean inclRegion                  = false;
   public boolean inclArticles                = false;
   public boolean inclMobileHome              = false;
   public boolean inclMobileMore              = false;
   public boolean inclSpecials                = false;
   public boolean inclEvents                  = false;
   public boolean inclCategories              = false;
   public boolean inclCategorySummary         = false;
   public boolean inclFeaturedCategories      = false;
   public boolean inclFeaturedProfiles        = false;
   public boolean inclDebug                   = false;
   public boolean inclLeads                   = false;
   public boolean inclBanners                 = false;
   public boolean inclPageData                = false;
   public boolean inclStaticContent           = false;
   public boolean inclBlog                    = false;
   public boolean inclContactFormData         = false;
   public boolean popupPageFlag               = false;

   public int     blogPostCount               = 1;
   public int     specialsCount               = 99999;
   public boolean randomizeSpecials           = false;
   public int     eventsCount                 = 99999;
   public boolean randomizeEvents             = false;

   // All ctrl objects used in model creation should be defined here or nested inside these ctrl objects

   private CategoryCtrl categoryCtrl = null;
   public  void         setCategoryCtrl( CategoryCtrl aCategoryCtrl ) { categoryCtrl = aCategoryCtrl; }
   public  CategoryCtrl getCategoryCtrl()    { return(categoryCtrl); }

   private CategoryCtrl categorySummaryCtrl = null;
   public  void         setCategorySummaryCtrl( CategoryCtrl aCategorySummaryCtrl ) { categorySummaryCtrl = aCategorySummaryCtrl; }
   public  CategoryCtrl getCategorySummaryCtrl() { return(categorySummaryCtrl); }

   private CategoryCtrl featuredCategoryCtrl = null;
   public  void         setFeaturedCategoryCtrl( CategoryCtrl aFeaturedCategoryCtrl ) { featuredCategoryCtrl = aFeaturedCategoryCtrl; }
   public  CategoryCtrl getFeaturedCategoryCtrl() { return(featuredCategoryCtrl); }

   private ProfileCtrl  featuredVendorProfileCtrl = null;
   public  void         setFeaturedVendorProfileCtrl( ProfileCtrl aFeaturedVendorProfileCtrl ) { featuredVendorProfileCtrl = aFeaturedVendorProfileCtrl; }
   public  ProfileCtrl  getFeaturedVendorProfileCtrl() { return(featuredVendorProfileCtrl); }

   private LeadCtrl leadCtrl = null;
   public  void     setLeadCtrl( LeadCtrl aLeadCtrl ) { leadCtrl = aLeadCtrl; }
   public  LeadCtrl getLeadCtrl()    { return(leadCtrl); }

   private ArticleDataAccessCtrl articleCtrl = null;
   public  void                  setArticleCtrl( ArticleDataAccessCtrl aArticleCtrl ) { articleCtrl = aArticleCtrl; }
   public  ArticleDataAccessCtrl getArticleCtrl()              { return(articleCtrl); }


   private String region = "";
   public  void   setRegion( String aRegion ) { region = aRegion; }
   public  String getRegion()    { return(region); }

   private int categoryId = -1;
   public  void setCategoryId( int aCategoryId ) { categoryId = aCategoryId; }
   public  int getCategoryId() { return(categoryId); }

   private int profileId = -1;
   public  void setProfileId( int aProfileId ) { profileId = aProfileId; }
   public  int getProfileId() { return(profileId); }

   public String[] staticContentNames = new String[0];

   public String currPageURL = "";
   public String baseURLQueryString = "";

   public  ContactFormData contactFormData = null;

   public WGBEDataAccessCtrl()
   {
      categoryCtrl =                        new CategoryCtrl();
      categoryCtrl.setProfileCtrl(          new ProfileCtrl() );
      categoryCtrl.setSpotlightProfileCtrl( new ProfileCtrl() );

      featuredCategoryCtrl =                new CategoryCtrl();
      categorySummaryCtrl =                 new CategoryCtrl();

      featuredVendorProfileCtrl =           new ProfileCtrl();

      articleCtrl =                         new ArticleDataAccessCtrl();
   }

}
