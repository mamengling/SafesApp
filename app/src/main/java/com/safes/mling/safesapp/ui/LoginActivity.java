package com.safes.mling.safesapp.ui;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.safes.mling.safesapp.R;
import com.safes.mling.safesapp.adapter.MyFragmentAdapter;
import com.safes.mling.safesapp.base.BaseCompatActivity;
import com.safes.mling.safesapp.fragment.FragmentLogin;
import com.safes.mling.safesapp.fragment.FragmentVerifyLogin;
import com.safes.mling.safesapp.utils.widget.ActivityAnim;
import com.safes.mling.safesapp.utils.widget.TitleBar;

import java.util.ArrayList;

/**
 * Created by MLing on 2018/6/29 0029.
 */

public class LoginActivity extends BaseCompatActivity {
    private RadioGroup radioGroup;
    private ViewPager viewPager;
    private RadioButton radiobutton0;
    private RadioButton radiobutton1;
    private MyFragmentAdapter myFragmentAdapter;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    /**
     * @param titleBar 设置标题栏
     */
    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setTitleName("登录送保保网");
        titleBar.setTitleBarClickImpl(new TitleBar.TitleBarClick() {
            @Override
            public void titleOnClick(int titleType) {
                switch (titleType){
                    case TitleBar.clickBack:
                        ActivityAnim.endActivity(LoginActivity.this);
                        break;
                }
            }
        });
    }

    /**
     * @return 设置页面布局
     */
    @Override
    protected int onCreateViewId() {
        return R.layout.activity_login;
    }

    /**
     * 设置页面布局实例化
     *
     * @param view
     */
    @Override
    protected void onCreateViewContent(View view) {
        radioGroup = (RadioGroup) view.findViewById(R.id.radiogroup_full);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        radiobutton0 = (RadioButton) view.findViewById(R.id.radiobutton0);
        radiobutton1 = (RadioButton) view.findViewById(R.id.radiobutton1);
    }

    /**
     * 本地传参
     */
    @Override
    protected void getExras() {

    }

    /**
     * 监听事件
     */
    @Override
    protected void setListener() {
        radioGroup.setOnCheckedChangeListener(new OnTabListener());
        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myFragmentAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radiobutton0.setChecked(true);
                        break;
                    case 1:
                        radiobutton1.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        fragmentList.clear();
        fragmentList.add(FragmentLogin.newInstance());//人材
        fragmentList.add(FragmentVerifyLogin.newInstance());//校招信息
        myFragmentAdapter.setList(fragmentList);
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


    protected class OnTabListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.radiobutton0:// 人材
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.radiobutton1:// 校招信息
                    viewPager.setCurrentItem(1);
                    break;
            }
        }
    }
}
