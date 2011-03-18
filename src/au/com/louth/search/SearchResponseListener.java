package au.com.louth.search;

import au.com.louth.model.APIResponse;

public interface SearchResponseListener {
	
	public void handleResponse(APIResponse response);

}
