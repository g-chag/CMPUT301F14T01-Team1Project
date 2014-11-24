/**
 * Creates custom adapter for Echos in YodelMainActivity. Allows buttons for up and down goating. Has text views for Echo text, user and date (still needs to be implemented).
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

//FOUND AT http://stackoverflow.com/questions/15832335/android-custom-row-item-for-listview 11/08/14 
@SuppressLint("InflateParams") public class newAdapter extends BaseAdapter{
	
    Context context;
    ArrayList<Echo> data;
    private LayoutInflater inflater = null;

    public newAdapter(Context context, ArrayList<Echo> arrayList) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = arrayList;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
 	* Gets Echo count.
 	*/
    @Override
    public int getCount() {
        return data.size();
    }

    /**
 	* Gets item based on position.
 	*/
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    /**
 	* Gets item's position based on its position.
 	*/
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.row, null);
        
        TextView text = (TextView) vi.findViewById(R.id.Header);
        TextView user = (TextView) vi.findViewById(R.id.userText);
        //TextView date = (TextView) vi.findViewById(R.id.dateText);
        final TextView total = (TextView) vi.findViewById(R.id.totalText);
        //final TextView upcount = (TextView) vi.findViewById(R.id.upText);
        //final TextView downcount = (TextView) vi.findViewById(R.id.downText);
        
        Button upgoat = (Button) vi.findViewById(R.id.upB);
        Button downgoat = (Button) vi.findViewById(R.id.downB);
        
        if (data != null){
        	Echo echo = data.get(position);
        	text.setText(echo.getText());
        	user.setText(echo.getAuthor());
        	//Need to set date
        	//date.setText(echo.getDate().toString());
        	//http://stackoverflow.com/questions/3994315/integer-value-in-textview
        	total.setText("" + ((echo.getUpgoats()-echo.getDowngoats())+1));
        }
        
        /**
	 	* Attempts an upgoat.
	 	*/
        upgoat.setOnClickListener(new OnClickListener() {
			Echo echo = data.get(position);
			@Override
			public void onClick(View v) {
				YodelitController.yodelList.getYodel(position).getEchoList().get(position).setUpgoats((echo.getUpgoats())+1);
				total.setText("" + ((echo.getUpgoats()-echo.getDowngoats())+1));
			}
		});
        
        /**
	 	* Attempts a downgoat.
	 	*/
        downgoat.setOnClickListener(new OnClickListener() {
			Echo echo = data.get(position);
			@Override
			public void onClick(View v) {
				YodelitController.yodelList.getYodel(position).getEchoList().get(position).setDowngoats((echo.getDowngoats())+1);
				total.setText("" + ((echo.getUpgoats()-echo.getDowngoats())+1));
			}
		});
        
        
        return vi;
    }

}
