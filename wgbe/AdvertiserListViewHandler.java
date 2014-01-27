package jwm.wgbe;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.*;
import jwm.jsputils.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AdvertiserListViewHandler extends StdWGBEReportViewHandler
{
   private int groupNum;
   public  void setGroupNum( int aGroupNum ) { groupNum = aGroupNum; }
   public  int getGroupNum() { return(groupNum); }


   public String getTableHeaderString()
   {
      String output = "";
      output += "<th>Name</th>";
      output += "<th>Order<br>Number</th>";
      output += "<th>Type</th>";
      output += "<th>Status</th>";
      output += "<th>Placement</th>";
      output += "<th>Notes</th>";
      output += "<th>&nbsp.</th>";
      return( output );
   }

   public String getTableRowString(int ndx)
   {
      Person aPerson = (Person)aPersonList.getRecordList()[ndx];
      Ad theAd = new Ad( dbData, groupNum, aPerson.getPersonId() );

      String output = "";

      output += getNameCell( aPerson );
      output += getOrderNumberCell( theAd );
      output += getAdTypeCell( theAd );
      output += getAdStatusCell( theAd );
      output += getAdPlacementCell( theAd );
      output += getAdNotesCell( theAd );
      output += getAdActionCell( theAd );

      return( output );
   }

   public String getOrderNumberCell( Ad theAd )
   {
      return( tableCell( new Integer( theAd.getOrderNumber()).toString() ));
   }
   public String getAdTypeCell( Ad theAd )
   {
      return( tableCell( Ad.adTypeText[ theAd.getAdType() ] ));
   }

   public String getAdStatusCell( Ad theAd )
   {
      return( tableCell( Ad.adStatusText[ theAd.getStatus() ] ));
   }

   public String getAdPlacementCell( Ad theAd )
   {
      return( tableCell( theAd.getAdPlacement()  ));
   }

   public String getAdNotesCell( Ad theAd )
   {
      return( tableCell( theAd.getAdNotes() ));
   }

   public String getAdActionCell( Ad theAd )
   {
      return( tableCell( "<a href=aaaaaa.jsp>Open</a>" ));
   }
}
