/**
 * This activity lists the Echoes related to a Yodel and is used for viewing Yodels individually along with it's Echos. Users can upgoat and downgoat Echos.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */


package com.example.yodelit;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class YodelMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//sets buttons
		setContentView(R.layout.activity_yodel_main);
        final ListView listview =  (ListView) findViewById(R.id.EchoListView);
        Button echobutton = (Button) findViewById(R.id.AddEchoButton);
        ImageView imgView = (ImageView) findViewById(R.id.imageView);
        
        //sets views, gets user id
        TextView yodelView = (TextView) findViewById(R.id.yodelView);
        TextView infoView = (TextView) findViewById(R.id.infoView);
        final int yID = getIntent().getIntExtra("YID", -1);
        
        final Yodel yodel = YodelitController.getYodelList().getYodel(yID); //#### MIGHT NEED TO BE CHANGED FOR SEARCH METHOD
        yodelView.setText(yodel.getYodelText());
        infoView.setText(yodel.getInfoText());
        Bitmap bm = yodel.getBitmap();
        imgView.setImageBitmap(bm);
        
		final newAdapter echoAdapter = new newAdapter(this, yodel.getEchoList());
		
		listview.setAdapter(echoAdapter);

		echobutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	posting(v, yID);
            	echoAdapter.notifyDataSetChanged();
            }
        });            
    }
	
	/**Sets view objects required for echo**/
	@Override
	public void onResume(){
		super.onResume();
			setContentView(R.layout.activity_yodel_main);
	        final ListView listview =  (ListView) findViewById(R.id.EchoListView);
	        Button echobutton = (Button) findViewById(R.id.AddEchoButton);
	        ImageView imgView = (ImageView) findViewById(R.id.imageView);
	        
	        TextView yodelView = (TextView) findViewById(R.id.yodelView);
	        TextView infoView = (TextView) findViewById(R.id.infoView);
	        final int yID = getIntent().getIntExtra("YID", -1);
	        
	        final Yodel yodel = YodelitController.getYodelList().getYodel(yID); //#### MIGHT NEED TO BE CHANGED FOR SEARCH METHOD
	        yodelView.setText(yodel.getYodelText());
	        infoView.setText(yodel.getInfoText());
	        Bitmap bm = yodel.getBitmap();
	        imgView.setImageBitmap(bm);
	        
	        final newAdapter echoAdapter = new newAdapter(this, yodel.getEchoList());
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

	/**Shows a new activity to which Echoes can be posted**/
	public void posting(View view, int id){
    	// Pressing Echo. Brings up a new activity to add a Echo/reply to a Yodel
    	Intent intent = new Intent(YodelMainActivity.this, AddEchoActivity.class);
    	intent.putExtra("YID", (int)id);
    	startActivity(intent);
    }
	
}
