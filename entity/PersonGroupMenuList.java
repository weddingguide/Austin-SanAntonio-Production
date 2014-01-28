package jwm.entity;

import jwm.db.*;
import jwm.idmanager.*;
import jwm.servletdb.*;
import jwm.idmanager.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class PersonGroupMenuList implements CustomMenuItem
{
   public String toHTML( DBData dbData )
   {
       EntityGroupList personGroups = new EntityGroupList( dbData, "People Groups" );

        String html = "            <select type=\"text\" name=\"groupNum\" style=\"text-transform: none;\">";

        for (int i=0; i< personGroups.getRecordList().length; i++ )
        {
           EntityGroup personGroup = (EntityGroup) personGroups.getRecordList()[i];
           html += "\n<option value=\""+personGroup.getId()+"\">" + personGroup.getName() + "</option>";
        }
        html += "\n</select>";
        html += "<button type=\"submit\">Go</button>";
        html += "<input type=hidden name=GroupList>";
       return( html );
   }
}
