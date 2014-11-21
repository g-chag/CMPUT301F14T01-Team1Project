package com.example.yodelit;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

/**
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
**/
public class ElasticSearchManager {
	
	
	private static final String SEARCH_URL = ""; //= "http://cmput301.softwareprocess.es:8080/search";
	private static final String RESOURCE_URL = ""; //= "http://cmput301.softwareprocess.es:8080/";
	private static final String TAG = ""; //= "YodelSearch";
	
	/** NEED TO IMPORT GSON PACKAGE TO OUR FILE PATH
	private Gson gson;
	**/
	public ElasticSearchManager() {
		super();
		//gson = new Gson();
	}
	
	public Yodel getYodel(int id) {

		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(RESOURCE_URL + id);

		HttpResponse response;

		try {
			response = httpClient.execute(httpGet);
			/**Methods to be defined elsewhere**/
			//SearchHit<Yodel> sr = parseYodelHit(response);
			//return sr.getSource();

		} catch (Exception e) {
			e.printStackTrace();
		} 

		return null;
	}
	
	/**
	 * Adds a new yodel, needs to be modified to use the new ID provided by elastic search
	 */
	public void addYodel(Yodel yodel) {
		HttpClient httpClient = new DefaultHttpClient();

		try {
			HttpPost addRequest = new HttpPost(RESOURCE_URL + yodel.getYid());

			//StringEntity stringEntity = new StringEntity(gson.toJson(yodel));
			//addRequest.setEntity(stringEntity);
			addRequest.setHeader("Accept", "application/json");

			HttpResponse response = httpClient.execute(addRequest);
			String status = response.getStatusLine().toString();
			Log.i(TAG, status);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes the yodel with the specified id
	 */
	public void deleteMovie(int movieId) {
		HttpClient httpClient = new DefaultHttpClient();

		try {
			HttpDelete deleteRequest = new HttpDelete(RESOURCE_URL + movieId);
			deleteRequest.setHeader("Accept", "application/json");

			HttpResponse response = httpClient.execute(deleteRequest);
			String status = response.getStatusLine().toString();
			Log.i(TAG, status);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
