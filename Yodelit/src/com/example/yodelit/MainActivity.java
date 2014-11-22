/**
 * Activity that handles the main loading screen. Gives a button for login, and setting username.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
 
    /**
 	* Sign in function. Checks for valid input.
 	*/
	public void login(View view) {
		//Toast.makeText(this, "Archive", Toast.LENGTH_SHORT).show();
		EditText userEditText = (EditText) findViewById(R.id.userNameEditText);
		String username = userEditText.getText().toString();
		if (submissionCheck(username)){
			User user = new User(username);
			YodelitController.setActiveUser(user);
			Intent intent = new Intent(MainActivity.this, HomeActivity.class);
			startActivity(intent);
		} else {
			Toast.makeText(this, "Please enter a username", Toast.LENGTH_SHORT).show();
		}
	}
	
	public boolean submissionCheck(String username){
		if (username.isEmpty()){
			return false;
		}
		return true;		
	}
}
