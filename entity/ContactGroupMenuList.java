package jwm.entity;

import jwm.db.*;
import jwm.idmanager.*;
import jwm.servletdb.*;
import jwm.idmanager.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ContactGroupMenuList implements CustomMenuItem
{
   public String toHTML( DBData dbData )
   {
       EntityGroupList contactGroups = new EntityGroupList( dbData, 0, ObjectClassID.CONTACT );

        String html = "            <select type=\"text\" name=\"groupName\" style=\"text-transform: none;\">";

        for (int i=0; i< contactGroups.getRecordList().length; i++ )
        {
           EntityGroup contactGroup = (EntityGroup) contactGroups.getRecordList()[i];
           html += "\n<option value=\""+contactGroup.getName()+"\">" + contactGroup.getName() + "</option>";
        }
        html += "\n</select>";
        html += "<button type=\"submit\">Go</button>";
       return( html );
   }
}
