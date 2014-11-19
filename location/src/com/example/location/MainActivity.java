package com.example.location;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	private GoogleMap googlemap;
	private double latitude  ;
	private double longitude  ;
	protected LocationManager locationManager;
	protected Location location;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			initializeMap();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

public void initializeMap(){
	if(googlemap == null){
		googlemap = ((MapFragment) getFragmentManager().findFragmentById(R.id.peta)).getMap();
		
		locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//		provider = locationManager.getBestProvider(criteria, false);
//		 Location location = locationManager.getLastKnownLocation(provider);
		//googlemap.setMyLocationEnabled(true);
		
		// create marker
		MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Hello Maps ");
		 
		// adding marker
		googlemap.addMarker(marker);
		if(googlemap == null){
			Toast.makeText(getApplicationContext(), "cannot load map", Toast.LENGTH_LONG).show();
		}
	}
	
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
}
	
}
