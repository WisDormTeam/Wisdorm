package com.wisdorm.manager;


public class AppController {
	private static AppController instance = null;
	
	//managers or controllers
	private NetworkManager networkManager= null;
	private UserManager userManager = null;
	private AlarmCenter alarmManager = null;
	
	public static AppController getInstance() {
		if(instance == null){
			instance = new AppController();
		}
		return instance;
	}
	 
	private AppController(){
		init();
	}
	
	//initialize managers or controllers here
	public void init() {
		networkManager = new NetworkManager();
		userManager = new UserManager();
		alarmManager = new AlarmCenter();
		
	}
	
	public NetworkManager getNetworkManager() {
		return networkManager;
	}
	
	public UserManager getUserManager() {
		return userManager;
	}
	
	public AlarmCenter getAlarmCenter() {
		return alarmManager;
	}
}
