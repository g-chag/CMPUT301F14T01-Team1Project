package com.example.yodelit;

import java.util.ArrayList;

public class User {
	public String Uname;
	private int UID;
	public ArrayList<Integer> YodelHist = new ArrayList<Integer>();
	public ArrayList<Integer> YodelFavs = new ArrayList<Integer>();
	
	
	public String getUname() {
		return Uname;
	}
	
	public void setUname(String uname) {
		Uname = uname;
	}
	public ArrayList<Integer> getYodelHist() {
		return YodelHist;
	}
	public void setYodelHist(ArrayList<Integer> yodelHist) {
		YodelHist = yodelHist;
	}
	public ArrayList<Integer> getYodelFavs() {
		return YodelFavs;
	}
	public void setYodelFavs(ArrayList<Integer> yodelFavs) {
		YodelFavs = yodelFavs;
	}
	
}
