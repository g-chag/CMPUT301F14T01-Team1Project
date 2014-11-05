package com.example.yodelit;

//Description: Controller for the Yodel lists. 
//
//Issues:

import android.util.Log;

public class YodelitController {
	
	public static YodelList yodelList = null;
	public static Yodel viewYodel;
	
	public static YodelList getYodelList(){
		if( yodelList == null ){
			yodelList = new YodelList();
			return yodelList;
		}
		else{
			return yodelList;
		}
	}
	
	public static void addYodel(Yodel yodel){
		YodelList temp = getYodelList();
		
		//set yodel id (len of yodels + 1)
		int id = temp.getYodels().size();
		yodel.setyID(id);
		//Log.i("XXX", "Yodel List " + temp + (temp == null));
		temp.addYodel(yodel);
		//Log.i("XXX", "Yodels " + yodelList.getYodels());
		//Log.i("XXX", "After" + yodelList.getYodels().size());
	}
	
	public static void setViewYodel(Yodel id){
		viewYodel = id;
		return;
	}
	public static Yodel getViewYodel(){
		return viewYodel;
	}
	
	

}
