/**
 * Object class for "Echo", our equivalent of replies. Contains text, author, Yodel id it belongs to, unique Echo id, date posted and number of up and down goats.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.sql.Date;
import java.util.ArrayList;

public class Echo {
	public String text; //Text of the reply
	public String Author; //Author/username id
	protected int YID; //ID of the Yodel echo is responding to
	protected int EID; //ID of the Echo
	public Date date; //Date
	public int upgoats; //Number of upgoats
	public int downgoats; //Number of downgoats
	public ArrayList<String> upgoatList = new ArrayList<String>(); //list of user id that has upvoted
	public ArrayList<String> downgoatList = new ArrayList<String>(); //list of user if that has downvoted
	
	public Echo(String text){
		this.text = text;
		this.Author = YodelitController.activeuser.getUname();
		//NEEDS TO SET DATE
		this.upgoats = 0;
		this.downgoats = 0;
	}
	/**
	 * Returns the Echo's text.
	 */
	public String getText() {
		return text;
	}
	/**
	 * Overhead method for returning Echo as a string. Redundant.
	 */
	public String toString(){
		return getText();
	}
	/**
	 * Returns the Echo's author.
	 */
	public String getAuthor() {
		return Author;
	}
	/**
	 * Takes a string, and sets the Echo's author to that string.
	 */
	public void setAuthor(String author) {
		Author = author;
	}
	/**
	 * Returns the ID of the associated Yodel.
	 */
	public int getYID() {
		return YID;
	}
	/**
	 * Sets the ID of the Yodel to which the Echo is attached to.
	 */
	public void setYID(int yID) {
		this.YID = yID;
	}
	/**
	 * Returns the Echo's ID.
	 */
	public int getEID() {
		return EID;
	}
	/**
	 * Sets the Echo's ID.
	 */
	public void setEID(int eID){
		this.EID = eID;
	}
	/**
	 * Returns the Echo's date.
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * Sets the Echo's date.
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * Returns the Echo's upgoat count.
	 */
	public int getUpgoats() {
		return upgoats;
	}
	/**
	 * Sets the Echo's upgoat count.
	 */
	public void setUpgoats(int upgoats) {
		this.upgoats = upgoats;
	}
	/**
	 * Returns the Echo's downgoat count.
	 */
	public int getDowngoats() {
		return downgoats;
	}
	/**
	 * Sets the Echo's downgoat count.
	 */
	public void setDowngoats(int downgoats) {
		this.downgoats = downgoats;
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
	
}
