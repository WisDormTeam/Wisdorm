package com.wisdorm.common;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

public class User extends BmobUser{
	//private String username;
	//private String email;
	//private String password;
	
	//above all is default attribute in BmobUser
	
	private BmobFile icon = null;
	private String dormId = null;
	
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
		return dormId;
	}
	
	public void setDormId(String dormId) {
		this.dormId = dormId;
	}
}
