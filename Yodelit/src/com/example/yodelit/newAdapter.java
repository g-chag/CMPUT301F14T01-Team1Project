/**
 * Creates custom adapter for Echos in YodelMainActivity. 
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
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

//FOUND AT http://stackoverflow.com/questions/15832335/android-custom-row-item-for-listview 11/08/14 
public class newAdapter extends BaseAdapter{
	
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

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.row, null);
        
        TextView text = (TextView) vi.findViewById(R.id.Header);
        TextView user = (TextView) vi.findViewById(R.id.userText);
        TextView date = (TextView) vi.findViewById(R.id.dateText);
        TextView upcount = (TextView) vi.findViewById(R.id.upText);
        TextView downcount = (TextView) vi.findViewById(R.id.downText);
        ImageButton upbutton = (ImageButton) vi.findViewById(R.id.upButton);
        upbutton.setBackgroundColor(color.white);
        ImageButton downbutton = (ImageButton) vi.findViewById(R.id.downButton);
        downbutton.setBackgroundColor(color.white);
        
        
        if (data != null){
        	Echo echo = data.get(position);
        	text.setText(echo.getText());
        	user.setText(echo.getAuthor());
        	//Need to set date
        	//date.setText(echo.getDate().toString());
        	//http://stackoverflow.com/questions/3994315/integer-value-in-textview
        	upcount.setText("" + echo.getUpgoats());
        	downcount.setText("" + echo.getDowngoats());
        	
        }
        return vi;
    }

}
