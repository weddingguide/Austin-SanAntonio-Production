package jwm.entity;

import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public abstract class ListViewHandler
{
   protected String queryString;
   protected DBData dbData;
   protected HttpServletRequest request;
   protected String formInstanceId;
   public  void     setFormInstanceId( String aFormInstanceId ) { formInstanceId = aFormInstanceId; }
   public  String   getFormInstanceId() { return(formInstanceId); }


   protected int additionalQueryData = -1;
   public    void setAdditionalQueryData( int aAdditionalQueryData ) { additionalQueryData = aAdditionalQueryData; }
   public    int getAdditionalQueryData() { return(additionalQueryData); }


   public abstract String getActionButtonString();
   public abstract String getLastRowString();
   public abstract String getQueryString();
   public abstract String getTableHeaderString();
   public abstract String getTableRowString(int ndx);
   public abstract void init( DBData aDbData, HttpServletRequest aRequest );
   public abstract boolean RemoveRecord(int ndx);
   public abstract void setQueryString( String aQueryString );
}
