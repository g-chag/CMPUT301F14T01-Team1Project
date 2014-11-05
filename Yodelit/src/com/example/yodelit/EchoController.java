package com.example.yodelit;

//Description: Controller for the Echo lists.
//
//Issues:

import java.util.ArrayList;

import android.util.Log;

public class EchoController {
	
public static EchoList echoList = null;
	
	public static EchoList getEchoList(){
		if( echoList == null ){
			echoList = new EchoList();
			return echoList;
		}
		else{
			return echoList;
		}
	}
	
	public static void addEchoes(Echo echo){
		EchoList temp = getEchoList();
		Log.i("XXX", "Echo List " + temp + (temp == null));
		getEchoList().addEcho(echo);
		Log.i("XXX", "Yodels " + echoList.getEchoes());
		Log.i("XXX", "After" + echoList.getEchoes().size());
	}

}
