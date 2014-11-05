package com.example.yodelit;

import java.util.ArrayList;
import java.util.Collection;

import android.app.Activity;
import android.os.Bundle;
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
	
	public void submitEcho(View view){
		
		final EditText reply =  (EditText) findViewById(R.id.echotext);
		String rString = reply.getText().toString();
		
		if (submissionCheck(rString)){
			Echo newEcho = new Echo();
			newEcho.text = rString;
			EchoController.addEchoes(newEcho);
			
			Collection<Echo> echoes = EchoController.getEchoList().getEchoes();
			
			if (echoes.size() == 0){
				Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show();
			}
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

