package com.example.meetingbrowser;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class browserWindow extends MainActivity implements OnSharedPreferenceChangeListener  {

	//override that enables javascript
	@SuppressLint("SetJavaScriptEnabled") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browserwindow);
	
		
		//Load the preference defaults
		PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
		
			
		//intent for catching web page address parameter 
		Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        
        //gets strings from preferences
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
    	// register preference change listener
        sharedPref.registerOnSharedPreferenceChangeListener(this);
        
        
        String webAddress = sharedPref.getString(serverPref, "");
		
        //launches webview browser
		WebView myWebView = (WebView) findViewById(R.id.webview);
		myWebView.setWebViewClient(new WebViewClient());
		myWebView.loadUrl(message);
		
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

		
}


