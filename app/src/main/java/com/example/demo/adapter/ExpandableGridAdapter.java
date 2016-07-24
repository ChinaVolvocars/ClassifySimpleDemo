package com.example.demo.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.R;
import com.example.demo.customview.MyGridView;

public class ExpandableGridAdapter extends BaseExpandableListAdapter implements
		OnItemClickListener {

	private String[][] child_text_array;
	private Context context;
	private MyGridView gridview;

	private List<Map<String, Object>> list;
	List<String> child_array;

	public ExpandableGridAdapter(Context context,
			List<Map<String, Object>> list, String[][] child_text_array) {
		this.context = context;
		this.list = list;
		this.child_text_array = child_text_array;
	}

	/**
	 * 获取一级标签总数
	 */
	@Override
	public int getGroupCount() {
		return list.size();
	}

	/**
	 * 获取一级标签下二级标签的总数
	 */
	@Override
	public int getChildrenCount(int groupPosition) {
		// 这里返回1是为了让ExpandableListView只显示一个ChildView，否则在展开
		// ExpandableListView时会显示和ChildCount数量相同的GridView
		return 1;
	}

	/**
	 * 获取一级标签内容
	 */
	@Override
	public Object getGroup(int groupPosition) {
		return list.get(groupPosition).get("txt");
	}

	/**
	 * 获取一级标签下二级标签的内容
	 */
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return child_text_array[groupPosition][childPosition];
	}

	/**
	 * 获取一级标签的ID
	 */
	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	/**
	 * 获取二级标签的ID
	 */
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	/**
	 * 指定位置相应的组视图
	 */
	@Override
	public boolean hasStableIds() {
		return true;
	}

	/**
	 * 对一级标签进行设置
	 */
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		convertView = (LinearLayout) LinearLayout.inflate(context,
				R.layout.item_gridview_group_layout, null);

		TextView group_title = (TextView) convertView
				.findViewById(R.id.group_title);
		if (isExpanded) {
			group_title.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.group_down, 0);
		} else {
			group_title.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.group_up, 0);
		}
		group_title.setText(list.get(groupPosition).get("txt").toString());
		return convertView;
	}

	/**
	 * 对一级标签下的二级标签进行设置
	 */
	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		convertView = (RelativeLayout) RelativeLayout.inflate(context,
				R.layout.item_grid_child_layout, null);
		gridview = (MyGridView) convertView.findViewById(R.id.gridview);

		int size = child_text_array[groupPosition].length;
		child_array = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			child_array.add(child_text_array[groupPosition][i]);
		}
		gridview.setAdapter(new GridTextAdapter(context, child_array));
		gridview.setOnItemClickListener(this);
		return convertView;
	}

	/**
	 * 当选择子节点的时候，调用该方法
	 */
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast.makeText(context, "当前选中的是:" + child_array.get(position),
				Toast.LENGTH_SHORT).show();
	}
}