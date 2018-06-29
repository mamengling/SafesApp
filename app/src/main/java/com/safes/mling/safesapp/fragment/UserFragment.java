package com.safes.mling.safesapp.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.safes.mling.safesapp.R;
import com.safes.mling.safesapp.base.BaseFragment;
import com.safes.mling.safesapp.ui.LoginActivity;
import com.safes.mling.safesapp.utils.widget.ActivityAnim;
import com.safes.mling.safesapp.utils.widget.TextIconPointView;
import com.safes.mling.safesapp.utils.widget.TitleBar;

/**
 * Created by MLing on 2018/6/29 0029.
 */

public class UserFragment extends BaseFragment implements View.OnClickListener {
    private TextIconPointView message;
    private ImageView image_user_logo;
    private TextView tv_user_name;
    private TextView tv_bang_status;
    private TextView setting;
    private TextView tv_login;

    public static UserFragment newInstance() {

        Bundle args = new Bundle();

        UserFragment fragment = new UserFragment();
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
        return R.layout.fragment_user;
    }

    /**
     * 设置页面布局实例化
     *
     * @param view
     */
    @Override
    protected void onCreateViewContent(View view) {
        tv_login = (TextView) view.findViewById(R.id.tv_login);
        image_user_logo = (ImageView) view.findViewById(R.id.image_user_logo);
        message = (TextIconPointView) view.findViewById(R.id.title_bar_message);
        setting = (TextView) view.findViewById(R.id.title_bar_set);
        tv_user_name = (TextView) view.findViewById(R.id.tv_user_name);
        tv_bang_status = (TextView) view.findViewById(R.id.tv_bang_status);
        view.findViewById(R.id.relative_collect).setOnClickListener(this);
        view.findViewById(R.id.relative_djq).setOnClickListener(this);
        view.findViewById(R.id.relative_clxr).setOnClickListener(this);
        view.findViewById(R.id.relative_balp).setOnClickListener(this);

        view.findViewById(R.id.tv_order_dzf).setOnClickListener(this);
        view.findViewById(R.id.tv_order_dwc).setOnClickListener(this);
        view.findViewById(R.id.tv_order_yzf).setOnClickListener(this);
        view.findViewById(R.id.tv_order_bzz).setOnClickListener(this);
        view.findViewById(R.id.tv_order_ydq).setOnClickListener(this);
        message.setImageResource(R.mipmap.user_icon_message);
        message.setTextNumber(1, true);
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
        tv_login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login:
                ActivityAnim.intentActivity(getActivity(), LoginActivity.class, null);
                break;
            case R.id.relative_collect:
                break;
            case R.id.relative_djq:
                break;
            case R.id.relative_clxr:
                break;
            case R.id.relative_balp:
                break;
            case R.id.tv_order_dzf:
                break;
            case R.id.tv_order_dwc:
                break;
            case R.id.tv_order_yzf:
                break;
            case R.id.tv_order_bzz:
                break;
            case R.id.tv_order_ydq:
                break;
        }
    }
}
