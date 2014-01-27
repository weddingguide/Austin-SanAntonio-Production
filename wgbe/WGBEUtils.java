package jwm.wgbe;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.db.*;
import jwm.entity.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.mail.internet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.util.*;
import org.apache.commons.io.*;

public class WGBEUtils
{
   HttpServletRequest request;
   DBData dbData;

   public WGBEUtils( HttpServletRequest aRequest, DBData aDbData )
   {
      dbData = aDbData;
      request = aRequest;
   }

   public String getURLCompliantVendorNameNoCategory( int businessEntityId )
   {
      String vendorName = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessEntityId, 73, 0);
      if ( vendorName.equals("") )
      {
         vendorName = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessEntityId, 1, 0);
         vendorName = vendorName.replace(' ', '-'); // only do substitution on base name attribute, not URL-Compliant name attribute
      }
      return( vendorName );
   }

   public String getURLCompliantVendorName( int businessEntityId )
   {
      return( getURLCompliantVendorName( dbData, businessEntityId ));
   }

   public static String getURLCompliantVendorName( DBData dbData, int businessEntityId )
   {
      String vendorName = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessEntityId, 73, 0);
      if ( vendorName.equals("") )
      {
         vendorName = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessEntityId, 1, 0);
         vendorName = vendorName.replace(' ', '-'); // only do substitution on base name attribute, not URL-Compliant name attribute
      }
      return( getURLCompliantCategoryNameForVendor(dbData, businessEntityId)+"/"+vendorName );
   }

   // use this one when category is possibly known
   public static String getURLCompliantVendorName( DBData dbData, int categoryId, int businessEntityId )
   {
      String vendorName = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessEntityId, 73, 0);
      if ( vendorName.equals("") )
      {
         vendorName = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, businessEntityId, 1, 0);
         vendorName = vendorName.replace(' ', '-'); // only do substitution on base name attribute, not URL-Compliant name attribute
      }
      if (categoryId > 0 ) return( getURLCompliantCategoryName(dbData, categoryId)+"/"+vendorName );
      return( getURLCompliantCategoryNameForVendor(dbData, businessEntityId)+"/"+vendorName );
   }

   public String getURLCompliantCategoryName( int groupNum )
   {
     // 8-18-11 add optional attribute for url-compliant category name
      String categoryName = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_WGBEVENDORCATEGORY, groupNum, 126, 0);
      if ( categoryName.equals( "" ) )
      {
         EntityGroup category = new EntityGroup( dbData, groupNum );
         categoryName = category.getName().replace(' ','-');
      }
      return( categoryName );
   }

   public static String getURLCompliantCategoryName( DBData dbData, int groupNum )
   {
     // 8-18-11 add optional attribute for url-compliant category name
      String categoryName = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_WGBEVENDORCATEGORY, groupNum, 126, 0);
      if ( categoryName.equals( "" ) )
      {
         EntityGroup category = new EntityGroup( dbData, groupNum );
         categoryName = category.getName().replace(' ','-');
      }
      return( categoryName );
   }

   public String getURLCompliantCategoryNameForVendor( int businessEntityId )
   {
      EntityGroupList categoryList = new EntityGroupList( dbData, "Vendor Category", businessEntityId );
      if (categoryList.getRecordList().length == 0 ) return( "" );

      return( getURLCompliantCategoryName( ((EntityGroup) categoryList.getRecordList()[0]).getGroupNum() ));
   }

   public static String getURLCompliantCategoryNameForVendor( DBData dbData, int businessEntityId )
   {
      EntityGroupList categoryList = new EntityGroupList( dbData, "Vendor Category", businessEntityId );
      if (categoryList.getRecordList().length == 0 ) return( "" );

      return( getURLCompliantCategoryName( dbData, ((EntityGroup) categoryList.getRecordList()[0]).getGroupNum() ));
   }

}
