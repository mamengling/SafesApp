package com.safes.mling.safesapp.fragment;

import android.os.Bundle;
import android.view.View;

import com.safes.mling.safesapp.R;
import com.safes.mling.safesapp.base.BaseFragment;
import com.safes.mling.safesapp.utils.widget.TitleBar;

/**
 * Created by MLing on 2018/6/29 0029.
 */

public class CustomFragment extends BaseFragment {
    public static CustomFragment newInstance() {

        Bundle args = new Bundle();

        CustomFragment fragment = new CustomFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * @param titleBar 设置标题栏
     */
    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setShowIcon(false, false, false);
        titleBar.setTitleName("免费定制");
    }

    /**
     * @return 设置页面布局
     */
    @Override
    protected int onCreateViewId() {
        return R.layout.fragment_custom;
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
