package com.example.sharepreferance;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class FormActivity extends Activity {
	private Spinner Pendidikan;
	private Button btnDialog;
	private EditText nama;
	private Button submit;
	private RadioButton pria;
	private RadioButton wanita;
	private Context context = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formlayout);
		addItemJenkel();
		ShowDialog();
		save();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void save(){
		
		SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
		final Editor editor = pref.edit();
		nama = (EditText) findViewById(R.id.nama);
		Pendidikan = (Spinner) findViewById(R.id.pendidikan);
		pria = (RadioButton) findViewById(R.id.pria);
		wanita = (RadioButton) findViewById(R.id.wanita);
		submit = (Button) findViewById(R.id.submit);
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				editor.putString("nama", nama.getText().toString());
				
				editor.putString("jenkel", pria.getText().toString());
				editor.putString("jenkel", wanita.getText().toString());
				
				editor.putString("pendidikan", Pendidikan.getSelectedItem().toString());
				editor.commit();
				Toast.makeText(context, "save "+nama.getText(), 1000).show();
			}
		});
		
	}
	
	public void addItemJenkel(){
		
		Pendidikan = (Spinner) findViewById(R.id.pendidikan);
		List<String> ListPendidikan = new ArrayList<String>();
		ListPendidikan.add("SMA");
		ListPendidikan.add("S1");
		ListPendidikan.add("S2");
		ArrayAdapter<String> dataPendidikan = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,ListPendidikan);
		Pendidikan.setAdapter(dataPendidikan);
	}
	
	public void ShowDialog(){
		 SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
		btnDialog = (Button) findViewById(R.id.dialog);
		final String resName = pref.getString("nama",null);
		btnDialog.setOnClickListener(new OnClickListener() {
	 
			@Override
			public void onClick(View v) {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
				alertDialogBuilder.setTitle("Information");
				
				alertDialogBuilder.setMessage("nama anda : " + resName);
				AlertDialog alertdialog = alertDialogBuilder.create();
				alertdialog.show();
			}
		});
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
