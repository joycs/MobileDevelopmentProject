package com.example.joy.mobiledevelopmentproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 300232405 on 11/21/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    final static String DATABASE_NAME="contactinformation.db";
    final static String TABLE_NAME="contactTable";
    final static int DATABASE_VERSION = 1;
    final static String COL_1 = "id";
    final static String COL_2 = "Fname";
    final static String COL_3 = "Lname";
    final static String COL_4 = "phone";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_1 + " INTEGER PRIMARY KEY, " +
                COL_2 + " TEXT, " +
                COL_3 + " TEXT, " +
                COL_4 + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists " + TABLE_NAME);
        onCreate(db);
    }

    //delete using sql
    public boolean deleteRec(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE from contactTable WHERE id = '" + id + "'";
        db.execSQL(query);
        return true;
    }

    //add record method
    public boolean addRec(String fname,String lname,String ph){
        //writable is moved from under super(context...) to here
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2,fname);
        values.put(COL_3,lname);
        values.put(COL_4,ph);
        long r = db.insert(TABLE_NAME,null,values);
        if(r==-1)
            return false;
        else return true;
    }

    public Cursor viewRec(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + TABLE_NAME;
        Cursor res = db.rawQuery(query,null);
        return res;
    }
}
