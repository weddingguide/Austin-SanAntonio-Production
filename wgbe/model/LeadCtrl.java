package jwm.wgbe.model;
import jwm.wgbe.model.db.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;

public class LeadCtrl extends LeadViewBase
{
   public String afterDate = "";
   public int    contactId = -1;
   public int    firstLabel= 0;

   public boolean  inclWeddingDate    = true;
   public boolean  inclNumberOfGuests = true;
   public boolean  inclCityOfWedding  = true;
   public boolean  inclBridesLast     = true;
   public boolean  inclBridesFirst    = true;
   public boolean  inclAddress        = true;
   public boolean  inclCity           = true;
   public boolean  inclState          = true;
   public boolean  inclZip            = true;
   public boolean  inclPhone1         = true;
   public boolean  inclPhone2         = true;
   public boolean  inclEmail          = true;
   public boolean  inclGroomLast      = true;
   public boolean  inclGroomFirst     = true;
   public boolean  inclCategories     = true;
   public boolean  inclSources        = true;
   public boolean  inclAdded          = true;
   public boolean  inclVendorName     = true;
   public boolean  inclSince          = true;

}
