package com.example.spendyourmoney;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends Activity {

	
	private int i = 0;
	private ListView monthsListView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final DatabaseHandler db = new DatabaseHandler(this);

		List<Spending> spending = db.getAllSpending();
		String[] spendingArr = new String[spending.size()];
		String[] descriptionArr = new String[spending.size()];
		String[] inputDateArr = new String[spending.size()];
		String[] typeArr = new String[spending.size()];
		final int[] idArr = new int[spending.size()];
		String strFormat = "#,###";
		DecimalFormat df = new DecimalFormat(strFormat,
		new DecimalFormatSymbols(Locale.GERMAN));
		
		
		for (Spending cn : spending) {
			String cobatanggal = cn.getDate();
			String[] SplitSpasi = cobatanggal.split(" ");
			String[] SplitTanggal = SplitSpasi[0].split("-");
			String TanggalFormat = SplitTanggal[2]+" "+SplitTanggal[1]+" "+SplitTanggal[0];

			Double money = Double.valueOf(cn.getMoney());
			

			spendingArr[i] = "Pengeluaran Mu Rp. " + df.format(money);
			descriptionArr[i] = cn.getDescription();
			inputDateArr[i] = TanggalFormat;
			typeArr[i] = cn.getType();
			idArr[i] = cn.getID();
			i++;
		}

		setContentView(R.layout.activity_display_message);
		TextView SpendingAll = (TextView) findViewById(R.id.spendingAll);
		Double AllSpending = Double.valueOf(db.sumSpendingAll());
		SpendingAll.setText("Total Pengeluaran Mu Rp. "
				+ df.format(AllSpending));

		final CustomList adapter = new CustomList(DisplayMessageActivity.this,
				spendingArr, descriptionArr, inputDateArr, typeArr);
		monthsListView = (ListView) findViewById(R.id.months_list);
		monthsListView.setAdapter(adapter);
		
		monthsListView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					final int position, long rowId) {
				// delete selected item list view
				AlertDialog.Builder adb = new AlertDialog.Builder(
						DisplayMessageActivity.this);
				adb.setTitle("");
				adb.setMessage("Yakin akan menghapus item ini?");
				// adb.setPositiveButton("Ok", null);
				adb.setPositiveButton("ok",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								db.deleteSpending(new Spending(idArr[position]));
								// reload list view
								List<Spending> Ospending = db.getAllSpending();
								String[] OspendingArr = new String[Ospending.size()];
								String[] OdescriptionArr = new String[Ospending.size()];
								String[] OinputDateArr = new String[Ospending.size()];
								String[] OtypeArr = new String[Ospending.size()];
								final int[] OidArr = new int[Ospending.size()];
								String OstrFormat = "#,###";
								DecimalFormat Odf = new DecimalFormat(OstrFormat,
								new DecimalFormatSymbols(Locale.GERMAN));
								int io = 0;
								for (Spending Ocn : Ospending) {
									String cobatanggal = Ocn.getDate();
									String[] SplitSpasi = cobatanggal.split(" ");
									String[] SplitTanggal = SplitSpasi[0].split("-");
									String TanggalFormat = SplitTanggal[2]+" "+SplitTanggal[1]+" "+SplitTanggal[0];

									Double Omoney = Double.valueOf(Ocn.getMoney());
									

									OspendingArr[io] = "Pengeluaran Mu Rp. " + Odf.format(Omoney);
									OdescriptionArr[io] = Ocn.getDescription();
									OinputDateArr[io] = TanggalFormat;
									OtypeArr[io] = Ocn.getType();
									OidArr[io] = Ocn.getID();
									io++;
								}
								final CustomList Oadapter = new CustomList(DisplayMessageActivity.this,
										OspendingArr, OdescriptionArr, OinputDateArr, OtypeArr);
								monthsListView = (ListView) findViewById(R.id.months_list);
								monthsListView.setAdapter(Oadapter);
								
								TextView OSpendingAll = (TextView) findViewById(R.id.spendingAll);
								Double OAllSpending = Double.valueOf(db.sumSpendingAll());
								OSpendingAll.setText("Total Pengeluaran Mu Rp. "
										+ Odf.format(OAllSpending));
								
								
								Oadapter.notifyDataSetChanged();

								
							}
						});
				adb.setNegativeButton("cancel",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						});
				adb.show();
				
				return false;
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
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
