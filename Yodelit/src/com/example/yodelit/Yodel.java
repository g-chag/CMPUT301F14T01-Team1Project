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


public class Yodel {
	protected int yID;
	public String question;
	public String info;
	public String Author;
	public Date date;
	public int upgoats; //Number of upgoats
	public int downgoats; //Number of downgoats
	public ArrayList<Echo> echoList = new ArrayList<Echo>();	
	
	//creation of a new Yodel and initializes content.
	//Needs date implemented.
	public Yodel(String question, String info){
		this.question = question;
		this.info = info;
		this.Author = YodelitController.getActiveUser().getUname();
		//NEEDS TO SET DATE
		this.upgoats = 0;
		this.downgoats = 0;
	}
	
	public String getYodelText() {
		return question;
	}
	
	public String toString() {
		return getYodelText();
	}

	public String getInfoText() {
		return info;
	}
	
	public void setYid(int index){
		yID = index;
	}

	public int getYid() {
		return yID;
	}
	
	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void addEcho(Echo echo){
		echoList.add(echo);
	}
	
	//-----For voting------//
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
	public ArrayList<Echo> getEchoList(){
		return echoList;
	}
	
}
