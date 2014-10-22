package com.wisdorm.ui;

import com.wisdorm.manager.AlarmCenter;
import com.wisdorm.manager.AppController;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver{
	
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Intent intent = new Intent(arg0, AlarmAlertActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_NO_USER_ACTION);
		Bundle alarmInfo = arg1.getBundleExtra(AlarmCenter.ALARM_INFO);
		intent.putExtra(AlarmCenter.ALARM_INFO, alarmInfo);
		arg0.startActivity(intent);
	}
}
