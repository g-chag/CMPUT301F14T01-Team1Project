/**
 * Controller class for Yodels, our equivalent of forum questions.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import android.util.Log;

public class YodelitController {
	
	public static YodelList yodelList = null;
	public static Yodel viewYodel;
	public static User activeuser;
	
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
		int index = temp.getYodels().size();
		yodel.setYid(index);
		//Log.i("XXX", "Yodel List " + temp + (temp == null));
		temp.addYodel(yodel);
		//Log.i("XXX", "Yodels " + yodelList.getYodels());
		//Log.i("XXX", "After" + yodelList.getYodels().size());
	}
	
	public static void setActiveUser(User user){
		activeuser = user;
	}
	public static User getActiveUser(){
		return activeuser;
	}

}
