package com.wisdorm.manager;

import cn.bmob.v3.datatype.BmobRelation;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

import com.wisdorm.base.MessageBase;
import com.wisdorm.base.MytListener;
import com.wisdorm.bmob.DebugTool;
import com.wisdorm.common.Dorm;
import com.wisdorm.common.User;
import com.wisdorm.common.Message.AttendDormMessage;
import com.wisdorm.common.Message.CreatDormMessage;
import com.wisdorm.common.Message.LoginMessage;
import com.wisdorm.common.Message.QueryDormMessage;
import com.wisdorm.common.Message.RegisterMessage;

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
			register((RegisterMessage)msgBase, listener);
			break;
		case MessageBase.MSG_CREATDORM:
			createDorm((CreatDormMessage)msgBase, listener);
			break;
		case MessageBase.MSG_ATTENDDORM:
			attendDorm((AttendDormMessage)msgBase, listener);
			break;
		case MessageBase.MSG_QUERYDORM:
			QueryDorm((QueryDormMessage)msgBase,listener);
			break;
		case MessageBase.MSG_ERROR:
			break;
		}
	}
	
	private void QueryDorm(QueryDormMessage msg, MytListener listener) {
		// TODO Auto-generated method stub
		final String dormId = msg.getDormId();
		final UserManager um = AppController.getInstance().getUserManager();
		um.getNetworkTool().queryDormById(dormId,listener);
	}

	private void attendDorm(AttendDormMessage msg, final MytListener listener) {
		final UserManager um = AppController.getInstance().getUserManager();
		final Dorm dorm = um.getDorm();
		final User user = um.getUser();
		dorm.getDormMates().add(user);
		dorm.update(ActivityManager.getInstance().getCreateDormActivity(),dorm.getObjectId(),new UpdateListener() {
			
			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				user.setDorm(dorm);
				user.update(ActivityManager.getInstance().getAttendDormActivity(), new UpdateListener() {
					
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
			
			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}
		});
				

	}

	private void login(LoginMessage msg,final MytListener listener) {
		
		final UserManager um = AppController.getInstance().getUserManager();
		final User user =um.getUser();
		
		user.setUsername(msg.getUsername());
		user.setPassword(msg.getPassword());
		
		user.login(ActivityManager.getInstance().getLoginActivity(), new SaveListener() {
			@Override
			public void onSuccess() {
				um.getNetworkTool().queryUserById(user.getObjectId(),listener);
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
				um.getNetworkTool().queryUserById(user.getObjectId(),listener);
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
		final Dorm dorm = new Dorm();
		
		dorm.setCount(msg.getNop());
		dorm.setDormName(msg.getDormname());
		
		dorm.save(ActivityManager.getInstance().getRegisterDormActivity(), new SaveListener() {
			@Override
			public void onSuccess() {
				AppController.getInstance().getUserManager().setDorm(dorm);
				um.getNetworkTool().addDormmate(dorm.getObjectId(), um.getUser(), listener);
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				
				listener.onFailure(arg1);
			}
		});
	}
}
