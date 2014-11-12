package com.example.yodelit.test;

import com.example.yodelit.MainActivity;
import com.example.yodelit.R;
import com.example.yodelit.User;
import com.example.yodelit.UserActivity;
import com.example.yodelit.YodelitController;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

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

}
