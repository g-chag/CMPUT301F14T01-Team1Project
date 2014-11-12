package com.example.yodelit.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import com.example.yodelit.MainActivity;
import com.example.yodelit.R;
import com.example.yodelit.User;
import com.example.yodelit.YodelitController;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity>{
	String username = "testuser";
	
	public MainActivityTest(){
		super(MainActivity.class);
	}
	
	public void testSetUser(){
		User user = new User(username);
		assertEquals(user.getUname().toString(), "testuser");
	}
	
	public void testGetActive(){
		User user = new User(username);
		YodelitController.setActiveUser(user);
		assertEquals(user.getUname(), YodelitController.getActiveUser().getUname());
	}
	
	public void testUserName() {
		//Trying to ensure exception is thrown when no user name is entered
		try {
			runTestOnUiThread(new Runnable() {
				@Override
				public void run() {
					MainActivity myAct = getActivity();
					Button button = (Button) myAct.findViewById(R.id.uNButton);
					EditText userEditText = (EditText) myAct.findViewById(R.id.userNameEditText);
					userEditText.setText("");
					try{
						button.performClick();
						fail();
					} catch (Exception e){
						assertEquals("okay", e, "Please enter a proper user name");
					}
				}
			});
		}
		catch (Throwable e){
			e.printStackTrace();
			}
	}
	
	public void testInputField(){
		//Trying to ensure the field has texts in it
		try {
			runTestOnUiThread(new Runnable() {
				@Override
				public void run() {
					MainActivity myAct = getActivity();
					//Button button = (Button) myAct.findViewById(R.id.uNButton);
					EditText userEditText = (EditText) myAct.findViewById(R.id.userNameEditText);
					userEditText.setText("testuser");
					assertEquals("testuser", userEditText.getText());
				}
			});
		}
		catch (Throwable e){
			e.printStackTrace();
			}
	}
	
	public void testButtonClickSetUsername(){
		//Testing the set button and making sure user has the name from the getUname function
		try {
			runTestOnUiThread(new Runnable() {
				@Override
				public void run() {
					MainActivity myAct = getActivity();
					Button button = (Button) myAct.findViewById(R.id.uNButton);
					//EditText userEditText = (EditText) myAct.findViewById(R.id.userNameEditText);
					User user = new User(username);
					button.performClick();
					assertEquals(user.getUname(), "tester");								
				}
			});
		}
		catch (Throwable e){
			e.printStackTrace();
			}
		
		}		
}

