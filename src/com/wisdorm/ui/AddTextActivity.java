package com.wisdorm.ui;

import com.example.wisdorm.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class AddTextActivity extends Activity{
	private EditText editText = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_text);
		editText = (EditText)findViewById(R.id.editText);
	}
}
