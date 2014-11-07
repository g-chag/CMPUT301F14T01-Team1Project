package com.example.yodelit.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;

import com.example.yodelit.MainActivity;
import com.example.yodelit.R;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity>{
	
	public MainActivityTest(){
		super(MainActivity.class);
	}
	
	public void testUserName(){
		MainActivity myAct = getActivity();
		Button button = (Button) myAct.findViewById(R.id.uNButton);
		EditText userEditText = (EditText) myAct.findViewById(R.id.userNameEditText);
		String blank = "";
		userEditText.setText(blank);
		try{
			button.performClick();
			fail();
		} catch (Exception e){
			assertEquals(e.getMessage(), "Please enter a proper user name");	
		}
		
	}
	
}
