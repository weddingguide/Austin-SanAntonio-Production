package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import org.w3c.dom.*;

public class EntityAttributeList extends EntityAttributeDBRecordListBase
{

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityAttributeList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityAttributeList( DBData aDbData, boolean omitExpired, int ownerType, int ownerId, int attributeDefId, int attributeDefSubId  )
   {
      super( aDbData );

      SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
      String currDate = formatter.format( new java.util.Date() );

      String queryString =  "OWNERTYPE = " + ownerType
                          + " and OWNERID = " + ownerId
                          + " AND VERSION = " + dbData.getVersionHandler().getVersion( ownerType, ownerId )
                          + " and attributeDefId = " + attributeDefId
                          + " and attributeDefSubId = " + attributeDefSubId
                          + " AND ENDDATE >= '" + currDate + "'";
      buildList( "ENTITYATTRIBUTE", queryString, "NDX ASC" );
   }

   public EntityAttributeList( DBData aDbData, int ownerType, int ownerId, int attributeDefId, int attributeDefSubId  )
   {
      super( aDbData );
      buildList( "ENTITYATTRIBUTE", "OWNERTYPE = " + ownerType + " and OWNERID = " + ownerId + " AND VERSION = " + dbData.getVersionHandler().getVersion( ownerType, ownerId ) + " and attributeDefId = " + attributeDefId + " and attributeDefSubId = " + attributeDefSubId, "NDX ASC" );
   }

   public EntityAttributeList( DBData aDbData, int ownerType, int ownerId, int attributeDefId, int attributeDefSubId, boolean sortByData, int dummy  )
   {
      super( aDbData );
      buildList( "ENTITYATTRIBUTE", "OWNERTYPE = " + ownerType + " and OWNERID = " + ownerId + " AND VERSION = " + dbData.getVersionHandler().getVersion( ownerType, ownerId ) + " and attributeDefId = " + attributeDefId + " and attributeDefSubId = " + attributeDefSubId, "ATTRIBUTEDATA ASC" );
   }

   public EntityAttributeList( DBData aDbData, int attributeDefId, int attributeDefSubId, int signatureFlag  )
   {
      super( aDbData );
      buildList( "ENTITYATTRIBUTE", "attributeDefId = " + attributeDefId + " and attributeDefSubId = " + attributeDefSubId, "" );
   }

   public EntityAttributeList( DBData aDbData, int attributeDefId, int attributeDefSubId, String attributeData, boolean flag )
   {
      super( aDbData );
      buildList( "ENTITYATTRIBUTE", "attributeDefId = " + attributeDefId + " and attributeDefSubId = " + attributeDefSubId + " and attributedata like " + prepareStringField("%"+attributeData+"%"), "" );
   }

   public EntityAttributeList( DBData aDbData, int ownerType, int ownerId, int attributeDefId, int attributeDefSubId, boolean signatureFlag1, boolean signatureFlag2  )
   {
      super( aDbData );

      SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
      String currDate = formatter.format( new java.util.Date() );

      buildList( "ENTITYATTRIBUTE", "OWNERTYPE = " + ownerType
                               + " and OWNERID = " + ownerId
                               + " and attributeDefId = " + attributeDefId
                               + " and attributeDefSubId = " + attributeDefSubId
                               + " AND BGNDATE <= '" + currDate + "'"
                               + " AND ENDDATE >= '" + currDate + "'"
                               + " AND VERSION = " + dbData.getVersionHandler().getVersion( ownerType, ownerId )
                               + " AND ATTRIBUTEDATA != '' ",
                               "NDX ASC" );
   }

   // find all attrbutes with attributedef udef field = specific value (used to total up lineitems in project line item status
   public EntityAttributeList( DBData aDbData, int ownerType, int ownerId, int userDefinedFieldValue, boolean signatureFlag )
   {
      super( aDbData );
      buildList( "ENTITYATTRIBUTE, ENTITYATTRIBUTEDEF", "ATTRIBUTEDEFID = ENTITYATTRIBUTEDEF.ID"
                 + " AND ATTRIBUTEDEFSUBID = ENTITYATTRIBUTEDEF.SUBID"
                 + " AND ENTITYATTRIBUTE.OWNERTYPE = " + ownerType
                 + " AND ENTITYATTRIBUTE.OWNERID   = " + ownerId
                 + " AND ENTITYATTRIBUTEDEF.USERDEFINED = " + userDefinedFieldValue,
                 ""  );
   }

   // find all attrbutes with attributedef udef field = specific value (used to total up 'COMPLETED' lineitems in project line item status
   public EntityAttributeList( DBData aDbData, int ownerType, int ownerId, int userDefinedFieldValue, String value )
   {
      super( aDbData );
      buildList( "ENTITYATTRIBUTE, ENTITYATTRIBUTEDEF", "ATTRIBUTEDEFID = ENTITYATTRIBUTEDEF.ID"
                 + " AND ATTRIBUTEDEFSUBID = ENTITYATTRIBUTEDEF.SUBID"
                 + " AND ENTITYATTRIBUTE.OWNERTYPE = " + ownerType
                 + " AND ENTITYATTRIBUTE.OWNERID   = " + ownerId
                 + " AND ENTITYATTRIBUTEDEF.USERDEFINED = " + userDefinedFieldValue
                 + " AND ENTITYATTRIBUTE.ATTRIBUTEDATA = '" + value + "'",
                 ""  );
   }

   public EntityAttributeList( DBData aDbData, boolean omitExpired, int ownerType,  int ownerId, int attributeDefId, int attributeDefSubId, int ndx  )
   {
      super( aDbData );

      SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
      String currDate = formatter.format( new java.util.Date() );

      String queryString =  "OWNERTYPE = " + ownerType
                         + " and OWNERID = " + ownerId
                         + " AND VERSION = " + dbData.getVersionHandler().getVersion( ownerType, ownerId )
                         + " and attributeDefId = " + attributeDefId
                         + " and attributeDefSubId = " + attributeDefSubId
                         + " and ndx = " + ndx
                          + " AND ENDDATE >= '" + currDate + "'";
      buildList( "ENTITYATTRIBUTE", queryString, "" );
   }

   public EntityAttributeList( DBData aDbData, int ownerType,  int ownerId, int attributeDefId, int attributeDefSubId, int ndx  )
   {
      super( aDbData );
      String queryString =  "OWNERTYPE = " + ownerType
                         + " and OWNERID = " + ownerId
                         + " AND VERSION = " + dbData.getVersionHandler().getVersion( ownerType, ownerId )
                         + " and attributeDefId = " + attributeDefId
                         + " and attributeDefSubId = " + attributeDefSubId
                         + " and ndx = " + ndx;
      buildList( "ENTITYATTRIBUTE", queryString, "" );
   }

   public EntityAttributeList( DBData aDbData, int ownerType, int ownerId, int attributeDefId, int ndx, boolean signatureFlag  )
   {
      super( aDbData );
      buildList( "ENTITYATTRIBUTE", "OWNERTYPE = " + ownerType + " and OWNERID = " + ownerId + " AND VERSION = " + dbData.getVersionHandler().getVersion( ownerType, ownerId ) + " and attributeDefId = " + attributeDefId + " and ndx = " + ndx, "" );
   }

   public EntityAttributeList( DBData aDbData, int ownerType, int ownerId, boolean signatureFlag )
   {
      super( aDbData );
      buildList( "ENTITYATTRIBUTE", "OWNERTYPE = " + ownerType + " and OWNERID = " + ownerId + " AND VERSION = " + dbData.getVersionHandler().getVersion( ownerType, ownerId ) + " and attributeDefSubId = 0" );
   }

   //This is specifically for the specials page in wgbe
   public EntityAttributeList( DBData aDbData, int attributeDefId, int groupNum )
   {
      this( aDbData, attributeDefId, groupNum, "BGNDATE DESC" );
   }

   public EntityAttributeList( DBData aDbData, int attributeDefId, int groupNum, String sortBy )
   {
      super( aDbData );
      SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
      String currDate = formatter.format( new java.util.Date() );

      buildList( "ENTITYATTRIBUTE, GROUPMEMBERMAP, PERSON", "attributeDefId = " + attributeDefId
                 + " AND attributeDefSubId=0"
                 + " AND GROUPMEMBERMAP.MEMBERID = ENTITYATTRIBUTE.OWNERID"
                 + " AND PERSON.PERSONID = ENTITYATTRIBUTE.OWNERID"            // added 6/11/13 -- specials and events should not include inactive vendors
                 + " AND (PERSON.SITEDEFENTITYTYPE = 1 OR PERSON.SITEDEFENTITYTYPE = 3)"  // added 6/11/13 / modified 7/8/13 --- ACTIVE OR "SPECIAL" (for AusWeddings and SAWeddings profiles)
                 + " AND BGNDATE <= '" + currDate + "'"
                 + " AND ENDDATE >= '" + currDate + "'"
                 + " AND VERSION = 1"                                           // ################^&%^&%&^%&%&%%&%&%%^%&%&%^%&%^% fix with versioning!!!!!!!!!
                 + " AND GROUPMEMBERMAP.GROUPNUM = " + groupNum,
                 sortBy  );
   }

   //This is specifically for the wgbe banners
   public EntityAttributeList( DBData aDbData, int attributeDefId, int regionGroup, String ownerIds, int theLimit )
   {
      super( aDbData );
      SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
      String currDate = formatter.format( new java.util.Date() );

      buildList( "ENTITYATTRIBUTE, GROUPMEMBERMAP", "attributeDefId = " + attributeDefId
                 + " AND attributeDefSubId=0"
                 + " AND GROUPMEMBERMAP.MEMBERID = OWNERID"
                 + " AND BGNDATE <= '" + currDate + "'"
                 + " AND ENDDATE >= '" + currDate + "'"
                 + " AND ATTRIBUTEDATA != '' "
                 + " AND VERSION = 1"                                           // ################^&%^&%&^%&%&%%&%&%%^%&%&%^%&%^% fix with versioning!!!!!!!!!
                 + " AND GROUPMEMBERMAP.GROUPNUM = " + regionGroup
                 + " AND OWNERID IN (" + ownerIds + ")",

                 " RAND() LIMIT " + theLimit  );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public EntityAttributeList( DBData dbData )
   {
      super( dbData, "OWNERID = -1000", "" ); // force empty list
   }

   public EntityAttributeList( DBData dbData, boolean signatureFlag )
   {
      super( dbData );
      buildList( "SELECT DISTINCT( 'ownerid' ), ownerid from ENTITYATTRIBUTE", 99999 );
   }

   public static String getAttributeValue( DBData dbData, int ownerType, int ownerId, int attributeDefId, int attributeDefSubId  )
   {
      String value = "";
      EntityAttributeList attributeList = new EntityAttributeList(dbData, ownerType, ownerId, attributeDefId, attributeDefSubId);
      if (attributeList.getRecordList().length > 0 ) value = ((EntityAttribute) attributeList.getRecordList()[0]).getAttributeData();
      return( value );
   }

   public static String getAttributeValue( DBData dbData, int ownerType, int ownerId, int attributeDefId, int attributeDefSubId, boolean omitExpired  )
   {
      String value = "";
      EntityAttributeList attributeList = new EntityAttributeList(dbData, true, ownerType, ownerId, attributeDefId, attributeDefSubId);
      if (attributeList.getRecordList().length > 0 ) value = ((EntityAttribute) attributeList.getRecordList()[0]).getAttributeData();
      return( value );
   }

   public static String getAttributeValue( DBData dbData, int ownerType, int ownerId, int attributeDefId, int attributeDefSubId, int ndx  )
   {
      String value = "";
      EntityAttributeList attributeList = new EntityAttributeList(dbData, ownerType, ownerId, attributeDefId, attributeDefSubId, ndx);
      if (attributeList.getRecordList().length > 0 ) value = ((EntityAttribute) attributeList.getRecordList()[0]).getAttributeData();
      return( value );
   }

   public static String[] getAttributeValues( DBData dbData, int ownerType, int ownerId, int attributeDefId, int attributeDefSubId  )
   {
      EntityAttributeList attributeList = new EntityAttributeList(dbData, ownerType, ownerId, attributeDefId, attributeDefSubId);
      String[] values = new String[ attributeList.getRecordList().length];
      for (int i = 0; i < attributeList.getRecordList().length; i++)
      {
         values[i] = ((EntityAttribute) attributeList.getRecordList()[i]).getAttributeData();
      }
      return( values);
   }

   public static String[] getAttributeValues( DBData dbData, int ownerType, int ownerId, int attributeDefId, int attributeDefSubId, boolean sort  )
   {
      EntityAttributeList attributeList = new EntityAttributeList(dbData, ownerType, ownerId, attributeDefId, attributeDefSubId, true, 0);
      String[] values = new String[ attributeList.getRecordList().length];
      for (int i = 0; i < attributeList.getRecordList().length; i++)
      {
         values[i] = ((EntityAttribute) attributeList.getRecordList()[i]).getAttributeData();
      }
      return( values);
   }

   public static String getAttributeValue( DBData dbData, int ownerType, int ownerId, int defaultOwnerId, int attributeDefId, int attributeDefSubId, boolean signatureFlag  )
   {
      EntityAttributeList attributeList = new EntityAttributeList(dbData, ownerType, ownerId, attributeDefId, attributeDefSubId);
      if (attributeList.getRecordList().length > 0 ) return( ((EntityAttribute) attributeList.getRecordList()[0]).getAttributeData());

      // try default ownerid to see if attr exists for it
      attributeList = new EntityAttributeList(dbData, ownerType, defaultOwnerId, attributeDefId, attributeDefSubId);
      if (attributeList.getRecordList().length > 0 ) return( ((EntityAttribute) attributeList.getRecordList()[0]).getAttributeData());

      return( "" );
   }

   public static String getAttributeValue( DBData dbData, int ownerType, int ownerId,  int defaultOwnerId, int attributeDefId, int attributeDefSubId, int ndx  )
   {
      EntityAttributeList attributeList = new EntityAttributeList(dbData, ownerType, ownerId, attributeDefId, attributeDefSubId, ndx);
      if (attributeList.getRecordList().length > 0 ) return( ((EntityAttribute) attributeList.getRecordList()[0]).getAttributeData() );

      // try default ownerid to see if attr exists for it
      attributeList = new EntityAttributeList(dbData, ownerType, defaultOwnerId, attributeDefId, attributeDefSubId, ndx);
      if (attributeList.getRecordList().length > 0 ) return( ((EntityAttribute) attributeList.getRecordList()[0]).getAttributeData() );

      return( "" );
   }

   // omit Expired attributes:
   public static String getAttributeValue( DBData dbData, int ownerType, int ownerId,  int defaultOwnerId, int attributeDefId, int attributeDefSubId, int ndx, boolean omitExpired  )
   {
      EntityAttributeList attributeList = new EntityAttributeList(dbData, true, ownerType, ownerId, attributeDefId, attributeDefSubId, ndx);
      if (attributeList.getRecordList().length > 0 ) return( ((EntityAttribute) attributeList.getRecordList()[0]).getAttributeData() );

      // try default ownerid to see if attr exists for it
      attributeList = new EntityAttributeList(dbData, true, ownerType, defaultOwnerId, attributeDefId, attributeDefSubId, ndx);
      if (attributeList.getRecordList().length > 0 ) return( ((EntityAttribute) attributeList.getRecordList()[0]).getAttributeData() );

      return( "" );
   }

   public static String[] getAttributeValues( DBData dbData, int ownerType, int ownerId,  int defaultOwnerId, int attributeDefId, int attributeDefSubId  )
   {
      EntityAttributeList attributeList = new EntityAttributeList(dbData, ownerType, defaultOwnerId, attributeDefId, attributeDefSubId);
      EntityAttributeList attributeList2 = new EntityAttributeList(dbData, ownerType, ownerId, attributeDefId, attributeDefSubId);

      String[] values = new String[ attributeList.getRecordList().length + attributeList2.getRecordList().length];
      for (int i = 0; i < attributeList.getRecordList().length; i++)
      {
         values[i] = ((EntityAttribute) attributeList.getRecordList()[i]).getAttributeData();
      }
      for (int i = 0; i < attributeList2.getRecordList().length; i++)
      {
         values[i+attributeList.getRecordList().length] = ((EntityAttribute) attributeList2.getRecordList()[i]).getAttributeData();
      }

      return( values);
   }

   public static int getAttributeInstanceCount( DBData dbData, int attributeDefId, int attributeDefSubId  )
   {
      EntityAttributeList attributeList = new EntityAttributeList(dbData, attributeDefId, attributeDefSubId, -1);
      return( attributeList.getRecordList().length );
   }

   public void cloneAttributeVersionSet(int newVersionNumber )
   {
      for (int i = 0; i < recordList.length; i++)
      {
         EntityAttribute attribute = (EntityAttribute) recordList[i];
         attribute.setVersion( newVersionNumber );
         // a little defensive coding here... this attribute should exist... don't allow dups
         EntityAttribute testAttribute = new EntityAttribute( dbData, attribute.getOwnerType(),attribute.getOwnerId(), attribute.getAttributeDefId(), attribute.getAttributeDefSubId(), attribute.getNdx(), attribute.getVersion() );
         if (!testAttribute.isRecordFound()) attribute.createRecord( "ENTITYATTRIBUTE" );
         else
         {
           dbData.getLog().logEvent( Log.ERROR, "Cloning attribute... attribute already exists: " + attribute.getOwnerType() + " " + attribute.getOwnerId() + " " + attribute.getAttributeDefId() + " " + attribute.getAttributeDefSubId() + " " + attribute.getNdx() + " " + attribute.getVersion() );
         }
      }
   }

   public static void addToElement( DBData dbData, Document doc, Element docElement, int ownerType, int ownerId  )
   {
      EntityAttributeList attributeList = new EntityAttributeList(dbData, ownerType, ownerId, true);
      String[] values = new String[ attributeList.getRecordList().length];
      for (int i = 0; i < attributeList.getRecordList().length; i++)
      {
         EntityAttribute anAttribute = (EntityAttribute) attributeList.getRecordList()[i];
         anAttribute.addToElement( doc, docElement );
      }
   }


}
