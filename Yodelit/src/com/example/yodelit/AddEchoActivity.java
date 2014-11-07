/**
 * Activity for adding "Echos" our equivalent of replies to a Yodel Thread.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.util.ArrayList;

import java.util.Collection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddEchoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_echo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_echo, menu);
		return true;
	}
	
	/**
	 * Constructs a string based on the reply text and creates an Echo from it.
	 * It then appends this Echo to the relevant Yodel. Echo text cannot be empty or the
	 * submission fails with a toast reminder.
	 */
	public void submitEcho(View view){
		final EditText reply =  (EditText) findViewById(R.id.echoText);
		String rString = reply.getText().toString();
		final int yID = getIntent().getIntExtra("YID", -1);
		
		if (submissionCheck(rString)){
			Echo newEcho = new Echo(rString);
			Yodel yodel = YodelitController.getYodelList().getYodel(yID);
			yodel.addEcho(newEcho);
			finish();
			return;
		} else {
			Toast.makeText(this, "Please type in your reply", Toast.LENGTH_SHORT).show();
			return;
		}
	}
	
	
	public boolean submissionCheck(String reply){
		if (reply.isEmpty()){
			return false;
		}
		return true;		
	}
	
	public void cancel(View view){
		finish();
	}

}

