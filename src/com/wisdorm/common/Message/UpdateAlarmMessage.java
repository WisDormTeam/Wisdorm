package com.wisdorm.common.Message;

import com.wisdorm.base.MessageBase;
import com.wisdorm.common.Alarm;

public class UpdateAlarmMessage extends MessageBase{
	private Alarm alarm = null;
	
	public UpdateAlarmMessage(Alarm alarm) {
		// TODO Auto-generated constructor stub
		this.msgType = MSG_UPDATEALARM;
		this.alarm = alarm;
	}
	
	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}
	
	public Alarm getAlarm() {
		return alarm;
	}
}
