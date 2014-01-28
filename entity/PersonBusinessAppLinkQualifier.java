package jwm.entity;

import jwm.db.*;
import jwm.idmanager.*;
import jwm.servletdb.*;
import jwm.idmanager.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class PersonBusinessAppLinkQualifier implements LinkQualifier
{
   public boolean showLink( DBData dbData, Person userPerson ) // returns true if logged on user is listed as a contact for any businesses
   {
       EntityGroupList businessList = new EntityGroupList( dbData, EntityGroup.TYPE_BUSINESS, userPerson.getPersonId(), true );
       if ( businessList.getRecordList().length > 0 ) return(true);
       return(false);
   }
}
