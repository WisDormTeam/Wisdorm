package com.wisdorm.ui.fragment;

import com.example.wisdorm.R;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlarmResponseFragment extends DialogFragment{
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return new AlarmResponseDialog(getActivity());
	}
	
	
	@SuppressWarnings("unused")
	private class AlarmResponseDialog extends Dialog {
		private MediaPlayer mMediaPlayer;
		
		public AlarmResponseDialog(Context context) {
			super(context);
		}
		
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.alarm_response);
			playMusic();
			
			Button confirm = (Button)findViewById(R.id.confirm);
			confirm.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg0) {
					cancel();
				}
			});
		}
		
		private void playMusic() {
			mMediaPlayer = MediaPlayer.create(getContext(), R.raw.response);
			mMediaPlayer.start();
		}
		
		@Override
		protected void onStop () {
			if(mMediaPlayer != null)
				mMediaPlayer.stop();
		}
	}
}
