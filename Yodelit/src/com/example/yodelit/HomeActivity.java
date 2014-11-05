package com.example.yodelit;

//Desciption: This activity gives the list of all the Yodels. 
//
//Issues: Need to send yid through intent when a Yodel is clicked 

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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
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
				Collection<Yodel> todos = YodelitController.getYodelList().getYodels();
				yodelList.addAll(todos);
				yodelsAdapter.notifyDataSetChanged();
			}
		});
        
		//listens for a short click on a Yodel to bring up related Echos
		listview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//NEEDS TO PASS YID THROUGH INTENT
				//List.get(position)
				Intent intent = new Intent(HomeActivity.this, YodelMainActivity.class);
		    	startActivity(intent);
				
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
}
    
