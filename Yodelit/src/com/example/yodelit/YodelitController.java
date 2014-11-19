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
	//----------------------------------------------------------
	//WIP. Based on the elastic search lab, this should use the UI thread for updating.
	class AddThread extends Thread {
		private Yodel theYodel;

		public AddThread(Yodel theYodel) {
			this.theYodel = theYodel;
		}

		@Override
		public void run() {
			YodelitController.addYodel(theYodel);
				
			// Give some time to get updated info
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//Need to run equivalent of the line below:
			//runOnUiThread(yodelAdapter.notifyDataSetChanged());
		}
	}
	//----------------------------------------------------------
	
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
		return activeuser;
	}

}
