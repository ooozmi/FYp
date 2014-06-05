package com.mobile.chashma;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;
import com.mobile.chashma.R;

public class Ui extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ui, menu);
		return true;
	}

	
	
	
	
	
	
	
	public void read(View view)
    {
		Spinner spin = (Spinner)findViewById(R.id.spinner1);
		String selected_option= (String)spin.getItemAtPosition(spin.getSelectedItemPosition());
		//Toast.makeText(this, selected_option, 500).show();
		float zoom_value=0;
		if(selected_option.compareTo("0.25 to 1.25")==0){
			zoom_value = (float)0;
		}
		else if(selected_option.compareTo("2.25 to 3.25")==0){
			zoom_value = (float)4;
		}
		
		else if(selected_option.compareTo("3.25 to 4.25")==0){
			zoom_value = (float)8;
		}
		else if(selected_option.compareTo("4.25 to 5.25")==0){
			zoom_value = (float)12;
		}
		else if(selected_option.compareTo("5.25 to 6.25")==0){
			zoom_value = (float)16;
		}
		else if(selected_option.compareTo("6.25 to 7.25")==0){
			zoom_value = (float)20;
		}
		else if(selected_option.compareTo("7.25 to 8.25")==0){
			zoom_value = (float)24;
		}
		else if(selected_option.compareTo("8.25 to 9.25")==0){
			zoom_value = (float)28;
		}
		else if(selected_option.compareTo("9.25 to 10.25")==0){
			zoom_value = (float)32;
		}
		else if(selected_option.compareTo("10.25 to 11.25")==0){
			zoom_value = (float)36;
		}
		else if(selected_option.compareTo("12.25 to 13.25")==0){
			zoom_value = (float)40;
		}
		else if(selected_option.compareTo("13.25 to 14.25")==0){
			zoom_value = (float)42;
		}
		else if(selected_option.compareTo("14.25 to 15.25")==0){
			zoom_value = (float)45;
		}
		
		
		
		
		
		
		
		
		
    	Intent read = new Intent(this,MainActivity.class);
    	read.putExtra("zoom_value", zoom_value);
    	startActivity(read);
    	
    	
    }
	
}
