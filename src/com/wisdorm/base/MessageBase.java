package com.wisdorm.base;

public class MessageBase {
	protected int msgType;
	
	public static final int MSG_ERROR 		= -1;
	public static final int MSG_BASE 		= 0;
	public static final int MSG_REGISTER 	= 1;
	public static final int MSG_LOGIN 		= 2;
	public static final int MSG_CREATDORM 	= 3;
	public static final int MSG_ALARM_OFF 	= 4;
	public static final int MSG_ATTENDDORM 	= 5;
	public static final int MSG_QUERYDORM 	= 6;
	public static final int MSG_AlARM_ON 	= 7;
	public static final int MSG_CREATALARM 	= 8;
	public static final int MSG_REMOVEALARM = 9;
	public static final int MSG_UPDATEALARM = 10;
	public static final int MSG_PULLALARMS 	= 11;
	public static final int MSG_LISTENALARM = 12;
	public static final int MSG_QUERYALARM = 13;
	//..............................
	//.........another type number
	
	
	public MessageBase() {
		msgType = MSG_BASE;
	}
	
	public int getMessageType() {
		return msgType;
	}
	
	
	
}
