package com.example.yodelit.test;

import com.example.yodelit.AddYodelActivity;
import com.example.yodelit.R;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

public class AddYodelActivityTest extends
		ActivityInstrumentationTestCase2<AddYodelActivity> {

	public AddYodelActivityTest() {
		super(AddYodelActivity.class);
		// TODO Auto-generated constructor stub
	}
	
	public void testSubmit(){
		try {
			runTestOnUiThread(new Runnable() {
				@Override
				public void run() {
					AddYodelActivity myAct = getActivity();
					Button button = (Button) myAct.findViewById(R.id.submit);
					TextView echoText = (TextView) myAct.findViewById(R.id.echoText);
					String blank = "";
					echoText.setText(blank);
					try{
					button.performClick();
					fail();
					} catch (IllegalArgumentException e){
						assertEquals("Please type in your question", e.getMessage());
					}
				}
			});
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}
}
