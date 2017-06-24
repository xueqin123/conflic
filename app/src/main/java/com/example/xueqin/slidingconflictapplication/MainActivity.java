package com.example.xueqin.slidingconflictapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by xue.qin on 2017/6/24.
 */

public class MainActivity extends Activity implements View.OnClickListener {
    Button btn1, btn2;
    HorizontalEx2 mHorizontalEx2;
    FrameLayout mContentPanel;
    ArrayList data1 = new ArrayList();
    ArrayList data2 = new ArrayList();
    ArrayList data3 = new ArrayList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        btn1 = (Button) findViewById(R.id.view_group_intercept);
        btn2 = (Button) findViewById(R.id.child_view_intercept);
        mContentPanel = (FrameLayout) findViewById(R.id.contentPanel);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        for (int i = 0; i < 100; i++) {
            data1.add("List1 第" + i + "行");
            data2.add("List2 第" + i + "行");
            data3.add("List3 第" + i + "行");
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.view_group_intercept:
                show1();
                break;
            case R.id.child_view_intercept:
                show2();
                break;
        }
    }

    private void show1() {
        ViewGroup.LayoutParams p
                = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        HorizontalEx horizontalEx = new HorizontalEx(this);
        horizontalEx.setLayoutParams(p);
        mContentPanel.removeAllViews();
        mContentPanel.addView(horizontalEx, p);
        ListView listView1 = new ListView(this);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data1);
        listView1.setAdapter(adapter1);

        ListView listView2 = new ListView(this);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data2);
        listView2.setAdapter(adapter2);

        ListView listView3 = new ListView(this);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data3);
        listView3.setAdapter(adapter3);

        ViewGroup.LayoutParams params
                = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        horizontalEx.addView(listView1, params);
        horizontalEx.addView(listView2, params);
        horizontalEx.addView(listView3, params);
    }

    private void show2() {
        ViewGroup.LayoutParams p
                = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        HorizontalEx2 horizontalEx2 = new HorizontalEx2(this);
        horizontalEx2.setLayoutParams(p);
        mContentPanel.removeAllViews();
        mContentPanel.addView(horizontalEx2, p);
        ListViewEx listView1 = new ListViewEx(this);
        listView1.setmHorizontalEx2(horizontalEx2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.list_item, data1);
        listView1.setAdapter(adapter1);

        ListViewEx listView2 = new ListViewEx(this);
        listView2.setmHorizontalEx2(horizontalEx2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.list_item, data2);
        listView2.setAdapter(adapter2);

        ListViewEx listView3 = new ListViewEx(this);
        listView3.setmHorizontalEx2(horizontalEx2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, R.layout.list_item, data3);
        listView3.setAdapter(adapter3);

        ViewGroup.LayoutParams params
                = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        horizontalEx2.addView(listView1, params);
        horizontalEx2.addView(listView2, params);
        horizontalEx2.addView(listView3, params);

    }


}
