package jwm.wgbe;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.*;
import jwm.jsputils.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StdWGBEReportViewHandler extends StdPersonListViewHandler
{
   public String getActionButtonString()
   {
      return("");
   }

   public String getLastRowString()
   {
      return("");
   }

   public String getTableHeaderString()
   {
      return( "***" );
   }

   public String getTableRowString(int ndx)
   {
      return( "***" );
   }
}
