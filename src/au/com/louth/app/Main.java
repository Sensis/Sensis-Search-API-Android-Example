package au.com.louth.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import au.com.louth.R;

public class Main extends Activity implements OnClickListener {
	
	public static final String KEY_QUERY = "query";
	public static final String KEY_LOCATION = "location";
	
	private EditText queryText;
	private EditText locationText;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        queryText = (EditText)findViewById(R.id.edit_query);
        locationText = (EditText)findViewById(R.id.edit_location);
        
        Button button = (Button)findViewById(R.id.button_search);
        button.setOnClickListener(this);
    }
    
	@Override
	public void onClick(View v) {
		int id = v.getId();
		
		switch(id){
			case R.id.button_search:{
				Intent intent = new Intent(this, BusinessList.class);
				intent.putExtra(KEY_QUERY, queryText.getText().toString());
				intent.putExtra(KEY_LOCATION, locationText.getText().toString());
				startActivity(intent);
				break;
			}
		}
	}
	
	
}
