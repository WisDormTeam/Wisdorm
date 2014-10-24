package com.wisdorm.common;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.datatype.BmobRelation;

public class User extends BmobUser{
	//private String username;
	//private String email;
	//private String password;
	
	//above all is default attribute in BmobUser
	private Boolean alarmon = false;
	private String nickname = null;
	private BmobFile icon = null;
	private Dorm dorm = null;
	private BmobRelation alarms = null;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public BmobFile getIcon() {
		return icon;
	}
	
	public void setIcon(BmobFile icon) {
		this.icon = icon;
	}
	
	public Dorm getDorm() {
		return dorm;
	}
	
	public void setDorm(Dorm dorm) {
		this.dorm = dorm;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public BmobRelation getAlarms() {
		return alarms;
	}
	
	public void setAlarms(BmobRelation alarms) {
		this.alarms = alarms;
	}
	
	public Boolean getAlarmon() {
		return alarmon;
	}
	
	public void setAlarmon(Boolean alarmon) {
		this.alarmon = alarmon;
	}
}
