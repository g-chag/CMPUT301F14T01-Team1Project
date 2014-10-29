package com.example.yodelit;

//Gives echos for a specific Yodels, gets YID from intent, sets up Echos 


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class YodelMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yodel_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.yodel_main, menu);
		return true;
	}

}
