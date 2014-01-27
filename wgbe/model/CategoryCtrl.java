package jwm.wgbe.model;
import jwm.wgbe.model.db.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;

public class CategoryCtrl extends CategoryViewBase
{
   private ProfileCtrl profileCtrl = null;
   public  void        setProfileCtrl( ProfileCtrl aProfileCtrl ) { profileCtrl = aProfileCtrl; }
   public  ProfileCtrl getProfileCtrl()    { return(profileCtrl); }

   private ProfileCtrl spotlightProfileCtrl = null;
   public  void        setSpotlightProfileCtrl( ProfileCtrl aSpotlightProfileCtrl ) { spotlightProfileCtrl = aSpotlightProfileCtrl; }
   public  ProfileCtrl getSpotlightProfileCtrl() { return(spotlightProfileCtrl); }


   public boolean inclDetails           = false;
   public boolean inclDescription       = false;
   public boolean inclProfiles          = false;
   public boolean inclSpotlightProfiles = false;
   public boolean inclImage             = false;
   public boolean inclDebug             = false;

   public int     imageWidth = 0;
   public int     imageHeight= 0;

   public int singleCategory = -1;

   public int maxCategories = -1;

   public CategoryCtrl()
   {
      super();
   }

}
