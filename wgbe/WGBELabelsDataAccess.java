package jwm.wgbe;

import jwm.db.*;
import jwm.entity.*;
import jwm.image.*;
import jwm.wgbe.*;
import jwm.wgbe.model.*;
import jwm.logger.*;
import jwm.servletdb.*;
import org.w3c.dom.*;


public class WGBELabelsDataAccess extends WGBEDataAccess
{
   public WGBELabelsDataAccess( DBData dbData, WGBEDataAccessCtrl aWGBEDataAccessCtrl )
   {
      super( dbData, aWGBEDataAccessCtrl );
   }

   public String export()
   {
      dbData.getLog().logEvent( "WGBELabelsDataAccessServlet - export() inclLeads=" + ctrl.inclLeads );
      String labelsData = "";
      if ( ctrl.inclLeads )
      {
         labelsData = leadList.getLabels();
      }
      dbData.getLog().logEvent( "WGBLabelsDataAccess.export() = " + labelsData.toString());
      return( labelsData );
   }
}
