package com.casii.droid.habittracking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.casii.droid.habittracking.data.TrackerContract;
import com.casii.droid.habittracking.data.TrackerDbHelper;

/**
 * Created by Casi on 13.07.2017.
 */
public class DbGateway {
    private TrackerDbHelper helper;

    public DbGateway(Context context) {
        helper = new TrackerDbHelper(context);
    }

    public void insertPerson(String name, int running, int eating, int learning) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TrackerContract.TrackerEntry.COLUMN_NAME, name);
        values.put(TrackerContract.TrackerEntry.COLUMN_RUNNING, running);
        values.put(TrackerContract.TrackerEntry.COLUMN_LEARNING, learning);
        values.put(TrackerContract.TrackerEntry.COLUMN_EATING, eating);

        db.insert(TrackerContract.TrackerEntry.TABLE_NAME, null, values);
    }

    public Cursor read() {
        SQLiteDatabase db = helper.getReadableDatabase();
        String[] projection = {
                TrackerContract.TrackerEntry.COLUMN_NAME,
                TrackerContract.TrackerEntry.COLUMN_RUNNING,
                TrackerContract.TrackerEntry.COLUMN_LEARNING,
                TrackerContract.TrackerEntry.COLUMN_EATING
        };

        return db.query(
                TrackerContract.TrackerEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
    }

}
