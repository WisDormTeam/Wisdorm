package com.wisdorm.ui;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wisdorm.R;
import com.wisdorm.common.Alarm;

public class AlarmListItem {
	public static LinearLayout create(Context context, Alarm alarm) {
		LayoutInflater inflater = LayoutInflater.from(context);
		LinearLayout listitem = (LinearLayout)inflater.inflate(R.layout.alarm_item, null);
		
		//time
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(alarm.getTimeMillis());
		Date date = (Date) calendar.getTime();
		SimpleDateFormat sf=new SimpleDateFormat("HH-mm");
		
		TextView time = (TextView)listitem.findViewById(R.id.time);
		time.setText(sf.format(date));
		
		//repeating
//		TextView mon = (TextView)listitem.findViewById(R.id.repeating_1);
//		if(alarm.getRepeating()[0]) 
//			mon.setBackground(R.drawable.mon_on)
//		else
//			mon.setBackgroundResource(R.drawable.mon_off);
//		
//		TextView tues = (TextView)listitem.findViewById(R.id.repeating_2);
//		if(alarm.getRepeating()[1]) 
//			tues.setBackground(R.drawable.tues_on)
//		else
//			tues.setBackgroundResource(R.drawable.tues_off);
//		
//		TextView wed = (TextView)listitem.findViewById(R.id.repeating_3);
//		if(alarm.getRepeating()[1]) 
//			wed.setBackground(R.drawable.wed_on)
//		else
//			wed.setBackgroundResource(R.drawable.wed_off);
//		
//		TextView thr = (TextView)listitem.findViewById(R.id.repeating_4);
//		if(alarm.getRepeating()[3]) 
//			thr.setBackground(R.drawable.thr_on)
//		else
//			thr.setBackgroundResource(R.drawable.thr_off);
//		
//		TextView fri = (TextView)listitem.findViewById(R.id.repeating_5);
//		if(alarm.getRepeating()[4]) 
//			fri.setBackground(R.drawable.fri_on)
//		else
//			fri.setBackgroundResource(R.drawable.fri_off);
//		
//		TextView sat = (TextView)listitem.findViewById(R.id.repeating_6);
//		if(alarm.getRepeating()[5]) 
//			sat.setBackground(R.drawable.sat_on)
//		else
//			sat.setBackgroundResource(R.drawable.sat_off);
//		
//		TextView sun = (TextView)listitem.findViewById(R.id.repeating_7);
//		if(alarm.getRepeating()[6]) 
//			sun.setBackground(R.drawable.sun_on)
//		else
//			sun.setBackgroundResource(R.drawable.sun_off);
		
		return listitem;
	}
}
