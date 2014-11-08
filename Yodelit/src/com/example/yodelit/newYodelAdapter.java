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

public class newYodelAdapter extends BaseAdapter{
	Context context;
    ArrayList<Yodel> data;
    private LayoutInflater inflater = null;

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
        	Yodel yodel = data.get(position);
        	text.setText(yodel.getYodelText());
        	user.setText(yodel.getAuthor());
        	//http://stackoverflow.com/questions/3994315/integer-value-in-textview
        	upcount.setText("" + yodel.getUpgoats());
        	downcount.setText("" + yodel.getDowngoats());
        }
        return vi;
    }
}
