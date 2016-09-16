package com.example.jay.mydatabaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jay on 9/16/2016.
 *
 * This (SQLiteOpenHelper) gives some methods to perform DataBase operations
 */
public class UserDbHelper extends SQLiteOpenHelper {

    // you have to define the database name and version
    private static final String DATABASE_NAME = "userInfo.DB";
    private static final int DATABASE_VERSIONS = 1;
    // Creating the QUERY for querying the database later on
    private static final String CREATE_QUERY =
            "CREATE TABLE "+ UserContract.newUserInfo.TABLE_NAME+" ("+ UserContract.newUserInfo.USER_NAME+" TEXT,"+
                    UserContract.newUserInfo.USER_MOB+" TEXT,"+ UserContract.newUserInfo.USER_EMAIL+" TEXT);";
    // no default constructor is available so you call one yourself
    public UserDbHelper(Context context){
        // call superclass constructor in this method

        super(context, DATABASE_NAME, null, DATABASE_VERSIONS);
        Log.e("DATABASE OPERATIONS", "Database created / opened...");
    }
    @Override

    // OnCreate method means if the database is called for the first time, it will call this method
    public void onCreate(SQLiteDatabase db) {
        // creates and executes the query
        db.execSQL(CREATE_QUERY);
            Log.e("DATABASE OPERATIONS","TABLE CREATED...");
    }

    public void addInfo(String name, String number, String email, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.newUserInfo.USER_NAME, name);
        contentValues.put(UserContract.newUserInfo.USER_MOB, number);
        contentValues.put(UserContract.newUserInfo.USER_EMAIL, email);

        db.insert(UserContract.newUserInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS","One row is inserted");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
