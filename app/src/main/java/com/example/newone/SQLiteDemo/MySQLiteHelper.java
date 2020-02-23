package com.example.newone.SQLiteDemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.newone.NavigationUser;

public class MySQLiteHelper extends SQLiteOpenHelper {
    private String TAG = "MySQLiteHelper";
    private Context context;
    private static final String DATABASE_NAME = "ngolist.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NGO = "ngo_demo";
    SQLiteDatabase sqLiteDatabaseObj1;
    MySQLiteHelper db;
//NGO TABLE INFO
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL= "email";
    public static final String COLUMN_MOBILE = "mobile";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_CITY= "city";
    public static final String COLUMN_STATE = "state";
    public static final String COLUMN_PINCODE = "pincode";
    public static final String COLUMN_NGOTYPE = "ngotype";
    public static final String COLUMN_DESCRIPTION = "description";

    //EVENT TABLE INFO
    //public static final String TABLE_EVENT="eventtable";
    //public static final String COLUMN_EVENT_ID="eventtable_id";
    //public static final String COLUMN_EVENT_NAME="eventtable_name";
    //public static final String COLUMN_EVENT_DATETIME="eventtable_datetime";
    //public static final String COLUMN_EVENT_PLACE="eventtable_place";
    //public static final String COLUMN_EVENT_DESCRIPTION="eventtable_description";
    //public static final String COLUMN_EVENT_PURPOSE="eventtable_purpose";
    //public static final String COLUMN_EVENT_BYNGO="eventtable_byngo";



//NGO TABLE QUERY
    private static final String DATABASE_CREATE =
        "CREATE TABLE " + TABLE_NGO + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
        + COLUMN_NAME + " TEXT ,"
        + COLUMN_EMAIL + " TEXT ,"
        + COLUMN_MOBILE + " TEXT,"
        + COLUMN_ADDRESS + " TEXT,"
        + COLUMN_CITY + " TEXT,"
        +COLUMN_STATE + " TEXT ,"
        +COLUMN_PINCODE + " INTEGER ,"
        +COLUMN_NGOTYPE + " TEXT,"
        + COLUMN_DESCRIPTION+  " TEXT"
        + ");";


 //private static final String EVENT_CREATE = "create table "
   //         + TABLE_EVENT + "(" + COLUMN_EVENT_ID
     //       + " INTEGER primary key autoincrement, " + COLUMN_EVENT_NAME
       //     + " TEXT ," + COLUMN_EVENT_DATETIME + " TEXT," + COLUMN_EVENT_PLACE + " TEXT," + COLUMN_EVENT_DESCRIPTION + " TEXT," +COLUMN_EVENT_PURPOSE +"TEXT,"  +COLUMN_EVENT_BYNGO + " TEXT," +");";



    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
 //       database.execSQL(TABLE_EVENT);

    }
    public Cursor getAllData( MySQLiteHelper db){
        sqLiteDatabaseObj1 = db.getWritableDatabase();
        Cursor res = db.getReadableDatabase().rawQuery("SELECT  * FROM ngo_demo",null);
        return res;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Log.w( MySQLiteHelper.class.getName(),
        //       "Upgrading database from version " + oldVersion + " to "
        //               + newVersion + ", which will destroy all old data");
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NGO);

        onCreate(db);
    }

}
