package jwm.entity;

import jwm.gl2.*;
import jwm.entity.*;
import jwm.db.*;
import jwm.servletdb.*;
import jwm.entity.db.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ContactStatus extends ContactStatusDBRecordBase
{

   private String categoryName ="";
   public  void   setCategoryName( String aCategoryName ) { categoryName = aCategoryName; }
   public  String getCategoryName() { return(categoryName); }

   private String categoryColor = "";
   public  void   setCategoryColor( String aCategoryColor ) { categoryColor = aCategoryColor; }
   public  String getCategoryColor() { return(categoryColor); }




   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactStatus( DBData aDbData, ResultSet results )
   {
      super( aDbData, results );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactStatus( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData, request, label );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactStatus( DBData aDbData, HttpServletRequest request )
   {
      super( aDbData, request, "" );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactStatus( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData, request, label, aId );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactStatus( DBData dbData )
   {
      super( dbData );
   }

   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====

   public ContactStatus( DBData dbData, String[] fields, int[] map )
   {
      super( dbData, fields, map );
   }

   public ContactStatus( DBData dbData, int aId )
   {
      super( dbData);
      populateObject( "ContactStatus", "ID", aId );

      ContactStatusCategory categoryObject = new ContactStatusCategory( dbData, category );
      categoryName = categoryObject.getName();
   }

   public ContactStatus( DBData dbData, String aName )
   {
      super( dbData);
      populateObject( "ContactStatus", "NAME ='"+aName+"'", "" );

      ContactStatusCategory categoryObject = new ContactStatusCategory( dbData, category );
      categoryName = categoryObject.getName();
   }

   public ContactStatusList getNextStateList()
   {
      EntityGroup ContactStatusGroup = new EntityGroup(dbData, name );
      ContactStatusGroup.deepPopulate();

      EntityGroupList nextStateGroups = ContactStatusGroup.getGGroupMembers();
      String names = "'---'"; // dummy for priming the string
      if (nextStateGroups != null )
      {
         if (nextStateGroups.getRecordList() != null )
         {
            for ( int i=0; i < nextStateGroups.getRecordList().length; i++ )
            {
               EntityGroup aGroup = (EntityGroup) nextStateGroups.getRecordList()[i];
               names += ", '"+aGroup.getName()+"'";
            }
         }
      }

      ContactStatusList nextStateList = new ContactStatusList( dbData, "name in ("+names+")", "" );

      return( nextStateList);
   }

   public String getHTML(int projectId)
   {
     ContactStatusCategory categoryObject = new ContactStatusCategory( dbData, category );
     String rc =  "<span class='"+categoryObject.getCss()+"'>"+name+"</span>";

     return(rc);
   }

   public static String getHTML( DBData dbData, Contact aContact )
   {
      ContactStatus aStatus = new ContactStatus( dbData, aContact.getStatus() );
      return( aStatus.getHTML(aContact.getId()));
   }

}
