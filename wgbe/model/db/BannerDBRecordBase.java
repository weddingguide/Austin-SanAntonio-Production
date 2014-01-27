package jwm.wgbe.model.db;
 
import jwm.db.*;
import jwm.servletdb.*;
import jwm.wgbe.model.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import org.apache.juli.*;
import org.w3c.dom.*;
 
public class BannerDBRecordBase extends ServletRecord
{
 
   public static final int OWNER = 0;
   public static final int LINK = 1;
   public static final int TARGET = 2;
   public static final int IMAGE = 3;
   public static final int DESCRIPTION = 4;
   public static final int NDX = 5;
 
   public static final String[] COLNAME = {
                                             "BANNER.OWNER",
                                             "BANNER.LINK",
                                             "BANNER.TARGET",
                                             "BANNER.IMAGE",
                                             "BANNER.DESCRIPTION",
                                             "BANNER.NDX"
                                                    };
 
   protected String owner = "";
   public    String getOwner() { return( owner ); }
   public     void setOwner( String aOwner ) { owner = aOwner; }
 
   protected String link = "";
   public    String getLink() { return( link ); }
   public     void setLink( String aLink ) { link = aLink; }
 
   protected String target = "";
   public    String getTarget() { return( target ); }
   public     void setTarget( String aTarget ) { target = aTarget; }
 
   protected String image = "";
   public    String getImage() { return( image ); }
   public     void setImage( String aImage ) { image = aImage; }
 
   protected String description = "";
   public    String getDescription() { return( description ); }
   public     void setDescription( String aDescription ) { description = aDescription; }
 
   protected int ndx;
   public    int getNdx() { return( ndx ); }
   public     void setNdx( int aNdx ) { ndx = aNdx; }
 
   protected int id;
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public BannerDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "BannerDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public BannerDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "BannerDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public BannerDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "BannerDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public BannerDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "BannerDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public BannerDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "BannerDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public BannerDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "BannerDBRecordBase constructor from array");
      for ( int i = 0; i<fields.length; i++ )
      {
          if ( map[i] != -1 )
          {
             if ( !fields[i].equals("") ) log.logEvent( log.TRACE, i + " " + fields[i] );
             dbColumns[ map[i] ].populateFromString( fields[ i ] );
          }
      }
      refreshLocalVariables();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void createColumnObjects( DBData aDbData )
   {
      dbColumns = new DBColumn[ 6 ];
      dbColumns[0] = new ServletStringColumn( aDbData, "BANNER.OWNER", "BANNER", "owner" );
      if ( owner == null ) owner = ((ServletStringColumn)dbColumns[0]).getValue(); // if it hasn't already been initialized...
      dbColumns[1] = new ServletStringColumn( aDbData, "BANNER.LINK", "BANNER", "link" );
      if ( link == null ) link = ((ServletStringColumn)dbColumns[1]).getValue(); // if it hasn't already been initialized...
      dbColumns[2] = new ServletStringColumn( aDbData, "BANNER.TARGET", "BANNER", "target" );
      if ( target == null ) target = ((ServletStringColumn)dbColumns[2]).getValue(); // if it hasn't already been initialized...
      dbColumns[3] = new ServletStringColumn( aDbData, "BANNER.IMAGE", "BANNER", "image" );
      if ( image == null ) image = ((ServletStringColumn)dbColumns[3]).getValue(); // if it hasn't already been initialized...
      dbColumns[4] = new ServletStringColumn( aDbData, "BANNER.DESCRIPTION", "BANNER", "description" );
      if ( description == null ) description = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
      dbColumns[5] = new ServletIntColumn( aDbData, "BANNER.NDX", "BANNER", "ndx" );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      owner = ((ServletStringColumn)dbColumns[0]).getValue();
      link = ((ServletStringColumn)dbColumns[1]).getValue();
      target = ((ServletStringColumn)dbColumns[2]).getValue();
      image = ((ServletStringColumn)dbColumns[3]).getValue();
      description = ((ServletStringColumn)dbColumns[4]).getValue();
      ndx = ((ServletIntColumn)dbColumns[5]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletStringColumn)dbColumns[0]).setValue( owner );
      ((ServletStringColumn)dbColumns[1]).setValue( link );
      ((ServletStringColumn)dbColumns[2]).setValue( target );
      ((ServletStringColumn)dbColumns[3]).setValue( image );
      ((ServletStringColumn)dbColumns[4]).setValue( description );
      ((ServletIntColumn)dbColumns[5]).setValue( ndx );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public String toString()
   {
         return( toString( "" ) );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public String toString( String prefix )
   {
      String retString = "\n" + prefix + "Banner Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    owner (BANNER.OWNER) -- ";
         retString += "localVar=\"" + owner.toString() + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    link (BANNER.LINK) -- ";
         retString += "localVar=\"" + link.toString() + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    target (BANNER.TARGET) -- ";
         retString += "localVar=\"" + target.toString() + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    image (BANNER.IMAGE) -- ";
         retString += "localVar=\"" + image.toString() + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    description (BANNER.DESCRIPTION) -- ";
         retString += "localVar=\"" + description.toString() + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    ndx (BANNER.NDX) -- ";
         retString += "localVar=\"" + Integer.toString( ndx) + "\";  ";
         retString += dbColumns[5].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
      }
         return( retString);
   }
   public String toCSVHeaderString(BannerViewBase viewDef, int ndx )
   {
      String retString = "";
      String ndxSuffix = "_"+ndx;
      if ( ndx == -1 ) ndxSuffix = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showOwner ) retString += commaSeparator(retString) + "owner" + ndxSuffix;
         if( viewDef.showLink ) retString += commaSeparator(retString) + "link" + ndxSuffix;
         if( viewDef.showTarget ) retString += commaSeparator(retString) + "target" + ndxSuffix;
         if( viewDef.showImage ) retString += commaSeparator(retString) + "image" + ndxSuffix;
         if( viewDef.showDescription ) retString += commaSeparator(retString) + "description" + ndxSuffix;
         if( viewDef.showNdx ) retString += commaSeparator(retString) + "ndx" + ndxSuffix;
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
   public String toCSVString(BannerViewBase viewDef )
   {
      String retString = "";
      try 
      {
         refreshColumnObjects();
         if( viewDef.showOwner ) retString += commaSeparator(retString) + CSVCell( owner);
         if( viewDef.showLink ) retString += commaSeparator(retString) + CSVCell( link);
         if( viewDef.showTarget ) retString += commaSeparator(retString) + CSVCell( target);
         if( viewDef.showImage ) retString += commaSeparator(retString) + CSVCell( image);
         if( viewDef.showDescription ) retString += commaSeparator(retString) + CSVCell( description);
         if( viewDef.showNdx ) retString += commaSeparator(retString) + CSVCell( ndx);
      }
      catch (Exception e)
      {
         retString += e.toString();
      }
         return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public boolean isValidDbCreate()
   {
      return( true );
   }
   public void getSQLCreateStatement()
   {
      sysLogger.info( "DROP TABLE BANNER;" );
      sysLogger.info( "CREATE TABLE BANNER ( BANNER.OWNER char, BANNER.LINK char, BANNER.TARGET char, BANNER.IMAGE char, BANNER.DESCRIPTION char, BANNER.NDX integer );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "Banner Object:";
      retString += "\n    owner (BANNER.OWNER) -- ";
      retString += "localVar=\"" + owner.toString() + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    link (BANNER.LINK) -- ";
      retString += "localVar=\"" + link.toString() + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    target (BANNER.TARGET) -- ";
      retString += "localVar=\"" + target.toString() + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    image (BANNER.IMAGE) -- ";
      retString += "localVar=\"" + image.toString() + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    description (BANNER.DESCRIPTION) -- ";
      retString += "localVar=\"" + description.toString() + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    ndx (BANNER.NDX) -- ";
      retString += "localVar=\"" + Integer.toString( ndx) + "\";  ";
      retString += dbColumns[5].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "owner", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "link", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "target", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "image", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "description", label ); 
      return( dBQuery );
   }
public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int qualifierCol, int qualifierValue, int logic )
   {
      DBQuery dBQuery = getDBQuery( aTableName, aDbData, request, label, logic );
     if ( !dBQuery.isNull() )
      {
         if ( qualifierValue != -1 )
         {
            dBQuery.add( aTableName, COLNAME[ qualifierCol ] + " = " + Integer.toString( qualifierValue ) );
         }
      }
      return( dBQuery );
   }
}
