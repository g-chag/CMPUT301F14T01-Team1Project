package com.example.yodelit;

import java.util.List;

public interface StretchyClient {

	public List<Yodel> searchYodels(String searchString, String field);
	public Yodel getYodel(int id);
	public void addYodel(Yodel Yodel);
	public void deleteYodel(int yodelId);
}
