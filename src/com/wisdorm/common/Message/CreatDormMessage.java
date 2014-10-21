package com.wisdorm.common.Message;

import com.wisdorm.base.MessageBase;

public class CreatDormMessage extends MessageBase{

	private int nop = 0; // the number of dormmates;
	private String dormname = null;
	
	public CreatDormMessage(String dormname,int nop) {
		// TODO Auto-generated constructor stub
		this.msgType = MessageBase.MSG_CREATDORM;
		this.nop = nop;
		this.dormname = dormname;
	}
	
	//get the number of dormmates
	public int getNop() {
		return nop;
	}
	
	public String getDormname() {
		return dormname;
	}
}
