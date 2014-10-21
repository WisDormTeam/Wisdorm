package com.wisdorm.common;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.datatype.BmobPointer;

public class User extends BmobUser{
	//private String username;
	//private String email;
	//private String password;
	
	//above all is default attribute in BmobUser
	private String nickname = null;
	private BmobFile icon = null;
	private String dormid = null;
	private Dorm dorm = null;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public BmobFile getIcon() {
		return icon;
	}
	
	public void setIcon(BmobFile icon) {
		this.icon = icon;
	}
	
	public String getDormId() {
		return dormid;
	}
	
	public void setDormId(String dormId) {
		this.dormid = dormId;
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
}
