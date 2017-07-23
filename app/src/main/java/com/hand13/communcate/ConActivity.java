package com.hand13.communcate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by hd110 on 2017/7/23.
 */

public class ConActivity  extends AppCompatActivity{
	public static final String TAG="com.hand13.communicate.ConActivity";
	public static final String backWork="com.back";
	public String fName;
	public EditText tNameText;
	public EditText messageText;
	public Button submitButton;
	@Override
	public void onCreate(Bundle args){
		super.onCreate(args);
		setContentView(R.layout.comlayview);
		fName=getIntent().getStringExtra(TAG);
		tNameText=(EditText)findViewById(R.id.tName);
		messageText=(EditText)findViewById(R.id.message);
		submitButton=(Button)findViewById(R.id.submitMessage);
		submitButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				BackWork backWork=new BackWork();
				backWork.execute(fName,tNameText.getText().toString(),messageText.getText().toString());
			}
		});
	}
}
