package jwm.entity;

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
import jwm.entity.*;
import jwm.entity.model.*;
import jwm.logger.*;
import jwm.servletdb.*;
import org.w3c.dom.*;

public class JWMBOSXMLDataAccessServlet extends JWMBOSDataAccessServlet
{
   public String getContentType()
   {
      return( "application/xml" );
   }

   public JWMBOSDataAccess createDataAccessModel( DBData dbData, JWMBOSDataAccessCtrl dataAccessCtrl )
   {
      return( new JWMBOSXMLDataAccess( dbData, dataAccessCtrl ));
   }

   public String  export()
   {
      return( dataAccess.export() );
   }
}

