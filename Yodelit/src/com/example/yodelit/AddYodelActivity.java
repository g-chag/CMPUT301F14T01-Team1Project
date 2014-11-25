/**
 * Activity for adding "Yodels" our equivalent of forum questions.
 * 
 * @author Yodelit!
 * @version 3.0
 * @since 1.0
 */

package com.example.yodelit;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddYodelActivity extends Activity implements OnClickListener {

	//code below from: http://www.itcuties.com/android/pick-image-from-gallery/
	private static final int LOAD_IMAGE_RESULTS = 1;
	private static Button button;
	private static ImageView image;
	private static Bitmap bitmap = null;
	//code use ends
	
	/**Interface for Elastic Search**/
	private RubberClient YodelManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_yodel);
		
		//code below from: http://www.itcuties.com/android/pick-image-from-gallery/
		button = (Button)findViewById(R.id.addPhotoButton);
		image = (ImageView)findViewById(R.id.photoView);
		button.setOnClickListener(this);
		//code use ends
		
		YodelManager = new ElasticSearchManager();
	}
	
	/**Thread that closes ElasticAdding after finished**/
	private Runnable doFinishAdd = new Runnable() {
		public void run() {
			finish();
		}
	};
	
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
			
			runOnUiThread(doFinishAdd);
		}
	}
	
	
	/**
	 * Inflate the menu; this adds items to the action bar if it is present.
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_yodel, menu);
		return true;
	}
	
	/**
	 * 	Gets into from screen. Adds newly created Yodel to controller.
	 */
	public void submitYodel(View view){
		final EditText question =  (EditText) findViewById(R.id.yodelText);
		final EditText add =  (EditText) findViewById(R.id.infoText);
		String qString = question.getText().toString();
		String addString = add.getText().toString();
		
		if (submissionCheck(qString, addString)){
			Yodel newYodel = new Yodel(qString, addString);
			newYodel.setBitmap(bitmap);
			YodelitController.addYodel(newYodel);
			
			/**This code attempts to add to Elastic Search. 
			 * It is currently crashing the APP when uncommented.**/
			//Thread thread = new AddThread(newYodel);
			//thread.start();
			/**-------------------------------------------------------------------**/
			
			finish();
			return;
		} else {
			Toast.makeText(this, "Please type in your question", Toast.LENGTH_SHORT).show();
		}
	}
	
	/**
	 * 	Ensures that a Yodel is not empty.
	 */
	public boolean submissionCheck(String question, String add){
		if (question.isEmpty()){
			return false;
		}
		return true;		
	}
	
	public void cancel(View view){
		finish();
	}
	
	//code below from: http://www.itcuties.com/android/pick-image-from-gallery/
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == LOAD_IMAGE_RESULTS && resultCode == RESULT_OK && data != null) {
			Uri pickedImage = data.getData();
			String[] path = {MediaStore.Images.Media.DATA };
			Cursor cursor = getContentResolver().query(pickedImage, path, null, null, null);
			cursor.moveToFirst();
			String imagePath = cursor.getString(cursor.getColumnIndex(path[0]));
            //Cursor cursor = getContentResolver().query(pickedImage, filePath, null, null, null);
            //cursor.moveToFirst();
            //String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));
			//BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
			//int height = 300; int width = 300;
			//int heightRatio = (int)Math.ceil(bmpFactoryOptions.outHeight/(float)height);
	       // int widthRatio = (int)Math.ceil(bmpFactoryOptions.outWidth/(float)width);
	       // bmpFactoryOptions.inSampleSize = widthRatio; 
	       // bmpFactoryOptions.inSampleSize = heightRatio;
	        Bitmap bm = BitmapFactory.decodeFile(imagePath);
	        bitmap = Bitmap.createScaledBitmap(bm,(int)(bm.getWidth()*0.35), (int)(bm.getHeight()*0.35), true);
	        image.setImageBitmap(bitmap);
            cursor.close();
		}
	}

	
	@Override
	public void onClick(View v) {
		Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, LOAD_IMAGE_RESULTS);
	}
	//code use ends
}
