/**
 * Activity that gives the list of all Yodels, and access to user settings. Each yodel displays upgoats, downgoats and user that created it.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends Activity {
	private ElasticSearchManager YodelManager;
	ArrayList<Yodel> yodelList;
	private newYodelAdapter yodelsAdapter;
	Collection<Yodel> yodels;
	
	
	private Runnable doUpdateGUIList = new Runnable() {
		public void run() {
			yodelsAdapter.notifyDataSetChanged();
		}
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final ListView listview =  (ListView) findViewById(R.id.YodelListView);
		Collection<Yodel> yodels = YodelitController.getYodelList().getYodels();
		
		yodelList = new ArrayList<Yodel>(yodels);
		yodelsAdapter = new newYodelAdapter(this, yodelList);
		listview.setAdapter(yodelsAdapter);
		YodelManager = new ElasticSearchManager();
		
		//yodelList.clear();
		//Thread thread = new SearchThread("");
		//thread.start();
        
		/**
	 	* Opens Yodel with Echo listed.
	 	*/
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
		
		/**
	 	* Sets favourites.
	 	*/
		listview.setOnItemLongClickListener(new OnItemLongClickListener(){
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				favouriteDialog(position, yodelList, listview);
				return true;
			}
			});
    }
	
    /**
 	* Inflate the menu; this adds items to the action bar if it is present.
 	*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
	protected void onResume() {
		super.onResume();
		// Refresh the list when visible
		yodelList.clear();
		Thread thread = new SearchThread("");
		thread.start();
		runOnUiThread(doUpdateGUIList);	
	}
    
    
    /**
 	* Pressing the Yodel A Question button will activate this function.
    * This is supposed to prompt an alert dialog with 2 edit texts.
 	*/
    public void posting(View view){

    	Intent intent = new Intent(HomeActivity.this, AddYodelActivity.class);
    	startActivity(intent);
    }
    
    
    @SuppressWarnings("null")
	@SuppressLint("DefaultLocale") 
    public void filter(View view){
    	try {
	    	EditText filterText = (EditText) findViewById(R.id.filterText);
	    	String filteree = filterText.getText().toString();
	    	final ListView filteredListview =  (ListView) findViewById(R.id.YodelListView);
			Collection<Yodel> yodels = YodelitController.getYodelList().getYodels();
			Collection<Yodel> filteredYodels = null; 
			
			Iterator<Yodel> i = yodels.iterator();
			
			while (i.hasNext()){
				Yodel yodel = i.next();
				String yodelText = yodel.getYodelText();
				if (yodelText.toLowerCase().contains(filteree.toLowerCase())){
					filteredYodels.add(yodel);
				}
			}
			
			final ArrayList<Yodel> filteredYodelList = new ArrayList<Yodel>(filteredYodels);
			final newYodelAdapter filteredYodelsAdapter = new newYodelAdapter(this, filteredYodelList);
			
			filteredListview.setAdapter(filteredYodelsAdapter);
    	} catch (Exception e) {
    		Log.i("Error:",e.toString());
    	}
    }
    
    /**
 	* Pressing user settings brings users to profile page.
    * Needs to pass username through intent.
 	*/
    public void userSettings(View view){
    	Intent intent = new Intent(HomeActivity.this, UserActivity.class);
    	startActivity(intent);
    }
    
    /**
 	* Prompts user to add to favorites list.
 	*/
    public void favouriteDialog(final int position, final ArrayList<Yodel> yodelList, final ListView listView){
    	final User user = YodelitController.getActiveUser();
    	final ArrayList<Integer> list = user.getYodelFavs();
		Yodel yodel = yodelList.get(position);
		final int id = yodel.getYid();
    	
		/**
	 	* Checks if ID is already listed.
	 	*/
    	if (list.contains(id) == false){
	    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Add to Favourites?");
	
			// Set up the buttons
			builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() { 
			    @Override
			    public void onClick(DialogInterface dialog, int which) {
			    	//ADD TO FAVOURITE LIST
					list.add(id);
					user.setYodelFavs(list);
					listView.getChildAt(position).setBackgroundColor(Color.rgb(179, 179, 179));
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
			
	    } else {
	    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Remove from Favourites?");
	
			// Set up the buttons
			builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() { 
			    @Override
			    public void onClick(DialogInterface dialog, int which) {
			    	//Remove From FAVOURITE LIST
					list.remove(id);
					user.setYodelFavs(list);
					listView.getChildAt(position).setBackgroundColor(Color.WHITE);
			    	Toast toast = Toast.makeText(getApplicationContext(), "Removed from Favourites!", Toast.LENGTH_SHORT);
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
    
    class SearchThread extends Thread {
		// TODO: Implement search thread
		public String search;
		
		public SearchThread(String s){
			search = s;
		}
		
		@Override
		public void run(){
			try {
				yodelList.clear();
				ArrayList<Yodel> holding = (ArrayList<Yodel>) YodelManager.searchYodels(search, null);
				YodelitController.addAllYodels(holding);
				yodelList.addAll(holding);
				runOnUiThread(doUpdateGUIList);
			}
			catch (Exception e) {
				Log.i("Error:",e.toString());
			}
		}
	}
    
    class DeleteThread extends Thread {
		public int yID;

		public DeleteThread(int movieId) {
			this.yID = yID;
		}
		@Override
		public void run() {
			YodelManager.deleteYodel(yID);

			// Remove movie from local list
			for (int i = 0; i < yodelList.size(); i++) {
				Yodel y = yodelList.get(i);

				if (y.getYid()== yID) {
					yodelList.remove(y);
					break;
				}
			}
			runOnUiThread(doUpdateGUIList);
		}
	}
}
    
