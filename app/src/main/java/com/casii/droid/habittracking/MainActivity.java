package com.casii.droid.habittracking;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.casii.droid.habittracking.data.TrackerContract;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbGateway db = new DbGateway(this);
        db.insertPerson("Alina", TrackerContract.TrackerEntry.LOW, TrackerContract.TrackerEntry.MEDIUM, TrackerContract.TrackerEntry.HIGH);
        db.insertPerson("Adrian", TrackerContract.TrackerEntry.HIGH, TrackerContract.TrackerEntry.MEDIUM, TrackerContract.TrackerEntry.LOW);
        Cursor DBResult = db.read();
    }

}
