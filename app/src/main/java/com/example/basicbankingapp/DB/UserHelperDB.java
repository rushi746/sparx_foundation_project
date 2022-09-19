package com.example.basicbankingapp.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContractDB.UserEntry;

public class UserHelperDB extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelperDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Anshul Ghumadwar', 'anshulghumadwar04@gmail.com','7584','7895641238', 150000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Rakesh Vaidya', 'rakeshvaidya@gmail.com','1258','8995641238', 50000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Rahul Dhole', 'dholerahul@gmail.com','8896','7595645896', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Krunal Sidam', 'sidamkrunal12@gmail.com','7752','9995640038', 80000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Sanket Deshmukh', 'sanketdeshmukh@gmail.com','3669','9095648962', 75000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Sudhanshu Deshmukh', 'sudhanshu0512@gmail.com','9985','8855640238', 65000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Sakshi Deshmukh', 'deshmukhs02@gmail.com','1207','8895640215', 45000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Shruti Lambe', 'lambeshruti0587@gmail.com','4522','9985021539', 25000)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Shital Punde', 'shitalpunde05@gmail.com','6582','9309565238', 105000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Ashutosh Bisen', 'bisenashu@gmail.com','5450','8292591201', 99000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Nikhil Jadhav', 'nikhiljadhav05@gmail.com','2656','9015641200', 98000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Ashish Mehare', 'ashish0527@gmail.com','1203','9995641999', 110000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Tushar Dathe', 'dathetr058@gmail.com','5566','9119541001', 58000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Mangesh Deshmukh', 'mangesg05@gmail.com','2236','6254642205', 35000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Anup Ghumadwar', 'ghumadwaranup@gmail.com','6692','6893641266', 10100)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}