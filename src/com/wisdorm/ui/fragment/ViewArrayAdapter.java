package com.wisdorm.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ViewArrayAdapter extends ArrayAdapter<View> {
	private int mResource;
	private List<View> mViews;
	
	public ViewArrayAdapter(Context context, int r, List<View> views) {
		super(context, r, views);
		this.mResource =  r;
		this.mViews = new ArrayList<View>();
		this.mViews = views;
	}
	
	@Override
	public View getView(int position, View v, ViewGroup parent)
	{
		if(position < 0 || position >= mViews.size())
			return null;
		
		return mViews.get(position);
	}
}
