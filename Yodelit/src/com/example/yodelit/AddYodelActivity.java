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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_yodel, menu);
		return true;
	}
	
	public void submitYodel(View view){
		
		final EditText question =  (EditText) findViewById(R.id.yodel);
		final EditText add =  (EditText) findViewById(R.id.additional);
		String qString = question.getText().toString();
		String addString = add.getText().toString();
		
		if (submissionCheck(qString, addString)){
			Yodel newYodel = new Yodel(qString);
			YodelitController.addYodel(newYodel);
			
			Collection<Yodel> yodels = YodelitController.getYodelList().getYodels();
			
			if (yodels.size() == 0){
				Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show();
			}
			finish();
			return;
		} else {
			Toast.makeText(this, "Please type in your question", Toast.LENGTH_SHORT).show();
			return;
		}
	}
	
	
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
