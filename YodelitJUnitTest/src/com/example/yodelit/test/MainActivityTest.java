package com.example.yodelit.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;

import com.example.yodelit.MainActivity;
import com.example.yodelit.R;
import com.example.yodelit.User;
import com.example.yodelit.YodelitController;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity>{
	
	public MainActivityTest(){
		super(MainActivity.class);
	}
	
	public void testSetUser(){
		User user = new User();
		user.setUname("testuser");
		assertEquals(user.getUname().toString(), "testuser");
	}
	
	public void testGetActive(){
		User user = new User();
		user.setUname("testuser2");
		YodelitController.setActiveUser(user);
		assertEquals(user.Uname, YodelitController.getActiveUser().Uname);
	}
	
	public void testUserName() {
		try {
			runTestOnUiThread(new Runnable() {
				@Override
				public void run() {
					MainActivity myAct = getActivity();
					Button button = (Button) myAct.findViewById(R.id.uNButton);
					EditText userEditText = (EditText) myAct.findViewById(R.id.userNameEditText);
					String blank = "";
					userEditText.setText(blank);
					button.performClick();
					fail();
				}
			});
		} catch (IllegalArgumentException e){
			assertEquals("Please enter a proper user name", e.getMessage());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testInputField(){
		try {
			runTestOnUiThread(new Runnable() {
				@Override
				public void run() {
					MainActivity myAct = getActivity();
					Button button = (Button) myAct.findViewById(R.id.uNButton);
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
}

