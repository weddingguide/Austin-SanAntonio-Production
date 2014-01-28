package jwm.entity;

import jwm.entity.db.*;
import jwm.logger.*;
import java.util.*;

public class WeddingDateComparator implements Comparator
{
   public int compare( Object o1, Object o2 )
   {
      EntityGroup coupleGroup1 = (EntityGroup) o1;
      EntityGroup coupleGroup2 = (EntityGroup) o2;

      CoupleGroupInfo coupleInfo1 = (CoupleGroupInfo) coupleGroup1.getGroupInfo();
      CoupleGroupInfo coupleInfo2 = (CoupleGroupInfo) coupleGroup2.getGroupInfo();
      return ( coupleInfo1.getWeddingEvent().getDate().compareTo( coupleInfo2.getWeddingEvent().getDate() ) );
   }

   public boolean equals( Object o)
   {
      return(false);
   }
}

