package com.example.yodelit.test;

import java.util.Collection;

import android.test.ActivityInstrumentationTestCase2;

import com.example.yodelit.HomeActivity;
import com.example.yodelit.Yodel;
import com.example.yodelit.YodelList;
import com.example.yodelit.YodelitController;

public class HomeActivityTest extends ActivityInstrumentationTestCase2<HomeActivity>{

	public HomeActivityTest(){
		super(HomeActivity.class);
	}
	public void testPass(){
		assertTrue(true);
	}
	/*public void testFail(){
		throw new UnsupportedOperationException("Intentional Failure");
	}
	*/
	public void testYodels() {
		Yodel tempYodel = new Yodel("Test Question","Test Clarification");
		YodelList tempYodelList = new YodelList();
		tempYodelList.addYodel(tempYodel);
		assertEquals(tempYodelList.getYodel(0),tempYodel);
	}
	
	public void testYodelQuestion(){
		//test for question posting
		//make sure to disallow empty subject box
		Collection<Yodel> yodels = YodelitController.getYodelList().getYodels();
		Yodel y = new Yodel("Tester", "Tester info");
		yodels.add(y);
		assertEquals(yodels.size(), 1);
		Yodel y2 = new Yodel("Tester2", "Tester info2");
		yodels.add(y2);
		assertEquals(yodels.size(), 2);
	}
}
