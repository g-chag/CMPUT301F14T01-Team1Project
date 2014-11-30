package com.example.yodelit;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.example.yodelit.data.ElasticSearchHit;
import com.example.yodelit.data.Hits;
import com.example.yodelit.data.SearchResponse;
import com.example.yodelit.data.SimpleSearchCommand;

public class ElasticSearchManager implements RubberClient {
	
	private static final String SEARCH_URL = "http://cmput301.softwareprocess.es:8080/team1/_search";
	private static final String RESOURCE_URL = "http://cmput301.softwareprocess.es:8080/team1/";
	private static final String TAG = "YodelSearch";
	
	// this variable was considered a God class
	// was not extracted as it is only a line of code
	// and is used in the class
	private Gson gson;
	
	public ElasticSearchManager() {
		gson = new Gson();
	}
	
	/**
	 * Input: Old Yodel ID
	 * Result: Yodel ID = Elastic Search ID for that Yodel
	 */
	public void setNewID(Yodel theYodel) {

		//Takes in the old Yodel ID
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(RESOURCE_URL + theYodel.getYid());

		HttpResponse response;

		try {
			response = httpClient.execute(httpGet);		
			ElasticSearchHit<Yodel> sr = parseYodelHit(response);
			String elasticID = sr.get_id();
			
			//Converts string ID to integer
			theYodel.setYid( Integer.parseInt(elasticID) );

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public Yodel getYodel(int id) {

		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(RESOURCE_URL + id);

		HttpResponse response;

		try {
			response = httpClient.execute(httpGet);		
			ElasticSearchHit<Yodel> sr = parseYodelHit(response);
			return sr.getSource();

		} catch (Exception e) {
			e.printStackTrace();
		} 

		return null;
	}

	/**
	 * Get Yodels with the specified search string. If the search does not
	 * specify fields, it searches on all the fields.
	 */
	public List<Yodel> searchYodels(String searchString, String field) {
		List<Yodel> result = new ArrayList<Yodel>();

		if (searchString == null || "".equals(searchString)) {
			searchString = "*";
		}
		
		HttpClient httpClient = new DefaultHttpClient();
		
		try {
			HttpPost searchRequest = createSearchRequest(searchString, field);
			
			HttpResponse response = httpClient.execute(searchRequest);
			
			String status = response.getStatusLine().toString();
			Log.i(TAG, status);
			
			SearchResponse<Yodel> esResponse = parseSearchResponse(response);
			Hits<Yodel> hits = esResponse.getHits();
			
			if (hits != null) {
				if (hits.getHits() != null) {
					for (ElasticSearchHit<Yodel> sesr : hits.getHits()) {
						result.add(sesr.getSource());
						//Log.i(TAG, result.add(sesr.getSource() ));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return result;
	}
	
	/**
	 * Adds a new yodel, needs to be modified to use the new ID provided by elastic search
	 */
	public void addYodel(Yodel yodel) {
		HttpClient httpClient = new DefaultHttpClient();

		try {
			HttpPost addRequest = new HttpPost(RESOURCE_URL + yodel.getYid());

			StringEntity stringEntity = new StringEntity(gson.toJson(yodel));
			addRequest.setEntity(stringEntity);
			addRequest.setHeader("Accept", "application/json");

			HttpResponse response = httpClient.execute(addRequest);
			String status = response.getStatusLine().toString();
			Log.i(TAG + "addYodel", status);
			
			//Now that we've added the new Yodel, we can set it's ID to the new one
			setNewID(yodel);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes the yodel with the specified id
	 */
	public void deleteYodel(int yodelId) {
		HttpClient httpClient = new DefaultHttpClient();

		try {
			HttpDelete deleteRequest = new HttpDelete(RESOURCE_URL + yodelId);
			deleteRequest.setHeader("Accept", "application/json");

			HttpResponse response = httpClient.execute(deleteRequest);
			String status = response.getStatusLine().toString();
			Log.i(TAG, status);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates a search request from a search string and a field
	 */
	private HttpPost createSearchRequest(String searchString, String field)	throws UnsupportedEncodingException {
		
		HttpPost searchRequest = new HttpPost(SEARCH_URL);

		String[] fields = null;
		if (field != null) {
			fields = new String[1];
			fields[0] = field;
		}
		
		SimpleSearchCommand command = new SimpleSearchCommand(searchString,	fields);
		
		String query = command.getJsonCommand();
		Log.i(TAG, "Json command: " + query);

		StringEntity stringEntity;
		stringEntity = new StringEntity(query);

		searchRequest.setHeader("Accept", "application/json");
		searchRequest.setEntity(stringEntity);

		return searchRequest;
	}
	
	// the next two methods were considered to be God classes
	// they were not extracted, as their functionality is the same as
	// the other methods in ElasticSearchManager.java
	// additionally, we would like to keep everything regarding Elastic Search
	// in one file
	private ElasticSearchHit<Yodel> parseYodelHit(HttpResponse response) {
		
		try {
			String json = getEntityContent(response);
			Type searchHitType = new TypeToken<ElasticSearchHit<Yodel>>() {}.getType();
			
			ElasticSearchHit<Yodel> sr = gson.fromJson(json, searchHitType);
			return sr;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Parses the response of a search
	 */
	private SearchResponse<Yodel> parseSearchResponse(HttpResponse response) throws IOException {
		String json;
		json = getEntityContent(response);

		Type searchResponseType = new TypeToken<SearchResponse<Yodel>>() {
		}.getType();
		
		SearchResponse<Yodel> esResponse = gson.fromJson(json, searchResponseType);

		return esResponse;
	}

	
	/**
	 * Gets content from an HTTP response
	 */
	public String getEntityContent(HttpResponse response) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		return result.toString();
	}

}
