package com.wisdorm.manager;

import java.util.Iterator;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.datatype.BmobRelation;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

import com.wisdorm.base.MessageBase;
import com.wisdorm.base.MytListener;
import com.wisdorm.bmob.DebugTool;
import com.wisdorm.common.Dorm;
import com.wisdorm.common.LoginListener;
import com.wisdorm.common.User;
import com.wisdorm.common.Message.AlarmOffMessage;
import com.wisdorm.common.Message.AlarmOnMessage;
import com.wisdorm.common.Message.AttendDormMessage;
import com.wisdorm.common.Message.CreatDormMessage;
import com.wisdorm.common.Message.LoginMessage;
import com.wisdorm.common.Message.QueryAlarmMessage;
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
		case MessageBase.MSG_ALARM_OFF:
			alarmOff((AlarmOffMessage)msgBase,listener);
			break;
		case MessageBase.MSG_AlARM_ON:
			alarmOn((AlarmOnMessage)msgBase,listener);
			break;
		case MessageBase.MSG_CREATALARM:
			break;
		case MessageBase.MSG_LISTENALARM:
			break;
		case MessageBase.MSG_PULLALARMS:
			break;
		case MessageBase.MSG_REMOVEALARM:
			break;
		case MessageBase.MSG_UPDATEALARM:
			break;
		case MessageBase.MSG_QUERYALARM:
			queryAlarm((QueryAlarmMessage)msgBase,listener);
			break;
		case MessageBase.MSG_ERROR:
			break;
		}
	}
	
	private void queryAlarm(QueryAlarmMessage msg,final MytListener listener) {
		// TODO Auto-generated method stub
		BmobQuery<User> query = new BmobQuery<User>();
		User user = AppController.getInstance().getUserManager().getUser();
		query.getObject(ActivityManager.getInstance().getCreateDormActivity(),user.getObjectId(), new GetListener<User>() {
			
			@Override
			public void onSuccess(User user) {
				AppController.getInstance().getUserManager().setUser(user);
				if(listener!=null){
					listener.onSuccess();
				}
				
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				if (listener!=null) {
					listener.onFailure(arg1);
				}
			}
		});
	}

	private void alarmOn(AlarmOnMessage msg, final MytListener listener) {
		// TODO Auto-generated method stub
		User user = AppController.getInstance().getUserManager().getUser();
		user.setAlarmon(true);
		user.update(ActivityManager.getInstance().getMainActivity(), user.getObjectId(), new UpdateListener() {
			
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

	private void alarmOff(AlarmOffMessage msg, final MytListener listener) {
		// TODO Auto-generated method stub
		final UserManager um = AppController.getInstance().getUserManager();
		
		um.getNetworkTool().queryDormById(AppController.getInstance().getUserManager().getDorm().getObjectId(), new MytListener() {
			
			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				Dorm dorm = AppController.getInstance().getUserManager().getDorm();
				BmobQuery<User> dormmates = new BmobQuery<User>();
				dormmates.addWhereRelatedTo("dormmates", new BmobPointer(dorm));
				dormmates.findObjects(ActivityManager.getInstance().getMainActivity(), new FindListener<User>() {
					
					@Override
					public void onSuccess(List<User> users) {
						// TODO Auto-generated method stub
						for (User user: users) {
			               if(user.getAlarmon()){
			            	   user.setAlarmon(false);
			            	   user.update(ActivityManager.getInstance().getMainActivity(), new UpdateListener() {
								
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
					}
					
					@Override
					public void onError(int arg0, String arg1) {
						// TODO Auto-generated method stub
						
					}
				});
				
			}
			
			@Override
			public void onFailure(String failMsg) {
				// TODO Auto-generated method stub
				
			}
		});
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
		dorm.update(ActivityManager.getInstance().getAttendDormActivity(),dorm.getObjectId(),new UpdateListener() {
			
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
		final User user = new User();
		
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
