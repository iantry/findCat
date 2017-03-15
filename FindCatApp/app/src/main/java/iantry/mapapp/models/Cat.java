package iantry.mapapp.models;

/**
 * Created by Andrey on 15.03.2017.
 */

public class Cat {

    private double mLatitude;
    private double mLongitude;
    private String mName;
    private String mRace;
    private String mDescription;
    private int mImageRes;

    public Cat(double latitude, double longitude, String name, String race, String description, int imageRes) {
        mLatitude = latitude;
        mLongitude = longitude;
        mName = name;
        mRace = race;
        mDescription = description;
        mImageRes = imageRes;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public String getName() {
        return mName;
    }

    public String getRace() {
        return mRace;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getImageRes() {
        return mImageRes;
    }
}
