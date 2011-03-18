package au.com.louth.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.util.Log;

public class JsonClient {
	
	private static HttpClient httpClient = new DefaultHttpClient();
	private static HttpContext localContext = new BasicHttpContext();
	
	public String getJSON(String url) {
		String json = null;
		
		try{
			HttpGet httpGet = new HttpGet(url);
			HttpResponse response = httpClient.execute(httpGet, localContext);
			InputStream is = response.getEntity().getContent();
			json = IOUtils.inputStreamToString(is);
		}
		catch (IOException e){
			Log.e("JsonClient", "IOException: " + e.getMessage());
		}
		
		return json;
	}
}
