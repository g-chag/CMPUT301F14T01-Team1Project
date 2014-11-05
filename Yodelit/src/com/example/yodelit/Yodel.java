package com.example.yodelit;

//Description: Class that describes a Yodel (question)
//
//Issues:


public class Yodel {
	protected int yID;
	public String question;
	public String info;
	

	
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
	
}
