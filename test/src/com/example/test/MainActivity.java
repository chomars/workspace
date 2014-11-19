package com.example.test;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.android.gms.ads.*;

public class MainActivity extends ActionBarActivity {
	  private AdView adView;
	  private static final String AD_UNIT_ID = "ca-app-pub-7753173895578171/3524640693";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		  adView = new AdView(this);
		    adView.setAdSize(AdSize.BANNER);
		    adView.setAdUnitId(AD_UNIT_ID);

		    // Add the AdView to the view hierarchy. The view will have no size until the ad is loaded.
		    // This code assumes you have a LinearLayout with attribute android:id="@+id/linear_layout"
		    // in your activity_main.xml.
		    LinearLayout layout = (LinearLayout) findViewById(R.id.linear_layout);
		    layout.addView(adView);

		    // Create an ad request. Check logcat output for the hashed device ID to get test ads on a
		    // physical device.
		    AdRequest adRequest = new AdRequest.Builder()
		        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
		        .addTestDevice("AC98C820A50B4AD8A2106EDE96FB87D4")
		        .build();

		    // Start loading the ad in the background.
		    adView.loadAd(adRequest);
	// Start loading the ad in the background.
	
		
	}
	 @Override
	  public void onResume() {
	    super.onResume();
	    if (adView != null) {
	      adView.resume();
	    }
	  }

	  @Override
	  public void onPause() {
	    if (adView != null) {
	      adView.pause();
	    }
	    super.onPause();
	  }

	  @Override
	  public void onDestroy() {
	    if (adView != null) {
	      adView.destroy();
	    }
	    super.onDestroy();
	  }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
