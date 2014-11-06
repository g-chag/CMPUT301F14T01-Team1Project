package com.example.yodelit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user);
		
		TextView displayUser = (TextView) findViewById(R.id.username);
		TextView changeUsername = (TextView) findViewById(R.id.changeuser);

		displayUser.setText("satodd");
	
		changeUsername.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				changeUser();
				
			}
		});
	
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public void changeUser() {
		//http://stackoverflow.com/questions/10903754/input-text-dialog-android

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Change Username");

		// Set up the input
		final EditText input = new EditText(this);
		// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
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
		//NEEDS TO RESET SINGLETON USERNAME
		
		return;
		
	}
}
