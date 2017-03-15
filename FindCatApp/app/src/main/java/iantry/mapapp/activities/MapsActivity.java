package iantry.mapapp.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import iantry.mapapp.R;
import iantry.mapapp.db.DataBaseWorker;
import iantry.mapapp.factories.IntentFactory;
import iantry.mapapp.models.Cat;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private final LatLng WASHINGTON = new LatLng(38.908883, -77.039296);

    private GoogleMap mMap;
    private ArrayList<Cat> mCatsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mCatsList = new DataBaseWorker(this).getCatsList();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        addMarkers();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(WASHINGTON, 10.3f));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Cat cat;
                if(marker.getTitle().equals(getResources().getString(R.string.vasiliy))) {
                    cat = mCatsList.get(0);
                    IntentFactory.startCatActivity(MapsActivity.this, cat.getImageRes(), cat.getName()
                            , cat.getRace(),cat.getDescription());
                }
                else if(marker.getTitle().equals(getResources().getString(R.string.tom))) {
                    cat = mCatsList.get(1);
                    IntentFactory.startCatActivity(MapsActivity.this, cat.getImageRes(), cat.getName()
                            , cat.getRace(),cat.getDescription());
                }
                else if(marker.getTitle().equals(getResources().getString(R.string.liapold))) {
                    cat = mCatsList.get(2);
                    IntentFactory.startCatActivity(MapsActivity.this, cat.getImageRes(), cat.getName()
                            , cat.getRace(),cat.getDescription());
                }
                else  if(marker.getTitle().equals(getResources().getString(R.string.garfild))) {
                    cat = mCatsList.get(3);
                    IntentFactory.startCatActivity(MapsActivity.this, cat.getImageRes(), cat.getName()
                            , cat.getRace(),cat.getDescription());
                }
                return true;
            }
        });
    }

    private void addMarkers(){
        LatLng catPosition;
        for (Cat cat: mCatsList) {
            catPosition = new LatLng(cat.getLatitude(), cat.getLongitude());
            mMap.addMarker(new MarkerOptions().position(catPosition).title(cat.getName()));
        }
    }

}
