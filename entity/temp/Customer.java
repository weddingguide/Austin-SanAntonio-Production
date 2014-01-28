package jwm.entity;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

// A customer has one group and one 'person (entity)' object associated.  Group holds people that are part of this customer.  Person object holds address, etc.
// Note that the customer points to the group.  But the person-entity object points to the customer


public class Customer extends CustomerDBRecordBase
{
   protected EntityGroup group = null;
   public  void          setGroup( EntityGroup aGroup ) { group = aGroup; }
   public  EntityGroup   getGroup()            { return(group); }

   protected Person customerEntity = null;
   public  void     setCustomerEntity( Person aCustomerEntity ) { customerEntity = aCustomerEntity; }
   public  Person   getCustomerEntity() { return(customerEntity); }




   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Customer( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Customer( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Customer( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Customer( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Customer( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Customer( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public Customer( DBData dbData, int customerId )
   {
      super( dbData );
      populateObject( "CUSTOMER", "ID = "+ customerId, "" );
   }


   // find or create a customer object where this person is the sole contact (i.e. the 1-for-1 customer/person situation)
   public Customer( DBData dbData, int personId, boolean signatureFlag )
   {
      super( dbData );
      EntityGroupList customerGroups = new EntityGroupList( dbData, EntityGroup.TYPE_CUSTOMERCONTACT, personId, true);
      // should be 0 or 1...
      if (customerGroups.getRecordList().length > 0)
      {
         EntityGroup customerGroup = (EntityGroup) customerGroups.getRecordList()[0];
         populateObject( "CUSTOMER", "GROUPID = "+ customerGroup.getGroupNum(), "" );
      }
      else
      {
         Person aPerson = new Person( dbData, personId );
         EntityGroup customerGroup = new EntityGroup( dbData, aPerson.getLastName() + ", " + aPerson.getFirstName(), "Customer Groups", EntityGroup.TYPE_CUSTOMERCONTACT, personId );

         groupId = customerGroup.getGroupNum();
         notifyChange = 1;
         lastUpdate = new java.sql.Date( new java.util.Date().getTime() );
         createDate = new java.sql.Date( new java.util.Date().getTime() );
         createRecord( "CUSTOMER" );
      }
   }

   // find or create a customer object with specified groupId
   public Customer( DBData dbData, int aGroupId, boolean signatureFlag, boolean signatureFlag2 )
   {
      super( dbData );
      populateObject( "CUSTOMER", "GROUPID = "+ aGroupId, "" );

      if (!recordFound)
      {
         groupId = aGroupId;
         notifyChange = 1;
         lastUpdate = new java.sql.Date( new java.util.Date().getTime() );
         createDate = new java.sql.Date( new java.util.Date().getTime() );
         createRecord( "CUSTOMER" );
      }
   }

   public PersonList getContacts()
   {
      return( new PersonList( dbData, EntityGroup.TYPE_CUSTOMERCONTACT, groupId ) );
   }

   public void deepPopulate()
   {
      group = new EntityGroup( dbData, groupId );
      if ( !group.isRecordFound() )
      {
         group.createRecord( "ENTITYGROUP" );
         groupId = group.getGroupNum();
         updateRecord( "CUSTOMER" );
      }

      customerEntity = new Person( dbData, ObjectClassID.CUSTOMER, id ); // find the person object that has this customer as the owner
      if ( !customerEntity.isRecordFound() )
      {
         customerEntity.setOwnerType( ObjectClassID.CUSTOMER );
         customerEntity.setOwnerId( id );
         customerEntity.setLastName( group.getName() );
         customerEntity.setRecordType( Person.RECORDTYPE_CUSTOMER );
         customerEntity.createRecord( "PERSON" );
      }
      customerEntity.deepPopulate();
   }


   public String getName()
   {
      if ( group == null ) deepPopulate();

      return( group.getName() );
   }

}
