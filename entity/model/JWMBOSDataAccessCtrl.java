package jwm.entity.model;
import jwm.entity.model.db.*;
import jwm.project.model.*;
import jwm.catalog.model.*;
import jwm.itemtrack.model.*;
import jwm.gl2.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;

public class JWMBOSDataAccessCtrl
{
   public boolean inclContacts  = false;
   public boolean inclCatalogs  = false;
   public boolean inclWorkItems = false;
   public boolean inclPageData  = false;

   public int     userPersonId  = -1;


   public  ContactDataAccessCtrl  contactDataAccessCtrl  =  null;
   public  CatalogDataAccessCtrl  catalogDataAccessCtrl  =  null;
   public  WorkItemDataAccessCtrl workItemDataAccessCtrl =  null;

// public String currPageURL = "";
// public String baseURLQueryString = "";
   public String callBack = "";
   public String self = "";

   public JWMBOSDataAccessCtrl()
   {
      contactDataAccessCtrl  = new ContactDataAccessCtrl();  // will create nested ctrl objects as necessary
      catalogDataAccessCtrl  = new CatalogDataAccessCtrl();  // "
      workItemDataAccessCtrl = new WorkItemDataAccessCtrl(); // "
   }

}
