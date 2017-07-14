package com.casii.droid.habittracking.data;

import android.provider.BaseColumns;

/**
 * Created by Casi on 13.07.2017.
 */

public final class TrackerContract {
    /*By implementing the BaseColumns interface, your inner class can inherit a
 primary key field called _ID that some Android classes such as cursor adaptors
 will expect it to have. It's not required, but this can help your database
 work harmoniously with the Android framework.*/
    private TrackerContract() {
    }

    public static class TrackerEntry implements BaseColumns {
        public static final String TABLE_NAME = "person";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_RUNNING = "running";
        public static final String COLUMN_LEARNING = "learning";
        public static final String COLUMN_EATING = "eating";

        /**
         * Possible values for the eating,running and learning column of the person.
         */
        public static final int LOW = 0;
        public static final int MEDIUM = 1;
        public static final int HIGH = 2;
    }
}
