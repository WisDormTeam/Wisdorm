package com.wisdorm.ui;
/*
 * test here~~~~/
 */

import com.example.wisdorm.R;
import com.example.wisdorm.R.id;
import com.example.wisdorm.R.layout;
import com.wisdorm.base.MytListener;
import com.wisdorm.bmob.DebugTool;
import com.wisdorm.common.LoginListener;
import com.wisdorm.common.Message.LoginMessage;
import com.wisdorm.common.Message.RegisterMessage;
import com.wisdorm.manager.ActivityManager;
import com.wisdorm.manager.AppController;
import com.wisdorm.manager.NetworkManager;

import cn.bmob.v3.Bmob;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class LoginActivity extends Activity {
	
	private static final String TAG_POST = null;
	public EditText emailText, password;
	public Button btn_login,btn_register;
	public CheckBox checkPwd;
	private String email;
	private String pass;
	private ProgressDialog proDialog;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		emailText = (EditText)findViewById(R.id.emailbox);  
		password = (EditText)findViewById(R.id.password);
		btn_login = (Button)findViewById(R.id.login);
		btn_register = (Button)findViewById(R.id.register);
		
		btn_login.setOnClickListener(new LoginClickListener());
		btn_register.setOnClickListener(new RegisterClickListener());
	
		//init Bmob here
		initBmob();
		
		ActivityManager.getInstance().setLoginActivity(this);
		
		//test
		//Intent intent = new Intent(LoginActivity.this, com.wisdorm.ui.MainActivity.class);
		//startActivity(intent);
	}
	
	private void initBmob(){
		Bmob.initialize(this, "81ea98fa1507d9f34639cc0b138770fb");
	}
	
	
	public class LoginClickListener implements View.OnClickListener{
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			email = emailText.getText().toString();
			pass = password.getText().toString();
			if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pass))
			{
				Toast.makeText(LoginActivity.this, "Email and password can't be null",
						Toast.LENGTH_LONG).show();
			}
			proDialog = ProgressDialog.show(LoginActivity.this,"waiting","loading", true, true);   
			
			NetworkManager nm = AppController.getInstance().getNetworkManager();
			nm.send(new LoginMessage(email, pass), new MytListener() {
				
				@Override
				public void onSuccess() {
					// TODO Auto-generated method stub
					Log.v("debug", "login success");
					proDialog.dismiss();
					Toast.makeText(LoginActivity.this, "login success",
					Toast.LENGTH_LONG).show();
					
					if(AppController.getInstance().getUserManager().getUser().getDormId() == null)
					{
						DebugTool.getInstance().log("null!!!!!!");
						Intent intent = new Intent(LoginActivity.this, CreateDormActivity.class);
						startActivity(intent);
					}
					else {
						DebugTool.getInstance().log("dsdsds");
						Intent intent = new Intent(LoginActivity.this, MainActivity.class);
						startActivity(intent);
					}
				}
				
				@Override
				public void onFailure(String failMsg) {
					// TODO Auto-generated method stub
					Log.v("debug", "login failure");
					proDialog.dismiss();
					Toast.makeText(LoginActivity.this, "login failed"+failMsg,
							Toast.LENGTH_LONG).show();
				}
			});
			
		}

	}
	
	
	public class RegisterClickListener implements View.OnClickListener{		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			email = emailText.getText().toString();
			pass = password.getText().toString();
			if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pass))
			{
				Toast.makeText(LoginActivity.this, "Email and password can't be null",
						Toast.LENGTH_LONG).show();
			}
		
			NetworkManager nm = AppController.getInstance().getNetworkManager();
			nm.send(new RegisterMessage(email, pass), new MytListener() {
				
				@Override
				public void onSuccess() {
					// TODO Auto-generated method stub
					Log.v("debug", "register success");
					Toast.makeText(LoginActivity.this, "register success",
							Toast.LENGTH_LONG).show();
					
					Intent intent = new Intent(LoginActivity.this, CreateDormActivity.class);
					startActivity(intent);
				}
				
				@Override
				public void onFailure(String failMsg) {
					// TODO Auto-generated method stub
					Log.v("fail", "register failure" + failMsg);
					Toast.makeText(LoginActivity.this, "×¢²áÊ§°Ü"+failMsg,
							Toast.LENGTH_LONG).show();
					
				}
			});
			
		}

	}

	

}

