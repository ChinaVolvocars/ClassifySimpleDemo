package com.example.demo.adapter;

import com.example.demo.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ClassifyMoreAdapter extends BaseAdapter {

	private Context context;
	private String[] text_list;
	private int position = 0;
	Holder hold;

	public ClassifyMoreAdapter(Context context, String[] text_list) {
		this.context = context;
		this.text_list = text_list;
	}

	public int getCount() {
		return text_list.length;
	}

	public Object getItem(int position) {
		return text_list[position];
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int arg0, View view, ViewGroup viewGroup) {

		if (view == null) {
			view = View.inflate(context, R.layout.item_classify_morelist, null);
			hold = new Holder(view);
			view.setTag(hold);
		} else {
			hold = (Holder) view.getTag();
		}
		hold.txt.setText(text_list[arg0]);
		hold.txt.setTextColor(0xFF666666);
		if (arg0 == position) {
			hold.txt.setTextColor(0xFFFF8C00);
		}
		return view;
	}

	public void setSelectItem(int position) {
		this.position = position;
	}

	private static class Holder {
		TextView txt;

		public Holder(View view) {
			txt = (TextView) view.findViewById(R.id.moreitem_txt);
		}
	}
}
