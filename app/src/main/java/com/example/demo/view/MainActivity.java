package com.example.demo.view;

import com.example.demo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button listlistview, listgridview, expandableListView,
			expandableGridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listlistview = (Button) findViewById(R.id.listlist);
		listgridview = (Button) findViewById(R.id.listgrid);
		expandableListView = (Button) findViewById(R.id.expandableListView);
		expandableGridView = (Button) findViewById(R.id.expandableGridView);

		listlistview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, ListListActivity.class);
				startActivity(intent);
			}
		});

		listgridview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, ScrollGridActivity.class);
				startActivity(intent);
			}
		});

		expandableListView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,
						ExpandableListViewActivity.class);
				startActivity(intent);
			}
		});

		expandableGridView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,
						ExpandableGridViewActivity.class);
				startActivity(intent);
			}
		});
	}

}
