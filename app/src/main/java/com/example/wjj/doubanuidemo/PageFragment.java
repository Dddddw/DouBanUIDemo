package com.example.wjj.doubanuidemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * function
 *
 * Created by wjj on 2016/9/28.
 */

public class PageFragment extends Fragment {

    private int mNum;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        mNum = bundle.getInt("pageNum");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View pager = inflater.inflate(R.layout.pagerfragment, container, false);
        TextView textView = (TextView) pager.findViewById(R.id.pager_text);

        textView.setText(String.valueOf("" + mNum));
        return pager;

    }
}
