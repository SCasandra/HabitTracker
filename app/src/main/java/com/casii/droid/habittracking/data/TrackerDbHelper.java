package com.casii.droid.habittracking.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TrackerDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "PersonTracking.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TrackerContract.TrackerEntry.TABLE_NAME + "(" +
                    TrackerContract.TrackerEntry._ID + " INTEGER PRIMARY KEY," +
                    TrackerContract.TrackerEntry.COLUMN_NAME + " TEXT," +
                    TrackerContract.TrackerEntry.COLUMN_RUNNING + " INTEGER," +
                    TrackerContract.TrackerEntry.COLUMN_EATING + " INTEGER," +
                    TrackerContract.TrackerEntry.COLUMN_LEARNING + " INTEGER)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TrackerContract.TrackerEntry.TABLE_NAME;

    public TrackerDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}