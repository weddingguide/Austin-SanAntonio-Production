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

public class WGBELabelsDataAccessServlet extends WGBEDataAccessServlet
{
   public String getContentType()
   {
      return( "application/html" );
   }

   public String getCharacterEncoding()
   {
      return( "ISO8859_1" );
   }

   public WGBEDataAccess createDataAccessModel( DBData dbData, WGBEDataAccessCtrl dataAccessCtrl )
   {
      return( new WGBELabelsDataAccess( dbData, dataAccessCtrl ));
   }

   public String  export()
   {
      System.out.println( "WGBLabelsDataAccessServlet.export()" );
      return( dataAccess.export() );
   }
}

