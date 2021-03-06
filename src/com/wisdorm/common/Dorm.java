package com.wisdorm.common;

import java.util.ArrayList;
import java.util.Arrays;

import android.R.integer;


import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobRelation;

public class Dorm extends BmobObject{
	private String dormname = null;
	private BmobRelation dormmates = null;
	private Boolean alarmon = false;
	private int count;
	
	public Dorm() {
	}
	
	public Boolean getAlarmon() {
		return alarmon;
	}
	
	public void setAlarmon(Boolean alarmon) {
		this.alarmon = alarmon;
	}
	
	public BmobRelation getDormMates() {
		return dormmates;
	}
	
	public String getDormName() {
		return dormname;
	}
	
	public void setDormMates(BmobRelation dormMates) {
		this.dormmates = dormMates;
	}
	public void setDormName(String dormName) {
		this.dormname = dormName;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
}
