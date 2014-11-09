/**
 * Controller class for Echoes, our equivalent of replies.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.util.ArrayList;

import android.util.Log;

public class EchoController {
	
public static EchoList echoList = null;
	
	/**
 	* Returns the EchoList in question. Instantiates a new EchoList if one cannot be found.
 	*/
	public static EchoList getEchoList(){
		if( echoList == null ){
			echoList = new EchoList();
			return echoList;
		}
		else{
			return echoList;
		}
	}
	
	/**
 	* Adds an Echo to the EchoList.
 	*/
	public static void addEchoes(Echo echo){
		EchoList temp = getEchoList();
		Log.i("XXX", "Echo List " + temp + (temp == null));
		getEchoList().addEcho(echo);
		Log.i("XXX", "Yodels " + echoList.getEchoes());
		Log.i("XXX", "After" + echoList.getEchoes().size());
	}

}
