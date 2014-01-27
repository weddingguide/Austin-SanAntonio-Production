package jwm.wgbe.model;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.*;
import jwm.wgbe.model.db.*;
import jwm.wgbe.*;
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

public class ProfileList extends ProfileDBRecordListBase
{
   private Region region;
   private Document doc;

   private int totalCount = 0;
   private int profileSetCount = 0;

   private ProfileCtrl profileCtrl = null;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ProfileList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ProfileList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "PROFILE", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ProfileList( DBData dbData )
   {
      super( dbData );
   }

   public ProfileList( DBData aDbData, Document aDoc, Region aRegion, ProfileCtrl aProfileCtrl, int parentCategoryId, boolean spotlight )
   {
      super( aDbData );
      region = aRegion;
      doc = aDoc;
      profileCtrl = aProfileCtrl;

      int maxCount = profileCtrl.profileSetSize;
      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list


      dbData.getLog().logEvent( "....Getting paid spotlight vendors" );

      EntityGroup catGroup       = new EntityGroup( dbData,  aProfileCtrl.singleCategoryId ); // get the category group
      EntityGroup spotlightGroup = new EntityGroup( dbData,  catGroup.getName() + " - Spotlight" ); // get the corresponding spotlight group

      int actualCategoryId = aProfileCtrl.singleCategoryId; // save it
      aProfileCtrl.singleCategoryId = spotlightGroup.getGroupNum();
      PersonList spotlightVendors = getVendorList( aProfileCtrl, aRegion, null ); // get list of paid spotlight vendors
      aProfileCtrl.singleCategoryId =actualCategoryId; // put it back

      dbData.getLog().logEvent( "....Getting filler spotlight vendors" );
      PersonList fillerVendors = getVendorList( aProfileCtrl, aRegion, spotlightVendors ); // get random filler vendors (but prevent dups from spotlight vendors)

      spotlightVendors.merge( fillerVendors );

      buildProfileList( spotlightVendors, aProfileCtrl );
   }


   public ProfileList( DBData aDbData, Document aDoc, Region aRegion, ProfileCtrl aProfileCtrl, int parentCategoryId )
   {
      super( aDbData );
      region = aRegion;
      doc = aDoc;
      profileCtrl = aProfileCtrl;

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      if ( profileCtrl.singleProfile != -1 ) // single category requested
      {
         Person aVendor = new Person( dbData, profileCtrl.singleProfile);
         Profile profile = new Profile( dbData, doc, parentCategoryId, 0, aVendor, profileCtrl );
         add( profile );  //add it to the list (always have a list.... even if one entry... simpler code
      }
      else // multiple categories based on search, single category, etc...
      {
         PersonList aVendorList = getVendorList( aProfileCtrl, aRegion, null );
         buildProfileList( aVendorList, aProfileCtrl );
      }
   }

   // constructor to return "featured profiles" (currently on the right sidebar of the home page (see extra_incl.jsp)

   public ProfileList( DBData aDbData, Document aDoc, Region aRegion, ProfileCtrl aProfileCtrl, boolean signatureFlag )
   {
      super( aDbData );
      region = aRegion;
      doc = aDoc;
      profileCtrl = aProfileCtrl;

      int maxCount = profileCtrl.profileSetSize;
      dbData.getLog().logEvent( "Featured Profile max: " + maxCount );


      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      dbData.getLog().logEvent( "....Getting paid feature vendors" );

      PersonList featuredVendors = new PersonList( dbData, EntityGroup.TYPE_GENERAL, aRegion.getFeaturedVendorGroupId(), 1, maxCount ); // get random featured vendors

      dbData.getLog().logEvent( "....Getting filler feature vendors" );

      PersonList fillerVendors = new PersonList( dbData, EntityGroup.TYPE_GENERAL, aRegion.getGroup(), 1, (maxCount*2)-(featuredVendors.getRecordList().length) ); // fill up to 8 with general random vendors from region; need 16 to handle dup potential
      featuredVendors.merge(fillerVendors);

      Vector usedVendors = new Vector<Integer>();
      int vendorCount = 0;

      for (int i=0; i < featuredVendors.getRecordList().length; i++ )
      {
         Person aVendor = (Person) featuredVendors.getRecordList()[i];
         int businessEntityId = aVendor.getPersonId();

         if (!usedVendors.contains( businessEntityId ))
         {
            Profile profile = new Profile( dbData, doc, -1, vendorCount, aVendor, profileCtrl );  // note categoryid = -1, profile must figure out it's category to use for url
            add( profile ); //add it to the list

            usedVendors.add(  businessEntityId );
            vendorCount++;
            dbData.getLog().logEvent( "....vendor count/max count: " + vendorCount + " " + maxCount );

            if (vendorCount == maxCount ) break;
         }
      }
//    totalCount = 8;  ??????????????? 1/1/14
   }

   public Element getElement( String tag)
   {
      dbData.getLog().logEvent( "ProfileList.getElement()" );
      if (!profileCtrl.useProfileSets ) return ( getProfilesElement( tag ));

      // using profile sets (i.e. pagination....)

      Element profileSetsElement = doc.createElement( "profileSets" );
      String paginateText = "false";
      if (profileSetCount > 1) paginateText = "true";
      profileSetsElement.setAttribute( "paginate", paginateText );

      int selectPrev = profileCtrl.profileSetId - 1;
      int selectNext = profileCtrl.profileSetId + 1;
      if ( selectPrev > 0 )                profileSetsElement.setAttribute( "selectprev", new Integer(selectPrev).toString() );
      if ( selectNext <= profileSetCount ) profileSetsElement.setAttribute( "selectnext", new Integer(selectNext).toString() );

      profileSetsElement.setAttribute( "count", new Integer(profileSetCount).toString() );



      for ( int i = 0; i < profileSetCount; i++ )
      {
         Element profileSetElement = doc.createElement( "profileSet" );
         profileSetElement.setAttribute( "id", (new Integer( i+1 )).toString() );

         String selected = "false";
         if ( i+1 == (profileCtrl.profileSetId) )
         {
            selected = "true";
            profileSetElement.appendChild( getProfilesElement( tag ) );
         }
         profileSetElement.setAttribute( "selected" , selected );

         profileSetElement.setAttribute( "randomstart" , new Boolean(profileCtrl.randomStart).toString() );

         profileSetsElement.appendChild( profileSetElement );
      }
      return( profileSetsElement );
   }

   public Element getProfilesElement( String tag)
   {
      Element profileListElement = doc.createElement( tag );
      profileListElement.setAttribute( "count", iString(recordList.length ));

      if (  ( totalCount > profileCtrl.profileSetMinimum ) // used for spotlight... if we don't have a min total of profiles in cat, don't want to show spotlight bar at all
         || (profileCtrl.profileSetMinimum == 0 )) // or if mimimum not set, then proceed
      {
         for ( int i = 0; i < recordList.length; i++ )
         {
            Profile profile = (Profile) recordList[i];
            profileListElement.appendChild( profile.getElement() );
         }
      }
      return( profileListElement );
   }

   private void buildProfileList( PersonList aVendorList, ProfileCtrl aProfileCtrl )
   {
       // set up to allow random start; but default to starting at 0;

       dbData.getLog().logEvent( "buildProfileList " + aVendorList.getRecordList().length + " " + profileCtrl.randomStart );
       int[] begin = new int[2];
       int[] end = new int[2];

       begin[0] = 0;
       end[0] = aVendorList.getRecordList().length;
       begin[1] = 0; // not used in default case
       end[1] = 0;

       if (profileCtrl.randomStart)
       {
          Random generator = new Random();
          begin[0] = generator.nextInt( aVendorList.getRecordList().length );
          end[1] = begin[0];
       }

       for ( int block = 0; block < 2; block++ )
       {
          for ( int i = begin[block]; i < end[block]; i++ )
          {
             dbData.getLog().logEvent( "buildProfileList - 1 profile: " + i );
              // one profile
             Person aVendor = (Person) aVendorList.getRecordList()[i];
             Profile profile = new Profile( dbData, doc, aProfileCtrl.singleCategoryId, i, aVendor, profileCtrl );
             add( profile ); //add it to the list
          }
       }
   }

   private PersonList getVendorList( ProfileCtrl aProfileCtrl, Region aRegion, PersonList excludeList )
   {
      String queryString = "";
      int recordType = Person.RECORDTYPE_BUSINESS_ORG;

      int queryCount = aProfileCtrl.profileSetSize;

      PersonList aVendorList = null;

      if ( aProfileCtrl.doSearch )
      {
         if (  (aProfileCtrl.searchString.toUpperCase().indexOf( "DELETE ") == -1 )
            && (aProfileCtrl.searchString.toUpperCase().indexOf( "INSERT ") == -1 )
            && (aProfileCtrl.searchString.toUpperCase().indexOf( "UPDATE ") == -1 )
            && (aProfileCtrl.searchString.toUpperCase().indexOf( "REPLACE ") == -1 )
            && (aProfileCtrl.searchString.toUpperCase().indexOf( "REMOVE ") == -1 )
            && (aProfileCtrl.searchString.toUpperCase().indexOf( "*") == -1 )
            && (aProfileCtrl.searchString.indexOf( "\"") == -1 )) // first line of defense to prevent sql insertion attack
         {
            aVendorList = new PersonList( dbData, aVendorList.prepareStringField(aProfileCtrl.searchString,false),EntityGroup.TYPE_GENERAL, aRegion.getGroup(), 1, recordType, false ); // just set up query... this constructor will not execute it
         }
      }
      else if (excludeList != null ) // single category with exclude profileList
      {
         aVendorList = new PersonList( dbData, EntityGroup.TYPE_GENERAL, aRegion.getGroup(), aProfileCtrl.singleCategoryId, 1, recordType, false, excludeList ); // just set up query... this constructor will not execute it
         queryCount -= excludeList.getRecordList().length;
      }
      else // single category
      {
         aVendorList = new PersonList( dbData, EntityGroup.TYPE_GENERAL, aRegion.getGroup(), aProfileCtrl.singleCategoryId, 1, recordType, false ); // just set up query... this constructor will not execute it
      }




      if (aProfileCtrl.randomize )
      {
         aVendorList.doQuery( queryCount ); // if no start record specified, doQuery will randomize
      }
      else
      {
         aVendorList.doQuery( ( (aProfileCtrl.profileSetId - 1 ) * aProfileCtrl.profileSetSize ), queryCount );
      }


      totalCount = aVendorList.getTotalRecordCount();

      dbData.getLog().logEvent( "total profiles found: " + totalCount + " -- this profileSet - " + aVendorList.getRecordList().length );
      profileSetCount = totalCount / aProfileCtrl.profileSetSize;
      if ( totalCount % aProfileCtrl.profileSetSize > 0 ) profileSetCount++;  // any remainder needs to add one more set

      dbData.getLog().logEvent( "....Getting total record count of profiles for category - profile set count " + profileSetCount );
      return( aVendorList );
   }
}
