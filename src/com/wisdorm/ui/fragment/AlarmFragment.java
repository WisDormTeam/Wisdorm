package com.wisdorm.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.wisdorm.R;
import com.wisdorm.common.Alarm;
import com.wisdorm.manager.AppController;
import com.wisdorm.ui.AlarmListItem;

import android.R.anim;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AlarmFragment extends BaseFragment  {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ListView listView = (ListView) inflater.inflate(R.layout.alarm_fragment, null);
		
		List views = new ArrayList<View>();
		
		ViewArrayAdapter adapter = new ViewArrayAdapter(getActivity(), 
				R.layout.alarm_item, views);
		AppController.getInstance().getAlarmCenter().setAdapter(adapter);
		
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new ItemClickListener());
		return listView; 
	}

	private class ItemClickListener implements AdapterView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long id) {
		}
	}
	
	@Override
	public void addItem() {
		AlarmPickerFragment fragment = new AlarmPickerFragment();
		fragment.show(getActivity().getFragmentManager(), "alarm_picker");
	}
}
