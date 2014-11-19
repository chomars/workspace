package com.example.spendyourmoney;

import android.support.v7.app.ActionBarActivity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabLayout extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_layout);
		TabHost tabHost = getTabHost();
        
        // Tab for Photos
        TabSpec photospec = tabHost.newTabSpec("Input Pengeluaran");
        // setting Title and Icon for the Tab
        photospec.setIndicator("Input Pengeluaran", getResources().getDrawable(R.drawable.icon_form_tab));
        Intent photosIntent = new Intent(this, MainActivity.class);
        photospec.setContent(photosIntent);
         
        // Tab for Songs
        TabSpec songspec = tabHost.newTabSpec("Daftar Pengeluaran");        
        songspec.setIndicator("Daftar Pengeluaran", getResources().getDrawable(R.drawable.icon_form_tab));
        Intent songsIntent = new Intent(this, DisplayMessageActivity.class);
        songspec.setContent(songsIntent);
      
       
       
        // Adding all TabSpec to TabHost
        tabHost.addTab(photospec); // Adding photos tab
        tabHost.addTab(songspec); // Adding songs tab
     
	}

	
}
