package com.wisdorm.manager;

import com.wisdorm.ui.CreateDormActivity;
import com.wisdorm.ui.LoginActivity;
import com.wisdorm.ui.MainActivity;

public class ActivityManager {
	
	private static ActivityManager instance = null;
	
	private LoginActivity loginActivity = null;
	private CreateDormActivity createDormActivity = null;
	private MainActivity mainActivity = null;
	
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
	
	public void setCreateDormActivity(CreateDormActivity createDormActivity) {
		this.createDormActivity = createDormActivity;
	}
	
	public CreateDormActivity getCreateDormActivity() {
		return createDormActivity;
	}
	
	public MainActivity getMainActivity() {
		return mainActivity;
	}
	
	public void setMainActivity(MainActivity mainActivity) {
		this.mainActivity = mainActivity;
	}
}
