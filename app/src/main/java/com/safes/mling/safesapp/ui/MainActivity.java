package com.safes.mling.safesapp.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.safes.mling.safesapp.R;
import com.safes.mling.safesapp.base.BaseCompatActivity;
import com.safes.mling.safesapp.fragment.CustomFragment;
import com.safes.mling.safesapp.fragment.HomeFragment;
import com.safes.mling.safesapp.fragment.UserFragment;
import com.safes.mling.safesapp.utils.widget.CustomButtonDialog;
import com.safes.mling.safesapp.utils.widget.NoScrollViewPager;
import com.safes.mling.safesapp.utils.widget.TitleBar;
import com.yinglan.alphatabs.AlphaTabsIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseCompatActivity {
    private AlphaTabsIndicator alphaTabsIndicator;
    private NoScrollViewPager mViewPger;
    private MainAdapter mainAdapter;

    @Override
    protected void titleBarSet(TitleBar titleBar) {
        titleBar.setVisibility(View.GONE);
    }

    @Override
    protected int onCreateViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreateViewContent(View view) {
        mViewPger = (NoScrollViewPager) findViewById(R.id.mViewPager);
        alphaTabsIndicator = (AlphaTabsIndicator) findViewById(R.id.alphaIndicator);

    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void setListener() {
        mainAdapter = new MainAdapter(getSupportFragmentManager());
        mViewPger.setAdapter(mainAdapter);
        mViewPger.addOnPageChangeListener(mainAdapter);
        alphaTabsIndicator.setViewPager(mViewPger);
        alphaTabsIndicator.getTabView(0).showNumber(6);
        alphaTabsIndicator.getTabView(1).showNumber(888);
        alphaTabsIndicator.getTabView(2);
        alphaTabsIndicator.getTabView(3).showNumber(998);
    }

    @Override
    protected void fromNetGetData() {

    }

    @Override
    protected void fromNotMsgReference() {

    }

    private class MainAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

        private List<Fragment> fragments = new ArrayList<>();

        public MainAdapter(FragmentManager fm) {
            super(fm);
            fragments.add(HomeFragment.newInstance());
            fragments.add(CustomFragment.newInstance());
            fragments.add(HomeFragment.newInstance());
            fragments.add(UserFragment.newInstance());
        }

        @Override
        public Fragment getItem(int position) {
            if (position != 2) {

            }
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (0 == position) {
                alphaTabsIndicator.getTabView(0).showNumber(alphaTabsIndicator.getTabView(0).getBadgeNumber() - 1);
            } else if (1 == position) {
                alphaTabsIndicator.getCurrentItemView().removeShow();
            } else if (2 == position) {
                callPhoneService("4008888889");
            } else if (3 == position) {
                alphaTabsIndicator.removeAllBadge();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }


    private void callPhoneService(final String phoneNumber) {
        final CustomButtonDialog dialog = new CustomButtonDialog(this);
        dialog.setText(phoneNumber);
        dialog.setLeftButtonTextColor(R.color.colorAccent);
        dialog.setRightButtonTextColor(R.color.colorAccent);
        dialog.setLeftButtonText("取消");
        dialog.setRightButtonText("确定");
        dialog.setButtonListener(new CustomButtonDialog.OnButtonListener() {
            @Override
            public void onLeftButtonClick(CustomButtonDialog var1) {
                dialog.cancel();
            }

            @Override
            public void onRightButtonClick(CustomButtonDialog var1) {
                dialog.cancel();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + phoneNumber);
                intent.setData(data);
                startActivity(intent);
            }
        });

    }
}
