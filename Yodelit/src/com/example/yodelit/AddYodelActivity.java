package com.example.yodelit;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

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
		Yodel newYodel = new Yodel();
		final EditText question =  (EditText) findViewById(R.id.yodel);
		final EditText add =  (EditText) findViewById(R.id.additional);
		String qString = question.getText().toString();
		String addString = add.getText().toString();
		newYodel.setText(qString);
		newYodel.setContent(addString);
		
		
		
		return;
	}

}
