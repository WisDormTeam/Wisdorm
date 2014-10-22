package com.wisdorm.common.Message;

import com.wisdorm.base.MessageBase;

public class AttendDormMessage extends MessageBase{
	private String dormId = null;
	
	public AttendDormMessage(String dormId) {
		// TODO Auto-generated constructor stub
		this.msgType = MSG_ATTENDDORM;
		this.dormId = dormId;
	}
	
	public String getDormId() {
		return dormId;
	}
}
