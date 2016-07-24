package com.example.demo.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.demo.Model;
import com.example.demo.R;
import com.example.demo.adapter.ClassifyMainAdapter;
import com.example.demo.adapter.ClassifyMoreAdapter;

public class ListListActivity extends Activity {

	private ListView mainlist;
	private ListView morelist;
	private List<Map<String, Object>> mainList;
	ClassifyMainAdapter mainAdapter;
	ClassifyMoreAdapter moreAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classify);
		initModle();
		initView();
	}

	private void initView() {
		mainlist = (ListView) findViewById(R.id.classify_mainlist);
		morelist = (ListView) findViewById(R.id.classify_morelist);
		mainAdapter = new ClassifyMainAdapter(ListListActivity.this, mainList);
		mainAdapter.setSelectItem(0);
		mainlist.setAdapter(mainAdapter);

		mainlist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				initAdapter(Model.MORELISTTXT[position]);
				mainAdapter.setSelectItem(position);
				mainAdapter.notifyDataSetChanged();
			}
		});
		mainlist.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		// 一定要设置这个属性，否则ListView不会刷新
		initAdapter(Model.MORELISTTXT[0]);

		morelist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				moreAdapter.setSelectItem(position);
				moreAdapter.notifyDataSetChanged();
			}
		});
	}

	private void initAdapter(String[] array) {
		moreAdapter = new ClassifyMoreAdapter(this, array);
		morelist.setAdapter(moreAdapter);
		moreAdapter.notifyDataSetChanged();
	}

	private void initModle() {
		mainList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < Model.LISTVIEWIMG.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("img", Model.LISTVIEWIMG[i]);
			map.put("txt", Model.LISTVIEWTXT[i]);
			mainList.add(map);
		}
	}
}