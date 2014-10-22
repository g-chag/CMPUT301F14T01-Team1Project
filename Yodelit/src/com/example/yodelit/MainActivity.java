package com.example.yodelit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button uNButton = (Button) findViewById(R.id.uNButton); //Could be declared earlier with other variables for neatness.
        Log.v("hi", "hi");
        
        uNButton.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			Intent forumActivity = new Intent(v.getContext(), ForumActivity.class);
    			startActivity(forumActivity);
    		}
        });
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
