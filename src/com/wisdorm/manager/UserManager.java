package com.wisdorm.manager;

import com.wisdorm.bmob.NetworkTool;
import com.wisdorm.common.Dorm;
import com.wisdorm.common.User;

public class UserManager {
	private User user = null;
	private Dorm dorm = null;
	
	private NetworkTool networkTool = null;
	
	public UserManager() {
		// TODO Auto-generated constructor stub
		user = new User();
		dorm = new Dorm();
		networkTool = new NetworkTool();
	}
	
	public NetworkTool getNetworkTool() {
		return networkTool;
	}
	
	public void setDorm(Dorm dorm) {
		this.dorm = dorm;
	}
	
	public Dorm getDorm() {
		return dorm;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
}
