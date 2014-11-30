/**
 * Object class for "Echo", our equivalent of replies. Contains text, author, Yodel id it belongs to, unique Echo id, date posted and number of up and down goats.
 * @author  Yodelit!
 * @version  3.0
 * @since  1.0
 */
package com.example.yodelit;


import java.util.ArrayList;
import android.util.Log;

// this was considered a God class
// it was moved into a new class from Echo.java as it 
// is an accessory to Echoes, rather than a core functionality
public class EchoVotes {
	
	// this was considered a God class within an extracted God class
	// it was not moved as the code is too little to place in another class
	// if this code were to be moved, there would have been no reason to 
	// create the EchoVotes class in the first place
	// additionally, this code is used in this class and is in a class
	// with items of a similar functionality
	public ArrayList<String> upgoatList = new ArrayList<String>(); //list of user id that has upvoted

	// this was considered a God class within an extracted God class
	// it was not moved as the code is too little to place in another class
	// if this code were to be moved, there would have been no reason to 
	// create the EchoVotes class in the first place 
	// additionally, this code is used in this class and is in a class
	// with items of a similar functionality
	private ArrayList<String> downgoatList = new ArrayList<String>();

	// this was considered a God class within an extracted God class
	// it was not moved as the code is too little to place in another class
	// if this code were to be moved, there would have been no reason to 
	// create the EchoVotes class in the first place
	// additionally, this code is used in this class and is in a class
	// with items of a similar functionality
	public ArrayList<String> getDowngoatList() {
		return downgoatList;
	}

	// this was considered a God class within an extracted God class
	// it was not moved as the code is too little to place in another class
	// if this code were to be moved, there would have been no reason to 
	// create the EchoVotes class in the first place
	// additionally, this code is used in this class and is in a class
	// with items of a similar functionality
	public void setDowngoatList(ArrayList<String> downgoatList) {
		this.downgoatList = downgoatList;
	}

	// this was considered a God class within an extracted God class
	// it was not moved as the code is too little to place in another class
	// if this code were to be moved, there would have been no reason to 
	// create the EchoVotes class in the first place
	// additionally, this code is used in this class and is in a class
	// with items of a similar functionality
	public void addUserDownVote() {
		Log.i("Gibberish", "I got here bro.");
		this.downgoatList.add(YodelitController.getActiveUser().getUname());
	}
	
	public void addUserUpVote(){
		Log.i("Gibberish", "I got here bro.");
		this.upgoatList.add(YodelitController.getActiveUser().getUname()); //TODO: NEEDS TO BE user id number!!
	}
}