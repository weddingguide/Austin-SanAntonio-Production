package jwm.entity;

import jwm.db.*;
import jwm.entity.*;
import jwm.image.*;
import jwm.entity.*;
import jwm.entity.model.*;
import jwm.catalog.model.*;
import jwm.itemtrack.model.*;
import jwm.logger.*;
import jwm.servletdb.*;
import org.w3c.dom.*;


public abstract class JWMBOSDataAccess extends DataAccess
{
   protected JWMBOSDataAccessCtrl       ctrl = null;

   protected ContactModelListSet  contactModelListSet  = null;
   protected CatalogModelList     catalogModelList     = null;
   protected WorkItemModelList    workItemModelList    = null;
   protected PageData             pageData             = null;


   public abstract String export();


   public JWMBOSDataAccess( DBData dbData, JWMBOSDataAccessCtrl aJWMBOSDataAccessCtrl )
   {
      super(dbData);

      ctrl = aJWMBOSDataAccessCtrl;

      if ( ctrl.inclPageData  ) pageData             = new PageData(             dbData, doc, ctrl                       );
      if ( ctrl.inclContacts  ) contactModelListSet  = new ContactModelListSet(  dbData, doc, ctrl.contactDataAccessCtrl );
      if ( ctrl.inclCatalogs  ) catalogModelList     = new CatalogModelList(     dbData, doc, ctrl.catalogDataAccessCtrl );
      if ( ctrl.inclWorkItems ) workItemModelList    = new WorkItemModelList(    dbData, doc, ctrl.workItemDataAccessCtrl );
   }

}
