package com.example.yodelit.test;
import android.test.ActivityInstrumentationTestCase2;
import com.example.yodelit.HomeActivity;
import com.example.yodelit.Yodel;
import com.example.yodelit.YodelList;

public class HomeActivityTest extends ActivityInstrumentationTestCase2<HomeActivity>{

	public HomeActivityTest(){
		super(HomeActivity.class);
	}
	public void testPass(){
		assertTrue(true);
	}
	public void testFail(){
		throw new UnsupportedOperationException("Intentional Failure");
	}
	public void testYodels() {
		Yodel tempYodel = new Yodel("Test Question","Test Clarification");
		YodelList tempYodelList = new YodelList();
		tempYodelList.addYodel(tempYodel);
		assertEquals(tempYodelList.getYodel(0),tempYodel);
	}

}
