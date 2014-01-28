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
 
public class NNWedCoupleList extends NNWedCoupleListDBRecordBase
{
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public NNWedCoupleList( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public NNWedCoupleList( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public NNWedCoupleList( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public NNWedCoupleList( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public NNWedCoupleList( DBData dbData )
   {
      super( dbData );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public NNWedCoupleList( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }
}
