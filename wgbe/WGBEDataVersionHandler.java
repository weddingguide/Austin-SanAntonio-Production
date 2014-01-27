package jwm.wgbe;
import jwm.db.*;
import jwm.wgbe.db.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WGBEDataVersionHandler extends DataVersionHandler
{
   public WGBEDataVersionHandler()
   {
      super();
   }

   public WGBEDataVersionHandler( HttpServletRequest request )
   {
      super();
   }

   public int getVersion( int ownerType, int ownerId )
   {
      return( 1 );
   }
}
