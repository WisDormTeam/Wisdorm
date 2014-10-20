package com.wisdorm.bmob;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

import com.wisdorm.common.User;
import com.wisdorm.manager.ActivityManager;
import com.wisdorm.manager.AppController;
import com.wisdorm.manager.UserManager;

public class QueryTool {
	
	
	public QueryTool() {
		// TODO Auto-generated constructor stub
	}
	
	
	//query the info of the User in the Bmob and store in the UserManager
	public void queryUser(String username) {
		BmobQuery<User> query = new BmobQuery<User>();
		query.addWhereEqualTo("username", username);
		query.findObjects(ActivityManager.getInstance().getLoginActivity(), new FindListener<User>() {
		    @Override
		    public void onSuccess(List<User> object) {
		        // TODO Auto-generated method stub
		    	User user = object.get(0);
		    	AppController.getInstance().getUserManager().setUser(user);
		    }
		    @Override
		    public void onError(int code, String msg) {
		        // TODO Auto-generated method stub
		    	DebugTool.getInstance().log(msg);
		    }
		});
		
		
	}
}
