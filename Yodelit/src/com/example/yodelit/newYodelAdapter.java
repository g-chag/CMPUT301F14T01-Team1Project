/**
 * Custom adapter for Yodels in HomeActivity. Allows buttons for up and down goating. Has text views for Yodel text, user and date (still needs to be implemented).
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */


package com.example.yodelit;

import java.util.ArrayList;

import android.R.color;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class newYodelAdapter extends BaseAdapter{
	Context context;
    ArrayList<Yodel> data;
    private LayoutInflater inflater = null;

    //creation of a new adapter
    public newYodelAdapter(Context context, ArrayList<Yodel> arrayList) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = arrayList;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.row, null);
        
        vi.setSelected(true);
        TextView text = (TextView) vi.findViewById(R.id.Header);
        TextView user = (TextView) vi.findViewById(R.id.userText);
        TextView date = (TextView) vi.findViewById(R.id.dateText);
        TextView total = (TextView) vi.findViewById(R.id.totalText);
        final TextView upcount = (TextView) vi.findViewById(R.id.upText);
        final TextView downcount = (TextView) vi.findViewById(R.id.downText);
        
        Button upgoat = (Button) vi.findViewById(R.id.upB);
        Button downgoat = (Button) vi.findViewById(R.id.downB);
        if (data != null){
        	Yodel yodel = data.get(position);
        	text.setText(yodel.getYodelText());
        	//http://stackoverflow.com/questions/3994315/integer-value-in-textview
        	int plus = yodel.getUpgoats();
        	upcount.setText("" + plus);
        	int minus = yodel.getDowngoats();
        	downcount.setText("" + minus);
        	user.setText(yodel.getAuthor());
        	
        }
        
        //upgoating
        upgoat.setOnClickListener(new OnClickListener() {
			Yodel yodel = data.get(position);
			@Override
			public void onClick(View v) {
				int hold = yodel.getUpgoats();
				hold = hold + 1;
				YodelitController.yodelList.getYodel(position).setUpgoats(hold);
				upcount.setText("" + yodel.getUpgoats());

			}
		});
        //downgoating
        downgoat.setOnClickListener(new OnClickListener() {
			Yodel yodel = data.get(position);
			@Override
			public void onClick(View v) {
				int hold = yodel.getDowngoats();
				hold = hold + 1;
				YodelitController.yodelList.getYodel(position).setDowngoats(hold);
		    	downcount.setText("" + yodel.getDowngoats());	
			}
		});

        return vi;
        
    }
}
