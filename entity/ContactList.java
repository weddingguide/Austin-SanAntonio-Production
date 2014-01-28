package jwm.entity;

import jwm.db.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import org.apache.juli.*;

public class ContactList extends ContactDBRecordListBase
{

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactList( DBData dbData )
   {
      super( dbData );
   }

   // IMPORTANT NOTE: there is NO contact table in the db at this time.  This is a virtual object made up of other db objects
   // A contact in reality is an EntityGroup, type=CONTACTCONTAINER.  But a contact also has invoice references, mail, projects, etc.
   // So the contact object is basically a container for all db objects related to the contact

   public ContactList( DBData dbData, String searchName )
   {
      this( dbData, new EntityGroupList( dbData, ObjectClassID.CONTACT, searchName ));
   }

   public ContactList( DBData dbData, int singleContactId, boolean signatureFlag, int signatureFlag2 )
   {
      this( dbData, new EntityGroupList( dbData, ObjectClassID.CONTACT, singleContactId, -1, true, true ));
   }
   public ContactList( DBData dbData, boolean inclDeleted, String searchName, boolean signatureFlag )
   {
      this( dbData, new EntityGroupList( dbData, ObjectClassID.CONTACT, inclDeleted, searchName, false ));
   }

   public ContactList( DBData dbData, boolean inclDeleted, java.util.Date bgnDate, java.util.Date endDate )
   {
      this( dbData, new EntityGroupList( dbData, ObjectClassID.CONTACT, inclDeleted, bgnDate, endDate ));
   }

   public ContactList( DBData dbData, int[] statusClassArray, java.util.Date bgnDate, java.util.Date endDate )
   {
      this( dbData, new EntityGroupList( dbData, ObjectClassID.CONTACT, statusClassArray, bgnDate, endDate ));
   }

   public ContactList( DBData dbData, int aStatus, java.util.Date theDate )
   {
      this( dbData, new EntityGroupList( dbData, ObjectClassID.CONTACT, aStatus, theDate ));
   }

   public ContactList( DBData dbData, boolean inclDeleted, java.util.Date theDate, int range )
   {
      this( dbData, new EntityGroupList( dbData, ObjectClassID.CONTACT, inclDeleted, theDate, range ));
   }

   public ContactList( DBData dbData, String groupName, boolean inclDeleted   ) // list contacts that are in a group by the given name
   {
      this( dbData, new EntityGroupList( dbData, inclDeleted, EntityGroup.TYPE_CONTACTCONTAINER, groupName ));
   }

   public ContactList( DBData dbData, int groupNum, boolean signatureFlag, boolean signatureFlag1, boolean signatureFlag2 ) // list contacts that are in a group with the given groupnum
   {
      this( dbData, new EntityGroupList( dbData, groupNum, false, false ));
   }

   public ContactList( DBData dbData, int count ) // list contacts with most recent activity (parm = contacts returned)
   {
      this( dbData, new EntityGroupList( dbData, true, ObjectClassID.CONTACT, count ));
   }

   public ContactList( DBData dbData, int personId, boolean signatureFlag) // list contacts containing this person
   {
      this( dbData, new EntityGroupList( dbData, ObjectClassID.CONTACT, personId, true ));
   }

   public ContactList( DBData dbData, int aStatus, boolean signatureFlag, boolean signatureFlag2) // list contacts with this status
   {
      this( dbData, new EntityGroupList( dbData, ObjectClassID.CONTACT, aStatus, "", true, 99999 ));
   }

   public ContactList( DBData dbData, boolean signatureFlag, boolean signatureFlag2, boolean signatureFlag3) // list contacts with open work items
   {
      this( dbData, new EntityGroupList( dbData, ObjectClassID.CONTACT, "", "", 99999 ));
   }

   public ContactList( DBData dbData, int[] aStatusArray, int max) // list contacts with any of these statuses
   {
      this( dbData, new EntityGroupList( dbData, ObjectClassID.CONTACT, aStatusArray, max ));
   }

   public ContactList( DBData dbData, int[] omitStatusArray, int attributeDefId, int attributeDefSubId, String attributeData) // list contacts with any of these statuses and attributes that match criteria
   {
      this( dbData, new EntityGroupList( dbData, ObjectClassID.CONTACT, omitStatusArray, attributeDefId, attributeDefSubId, attributeData, 10000 ));
   }

   public ContactList( DBData dbData, int aStatus, boolean signatureFlag, boolean signatureFlag2, int maxCount) // list contacts with this status
   {
      this( dbData, new EntityGroupList( dbData, ObjectClassID.CONTACT, aStatus, "", true, maxCount ));
   }

   public ContactList( DBData dbData, int vendorId, String  afterDate )
   {
      this( dbData, new EntityGroupList( dbData, vendorId, true, afterDate ));
   }

   public ContactList( DBData dbData, boolean flag, int count ) // recent account/invoice activity
   {
      this( dbData, new EntityGroupList( dbData, true, ObjectClassID.CONTACT, count, true ));
   }

   public ContactList( DBData dbData, boolean flag, boolean flag2) // all contacts with open accounts
   {
      this( dbData, new EntityGroupList( dbData, true, ObjectClassID.CONTACT, true ));
   }

   public ContactList( DBData dbData, int followUpStatus, int count) // all with a specified followupstatus
   {
      this( dbData, new EntityGroupList( dbData, followUpStatus, true, ObjectClassID.CONTACT, count ));
   }

   public ContactList( DBData dbData, EntityGroupList groupList )
   {
      super( dbData );

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      for ( int i=0; i < groupList.getRecordList().length; i++ )
      {
         EntityGroup group = (EntityGroup) groupList.getRecordList()[i];
         Contact aContact = new Contact( dbData, group ); // build a contact from each contact group
         add( aContact ); //add it to the list
      }
   }

   public ContactList( DBData dbData, int groupNum, int groupNum2, boolean signatureFlag, boolean signatureFlag1, boolean signatureFlag2 ) // list contacts that are in both specified groups
   {
      this( dbData, new EntityGroupList( dbData, groupNum, groupNum2, false, false, false ));
   }

   public void sort() throws Exception
   {
      Arrays.sort( recordList, new ContactComparator() );
   }
}
