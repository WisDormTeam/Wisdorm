package com.wisdorm.manager;

import android.util.Log;
import cn.bmob.v3.listener.SaveListener;

import com.wisdorm.base.MessageBase;
import com.wisdorm.base.MytListener;
import com.wisdorm.bmob.DebugTool;
import com.wisdorm.bmob.QueryTool;
import com.wisdorm.common.Dorm;
import com.wisdorm.common.User;
import com.wisdorm.common.Message.CreatDormMessage;
import com.wisdorm.common.Message.LoginMessage;
import com.wisdorm.common.Message.RegisterMessage;
import com.wisdorm.ui.LoginActivity;

public class NetworkManager {
	
	public NetworkManager() {
	}
	
	public void send(MessageBase msgBase,MytListener listener){
		int type = msgBase.getMessageType();
		switch (type) {
		case MessageBase.MSG_LOGIN:
			login((LoginMessage)msgBase,listener);
			break;
		case MessageBase.MSG_REGISTER:
			//register((RegisterMessage)msgBase, listener);
			login(new LoginMessage("", ""),listener);
			break;
		
		case MessageBase.MSG_CREATDORM:
			
			break;
		case MessageBase.MSG_ERROR:
			break;
		}
	}
	
	private void login(LoginMessage msg,final MytListener listener) {
		
		final UserManager um = AppController.getInstance().getUserManager();
		final User user =um.getUser();
		final String username = msg.getUsername();
		
		user.setUsername("CBUU");
		user.setPassword("123456");
		
		user.login(ActivityManager.getInstance().getLoginActivity(), new SaveListener() {
			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				//um.getQueryTool().queryUser("CBUU");
				//DebugTool.getInstance().log(AppController.getInstance().getUserManager().getUser().getNickname());
				um.getQueryTool().queryUserById(user.getObjectId(),listener);
				
				//DebugTool.getInstance().log(user.getObjectId());
				
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				listener.onFailure(arg1);
			}
		});
	}
	
	private void register(RegisterMessage msg,final MytListener listener){
		final UserManager um = AppController.getInstance().getUserManager();
		final User user = new User();
		user.setUsername(msg.getEmail());
		user.setEmail(msg.getEmail());
		user.setPassword(msg.getPassword());
		user.signUp(ActivityManager.getInstance().getLoginActivity(), new SaveListener() {
			
			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				um.getQueryTool().queryUserById(user.getObjectId(),listener);
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				listener.onFailure(arg1);
			}
		});
	}

	private void createDorm(CreatDormMessage msg,final MytListener listener){
		final UserManager um = AppController.getInstance().getUserManager();
		Dorm dorm = new Dorm();
		dorm.setCount(msg.getNop());
		dorm.setDormName(msg.getDormname());
		dorm.save(ActivityManager.getInstance().getLoginActivity(), new SaveListener() {
			
			@Override
			public void onSuccess() {
				
				listener.onSuccess();
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				listener.onFailure(arg1);
			}
		});
	}
}
