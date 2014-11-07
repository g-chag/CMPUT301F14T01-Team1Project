/**
 * This activity lists the Echoes related to a Yodel and is used for viewing Yodels individually.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */


package com.example.yodelit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
		//Yodel viewYodel = YodelitController.getViewYodel();
		setContentView(R.layout.activity_yodel_main);
        final ListView listview =  (ListView) findViewById(R.id.EchoListView);
        Button echobutton = (Button) findViewById(R.id.AddEchoButton);
        
        TextView yodelView = (TextView) findViewById(R.id.yodelView);
        TextView infoView = (TextView) findViewById(R.id.infoView);
        final int yID = getIntent().getIntExtra("YID", -1);
        
        final Yodel yodel = YodelitController.getYodelList().getYodel(yID); //#### MIGHT NEED TO BE CHANGED FOR SEARCH METHOD
        yodelView.setText(yodel.getYodelText());
        infoView.setText(yodel.getInfoText());
        
        //Collection<Echo> echos = EchoController.getEchoList().getEchoes();
		//final ArrayList<Echo> echoList = new ArrayList<Echo>(echos);
		final ArrayAdapter<Echo> echoAdapter = new ArrayAdapter<Echo>(this, android.R.layout.simple_list_item_1, yodel.getEchoList());
		listview.setAdapter(echoAdapter);

		echobutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	posting(v, yID);
            	echoAdapter.notifyDataSetChanged();
            }
            });
    }
	@Override
	public void onResume(){
		super.onResume();
			//Yodel viewYodel = YodelitController.getViewYodel();
			setContentView(R.layout.activity_yodel_main);
	        final ListView listview =  (ListView) findViewById(R.id.EchoListView);
	        Button echobutton = (Button) findViewById(R.id.AddEchoButton);
	        
	        TextView yodelView = (TextView) findViewById(R.id.yodelView);
	        TextView infoView = (TextView) findViewById(R.id.infoView);
	        final int yID = getIntent().getIntExtra("YID", -1);
	        
	        final Yodel yodel = YodelitController.getYodelList().getYodel(yID); //#### MIGHT NEED TO BE CHANGED FOR SEARCH METHOD
	        yodelView.setText(yodel.getYodelText());
	        infoView.setText(yodel.getInfoText());
	        
	        //Collection<Echo> echos = EchoController.getEchoList().getEchoes();
			//final ArrayList<Echo> echoList = new ArrayList<Echo>(echos);
			final ArrayAdapter<Echo> echoAdapter = new ArrayAdapter<Echo>(this, android.R.layout.simple_list_item_1, yodel.getEchoList());
			listview.setAdapter(echoAdapter);

			echobutton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	posting(v, yID);
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

	public void posting(View view, int id){
    	// Pressing Echo. Brings up a new activity to add a Echo/reply to a Yodel
    	Intent intent = new Intent(YodelMainActivity.this, AddEchoActivity.class);
    	intent.putExtra("YID", (int)id);
    	startActivity(intent);
    	
    }
}
