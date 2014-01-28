package jwm.entity;
import jwm.entity.db.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StdCSVEmailView extends EmailViewBase
{
   public StdCSVEmailView( HttpServletRequest request )
   {
      super();
      showEmailAddress = true;
   }
}
