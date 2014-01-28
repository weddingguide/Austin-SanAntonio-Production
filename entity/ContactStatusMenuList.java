package jwm.entity;

import jwm.db.*;
import jwm.idmanager.*;
import jwm.servletdb.*;
import jwm.idmanager.db.*;
import jwm.logger.*;
import jwm.project.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ContactStatusMenuList implements CustomMenuItem
{
   public String toHTML( DBData dbData )
   {
       ProjectStatusList projectStatusList = new ProjectStatusList( dbData );

        String html = "            <select type=\"text\" name=\"status\" style=\"text-transform: none;\">";

        for (int i=0; i< projectStatusList.getRecordList().length; i++ )
        {
           ProjectStatus status = (ProjectStatus) projectStatusList.getRecordList()[i];
           html += "\n<option value=\""+status.getId()+"\">" + status.getName() + "</option>";
        }
        html += "\n</select>";
        html += "<button type=\"submit\">Go</button>";
       return( html );
   }
}
