package com.wisdorm.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.wisdorm.R;

import android.R.anim;
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
	String[] presidents = {
	          "Dwight D. Eisenhower",
	          "John F. Kennedy",
	          "Lyndon B. Johnson",
	          "Richard Nixon",
	          "Gerald Ford",
	          "Jimmy Carter",
	          "Ronald Reagan",
	          "George H. W. Bush",
	          "Bill Clinton",
	          "George W. Bush",
	          "Barack Obama",
	          "Jimmy Carter",
	          "Ronald Reagan",
	          "George H. W. Bush",
	          "Bill Clinton",
	          "George W. Bush",
	          "Barack Obama"
	     };
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ListView listView = (ListView) inflater.inflate(R.layout.alarm_fragment, null);
		
//		List views = new ArrayList<View>();
//		for(int i = 0; i < 5; i++) {
//			View view = inflater.inflate(R.layout.alarm_item, null);
//			views.add(view);
//		}
		
		listView.setAdapter(new ArrayAdapter<String>(getActivity(), 
				android.R.layout.simple_list_item_1, presidents));
		
		listView.setOnItemClickListener(new ItemClickListener());
		return listView; 
	}

	private class ItemClickListener implements AdapterView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long id) {
//			Toast.makeText(getActivity(),
//					"You have selected " + presidents[position],
//					Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	public void addItem() {
		Toast.makeText(getActivity(), "In alarm", Toast.LENGTH_LONG).show();
	}
}
