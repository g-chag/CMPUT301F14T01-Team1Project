package com.example.yodelit;

//Description: This activity lists the Echos related to a Yodel
//
//Issues: Need to get yid from Intent


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class YodelMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yodel_main);

        ListView listview =  (ListView) findViewById(R.id.EchoListView);

        Collection<Echo> echos = EchoController.getEchoList().getEchoes();
		final ArrayList<Echo> echoList = new ArrayList<Echo>(echos);
		final ArrayAdapter<Echo> todosAdapter = new ArrayAdapter<Echo>(this, android.R.layout.simple_list_item_1, echoList);
		listview.setAdapter(todosAdapter);
		
		EchoController.getEchoList().addListener(new Listener(){

			@Override
			public void update() {
				echoList.clear();
				Collection<Echo> todos = EchoController.getEchoList().getEchoes();
				echoList.addAll(todos);
				todosAdapter.notifyDataSetChanged();
			}
		});
		
		
        
    }
	@Override
	public void onResume(){
		super.onResume();
	        ListView listview =  (ListView) findViewById(R.id.EchoListView);
	        Collection<Echo> echos = EchoController.getEchoList().getEchoes();
			final ArrayList<Echo> echoList = new ArrayList<Echo>(echos);
			final ArrayAdapter<Echo> todosAdapter = new ArrayAdapter<Echo>(this, android.R.layout.simple_list_item_1, echoList);
			listview.setAdapter(todosAdapter);

			if(echos.size()==0){
				Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show();
			}
			
			YodelitController.getYodelList().addListener(new Listener(){
				
				@Override
				public void update() {
					echoList.clear();
					Collection<Echo> todos = EchoController.getEchoList().getEchoes();
					echoList.addAll(todos);
					todosAdapter.notifyDataSetChanged();
				}
			});   
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.yodel_main, menu);
		return true;
	}

	public void posting(View view){
    	// Pressing Yodel A Question button will activate this function
    	// this is supposed to prompt a alert dialog with 2 edittexts
    	Intent intent = new Intent(YodelMainActivity.this, AddYodelActivity.class);
    	startActivity(intent);
    }
}
