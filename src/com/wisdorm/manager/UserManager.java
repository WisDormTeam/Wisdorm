package com.wisdorm.manager;

import com.wisdorm.bmob.QueryTool;
import com.wisdorm.common.Dorm;
import com.wisdorm.common.User;

public class UserManager {
	private User user = null;
	private Dorm dorm = null;
	
	private QueryTool queryTool = null;
	
	public UserManager() {
		// TODO Auto-generated constructor stub
		user = new User();
		dorm = new Dorm();
		queryTool = new QueryTool();
	}
	
	public QueryTool getQueryTool() {
		return queryTool;
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
