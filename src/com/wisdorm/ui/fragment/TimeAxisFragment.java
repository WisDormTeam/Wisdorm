package com.wisdorm.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.wisdorm.R;
import com.wisdorm.base.MytListener;
import com.wisdorm.common.Message.AlarmOffMessage;
import com.wisdorm.manager.AppController;
import com.wisdorm.manager.NetworkManager;

public class TimeAxisFragment extends BaseFragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//return inflater.inflate(R.layout.fragment_login, null);
		View view =inflater.inflate(R.layout.fragment_login, null);
		Button button = (Button)view.findViewById(R.id.turnoff);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				turnOffAlarm();
				
			}
		});
		
		return view;
	}

	@Override
	public void addItem() {
		TypeSelectFragment fragment = new TypeSelectFragment();
		fragment.show(getActivity().getFragmentManager(), "type_select");
	}
	
	private void turnOffAlarm() {
		AlarmOffMessage msg = new AlarmOffMessage();
		NetworkManager manager = AppController.getInstance().getNetworkManager();
		manager.send(msg, new MytListener() {
			@Override
			public void onSuccess() {
				Toast.makeText(getActivity(), "拍飞舍友闹钟！", Toast.LENGTH_LONG).show();
			}
			
			@Override
			public void onFailure(String failMsg) {
			}
		});
	}
}
