package com.wisdorm.ui;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wisdorm.R;
import com.wisdorm.common.Alarm;
import com.wisdorm.manager.AppController;

public class AlarmListItem extends RelativeLayout {
	private Alarm mAlarm;
	private TextView mTimeTextView;
	private Button mDelete;
	private AlarmListItem(Context context) {
		super(context);
		initView(context);
	}
	
	private AlarmListItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}
	
	private void initView(Context context) {
		LayoutInflater inflater = LayoutInflater.from(context);
		inflater.inflate(R.layout.alarm_item, this);
		this.mTimeTextView = (TextView)findViewById(R.id.time);
		this.mDelete = (Button)findViewById(R.id.delete);
		
		this.mDelete.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				removeSelf();
			}
		});
	}

	public static AlarmListItem create(Context context, Alarm alarm) {
		AlarmListItem listItem = new AlarmListItem(context);
		
		LayoutInflater inflater = LayoutInflater.from(context);
		RelativeLayout listitem = (RelativeLayout)inflater.inflate(R.layout.alarm_item, null);
		listItem.setAlarm(alarm);
	
		listItem.getTimeTextView().setText(alarm.getFormatTime());
		
		return listItem;
	}
	
	private void removeSelf() {
		AppController.getInstance().getAlarmCenter().deleteAlarmById(mAlarm.getID());
	}
	
	public Alarm getAlarm() {
		return mAlarm;
	}
	
	public void setAlarm(Alarm alarm) {
		this.mAlarm = alarm;
	}
	
	public TextView getTimeTextView() {
		return mTimeTextView;
	}
}
