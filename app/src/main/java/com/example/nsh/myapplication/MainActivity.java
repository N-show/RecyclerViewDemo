package com.example.nsh.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private ArrayList<SampleModel> sampleData;
    private HomeAdapter homeAdapter;
    private LinearLayoutManager linearLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sampleData = getSampleData(1000);
        initView();
        //RecyclerView的构造器方法
        homeAdapter = new HomeAdapter(this, this.sampleData);

        //RecyclerView的布局管理
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //RecyclerView的分割线


        mRecyclerView.setAdapter(homeAdapter);
        //设置布局管理器
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //设置分割线  添加ItemDecoration
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this));
    }




    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
    }

    private ArrayList<SampleModel> getSampleData(int size) {
        sampleData = new ArrayList<SampleModel>(size);
        for (int i = 0; i < size; i++) {
            sampleData.add(new SampleModel("新的列表项<" + i + ">"));
        }
        return sampleData;
    }
}
