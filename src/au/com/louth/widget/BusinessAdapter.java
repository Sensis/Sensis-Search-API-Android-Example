package au.com.louth.widget;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import au.com.louth.R;
import au.com.louth.model.Business;


public class BusinessAdapter extends ArrayAdapter<Business> {
	
	private Context context;
	
	public BusinessAdapter(Context ctx, List<Business> projects){
		super(ctx, R.layout.business_row, projects);
		this.context = ctx;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View row = convertView;
		
		if (row == null) {
			LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row=inflater.inflate(R.layout.business_row, parent, false);
		}
		
		TextView name = (TextView)row.findViewById(R.id.row_name);

		Business business = getItem(position);
		
		name.setText(business.getName());

		return row;
	}

}
