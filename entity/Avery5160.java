package jwm.entity;
import jwm.db.*;
import jwm.servletdb.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import jwm.jsputils.*;

public class Avery5160 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
       doPost( request, response );
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("application/rtf");
        PrintWriter out = response.getWriter();

        JSPUtils jspUtils = new JSPUtils( request );

        out.print("{\\rtf1\\ansi\\ansicpg1252\\uc1 \\deff0\\deflang1033\\deflangfe1033{\\fonttbl{\\f0\\froman\\fcharset0\\fprq2{\\*\\panose 02020603050405020304}Times New Roman;}{\\f1\\fswiss\\fcharset0\\fprq2{\\*\\panose 020b0604020202020204}Arial;}" );
        out.print("{\\f72\\fswiss\\fcharset0\\fprq2{\\*\\panose 020b0603020202020204}Trebuchet MS;}{\\f147\\froman\\fcharset238\\fprq2 Times New Roman CE;}{\\f148\\froman\\fcharset204\\fprq2 Times New Roman Cyr;}{\\f150\\froman\\fcharset161\\fprq2 Times New Roman Greek;}" );
        out.print("{\\f151\\froman\\fcharset162\\fprq2 Times New Roman Tur;}{\\f152\\froman\\fcharset177\\fprq2 Times New Roman (Hebrew);}{\\f153\\froman\\fcharset178\\fprq2 Times New Roman (Arabic);}{\\f154\\froman\\fcharset186\\fprq2 Times New Roman Baltic;}" );
        out.print("{\\f155\\fswiss\\fcharset238\\fprq2 Arial CE;}{\\f156\\fswiss\\fcharset204\\fprq2 Arial Cyr;}{\\f158\\fswiss\\fcharset161\\fprq2 Arial Greek;}{\\f159\\fswiss\\fcharset162\\fprq2 Arial Tur;}{\\f160\\fswiss\\fcharset177\\fprq2 Arial (Hebrew);}" );
        out.print("{\\f161\\fswiss\\fcharset178\\fprq2 Arial (Arabic);}{\\f162\\fswiss\\fcharset186\\fprq2 Arial Baltic;}{\\f723\\fswiss\\fcharset238\\fprq2 Trebuchet MS CE;}{\\f727\\fswiss\\fcharset162\\fprq2 Trebuchet MS Tur;}}{\\colortbl;\\red0\\green0\\blue0;\\red0\\green0\\blue255;" );
        out.print("\\red0\\green255\\blue255;\\red0\\green255\\blue0;\\red255\\green0\\blue255;\\red255\\green0\\blue0;\\red255\\green255\\blue0;\\red255\\green255\\blue255;\\red0\\green0\\blue128;\\red0\\green128\\blue128;\\red0\\green128\\blue0;\\red128\\green0\\blue128;\\red128\\green0\\blue0;" );
        out.print("\\red128\\green128\\blue0;\\red128\\green128\\blue128;\\red192\\green192\\blue192;}{\\stylesheet{\\qc \\li0\\ri0\\widctlpar\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0\\itap0 \\b\\f1\\fs20\\lang1033\\langfe1033\\cgrid\\langnp1033\\langfenp1033 \\snext0 Normal;}{" );
        out.print("\\s1\\qc \\li0\\ri0\\keepn\\widctlpar\\aspalpha\\aspnum\\faauto\\outlinelevel0\\adjustright\\rin0\\lin0\\itap0 \\b\\f72\\fs20\\lang1033\\langfe1033\\cgrid\\langnp1033\\langfenp1033 \\sbasedon0 \\snext0 heading 1;}{\\*\\cs10 \\additive Default Paragraph Font;}}{\\info" );
        out.print("{\\title Avery Templates}{\\subject Avery Template}{\\author Avery Dennison Corporation}{\\keywords Avery Templates}{\\doccomm Copyright \\'a92004 Avery Dennison Corporation. All rights reserved.}{\\operator Shawna}{\\creatim\\yr2004\\mo9\\dy3\\hr15\\min53}" );
        out.print("{\\revtim\\yr2004\\mo9\\dy3\\hr15\\min53}{\\printim\\yr2004\\mo3\\dy12\\hr14\\min37}{\\version2}{\\edmins3}{\\nofpages1}{\\nofwords8}{\\nofchars50}{\\*\\company Avery Dennison Corporation}{\\*\\category Avery Templates}{\\nofcharsws61}{\\vern8247}}" );
        out.print("\\margl274\\margr274\\margt720\\margb0 \\widowctrl\\ftnbj\\aenddoc\\noxlattoyen\\expshrtn\\noultrlspc\\dntblnsbdb\\nospaceforul\\formshade\\horzdoc\\dghspace187\\dgvspace187\\dghorigin1699\\dgvorigin1987\\dghshow0\\dgvshow0" );
        out.print("\\jexpand\\viewkind1\\viewscale100\\pgbrdrhead\\pgbrdrfoot\\nolnhtadjtbl \\fet0\\sectd \\psz1\\linex0\\endnhere\\sectlinegrid272\\sectdefaultcl {\\*\\pnseclvl1\\pnucrm\\pnstart1\\pnindent720\\pnhang{\\pntxta .}}{\\*\\pnseclvl2\\pnucltr\\pnstart1\\pnindent720\\pnhang{\\pntxta .}}" );
        out.print("{\\*\\pnseclvl3\\pndec\\pnstart1\\pnindent720\\pnhang{\\pntxta .}}{\\*\\pnseclvl4\\pnlcltr\\pnstart1\\pnindent720\\pnhang{\\pntxta )}}{\\*\\pnseclvl5\\pndec\\pnstart1\\pnindent720\\pnhang{\\pntxtb (}{\\pntxta )}}{\\*\\pnseclvl6\\pnlcltr\\pnstart1\\pnindent720\\pnhang{\\pntxtb (}" );
        out.print("{\\pntxta )}}{\\*\\pnseclvl7\\pnlcrm\\pnstart1\\pnindent720\\pnhang{\\pntxtb (}{\\pntxta )}}{\\*\\pnseclvl8\\pnlcltr\\pnstart1\\pnindent720\\pnhang{\\pntxtb (}{\\pntxta )}}{\\*\\pnseclvl9\\pnlcrm\\pnstart1\\pnindent720\\pnhang{\\pntxtb (}{\\pntxta )}}" );

        DBData dbData = ServletDBData.getInstance( request, "jdbc/cis" );
        int recordType = Person.RECORDTYPE_PERSON;
        if ( request.getParameter( "business" ) != null ) recordType = Person.RECORDTYPE_BUSINESS_ORG;

        Person blank = new Person( dbData );
        blank.deepPopulate();

        int firstLabel = jspUtils.getIntParm( "firstlabel" );

        PersonList aPersonList = null;
        EntityGroupList aFamilyList = null;
        ContactList aContactContainerList = null;

        boolean families = false;
        boolean contacts = false;

        int count;


        if ((request.getParameter( "families" ) != null )
          && (!request.getParameter( "families" ).equals("null" )))
        {
           aFamilyList = (EntityGroupList) request.getSession().getAttribute( "familyListQueryResults" );
           count = aFamilyList.getRecordList().length;
           families = true;
        }
        else if (request.getParameter( "contacts" ) != null )
        {
           ContactList[] contactLists = (ContactList[]) request.getSession().getAttribute( "contactLists" );
           int ndx = jspUtils.getIntParm( "ndx" );
           aContactContainerList = contactLists[ndx];
           count = aContactContainerList.getRecordList().length;

           contacts = true;
        }
        else // not family or contact groups, default to list of people
        {
           aPersonList = (PersonList) request.getSession().getAttribute( "personListQueryResults" ); // get the stored list from the session object
           count = aPersonList.getRecordList().length;
        }


        int i = 0;
        for ( int labelPos = 1; ;  )
        {
           if (i >= count ) break;

           Person p1 = blank;
           Person p2 = blank;
           Person p3 = blank;

           // if family... get primary person from family... change first name - last name in person object to "The <lastname> family" to avoid more 'if' statements in the RTF code

           if ( labelPos >= firstLabel )
           {
              if (families)
              {
                 p1 = getPrimaryPersonFromFamily( dbData, aFamilyList, i++ );
              }
              else if (contacts)
              {
                 p1 = getPrimaryPersonFromContactContainer( dbData, aContactContainerList, i++ );
              }
              else
              {
                 p1 = (Person) aPersonList.getRecordList()[i++];
              }
           }
           labelPos++;

           if ( i  < count )
           {
              if ( labelPos >= firstLabel )
              {
                 if (families)
                 {
                    p2 = getPrimaryPersonFromFamily( dbData, aFamilyList, i++ );
                 }
                 else if (contacts)
                 {
                    p2 = getPrimaryPersonFromContactContainer( dbData, aContactContainerList, i++ );
                 }
                 else
                 {
                    p2 = (Person) aPersonList.getRecordList()[i++];
                 }
              }
           }
           labelPos++;

           if ( i  < count )
           {
              if ( labelPos >= firstLabel )
              {
                 if (families)
                 {
                    p3 = getPrimaryPersonFromFamily( dbData, aFamilyList, i++ );
                 }
                 else if (contacts)
                 {
                    p3 = getPrimaryPersonFromContactContainer( dbData, aContactContainerList, i++ );
                 }
                 else
                 {
                    p3 = (Person) aPersonList.getRecordList()[i++];
                 }
              }
           }
           labelPos++;

           out.print("\\trowd" );
           out.print("\\trgaph15\\trrh-1440\\trleft-15\\trkeep\\trftsWidth1\\trpaddl15\\trpaddr15\\trpaddfl3\\trpaddfr3 \\clvertalc\\clbrdrt\\brdrnone \\clbrdrl\\brdrnone \\clbrdrb\\brdrnone \\clbrdrr\\brdrnone \\cltxlrtb\\clftsWidth3\\clwWidth3780 \\cellx3765\\clvertalc\\clbrdrt\\brdrnone \\clbrdrl" );
           out.print("\\brdrnone \\clbrdrb\\brdrnone \\clbrdrr\\brdrnone \\cltxlrtb\\clftsWidth3\\clwWidth180 \\cellx3945\\clvertalc\\clbrdrt\\brdrnone \\clbrdrl\\brdrnone \\clbrdrb\\brdrnone \\clbrdrr\\brdrnone \\cltxlrtb\\clftsWidth3\\clwWidth3780 \\cellx7725\\clvertalc\\clbrdrt\\brdrnone \\clbrdrl" );
           out.print("\\brdrnone \\clbrdrb\\brdrnone \\clbrdrr\\brdrnone \\cltxlrtb\\clftsWidth3\\clwWidth180 \\cellx7905\\clvertalc\\clbrdrt\\brdrnone \\clbrdrl\\brdrnone \\clbrdrb\\brdrnone \\clbrdrr\\brdrnone \\cltxlrtb\\clftsWidth3\\clwWidth3780 \\cellx11685\\pard\\plain" );
           out.print("\\s1\\qc \\li0\\ri0\\keepn\\widctlpar\\intbl\\aspalpha\\aspnum\\faauto\\outlinelevel0\\adjustright\\rin0\\lin0 \\b\\f72\\fs20\\lang1033\\langfe1033\\cgrid\\langnp1033\\langfenp1033 {"+p1.getFirstName() + " " + p1.getLastName() );
           out.print("\\par }\\pard\\plain \\qc \\li0\\ri0\\widctlpar\\intbl\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0 \\b\\f1\\fs20\\lang1033\\langfe1033\\cgrid\\langnp1033\\langfenp1033 {\\f72 "+p1.getAddress().getAddressLine1() );
           if (!p1.getAddress().getAddressLine2().equals("")) out.print("\\par "+p1.getAddress().getAddressLine2() );
           out.print("\\par " + p1.getAddress().getCity());
           if ( !p1.getAddress().getCity().equals("")) out.print( ", " );
           out.print( p1.getAddress().getState() + " " + p1.getAddress().getPostalCode() );

           out.print("\\cell }{\\cell " + p2.getFirstName() + " " + p2.getLastName() );
           out.print("\\par " + p2.getAddress().getAddressLine1() );
           if (!p2.getAddress().getAddressLine2().equals("")) out.print("\\par "+p2.getAddress().getAddressLine2() );
           out.print("\\par " + p2.getAddress().getCity());
           if ( !p2.getAddress().getCity().equals("")) out.print( ", " );
           out.print( p2.getAddress().getState() + " " + p2.getAddress().getPostalCode() );

           out.print("\\cell }{\\cell " + p3.getFirstName() + " " + p3.getLastName() );
           out.print("\\par " + p3.getAddress().getAddressLine1() );
           if (!p3.getAddress().getAddressLine2().equals("")) out.print("\\par "+p3.getAddress().getAddressLine2() );
           out.print("\\par " + p3.getAddress().getCity());
           if ( !p3.getAddress().getCity().equals("")) out.print( ", " );
           out.print( p3.getAddress().getState() + " " + p3.getAddress().getPostalCode() );

           out.print("\\cell }\\pard \\qc \\li0\\ri0\\widctlpar\\intbl\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0 {\\trowd \\trgaph15\\trrh-1440\\trleft-15\\trkeep\\trftsWidth1\\trpaddl15\\trpaddr15\\trpaddfl3\\trpaddfr3 \\clvertalc\\clbrdrt\\brdrnone \\clbrdrl\\brdrnone \\clbrdrb" );
           out.print("\\brdrnone \\clbrdrr\\brdrnone \\cltxlrtb\\clftsWidth3\\clwWidth3780 \\cellx3765\\clvertalc\\clbrdrt\\brdrnone \\clbrdrl\\brdrnone \\clbrdrb\\brdrnone \\clbrdrr\\brdrnone \\cltxlrtb\\clftsWidth3\\clwWidth180 \\cellx3945\\clvertalc\\clbrdrt\\brdrnone \\clbrdrl\\brdrnone \\clbrdrb" );
           out.print("\\brdrnone \\clbrdrr\\brdrnone \\cltxlrtb\\clftsWidth3\\clwWidth3780 \\cellx7725\\clvertalc\\clbrdrt\\brdrnone \\clbrdrl\\brdrnone \\clbrdrb\\brdrnone \\clbrdrr\\brdrnone \\cltxlrtb\\clftsWidth3\\clwWidth180 \\cellx7905\\clvertalc\\clbrdrt\\brdrnone \\clbrdrl\\brdrnone \\clbrdrb" );
           out.print("\\brdrnone \\clbrdrr\\brdrnone \\cltxlrtb\\clftsWidth3\\clwWidth3780 \\cellx11685\\row }" );
        }

        out.print("\\pard \\qj \\li0\\ri0\\widctlpar\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0\\itap0 {" );
        out.print("\\par }}" );
    }

    private Person getPrimaryPersonFromFamily( DBData dbData, EntityGroupList familyList, int index )
    {
       EntityGroup aFamily = (EntityGroup) familyList.getRecordList()[index];
       int familyEGId = aFamily.getGroupNum();
       Person familyMember = new Person( dbData );
       familyMember.deepPopulate();

       PersonList familyMembers = new PersonList( dbData, EntityGroup.TYPE_FAMILY, familyEGId ); // all persons in this family
       for (int i=0; i < familyMembers.getRecordList().length; i++ )
       {
          familyMember = (Person)familyMembers.getRecordList()[i];
          GroupMemberMap map = new GroupMemberMap( dbData, familyEGId, Person.RECORDTYPE_PERSON, familyMember.getPersonId(), true );
          if ( familyMember.getRecordType() == Person.RECORDTYPE_PERSON )
          {
             if (map.getPrimaryMember() > 0) break;
          }
       }
       if (familyMembers.getRecordList().length > 1 )
       {
          familyMember.setFirstName( "" );
          familyMember.setLastName( "The " + familyMember.getLastName() + " Family" );
       }
       return( familyMember );
    }

    private Person getPrimaryPersonFromContactContainer( DBData dbData, ContactList contactContainerList, int index )
    {
       EntityGroup aContactContainer = (EntityGroup) ((Contact) contactContainerList.getRecordList()[index]).getPeople();
       int contactContainerEGId = aContactContainer.getGroupNum();
       Person contactContainerMember = new Person( dbData );
       contactContainerMember.deepPopulate();

       PersonList contactContainerMembers = new PersonList( dbData, EntityGroup.TYPE_FAMILY, contactContainerEGId ); // all persons in this contactContainer
       for (int i=0; i < contactContainerMembers.getRecordList().length; i++ )
       {
          contactContainerMember = (Person)contactContainerMembers.getRecordList()[i];
          GroupMemberMap map = new GroupMemberMap( dbData, contactContainerEGId, Person.RECORDTYPE_PERSON, contactContainerMember.getPersonId(), true );
          if ( contactContainerMember.getRecordType() == Person.RECORDTYPE_PERSON )
          {
             if (map.getPrimaryMember() > 0) break;
          }
       }
       if (contactContainerMembers.getRecordList().length > 1 )
       {
          contactContainerMember.setFirstName( "" );
          contactContainerMember.setMiddleName( "" );
          contactContainerMember.setLastName( aContactContainer.getName() );
       }
       return( contactContainerMember );
    }

}

