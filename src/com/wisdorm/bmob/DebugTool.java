package com.wisdorm.bmob;

import android.util.Log;

public class DebugTool {
		private static DebugTool instance = null;
		

		public static DebugTool getInstance() {
			if(instance==null){
				instance = new DebugTool();
			}
			return instance;
		}
		
		
		//this is the debugLog tool ,before use this you should creat a filters whose tag is "debug";
		public void log(String msg) {
			if (msg==null) {
				Log.d("debug", "this is null");
			}else {
				Log.d("debug", msg);
			}
			
		}
}
