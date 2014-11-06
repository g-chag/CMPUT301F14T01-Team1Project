package com.example.yodelit;

//Description: Main loading screen. Gives a button for login after user enters a username. Does not check for password.
//
//Issues:

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
  
    
	public void login(View view) {
		//Toast.makeText(this, "Archive", Toast.LENGTH_SHORT).show();
		EditText userEditText = (EditText) findViewById(R.id.userNameEditText);
		String username = userEditText.getText().toString();
		User user = new User();
		user.setUname(username);
		YodelitController.setActiveUser(user);
		Intent intent = new Intent(MainActivity.this, HomeActivity.class);
		startActivity(intent);
	}
}
