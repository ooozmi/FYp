package com.mobile.chashma;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PointF;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.mobile.chashma.R;

public class MainActivity extends Activity {
	private CamLayer mPreview;
	
	//multi touch event
	private float oldDist = 1f;
	private PointF mid = new PointF(); 
	private int mode = 0;
	private boolean down = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent intent = getIntent();
		final float zoom_value = intent.getFloatExtra("zoom_value", 0);
		Toast.makeText(this, String.valueOf(zoom_value), 500).show();
        // Create our Preview view and set it as the content of our activity.
        mPreview = new CamLayer(this);
        
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mPreview);
        //mode = 1;
        
        
        
			
        mPreview.setOnTouchListener(new OnSwipeTouchListener(){
			 public void onSwipeTop() {
				 if(down){
				/* Thread t = new Thread() {
	                    public void run() {
	                    	mPreview.upsidedownit();

	                    	
	                    }
	                };
	                t.start();*/
					mPreview.zoomin(zoom_value);
			    }
			 }
			    public void onSwipeRight() {
			    	if(down){
			    	Thread t = new Thread() {
	                    public void run() {
	                    	mPreview.flipit();
	                    }
	                };
	                t.start();
			    }
			    }
			    public void onSwipeLeft() {
			    	if(down){
			    	Thread t = new Thread() {
	                    public void run() {
	                    	mPreview.flipit();
	                    }
	                };
	                t.start();
			    }
			    }
			    public void onSwipeBottom() {
					 if(down){
						 Thread t = new Thread() {
			                    public void run() {
			                    	mPreview.upsidedownit();
			                    }
			                };
			                t.start();

					    }
					 }
		});
        
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		switch(event.getAction() & MotionEvent.ACTION_MASK){
			case MotionEvent.ACTION_DOWN:
				down = true;
				break;
				
			case MotionEvent.ACTION_POINTER_DOWN:
				down = false;
				oldDist = spacing(event);
				if(oldDist > 10f){
					midPoint(mid, event);
					mode = 1;
				}
				break;
				
		    case MotionEvent.ACTION_UP:
		    	 down = true;
		    	 mode = 0;
			     break;
			     
			case MotionEvent.ACTION_POINTER_UP:
				 down =false;
		         mode = 0;
		         break;
		
			case MotionEvent.ACTION_MOVE:
				if(mode == 1){
					float newDist = spacing(event);
					if(newDist > 10f){
						float m = newDist/oldDist;
						//Toast.makeText(this, String.valueOf(m), 500).show();
						mPreview.zoomin(m);
					}
				}
				break;   
		         
		         
		         
		         
		     	
		         
		         
		         
		}
		return true;
		
	}
	 
	 /** Determine the space between the first two fingers */
	 private float spacing(MotionEvent event) {
	    float x = event.getX(0) - event.getX(1);
	    float y = event.getY(0) - event.getY(1);
	    return FloatMath.sqrt(x * x + y * y);
	 }

	 /** Calculate the mid point of the first two fingers */
	 private void midPoint(PointF point, MotionEvent event) {
	    float x = event.getX(0) + event.getX(1);
	    float y = event.getY(0) + event.getY(1);
	    point.set(x / 2, y / 2);
	 }
	
	
	 @Override
		public void onDestroy(){
			super.onDestroy();
			mPreview.onStop();
		}
		
		@Override
		public void onPause(){
			super.onPause();
			mPreview.onPause();
		}
		
		@Override
		public void onResume(){
			super.onResume();
		
		}

}

