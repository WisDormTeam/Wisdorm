package com.wisdorm.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.wisdorm.manager.AppController;

import cn.bmob.v3.BmobObject;

import android.R.string;
import android.os.Bundle;

public class Alarm extends BmobObject{
	private long     mID;
	private long    mTimeMillis;
	private boolean[] mRepeating;  //store to database as integer
	private final static int DAY_IN_WEEK = 7;
	
	private User user = null;
	
	public final static String ID_KEY = "ALARM_ID";
	public final static String TIMEMILLIS_KEY = "ALARM_TIMEMILLIS";
	public final static String FORMATTIME_KEY = "ALARM_FORMATTIME";
	
	public Alarm() {
		setID(0);
		setTimeMillis(0);
		setRepeating(new boolean[DAY_IN_WEEK]);
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	//AlarmId is TimeMillis that it was created
	public long getID() {
		return mID;
	}

	public void setID(long mID) {
		this.mID = mID;
	}

	public long getTimeMillis() {
		return mTimeMillis;
	}

	public void setTimeMillis(long mTimeMillis) {
		this.mTimeMillis = mTimeMillis;
	}

	public boolean[] getRepeating() {
		return mRepeating;
	}

	public void setRepeating(boolean[] mRepeating) {
		this.mRepeating = mRepeating;
	}
	
	public String getFormatTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(getTimeMillis());
		Date date = (Date) calendar.getTime();
		SimpleDateFormat sf=new SimpleDateFormat("HH:mm");
		
		return sf.format(date);
	}
	
	//convert To byte;
	public Byte getRepeatingByte() {
		return null;
	}
	
	public Bundle getBundleInfo() {
		Bundle bundle = new Bundle();
		bundle.putLong(ID_KEY, getID());
		bundle.putLong(TIMEMILLIS_KEY, getTimeMillis());
		bundle.putString(FORMATTIME_KEY, getFormatTime());
		return bundle;
	}
}
