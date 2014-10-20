package com.wisdorm.manager;

import com.wisdorm.activity.LoginActivity;

public class ActivityManager {
	
	private static ActivityManager instance = null;
	
	private LoginActivity loginActivity = null;
	
	public static ActivityManager getInstance() {
		if(instance == null){
			instance = new ActivityManager();
		}
		return instance;
	}
	
	public void setLoginActivity(LoginActivity loginActivity) {
		this.loginActivity = loginActivity;
	}
	
	public LoginActivity getLoginActivity() {
		return loginActivity;
	}
}
