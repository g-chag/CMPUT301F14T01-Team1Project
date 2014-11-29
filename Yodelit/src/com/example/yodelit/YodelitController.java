/**
 * Controller class for Yodels, our equivalent of forum questions.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.util.ArrayList;

public class YodelitController {
	
	public static YodelList yodelList = null;
	public static Yodel viewYodel;
	public static User activeuser;
	
	/**
	* Creates a new Yodel.
 	*/
	public static YodelList getYodelList(){
		if( yodelList == null ){
			yodelList = new YodelList();
			return yodelList;
		}
		else{
			return yodelList;
		}
	}
	
	
	/**
	* Adds a Yodel.
 	*/
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
	
	public static boolean addAllYodels(ArrayList<Yodel> list){
		YodelList temp = getYodelList();
		return temp.addAll(list);
		
	}
	
	/**
	* Set current user.
 	*/
	public static void setActiveUser(User user){
		activeuser = user;
	}
	
	/**
	* Get current user..
 	*/
	public static User getActiveUser(){
		if (activeuser == null) {
			throw new RuntimeException("Null user.");
		}
		return activeuser;
	}

}
