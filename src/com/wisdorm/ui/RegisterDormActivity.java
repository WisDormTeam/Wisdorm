package com.wisdorm.ui;

import com.example.wisdorm.R;
import com.example.wisdorm.R.id;
import com.example.wisdorm.R.layout;
import com.example.wisdorm.R.menu;
import com.wisdorm.base.MytListener;
import com.wisdorm.common.Message.CreatDormMessage;
import com.wisdorm.manager.ActivityManager;
import com.wisdorm.manager.AppController;
import com.wisdorm.manager.NetworkManager;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterDormActivity extends Activity {
	
	private String name;
	int nop;
	private Button btn_ok;
	private EditText dormnop;
	private EditText dormname;
	private Image headImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_dorm);
		
		btn_ok =(Button)findViewById(R.id.ok);
		dormnop = (EditText)findViewById(R.id.dormnop);
		dormname = (EditText)findViewById(R.id.dormname);
		headImage = null;
		
		btn_ok.setOnClickListener(new RegisterClickListener());
		
		ActivityManager.getInstance().setRegisterDormActivity(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register_dorm, menu);
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
	
	public class RegisterClickListener implements OnClickListener
	{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			name = dormname.getText().toString();
			if(TextUtils.isEmpty(name) || TextUtils.isEmpty(dormnop.getText().toString()))
			{
				Toast.makeText(RegisterDormActivity.this, "name and nop can't be null",
						Toast.LENGTH_LONG).show();
			} else {
			    try{
		             nop=Integer.parseInt(dormnop.getText().toString());
		            	//data=myEditText.getText();
		            }catch (Exception e){
		        	    e.printStackTrace();
		            }
		        NetworkManager nm = AppController.getInstance().getNetworkManager();
		        if(headImage == null)
		        {
		        nm.send(new CreatDormMessage(name,nop), new MytListener() {
				
				    @Override
				    public void onSuccess() {
					    // TODO Auto-generated method stub
					    Toast.makeText(RegisterDormActivity.this, "success",
						    	Toast.LENGTH_LONG).show();
					    Intent intent = new Intent(RegisterDormActivity.this,MainActivity.class);
					    startActivity(intent);
				    }
		  
				
				@Override
				public void onFailure(String failMsg) {
					// TODO Auto-generated method stub
					Toast.makeText(RegisterDormActivity.this, "fail",
							Toast.LENGTH_LONG).show();
					
				}
			});
		   }
	     }
	  }
	}
}
