/**
 * Class for storing a list of Yodels. User can add Yodels to the list, as well as notify updated systems
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.util.ArrayList;
import java.util.Collection;

public class YodelList {
	
	// this line of code was considered a God class
	// was not extracted as it is only a line of code
	public ArrayList<Yodel> List;
	
	protected transient ArrayList<Listener> listeners;

	// this method up till and including addListener were
	// considered God classes
	// were not extracted as they make up the bulk of the class
	public YodelList() {
		List = new ArrayList<Yodel>();
		listeners = new ArrayList<Listener>();

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

	public void addYodel(Yodel yodel) {
		//Log.i("XXX", yodel.toString() + " " + List.size());
		List.add(yodel);
		//Log.i("XXX", yodel + " " + List.size());
		notifyeveryone();
	}
	
	public boolean addAll(ArrayList<Yodel> yodels){
		return List.addAll(yodels);
	}

	public Yodel getYodel(int index) {
		return List.get(index);

	}

	// -----------------------------//

	public Collection<Yodel> getYodels() {
		//Log.i("XXX", "List " + List);
		if (List == null) {
			//Log.i("XXX", "Empty " + List.size());
			List = new ArrayList<Yodel>();
			return List;
		}
		//Log.i("XXX", "Null" + List.size());
		return List;

	}

	public void clear() {
		List = new ArrayList<Yodel>();
		notifyeveryone();
	}

}
