package jwm.wgbe.db;
 
import jwm.db.*;
import jwm.servletdb.*;
import jwm.wgbe.*;
import jwm.logger.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class ExhibitorDBRecordBase extends ServletRecord
{
 
   public static final int ID = 0;
   public static final int ORDERNUMBER = 1;
   public static final int OWNERID = 2;
   public static final int PARENTGROUP = 3;
   public static final int BOOTH = 4;
   public static final int CORNER = 5;
   public static final int TABLE4FT = 6;
   public static final int TABLE6FT = 7;
   public static final int TABLE8FT = 8;
   public static final int ELECTRICITY = 9;
   public static final int CARPET = 10;
   public static final int DUEMONEY = 11;
   public static final int TOTALMONEY = 12;
   public static final int BOOTHMONEY = 13;
   public static final int ELECMONEY = 14;
   public static final int CARPETMONEY = 15;
   public static final int TABLEMONEY = 16;
   public static final int SHOWSIGN = 17;
   public static final int MISCMONEY = 18;
   public static final int SHOWNOTES = 19;
 
   public static final String[] COLNAME = {
                                             "EXHIBITOR.ID",
                                             "EXHIBITOR.ORDERNUMBER",
                                             "EXHIBITOR.OWNERID",
                                             "EXHIBITOR.PARENTGROUP",
                                             "EXHIBITOR.BOOTH",
                                             "EXHIBITOR.CORNER",
                                             "EXHIBITOR.TABLE4FT",
                                             "EXHIBITOR.TABLE6FT",
                                             "EXHIBITOR.TABLE8FT",
                                             "EXHIBITOR.ELECTRICITY",
                                             "EXHIBITOR.CARPET",
                                             "EXHIBITOR.DUEMONEY",
                                             "EXHIBITOR.TOTALMONEY",
                                             "EXHIBITOR.BOOTHMONEY",
                                             "EXHIBITOR.ELECMONEY",
                                             "EXHIBITOR.CARPETMONEY",
                                             "EXHIBITOR.TABLEMONEY",
                                             "EXHIBITOR.SHOWSIGN",
                                             "EXHIBITOR.MISCMONEY",
                                             "EXHIBITOR.SHOWNOTES"
                                                    };
 
   protected int id;
   public    int getId() { return( id ); }
   public     void setId( int aId ) { id = aId; }
 
   protected int orderNumber;
   public    int getOrderNumber() { return( orderNumber ); }
   public     void setOrderNumber( int aOrderNumber ) { orderNumber = aOrderNumber; }
 
   protected int ownerId;
   public    int getOwnerId() { return( ownerId ); }
   public     void setOwnerId( int aOwnerId ) { ownerId = aOwnerId; }
 
   protected int parentGroup;
   public    int getParentGroup() { return( parentGroup ); }
   public     void setParentGroup( int aParentGroup ) { parentGroup = aParentGroup; }
 
   protected String booth = "";
   public    String getBooth() { return( booth ); }
   public     void setBooth( String aBooth ) { booth = aBooth; }
 
   protected int corner;
   public    int getCorner() { return( corner ); }
   public     void setCorner( int aCorner ) { corner = aCorner; }
 
   protected int table4Ft;
   public    int getTable4Ft() { return( table4Ft ); }
   public     void setTable4Ft( int aTable4Ft ) { table4Ft = aTable4Ft; }
 
   protected int table6Ft;
   public    int getTable6Ft() { return( table6Ft ); }
   public     void setTable6Ft( int aTable6Ft ) { table6Ft = aTable6Ft; }
 
   protected int table8Ft;
   public    int getTable8Ft() { return( table8Ft ); }
   public     void setTable8Ft( int aTable8Ft ) { table8Ft = aTable8Ft; }
 
   protected int electricity;
   public    int getElectricity() { return( electricity ); }
   public     void setElectricity( int aElectricity ) { electricity = aElectricity; }
 
   protected int carpet;
   public    int getCarpet() { return( carpet ); }
   public     void setCarpet( int aCarpet ) { carpet = aCarpet; }
 
   protected String dueMoney = "";
   public    String getDueMoney() { return( dueMoney ); }
   public     void setDueMoney( String aDueMoney ) { dueMoney = aDueMoney; }
 
   protected String totalMoney = "";
   public    String getTotalMoney() { return( totalMoney ); }
   public     void setTotalMoney( String aTotalMoney ) { totalMoney = aTotalMoney; }
 
   protected String boothMoney = "";
   public    String getBoothMoney() { return( boothMoney ); }
   public     void setBoothMoney( String aBoothMoney ) { boothMoney = aBoothMoney; }
 
   protected String elecMoney = "";
   public    String getElecMoney() { return( elecMoney ); }
   public     void setElecMoney( String aElecMoney ) { elecMoney = aElecMoney; }
 
   protected String carpetMoney = "";
   public    String getCarpetMoney() { return( carpetMoney ); }
   public     void setCarpetMoney( String aCarpetMoney ) { carpetMoney = aCarpetMoney; }
 
   protected String tableMoney = "";
   public    String getTableMoney() { return( tableMoney ); }
   public     void setTableMoney( String aTableMoney ) { tableMoney = aTableMoney; }
 
   protected String showSign = "";
   public    String getShowSign() { return( showSign ); }
   public     void setShowSign( String aShowSign ) { showSign = aShowSign; }
 
   protected String miscMoney = "";
   public    String getMiscMoney() { return( miscMoney ); }
   public     void setMiscMoney( String aMiscMoney ) { miscMoney = aMiscMoney; }
 
   protected String showNotes = "";
   public    String getShowNotes() { return( showNotes ); }
   public     void setShowNotes( String aShowNotes ) { showNotes = aShowNotes; }
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ExhibitorDBRecordBase( DBData aDbData, ResultSet results )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( results );
//    log.logEvent( log.TRACE, "ExhibitorDBRecordBase constructor from ResultSet");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ExhibitorDBRecordBase( DBData aDbData, HttpServletRequest request, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( request, label );
//    log.logEvent( log.TRACE, "ExhibitorDBRecordBase constructor from label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ExhibitorDBRecordBase( DBData aDbData, Hashtable hashTable, String label )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      populateObject( hashTable, label );
//    log.logEvent( log.TRACE, "ExhibitorDBRecordBase constructor from hashTable - label: " + label );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ExhibitorDBRecordBase( DBData aDbData, HttpServletRequest request, String label, int aId )
   {
      super( aDbData );
      createColumnObjects( aDbData );
      id = aId;
      populateObject( request, label );
//    log.logEvent( log.TRACE, "ExhibitorDBRecordBase constructor from label: " + label + " & id: " + id );
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ExhibitorDBRecordBase( DBData dbData )
   {
      super( dbData );
      createColumnObjects( dbData );
//    log.logEvent( log.TRACE, "ExhibitorDBRecordBase basic constructor");
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public ExhibitorDBRecordBase( DBData dbData, String[] fields, int[] map )
   {
      super( dbData );
      createColumnObjects( dbData );
      log.logEvent( log.TRACE, "ExhibitorDBRecordBase constructor from array");
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
      dbColumns = new DBColumn[ 20 ];
      dbColumns[0] = new ServletGeneratedIntColumn( aDbData, "EXHIBITOR.ID", "EXHIBITOR", "id" );
      dbColumns[1] = new ServletIntColumn( aDbData, "EXHIBITOR.ORDERNUMBER", "EXHIBITOR", "orderNumber" );
      dbColumns[2] = new ServletIntColumn( aDbData, "EXHIBITOR.OWNERID", "EXHIBITOR", "ownerId" );
      dbColumns[3] = new ServletIntColumn( aDbData, "EXHIBITOR.PARENTGROUP", "EXHIBITOR", "parentGroup" );
      dbColumns[4] = new ServletStringColumn( aDbData, "EXHIBITOR.BOOTH", "EXHIBITOR", "booth" );
      if ( booth == null ) booth = ((ServletStringColumn)dbColumns[4]).getValue(); // if it hasn't already been initialized...
      dbColumns[5] = new ServletBoolIntColumn( aDbData, "EXHIBITOR.CORNER", "EXHIBITOR", "corner" );
      dbColumns[6] = new ServletIntColumn( aDbData, "EXHIBITOR.TABLE4FT", "EXHIBITOR", "table4Ft" );
      dbColumns[7] = new ServletIntColumn( aDbData, "EXHIBITOR.TABLE6FT", "EXHIBITOR", "table6Ft" );
      dbColumns[8] = new ServletIntColumn( aDbData, "EXHIBITOR.TABLE8FT", "EXHIBITOR", "table8Ft" );
      dbColumns[9] = new ServletBoolIntColumn( aDbData, "EXHIBITOR.ELECTRICITY", "EXHIBITOR", "electricity" );
      dbColumns[10] = new ServletIntColumn( aDbData, "EXHIBITOR.CARPET", "EXHIBITOR", "carpet" );
      dbColumns[11] = new ServletStringColumn( aDbData, "EXHIBITOR.DUEMONEY", "EXHIBITOR", "dueMoney" );
      if ( dueMoney == null ) dueMoney = ((ServletStringColumn)dbColumns[11]).getValue(); // if it hasn't already been initialized...
      dbColumns[12] = new ServletStringColumn( aDbData, "EXHIBITOR.TOTALMONEY", "EXHIBITOR", "totalMoney" );
      if ( totalMoney == null ) totalMoney = ((ServletStringColumn)dbColumns[12]).getValue(); // if it hasn't already been initialized...
      dbColumns[13] = new ServletStringColumn( aDbData, "EXHIBITOR.BOOTHMONEY", "EXHIBITOR", "boothMoney" );
      if ( boothMoney == null ) boothMoney = ((ServletStringColumn)dbColumns[13]).getValue(); // if it hasn't already been initialized...
      dbColumns[14] = new ServletStringColumn( aDbData, "EXHIBITOR.ELECMONEY", "EXHIBITOR", "elecMoney" );
      if ( elecMoney == null ) elecMoney = ((ServletStringColumn)dbColumns[14]).getValue(); // if it hasn't already been initialized...
      dbColumns[15] = new ServletStringColumn( aDbData, "EXHIBITOR.CARPETMONEY", "EXHIBITOR", "carpetMoney" );
      if ( carpetMoney == null ) carpetMoney = ((ServletStringColumn)dbColumns[15]).getValue(); // if it hasn't already been initialized...
      dbColumns[16] = new ServletStringColumn( aDbData, "EXHIBITOR.TABLEMONEY", "EXHIBITOR", "tableMoney" );
      if ( tableMoney == null ) tableMoney = ((ServletStringColumn)dbColumns[16]).getValue(); // if it hasn't already been initialized...
      dbColumns[17] = new ServletStringColumn( aDbData, "EXHIBITOR.SHOWSIGN", "EXHIBITOR", "showSign" );
      if ( showSign == null ) showSign = ((ServletStringColumn)dbColumns[17]).getValue(); // if it hasn't already been initialized...
      dbColumns[18] = new ServletStringColumn( aDbData, "EXHIBITOR.MISCMONEY", "EXHIBITOR", "miscMoney" );
      if ( miscMoney == null ) miscMoney = ((ServletStringColumn)dbColumns[18]).getValue(); // if it hasn't already been initialized...
      dbColumns[19] = new ServletStringColumn( aDbData, "EXHIBITOR.SHOWNOTES", "EXHIBITOR", "showNotes" );
      if ( showNotes == null ) showNotes = ((ServletStringColumn)dbColumns[19]).getValue(); // if it hasn't already been initialized...
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshLocalVariables()
   {
      id = ((ServletGeneratedIntColumn)dbColumns[0]).getValue();
      orderNumber = ((ServletIntColumn)dbColumns[1]).getValue();
      ownerId = ((ServletIntColumn)dbColumns[2]).getValue();
      parentGroup = ((ServletIntColumn)dbColumns[3]).getValue();
      booth = ((ServletStringColumn)dbColumns[4]).getValue();
      corner = ((ServletBoolIntColumn)dbColumns[5]).getValue();
      table4Ft = ((ServletIntColumn)dbColumns[6]).getValue();
      table6Ft = ((ServletIntColumn)dbColumns[7]).getValue();
      table8Ft = ((ServletIntColumn)dbColumns[8]).getValue();
      electricity = ((ServletBoolIntColumn)dbColumns[9]).getValue();
      carpet = ((ServletIntColumn)dbColumns[10]).getValue();
      dueMoney = ((ServletStringColumn)dbColumns[11]).getValue();
      totalMoney = ((ServletStringColumn)dbColumns[12]).getValue();
      boothMoney = ((ServletStringColumn)dbColumns[13]).getValue();
      elecMoney = ((ServletStringColumn)dbColumns[14]).getValue();
      carpetMoney = ((ServletStringColumn)dbColumns[15]).getValue();
      tableMoney = ((ServletStringColumn)dbColumns[16]).getValue();
      showSign = ((ServletStringColumn)dbColumns[17]).getValue();
      miscMoney = ((ServletStringColumn)dbColumns[18]).getValue();
      showNotes = ((ServletStringColumn)dbColumns[19]).getValue();
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   protected void refreshColumnObjects()
   {
      ((ServletGeneratedIntColumn)dbColumns[0]).setValue( id );
      ((ServletIntColumn)dbColumns[1]).setValue( orderNumber );
      ((ServletIntColumn)dbColumns[2]).setValue( ownerId );
      ((ServletIntColumn)dbColumns[3]).setValue( parentGroup );
      ((ServletStringColumn)dbColumns[4]).setValue( booth );
      ((ServletBoolIntColumn)dbColumns[5]).setValue( corner );
      ((ServletIntColumn)dbColumns[6]).setValue( table4Ft );
      ((ServletIntColumn)dbColumns[7]).setValue( table6Ft );
      ((ServletIntColumn)dbColumns[8]).setValue( table8Ft );
      ((ServletBoolIntColumn)dbColumns[9]).setValue( electricity );
      ((ServletIntColumn)dbColumns[10]).setValue( carpet );
      ((ServletStringColumn)dbColumns[11]).setValue( dueMoney );
      ((ServletStringColumn)dbColumns[12]).setValue( totalMoney );
      ((ServletStringColumn)dbColumns[13]).setValue( boothMoney );
      ((ServletStringColumn)dbColumns[14]).setValue( elecMoney );
      ((ServletStringColumn)dbColumns[15]).setValue( carpetMoney );
      ((ServletStringColumn)dbColumns[16]).setValue( tableMoney );
      ((ServletStringColumn)dbColumns[17]).setValue( showSign );
      ((ServletStringColumn)dbColumns[18]).setValue( miscMoney );
      ((ServletStringColumn)dbColumns[19]).setValue( showNotes );
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
      String retString = "\n" + prefix + "Exhibitor Object:";
      try 
      {
         refreshColumnObjects();
         retString += "\n"+ prefix +   "    id (EXHIBITOR.ID) -- ";
         retString += "localVar=\"" + Integer.toString( id) + "\";  ";
         retString += dbColumns[0].toString();
         retString += "\n"+ prefix +   "    orderNumber (EXHIBITOR.ORDERNUMBER) -- ";
         retString += "localVar=\"" + Integer.toString( orderNumber) + "\";  ";
         retString += dbColumns[1].toString();
         retString += "\n"+ prefix +   "    ownerId (EXHIBITOR.OWNERID) -- ";
         retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
         retString += dbColumns[2].toString();
         retString += "\n"+ prefix +   "    parentGroup (EXHIBITOR.PARENTGROUP) -- ";
         retString += "localVar=\"" + Integer.toString( parentGroup) + "\";  ";
         retString += dbColumns[3].toString();
         retString += "\n"+ prefix +   "    booth (EXHIBITOR.BOOTH) -- ";
         retString += "localVar=\"" + booth.toString() + "\";  ";
         retString += dbColumns[4].toString();
         retString += "\n"+ prefix +   "    corner (EXHIBITOR.CORNER) -- ";
         retString += "localVar=\"" + Integer.toString( corner) + "\";  ";
         retString += dbColumns[5].toString();
         retString += "\n"+ prefix +   "    table4Ft (EXHIBITOR.TABLE4FT) -- ";
         retString += "localVar=\"" + Integer.toString( table4Ft) + "\";  ";
         retString += dbColumns[6].toString();
         retString += "\n"+ prefix +   "    table6Ft (EXHIBITOR.TABLE6FT) -- ";
         retString += "localVar=\"" + Integer.toString( table6Ft) + "\";  ";
         retString += dbColumns[7].toString();
         retString += "\n"+ prefix +   "    table8Ft (EXHIBITOR.TABLE8FT) -- ";
         retString += "localVar=\"" + Integer.toString( table8Ft) + "\";  ";
         retString += dbColumns[8].toString();
         retString += "\n"+ prefix +   "    electricity (EXHIBITOR.ELECTRICITY) -- ";
         retString += "localVar=\"" + Integer.toString( electricity) + "\";  ";
         retString += dbColumns[9].toString();
         retString += "\n"+ prefix +   "    carpet (EXHIBITOR.CARPET) -- ";
         retString += "localVar=\"" + Integer.toString( carpet) + "\";  ";
         retString += dbColumns[10].toString();
         retString += "\n"+ prefix +   "    dueMoney (EXHIBITOR.DUEMONEY) -- ";
         retString += "localVar=\"" + dueMoney.toString() + "\";  ";
         retString += dbColumns[11].toString();
         retString += "\n"+ prefix +   "    totalMoney (EXHIBITOR.TOTALMONEY) -- ";
         retString += "localVar=\"" + totalMoney.toString() + "\";  ";
         retString += dbColumns[12].toString();
         retString += "\n"+ prefix +   "    boothMoney (EXHIBITOR.BOOTHMONEY) -- ";
         retString += "localVar=\"" + boothMoney.toString() + "\";  ";
         retString += dbColumns[13].toString();
         retString += "\n"+ prefix +   "    elecMoney (EXHIBITOR.ELECMONEY) -- ";
         retString += "localVar=\"" + elecMoney.toString() + "\";  ";
         retString += dbColumns[14].toString();
         retString += "\n"+ prefix +   "    carpetMoney (EXHIBITOR.CARPETMONEY) -- ";
         retString += "localVar=\"" + carpetMoney.toString() + "\";  ";
         retString += dbColumns[15].toString();
         retString += "\n"+ prefix +   "    tableMoney (EXHIBITOR.TABLEMONEY) -- ";
         retString += "localVar=\"" + tableMoney.toString() + "\";  ";
         retString += dbColumns[16].toString();
         retString += "\n"+ prefix +   "    showSign (EXHIBITOR.SHOWSIGN) -- ";
         retString += "localVar=\"" + showSign.toString() + "\";  ";
         retString += dbColumns[17].toString();
         retString += "\n"+ prefix +   "    miscMoney (EXHIBITOR.MISCMONEY) -- ";
         retString += "localVar=\"" + miscMoney.toString() + "\";  ";
         retString += dbColumns[18].toString();
         retString += "\n"+ prefix +   "    showNotes (EXHIBITOR.SHOWNOTES) -- ";
         retString += "localVar=\"" + showNotes.toString() + "\";  ";
         retString += dbColumns[19].toString();
      }
      catch (Exception e)
      {
         retString += "\n"+ prefix + e.toString();
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
      System.out.println( "DROP TABLE EXHIBITOR;" );
      System.out.println( "CREATE TABLE EXHIBITOR ( EXHIBITOR.ID integer, EXHIBITOR.ORDERNUMBER integer, EXHIBITOR.OWNERID integer, EXHIBITOR.PARENTGROUP integer, EXHIBITOR.BOOTH char, EXHIBITOR.CORNER integer, EXHIBITOR.TABLE4FT integer, EXHIBITOR.TABLE6FT integer, EXHIBITOR.TABLE8FT integer, EXHIBITOR.ELECTRICITY integer, EXHIBITOR.CARPET integer, EXHIBITOR.DUEMONEY char, EXHIBITOR.TOTALMONEY char, EXHIBITOR.BOOTHMONEY char, EXHIBITOR.ELECMONEY char, EXHIBITOR.CARPETMONEY char, EXHIBITOR.TABLEMONEY char, EXHIBITOR.SHOWSIGN char, EXHIBITOR.MISCMONEY char, EXHIBITOR.SHOWNOTES char );" );
   }
   public String exportSQLInsertStatement()
   {
      refreshColumnObjects();
      String retString = "Exhibitor Object:";
      retString += "\n    id (EXHIBITOR.ID) -- ";
      retString += "localVar=\"" + Integer.toString( id) + "\";  ";
      retString += dbColumns[0].toString();
      retString += "\n    orderNumber (EXHIBITOR.ORDERNUMBER) -- ";
      retString += "localVar=\"" + Integer.toString( orderNumber) + "\";  ";
      retString += dbColumns[1].toString();
      retString += "\n    ownerId (EXHIBITOR.OWNERID) -- ";
      retString += "localVar=\"" + Integer.toString( ownerId) + "\";  ";
      retString += dbColumns[2].toString();
      retString += "\n    parentGroup (EXHIBITOR.PARENTGROUP) -- ";
      retString += "localVar=\"" + Integer.toString( parentGroup) + "\";  ";
      retString += dbColumns[3].toString();
      retString += "\n    booth (EXHIBITOR.BOOTH) -- ";
      retString += "localVar=\"" + booth.toString() + "\";  ";
      retString += dbColumns[4].toString();
      retString += "\n    corner (EXHIBITOR.CORNER) -- ";
      retString += "localVar=\"" + Integer.toString( corner) + "\";  ";
      retString += dbColumns[5].toString();
      retString += "\n    table4Ft (EXHIBITOR.TABLE4FT) -- ";
      retString += "localVar=\"" + Integer.toString( table4Ft) + "\";  ";
      retString += dbColumns[6].toString();
      retString += "\n    table6Ft (EXHIBITOR.TABLE6FT) -- ";
      retString += "localVar=\"" + Integer.toString( table6Ft) + "\";  ";
      retString += dbColumns[7].toString();
      retString += "\n    table8Ft (EXHIBITOR.TABLE8FT) -- ";
      retString += "localVar=\"" + Integer.toString( table8Ft) + "\";  ";
      retString += dbColumns[8].toString();
      retString += "\n    electricity (EXHIBITOR.ELECTRICITY) -- ";
      retString += "localVar=\"" + Integer.toString( electricity) + "\";  ";
      retString += dbColumns[9].toString();
      retString += "\n    carpet (EXHIBITOR.CARPET) -- ";
      retString += "localVar=\"" + Integer.toString( carpet) + "\";  ";
      retString += dbColumns[10].toString();
      retString += "\n    dueMoney (EXHIBITOR.DUEMONEY) -- ";
      retString += "localVar=\"" + dueMoney.toString() + "\";  ";
      retString += dbColumns[11].toString();
      retString += "\n    totalMoney (EXHIBITOR.TOTALMONEY) -- ";
      retString += "localVar=\"" + totalMoney.toString() + "\";  ";
      retString += dbColumns[12].toString();
      retString += "\n    boothMoney (EXHIBITOR.BOOTHMONEY) -- ";
      retString += "localVar=\"" + boothMoney.toString() + "\";  ";
      retString += dbColumns[13].toString();
      retString += "\n    elecMoney (EXHIBITOR.ELECMONEY) -- ";
      retString += "localVar=\"" + elecMoney.toString() + "\";  ";
      retString += dbColumns[14].toString();
      retString += "\n    carpetMoney (EXHIBITOR.CARPETMONEY) -- ";
      retString += "localVar=\"" + carpetMoney.toString() + "\";  ";
      retString += dbColumns[15].toString();
      retString += "\n    tableMoney (EXHIBITOR.TABLEMONEY) -- ";
      retString += "localVar=\"" + tableMoney.toString() + "\";  ";
      retString += dbColumns[16].toString();
      retString += "\n    showSign (EXHIBITOR.SHOWSIGN) -- ";
      retString += "localVar=\"" + showSign.toString() + "\";  ";
      retString += dbColumns[17].toString();
      retString += "\n    miscMoney (EXHIBITOR.MISCMONEY) -- ";
      retString += "localVar=\"" + miscMoney.toString() + "\";  ";
      retString += dbColumns[18].toString();
      retString += "\n    showNotes (EXHIBITOR.SHOWNOTES) -- ";
      retString += "localVar=\"" + showNotes.toString() + "\";  ";
      retString += dbColumns[19].toString();
      return( retString);
   }
 
   //====generated===========generated=========generated==========generated=====
   //====generated===========generated=========generated==========generated=====
 
   public static DBQuery getDBQuery( String aTableName, DBData aDbData, HttpServletRequest request, String label, int logic )
   {
      DBQuery dBQuery = new DBQuery( logic ); 
      buildFieldQuery( aTableName, dBQuery, request, "booth", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "dueMoney", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "totalMoney", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "boothMoney", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "elecMoney", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "carpetMoney", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "tableMoney", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "showSign", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "miscMoney", label ); 
      buildFieldQuery( aTableName, dBQuery, request, "showNotes", label ); 
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
