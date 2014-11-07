/**
 * Object class for "Yodel", our equivalent of forum questions.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.sql.Date;
import java.util.ArrayList;

//Description: Class that describes a Yodel (question)
//
//Issues:


public class Yodel {
	protected int yID;
	public String question;
	public String info;
	public String Author;
	public Date date;
	public ArrayList<Echo> echoList = new ArrayList<Echo>();	
	
	public Yodel(String question, String info){
		this.question = question;
		this.info = info;
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
	
	public void addEcho(Echo echo){
		echoList.add(echo);
	}
	
	public ArrayList<Echo> getEchoList(){
		return echoList;
	}
	
}
