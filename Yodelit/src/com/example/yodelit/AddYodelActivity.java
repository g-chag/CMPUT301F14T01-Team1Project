/**
 * Activity for adding "Yodels" our equivalent of forum questions.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.util.ArrayList;
import java.util.Collection;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddYodelActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_yodel);
	}
	
	/**
	 * Inflate the menu; this adds items to the action bar if it is present.
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_yodel, menu);
		return true;
	}
	
	/**
	 * 	Gets into from screen. Adds newly created Yodel to controller.
	 */
	public void submitYodel(View view){
		final EditText question =  (EditText) findViewById(R.id.yodelText);
		final EditText add =  (EditText) findViewById(R.id.infoText);
		String qString = question.getText().toString();
		String addString = add.getText().toString();
		
		if (submissionCheck(qString, addString)){
			Yodel newYodel = new Yodel(qString, addString);
			YodelitController.addYodel(newYodel);
			finish();
			return;
		} else {
			Toast.makeText(this, "Please type in your question", Toast.LENGTH_SHORT).show();
			return;
		}
	}
	
	/**
	 * 	Ensures that a Yodel is not empty.
	 */
	public boolean submissionCheck(String question, String add){
		if (question.isEmpty()){
			return false;
		}
		return true;		
	}
	
	public void cancel(View view){
		finish();
	}

}
