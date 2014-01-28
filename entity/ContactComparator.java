package jwm.entity;

import java.util.*;

public class ContactComparator implements Comparator
{
    public int compare(Object contact1, Object contact2)
    {
       try
       {
          return( ((Contact)contact1).getTrackingDate().compareTo( ((Contact)contact2).getTrackingDate()));
       }
       catch( Exception e)
       {
       }
       return(0);
    }
}
