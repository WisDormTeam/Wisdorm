package com.wisdorm.ui;

import com.example.wisdorm.R;
import com.wisdorm.common.Alarm;
import com.wisdorm.manager.AlarmCenter;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AlarmAlertActivity extends Activity{
	private MediaPlayer mMediaPlayer  = null;
	private Button mButton = null;
	private TextView mTime = null;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alarm_alert);
		setFinishOnTouchOutside(false);
		
		mButton = (Button)findViewById(R.id.confirm);
		mButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				stopMusic();
				finish();	
			}
		});
		
		mTime = (TextView)findViewById(R.id.time);
		Bundle bundle = getIntent().getBundleExtra(AlarmCenter.ALARM_INFO);
		String formatTIme = bundle.getString(Alarm.FORMATTIME_KEY);
		if(formatTIme != null)
			mTime.setText(formatTIme);
		playMusic();
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
	
	//每隔10秒访问网络
	private void 
}
