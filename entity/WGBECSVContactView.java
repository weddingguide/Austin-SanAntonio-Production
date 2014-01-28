package jwm.entity;
import jwm.entity.db.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WGBECSVContactView extends ContactView
{
   public StdCSVPersonView   personView;


   public WGBECSVContactView( HttpServletRequest request )
   {
      super( request );
      showPerson2Full = true;
      showPerson3Full = false;

      personView = new StdCSVPersonView( request );
   }
}
