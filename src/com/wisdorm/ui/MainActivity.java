package com.wisdorm.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import cn.volley.toolbox.AndroidAuthenticator;

import com.example.wisdorm.R;

public class MainActivity extends Activity{
	private FragmentTransaction fragmentTransaction;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		initFragment();
	}
	
	private void initFragment() {
		fragmentTransaction = getFragmentManager().beginTransaction();
		TimeAxisFragment fragment = new TimeAxisFragment();
		fragmentTransaction.add(R.id.maincontent, fragment);
		fragmentTransaction.commit();
		
		RadioButton button = (RadioButton)findViewById(R.id.timeAxis);
		button.setBackgroundResource(R.drawable.indexchoosed);
	}
	
	private class RadioGroupListener implements 
		android.widget.RadioGroup.OnCheckedChangeListener {
		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			resetButton();
			switch (arg1) {
			case R.id.timeAxis:
				turnToTimeAxis();
				break;
			case R.id.alarm :
				turnToAlarm();
			default:
				break;
			}
		}
		
	}
	
	private void resetButton() {
		findViewById(R.id.timeAxis).setBackgroundResource(R.drawable.index);
		findViewById(R.id.alarm).setBackgroundResource(R.drawable.article);
		findViewById(R.id.setting).setBackgroundResource(R.drawable.ad);
		
	}
	
	private void turnToTimeAxis() {
		findViewById(R.id.timeAxis).setBackgroundResource(R.drawable.indexchoosed);
	}
	
	private void turnToAlarm() {
		findViewById(R.id.alarm).setBackgroundResource(R.drawable.articlechoosed);
	}
}
