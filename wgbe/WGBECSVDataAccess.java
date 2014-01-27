package jwm.wgbe;

import jwm.db.*;
import jwm.entity.*;
import jwm.image.*;
import jwm.wgbe.*;
import jwm.wgbe.model.*;
import jwm.logger.*;
import jwm.servletdb.*;
import org.w3c.dom.*;


public class WGBECSVDataAccess extends WGBEDataAccess
{
   public WGBECSVDataAccess( DBData dbData, WGBEDataAccessCtrl aWGBEDataAccessCtrl )
   {
      super( dbData, aWGBEDataAccessCtrl );
   }

   public String export()
   {
      StringBuffer csvData = new StringBuffer("");
      if ( ctrl.inclLeads )
      {
         csvData.append( leadList.getCSV() );
      }
      dbData.getLog().logEvent( "WGBCSVDataAccess.export() = " + csvData.toString());
      return( csvData.toString() );
   }
}
