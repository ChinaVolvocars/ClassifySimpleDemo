package com.example.demo.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.demo.Model;
import com.example.demo.R;
import com.example.demo.adapter.ClassifyMainAdapter;
import com.example.demo.adapter.ClassifyMoreAdapter;

public class RecyclerViewListActivity extends AppCompatActivity {

  private RecyclerView mMainRecyclerView;
  private RecyclerView mMoreRecyclerView;
  private List<Map<String, Object>> mainList;
  ClassifyMainAdapter mMainAdapter;
  ClassifyMoreAdapter moreAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_classify);
    initModle();
    initView();
  }

  private void initView() {
    mMainRecyclerView = findViewById(R.id.classify_main_RecyclerView);
    mMoreRecyclerView = findViewById(R.id.classify_more_RecyclerView);

    mMainRecyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewListActivity.this, LinearLayoutManager.VERTICAL, false));
    mMoreRecyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewListActivity.this, LinearLayoutManager.VERTICAL, false));

    mMainAdapter = new ClassifyMainAdapter(RecyclerViewListActivity.this, mainList);
    mMainRecyclerView.setAdapter(mMainAdapter);
    mMainAdapter.setSelectItem(0);


    mMainAdapter.setOnItemClickListener(new ClassifyMainAdapter.OnItemClickListener() {
      @Override
      public void onItemClick(View v, int position) {
        if (position != -1) {
          initAdapter(Model.MORELISTTXT[position]);
        }
      }
    });

//  一定要设置这个属性，否则RecyclerView不会刷新
    initAdapter(Model.MORELISTTXT[0]);
  }

  private void initAdapter(String[] array) {
    moreAdapter = new ClassifyMoreAdapter(this, array);
    mMoreRecyclerView.setAdapter(moreAdapter);
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