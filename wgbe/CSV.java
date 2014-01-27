package jwm.wgbe;
import jwm.db.*;
import jwm.entity.*;
import jwm.logger.*;
import javax.servlet.*;
import javax.servlet.http.*;
import jwm.entity.*;
import jwm.entity.db.*;
import jwm.servletdb.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import jwm.jsputils.*;

public class CSV extends HttpServlet {

    private ServletContext context;

    public void init(ServletConfig config) throws javax.servlet.ServletException
    {
       super.init(config);

       context = config.getServletContext();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException
    {
       doPost( request, response );
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        DBData dbData = ServletDBData.getInstance( context, "jdbc/wgbe" );
        dbData.setVersionHandler( new WGBEDataVersionHandler( request ) );
        dbData.getLog().setLogLevel( Log.DEBUG );

        response.setContentType("application/txt");
        PrintWriter out = response.getWriter();

        JSPUtils jspUtils = new JSPUtils( request );

        String retString = "";
        EntityAttributeDefList attributeDefList = new EntityAttributeDefList(dbData, "OWNERTYPE = " + EntityAttributeDef.OWNERTYPE_GLOBAL + " AND SUBID=0", "SORTWEIGHT ASC");
        for ( int i = 0; i < attributeDefList.getRecordList().length; i++ )
        {
           EntityAttributeDef attributeDef = (EntityAttributeDef) attributeDefList.getRecordList()[i];
           retString += attributeDef.commaSeparator(retString) + attributeDef.CSVCell( attributeDef.getName());
        }
        out.println( retString );


        EntityAttributeList vendors = new EntityAttributeList( dbData, true ); // get a list of unique attribute owner ids

       for ( int j = 0; j < vendors.getRecordList().length; j++ )
       {
          EntityAttribute aVendor = (EntityAttribute) vendors.getRecordList()[j];

          EntityAttributeList attrList = new EntityAttributeList( dbData, EntityAttribute.OWNERTYPE_PERSON, aVendor.getOwnerId(), true );

          retString = "";
          for ( int i = 0; i < attributeDefList.getRecordList().length; i++ )
          {
             EntityAttributeDef attributeDef = (EntityAttributeDef) attributeDefList.getRecordList()[i];
             String[] values = EntityAttributeList.getAttributeValues(dbData, EntityAttribute.OWNERTYPE_PERSON, aVendor.getOwnerId(), attributeDef.getId(), 0 );


             String value = "";
             for ( int k=0; k<values.length; k++ )
             {
                value += values[k];
                if (k<values.length-1) value+="; ";
             }
             retString += attributeDef.commaSeparator(retString) + attributeDef.CSVCell( value );
          }
          out.println( retString );
       }

        out.flush();
        out.close();
    }
}
