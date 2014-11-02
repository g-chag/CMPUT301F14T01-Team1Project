package com.example.yodelit;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

//import org.apache.commons.io.FileUtils;

import android.content.Context;
import android.util.Log;

//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;

//READ ME:
//I've basically commented out everything that doesn't work or causes errors. This is WIP.
//Need to add appropriate files for the commented out imports.

@SuppressWarnings("unused")
public enum IoController {
	INSTANCE;
	private static final String ToDoItemFile = "appfile.sav";
	
	//Collection<Yodel> theYodels = YodelList.getYodels();
	//private static Gson gson = new Gson();
    private static Context theContext;
	
	
	public void loadContext(Context ctx) {
    	theContext = ctx;
    }
	
	public void saveItems() {
    	try {
    		//FileUtils.write((new File(theContext.getFilesDir(),YodelFile)), gson.toJson(theYodels));
		} catch (Exception e) {
			Log.i("notes", "Error saving To-Do List");
			e.printStackTrace();
		}
    }	  
	
	public void loadList() {
    	
		try {
			//Non-working Lines are commented out
			
			//String fileContent = FileUtils.readFileToString(new File(theContext.getFilesDir(),YodelFile));
			//Type collectionType = new TypeToken<Collection<Yodel>>() {}.getType(); //API to get a generic type for feeding to GSON
			//YodelList.clear();
			//theYodels.addAll((Collection<? extends Yodel>) gson.fromJson(fileContent, (java.lang.reflect.Type) collectionType));

		} catch (Exception e) {
			Log.i("notes", "Error loading Yodels");
			e.printStackTrace();
		}
		
    }
}
