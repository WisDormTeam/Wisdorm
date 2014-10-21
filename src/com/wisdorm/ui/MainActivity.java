package com.wisdorm.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;

import com.example.wisdorm.R;
import com.wisdorm.ui.fragment.AlarmFragment;
import com.wisdorm.ui.fragment.BaseFragment;
import com.wisdorm.ui.fragment.FragmentAdapter;
import com.wisdorm.ui.fragment.TimeAxisFragment;

public class MainActivity extends FragmentActivity{
	private FragmentAdapter adapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		initFragment();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add:
				adapter.addItem();
			break;

		default:
			break;
		}
		
		return true;
	}
	
	private void initFragment() {
		List<BaseFragment> fragments = new ArrayList<BaseFragment>();
		fragments.add(new TimeAxisFragment());
		fragments.add(new AlarmFragment());
		fragments.add(new TimeAxisFragment());
		
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
		adapter = new FragmentAdapter(this, fragments, R.id.maincontent, radioGroup);
	}
}
