package com.wisdorm.common.Message;

import com.wisdorm.base.MessageBase;

public class LoginMessage extends MessageBase{
	private String username = null;
	private String password = null;
	
	public LoginMessage(String username,String password) {
		// TODO Auto-generated constructor stub
		this.msgType = MSG_LOGIN;
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
