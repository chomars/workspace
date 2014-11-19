package com.example.spendyourmoney;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.support.v7.app.ActionBarActivity;
import android.text.format.DateFormat;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	public final static String EXTRA_MESSAGE = "com.example.myfirst";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	public void process(View view) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(Calendar.getInstance().getTime());
		//String date = "2014-09-17 00:00:00";
	    DatabaseHandler db = new DatabaseHandler(this);
		Intent intent = new Intent(this, DisplayMessageActivity.class);
	    EditText editText = (EditText) findViewById(R.id.editText1);
	    EditText description = (EditText) findViewById(R.id.description);
	    int spending = Integer.parseInt(editText.getText().toString());
	    String descriptionText = description.getText().toString();
	    String type = "Spending";
	    
	    
	    db.addSpending(new Spending("Chomars",spending,descriptionText,date,type));
	   // Log.d("msg: ", spending.toString());
	    Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
	  //  intent.putExtra(EXTRA_MESSAGE, message);
	   // startActivity(intent);
	}
	
	/*public void process(View view){
		
	}*/
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
