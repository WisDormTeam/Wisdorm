package com.wisdorm.ui.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public class AlarmPickerFragment extends DialogFragment{
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return new TimePickerDialog(getActivity());
	}
}
