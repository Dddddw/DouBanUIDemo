package com.example.wjj.doubanuidemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * function
 * <p>
 * Created by wjj on 2016/9/28.
 */

public class ReListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.relistfragment, container, false);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_list);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        //设置进程动画的颜色
        mSwipeRefreshLayout.setColorSchemeResources(R.color.blue
                ,R.color.green
                ,R.color.orange
                ,R.color.red);

        ListView listView = (ListView) view.findViewById(R.id.list_item);
        listView.setAdapter(new ArrayAdapter<>(getContext(),  android.R.layout.simple_list_item_1, getData()));

        return view;
    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 3000);
    }

    public List<String> getData() {
        List<String> data = new ArrayList<>();
        for (int i = 0 ; i< 20; i++){
            data.add("" + i);
        }
        return data;
    }
}
