package au.com.louth.search;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import au.com.louth.model.APIResponse;
import au.com.louth.util.APIClient;

public class SearchThread extends Thread {
	
	private String query;
	private String location;
	private ProgressDialog pd;
	private SearchResponseListener listener;
	
	private APIResponse response;
	
	public SearchThread(ProgressDialog pd, SearchResponseListener listener, String query, String location){
		this.pd = pd;
		this.listener = listener;
		this.query = query;
		this.location = location;
	}

	@Override
	public void run() {
		Log.d("BusinessList", "running thread");
		response = APIClient.search(query, location);	
		handler.sendEmptyMessage(0);
	}
	
	private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            listener.handleResponse(response);
            pd.dismiss();
        }
    };
}