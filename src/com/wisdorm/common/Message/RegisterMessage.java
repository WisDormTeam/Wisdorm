package com.wisdorm.common.Message;

import android.provider.ContactsContract.CommonDataKinds.Email;

import com.wisdorm.base.MessageBase;

public class RegisterMessage extends MessageBase{
	private String email = null;
	private String password = null;
	private String username = null;
	
	public RegisterMessage(String username,String email,String password) {
		// TODO Auto-generated constructor stub
		this.msgType = MSG_REGISTER;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	
}
