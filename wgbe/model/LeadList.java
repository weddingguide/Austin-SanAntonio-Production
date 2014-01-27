package jwm.wgbe.model;

import jwm.db.*;
import jwm.wgbe.model.db.*;
import jwm.entity.*;
import jwm.document.Avery5160;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;

public class LeadList extends LeadDBRecordListBase
{
   private Document doc;
   private LeadCtrl leadCtrl;
   private Contact vendorContact;

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public LeadList( DBData aDbData, String criteriaString, String orderString  )
   {
      super( aDbData, criteriaString, orderString );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public LeadList( DBData aDbData, int aId  )
   {
      super( aDbData );
      buildList( "PROFILE", "ID = " + Integer.toString(aId) );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public LeadList( DBData dbData )
   {
      super( dbData );
   }

   public LeadList( DBData dbData, Document aDoc, LeadCtrl aLeadCtrl )
   {
      super( dbData );
      doc = aDoc;
      leadCtrl = aLeadCtrl;

      vendorContact = new Contact( dbData, leadCtrl.contactId );

      SimpleDateFormat intFormat= new SimpleDateFormat ("yyyy-MM-dd HH:mm");
      SimpleDateFormat extFormat= new SimpleDateFormat ("EEEE, MMMM d, yyyy hh:mm a");

      recordList = getListInstance(0);  // initialize contact recordList to size 0; preparing to build the list

      try
      {
         ContactList leads = new ContactList( dbData, leadCtrl.contactId, intFormat.format( extFormat.parse(leadCtrl.afterDate)) );
         for ( int i =0; i < leads.getRecordList().length; i++ )
         {
            Contact aContact = (Contact) leads.getRecordList()[i];

            Lead aLead = new Lead( dbData, doc, aContact, leadCtrl );
            add( aLead );
         }
      }
      catch( Exception e)
      {
         dbData.getLog().logEvent( "Leadlist.java -- " + e );
         e.printStackTrace( System.out );
      }
   }

   public Element getElement()
   {
      Element leadListElement = doc.createElement( "leads" );
      leadListElement.setAttribute( "user", vendorContact.getName() );
      leadListElement.setAttribute( "since", leadCtrl.afterDate );

      for ( int i = 0; i < recordList.length; i++ )
      {
         Lead aLead = (Lead) recordList[i];
         leadListElement.appendChild( aLead.getElement() );
      }
      return( leadListElement );
   }

   public String getCSV()
   {
      StringBuffer csvData = new StringBuffer("~~~~~");

      String csvHeader = "";
      if( leadCtrl.inclWeddingDate    ) csvHeader += commaSeparator(csvHeader) + "Wedding Date";
      if( leadCtrl.inclNumberOfGuests ) csvHeader += commaSeparator(csvHeader) + "# of Guests";
      if( leadCtrl.inclCityOfWedding  ) csvHeader += commaSeparator(csvHeader) + "City of Wedding";
      if( leadCtrl.inclBridesLast     ) csvHeader += commaSeparator(csvHeader) + "Brides Last";
      if( leadCtrl.inclBridesFirst    ) csvHeader += commaSeparator(csvHeader) + "Brides First";
      if( leadCtrl.inclAddress        ) csvHeader += commaSeparator(csvHeader) + "Address";
      if( leadCtrl.inclCity           ) csvHeader += commaSeparator(csvHeader) + "City";
      if( leadCtrl.inclState          ) csvHeader += commaSeparator(csvHeader) + "State";
      if( leadCtrl.inclZip            ) csvHeader += commaSeparator(csvHeader) + "Zip";
      if( leadCtrl.inclPhone1         ) csvHeader += commaSeparator(csvHeader) + "Phone1";
      if( leadCtrl.inclPhone2         ) csvHeader += commaSeparator(csvHeader) + "Phone2";
      if( leadCtrl.inclEmail          ) csvHeader += commaSeparator(csvHeader) + "Email";
      if( leadCtrl.inclGroomLast      ) csvHeader += commaSeparator(csvHeader) + "Groom Last";
      if( leadCtrl.inclGroomFirst     ) csvHeader += commaSeparator(csvHeader) + "Groom First";
      if( leadCtrl.inclCategories     ) csvHeader += commaSeparator(csvHeader) + "Categories";
      if( leadCtrl.inclSources        ) csvHeader += commaSeparator(csvHeader) + "Sources";
      if( leadCtrl.inclAdded          ) csvHeader += commaSeparator(csvHeader) + "Added";
      if( leadCtrl.inclVendorName     ) csvHeader += commaSeparator(csvHeader) + "Vendor Name";
      if( leadCtrl.inclSince          ) csvHeader += commaSeparator(csvHeader) + "Since";

      csvData.append( csvHeader + "\n" );

      Lead aLead = new Lead(dbData); // need a dummy object subclassing ServletRecord to use for CSVCell method below...

      // first row only contains request metadata... vendor name and 'since' parameter
      String csvRow1 = "";
      if( leadCtrl.inclWeddingDate    ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclNumberOfGuests ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclCityOfWedding  ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclBridesLast     ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclBridesFirst    ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclAddress        ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclCity           ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclState          ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclZip            ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclPhone1         ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclPhone2         ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclEmail          ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclGroomLast      ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclGroomFirst     ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclCategories     ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclSources        ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclAdded          ) csvRow1 += commaSeparator(csvRow1) + " ";
      if( leadCtrl.inclVendorName     ) csvRow1 += commaSeparator(csvRow1) + aLead.CSVCell( vendorContact.getName() );
      if( leadCtrl.inclSince          ) csvRow1 += commaSeparator(csvRow1) + aLead.CSVCell( leadCtrl.afterDate );

      csvData.append( csvRow1 + "\n" );

      for ( int i = 0; i < recordList.length; i++ )
      {
         aLead = (Lead) recordList[i];
         csvData.append( aLead.getCSV() + "\n" );
      }
      return( csvData.toString() );
   }

   public String getLabels()
   {
      dbData.getLog().logEvent( "LeadList.getLabels() " + leadCtrl.firstLabel +" " + ( recordList.length+leadCtrl.firstLabel+1) );
      Avery5160 labelDoc = new Avery5160( leadCtrl.firstLabel + recordList.length+leadCtrl.firstLabel+1 );

      if ( recordList.length > 0 )
      {
         for ( int i = 0; i < recordList.length; i++ )
         {
            Lead aLead = (Lead) recordList[i];
            labelDoc.setLabelContent( leadCtrl.firstLabel + i, aLead.getAddressLabel() );
         }
      }
      else
      {
         labelDoc.setLabelContent( 0, "No leads found" );
      }

      return( labelDoc.getPDF() );
   }
}
