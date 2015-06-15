package com.example.vjezbaa6_1.adapters;

import java.util.ArrayList;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CityAdapter extends BaseAdapter{
	Context context;
	ArrayList<String> citylist;
	
	public CityAdapter(Context context, ArrayList<String> cityList) {
		super();
		this.context = context;
		this.citylist = cityList;
	}


	@Override
	public int getCount() {
		return citylist.size();
	}

	@Override
	public Object getItem(int position) {
		return citylist.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

		
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		
		if (v == null){
			LayoutInflater li = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
			v  =li.inflate(com.example.vjezbaa6_1.R.layout.support_simple_spinner_dropdown_item, null);
		}		

		return v;
	}


	public void add(String city) {
		// TODO Auto-generated method stub
		
	}
	
}
