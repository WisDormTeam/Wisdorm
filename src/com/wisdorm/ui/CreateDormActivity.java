package com.wisdorm.ui;

import com.example.wisdorm.R;
import com.example.wisdorm.R.id;
import com.example.wisdorm.R.layout;
import com.example.wisdorm.R.menu;
import com.wisdorm.base.MytListener;
import com.wisdorm.bmob.DebugTool;
import com.wisdorm.common.Message.LoginMessage;
import com.wisdorm.manager.ActivityManager;
import com.wisdorm.manager.AppController;
import com.wisdorm.manager.NetworkManager;
import com.wisdorm.ui.LoginActivity.LoginClickListener;
import com.wisdorm.ui.LoginActivity.RegisterClickListener;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateDormActivity extends Activity {
	
	private Button btn_havedorm;
	private Button btn_createdorm;
	private EditText dormidText;
	private String dormid;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_dorm);

		dormidText = (EditText)findViewById(R.id.dormidText);
		btn_createdorm = (Button)findViewById(R.id.createdorm);
		btn_havedorm = (Button)findViewById(R.id.havedorm);
		
		btn_createdorm.setOnClickListener(new CreateClickListener());
		btn_havedorm.setOnClickListener(new HaveClickListener());
		
		ActivityManager.getInstance().setCreateDormActivity(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_dorm, menu);
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
	
	
	public class CreateClickListener implements OnClickListener
	{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(CreateDormActivity.this, RegisterDormActivity.class);
			startActivity(intent);
			
			
			
		}
		
	}
	
	public class HaveClickListener implements OnClickListener
	{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			dormid = dormidText.getText().toString();
			if(TextUtils.isEmpty(dormid))
			{
				Toast.makeText(CreateDormActivity.this, "dormId can't be empty",
						Toast.LENGTH_LONG).show();
			} else {
				
			}
		}
	}
		
}
