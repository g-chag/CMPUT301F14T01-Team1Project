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

public class AddYodelActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_yodel);
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
			YodelitController.addYodel(newYodel);
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
	//code from: http://www.itcuties.com/android/pick-image-from-gallery/
    // Image loading result to pass to startActivityForResult method.
    private static int LOAD_IMAGE_RESULTS = 1;
     
    // GUI components
    private Button button;  // The button
    private ImageView image;// ImageView
     
    protected void onCreate1(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_yodel);
         
        // Find references to the GUI objects
        button = (Button)findViewById(R.id.buttonLoadPicture);
        image = (ImageView)findViewById(R.id.image);
         
        // Set button's onClick listener object.
        button.setOnClickListener((OnClickListener) this);
         
    }
 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         
        // Here we need to check if the activity that was triggers was the Image Gallery.
        // If it is the requestCode will match the LOAD_IMAGE_RESULTS value.
        // If the resultCode is RESULT_OK and there is some data we know that an image was picked.
        if (requestCode == LOAD_IMAGE_RESULTS && resultCode == RESULT_OK && data != null) {
            // Let's read picked image data - its URI
            Uri pickedImage = data.getData();
            // Let's read picked image path using content resolver
            String[] filePath = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(pickedImage, filePath, null, null, null);
            cursor.moveToFirst();
            String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));
             
            // Now we need to set the GUI ImageView data with data read from the picked file.
            image.setImageBitmap(BitmapFactory.decodeFile(imagePath));
             
            // At the end remember to close the cursor or you will end with the RuntimeException!
            cursor.close();
        }
    }
     
    public void onClick(View v) {
        // Create the Intent for Image Gallery.
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
         
        // Start new activity with the LOAD_IMAGE_RESULTS to handle back the results when image is picked from the Image Gallery.
        startActivityForResult(i, LOAD_IMAGE_RESULTS);
    }
}
