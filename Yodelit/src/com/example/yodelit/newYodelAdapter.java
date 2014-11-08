package com.example.yodelit;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
        TextView user = (TextView) vi.findViewById(R.id.text);
        //Button upbutton = (Button) vi.findViewById(R.id.upButton);
       // Button downbutton = (Button) vi.findViewById(R.id.downButton);
        if (data != null){
        	Yodel yodel = data.get(position);
        	text.setText(yodel.getYodelText());
        	user.setText(yodel.getInfoText());
        }
        return vi;
    }
}
