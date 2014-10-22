package com.wisdorm.common.Message;

import com.wisdorm.base.MessageBase;


//*this is my Message which is useless for all you~

public class ContentMessage extends MessageBase{
	private String content = null;
	
	public ContentMessage(String content) {
		// TODO Auto-generated constructor stub
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
