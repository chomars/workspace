package com.example.location;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonParser;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class SplashActivity extends Activity {
	private static int SPLASH_TIME_OUT = 3000;
	static String URLAPI = "http://122.248.251.132:8080/api-1.0/category";
	static String URLAPI2 = "http://api.androidhive.info/game/game_stats.json";
	protected String jItems  =  null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		new PrefetchData().execute();
//		new Handler().postDelayed(new Runnable() {
//			
//			@Override
//			public void run() {
//				Intent i = new Intent(SplashActivity.this ,MainActivity.class);
//				startActivity(i);
//				finish();
//				
//			}
//		},SPLASH_TIME_OUT);
	}
	private class PrefetchData extends AsyncTask<Void, Void, Void>{
		
	
		String Collection = null;
		protected void onPreExecute(){
			super.onPreExecute();			
		}
		@Override
		protected Void doInBackground(Void... params) {
				com.example.location.JsonParser jsonparser = new com.example.location.JsonParser();
				JSONObject Json = jsonparser.getJSONFromUrl(URLAPI2);
				
				 if (Json != null) {
		                try {
		                    JSONObject jObj = Json
		                            .getJSONObject("game_stat");
		                     jItems  = jObj.getString("now_playing");
		                    
		                    Log.d("JSON", "> " + jItems);
		 
		                } catch (JSONException e) {
		                    // TODO Auto-generated catch block
		                	
		                    e.printStackTrace();
		                }
		 
		            }
				 return null;
		}
		
		protected void onPostExecute(Void result){
			super.onPostExecute(result);
			
			Intent i = new Intent(SplashActivity.this, MainActivity.class);
			i.putExtra("items", jItems);
			startActivity(i);
			finish();
		}
	}
	

	
}
