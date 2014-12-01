/**
 * Creates custom adapter for Echos in YodelMainActivity. Allows buttons for up and down goating. Has text views for Echo text, user and date (still needs to be implemented).
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.util.ArrayList;
import java.util.Collection;

import com.example.yodelit.newYodelAdapter.AddThread;
import com.example.yodelit.newYodelAdapter.DeleteThread;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//FOUND AT http://stackoverflow.com/questions/15832335/android-custom-row-item-for-listview 11/08/14 
@SuppressLint("InflateParams") public class newAdapter extends BaseAdapter{
	
    Context context;
    ArrayList<Echo> data;
    private LayoutInflater inflater = null;
	/**Interface for Elastic Search**/
	private RubberClient YodelManager;

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
        TextView date = (TextView) vi.findViewById(R.id.dateText);
        final TextView total = (TextView) vi.findViewById(R.id.totalText);
        
        Button upgoat = (Button) vi.findViewById(R.id.upB);
        Button downgoat = (Button) vi.findViewById(R.id.downB);
        
        YodelManager = new ElasticSearchManager();

        if (data != null){
        	Echo echo = data.get(position);
        	text.setText(echo.getText());
        	user.setText(echo.getAuthor());
        	date.setText(echo.getDate());
        	total.setText("" + (echo.getUpgoats()-echo.getDowngoats()) );
        }
        
        /**
	 	* Attempts an upgoat.
	 	*/
        //TODO: Fix this so it upgoats properly.
        upgoat.setOnClickListener(new OnClickListener() {
			Echo echo = data.get(position);
			User theUser = YodelitController.getActiveUser();
			String activeUser = theUser.tryName();
			@Override
			public void onClick(View v) {
				try {
						int id = echo.getYID();
						YodelitController.getYodelList().getYodel(id).getEchoList().get(position).setUpgoats(echo.getUpgoats() + 1);
						total.setText("" + ((echo.getUpgoats()-echo.getDowngoats())));
						
			        	Thread thread = new DeleteThread(echo.getYID());
						thread.start();
						Yodel yodel = YodelitController.getYodelList().getYodel(echo.getYID());
						thread = new AddThread(yodel);
						thread.start();
				}
				catch (Exception e) {
					Log.e("Debug","Upgoat failed.");
				}
			}
		});
        
        /**
	 	* Attempts a downgoat.
	 	*/
        //TODO: Fix this so it downgoats properly.
        downgoat.setOnClickListener(new OnClickListener() {
			Echo echo = data.get(position);
			User theUser = YodelitController.getActiveUser();
			String activeUser = theUser.tryName();
			@Override
			public void onClick(View v) {
				try {
					int id = echo.getYID();
					YodelitController.getYodelList().getYodel(id).getEchoList().get(position).setDowngoats(echo.getDowngoats() + 1);
					total.setText("" + ((echo.getUpgoats()-echo.getDowngoats())));
					
		        	Thread thread = new DeleteThread(echo.getYID());
					thread.start();
					
					Yodel yodel = YodelitController.getYodelList().getYodel(echo.getYID());
					
					thread = new AddThread(yodel);
					thread.start();
				}
				catch (Exception e) {
					Log.e("Debug","Downgoat failed.");
				}
			}
		});
        
        return vi;
    }
    class DeleteThread extends Thread {
		public int yID;

		public DeleteThread(int movieId) {
			this.yID = yID;
		}

		@Override
		public void run() {
			YodelManager.deleteYodel(yID);
			Collection<Yodel> yodels = YodelitController.getYodelList().getYodels();
			ArrayList<Yodel> yodelList = new ArrayList<Yodel>(yodels);
			// Remove movie from local list
			for (int i = 0; i < yodelList.size(); i++) {
				Yodel y = yodelList.get(i);
				if (y.getYid()== yID) {
					yodelList.remove(y);
					break;
				}
			}
		}
	}
    
    
    /**Used for calling ElasticAdding**/
	class AddThread extends Thread {
		private Yodel yodel;

		public AddThread(Yodel yodel) {
			this.yodel = yodel;
		}

		@Override
		public void run() {
			YodelManager.addYodel(yodel);
			
			// Give some time to get updated info
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
