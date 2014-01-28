package jwm.entity;
import jwm.entity.db.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;

public class ContactView extends ContactViewBase
{
   public boolean showEventDate = true;
   public boolean showEventLoc1 = true;
   public boolean showEventLoc2 = true;

   public boolean showPrimaryPerson = true;
   public boolean showPerson2Full = true;
   public boolean showPerson3Full = true;

   public PersonView personView;

   public ContactView( HttpServletRequest request )
   {
      super();
   }
}
