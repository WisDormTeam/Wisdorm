package com.wisdorm.manager;

import com.wisdorm.common.Dorm;
import com.wisdorm.common.User;

public class UserManager {
	private User user = null;
	private Dorm dorm = null;
	
	public UserManager() {
		// TODO Auto-generated constructor stub
		user = new User();
		dorm = new Dorm();
	}
	
	public void setDorm(Dorm dorm) {
		this.dorm = dorm;
	}
	
	public Dorm getDorm() {
		return dorm;
	}
	
	public User getUser() {
		return user;
	}
	
}
