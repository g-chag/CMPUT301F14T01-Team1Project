/**
 * Class for storing a list of Echoes.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.util.ArrayList;
import java.util.Collection;

import android.util.Log;


public class EchoList {
	
	// this line of code was considered a God class
	// was not extracted into a new class, as it is only a line of code
	private ArrayList<Echo> List;
	
	protected transient ArrayList<Listener> listeners;

	public EchoList() {
		List = new ArrayList<Echo>();
		listeners = new ArrayList<Listener>();

	}

	// this method up till and including addListener where considered
	// God classes
	// were not extracted as they are similar in functionality to the
	// other methods
	/**
 	* Adds a list of Echos to an EchoList.
 	*/
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
	/**
 	* Adds an Echo to an EchoList.
 	*/
	public void addEcho(Echo echo) {
		Log.i("XXX", echo.toString() + " " + List.size());
		List.add(echo);
		Log.i("XXX", echo + " " + List.size());
		notifyeveryone();
	}
	/**
 	* Returns an Echo at the specified index.
 	*/
	public Echo getEchoes(int index) {
		return List.get(index);

	}

	// -----------------------------//
	
	/**
 	* Returns all Echo's in an Echo List.
 	*/
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
