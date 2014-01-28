package jwm.entity;
import jwm.db.*;
import jwm.servletdb.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import jwm.jsputils.*;

public class CSV extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException
    {
       doPost( request, response );
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("application/txt");
        PrintWriter out = response.getWriter();

        JSPUtils jspUtils = new JSPUtils( request );


        if ( request.getParameter( "contacts" ) != null )
        {
           ContactList[] contactLists = (ContactList[]) request.getSession().getAttribute( "contactLists" );
           int ndx = jspUtils.getIntParm( "ndx" );
           ContactList contactList = contactLists[ndx];

           for ( int i = 0; i < contactList.getRecordList().length; i++ )
           {
              Contact aContact = (Contact) contactList.getRecordList()[i];
              aContact.getDbData().open();  // dbData is stale in objects passed in session; need to reactivate with a new connection
              aContact.deepPopulate();
              aContact.getDbData().getLog().logEvent( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CSV.java - " + i + " " + aContact.getName() );
              if ( i == 0 ) out.println( aContact.toCSVHeaderString(new StdCSVContactView(request), -1 ) );
              out.println( aContact.toCSVString(new StdCSVContactView(request) ) );
           }
        }
        else
        {
           PersonList personList = (PersonList) request.getSession().getAttribute( "personListQueryResults" ); // get the stored list from the session object

           for ( int i = 0; i < personList.getRecordList().length; i++ )
           {
              Person aPerson = (Person) personList.getRecordList()[i];
              if ( i == 0 ) out.println( aPerson.toCSVHeaderString(new StdCSVPersonView(request), -1 ) );
              out.println( aPerson.toCSVString(new StdCSVPersonView(request) ) );
           }
        }
        out.flush();
        out.close();
    }
}
