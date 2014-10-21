package com.wisdorm.bmob;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetListener;

import com.wisdorm.base.MytListener;
import com.wisdorm.common.User;
import com.wisdorm.manager.ActivityManager;
import com.wisdorm.manager.AppController;
import com.wisdorm.manager.UserManager;

public class QueryTool {
	
	
	public QueryTool() {
		// TODO Auto-generated constructor stub
	}
	
	
	//query the info of the User in the Bmob and store in the UserManager
	public void queryUserById(String objectId,final MytListener listener) {
		BmobQuery<User> query = new BmobQuery<User>();
		query.getObject(ActivityManager.getInstance().getLoginActivity(),objectId, new GetListener<User>() {
			
			@Override
			public void onSuccess(User user) {
				// TODO Auto-generated method stub
				AppController.getInstance().getUserManager().setUser(user);
				listener.onSuccess();
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				listener.onSuccess();
			}
		});
	}
}
