package com.wisdorm.common;

import java.util.ArrayList;
import java.util.Arrays;


import cn.bmob.v3.BmobObject;

public class Dorm extends BmobObject{
	private String dormName = null;
	private ArrayList<User> dormMates = null;
	private String dormId = null;
	
	public Dorm() {
		dormMates = new ArrayList<User>();
	}
	
	public String getDormId() {
		return dormId;
	}
	
	public ArrayList<User> getDormMates() {
		return dormMates;
	}
	
	public String getDormName() {
		return dormName;
	}
	
	public void setDormId(String dormId) {
		this.dormId = dormId;
	}
	
	public void setDormMates(ArrayList<User> dormMates) {
		this.dormMates = dormMates;
	}
	public void setDormName(String dormName) {
		this.dormName = dormName;
	}
}
