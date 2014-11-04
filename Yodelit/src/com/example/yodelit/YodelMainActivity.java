package com.example.yodelit;

//Description: This activity lists the Echos related to a Yodel
//
//Issues: Need to get yid from Intent


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class YodelMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yodel_main);

        ListView listview =  (ListView) findViewById(R.id.EchoListView);
		//EchoList echosList = EchoController.getEchoList();
		//EchoList echoList = new EchoList;
		final EchoList echoList = EchoController.getEchoList();
		
		final ArrayAdapter<Echo> echoAdapter = new ArrayAdapter<Echo>(this, android.R.layout.simple_list_item_1,echoList.toArray());
		listview.setAdapter(echoAdapter);
		
		YodelitController.getYodelList().addListener(new Listener(){

			@Override
			public void update() {
				//echoList.clear();
				EchoList echos = EchoController.getEchoList();
				echoList.addAll(echos);
				echoAdapter.notifyDataSetChanged();
			}
		});
        
    }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.yodel_main, menu);
		return true;
	}

}
