/**
 * Object class for users. Stores information such as their Yodel history, user name and favorites.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Context;

public class User {
	public String Uname;
	//private int UID;
	public ArrayList<Integer> YodelHist = new ArrayList<Integer>();
	public ArrayList<Integer> YodelFavs = new ArrayList<Integer>();
	public ArrayList<Echo> echoList = new ArrayList<Echo>();
	public YodelGeoExtra yodelGeoExtra = new YodelGeoExtra();
	
	public User(String username){
		this.Uname = username;
	}
	/**
 	* Get username.
 	*/
	public String getUname() {
		return Uname;
	}
	
	/**
 	* Change username to string provided.
 	*/
	public void setUname(String uname) {
		Uname = uname;
	}
	
	/**
 	* Get ID of the yodels the person has Yodelled.
 	*/
	public ArrayList<Integer> getYodelHist() {
		return YodelHist;
	}
	
	/**
 	* Set users Yodel history to the argument provided.
 	*/
	public void setYodelHist(ArrayList<Integer> yodelHist) {
		YodelHist = yodelHist;
	}
	
	/**
 	* Get the users favorite Yodels.
 	*/
	public ArrayList<Integer> getYodelFavs() {
		return YodelFavs;
	}
	
	/**
 	* Set the users favorite Yodels.
 	*/
	public void setYodelFavs(ArrayList<Integer> yodelFavs) {
		YodelFavs = yodelFavs;
	}
	
	
	public void setLocationGPS(Context context) {
		yodelGeoExtra.setLocationGPS(context);
	}
	
	// this method was found to be a bad smell in newYodelAdapter.java
	// it was suggested to move the method over to User.java
	// this change was accepted as the method deals with attempting to ensure
	// that a username is valid, and since it deals with the user, is better
	// suited to be in file with other user information
	public String tryName() {
		String tempUserString;
		try {
			tempUserString = getUname();
		}
		catch (Exception e) {
			tempUserString = " ";
		}
		return tempUserString;
	}
	public YodelGeoExtra getLocation() {
		return yodelGeoExtra;
	}
	public void setLocation(String location) {
		String[] temp = location.split(",");
		if (temp.length< 1){
			ArrayList<String> empty = new ArrayList<String>();
			empty.add("None");
			empty.add("None");
			yodelGeoExtra.setLocation(empty);
		}
		else if (temp.length < 2){
			if (temp[0].equals("")){
				ArrayList<String> empty = new ArrayList<String>();
				empty.add("None");
				empty.add("None");
				yodelGeoExtra.setLocation(empty);
			}else{
				ArrayList<String> country = new ArrayList<String>();
				country.add("None");
				country.add(temp[0]);
				yodelGeoExtra.setLocation(country);
			}
		}
		else{
			ArrayList<String> both = new ArrayList<String>();
			both.add(temp[0]);
			both.add(temp[1]);
			yodelGeoExtra.setLocation(both);
		}
		
	}
	
}
