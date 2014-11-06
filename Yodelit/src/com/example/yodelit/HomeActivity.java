package com.example.yodelit;

//Desciption: This activity gives the list of all the Yodels. 
//
//Issues: Need to add favourites to username

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ListView listview =  (ListView) findViewById(R.id.YodelListView);
		Collection<Yodel> yodels = YodelitController.getYodelList().getYodels();
		final ArrayList<Yodel> yodelList = new ArrayList<Yodel>(yodels);
		final ArrayAdapter<Yodel> yodelsAdapter = new ArrayAdapter<Yodel>(this, android.R.layout.simple_list_item_1,yodelList);
		listview.setAdapter(yodelsAdapter);
		
		YodelitController.getYodelList().addListener(new Listener(){

			@Override
			public void update() {
				yodelList.clear();
				Collection<Yodel> yodels = YodelitController.getYodelList().getYodels();
				yodelList.addAll(yodels);
				yodelsAdapter.notifyDataSetChanged();
			}
		});
        
		listview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//NEEDS TO PASS YID THROUGH INTENT
				//List.get(position)
				final int finalPosition = position;
				Yodel yodel = yodelList.get(finalPosition);
				Intent intent = new Intent(HomeActivity.this, YodelMainActivity.class);
				intent.putExtra("YID", (int)yodel.getYid());
		    	startActivity(intent);

			}
		});
		
		listview.setOnItemLongClickListener(new OnItemLongClickListener(){
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				favouriteDialog();
				return false;
			}
			});
			
		
    }
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void posting(View view){
    	// Pressing Yodel A Question button will activate this function
    	// this is supposed to prompt a alert dialog with 2 edittexts
    	Intent intent = new Intent(HomeActivity.this, AddYodelActivity.class);
    	startActivity(intent);
    }
    
    public void userSettings(View view){
    	//Pressing user settings brings users to profile page
    	//Needs to pass username through intent
    	Intent intent = new Intent(HomeActivity.this, UserActivity.class);
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
    
