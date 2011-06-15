package com.chenyz;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MultiActivity extends ActivityGroup {
	
	private ScrollView container = null;
	private ScrollView container2 = null;
	private ScrollView container3 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        setContentView(R.layout.multi_activity);

        container = (ScrollView) findViewById(R.id.containerBody);
        container2 = (ScrollView) findViewById(R.id.containerBody2);
        container3 = (ScrollView) findViewById(R.id.containerBody3);
        
        container.addView(getLocalActivityManager().startActivity(
                "Module1",
                new Intent(MultiActivity.this, MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                .getDecorView());
        
        container2.addView(getLocalActivityManager().startActivity(
                "Module2",
                new Intent(MultiActivity.this, SecondActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                .getDecorView());
        
        container3.removeAllViews();
        container3.addView(getLocalActivityManager().startActivity(
                "Module3",
                new Intent(MultiActivity.this, ThirdActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                .getDecorView());

        // Module1
        ImageView btnModule1 = (ImageView) findViewById(R.id.btnModule1);
        btnModule1.setOnClickListener(new OnClickListener() {
            
            public void onClick(View v) {
            	if(container.getChildCount()==0){
            		container.addView(getLocalActivityManager().startActivity(
                            "Module1",
                            new Intent(MultiActivity.this, MainActivity.class)
                                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                            .getDecorView());
            	}else{
            		container.removeAllViews();
            	}
                
                
            }
        });

        // Module2
        ImageView btnModule2 = (ImageView) findViewById(R.id.btnModule2);
        btnModule2.setOnClickListener(new OnClickListener() {

        	
            public void onClick(View v) {
            	if(container2.getChildCount()==0){
            		container2.addView(getLocalActivityManager().startActivity(
                            "Module2",
                            new Intent(MultiActivity.this, SecondActivity.class)
                                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                            .getDecorView());
            	}else{
            		container2.removeAllViews();
            	}           	
            	
            }
            
        });

        // Module 3
        ImageView btnModule3 = (ImageView) findViewById(R.id.btnModule3);
        btnModule3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	
            	if(container3.getChildCount()==0){
            		container3.addView(getLocalActivityManager().startActivity(
                            "Module3",
                            new Intent(MultiActivity.this, ThirdActivity.class)
                                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                            .getDecorView());
            	}else{
            		container3.removeAllViews();
            	}
                
                
            }
        });
    }

}
