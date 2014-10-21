package com.wisdorm.ui;

import com.example.wisdorm.R;
import com.example.wisdorm.R.id;
import com.example.wisdorm.R.layout;
import com.example.wisdorm.R.menu;
import com.wisdorm.manager.ActivityManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AttendDormActivity extends Activity {
	
	private Button btn_confirm;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attend_dorm);
		
		btn_confirm = (Button)findViewById(R.id.confirm);
		btn_confirm.setOnClickListener(new ConfirmClickListener());
		
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
			Intent intent = new Intent(AttendDormActivity.this,MainActivity.class);
			startActivity(intent);
			
		}		
	}
}
