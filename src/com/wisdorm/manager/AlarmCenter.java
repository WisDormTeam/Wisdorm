package com.wisdorm.manager;

import java.util.ArrayList;
import java.util.List;

import android.R.anim;
import android.content.Context;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;

import com.wisdorm.common.Alarm;
import com.wisdorm.ui.AlarmListItem;
import com.wisdorm.ui.AlarmReceiver;
import com.wisdorm.ui.MainActivity;
import com.wisdorm.ui.fragment.ViewArrayAdapter;

public class AlarmCenter {
	private MainActivity mActivity;
	private List<Alarm> mAlarms;
	private ViewArrayAdapter mAdapter;
	
	public AlarmCenter() {
		mAlarms = new ArrayList<Alarm>();
		setAdapter(null);
	}
	
	public ViewArrayAdapter getAdapter() {
		return mAdapter;
	}

	public void setAdapter(ViewArrayAdapter mAdapter) {
		this.mAdapter = mAdapter;
	}
	
	public void setActivity(MainActivity activity) {
		this.mActivity = activity;
	}
	
	//addAlarm 1.add To network if share 2.add to listView 3.registerAlarm at system
	public boolean addAlarm(Alarm alarm) {
		if(mAdapter == null || alarm == null)
			return false;
		
		mAlarms.add(alarm);
		AlarmListItem item = AlarmListItem.create(mAdapter.getContext(), alarm);
		mAdapter.addView(item);
		registerAlarm(alarm);
		return true;
	}
	
	//delete from network if share 2.delete from listView 3.cancel at system
	public boolean deleteAlarm(Alarm alarm) {
		return true;
	}
	
	public boolean registerAlarm(Alarm alarm) {
		Intent intent = new Intent(mActivity, AlarmReceiver.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this.mActivity, 0, intent, 0);
		AlarmManager alarmManager = (AlarmManager)mActivity.getSystemService(Context.ALARM_SERVICE);
			
		alarmManager.set(AlarmManager.RTC_WAKEUP, alarm.getTimeMillis(), pendingIntent);
		
		return true;
	}
	
}
