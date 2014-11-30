package com.example.yodelit;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;

public class GeoLoc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5641804950085965912L;
	
	// this ArrayList was considered a God class
	// this method was not extracted into another class, as the code is very small
	public ArrayList<String> Location = new ArrayList<String>();
	
	public String coordinates;
	
	// this Context was considered a God class
	// this method was not extracted into another class, as the code is very small
	public Context currentContext;
	
	public GeoLoc(Context activityContext){
		currentContext = activityContext;
	}
	
	// this was method was considered a God class
	// this method was not extracted into another class, as it basically makes
	// up the entire GeoLoc class
	public ArrayList<String> findLocation() throws IOException{
		LocationManager locMan = (LocationManager)currentContext.getSystemService(Context.LOCATION_SERVICE);
		/*Criteria criteria = new Criteria();
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		String provider = locMan.getBestProvider(criteria, false);
		*/
		String provider = LocationManager.NETWORK_PROVIDER;
		Location lastKnownLoc = locMan.getLastKnownLocation(provider);
		if (lastKnownLoc != null){
			double lat =  lastKnownLoc.getLatitude();
			double  lon =  lastKnownLoc.getLongitude();
			List<Address> addresses=null;
			Geocoder geocoder = new Geocoder(currentContext, Locale.getDefault());
			addresses = geocoder.getFromLocation(lat,lon,1);
			if(addresses.size()>0){
				Address adress = addresses.get(0);
				if (adress != null){
					Location.add(adress.getLocality());
					Location.add(adress.getCountryName());
				}
				else{
					Location.add("None");
					Location.add("None");
				}
			}
			else{
				Location.add("None");
				Location.add("None");
			}
		}
		else{
			Location.add("None");
			Location.add("None");
		}
		return Location;
	}

}
