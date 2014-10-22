package com.wisdorm.ui.fragment;

import java.sql.Date;
import java.util.Calendar;

import com.example.wisdorm.R;
import com.wisdorm.common.Alarm;
import com.wisdorm.manager.AppController;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.StaticLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class TimePickerDialog extends Dialog{
	 private Alarm mAlarm;
	 private final static long MILLIS_OF_DAY = 86400000;
	 public TimePickerDialog(Context context) {
		 super(context);
		 setCanceledOnTouchOutside(false);
		 
		 //should give a id;
		 mAlarm = new Alarm();
		 mAlarm.setTimeMillis(System.currentTimeMillis());
	 }
	 
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 this.setContentView(R.layout.alarm_picker);
		 
		 TimePicker timePicker = (TimePicker)findViewById(R.id.timepicker);
		 timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
			@Override
			public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(System.currentTimeMillis());
				calendar.set(Calendar.HOUR_OF_DAY, arg1);
				calendar.set(calendar.MINUTE, arg2);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				
				//nextDay
				if(calendar.getTimeInMillis() < System.currentTimeMillis())
					calendar.setTimeInMillis(calendar.getTimeInMillis() + MILLIS_OF_DAY);
				mAlarm.setTimeMillis(calendar.getTimeInMillis());
			}
		});
		 
		 Button confirm = (Button)findViewById(R.id.confirm);
		 confirm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				mAlarm.setID(System.currentTimeMillis());
				AppController.getInstance().getAlarmCenter().addAlarm(mAlarm);
				cancel();
			}
		});
		 
		 Button cancel = (Button)findViewById(R.id.cancel);
		 cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				cancel();
			}
		});
	 }
}
