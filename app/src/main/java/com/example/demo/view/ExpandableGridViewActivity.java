package com.example.demo.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.Model;
import com.example.demo.R;
import com.example.demo.adapter.ExpandableGridAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;

public class ExpandableGridViewActivity extends Activity {

	private ExpandableListView expandableGridView;

	ExpandableGridAdapter adapter;

	private List<Map<String, Object>> list;
	private String[][] child_text_array;

	private int sign = -1;// 控制列表的展开

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expandable_gridview);
		init();
		initModle();
		setListener();
	}

	private void init() {
		expandableGridView = (ExpandableListView) findViewById(R.id.list);

		child_text_array = Model.EXPANDABLE_MOREGRIDVIEW_TXT;
	}

	private void setListener() {
		expandableGridView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				if (sign == -1) {
					// 展开被选的group
					expandableGridView.expandGroup(groupPosition);
					// 设置被选中的group置于顶端
					expandableGridView.setSelectedGroup(groupPosition);
					sign = groupPosition;
				} else if (sign == groupPosition) {
					expandableGridView.collapseGroup(sign);
					sign = -1;
				} else {
					expandableGridView.collapseGroup(sign);
					// 展开被选的group
					expandableGridView.expandGroup(groupPosition);
					// 设置被选中的group置于顶端
					expandableGridView.setSelectedGroup(groupPosition);
					sign = groupPosition;
				}
				return true;
			}
		});
	}

	private void initModle() {
		list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < Model.EXPANDABLE_GRIDVIEW_TXT.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("txt", Model.EXPANDABLE_GRIDVIEW_TXT[i]);
			list.add(map);
		}
		adapter = new ExpandableGridAdapter(this, list, child_text_array);
		expandableGridView.setAdapter(adapter);
	}

}
