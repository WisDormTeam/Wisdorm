package com.wisdorm.common.Message;

import java.io.File;

import com.wisdorm.base.MessageBase;

public class CreatDormMessage extends MessageBase{

	private int nop = 0; // the number of dormmates;
	private String dormname = null;
	private File file = null;
	
	public CreatDormMessage(String dormname,int nop) {
		// TODO Auto-generated constructor stub
		this.msgType = MessageBase.MSG_CREATDORM;
		this.nop = nop;
		this.dormname = dormname;
	}
	
	
	//if you have the icon to upload,you can use this method
	public CreatDormMessage(String dormname,int nop,File file) {
		// TODO Auto-generated constructor stub
		this.msgType = MessageBase.MSG_CREATDORM;
		this.nop = nop;
		this.dormname = dormname;
		this.file = file;
	}
	
	//get the number of dormmates
	public int getNop() {
		return nop;
	}
	
	public String getDormname() {
		return dormname;
	}
	
	public File getFile() {
		return file;
	}
}
