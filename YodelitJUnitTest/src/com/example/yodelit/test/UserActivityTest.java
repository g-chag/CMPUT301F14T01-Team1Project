package com.example.yodelit.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.yodelit.R;
import com.example.yodelit.User;
import com.example.yodelit.UserActivity;
import com.example.yodelit.YodelitController;

public class UserActivityTest extends ActivityInstrumentationTestCase2<UserActivity>{

	public UserActivityTest(){
		super(UserActivity.class);
	}
	
	public void testUserText(){
		User user = new User("tester");
		//YodelitController yodel = new YodelitController();
		YodelitController.setActiveUser(user);
		UserActivity myAct = getActivity();
		TextView userEditText = (TextView) myAct.findViewById(R.id.usernameText);
		assertEquals("tester", userEditText.getText());
	}
	
	public void testChangeButton() throws Throwable{ //test not fully completed yet ##
		User user = new User("tester");
		YodelitController.setActiveUser(user);
		UserActivity myAct = getActivity();
		final TextView uText = (TextView) myAct.findViewById(R.id.usernameText);
		final TextView changeText = (TextView) myAct.findViewById(R.id.changeUser);
		runTestOnUiThread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				uText.setText("tester");
				changeText.performClick();
			}
		});
	}
	
	public void testChangeLocation() {
		User user = new User("tester");
		user.setLocation("Edmonton, Canada");
		UserActivity myAct = getActivity();
		TextView changeLoc = (TextView) myAct.findViewById(R.id.changeLocText);
		changeLoc.setText("London, England");
		assertNotSame(user.getLocation(), changeLoc.getText());
	}
	
	
}
