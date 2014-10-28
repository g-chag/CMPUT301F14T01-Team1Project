package com.example.yodelit;

import java.sql.Date;

public class Echo {
	public String text;
	public String Author;
	public int YID;
	public int EID;
	public Date date;
	public int upgoats;
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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
}
