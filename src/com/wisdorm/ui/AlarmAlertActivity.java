package com.wisdorm.ui;

import com.example.wisdorm.R;
import com.wisdorm.base.MytListener;
import com.wisdorm.common.Alarm;
import com.wisdorm.common.Message.AlarmOffMessage;
import com.wisdorm.common.Message.AlarmOnMessage;
import com.wisdorm.common.Message.QueryAlarmMessage;
import com.wisdorm.manager.AlarmCenter;
import com.wisdorm.manager.AppController;
import com.wisdorm.manager.NetworkManager;
import com.wisdorm.manager.UserManager;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AlarmAlertActivity extends Activity{
	private final static int VISIT_TIME = 600;
	private final static long VISIT_INTERVEL = 1000;
	private int mCurVisitTIme = 0;
	
	private MediaPlayer mMediaPlayer  = null;
	private Button mButton = null;
	private TextView mTime = null;
	private VisitNetworkTimer mTimer = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alarm_alert);
		setFinishOnTouchOutside(false);
		
		mButton = (Button)findViewById(R.id.confirm);
		mButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				stopAlert();
			}
		});
		
		mTime = (TextView)findViewById(R.id.time);
		Bundle bundle = getIntent().getBundleExtra(AlarmCenter.ALARM_INFO);
		String formatTIme = bundle.getString(Alarm.FORMATTIME_KEY);
		if(formatTIme != null)
			mTime.setText(formatTIme);
		playMusic();
		
		//toast the network alarmOn;
		toastAlarmOn();
	}
	
	
	private void playMusic() {
		mMediaPlayer = MediaPlayer.create(this, R.raw.response);
		mMediaPlayer.start();
	}
	
	private void stopMusic() {
		if(mMediaPlayer != null) {
			mMediaPlayer.stop();
			mMediaPlayer = null;
		}
	}
	
	private void cancelTimer() {
		if(mTimer != null)
			mTimer.cancel();
	}
	
	private void stopAlert() {
		stopMusic();
		cancelTimer();
		finish();	
	}
	
	private void toastAlarmOn() {
		AlarmOnMessage msg = new AlarmOnMessage();
		NetworkManager manager = AppController.getInstance().getNetworkManager();
		manager.send(msg, new MytListener() {
			
			@Override
			public void onSuccess() {
				Toast.makeText(AlarmAlertActivity.this, "告知服务器Alarm On", Toast.LENGTH_LONG).show();
				visitNetworkRepeatedly();
			}
			
			@Override
			public void onFailure(String failMsg) {
				Toast.makeText(AlarmAlertActivity.this, failMsg, Toast.LENGTH_LONG).show();
			}
		});
	}
	
	private void visitNetworkRepeatedly() {
		mTimer = new VisitNetworkTimer(VISIT_INTERVEL, 1000);
		mTimer.start();
	}
	
	private class VisitNetworkTimer extends CountDownTimer {

		public VisitNetworkTimer(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		@Override
		public void onFinish() {
			if(mCurVisitTIme > VISIT_TIME)
				stopAlert();
			else {
				checkAlarmOff();
			}
		}

		@Override
		public void onTick(long arg0) {
		}
		
		private void checkAlarmOff() {
			QueryAlarmMessage msg = new QueryAlarmMessage();
			NetworkManager manger = AppController.getInstance().getNetworkManager();
			manger.send(msg, new MytListener() {
				@Override
				public void onSuccess() {
					UserManager userManager = AppController.getInstance().getUserManager();
					if(userManager.getUser().getAlarmon() == false) {
						Toast.makeText(AlarmAlertActivity.this, "闹钟被关闭", Toast.LENGTH_LONG).show();
						stopAlert();
					}
					else {
						Toast.makeText(AlarmAlertActivity.this, "闹钟还没有被关闭", Toast.LENGTH_LONG).show();
						start();
					}
				}
				
				@Override
				public void onFailure(String failMsg) {
					Toast.makeText(AlarmAlertActivity.this, failMsg, Toast.LENGTH_LONG).show();
					start();
				}
			});
		}
	}
}
