package com.example.yodelit;

public class User {
	public String Uname;
	private int UID;
	public int[] YodelHist;
	public int[] YodelFavs;
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public int[] getYodelHist() {
		return YodelHist;
	}
	public void setYodelHist(int[] yodelHist) {
		YodelHist = yodelHist;
	}
	public int[] getYodelFavs() {
		return YodelFavs;
	}
	public void setYodelFavs(int[] yodelFavs) {
		YodelFavs = yodelFavs;
	}
	
}
