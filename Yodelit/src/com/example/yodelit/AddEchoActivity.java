/**
 * Activity for adding "Echos" our equivalent of replies to a Yodel Thread. Users can view the Yodel and it's information and reply to it. 
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import java.util.ArrayList;
import java.util.Collection;

import com.example.yodelit.AddYodelActivity.AddThread;
import com.example.yodelit.HomeActivity.DeleteThread;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class AddEchoActivity extends Activity {

	
	/**Interface for Elastic Search**/
	private RubberClient YodelManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_echo);
		YodelManager = new ElasticSearchManager();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_echo, menu);
		return true;
	}
	
	/**
	 * Constructs a string based on the reply text and creates an Echo from it.
	 * It then appends this Echo to the relevant Yodel. Echo text cannot be empty or the
	 * submission fails with a toast reminder.
	 */
	public void submitEcho(View view){
		final EditText reply =  (EditText) findViewById(R.id.echoText);
		String rString = reply.getText().toString();
		final int yID = getIntent().getIntExtra("YID", -1);
		
		if (submissionCheck(rString)){
			Echo newEcho = new Echo(rString);
			Echo.setYID(yID);
			Yodel yodel = YodelitController.getYodelList().getYodel(yID);
			yodel.addEcho(newEcho);
			
			Thread thread = new DeleteThread(yID);
			thread.start();
			
			thread = new AddThread(yodel);
			thread.start();
			
			finish();
			return;
		} else {
			Toast.makeText(this, "Please type in your reply", Toast.LENGTH_SHORT).show();
			return;
		}
	}
	
	/**
	 * Verifies that an Echo submission is not empty.
	 */
	public boolean submissionCheck(String reply){
		if (reply.isEmpty()){
			return false;
		}
		return true;		
	}
	
	public void cancel(View view){
		finish();
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


