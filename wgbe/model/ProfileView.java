package jwm.wgbe.model;
import jwm.wgbe.model.db.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;

public class ProfileView extends ProfileViewBase
{
   public boolean inclAbstract    = false;
   public boolean inclAddress     = false;
   public boolean inclAudio       = false;
   public boolean inclAvatar      = false;
   public boolean inclCategories  = false;
   public boolean inclContactInfo = false;
   public boolean inclDebug       = false;
   public boolean inclDescription = false;
   public boolean inclDetails     = false;
   public boolean inclEvents      = false;
   public boolean inclImages      = false;
   public boolean inclMap         = false;
   public boolean inclNdxId       = false;
   public boolean inclSocialMedia = false;
   public boolean inclSpecials    = false;
   public boolean inclTestimonials= false;
   public boolean inclVideo       = false;
   public boolean inclVirtualTours= false;

   public int avatarWidth = 150;
   public int avatarHeight= 150;

   public int truncateAbstract    = -1;

   public int singleProfile = -1;

   public int singleCategoryId= -1;

   public boolean useProfileSets= false;
   public int     profileSetSize = 99999;
   public int     profileSetMinimum = 0;

   public boolean randomize = false;
   public boolean randomStart = false;
   public boolean sortAscending = true;

   public int     profileSetId = 1;

   public boolean doSearch = false;
   public String  searchString = "";
}
