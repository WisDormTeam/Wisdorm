package com.wisdorm.common;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Item extends BmobObject{
	private String text = null;
	private String publisher = null;
	private BmobFile pic = null;
	private BmobFile video = null;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public String getText() {
		return text;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public BmobFile getPic() {
		return pic;
	}
	
	public BmobFile getVideo() {
		return video;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public void setPic(BmobFile pic) {
		this.pic = pic;
	}
	
	public void setVideo(BmobFile video) {
		this.video = video;
	}
}
