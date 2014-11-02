package com.example.yodelit;

import java.util.ArrayList;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

//Note from Aedan - This file seems to be redundant, and I'm starting to think we should
//implement these methods within our YodelList class. I will leave this for now until a solution is reached.

public class YodelViewAdapter extends YodelList implements Runnable {
	private LayoutInflater inflater;
	private Context context;
	public YodelViewAdapter(Context context, ArrayList<Yodel> list) {
	super(); 
	this.context = context; //Prevents self-assignment and makes context accessible
	inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //Service required for Inflation
	}
	
	Handler GuiUpdater = new Handler(Looper.getMainLooper()); //This helps the GUI stay updated. See comments below.
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			view = inflater.inflate(R.layout.activity_yodel_main, parent, false); //False, ensures it is the root of the inflated XML that gets returned.
		}
		
		return view;
	}
	
	
	//Need to be methods in here that actually edit the list, but it feels like YodelList contains those.
	
	
	//These two methods may be redundant with YodelList.notifyeveryone() but may fix edge cases.
	public void update() {
		GuiUpdater.post(this); //This should constantly keep the GUI updated. 
	}

	@Override
	public void run() {
		this.notify(); //Necessary method for GUI updater. 
	}
}