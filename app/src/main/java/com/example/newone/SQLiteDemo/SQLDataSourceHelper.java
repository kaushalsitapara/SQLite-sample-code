package com.example.newone.SQLiteDemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.newone.AddNGO;
import com.example.newone.NGONameModel;

import java.util.ArrayList;
import java.util.List;

public class SQLDataSourceHelper {
    private static final String tag = "SQLDataSourceHelper";
    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    private String[] allColumns = {MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_NAME,MySQLiteHelper.COLUMN_EMAIL,MySQLiteHelper.COLUMN_MOBILE, MySQLiteHelper.COLUMN_ADDRESS,
            MySQLiteHelper.COLUMN_CITY, MySQLiteHelper.COLUMN_STATE,MySQLiteHelper.COLUMN_PINCODE,
            MySQLiteHelper.COLUMN_NGOTYPE,MySQLiteHelper.COLUMN_DESCRIPTION};
//private String[] allcolumns =
  //  {MySQLiteHelper.COLUMN_EVENT_ID,
    //        MySQLiteHelper.COLUMN_EVENT_NAME,MySQLiteHelper.COLUMN_EVENT_DATETIME,MySQLiteHelper.COLUMN_EVENT_PLACE, MySQLiteHelper.COLUMN_EVENT_DESCRIPTION,
      //      MySQLiteHelper.COLUMN_EVENT_PURPOSE,MySQLiteHelper.COLUMN_EVENT_BYNGO};



    public SQLDataSourceHelper(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        dbHelper.onOpen(database);// open database
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void save(String dateTime, String message, String orderid,
                     String title, String icon) {
        ContentValues values = new ContentValues( );
        values.put( MySQLiteHelper.COLUMN_NAME, dateTime );
        values.put( MySQLiteHelper.COLUMN_EMAIL, message );
        values.put( MySQLiteHelper.COLUMN_MOBILE, orderid );
        values.put( MySQLiteHelper.COLUMN_ADDRESS, icon );
        values.put( MySQLiteHelper.COLUMN_CITY, orderid );
        values.put( MySQLiteHelper.COLUMN_STATE, orderid );
        values.put( MySQLiteHelper.COLUMN_PINCODE, orderid );
        values.put( MySQLiteHelper.COLUMN_NGOTYPE, orderid );
        values.put( MySQLiteHelper.COLUMN_DESCRIPTION, orderid );

        database.insert( MySQLiteHelper.TABLE_NGO, null, values );




       // ContentValues values = new ContentValues( );
    //    values.put( MySQLiteHelper.COLUMN_EVENT_NAME, message );
      //  values.put( MySQLiteHelper.COLUMN_EVENT_DATETIME, message );
        //values.put( MySQLiteHelper.COLUMN_EVENT_PLACE, orderid );
    //    values.put( MySQLiteHelper.COLUMN_EVENT_DESCRIPTION, icon );
      //  values.put( MySQLiteHelper.COLUMN_EVENT_PURPOSE, orderid );
        //values.put( MySQLiteHelper.COLUMN_EVENT_BYNGO, orderid );

       // database.insert( MySQLiteHelper.TABLE_EVENT, null, values );

    }





    public void deletemsg(int idd) {
        Log.i( tag, "delete:message:" + idd);
        database.delete(MySQLiteHelper.TABLE_NGO,
                        MySQLiteHelper.COLUMN_ID + "=" + idd, null);



    //    Log.i( tag, "delete:message:" + idd);
     //   database.delete(MySQLiteHelper.TABLE_EVENT,
       //                 MySQLiteHelper.COLUMN_ID + "=" + idd, null);
    }



    public List<NGONameModel> get(String limit) {
        List<NGONameModel> gcmMessages = new ArrayList<NGONameModel>();
        Cursor cursor = database.query( MySQLiteHelper.TABLE_NGO,
                                        allColumns, null, null, null, null, "id ASC", limit);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            NGONameModel gcmMessage = cursorToGcmMessage( cursor);
            gcmMessages.add(gcmMessage);
            cursor.moveToNext();
        }

        // Make sure to close the cursor
        cursor.close();
        return gcmMessages;
    }


    private NGONameModel cursorToGcmMessage(Cursor cursor) {
        NGONameModel gcmMessage = new NGONameModel();

        gcmMessage.setNgoId(cursor.getInt(0));
        gcmMessage.setNgoName(cursor.getString(1));
        gcmMessage.setNgoEmail(cursor.getString(2));
        gcmMessage.setNgoMobile(cursor.getString(3));
        gcmMessage.setNgoAddress(cursor.getString(4));
        gcmMessage.setNgoCity(cursor.getString(5));
        gcmMessage.setNgoState(cursor.getString(6));
        gcmMessage.setNgoPincode(cursor.getInt(7));
        gcmMessage.setNgoNgoType(cursor.getString(8));
        gcmMessage.setNgoDescription(cursor.getString(9));
        return gcmMessage;

    }


    public String[] getAllColumns() {
        return allColumns;
    }

    public void setAllColumns(String[] allColumns) {
        this.allColumns = allColumns;
    }
}
