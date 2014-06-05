package com.mobile.chashma;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Ocr extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ocr);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ocr, menu);
		return true;
	}

	
	public void ocrr(View view)
	   {
		   
		
		Uri uri = Uri.parse("http://www.onlineocr.net");
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);
		
	
	   }
	public void ocrg(View view)
	   {
		   Intent intent = new Intent(Intent.ACTION_MAIN);
		   intent.setComponent(new ComponentName("edu.sfsu.cs.orange.ocr","edu.sfsu.cs.orange.ocr.HelpActivity"));
		   startActivity(intent);
	
	   }

	public void ocrgg(View view)
	   {
		   
		
		Uri uri = Uri.parse("http://www.newocr.com");
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);
		
	
	   }
	
}
