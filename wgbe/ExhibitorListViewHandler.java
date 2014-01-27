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

public class ExhibitorListViewHandler extends StdWGBEReportViewHandler
{
   private int groupNum;
   public  void setGroupNum( int aGroupNum ) { groupNum = aGroupNum; }
   public  int getGroupNum() { return(groupNum); }


   public String getTableHeaderString()
   {
      String output = "";
      output += "<th>$Due</th>";
      output += "<th>Rep</th>";
      output += "<th>Order<br>Number</th>";
      output += "<th>Name</th>";
      output += "<th>Booth#</th>";
      output += "<th>Elec</th>";
      output += "<th>Carpet</th>";
      output += "<th>6'</th>";
      output += "<th>8'</th>";
      output += "<th>Total$</th>";
      output += "<th>Booth$</th>";
      output += "<th>Table$</th>";
      output += "<th>Elec$</th>";
      output += "<th>Carpet$</th>";
      output += "<th>Misc$</th>";
      output += "<th>&nbsp;</th>";
      return( output );
   }

   public String getTableRowString(int ndx)
   {
      Person aPerson = (Person)aPersonList.getRecordList()[ndx];
      Exhibitor exhibitor = new Exhibitor( dbData, groupNum, aPerson.getPersonId() );

      String output = "";

      output += getSDueCell( exhibitor );
      output += getRepCell( exhibitor );
      output += getOrderNumberCell( exhibitor );
      output += getNameCell( aPerson );
      output += getBoothCell( exhibitor );
      output += getElecCell( exhibitor );
      output += getCarpetCell( exhibitor );
      output += get6ftCell( exhibitor );
      output += get8ftCell( exhibitor );
      output += getTotalSCell( exhibitor );
      output += getBoothSCell( exhibitor );
      output += getTableSCell( exhibitor );
      output += getElecSCell( exhibitor );
      output += getCarpetSCell( exhibitor );
      output += getMiscSCell( exhibitor );
      output += getActionCell( exhibitor );

      return( output );
   }

   public String getSDueCell(        Exhibitor exhibitor ) { return( tableCell(  exhibitor.getDueMoney() ) ); }
   public String getOrderNumberCell( Exhibitor exhibitor ) { return( tableCell(  exhibitor.getOrderNumber() ) ); }
   public String getRepCell(         Exhibitor exhibitor ) { return( tableCell(  exhibitor.getDueMoney() ) ); }
   public String getBoothCell(       Exhibitor exhibitor ) { return( tableCell(  exhibitor.getBooth() ) ); }
   public String getElecCell(        Exhibitor exhibitor ) { return( tableCell(  exhibitor.getElectricity() ) ); }
   public String getCarpetCell(      Exhibitor exhibitor ) { return( tableCell(  exhibitor.getCarpet() ) ); }
   public String get6ftCell(         Exhibitor exhibitor ) { return( tableCell(  exhibitor.getTable6Ft() ) ); }
   public String get8ftCell(         Exhibitor exhibitor ) { return( tableCell(  exhibitor.getTable8Ft() ) ); }
   public String getTotalSCell(      Exhibitor exhibitor ) { return( tableCell(  exhibitor.getTotalMoney() ) ); }
   public String getBoothSCell(      Exhibitor exhibitor ) { return( tableCell(  exhibitor.getBoothMoney() ) ); }
   public String getTableSCell(      Exhibitor exhibitor ) { return( tableCell(  exhibitor.getTableMoney() ) ); }
   public String getElecSCell(       Exhibitor exhibitor ) { return( tableCell(  exhibitor.getElecMoney() ) ); }
   public String getCarpetSCell(     Exhibitor exhibitor ) { return( tableCell(  exhibitor.getCarpetMoney() ) ); }
   public String getMiscSCell(       Exhibitor exhibitor ) { return( tableCell(  exhibitor.getMiscMoney() ) ); }
   public String getActionCell(      Exhibitor exhibitor ) { return( tableCell(  "<a href=aaaaaa.jsp>Open</a>" ) ); }
}
