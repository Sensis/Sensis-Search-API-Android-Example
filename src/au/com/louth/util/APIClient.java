package au.com.louth.util;

import java.net.URLEncoder;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import android.util.Log;
import au.com.louth.model.APIResponse;


public class APIClient {

	public static final String apiURL = "http://api.sensis.com.au";
	public static final String apiVersion = "20110229"; 
	
	/** INSERT YOUR KEY HERE **/
	/*********************************************************/
	public static final String apiKey = "INSERT YOUR KEY HERE"; 
	/*********************************************************/
	
	
	public static final String PARAM_QUERY="query=";
	public static final String PARAM_LOCATION="location=";
	public static final String PARAM_KEY="key=";
	
	public static final String SEARCH_URL = "%s/%s/search?key=%s&query=%s&location=%s";
	
	private static final ObjectMapper mapper = new ObjectMapper();
	private static final JsonClient jsonClient = new JsonClient();

	
	static {
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	public static APIResponse search(String query, String location){
		String url = String.format(SEARCH_URL, apiURL, apiVersion, apiKey, URLEncoder.encode(query), URLEncoder.encode(location));
		String json = jsonClient.getJSON(url);
		return jsonToAPIResponse(json);
	}
	
	public static APIResponse jsonToAPIResponse(String json){
		APIResponse response = null;
		
		try {
			response = mapper.readValue(json, APIResponse.class);
		} catch (Exception e) {
			Log.e("APIClient", "Exception: " + e.getMessage());
		} 
		
		return response;
	}
	
	
}
