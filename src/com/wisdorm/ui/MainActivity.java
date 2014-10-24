package com.wisdorm.ui;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.wisdorm.R;
import com.wisdorm.manager.AlarmCenter;
import com.wisdorm.manager.AppController;
import com.wisdorm.ui.fragment.AlarmFragment;
import com.wisdorm.ui.fragment.BaseFragment;
import com.wisdorm.ui.fragment.FragmentAdapter;
import com.wisdorm.ui.fragment.TimeAxisFragment;
import com.wisdorm.manager.ActivityManager;

public class MainActivity extends FragmentActivity{
	private FragmentAdapter mAdapter = null;
	public final static int ALARM_MSG = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		ActivityManager.getInstance().setMainActivity(this);
		
		initFragment();
		initAlarmCenter();
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add:
				mAdapter.addItem();
			break;
		default:
			break;
		}
		
		return true;
	}
	
	private void initFragment() {
		List<BaseFragment> fragments = new ArrayList<BaseFragment>();
		fragments.add(new TimeAxisFragment());
		fragments.add(new AlarmFragment());
		fragments.add(new TimeAxisFragment());
		
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
		mAdapter = new FragmentAdapter(this, fragments, R.id.maincontent, radioGroup);
	}
	
	private void initAlarmCenter() {
		AppController.getInstance().getAlarmCenter().setActivity(this);
	}
}
