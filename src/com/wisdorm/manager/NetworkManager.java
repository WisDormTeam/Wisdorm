package com.wisdorm.manager;

import cn.bmob.v3.listener.SaveListener;

import com.wisdorm.activity.LoginActivity;
import com.wisdorm.base.MessageBase;
import com.wisdorm.base.MytListener;
import com.wisdorm.common.User;
import com.wisdorm.common.Message.LoginMessage;
import com.wisdorm.common.Message.RegisterMessage;

public class NetworkManager {
	
	private User user = null;
	
	
	public NetworkManager() {
	}
	
	public void send(MessageBase msgBase,MytListener listener){
		int type = msgBase.getMessageType();
		switch (type) {
		case MessageBase.MSG_LOGIN:
			login((LoginMessage)msgBase,listener);
			break;
		case MessageBase.MSG_REGISTER:
			register((RegisterMessage)msgBase, listener);
			break;
		case MessageBase.MSG_ERROR:
				break;
		default:
			break;
		}
	}
	
	private void login(LoginMessage msg,MytListener listener) {
	}
	
	private void register(RegisterMessage msg,final MytListener listener){
		user = new User();
		user.setUsername(msg.getUsername());
		user.setEmail(msg.getEmail());
		user.setPassword(msg.getPassword());
		user.signUp(ActivityManager.getInstance().getLoginActivity(), new SaveListener() {
			
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
}
