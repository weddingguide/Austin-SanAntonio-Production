package jwm.entity;
import jwm.entity.db.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StdCSVContactView extends ContactView
{
   public StdCSVPersonView   personView;


   public StdCSVContactView( HttpServletRequest request )
   {
      super( request );
      showPerson2Full = false;
      showPerson3Full = false;

      personView = new StdCSVPersonView( request );
   }
}
