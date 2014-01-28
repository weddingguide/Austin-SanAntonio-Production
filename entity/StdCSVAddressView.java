package jwm.entity;
import jwm.entity.db.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StdCSVAddressView extends AddressViewBase
{
   public StdCSVAddressView( HttpServletRequest request )
   {
      super();
      showAddressLine1 = true;
      showAddressLine2 = true;
      showAddressLine3 = true;
      showCity = true;
      showState = true;
      showCountry = true;
      showPostalCode = true;
   }
}
