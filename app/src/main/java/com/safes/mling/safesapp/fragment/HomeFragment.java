package com.safes.mling.safesapp.fragment;

import android.os.Bundle;
import android.view.View;

import com.safes.mling.safesapp.R;
import com.safes.mling.safesapp.base.BaseFragment;
import com.safes.mling.safesapp.utils.widget.TitleBar;

/**
 * 作者：MLing
 * 邮箱：mlingvip@163.com
 * 创建时间：2018/4/9 22:57
 */

public class HomeFragment extends BaseFragment{
    public static HomeFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setVisibility(View.GONE);
    }

    @Override
    protected int onCreateViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onCreateViewContent(View view) {

    }

    @Override
    protected void fromNetGetData() {

    }

    @Override
    protected void fromNotMsgReference() {

    }

    @Override
    protected void setListener() {

    }
}
