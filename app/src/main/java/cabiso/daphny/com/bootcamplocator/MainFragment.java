package cabiso.daphny.com.bootcamplocator;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by Lenovo on 8/13/2017.
 */

public class MainFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap mGoogleMap;
    private MarkerOptions userMarker;
    private String zip;
    private LocationsListFragments locationsListFragments;


    public MainFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        //loading the map...
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        locationsListFragments =  (LocationsListFragments) getActivity()
                .getSupportFragmentManager()
                .findFragmentById(R.id.container_location_list);
        if(locationsListFragments == null){
            locationsListFragments = LocationsListFragments.newInstance();
            getActivity().
                    getSupportFragmentManager().
                    beginTransaction().
                    add(R.id.container_location_list, locationsListFragments).
                    commit();
        }

        final EditText zipText=(EditText) v.findViewById(R.id.zip_text);
        zipText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction()==KeyEvent.ACTION_DOWN) && keyCode== KeyEvent.KEYCODE_ENTER){

                    String text = zipText.getText().toString();
                    int zip = Integer.parseInt(text);

                    InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(zipText.getWindowToken(),0);
                    showList();
                    updateMapForZipCode(zip);
                    return true;
                }
                return false;
            }
        });
        hideList();
        return v;

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;

    }

    public void setUserMarkers(LatLng latLng) {
        if (userMarker == null) {
            userMarker = new MarkerOptions().position(latLng).title("Current Location");
            mGoogleMap.addMarker(userMarker);
            Log.v("Hey", "Current Location");
        }


        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));

        mGoogleMap.setTrafficEnabled( true );

    }


    private void updateMapForZipCode(int zipcode){
        ArrayList<Devslopes> locations=DataService.getInstance().getNearBootCampLocations(zipcode);
        for (int i=0; i<locations.size();i++){
            Devslopes loc=locations.get(i);
            MarkerOptions marker= new MarkerOptions().position(new LatLng(loc.getLatitude(),loc.getLongitude()));
            marker.title(loc.getLocationTitle());
            marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin));
            mGoogleMap.addMarker(marker);
        }

    }

    //Hide location list fragment function ...
    private void hideList(){
        getActivity().getSupportFragmentManager().beginTransaction().hide(locationsListFragments).commit();
    }

    //Show location list fragment function ...
    private void showList(){
        getActivity().getSupportFragmentManager().beginTransaction().show(locationsListFragments).commit();
    }

}