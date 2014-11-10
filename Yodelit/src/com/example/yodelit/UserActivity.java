/**
 * Activity for fetching user profile information. Here users can see their favorite Yodels listed.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class UserActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user);
		
		TextView displayUser = (TextView) findViewById(R.id.username);
		TextView changeUsername = (TextView) findViewById(R.id.changeuser);
		User user = YodelitController.getActiveUser();
		String name = user.getUname();
		displayUser.setText(name);
		
		ArrayList<String> list = new ArrayList<String>();
		final ArrayList<Integer> favlist = user.getYodelFavs();
		
		/**
	 	* Set the Yodels here into the favorites list.
	 	*/
		for (int x = 0; x < favlist.size(); x++){
			list.add(YodelitController.getYodelList().getYodel(favlist.get(x)).getYodelText()); //#### MIGHT NEED TO BE CHANGED FOR SEARCH METHOD
		}
    	
		ListView favView = (ListView) findViewById(R.id.listView);
		ArrayAdapter<String> favAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		favView.setAdapter(favAdapter); 
		
		/**
	 	* Changing username.
	 	*/
		changeUsername.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				changeUser();	
			}
		});
		
		/**
	 	* Can view Echos of favourite Yodels by clicking on the list.
	 	*/
		favView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(UserActivity.this, YodelMainActivity.class);
				intent.putExtra("YID", favlist.get(position));
		    	startActivity(intent);

			}
		});
		
		
	
	}

	/**
	* Inflate the menu; this adds items to the action bar if it is present.
 	*/
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.user, menu);
		return true;
	}

	/**
	*  Handle action bar item clicks here. The action bar will
	*  automatically handle clicks on the Home/Up button, so long
	*  as you specify a parent activity in AndroidManifest.xml.
 	*/
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/**
	* Changes the current user.
 	*/
	public void changeUser() {
		//For getting input from user in a dialogue box: http://stackoverflow.com/questions/10903754/input-text-dialog-android 11/06/14

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Change Username");

		final EditText input = new EditText(this);
		builder.setView(input);

		// Set up the buttons
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { 
		    @Override
		    public void onClick(DialogInterface dialog, int which) {
		    	final String name = input.getText().toString();
				TextView displayUser = (TextView) findViewById(R.id.username);
				displayUser.setText(name);
		    }
		});
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
		    @Override
		    public void onClick(DialogInterface dialog, int which) {
		        dialog.cancel();
		    }
		});
		final String name = input.getText().toString();
		builder.show();
		return;
		
	}
}
