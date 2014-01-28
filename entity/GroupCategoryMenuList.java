package jwm.entity;

import jwm.db.*;
import jwm.idmanager.*;
import jwm.servletdb.*;
import jwm.idmanager.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class GroupCategoryMenuList implements CustomMenuItem
{
   public String toHTML( DBData dbData )
   {
       GroupCategoryList categories = new GroupCategoryList( dbData );

        String html = "            <select type=\"text\" name=\"category\" style=\"text-transform: none;\">";

        for (int i=0; i< categories.getRecordList().length; i++ )
        {
           GroupCategory aCategory = (GroupCategory) categories.getRecordList()[i];
           html += "\n<option value=\""+aCategory.getId()+"\">" + aCategory.getName() + "</option>";
        }
        html += "\n</select>";
        html += "<button type=\"submit\">Go</button>";
       return( html );
   }
}
