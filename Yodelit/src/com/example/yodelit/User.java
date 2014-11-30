/**
 * Object class for users. Stores information such as their Yodel history, user name and favorites.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.util.ArrayList;

public class User {
	public String Uname;
	//private int UID;
	public ArrayList<Integer> YodelHist = new ArrayList<Integer>();
	public ArrayList<Integer> YodelFavs = new ArrayList<Integer>();
	
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
	
}
