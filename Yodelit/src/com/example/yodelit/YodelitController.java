package com.example.yodelit;

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
		Log.i("XXX", "Yodel List " + temp + (temp == null));
		getYodelList().addYodel(yodel);
		Log.i("XXX", "Yodels " + yodelList.getYodels());
		Log.i("XXX", "After" + yodelList.getYodels().size());
	}
	
	

}
