package jwm.wgbe;

import java.io.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import jwm.db.*;
import jwm.entity.*;
import jwm.image.*;
import jwm.logger.*;
import jwm.servletdb.*;
import jwm.wgbe.*;
import net.sf.json.*;
import net.sf.json.xml.*;
import org.w3c.dom.*;

public class WGBEJsonDataAccessServlet extends WGBEXMLDataAccessServlet
{
   public String getContentType()
   {
      return( "application/json" );
   }

   public String getResponseData( DBData dbData, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
   {
      String jsonData = "**";
      try
      {
         String xmlData = super.getResponseData( dbData, request, response );

         XMLSerializer xmlSerializer = new XMLSerializer();
         JSON json = xmlSerializer.read( xmlData );
         if (json.isArray())
         {
            JSONArray arr = (JSONArray) json;
            jsonData = arr.getJSONObject(0).toString(2);
         }
         else
         {
            jsonData = json.toString(2);
         }
      }
      catch (Exception e)
      {
          System.out.println("WGBEJson Servlet: " + e);
          e.printStackTrace( System.out );
          jsonData = "  ** Error in WGBEJsonDataAccessServlet **";
      }
     return( jsonData );
   }
}

