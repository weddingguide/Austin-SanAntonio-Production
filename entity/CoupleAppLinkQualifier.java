package jwm.entity;

import jwm.db.*;
import jwm.idmanager.*;
import jwm.servletdb.*;
import jwm.idmanager.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class CoupleAppLinkQualifier implements LinkQualifier
{
   public boolean showLink( DBData dbData, Person userPerson ) // returns true if logged on user is part of a 'couple' group
   {
       EntityGroupList groupList = new EntityGroupList( dbData, EntityGroup.TYPE_COUPLE, Person.RECORDTYPE_PERSON, userPerson.getPersonId() );
       if ( groupList.getRecordList().length > 0 ) return(true);
       return(false);
   }
}
