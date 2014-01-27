package jwm.wgbe.model;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.*;
import jwm.wgbe.model.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;

public class Lead extends LeadDBRecordBase
{
   private Document doc;

   private LeadCtrl leadCtrl = null;


   public int     numberOfGuests =0;
   public  void   setNumberOfGuests( int aNumberOfGuests ) { numberOfGuests = aNumberOfGuests; }
   public  int    getNumberOfGuests() { return(numberOfGuests); }

   public String  address;
   public  void   setAddress( String aAddress ) { address = aAddress; }
   public  String getAddress()   { return(address); }

   public String  bridesFirst;
   public  void   setBridesFirst( String aBridesFirst ) { bridesFirst = aBridesFirst; }
   public  String getBridesFirst() { return(bridesFirst); }

   public String  bridesLast;
   public  void   setBridesLast( String aBridesLast ) { bridesLast = aBridesLast; }
   public  String getBridesLast() { return(bridesLast); }

   public String  categories = "";
   public  void   setCategories( String aCategories ) { categories = aCategories; }
   public  String getCategories() { return(categories); }

   public String  city;
   public  void   setCity( String aCity ) { city = aCity; }
   public  String getCity()      { return(city); }

   public String  cityOfWedding;
   public  void   setCityOfWedding( String aCityOfWedding ) { cityOfWedding = aCityOfWedding; }
   public  String getCityOfWedding() { return(cityOfWedding); }

   public String  email;
   public  void   setEmail( String aEmail ) { email = aEmail; }
   public  String getEmail()     { return(email); }

   public String  groomFirst;
   public  void   setGroomFirst( String aGroomFirst ) { groomFirst = aGroomFirst; }
   public  String getGroomFirst() { return(groomFirst); }

   public String  groomLast;
   public  void   setGroomLast( String aGroomLast ) { groomLast = aGroomLast; }
   public  String getGroomLast() { return(groomLast); }

   public String[]  phone;
   public  void     setPhone( String[] aPhone ) { phone = aPhone; }
   public  String[] getPhone()       { return(phone); }


   public String  state;
   public  void   setState( String aState ) { state = aState; }
   public  String getState()     { return(state); }

   public String  weddingDate;
   public  void   setWeddingDate( String aWeddingDate ) { weddingDate = aWeddingDate; }
   public  String getWeddingDate() { return(weddingDate); }

   public String  zip;
   public  void   setZip( String aZip ) { zip = aZip; }
   public  String getZip()       { return(zip); }

   public Timestamp lastUpdate;
   public  void     setLastUpdate( Timestamp aLastUpdate ) { lastUpdate = aLastUpdate; }
   public  Timestamp getLastUpdate()  { return(lastUpdate); }

   public String[] groups = new String[0];
   public  void    setGroups( String[] aGroups ) { groups = aGroups; }
   public  String[] getGroups()     { return(groups); }



   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Lead( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   public Lead( DBData aDbData, Document aDoc, Contact aContact, LeadCtrl aLeadCtrl )
   {
      super( aDbData );
      doc = aDoc;
      leadCtrl = aLeadCtrl;

      id = aContact.getId();

      lastUpdate = aContact.getLastUpdate();

      PersonList personList = new PersonList( dbData, -1, id, true );

      for ( int j= 0; j < personList.getRecordList().length; j++ )
      {
         Person aPerson = (Person) personList.getRecordList()[j];

//       dbData.getLog().logEvent( aPerson.toString() );

         GroupMemberMap map = new GroupMemberMap( dbData, aContact.getId(), Person.RECORDTYPE_PERSON, aPerson.getPersonId(), true );

         if ( map.getMemberRole() == GroupMemberMap.MEMBERROLE_BRIDE )
         {
            bridesFirst = aPerson.getFirstName();
            bridesLast  = aPerson.getLastName();

            // all address/phone/email info is stored under bride's record even though it is technically not identified as bride's contact info

            address = aPerson.getAddress().getAddressLine1();
            city = aPerson.getAddress().getCity();
            state = aPerson.getAddress().getState();
            zip   = aPerson.getAddress().getPostalCode();

            email = aPerson.getEmail().getEmailAddress();

            phone = new String[2];

            phone[0] = aPerson.getPhone(0).getPhoneNumber();
            phone[1] = aPerson.getPhone(1).getPhoneNumber();

         }
         if ( map.getMemberRole() == GroupMemberMap.MEMBERROLE_GROOM )
         {
            groomFirst = aPerson.getFirstName();
            groomLast  = aPerson.getLastName();
         }
      }

      HistoryList historyList = new HistoryList( dbData, ObjectClassID.CONTACT, aContact.getId());
      for ( int i = 0; i < historyList.getRecordList().length; i++ )
      {
         History aNote = (History)historyList.getRecordList()[i];

         if ( aNote.getDescription().equals( "Wedding Date" ))         weddingDate = aNote.getComment();
         try
         {
            if ( aNote.getDescription().equals( "# of Guests" ))          numberOfGuests = new Integer(aNote.getComment()).intValue();
         }
         catch( Exception e)
         {
            // ignore... use default text string
         }
         if ( aNote.getDescription().equals( "City of Wedding" ))      cityOfWedding = aNote.getComment();
         if ( aNote.getDescription().equals( "Interest Categories" ))  categories = aNote.getComment();
      }

      EntityGroupList currGroups = new EntityGroupList( dbData, aContact.getId(), true, true, true);
      ArrayList groupArray = new ArrayList();

      for (int i=0; i < currGroups.getRecordList().length; i++ )
      {
         EntityGroup aGroup = (EntityGroup) currGroups.getRecordList()[i];
         if ( aGroup.getName().indexOf( "Leads" ) == -1 ) // don't want to list the Leads group
         {
            String[] parts = aGroup.getName().split( "\\(" );
            groupArray.add( parts[0] );
         }
      }
      groups = (String[]) groupArray.toArray( groups );

   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Lead( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Lead( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Lead( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Lead( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Lead( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }


   public Element getElement()
   {
      SimpleDateFormat extFormat= new SimpleDateFormat ("EEEE, MMMM d, yyyy hh:mm a");

      Element leadElement = doc.createElement( "lead" );
      leadElement.setAttribute( "created", extFormat.format(lastUpdate) );

      Element sourcesElement = doc.createElement( "sources");
      leadElement.appendChild( sourcesElement );

      for ( int i = 0; i < groups.length; i++ )
      {
         Element sourceElement = doc.createElement( "source");
         sourcesElement.appendChild( sourceElement );
         sourceElement.setAttribute( "name", groups[i] );
      }

      Element brideElement = doc.createElement("bride");
      brideElement.setAttribute( "lastname", bridesLast );
      brideElement.setAttribute( "firstname", bridesFirst );
      leadElement.appendChild( brideElement );

      Element groomElement = doc.createElement("groom");
      groomElement.setAttribute( "lastname", groomLast );
      groomElement.setAttribute( "firstname", groomFirst );
      leadElement.appendChild( groomElement );

      Element addressElement = doc.createElement("address");
      leadElement.appendChild( addressElement );
      addressElement.setAttribute( "addressline1", address );
      addressElement.setAttribute( "city", city );
      addressElement.setAttribute( "state", state );
      addressElement.setAttribute( "zip", zip );

      Element phoneNumbersElement = doc.createElement( "phonenumbers");
      leadElement.appendChild( phoneNumbersElement );

      if ( !phone[0].equals( "" ))
      {
         Element phoneNumberElement1 = doc.createElement( "phone");
         phoneNumbersElement.appendChild( phoneNumberElement1 );
         phoneNumberElement1.setAttribute( "number", phone[0] );
      }
      if ( !phone[1].equals( "" ))
      {
         Element phoneNumberElement2 = doc.createElement( "phone");
         phoneNumbersElement.appendChild( phoneNumberElement2 );
         phoneNumberElement2.setAttribute( "number", phone[1] );
      }

      Element emailElement = doc.createElement("email");
      leadElement.appendChild( emailElement );
      emailElement.setAttribute( "emailaddress", email );

      Element weddingElement = doc.createElement("wedding");
      leadElement.appendChild( weddingElement );
      weddingElement.setAttribute( "cityofwedding", cityOfWedding );

      String numberOfGuestsText = "";
      try
      {
         numberOfGuestsText = new Integer( numberOfGuests ).toString();
      }
      catch( Exception e)
      {
         // ignore... use default text string
      }
      weddingElement.setAttribute( "numberofguests", numberOfGuestsText );
      weddingElement.setAttribute( "weddingdate", weddingDate );

      Element categoriesElement = doc.createElement("categories");
      categoriesElement.appendChild(doc.createTextNode(categories));
      leadElement.appendChild( categoriesElement );

      return( leadElement );
   }


   public String getCSV()
   {
      SimpleDateFormat extFormat= new SimpleDateFormat ("EEEE, MMMM d, yyyy hh:mm a");
      String csvData = "";

      if( leadCtrl.inclWeddingDate    ) csvData += commaSeparator(csvData) + CSVCell( weddingDate );
      if( leadCtrl.inclNumberOfGuests ) csvData += commaSeparator(csvData) + CSVCell( numberOfGuests );
      if( leadCtrl.inclCityOfWedding  ) csvData += commaSeparator(csvData) + CSVCell( cityOfWedding );
      if( leadCtrl.inclBridesLast     ) csvData += commaSeparator(csvData) + CSVCell( bridesLast );
      if( leadCtrl.inclBridesFirst    ) csvData += commaSeparator(csvData) + CSVCell( bridesFirst );
      if( leadCtrl.inclAddress        ) csvData += commaSeparator(csvData) + CSVCell( address );
      if( leadCtrl.inclCity           ) csvData += commaSeparator(csvData) + CSVCell( city );
      if( leadCtrl.inclState          ) csvData += commaSeparator(csvData) + CSVCell( state );
      if( leadCtrl.inclZip            ) csvData += commaSeparator(csvData) + CSVCell( zip );
      if( leadCtrl.inclPhone1         ) csvData += commaSeparator(csvData) + CSVCell( phone[0] );
      if( leadCtrl.inclPhone2         ) csvData += commaSeparator(csvData) + CSVCell( phone[1] );
      if( leadCtrl.inclEmail          ) csvData += commaSeparator(csvData) + CSVCell( email );
      if( leadCtrl.inclGroomLast      ) csvData += commaSeparator(csvData) + CSVCell( groomLast );
      if( leadCtrl.inclGroomFirst     ) csvData += commaSeparator(csvData) + CSVCell( groomFirst );
      if( leadCtrl.inclCategories     ) csvData += commaSeparator(csvData) + CSVCell( categories );

      String sourceCell = "";
      for ( int i = 0; i < groups.length; i++ )
      {
         sourceCell += commaSeparator( sourceCell ) + groups[i];
      }
      if( leadCtrl.inclSources        ) csvData += commaSeparator(csvData) + CSVCell( sourceCell );
      if( leadCtrl.inclAdded          ) csvData += commaSeparator(csvData) + CSVCell( extFormat.format(lastUpdate) );
      if( leadCtrl.inclVendorName     ) csvData += commaSeparator(csvData) + CSVCell( " " );
      if( leadCtrl.inclSince          ) csvData += commaSeparator(csvData) + CSVCell( " " );

      dbData.getLog().logEvent( "Lead: csvData: " + csvData );
      return( csvData );
   }

   public String getAddressLabel()
   {
      return( bridesFirst + " " + bridesLast + "\n"
             + "<br>" + address + "\n"
             + "<br>" + city + ", " + state + " " + zip + "\n" );
   }
}
