package jwm.entity;

import jwm.db.*;
import jwm.entity.*;
import jwm.image.*;
import jwm.entity.*;
import jwm.entity.model.*;
import jwm.logger.*;
import jwm.servletdb.*;
import org.w3c.dom.*;


public class JWMBOSXMLDataAccess extends JWMBOSDataAccess
{
   public JWMBOSXMLDataAccess( DBData dbData, JWMBOSDataAccessCtrl aJWMBOSDataAccessCtrl )
   {
      super( dbData, aJWMBOSDataAccessCtrl );
   }

   public String export()
   {
      buildDOM();
      return( super.toXML() );
   }

   public void buildDOM()
   {
      Element jwmbosElement = doc.createElement( "jwmbos" );
      doc.appendChild( jwmbosElement );

      if ( ctrl.inclPageData  ) jwmbosElement.appendChild( pageData.getElement()          );
      if ( ctrl.inclContacts  ) jwmbosElement.appendChild( contactModelListSet.getElement() );
      if ( ctrl.inclCatalogs  ) jwmbosElement.appendChild( catalogModelList.getElement() );
      if ( ctrl.inclWorkItems ) jwmbosElement.appendChild( workItemModelList.getElement() );
   }
}
