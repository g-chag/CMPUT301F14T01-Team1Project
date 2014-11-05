package com.example.yodelit;

//Description: Class for the Yodel lists. Includes listener methods and adding methods to the array.
//
//Issues:

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

import android.util.Log;


public class EchoList {
	
	private ArrayList<Echo> List;
	protected transient ArrayList<Listener> listeners;

	public EchoList() {
		List = new ArrayList<Echo>();
		listeners = new ArrayList<Listener>();

	}

//	public ArrayList<Echo> toArray() {
//		if (this != null){
//			return this.toArray();}
//		else {
//			return new ArrayList<Echo>;
//		}
//	}
	
	
	public ArrayList<Echo> addAll(EchoList echos){
		return this.addAll(echos);
	}
	

	// ------Listener methods------//

	private ArrayList<Listener> getListeners() {
		if (listeners == null) {
			listeners = new ArrayList<Listener>();
		}
		return listeners;
	}

	private void notifyeveryone() {
		for (Listener listener : listeners) {
			listener.update();
		}

	}

	public void addListener(Listener l) {
		getListeners().add(l);
	}

	public void removeListener(Listener l) {
		getListeners().remove(l);
	}

	// ------------------------------//

	// ------YodelList Methods-------//

	public void addEcho(Echo echo) {
		Log.i("XXX", echo.toString() + " " + List.size());
		List.add(echo);
		Log.i("XXX", echo + " " + List.size());
		notifyeveryone();
	}

	public Echo getEchoes(int index) {
		return List.get(index);

	}

	// -----------------------------//

	public Collection<Echo> getEchoes() {
		Log.i("XXX", "List " + List);
		if (List == null) {
			Log.i("XXX", "Empty " + List.size());
			List = new ArrayList<Echo>();
			return List;
		}
		Log.i("XXX", "Null" + List.size());
		return List;

	}

	public void clear() {
		List = new ArrayList<Echo>();
		notifyeveryone();
	}

}
