package com.example.yodelit.test;

import java.util.Collection;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

import com.example.yodelit.HomeActivity;
import com.example.yodelit.R;
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
		try {
			Yodel tempYodel = new Yodel("Question", "Clarification");
			YodelList tempYodelList = new YodelList();
			tempYodelList.addYodel(tempYodel);
			assertEquals(tempYodelList.getYodel(0),tempYodel);
		} catch (Throwable e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testYodelQuestion(){
		//test for question posting
		//make sure to disallow empty subject box
		try {
			Collection<Yodel> yodels = YodelitController.getYodelList().getYodels();
			Yodel y = new Yodel("Tester", "Tester info");
			yodels.add(y);
			assertEquals(yodels.size(), 1);
			Yodel y2 = new Yodel("Tester2", "Tester info2");
			yodels.add(y2);
			assertEquals(yodels.size(), 2);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testUpgoat(){
		try{
			HomeActivity myAct = getActivity();
			Button button = (Button) myAct.findViewById(R.id.upB);
			//TextView upText = (TextView) myAct.findViewById(R.id.upText);
			//String before = upText.toString();
			button.performClick();
			//String after = upText.toString();
			//assertEquals(before, "0");
			//assertEquals(after, "1");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void testDowngoat(){
		try{
			HomeActivity myAct = getActivity();
			Button button = (Button) myAct.findViewById(R.id.downB);
			//TextView downText = (TextView) myAct.findViewById(R.id.downText);
			//String before = downText.toString();
			button.performClick();
			//String after = downText.toString();
			//assertEquals(before, "0");
			//assertEquals(after, "-1");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
