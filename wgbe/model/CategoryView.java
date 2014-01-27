package jwm.wgbe.model;
import jwm.wgbe.model.db.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;

public class CategoryView extends CategoryViewBase
{
   private ProfileView profileView = null;
   public  void        setProfileView( ProfileView aProfileView ) { profileView = aProfileView; }
   public  ProfileView getProfileView()    { return(profileView); }

   private ProfileView spotlightProfileView = null;
   public  void        setSpotlightProfileView( ProfileView aSpotlightProfileView ) { spotlightProfileView = aSpotlightProfileView; }
   public  ProfileView getSpotlightProfileView() { return(spotlightProfileView); }


   public boolean inclDetails           = false;
   public boolean inclDescription       = false;
   public boolean inclProfiles          = false;
   public boolean inclSpotlightProfiles = false;
   public boolean inclImage             = false;
   public boolean inclDebug             = false;

   public int     imageWidth = 0;
   public int     imageHeight= 0;

   public int singleCategory = -1;

   public CategoryView()
   {
      super();
   }

}
