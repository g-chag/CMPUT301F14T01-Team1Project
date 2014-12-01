/**
 * Object class for "Yodel", our equivalent of forum questions. Contains a unique id, question, info, author, date, upgoats, downgoats and a list of related echos.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import android.content.Context;
import android.graphics.Bitmap;

public class Yodel {
	private YodelGeoExtra yodelGeoExtra = new YodelGeoExtra();
	protected int yID;
	public String question;
	
	// these variables were considered God classes
	// they were not extracted as the amount of code is very little
	// additionally, these lines of code are used in this class
	public String info;
	public String Author;
	public String date;
	public int upgoats; //Number of upgoats
	public int downgoats; //Number of downgoats
	public ArrayList<Echo> echoList = new ArrayList<Echo>();
	
	// this method was considered a God class
	// it was not extracted as it is only one line of code
	public ArrayList<String> upgoatList = new ArrayList<String>(); //list of user id that has upvoted
	
	public ArrayList<String> downgoatList = new ArrayList<String>(); //list of user if that has downvoted
	public Bitmap bm;
	
	/**
	* Creates and initializes a new Yodel.
	* Need to implement getting the date!
 	*/
	public Yodel(String question, String info){
		this.question = question;
		this.info = info;
		this.Author = YodelitController.getActiveUser().getUname();
		//NEEDS TO SET DATE
		this.upgoats = 0;
		this.downgoats = 0;
		Calendar now = Calendar.getInstance();
		this.date = now.get(Calendar.DAY_OF_MONTH) + "/"+ now.get(Calendar.MONTH) +"/"+ now.get(Calendar.YEAR);
		this.yodelGeoExtra.getLocation().add("none");
		this.yodelGeoExtra.getLocation().add("none");
	}
	
	/**
	* Returns the Yodel text.
 	*/
	public String getYodelText() {
		return question;
	}
	
	/**
	* Calls getYodelText().
 	*/
	public String toString() {
		return getYodelText();
	}

	/**
	* Returns the additional info as a string.
 	*/
	public String getInfoText() {
		return info;
	}
	
	/**
	*  Sets the Yodels ID.
 	*/
	public void setYid(int index){
		yID = index;
	}

	/**
	*  Gets the Yodels ID.
 	*/
	public int getYid() {
		return yID;
	}
	
	/**
	*  Gets the Yodels author.
 	*/
	public String getAuthor() {
		return Author;
	}

	/**
	*  Sets the Yodels author.
 	*/
	// this was also considered a God class
	// it was not extracted as it serves a similar functionality as
	// the other methods in the class
	// additionally, the code amount is extremely small to extract
	public void setAuthor(String author) {
		Author = author;
	}
	
	/**
	*  Gets the Yodels date.
 	*/
	public String getDate() {
		return date;
	}
	
	/**
	*  Sets the Yodels date.
 	*/
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	*  Appends an Echo to the Yodel.
 	*/
	public void addEcho(Echo echo){
		echoList.add(echo);
	}
	
	/**
	*  Gets the Upgoats of the Yodel.
 	*/
	public int getUpgoats() {
		return upgoats;
	}
	
	/**
	*  Sets the Upgoats of the Yodel.
 	*/
	public void setUpgoats(int upgoats) {
		this.upgoats = upgoats;
	}
	
	public void setLocationGPS(Context context) {
		yodelGeoExtra.setLocationGPS(context);
		
	}
	public ArrayList<String> getLocation() {
		if (yodelGeoExtra == null){
			ArrayList<String> list = new ArrayList<String>();
		    list.add("None");
		    list.add("None");
		    return list;
		}else{
			
		return yodelGeoExtra.getLocation();
		}
	}
	

	
	/**
	*  Gets the Downgoats of the Yodel.
 	*/
	public int getDowngoats() {
		return downgoats;
	}
	
	/**
	*  Sets the Downgoats of the Yodel.
 	*/
	public void setDowngoats(int downgoats) {
		this.downgoats = downgoats;
	}
	
	/**
	*  Returns the list of Echos attached to the Yodel.
 	*/
	public ArrayList<Echo> getEchoList(){
		return echoList;
	}
	
	/**
	*  Adds UpGoats to the Yodel.
 	*/
	public void addUserUpVote(){
		this.upgoatList.add(YodelitController.getActiveUser().getUname()); //TODO: NEEDS TO BE user id number!!
	}
	
	/**
	*  Adds DownGoats to the Yodel.
 	*/
	public void addUserDownVote(){
		this.downgoatList.add(YodelitController.getActiveUser().getUname()); //TODO: NEEDS TO BE user id number!!
	}
	
	/**
	*  Gets number of UpGoats.
 	*/
	public ArrayList<String> getUsersUpVote(){
		return this.upgoatList; //TODO: NEEDS TO BE user id number!!
	}
	
	/**
	*  Gets number of DownGoats.
 	*/
	public ArrayList<String> getUsersDownVote(){
		return this.downgoatList;
	}
	
	/**
	*  Returns Bitmap value.
 	*/
	public Bitmap getBitmap(){
		return bm;
	}
	
	/**
	*  Sets Bitmap value.
 	*/
	public void setBitmap(Bitmap bitmap)
	{
		this.bm = bitmap;
	}

	/**Sets user location.
 	*/
	public void setLocation(YodelGeoExtra yge) {
		yodelGeoExtra = yge;
		
	}
	
}
