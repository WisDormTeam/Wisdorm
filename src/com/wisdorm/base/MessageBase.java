package com.wisdorm.base;

public class MessageBase {
	protected int msgType;
	
	public static final int MSG_ERROR = -1;
	public static final int MSG_BASE = 0;
	public static final int MSG_REGISTER = 1;
	public static final int MSG_LOGIN = 2;
	//..............................
	//.........another type number
	
	
	public MessageBase() {
		msgType = MSG_BASE;
	}
	
	public int getMessageType() {
		return msgType;
	}
	
	
	
}
