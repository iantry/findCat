package iantry.mapapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andrey on 15.03.2017.
 */

class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "dbPoints";
    private static final int VERSION_DATA_BASE = 1;

    static final String TABLE_CAT_POINTS = "Points";
    private static final String COLUMN_ID = "id";
    static final String COLUMN_LATITUDE = "latitude";
    static final String COLUMN_LONGITUDE = "longitude";


    private static final String CREATE_TABLE_CAT_POINTS = "create table IF NOT EXISTS " + TABLE_CAT_POINTS + " ( "
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_LATITUDE + " real, "
            + COLUMN_LONGITUDE + " real );";


    DataBaseHelper(Context context) {
        super(context, DATA_BASE_NAME, null, VERSION_DATA_BASE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_CAT_POINTS);
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_LATITUDE, 38.948405);
        cv.put(COLUMN_LONGITUDE, -76.986886);
        db.insert(TABLE_CAT_POINTS, null, cv);
        cv.clear();
        cv.put(COLUMN_LATITUDE, 38.848641);
        cv.put(COLUMN_LONGITUDE, -77.158184);
        db.insert(TABLE_CAT_POINTS, null, cv);
        cv.clear();
        cv.put(COLUMN_LATITUDE, 38.969978);
        cv.put(COLUMN_LONGITUDE, -77.141884);
        db.insert(TABLE_CAT_POINTS, null, cv);
        cv.clear();
        cv.put(COLUMN_LATITUDE, 38.860669);
        cv.put(COLUMN_LONGITUDE, -76.892520);
        db.insert(TABLE_CAT_POINTS, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}


}
