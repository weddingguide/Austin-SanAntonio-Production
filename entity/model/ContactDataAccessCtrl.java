package jwm.entity.model;
import jwm.entity.model.db.*;
import jwm.project.model.*;
import jwm.gl2.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;

public class ContactDataAccessCtrl
{
   public boolean inclIndividualContacts     = false;

   public boolean inclSearch                 = false;
   public boolean inclRecentAccountActivity  = false;
   public boolean inclAllOpenAccounts        = false;
   public boolean inclByGroupName            = false;
   public boolean inclByEventDate            = false;
   public boolean inclByEventDateRange       = false;
   public boolean inclByEventLoc             = false;
   public boolean inclRecent                 = false;
   public boolean inclByStatus               = false;
   public boolean inclAllStatus              = false;
   public boolean inclHistory                = false;
   public boolean inclLastHistory            = false;
   public boolean inclProjects               = false;
   public boolean inclStatement              = false;
   public boolean inclMembers                = false;
   public boolean inclAccountStatement       = false;
   public boolean inclStickyNotes            = false;
   public boolean inclMailTemplates          = false;
   public boolean inclByOpenWorkItems        = false;
   public boolean inclWorkItemCounts         = false;
   public boolean inclByYear                 = false;
   public boolean inclFutureOnly             = false;

   public boolean createGroup                = false;

   public boolean inclByFollowUp             = false;
   public int     followUpStatus             = -1;

   public boolean inclAbandoned              = false;

   public boolean inclSingleContact          = false;
   public int     singleContactId            = -1;

   public boolean separateLists              = false;
   public int[]   statusArray                = new int[0];
   public String  search                     = "????";
   public String  groupName                  = "????";
   public String  eventDate                  = "????";
   public String  eventLoc                   = "????";
   public String  year                       = "????";
   public int     max                        = 500;
   public String  mainTitle                  = "";
   public String  title                      = "";

   public int[]   omitStatusArray           = new int[0];

   public  PersonDataAccessCtrl  personDataAccessCtrl  =  null;
   public  ProjectDataAccessCtrl projectDataAccessCtrl =  null;
   public  GLDataAccessCtrl      glDataAccessCtrl      =  null;

   public ContactDataAccessCtrl()
   {
      personDataAccessCtrl  = new PersonDataAccessCtrl(); // will create nested view objects as necessay
      projectDataAccessCtrl = new ProjectDataAccessCtrl();
      glDataAccessCtrl      = new GLDataAccessCtrl();
   }
}
