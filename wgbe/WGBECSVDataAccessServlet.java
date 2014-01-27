package jwm.wgbe;

import java.io.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import jwm.db.*;
import jwm.entity.*;
import jwm.jsputils.*;
import jwm.image.*;
import jwm.wgbe.*;
import jwm.wgbe.model.*;
import jwm.logger.*;
import jwm.servletdb.*;
import org.w3c.dom.*;

public class WGBECSVDataAccessServlet extends WGBEDataAccessServlet
{
   public String getContentType()
   {
      return( "application/csv" );
   }

   public WGBEDataAccess createDataAccessModel( DBData dbData, WGBEDataAccessCtrl dataAccessCtrl )
   {
      return( new WGBECSVDataAccess( dbData, dataAccessCtrl ));
   }

   public String  export()
   {
      System.out.println( "WGBCSVDataAccessServlet.export()" );
      return( dataAccess.export() );
   }
}

