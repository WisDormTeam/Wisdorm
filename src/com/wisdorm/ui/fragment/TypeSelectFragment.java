package com.wisdorm.ui.fragment;

import com.example.wisdorm.R;
import com.wisdorm.ui.AddTextActivity;
import com.wisdorm.ui.filechooser.FileChooserActivity;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TypeSelectFragment extends DialogFragment{
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return new TypeSelectDialog(getActivity());
	}
	
	private class TypeSelectDialog extends Dialog {
		private static final int REQUEST_CODE = 6384;
		
		public TypeSelectDialog(Context context) {
			super(context);
			setContentView(R.layout.type_select);
			setCanceledOnTouchOutside(false);
			//setTitle(STYLE_NO_TITLE);
			
			Button takephoto = (Button)findViewById(R.id.takephoto);
			takephoto.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg0) {
					takePhoto();
					cancel();
				}
			});
			
			Button selectpicture = (Button)findViewById(R.id.selectpicture);
			selectpicture.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg0) {
					selectPicture();
					cancel();
				}
			});
			
			Button text = (Button)findViewById(R.id.text);
			text.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg0) {
					addText();
					cancel();
				}
			});
		}
		
		private void takePhoto() {
		}
		
		private void selectPicture() {
			Intent intent = new Intent(getActivity(), FileChooserActivity.class);
			getActivity().startActivityForResult(intent, REQUEST_CODE);
		}
		
		private void addText() {
			Intent intent = new Intent(getActivity(), AddTextActivity.class);
			getActivity().startActivityForResult(intent, REQUEST_CODE);
		}
	}
}




