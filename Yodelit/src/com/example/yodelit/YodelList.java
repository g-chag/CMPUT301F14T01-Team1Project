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
	/**Creates a new list and listener**/
	public YodelList() {
		List = new ArrayList<Yodel>();
		listeners = new ArrayList<Listener>();
	}

	// ------Listener methods------//

	/**Returns listeners**/
	private ArrayList<Listener> getListeners() {
		if (listeners == null) {
			listeners = new ArrayList<Listener>();
		}
		return listeners;
	}

	/**Updates listeners**/
	private void notifyeveryone() {
		for (Listener listener : listeners) {
			listener.update();
		}

	}

	/**Adds listeners**/
	public void addListener(Listener l) {
		getListeners().add(l);
	}

	/**Removes listeners**/
	public void removeListener(Listener l) {
		getListeners().remove(l);
	}

	// ------------------------------//

	// ------YodelList Methods-------//

	/**Adds Yodels to the list and updates listeners**/
	public void addYodel(Yodel yodel) {
		List.add(yodel);
		notifyeveryone();
	}
	
	/**Adds all Yodels to the list and updates listeners**/
	public boolean addAll(ArrayList<Yodel> yodels){
		return List.addAll(yodels);
	}

	/**Retrives Yodels from the list based on index values**/
	public Yodel getYodel(int index) {
		return List.get(index);
	}

	// -----------------------------//

	/**Returns list of Yodels**/
	public Collection<Yodel> getYodels() {
		if (List == null) {
			List = new ArrayList<Yodel>();
			return List;
		}
		return List;

	}

	/**Creates a new list of Yodels and updates the listener**/
	public void clear() {
		List = new ArrayList<Yodel>();
		notifyeveryone();
	}

}
