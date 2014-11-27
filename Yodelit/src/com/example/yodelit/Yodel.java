/**
 * Object class for "Yodel", our equivalent of forum questions. Contains a unique id, question, info, author, date, upgoats, downgoats and a list of related echos.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;

public class Yodel {
	protected int yID;
	public String question;
	public String info;
	public String Author;
	public Date date;
	public ArrayList<String> Location = new ArrayList<String>();
	public int upgoats; //Number of upgoats
	public int downgoats; //Number of downgoats
	public ArrayList<Echo> echoList = new ArrayList<Echo>();	
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
		this.Location.add("none");
		this.Location.add("none");
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
	public void setAuthor(String author) {
		Author = author;
	}
	
	/**
	*  Gets the Yodels date.
 	*/
	public Date getDate() {
		return date;
	}
	
	/**
	*  Sets the Yodels date.
 	*/
	public void setDate(Date date) {
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
		GeoLoc gl = new GeoLoc(context);
		try {
			Location = gl.findLocation();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Location.add("Broken");
			Location.add("Broken");
		}
		
	}
	public ArrayList<String> getLocation() {
		return Location;
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
	
	public void addUserUpVote(){
		this.upgoatList.add(YodelitController.getActiveUser().getUname()); //TODO: NEEDS TO BE user id number!!
	}
	public void addUserDownVote(){
		this.downgoatList.add(YodelitController.getActiveUser().getUname()); //TODO: NEEDS TO BE user id number!!
	}
	
	public ArrayList<String> getUsersUpVote(){
		return this.upgoatList; //TODO: NEEDS TO BE user id number!!
	}
	public ArrayList<String> getUsersDownVote(){
		return this.downgoatList;
	}
	
	public Bitmap getBitmap(){
		return bm;
	}
	
	public void setBitmap(Bitmap bitmap)
	{
		this.bm = bitmap;
	}
	
}
