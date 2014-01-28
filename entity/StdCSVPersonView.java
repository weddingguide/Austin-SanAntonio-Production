package jwm.entity;
import jwm.entity.db.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StdCSVPersonView extends PersonViewBase
{
   public StdCSVAddressView  addressView;
   public StdCSVPhoneView    phoneView;
   public StdCSVEmailView    emailView;


   public StdCSVPersonView( HttpServletRequest request )
   {
      super();
      showLastName = true;
      showFirstName = true;
      showMiddleName = true;
      showTitle = true;
      showSuffix = true;
      boolean showFamilies = true;

      addressView = new StdCSVAddressView( request );
      phoneView = new StdCSVPhoneView( request );
      emailView = new StdCSVEmailView( request );
   }
}
