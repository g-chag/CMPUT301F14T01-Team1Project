/**
 * Custom adapter for Yodels in HomeActivity. Allows buttons for up and down goating. Has text views for Yodel text, user and date (still needs to be implemented).
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */


package com.example.yodelit;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("InflateParams") 
public class newYodelAdapter extends BaseAdapter{
	Context context;
    ArrayList<Yodel> data;
    private LayoutInflater inflater = null;

    /**
 	* Creates a new Yodel Adapter.
 	*/
    public newYodelAdapter(Context context, ArrayList<Yodel> arrayList){
        this.context = context;
        this.data = arrayList;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
 	* Get item count..
 	*/
    public int getCount() {
        return data.size();
    }

    /**
 	* Get item based on its position.
 	*/
    public Object getItem(int position) {
        return data.get(position);
    }
    /**
 	* Get item position, based on its position.
 	*/
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.row, null);
        
        vi.setSelected(true);
        TextView text = (TextView) vi.findViewById(R.id.Header);
        TextView user = (TextView) vi.findViewById(R.id.userText);
        final TextView total = (TextView) vi.findViewById(R.id.totalText);
        
        Button upgoat = (Button) vi.findViewById(R.id.upB);
        Button downgoat = (Button) vi.findViewById(R.id.downB);
        if (data != null){
        	Yodel yodel = data.get(position);
        	text.setText(yodel.getYodelText());
        	//http://stackoverflow.com/questions/3994315/integer-value-in-textview
        	total.setText("" + (yodel.getUpgoats() - yodel.getDowngoats()));
        	user.setText(yodel.getAuthor());
        	
        }
        
        /**
	 	* Attempts an upgoat.
	 	*/
        upgoat.setOnClickListener(new OnClickListener() {
			Yodel yodel = data.get(position);
			User theUser = YodelitController.getActiveUser();
			String activeUser = tryName(theUser);
			@Override
			public void onClick(View v) {
				if ( (yodel.getAuthor() != activeUser) && (yodel.getUsersUpVote().contains(activeUser) == false) ){
					YodelitController.yodelList.getYodel(position).setUpgoats((yodel.getUpgoats())+1);
					YodelitController.yodelList.getYodel(position).addUserUpVote();
		        	total.setText("" + (yodel.getUpgoats() - yodel.getDowngoats()));	
				} else if (yodel.getAuthor() == activeUser) {
					Toast.makeText(context, "Cannot upgoat own Yodel!", Toast.LENGTH_SHORT).show();
				} else if (yodel.getUsersUpVote().contains(activeUser) == true){
					Toast.makeText(context, "Already voted!!", Toast.LENGTH_SHORT).show();
				}

			}
		});
        /**
	 	* Attempts an downgoat.
	 	*/
        downgoat.setOnClickListener(new OnClickListener() {
			Yodel yodel = data.get(position);
			User theUser = YodelitController.getActiveUser();
			String activeUser = tryName(theUser);
			@Override
			public void onClick(View v) {
				if ( (yodel.getAuthor() != activeUser) && (yodel.getUsersDownVote().contains(activeUser) == false) ){
					YodelitController.yodelList.getYodel(position).setDowngoats((yodel.getDowngoats())+1);
					YodelitController.yodelList.getYodel(position).addUserDownVote();
		        	total.setText("" + (yodel.getUpgoats() - yodel.getDowngoats()));	
				} else if (yodel.getAuthor() == activeUser) {
					Toast.makeText(context, "Cannot downgoat own Yodel!", Toast.LENGTH_SHORT).show();
				} else if (yodel.getUsersDownVote().contains(activeUser) == true){
					Toast.makeText(context, "Already voted!!", Toast.LENGTH_SHORT).show();
				}
			}
		});

        return vi;
        
    }
    //TODO: This method shouldn't be necessary. Need to fix app so it doesn't throw errors.
    public String tryName(User tempUser) {
    	String tempUserString;
    	try {
    		tempUserString = tempUser.getUname();
    	}
    	catch (Exception e) {
    		tempUserString = " ";
    	}
    	return tempUserString;
    }
}
