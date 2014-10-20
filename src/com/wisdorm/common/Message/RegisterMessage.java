package com.wisdorm.common.Message;

import android.provider.ContactsContract.CommonDataKinds.Email;

import com.wisdorm.base.MessageBase;

public class RegisterMessage extends MessageBase{
	private String email = null;
	private String password = null;
	
	public RegisterMessage(String email,String password) {
		// TODO Auto-generated constructor stub
		this.msgType = MSG_REGISTER;
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	
}
