package com.mobile.chashma;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import com.mobile.chashma.R;

public class Welcome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}
	
	public void go(View view)
    {
    	Intent go = new Intent(this,Ui.class);
    	startActivity(go);
    	
    	
    }
	


	public void eyesight(View view)
    {
    	Intent eyesight = new Intent(this,Eyesight.class);
    	startActivity(eyesight);
    	
    	
    }
	
	

	public void color(View view)
    {
    	Intent color = new Intent(this,Colorblind.class);
    	startActivity(color);
    	
    	
    }
	
	
	
	
	
	public void about(View view)
    {
    	Intent about = new Intent(this,Aboutus.class);
    	startActivity(about);
    	
    	
    }
	
	
	
	public void ocr(View view)
    {
    	Intent ocr = new Intent(this,Ocr.class);
    	startActivity(ocr);
    	
    	
    }
	
	
	
}
