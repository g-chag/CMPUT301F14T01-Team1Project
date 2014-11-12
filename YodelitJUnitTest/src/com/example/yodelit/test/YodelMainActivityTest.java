package com.example.yodelit.test;

import com.example.yodelit.Echo;
import com.example.yodelit.MainActivity;
import com.example.yodelit.R;
import com.example.yodelit.User;
import com.example.yodelit.Yodel;
import com.example.yodelit.YodelitController;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;

import com.example.yodelit.YodelMainActivity;

public class YodelMainActivityTest extends
		ActivityInstrumentationTestCase2<YodelMainActivity> {

	String username = "testuser";
	
	public YodelMainActivityTest() {
		super(YodelMainActivity.class);
	}
	
	public void testgetYodelText(){
		User user = new User(username);
		YodelitController.setActiveUser(user);
		Yodel y1 = new Yodel("Question","Info");
		assertEquals("Question", y1.getYodelText());
	}
	
	public void testgetYodelInfo(){
		User user = new User(username);
		YodelitController.setActiveUser(user);
		Yodel y1 = new Yodel("Question","Info");
		assertEquals("Info", y1.getInfoText());	
	}
	
	public void testgetYID(){
		User user = new User(username);
		YodelitController.setActiveUser(user);
		Yodel y1 = new Yodel("Question","Info");
		assertEquals(y1.getYid(),0);
	}
	
	public void testsetYID(){
		User user = new User(username);
		YodelitController.setActiveUser(user);
		Yodel y1 = new Yodel("Question","Info");
		y1.setYid(5);
		assertEquals(y1.getYid(),5);
	}
	
	public void testgetsetAuthor(){
		User user = new User(username);
		YodelitController.setActiveUser(user);
		Yodel y1 = new Yodel("Question","Info");
		y1.setYid(5);
		assertEquals(y1.getAuthor(), "testuser");
		y1.setAuthor("testuser2");
		assertEquals(y1.getAuthor(), "testuser2");
		
	}
	public void testAddEcho(){
		User user = new User(username);
		YodelitController.setActiveUser(user);
		Yodel y1 = new Yodel("Question","Info");
		Echo e1 = new Echo("reply");
		y1.echoList.add(e1);
		assertEquals(y1.getEchoList().get(0).getText(), "reply");
		
	}
}
