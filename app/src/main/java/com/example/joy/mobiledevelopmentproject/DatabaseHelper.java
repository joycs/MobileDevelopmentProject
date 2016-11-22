package com.example.joy.mobiledevelopmentproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by 300232405 on 11/21/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    final static String DATABASE_NAME="expensetracker.db";
    final static int DATABASE_VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE bills(billId INTEGER PRIMARY KEY, billName TEXT, billAmount TEXT, billDate TEXT)";
        db.execSQL(query);
        query = "CREATE TABLE income(incomeId INTEGER PRIMARY KEY, incomeName TEXT, incomeAmount TEXT)";
        db.execSQL(query);
        query = "CREATE TABLE budget(budgetId INTEGER PRIMARY KEY, budgetName TEXT, budgetAmount TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP table if exists " + TABLE_NAME);
        onCreate(db);
    }

    //add record method
    public boolean addRec(String table,ArrayList<String> s){
        //writable is moved from under super(context...) to here
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(table=="bills"){
            values.put("billName",s.get(0));
            values.put("billAmount",s.get(1));
            values.put("billDate",s.get(2));
        }
        long r = db.insert(table,null,values);
        if(r==-1)
            return false;
        else return true;
    }

    public Cursor viewRec(String table){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + table;
        Cursor res = db.rawQuery(query,null);
        return res;
    }

    //delete using sql
    public boolean deleteRec(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE from contactTable WHERE id = '" + id + "'";
        db.execSQL(query);
        return true;
    }
}
