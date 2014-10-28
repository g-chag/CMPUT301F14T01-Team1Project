package com.example.yodelit;

import java.util.ArrayList;

public class YodelList {
	public ArrayList<Yodel> List;
	
	public void addYodel(Yodel id) {
		List.add(id);
	}

	public Yodel getYodel(int index){
		return List.get(index);
		
	}

}
