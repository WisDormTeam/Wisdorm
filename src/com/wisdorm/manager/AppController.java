package com.wisdorm.manager;


public class AppController {
	private static AppController instance = null;
	
	//managers or controllers
	private NetworkManager networkManager= null;
	private UserManager userManager = null;
	
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
	}
	
	public NetworkManager getNetworkManager() {
		return networkManager;
	}
	
	public UserManager getUserManager() {
		return userManager;
	}
}
