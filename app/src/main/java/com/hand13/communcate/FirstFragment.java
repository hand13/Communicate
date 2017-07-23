package com.hand13.communcate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by hd110 on 2017/7/22.
 */

public class FirstFragment extends Fragment {
	private Button submitButton;
	private EditText nameText;
	public static FirstFragment newInstance(){
		return new FirstFragment();
	}
	@Override
	public View onCreateView(LayoutInflater layoutInflater, ViewGroup parent,Bundle args){
		View v=layoutInflater.inflate(R.layout.firstfragment_view,parent,false);
		submitButton=(Button)v.findViewById(R.id.submitButton);
		nameText=(EditText)v.findViewById(R.id.textInput);
		submitButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String name=nameText.getText().toString();
				Intent intent=new Intent(getActivity(),ConActivity.class);
				intent.putExtra(ConActivity.TAG,name);
				startActivity(intent);
			}
		});
		return v;
	}
}
