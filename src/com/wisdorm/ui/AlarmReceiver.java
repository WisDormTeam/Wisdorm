package com.wisdorm.ui;

import com.wisdorm.manager.AppController;
import com.wisdorm.ui.fragment.AlarmResponseFragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Toast.makeText(arg0, "时间到了", Toast.LENGTH_LONG).show();
	}

}
