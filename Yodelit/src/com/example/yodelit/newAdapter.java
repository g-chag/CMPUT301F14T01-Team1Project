package com.example.yodelit;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

//FOUND AT http://stackoverflow.com/questions/15832335/android-custom-row-item-for-listview
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
        TextView user = (TextView) vi.findViewById(R.id.text);
        //Button upbutton = (Button) vi.findViewById(R.id.upButton);
       // Button downbutton = (Button) vi.findViewById(R.id.downButton);
        if (data != null){
        	Echo echo = data.get(position);
        	text.setText(echo.getText());
        	user.setText(echo.getAuthor());
        }
        return vi;
    }

}
