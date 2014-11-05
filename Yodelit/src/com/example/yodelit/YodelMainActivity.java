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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class YodelMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Yodel viewYodel = YodelitController.getViewYodel();
		setContentView(R.layout.activity_yodel_main);
        ListView listview =  (ListView) findViewById(R.id.EchoListView);
        Button echobutton = (Button) findViewById(R.id.AddEchoButton);
        
        TextView yodelView = (TextView) findViewById(R.id.yodelView);
        TextView infoView = (TextView) findViewById(R.id.infoView);
        yodelView.setText(viewYodel.getYodelText());
        infoView.setText(viewYodel.getInfoText());
        
        Collection<Echo> echos = EchoController.getEchoList().getEchoes();
		final ArrayList<Echo> echoList = new ArrayList<Echo>(echos);
		final ArrayAdapter<Echo> yodelAdapter = new ArrayAdapter<Echo>(this, android.R.layout.simple_list_item_1, echoList);
		listview.setAdapter(yodelAdapter);
		
		EchoController.getEchoList().addListener(new Listener(){

			@Override
			public void update() {
				echoList.clear();
				Collection<Echo> todos = EchoController.getEchoList().getEchoes();
				echoList.addAll(todos);
				yodelAdapter.notifyDataSetChanged();
			}
		});
		
		echobutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	posting(v);
            }
        });
    }
        
	/*@Override
	public void onResume(){
		super.onResume();
	        ListView listview =  (ListView) findViewById(R.id.EchoListView);
	        Collection<Echo> echos = EchoController.getEchoList().getEchoes();
			final ArrayList<Echo> echoList = new ArrayList<Echo>(echos);
			final ArrayAdapter<Echo> yodelAdapter = new ArrayAdapter<Echo>(this, android.R.layout.simple_list_item_1, echoList);
			listview.setAdapter(yodelAdapter);
			YodelitController.getYodelList().addListener(new Listener(){
				
				@Override
				public void update() {
					echoList.clear();
					Collection<Echo> todos = EchoController.getEchoList().getEchoes();
					echoList.addAll(todos);
					yodelAdapter.notifyDataSetChanged();
				}
			});   
    }
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.yodel_main, menu);
		return true;
	}

	public void posting(View view){
    	// Pressing Echo. Brings up a new activity to add a Echo/reply to a Yodel
    	Intent intent = new Intent(YodelMainActivity.this, AddEchoActivity.class);
    	startActivity(intent);
    }
}
