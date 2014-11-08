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
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class YodelMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//sets buttons
		setContentView(R.layout.activity_yodel_main);
        final ListView listview =  (ListView) findViewById(R.id.EchoListView);
        Button echobutton = (Button) findViewById(R.id.AddEchoButton);
        ImageButton favbutton = (ImageButton) findViewById(R.id.favButton);
        //sets views, gets user id
        TextView yodelView = (TextView) findViewById(R.id.yodelView);
        TextView infoView = (TextView) findViewById(R.id.infoView);
        final int yID = getIntent().getIntExtra("YID", -1);
        
        final Yodel yodel = YodelitController.getYodelList().getYodel(yID); //#### MIGHT NEED TO BE CHANGED FOR SEARCH METHOD
        yodelView.setText(yodel.getYodelText());
        infoView.setText(yodel.getInfoText());
        
		final newAdapter echoAdapter = new newAdapter(this, yodel.getEchoList());
		
		
		listview.setAdapter(echoAdapter);

		echobutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	posting(v, yID);
            	echoAdapter.notifyDataSetChanged();
            }
            });            
		
		favbutton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				favouriteDialog();
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
	        ImageButton favbutton = (ImageButton) findViewById(R.id.favButton);
	        
	        TextView yodelView = (TextView) findViewById(R.id.yodelView);
	        TextView infoView = (TextView) findViewById(R.id.infoView);
	        final int yID = getIntent().getIntExtra("YID", -1);
	        
	        final Yodel yodel = YodelitController.getYodelList().getYodel(yID); //#### MIGHT NEED TO BE CHANGED FOR SEARCH METHOD
	        yodelView.setText(yodel.getYodelText());
	        infoView.setText(yodel.getInfoText());
	        
	        //Collection<Echo> echos = EchoController.getEchoList().getEchoes();
			//final ArrayList<Echo> echoList = new ArrayList<Echo>(echos);
	        final newAdapter echoAdapter = new newAdapter(this, yodel.getEchoList());
			listview.setAdapter(echoAdapter);

			echobutton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	posting(v, yID);
	            	echoAdapter.notifyDataSetChanged();
	            }
	            });
			
			favbutton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					favouriteDialog();
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
	 public void favouriteDialog(){
	    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Add to Favourites?");

			// Set up the buttons
			builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() { 
			    @Override
			    public void onClick(DialogInterface dialog, int which) {
			    	//NEED TO ADD TO FAVOURITE LIST
			    	Toast toast = Toast.makeText(getApplicationContext(), "Added to Favourites!", Toast.LENGTH_SHORT);
			    	toast.show();
			    }
			});
			builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			    @Override
			    public void onClick(DialogInterface dialog, int which) {
			        dialog.cancel();
			    }
			});
			builder.show();
	    }
	
}
