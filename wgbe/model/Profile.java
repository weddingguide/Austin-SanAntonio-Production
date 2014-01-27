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


public class Profile extends ProfileDBRecordBase
{
   private Document doc;

   private ProfileCtrl profileCtrl = null;

   private int id = -1;
   public  void setId( int aId ) { id = aId; }
   public  int getId()     { return(id); }

   private String name = "";
   public  void   setName( String aName ) { name = aName; }
   public  String getName()      { return(name); }

   public  String businessEntityName = "";
   public  void   setBusinessEntityName( String aBusinessEntityName ) { businessEntityName = aBusinessEntityName; }
   public  String getBusinessEntityName() { return(businessEntityName); }

   public  String businessEGName = "";
   public  void   setBusinessEGName( String aBusinessEGName ) { businessEGName = aBusinessEGName; }
   public  String getBusinessEGName() { return(businessEGName); }

   public  int    businessEGId = -1;
   public  void   setBusinessEGId( int aBusinessEGId ) { businessEGId = aBusinessEGId; }
   public  int    getBusinessEGId() { return(businessEGId); }

   public  int    crossCheckProfileId = -1;
   public  void   setCrossCheckProfileId( int aCrossCheckProfileId ) { crossCheckProfileId = aCrossCheckProfileId; }
   public  int    getCrossCheckProfileId() { return(crossCheckProfileId); }

   public  String  crossCheckResult = "Ok";
   public  void    setCrossCheckResult( String aCrossCheckResult ) { crossCheckResult = aCrossCheckResult; }
   public  String  getCrossCheckResult() { return(crossCheckResult); }

   public String[] businessEntityGroupMemberName = null;
   public int[] businessEntityGroupMemberId = null;
   public String[] businessEntityGroupMemberType = null;
   public String[] businessEntityGroupMemberStatus = null;

   private String description = "";
   public  void   setDescription( String aDescription ) { description = aDescription; }
   public  String getDescription() { return(description); }

   private String address = "";
   public  void   setAddress( String aAddress ) { address = aAddress; }
   public  String getAddress()   { return(address); }


   private boolean omitDetails = false;
   public  void    setOmitDetails( boolean aOmitDetails ) { omitDetails = aOmitDetails; }
   public  boolean getOmitDetails() { return(omitDetails); }

   private Hashtable details = null;
   public  void      setDetails( Hashtable aDetails ) { details = aDetails; }
   public  Hashtable getDetails()      { return(details); }

   private boolean avatarScaleOnlyFlag = false;
   public  void    setAvatarScaleOnlyFlag( boolean aAvatarScaleOnlyFlag ) { avatarScaleOnlyFlag = aAvatarScaleOnlyFlag; }
   public  boolean getAvatarScaleOnlyFlag() { return(avatarScaleOnlyFlag); }

   private String mapURL;
   public  void   setMapURL( String aMapURL ) { mapURL = aMapURL; }
   public  String getMapURL()    { return(mapURL); }

   private boolean embedMap = false;
   public  void    setEmbedMap( boolean aEmbedMap ) { embedMap = aEmbedMap; }
   public  boolean getEmbedMap()   { return(embedMap); }

   private ImageList imageList = null;
   public  void      setImageList( ImageList aImageList ) { imageList = aImageList; }
   public  ImageList getImageList()    { return(imageList); }

   private VideoList videoList = null;
   public  void      setVideoList( VideoList aVideoList ) { videoList = aVideoList; }
   public  VideoList getVideoList()    { return(videoList); }

   private AudioList audioList = null;
   public  void      setAudioList( AudioList aAudioList ) { audioList = aAudioList; }
   public  AudioList getAudioList()    { return(audioList); }

   private String profileAbstract = "";
   public  void   setProfileAbstract( String aProfileAbstract ) { profileAbstract = aProfileAbstract; }
   public  String getProfileAbstract() { return(profileAbstract); }

   private String avatarTag = "";
   public  void   setAvatarTag( String aAvatarTag ) { avatarTag = aAvatarTag; }
   public  String getAvatarTag() { return(avatarTag); }

   private Image avatar = null;
   public  void  setAvatar( Image aAvatar ) { avatar = aAvatar; }
   public  Image getAvatar()   { return(avatar); }


   private SpecialList specialList = null;
   private EventList eventList = null;
   private VirtualTourList virtualTourList = null;
   private TestimonialList testimonialList = null;

   private String[] profileCategories = new String[1];
   public  void     setprofileCategories( String[] aprofileCategories ) { profileCategories = aprofileCategories; }
   public  String[] getprofileCategories() { return(profileCategories); }

   private String facebook                = "";
   public  void   setFacebook( String aFacebook ) { facebook = aFacebook; }
   public  String getFacebook()  { return(facebook); }

   private String googleplus              = "";
   public  void   setGoogleplus( String aGoogleplus ) { googleplus = aGoogleplus; }
   public  String getGoogleplus() { return(googleplus); }

   private String instagram               = "";
   public  void   setInstagram( String aInstagram ) { instagram = aInstagram; }
   public  String getInstagram() { return(instagram); }


   private String linkedIn                = "";
   public  void   setLinkedIn( String aLinkedIn ) { linkedIn = aLinkedIn; }
   public  String getLinkedIn()  { return(linkedIn); }

   private String myspace                 = "";
   public  void   setMyspace( String aMyspace ) { myspace = aMyspace; }
   public  String getMyspace()   { return(myspace); }

   private String[] phone                 = new String[1];
   public  void     setPhone( String[] aPhone ) { phone = aPhone; }
   public  String[] getPhone()       { return(phone); }

   private String pinterest               = "";
   public  void   setPinterest( String aPinterest ) { pinterest = aPinterest; }
   public  String getPinterest() { return(pinterest); }

   private String twitter                 = "";
   public  void   setTwitter( String aTwitter ) { twitter = aTwitter; }
   public  String getTwitter()   { return(twitter); }

   private String url                     = "";
   public  void   setUrl( String aUrl ) { url = aUrl; }
   public  String getUrl()       { return(url); }

   private String email = "";
   public  void   setEmail( String aEmail ) { email = aEmail; }
   public  String getEmail()     { return(email); }


   private String urlCompliantVendorName  = "";
   public  void   setUrlCompliantVendorName( String aUrlCompliantVendorName ) { urlCompliantVendorName = aUrlCompliantVendorName; }
   public  String getUrlCompliantVendorName() { return(urlCompliantVendorName); }

   private String ndxId = "";  // this is used for the sidebar css selection named "extra-a", "extra-b", etc.
   private String[] ndxValues = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l" }; // only used when max 8 profiles.  A few more than that here, but will crash if overrun array

   private int    detailsGroups = 0;

   private ProfileContactInfoList contactInfoList = null;


   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Profile( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Profile( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Profile( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Profile( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Profile( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public Profile( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public Profile( DBData aDbData, Document aDoc, int categoryId, int ndx, Person aVendor, ProfileCtrl aProfileCtrl )
   {
      super( aDbData );
      doc = aDoc;
      profileCtrl = aProfileCtrl;

      if ( categoryId == -1 ) // parent is collection of profiles from diff categories (e.g. featured profiles), need to get best category to use
      {
         EntityGroupList vendorCategories = new EntityGroupList( dbData, "Vendor Category", id );

         for (int i=0; i<vendorCategories.getRecordList().length; i++ )
         {
            EntityGroup vendorCategory = (EntityGroup) vendorCategories.getRecordList()[i];
            if ( vendorCategory.getAliasOf() == -1 ) // don't include alias group names (e.g. facilities )
            {
               categoryId = vendorCategory.getGroupNum();
               break; // just use the first category...
            }
         }
      }

      if ( aProfileCtrl.inclNdxId )
      {
         if ( ndx < ndxValues.length ) ndxId = ndxValues[ ndx ];
      }

      id = aVendor.getPersonId();
      name = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 1, 0);

      // populate based on profileCtrl flags

      if ( profileCtrl.inclDebug )
      {
         businessEntityName = aVendor.getLastName();
         businessEGId = aVendor.getOwnerId();
         EntityGroup businessEntityGroup = new EntityGroup( dbData, businessEGId );
         businessEGName = businessEntityGroup.getName();

         PersonList businessContacts = new PersonList( dbData, EntityGroup.TYPE_BUSINESS, businessEGId ); // all contacts in this business (people + business record)

         businessEntityGroupMemberName = new String[ businessContacts.getRecordList().length];
         businessEntityGroupMemberId = new int[ businessContacts.getRecordList().length];
         businessEntityGroupMemberType = new String[ businessContacts.getRecordList().length];
         businessEntityGroupMemberStatus = new String[ businessContacts.getRecordList().length];

         for (int i=0; i < businessContacts.getRecordList().length; i++ )
         {
            Person contact = (Person)businessContacts.getRecordList()[i];
            businessEntityGroupMemberName[i] = contact.getName();
            businessEntityGroupMemberId[i] = contact.getPersonId();
            if ( contact.getStatus() == Person.STATUS_ACTIVE )
            {
               businessEntityGroupMemberStatus[i] = "Active";
            }
            else
            {
               businessEntityGroupMemberStatus[i] = "Inactive";
            }

            businessEntityGroupMemberId[i] = contact.getPersonId();

            if ( contact.getRecordType() != Person.RECORDTYPE_PERSON )
            {
               businessEntityGroupMemberType[i] = "Business";
               if (contact.getPersonId() != id )  crossCheckResult = "***** Fail *****";
            }
            else
            {
               businessEntityGroupMemberType[i] = "Person";
            }
         }
      }

      // description
      if (profileCtrl.inclDescription  )
      {
         description = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 6, 0);
      }

      // Abstract
      if (profileCtrl.inclAbstract     )
      {
         profileAbstract = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 72, 0);
         if (profileAbstract.equals(""))
         {
             profileAbstract = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 6, 0);
         }
         dbData.getLog().logEvent( "Truncating abstract for " + name + ".  Truncate length: " + profileCtrl.truncateAbstract );
         System.out.println( "Truncating abstract for " + name + ".  Truncate length: " + profileCtrl.truncateAbstract );
         if ( profileCtrl.truncateAbstract != -1 )
         {
           try
           {
             BreakIterator bi = BreakIterator.getWordInstance();
             bi.setText( profileAbstract );
             int first_after = bi.following(profileCtrl.truncateAbstract );
             profileAbstract = profileAbstract.substring(0, first_after);
           }
           catch (Exception e)
           {
           //do nothing.. ignore
              dbData.getLog().logEvent( "Could not truncate abstract for " + name + ".  Truncate length: " + profileCtrl.truncateAbstract + " " + e );
           }
         }
      }


      // Address
      if (profileCtrl.inclAddress  || profileCtrl.inclDebug  ) address = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 2, 0);



      // details
      if (profileCtrl.inclDetails)
      {
         // get attributeDef for "omit details" checkbox for this category
         EntityAttributeDef omitDetailsAttrDef = new EntityAttributeDef( dbData, categoryId, "OmitDetails" );
         if ( EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, omitDetailsAttrDef.getId(), 0 ).equals("checked"))
         {
            omitDetails = true;
         }

         details = new Hashtable();
         EntityAttributeDefList attributeDefList = new EntityAttributeDefList(dbData, "OWNERTYPE = " + EntityAttributeDef.OWNERTYPE_GROUP + " AND OWNERID = " + categoryId + " AND SUBID=0", "SORTWEIGHT ASC");
         dbData.getLog().logEvent( "Profile --> details for " + categoryId + " = " + attributeDefList.getRecordList().length );
         for (int k=0; k< attributeDefList.getRecordList().length; k++ )
         {
            EntityAttributeDef attributeDef = (EntityAttributeDef) attributeDefList.getRecordList()[k];
            String attributeValue = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, attributeDef.getId(), 0);
            if (attributeValue.equals( "checked" )) attributeValue = "Y";
            if (attributeValue.equals( "unchecked" )) attributeValue = "N";
            if (attributeValue.equals( "" )) attributeValue = "N";
            details.put( attributeDef.getName(), attributeValue );
         }
      }

      Vector detailsCategories = new Vector();
      EntityGroupList vendorCategories = new EntityGroupList( dbData, "Vendor Category", id );
      for ( int i = 0; i < vendorCategories.getRecordList().length; i++ )
      {
         EntityGroup vendorCategory = (EntityGroup) vendorCategories.getRecordList()[i];
         if ( vendorCategory.getAliasOf() == -1 ) // don't include alias category names (e.g. 'facilities'
         {
            if (EntityGroup.isMemberOfGroup( dbData, 4422, EntityGroup.TYPE_GROUP, vendorCategory.getGroupNum() )) // is this vendor category in the "Supports details" group?
            {
               detailsCategories.add( vendorCategory );
            }
         }
      }
      detailsGroups = detailsCategories.size();

      urlCompliantVendorName = WGBEUtils.getURLCompliantVendorName(dbData, categoryId, id);

      // contact info
      if (profileCtrl.inclContactInfo  || profileCtrl.inclDebug  )
      {

         phone = EntityAttributeList.getAttributeValues(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 3, 0);
         email = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 4, 0);
         url =   EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 5, 0);


        // 8/8/13 -- ProfileContactInfo Blocks
        contactInfoList = new ProfileContactInfoList( dbData, doc, id );
      }

      // social media info
      if (profileCtrl.inclSocialMedia  )
      {
         facebook =  EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 12, 0);
         myspace = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 13, 0);
         twitter = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 11, 0);
         linkedIn = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 14, 0);
         pinterest = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 135, 0);
         googleplus = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 159, 0);
         instagram = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 160, 0);
      }

      // videos
      if (profileCtrl.inclVideo        ) videoList = new VideoList( dbData, doc, id );

      // audio clips
      if (profileCtrl.inclAudio        ) audioList = new AudioList( dbData, doc, id );

      // map
      if (profileCtrl.inclMap          )
      {
         mapURL = EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 45, 0);
         embedMap = (EntityAttributeList.getAttributeValue(dbData, EntityAttribute.OWNERTYPE_PERSON, id, 45, 1, 0).equals("checked"));
      }

      // images
      if (profileCtrl.inclImages       ) imageList = new ImageList( dbData, doc, id );

      // avatar
      if (profileCtrl.inclAvatar       )
      {
         avatar = new Image( dbData,
                             doc,
                             44, // attrDefId for avatar
                             0,
                             EntityAttribute.OWNERTYPE_PERSON,
                             id,
                             "",
                             "avatar",
                             profileCtrl.avatarWidth,
                             profileCtrl.avatarHeight );

         if (avatar.getName().equals(""))
         {
            avatar = new Image( dbData,
                                doc,
                                7,  // attrDefId for general images
                                0,
                                EntityAttribute.OWNERTYPE_PERSON,
                                id,
                                "",
                                "avatar",
                                profileCtrl.avatarWidth,
                                profileCtrl.avatarHeight );

         }
         ImageCacheHandler imageCacheHandler = new ImageCacheHandler( dbData );
         avatarTag =imageCacheHandler.cachedImageTag( id,
                                                     avatar.getName(),
                                                     "",
                                                     "feature-avatar",
                                                     125,
                                                     125,
                                                     "",
                                                     false );

      }

      // specials
      if (profileCtrl.inclSpecials     ) specialList = new SpecialList( dbData, doc, id );

      // events
      if (profileCtrl.inclEvents       ) eventList = new EventList( dbData, doc, id );

      // virtual tours
      if (profileCtrl.inclVirtualTours ) virtualTourList = new VirtualTourList( dbData, doc, id );

      // testimonials
      if (profileCtrl.inclTestimonials ) testimonialList = new TestimonialList( dbData, doc, id );

      // categories
      if (profileCtrl.inclCategories   )
      {

         EntityGroupList profileCategoriesEGList = new EntityGroupList( dbData, "Vendor Category", id );

         ArrayList profileCategoriesArray = new ArrayList();

         for (int i=0; i<profileCategoriesEGList.getRecordList().length; i++ )
         {
            EntityGroup profileCategory = (EntityGroup) profileCategoriesEGList.getRecordList()[i];
            if ( profileCategory.getAliasOf() == -1 ) // don't include alias group names (e.g. facilities )
            {
               profileCategoriesArray.add( profileCategory.getName() );
            }
         }
         profileCategories = (String[]) profileCategoriesArray.toArray(profileCategories);
      }
   }

   public Element getElement()
   {
      Element profileElement = doc.createElement( "profile" );
      profileElement.setAttribute( "vendorName", name );
      profileElement.setAttribute( "id", new Integer( id ).toString() );

      profileElement.setAttribute( "detailsGroups", new Integer( detailsGroups ).toString() );

      if ( profileCtrl.inclNdxId )
      {
         profileElement.setAttribute( "ndxid", ndxId );
      }

      // debug
      if ( profileCtrl.inclDebug )
      {
         profileElement.setAttribute( "internalName", businessEntityName );

         profileElement.setAttribute( "crossCheckResult", crossCheckResult );

         if (businessEntityGroupMemberName != null )
         {
            Element businessGroupElement = doc.createElement("ownerBusinessGroup");
            profileElement.appendChild(businessGroupElement);

            businessGroupElement.setAttribute( "id", new Integer( businessEGId ).toString() );
            businessGroupElement.setAttribute( "nameNotUsed", businessEGName );

            for ( int i = 0; i < businessEntityGroupMemberName.length; i++ )
            {
               Element entityGroupMemberElement = doc.createElement( "businessMember" );
               entityGroupMemberElement.setAttribute( "name", businessEntityGroupMemberName[i] );
               entityGroupMemberElement.setAttribute( "id", new Integer( businessEntityGroupMemberId[i]).toString() );
               entityGroupMemberElement.setAttribute( "status", businessEntityGroupMemberStatus[i]);
               entityGroupMemberElement.setAttribute( "type", businessEntityGroupMemberType[i]);
               businessGroupElement.appendChild( entityGroupMemberElement );
            }
         }
      }


      // description
      if (profileCtrl.inclDescription  )
      {
         Element descriptionElement = doc.createElement("description");
         descriptionElement.appendChild(doc.createCDATASection(description));
         profileElement.appendChild(descriptionElement);
      }

      // abstract
      if (profileCtrl.inclAbstract  )
      {
         Element abstractElement = doc.createElement("abstract");
         abstractElement.appendChild(doc.createCDATASection(profileAbstract));
         profileElement.appendChild(abstractElement);
      }

      //address
      if (profileCtrl.inclDescription || profileCtrl.inclDebug )
      {
         Element addressElement = doc.createElement("address");
         addressElement.appendChild(doc.createTextNode(address));
         profileElement.appendChild(addressElement);
      }

      // details
      if (profileCtrl.inclDetails)
      {
         Element detailsElement = doc.createElement("details");
         profileElement.appendChild(detailsElement);

         if ( omitDetails ) detailsElement.setAttribute( "omit", "true" );
         else               detailsElement.setAttribute( "omit", "false" );

         for (Enumeration enum1 = details.keys(); enum1.hasMoreElements();)
         {
            String detailName = (String) enum1.nextElement();
            String detailText = (String) details.get( detailName );
            detailsElement.setAttribute( detailName, detailText );
         }
      }


      // Contact Info
      if (profileCtrl.inclContactInfo || profileCtrl.inclDebug )
      {
         if( phone.length > 0) profileElement.setAttribute( "phone" , phone[0] ); //legacy support...multiple phones handled below
         profileElement.setAttribute( "email" , email );
         profileElement.setAttribute( "url" , url );
         profileElement.setAttribute( "urlcompliantvendorname" , urlCompliantVendorName );

         // forgot about mult phone numbers.  Should not use attribute for phone.  But for legacy reason, have to keep it, but deprecate it... correct way is sub-element for phone
         Element phonesElement = doc.createElement("phonenumbers");
         profileElement.appendChild(phonesElement);
         for ( int i = 0; i < phone.length; i++ )
         {
            Element phoneElement = doc.createElement("phone");
            phonesElement.appendChild(phoneElement);
            phoneElement.setAttribute( "number", phone[i] );
         }

         profileElement.appendChild( contactInfoList.getElement() );


      }

      // Social Media
      if (profileCtrl.inclSocialMedia  )
      {
         if ( !facebook.equals("")) profileElement.setAttribute( "facebook" , facebook );
         if ( !myspace.equals("")) profileElement.setAttribute( "myspace" , myspace );
         if ( !twitter.equals("")) profileElement.setAttribute( "twitter" , twitter );
         if ( !linkedIn.equals("")) profileElement.setAttribute( "linkedin" , linkedIn );
         if ( !pinterest.equals("")) profileElement.setAttribute( "pinterest" , pinterest );
         if ( !googleplus.equals("")) profileElement.setAttribute( "googleplus" , googleplus );
         if ( !instagram.equals("")) profileElement.setAttribute( "instagram" , instagram );
      }

      // avatar
      if (profileCtrl.inclAvatar       )
      {
         profileElement.setAttribute( "avatarURL", avatar.getUrl());
         profileElement.setAttribute( "avatarWidth", new Integer( avatar.getWidth()).toString());
         profileElement.setAttribute( "avatarHeight", new Integer( avatar.getHeight()).toString());

         Element avatarElement = doc.createElement("avatartag");
         avatarElement.appendChild(doc.createCDATASection(avatarTag));
         profileElement.appendChild(avatarElement);
      }

      // video
      if (profileCtrl.inclVideo        ) profileElement.appendChild( videoList.getElement() );

      // audio
      if (profileCtrl.inclAudio        ) profileElement.appendChild( audioList.getElement() );

      // map
      if (profileCtrl.inclMap          )
      {
         Element mapElement = doc.createElement("map");
         mapElement.setAttribute( "url", mapURL );
         String embedMapText = "false";
         if ( embedMap ) embedMapText = "true";
         mapElement.setAttribute( "embed", embedMapText );
         profileElement.appendChild(mapElement);
         mapElement.appendChild(doc.createCDATASection(mapURL));
      }

      // images
      if (profileCtrl.inclImages       ) profileElement.appendChild( imageList.getElement() );

      // Specials
      if (profileCtrl.inclSpecials     ) profileElement.appendChild( specialList.getElement() );

      // Events
      if (profileCtrl.inclEvents       ) profileElement.appendChild( eventList.getElement() );

      // Testimonials
      if (profileCtrl.inclTestimonials ) profileElement.appendChild( testimonialList.getElement() );

      // Virtual Tours
      if (profileCtrl.inclVirtualTours ) profileElement.appendChild( virtualTourList.getElement() );

      // Profile Categories
      if (profileCtrl.inclCategories   )
      {
         Element profileCategoriesElement = doc.createElement("profilecategories");
         for ( int i = 0; i < profileCategories.length; i++ )
         {
            Element profileCategoryElement = doc.createElement("profilecategory");
            profileCategoriesElement.appendChild(profileCategoryElement);
            profileCategoryElement.setAttribute( "name", profileCategories[i]);
         }
      }

      return( profileElement );
   }
}
