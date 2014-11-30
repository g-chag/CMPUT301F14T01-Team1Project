/**
 * Object class for "Yodel", our equivalent of forum questions. Contains a unique id, question, info, author, date, upgoats, downgoats and a list of related echos.
 * @author  Yodelit!
 * @version  3.0
 * @since  1.0
 */
package com.example.yodelit;


import java.util.ArrayList;
import android.content.Context;
import java.io.IOException;

// this class was extracted from Yodel.java
// it was considered to be a God class in Yodel.java
// it was extracted because what is does is more so of an
// accessory to the Yodels, rather than a core functionality
public class YodelGeoExtra {
	private ArrayList<String> Location = new ArrayList<String>();

	public ArrayList<String> getLocation() {
		return Location;
	}

	public void setLocation(ArrayList<String> Location) {
		this.Location = Location;
	}

	public void setLocationGPS(Context context) {
		GeoLoc gl = new GeoLoc(context);
		try {
			Location = gl.findLocation();
		} catch (IOException e) {
			Location.add("Broken");
			Location.add("Broken");
		}
	}
}