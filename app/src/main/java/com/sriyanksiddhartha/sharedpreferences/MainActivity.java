package com.sriyanksiddhartha.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Author : Sriyank Siddhartha
 * Module 2 : Saving and Retrieving Data from SharedPreferences
 *
 * 		"BEFORE" Demo Project : Initial Project Setup
 * */
public class MainActivity extends AppCompatActivity {

	private EditText etName, etProfession;
	private TextView txvName, txvProfession;
	private Switch pageColorSwitch;
	private LinearLayout pageLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etName = (EditText) findViewById(R.id.etName);
		etProfession = (EditText) findViewById(R.id.etProfession);

		txvName = (TextView) findViewById(R.id.txvName);
		txvProfession = (TextView) findViewById(R.id.txvProfession);

		pageLayout = (LinearLayout) findViewById(R.id.pageLayout);
		pageColorSwitch = (Switch) findViewById(R.id.pageColorSwitch);
	}

	public void saveAccountData(View view) {
		//It simply returns the reference to the shared Preference object that points to the shared Preference file.
          SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
          SharedPreferences.Editor editor = sharedPreferences.edit();
          editor.putString("name",etName.getText().toString());
          editor.putString("profession",etProfession.getText().toString());
          editor.putInt("professionid",287);
          editor.apply();
          //So we have inserted data in sharedPreferences file
	}

	public void loadAccountData(View view) {
	    //Syntax to retrieve data from sharedPreference file
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
         String name = sharedPreferences.getString("name","N/A");
         String profession = sharedPreferences.getString("profession","N/A");
         int professionID = sharedPreferences.getInt("professionid",0);
         txvName.setText(name);
         String profStr = profession + " - "+ professionID;
         txvProfession.setText(profStr);


	}

	public void openSecondActivity(View view) {

	}
}
