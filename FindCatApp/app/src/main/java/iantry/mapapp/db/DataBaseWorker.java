package iantry.mapapp.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import iantry.mapapp.R;
import iantry.mapapp.models.Cat;

/**
 * Created by Andrey on 15.03.2017.
 */

public class DataBaseWorker {

    private DataBaseHelper mdbHelper;
    private SQLiteDatabase mdb;
    private ArrayList<Cat> mCatsList;
    private Context mContext;

    public DataBaseWorker(Context context) {
        mContext = context;
        mCatsList = generateCatList();
    }

    private void connectToDB() {
        mdbHelper = new DataBaseHelper(mContext);
        mdb = mdbHelper.getReadableDatabase();
    }

    private void closeConnectToDB() {
        mdbHelper.close();
        mdb.close();
    }

    private Cursor readAllData() {
        return mdb.query(DataBaseHelper.TABLE_CAT_POINTS, null, null, null, null, null, null);
    }

    private ArrayList<Cat> generateCatList() {

        ArrayList<Cat> cats = new ArrayList<>();
        Cat cat;

        connectToDB();
        Cursor cursor = readAllData();
        int columnLatitude = cursor.getColumnIndex(DataBaseHelper.COLUMN_LATITUDE);
        int columnLongitude = cursor.getColumnIndex(DataBaseHelper.COLUMN_LONGITUDE);
        cursor.moveToFirst();
        cat = new Cat(cursor.getDouble(columnLatitude),
                cursor.getDouble(columnLongitude),
                mContext.getResources().getString(R.string.vasiliy),
                mContext.getResources().getString(R.string.vasiliy_race),
                mContext.getResources().getString(R.string.vasiliy_desc),
                R.drawable.american_kerl_vas);
        cats.add(cat);
        cursor.moveToNext();
        cat = new Cat(cursor.getDouble(columnLatitude),
                cursor.getDouble(columnLongitude),
                mContext.getResources().getString(R.string.tom),
                mContext.getResources().getString(R.string.tom_race),
                mContext.getResources().getString(R.string.tom_desc),
                R.drawable.bambino_tom);
        cats.add(cat);
        cursor.moveToNext();
        cat = new Cat(cursor.getDouble(columnLatitude),
                cursor.getDouble(columnLongitude),
                mContext.getResources().getString(R.string.liapold),
                mContext.getResources().getString(R.string.liapold_race),
                mContext.getResources().getString(R.string.liapold_desc),
                R.drawable.russian_blue_lia);
        cats.add(cat);
        cursor.moveToNext();
        cat = new Cat(cursor.getDouble(columnLatitude),
                cursor.getDouble(columnLongitude),
                mContext.getResources().getString(R.string.garfild),
                mContext.getResources().getString(R.string.garfild_race),
                mContext.getResources().getString(R.string.garfild_desc),
                R.drawable.toyger_garf);
        cats.add(cat);
        cursor.close();
        closeConnectToDB();

        return cats;
    }

    public ArrayList<Cat> getCatsList() {
        return mCatsList;
    }
}
