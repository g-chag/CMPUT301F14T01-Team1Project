package com.example.yodelit;

//Description: Controller for the Yodel lists. 
//
//Issues:

import android.util.Log;

public class YodelitController {
	
	public static YodelList yodelList = null;
	
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
		//Log.i("XXX", "Yodel List " + temp + (temp == null));
		temp.addYodel(yodel);
		//Log.i("XXX", "Yodels " + yodelList.getYodels());
		//Log.i("XXX", "After" + yodelList.getYodels().size());
	}
	
	
	
	

}
