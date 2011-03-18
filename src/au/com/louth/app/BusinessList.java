package au.com.louth.app;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;
import au.com.louth.R;
import au.com.louth.model.APIResponse;
import au.com.louth.model.Business;
import au.com.louth.search.SearchResponseListener;
import au.com.louth.search.SearchThread;
import au.com.louth.widget.BusinessAdapter;

public class BusinessList extends Activity implements SearchResponseListener {
	
	private SearchThread searchThread;
	private ListView businessesList;  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	    setContentView(R.layout.business_list);

	    businessesList = (ListView)findViewById(R.id.list_businesses);

	    ProgressDialog pd = ProgressDialog.show(this, null, "Searching...", true, false);
	    
	    Bundle bundle = getIntent().getExtras();
	    String query = bundle.getString(Main.KEY_QUERY);
	    String location = bundle.getString(Main.KEY_LOCATION);
	    
	    searchThread = new SearchThread(pd, this, query, location);
	    searchThread.start();
	}
	
	@Override
	public void handleResponse(APIResponse response){
	    List<Business> businesses = response.getBusinesses();
	    BusinessAdapter adapter = new BusinessAdapter(this, businesses);
	    businessesList.setAdapter(adapter);
	}

}
