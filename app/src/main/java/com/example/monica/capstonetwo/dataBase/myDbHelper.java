package com.example.monica.capstonetwo.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by monica on 7/14/2017.
 */

public class myDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sub.db";
    private static final int DATABASE_VERSION = 3;

    public myDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_SUBRED_TABLE = "CREATE TABLE " + myContract.sunRedditEntry.TABLE_NAME + " (" +
                myContract.sunRedditEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                myContract.sunRedditEntry.COLUMN_SUBRED_AUTHOR+ " TEXT , " +
                myContract.sunRedditEntry.COLUMN_SUBRED_TITLE+ " TEXT )";

        sqLiteDatabase.execSQL(SQL_CREATE_SUBRED_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + myContract.sunRedditEntry.TABLE_NAME);
        onCreate(db);
    }
}


