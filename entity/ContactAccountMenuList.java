package jwm.entity;

import jwm.db.*;
import jwm.idmanager.*;
import jwm.servletdb.*;
import jwm.idmanager.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ContactAccountMenuList implements CustomMenuItem
{
   public String toHTML( DBData dbData )
   {
        String html = "";
        html += "<select type=\"text\" name=\"byAccount\" style=\"text-transform: none;\">";
        html += "\n<option value=\"RecentAccountActivity\">Recent Account Activity</option>";
        html += "\n<option value=\"AllOpenAccounts\">All Open Accounts</option>";
        html += "\n</select>";
        html += "\n<input type=hidden name=enablePayment value='*'>";
        html += "<button type=\"submit\">Go</button>";
       return( html );
   }
}
