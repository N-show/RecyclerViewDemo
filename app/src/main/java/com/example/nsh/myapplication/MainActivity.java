package com.example.nsh.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

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

        mRecyclerView.setAdapter(homeAdapter);
        //设置布局管理器
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //设置分割线  添加ItemDecoration
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration
                .VERTICAL_LIST));
        //设置默认动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    //创建了菜单的布局文件
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //菜单选择器的菜单事件处理
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.id_action_listview:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.id_action_gridview:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            case R.id.id_action_horizontalgridview:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 5, GridLayoutManager
                        .HORIZONTAL, false));
                break;
            case R.id.id_action_staggeredgraidview:
                mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                        DividerItemDecoration.HORIZONTAL_LIST));
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,
                        staggeredGridLayoutManager.VERTICAL));
                break;
            case R.id.actionbar_add_icon:
                homeAdapter.addData(1);
                break;
            case R.id.actionbar_delete_icon:
                homeAdapter.removeData(1);
                break;

        }
        return super.onOptionsItemSelected(item);
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
