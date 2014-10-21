package com.wisdorm.ui.fragment;

import java.util.List;

import com.example.wisdorm.R;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FragmentAdapter implements RadioGroup.OnCheckedChangeListener {
	private FragmentActivity   activity;
	private List<BaseFragment>     fragments ;
	private int                contentId;
	private RadioGroup         radioGroup;
	
	private int currentTab;
	
	public FragmentAdapter(FragmentActivity activity, List<BaseFragment> fragments, 
			int contentId, RadioGroup radioGroup) {
		this.activity = activity;
		this.fragments = fragments;
		this.contentId = contentId;
		this.radioGroup = radioGroup;
		
		//show the first
		this.radioGroup.setOnCheckedChangeListener(this);
		RadioButton button = (RadioButton) activity.findViewById(R.id.timeAxis);
		if(button != null)
			button.setBackgroundResource(R.drawable.indexchoosed);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		ft.add(contentId, fragments.get(0));
		ft.commit();
		
		currentTab = 0;
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		handleButtonChanged(arg1);
		handleFragmentChanged(arg1);
	}
	
	private void handleButtonChanged(int buttonId) {
		resetButton();
		
		switch (buttonId) {
		case R.id.timeAxis:
			RadioButton timeAxisButton = (RadioButton) activity.findViewById(R.id.timeAxis);
			if(timeAxisButton != null)
				timeAxisButton.setBackgroundResource(R.drawable.indexchoosed);
			break;
		case R.id.alarm:
			RadioButton alarmButton = (RadioButton) activity.findViewById(R.id.alarm);
			if(alarmButton != null)
				alarmButton.setBackgroundResource(R.drawable.articlechoosed);
			break;
		case R.id.setting:
			RadioButton settingButton = (RadioButton) activity.findViewById(R.id.setting);
			if(settingButton != null)
				settingButton.setBackgroundResource(R.drawable.adchoosed);
			break;
		default:
			break;
		}
	}
	
	private void resetButton() {
		RadioButton timeAxisButton = (RadioButton) activity.findViewById(R.id.timeAxis);
		if(timeAxisButton != null)
			timeAxisButton.setBackgroundResource(R.drawable.index);
		
		RadioButton alarmButton = (RadioButton) activity.findViewById(R.id.alarm);
		if(alarmButton != null)
			alarmButton.setBackgroundResource(R.drawable.article);
		
		RadioButton settingButton = (RadioButton) activity.findViewById(R.id.setting);
		if(settingButton != null)
			settingButton.setBackgroundResource(R.drawable.ad);
	}
	
	private void handleFragmentChanged(int buttonId) {
		for (int i = 0; i < radioGroup.getChildCount(); i++) {
			if(radioGroup.getChildAt(i).getId() == buttonId) {
				Fragment fragment = fragments.get(i);
				FragmentTransaction fragmentTransaction = obtainTransaction();
				
				if(getCurFragment() != null)
					getCurFragment().onPause();
				
				if(fragment.isAdded()) {
					fragment.onResume();
				}
				else {
					fragmentTransaction.add(contentId, fragment);
				}
				
				showTab(i);
				fragmentTransaction.commit();
			}
		}
	}
	
	private void showTab(int idx) {
		for(int i = 0; i < fragments.size(); i++) {
			Fragment fragment = fragments.get(i);
			FragmentTransaction transaction = obtainTransaction();
			
			if(idx == i) {
				transaction.show(fragment);
			}
			else {
				transaction.hide(fragment);
			}
			transaction.commit();
		}
		
		currentTab = idx;
	}
	
	private FragmentTransaction obtainTransaction() {
		return activity.getFragmentManager().beginTransaction();
	}
	
	public int getCurTab() {
		return currentTab;
	}
	
	public BaseFragment getCurFragment() {
		if(currentTab >= 0 && currentTab < fragments.size())
			return fragments.get(currentTab);
		else
			return null;
	}
	
	public void addItem() {
		if(getCurFragment() != null)
			getCurFragment().addItem();
	}
}
