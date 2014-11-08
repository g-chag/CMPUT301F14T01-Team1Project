/**
 * Object class for "Echo", our equivalent of replies. Contains text, author, Yodel id it belongs to, unique Echo id, date posted and number of up and down goats.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

//Description: This class defines an Echo (answer to a question)
//
//Issues:


import java.sql.Date;

public class Echo {
	public String text; //Text of the reply
	public String Author; //Author/username id
	protected int YID; //ID of the Yodel echo is responding to
	protected int EID; //ID of the Echo
	public Date date; //Date
	public int upgoats; //Number of upgoats
	public int downgoats; //Number of downgoats
	
	public Echo(String text){
		this.text = text;
		this.Author = YodelitController.activeuser.getUname();
		//NEEDS TO SET DATE
		this.upgoats = 0;
		this.downgoats = 0;
	}
	public String getText() {
		return text;
	}
	public String toString(){
		return getText();
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public int getYID() {
		return YID;
	}
	public void setYID(int yID) {
		this.YID = yID;
	}
	public int getEID() {
		return EID;
	}
	public void setEID(int eID){
		this.EID = eID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getUpgoats() {
		return upgoats;
	}
	public void setUpgoats(int upgoats) {
		this.upgoats = upgoats;
	}
	public int getDowngoats() {
		return downgoats;
	}
	public void setDowngoats(int downgoats) {
		this.downgoats = downgoats;
	}
}
