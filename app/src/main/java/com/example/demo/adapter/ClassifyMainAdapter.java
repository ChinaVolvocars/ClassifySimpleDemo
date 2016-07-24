package com.example.demo.adapter;

import java.util.List;
import java.util.Map;

import com.example.demo.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ClassifyMainAdapter extends BaseAdapter {

	private Context context;
	private List<Map<String, Object>> list;
	private int position = 0;
	private boolean islodingimg = true;
	Holder hold;

	public ClassifyMainAdapter(Context context, List<Map<String, Object>> list) {
		this.context = context;
		this.list = list;
	}

	public ClassifyMainAdapter(Context context, List<Map<String, Object>> list,
			boolean islodingimg) {
		this.context = context;
		this.list = list;
		this.islodingimg = islodingimg;
	}

	public int getCount() {
		return list.size();
	}

	public Object getItem(int position) {
		return list.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int arg0, View view, ViewGroup viewGroup) {

		if (view == null) {
			view = View.inflate(context, R.layout.item_classify_mainlist, null);
			hold = new Holder(view);
			view.setTag(hold);
		} else {
			hold = (Holder) view.getTag();
		}
		if (islodingimg == true) {
			hold.img.setImageResource(Integer.parseInt(list.get(arg0)
					.get("img").toString()));
		}
		hold.txt.setText(list.get(arg0).get("txt").toString());
		hold.layout.setBackgroundColor(0xFFEBEBEB);
		if (arg0 == position) {
			hold.layout.setBackgroundColor(0xFFFFFFFF);
		}
		return view;
	}

	public void setSelectItem(int position) {
		this.position = position;
	}

	public int getSelectItem() {
		return position;
	}

	private static class Holder {
		LinearLayout layout;
		ImageView img;
		TextView txt;

		public Holder(View view) {
			txt = (TextView) view.findViewById(R.id.mainitem_txt);
			img = (ImageView) view.findViewById(R.id.mainitem_img);
			layout = (LinearLayout) view.findViewById(R.id.mainitem_layout);
		}
	}
}
