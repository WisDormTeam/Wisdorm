package com.wisdorm.common;

public class Alarm {
	private int     mID;
	private long    mTimeMillis;
	private boolean[] mRepeating;  //store to database as integer
	private final static int DAY_IN_WEEK = 7;
	
	public Alarm(int id) {
		setID(id);
		setTimeMillis(0);
		setRepeating(new boolean[DAY_IN_WEEK]);
	}

	public int getID() {
		return mID;
	}

	public void setID(int mID) {
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
}
