package jwm.entity;

public class ObjectClassID
{
   public static final int GENERAL         =  0;
   public static final int FAMILY          =  1;
   public static final int TEMPORARYGROUP  =  2;
   public static final int GROUP           =  2;
   public static final int COUPLE          =  3;
   public static final int ENTITYGROUP     =  3;
   public static final int BUSINESS        =  4;
   public static final int PERSON          =  5;
   public static final int PROJECT         =  6;
//   public static final int CUSTOMER      =  7;
   public static final int CONTACT         =  8;  // this should replace all references CUSTOMER (and ultimates BUSINESS/FAMILY as well)
   public static final int DOMAIN          =  9;  // representing different 'sub-sites' of a main web site, such as wedding/party/more
   public static final int CONTACTSTATUS   = 10;
   public static final int WORKITEM        = 11;
   public static final int DELIVERABLE     = 12;
   public static final int LEDGERITEM      = 13;
   public static final int EVENT           = 14;
   public static final int ARTICLE         = 15;
   public static final int GALLERYITEM     = 16;

   public static final String[] TEXT = { "General",
                                          "Family",
                                          "Group",
                                          "Couple",
                                          "Business",
                                          "Person",
                                          "Project",
                                          "Customer",
                                          "Contact",
                                          "Domain",
                                          "ContactStatus",
                                          "WorkItem",
                                          "Deliverable",
                                          "Ledgeritem",
                                          "Event",
                                          "Article",
                                          "GalleryItem" };
}
