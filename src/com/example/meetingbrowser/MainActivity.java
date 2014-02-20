package com.example.meetingbrowser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
		
	}
	
	/** Called when the user clicks the Send button */
	public void sendMessage(View view) {
	    // launches new activity in response to button
		Intent intent = new Intent(this, browserWindow.class);
		//field for server identification
		EditText editText1 = (EditText) findViewById(R.id.editText1);
		//field for meeting room identification
		EditText editText2 = (EditText) findViewById(R.id.editText2);
		//passes string with address to specific room web page
		String message = "http://" + editText1.getText().toString() + "/" + editText2.getText().toString() + "/"; 
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}

}
