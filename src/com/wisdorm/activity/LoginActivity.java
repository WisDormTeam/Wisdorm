package com.wisdorm.activity;
/*
 * test here~~~~/
 */
import com.example.wisdorm.R;
import com.example.wisdorm.R.id;
import com.example.wisdorm.R.layout;
import com.wisdorm.base.MytListener;
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
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		
		//init Bmob here
		initBmob();
		
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		
		ActivityManager.getInstance().setLoginActivity(this);
		
		//test
		Intent intent = new Intent(LoginActivity.this, com.wisdorm.ui.MainActivity.class);
		startActivity(intent);
	}
	
	private void initBmob(){
		Bmob.initialize(this, "81ea98fa1507d9f34639cc0b138770fb");
	}

	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_login,
					container, false);
			return rootView;
		}
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
			Button login = (Button) getActivity().findViewById(R.id.login);
			login.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Log.d("bmob", "Test Register");
					NetworkManager nm = AppController.getInstance().getNetworkManager();
					nm.send(new RegisterMessage("CBUU","407471516@qq.com","123456"),new MytListener() {
						
						@Override
						public void onSuccess() {
							// TODO Auto-generated method stub
							Log.d("bmob", "Register succeed");
						}
						
						@Override
						public void onFailure(String failMsg) {
							// TODO Auto-generated method stub
							Log.d("bmob", failMsg);
						}
					});
				}
			});
		}
	}

}
