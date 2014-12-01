package com.example.yodelit.test;

import java.util.ArrayList;
import java.util.List;

import com.example.yodelit.YodelGeoExtra;
import com.example.yodelit.GeoLoc;

import android.location.Address;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

public class GeoLocTest extends ActivityInstrumentationTestCase2<YodelGeoExtra> {

	//what to do if the test passes
	public void testPass(){
		assertTrue(true);
	}
	
	//what to do if the test fails
	public void testFail(){
		throw new UnsupportedOperationException("Intentional Failure");
	}
	
	//creates a new arraylist for location
	private ArrayList<String> Location = new ArrayList<String>();

	//autogenerated method to remove errors
	public GeoLocTest(Class<YodelGeoExtra> YodelGeoExtra) {
		super(YodelGeoExtra);
		// TODO Auto-generated constructor stub
	}

	//checks to see if a location can be retrieved
	public ArrayList<String> getLocation() {
		if (Location == null){
			Location.add("None");
			Location.add("None");
			testPass();
		}
		else if (Location != null){
			List<Address> addresses=null;
			Address adress = addresses.get(0);
			Location.add(adress.getLocality());
			Location.add(adress.getCountryName());
			testPass();
		}
		else{
			testFail();
		}
	}
}