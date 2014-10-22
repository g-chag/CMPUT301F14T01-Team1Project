package com.example.yodelit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ForumActivity extends Activity {

	@SuppressWarnings("unused") //remove this once button functionality is implemented
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forum);
		
		//The 9 buttons represent the 9 forums that are displayed in the forum activity.
		//Should we name the buttons after topics or by the order they are shown?
		
        Button topic1 = (Button) findViewById(R.id.topic1);
        Button topic2 = (Button) findViewById(R.id.topic2);
        Button topic3 = (Button) findViewById(R.id.topic3);
        Button topic4 = (Button) findViewById(R.id.topic4);
        Button topic5 = (Button) findViewById(R.id.topic5);
        Button topic6 = (Button) findViewById(R.id.topic6);
        Button topic7 = (Button) findViewById(R.id.topic7);
        Button topic8 = (Button) findViewById(R.id.topic8);
        Button topic9 = (Button) findViewById(R.id.topic9);
        
        //The following toast is just to verify one of the buttons is working.
        topic1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "This button works.", Toast.LENGTH_SHORT).show(); 
			}
		});
	}
}