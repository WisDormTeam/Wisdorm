package com.wisdorm.ui;

import com.example.wisdorm.R;
import com.example.wisdorm.R.id;
import com.example.wisdorm.R.layout;
import com.example.wisdorm.R.menu;
import com.wisdorm.base.MytListener;
import com.wisdorm.common.Dorm;
import com.wisdorm.common.Message.AttendDormMessage;
import com.wisdorm.common.Message.CreatDormMessage;
import com.wisdorm.manager.ActivityManager;
import com.wisdorm.manager.AppController;
import com.wisdorm.manager.NetworkManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AttendDormActivity extends Activity {
	
	private Button btn_confirm;
	private Dorm dorm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attend_dorm);
		
		btn_confirm = (Button)findViewById(R.id.confirm);
		btn_confirm.setOnClickListener(new ConfirmClickListener());
		dorm = AppController.getInstance().getUserManager().getUser().getDorm();
		
		ActivityManager.getInstance().setAttendDormActivity(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.attend_dorm, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public class ConfirmClickListener implements OnClickListener
	{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			 NetworkManager nm = AppController.getInstance().getNetworkManager();
		     nm.send(new AttendDormMessage(dorm.getObjectId()), new MytListener() {
				
				@Override
				public void onSuccess() {
					// TODO Auto-generated method stub
					Toast.makeText(AttendDormActivity.this, "Attend dorm success",
							Toast.LENGTH_LONG).show();
					Intent intent = new Intent(AttendDormActivity.this,MainActivity.class);
				    startActivity(intent);
				}
				
				@Override
				public void onFailure(String failMsg) {
					// TODO Auto-generated method stub
					Toast.makeText(AttendDormActivity.this, failMsg,
							Toast.LENGTH_LONG).show();
					
				}
			});
		}		
	}
}
