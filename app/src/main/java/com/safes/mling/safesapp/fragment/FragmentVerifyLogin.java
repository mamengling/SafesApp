package com.safes.mling.safesapp.fragment;

import android.os.Bundle;
import android.view.View;

import com.safes.mling.safesapp.R;
import com.safes.mling.safesapp.base.BaseFragment;
import com.safes.mling.safesapp.utils.widget.TitleBar;

/**
 * Created by MLing on 2018/6/29 0029.
 */

public class FragmentVerifyLogin extends BaseFragment {
    public static FragmentVerifyLogin newInstance() {

        Bundle args = new Bundle();

        FragmentVerifyLogin fragment = new FragmentVerifyLogin();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * @param titleBar 设置标题栏
     */
    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setVisibility(View.GONE);
    }

    /**
     * @return 设置页面布局
     */
    @Override
    protected int onCreateViewId() {
        return R.layout.fragment_verify_login;
    }

    /**
     * 设置页面布局实例化
     *
     * @param view
     */
    @Override
    protected void onCreateViewContent(View view) {

    }

    /**
     * 获取数据方法，之后，View赋值
     */
    @Override
    protected void fromNetGetData() {

    }

    /**
     * 获取数据方法，之后，View赋值
     */
    @Override
    protected void fromNotMsgReference() {

    }

    /**
     * 监听事件
     */
    @Override
    protected void setListener() {

    }
}
