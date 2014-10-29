package com.example.yodelit;

import java.sql.Date;

public class Yodel {
	public String question;
	public String content;
	public String Author;
	public int YID;
	public Date date;
	public int upgoats;
	public String getText() {
		return question;
	}
	public void setText(String text) {
		this.question = question;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String text) {
		this.content = content;
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
		YID = yID;
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
