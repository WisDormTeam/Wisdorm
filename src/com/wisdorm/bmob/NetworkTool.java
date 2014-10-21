package com.wisdorm.bmob;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobRelation;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetListener;
import cn.bmob.v3.listener.UpdateListener;

import com.wisdorm.base.MytListener;
import com.wisdorm.common.Dorm;
import com.wisdorm.common.User;
import com.wisdorm.manager.ActivityManager;
import com.wisdorm.manager.AppController;
import com.wisdorm.manager.UserManager;

public class NetworkTool {
	
	
	public NetworkTool() {
		// TODO Auto-generated constructor stub
	}
	
	public void attachDorm(String userId,Dorm dorm,final MytListener listener) {
		User user = AppController.getInstance().getUserManager().getUser();
		user.setDorm(dorm);
		user.update(ActivityManager.getInstance().getCreateDormActivity(),userId, new UpdateListener() {
			
			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				listener.onSuccess();
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				listener.onFailure(arg1);
			}
		});
	}
	
	public void addDormmate(String dormId,final User user,final MytListener listener) {
		final Dorm dorm = AppController.getInstance().getUserManager().getDorm();
		BmobRelation users = new BmobRelation();
		users.add(user);
		dorm.setDormMates(users);
		dorm.update(ActivityManager.getInstance().getCreateDormActivity(),dormId, new UpdateListener() {
			
			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				attachDorm(user.getObjectId(), dorm, listener);
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				listener.onFailure(arg1);
			}
		});
	}
	
	
	//query the info of the User in the Bmob and store in the UserManager
	public void queryUserById(String objectId,final MytListener listener) {
		BmobQuery<User> query = new BmobQuery<User>();
		query.getObject(ActivityManager.getInstance().getLoginActivity(),objectId, new GetListener<User>() {
			
			@Override
			public void onSuccess(User user) {
				// TODO Auto-generated method stub
				
				AppController.getInstance().getUserManager().setUser(user);
				AppController.getInstance().getUserManager().setDorm(user.getDorm());
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
