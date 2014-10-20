package com.wisdorm.common;

import java.util.Arrays;


import cn.bmob.v3.BmobObject;

public class Dorm extends BmobObject{
	private String dormName = null;
	private Arrays dormMates = null;
	private String dormId = null;
	
	public Dorm() {
		// TODO Auto-generated constructor stub
	}
	
	public String getDormId() {
		return dormId;
	}
	
	public Arrays getDormMates() {
		return dormMates;
	}
	
	public String getDormName() {
		return dormName;
	}
	
	public void setDormId(String dormId) {
		this.dormId = dormId;
	}
	
	public void setDormMates(Arrays dormMates) {
		this.dormMates = dormMates;
	}
	public void setDormName(String dormName) {
		this.dormName = dormName;
	}
}
