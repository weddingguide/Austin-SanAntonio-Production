package jwm.entity;
import jwm.entity.db.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StdCSVPhoneView extends PhoneViewBase
{
   public StdCSVPhoneView( HttpServletRequest request )
   {
      super();
      showPhoneNumber = true;
   }
}
