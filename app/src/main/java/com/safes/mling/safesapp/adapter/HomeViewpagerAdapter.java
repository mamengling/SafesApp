package com.safes.mling.safesapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.safes.mling.safesapp.R;
import com.safes.mling.safesapp.utils.common.GlideUtils;

import java.util.List;

import lib.util.open.rollviewpage.adapter.StaticPagerAdapter;

/**
 * 作者：MLing on 2016/12/7 13:25
 * 邮箱：mamenglingkl1314@163.com
 */
public class HomeViewpagerAdapter extends StaticPagerAdapter {
    private List<String> mList;
    private Context mContext;

    public HomeViewpagerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setImgs(List<String> imgs) {
        this.mList = imgs;
        notifyDataSetChanged();
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        GlideUtils.getInstance().LoadContextBitmap(mContext, mList.get(position), view, R.mipmap.ic_launcher, GlideUtils.LOAD_BITMAP);
        return view;
    }


    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }
}
