package com.safes.mling.safesapp.fragment;

import android.os.Bundle;
import android.view.View;

import com.loopj.android.http.RequestParams;
import com.safes.mling.safesapp.R;
import com.safes.mling.safesapp.adapter.HomeFragmentAdapter;
import com.safes.mling.safesapp.base.BaseFragment;
import com.safes.mling.safesapp.bean.CallBackVo;
import com.safes.mling.safesapp.bean.HomeBean;
import com.safes.mling.safesapp.iactivityview.HomeFragmentView;
import com.safes.mling.safesapp.utils.widget.TitleBar;

/**
 * 作者：MLing
 * 邮箱：mlingvip@163.com
 * 创建时间：2018/4/9 22:57
 */

public class HomeFragment extends BaseFragment implements HomeFragmentView {
    private HomeFragmentAdapter mAdapter;
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

    @Override
    public void excuteSuccessCallBack(HomeBean bean) {

    }

    /**
     * 获取参数
     *
     * @return
     */
    @Override
    public RequestParams getParamenters() {
        return null;
    }

    /**
     * 显示操作进度
     */
    @Override
    public void showProgress() {

    }

    /**
     * 关闭进度
     */
    @Override
    public void closeProgress() {

    }

    /**
     * 失败回调
     *
     * @param mCallBackVo
     */
    @Override
    public void excuteFailedCallBack(CallBackVo mCallBackVo) {

    }
}
