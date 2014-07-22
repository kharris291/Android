package kev.harris.noticeboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class WebScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webscreen);
		initialize();
	}

	WebView myWebView;
	private void initialize() {
		// TODO Auto-generated method stub
		myWebView = (WebView) findViewById(R.id.webview);
		myWebView.loadUrl("http://extractioneg.blogspot.ie/");
		myWebView.setWebViewClient(new WebViewClient());
		

		
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    // Check if the key event was the Back button and if there's history
	    if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
	        myWebView.goBack();
	        return true;
	    }
	    // If it wasn't the Back key or there's no web page history, bubble up to the default
	    // system behavior (probably exit the activity)
	    onBackPressed();
	    return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
		super.onBackPressed();
		Intent j = new Intent(Intent.ACTION_MAIN);
		j.addCategory(Intent.CATEGORY_HOME);
		startActivity(j);
		finish();
	}
	

}
