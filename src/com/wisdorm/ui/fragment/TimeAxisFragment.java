package com.wisdorm.ui.fragment;

import com.example.wisdorm.R;
import com.wisdorm.ui.filechooser.FileChooserActivity;

import android.os.Bundle;
import android.app.Fragment;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TimeAxisFragment extends BaseFragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_login, null);
	}

	@Override
	public void addItem() {
		TypeSelectFragment fragment = new TypeSelectFragment();
		fragment.show(getActivity().getFragmentManager(), "type_select");
	}
}
