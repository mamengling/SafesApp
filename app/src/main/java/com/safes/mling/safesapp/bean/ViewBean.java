package com.safes.mling.safesapp.bean;

import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * Created by MLing on 2018/6/14 0014.
 */

public class ViewBean {
    private int viewType;
    private List<HomeBean.DataBean.BannerBean> bannerBeans;
    private List<HomeBean.DataBean.IndexJifenProBean> iconBanner;
    private List<ViewPagerBean> viewpager;
    private HomeBean.DataBean.IndexCateProBean titleBean;
    private HomeBean.DataBean.IndexCateProBean.ProBean listBean;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public List<HomeBean.DataBean.BannerBean> getBannerBeans() {
        return bannerBeans;
    }

    public void setBannerBeans(List<HomeBean.DataBean.BannerBean> bannerBeans) {
        this.bannerBeans = bannerBeans;
    }

    public List<ViewPagerBean> getViewpager() {
        return viewpager;
    }

    public void setViewpager(List<ViewPagerBean> viewpager) {
        this.viewpager = viewpager;
    }

    public HomeBean.DataBean.IndexCateProBean getTitleBean() {
        return titleBean;
    }

    public void setTitleBean(HomeBean.DataBean.IndexCateProBean titleBean) {
        this.titleBean = titleBean;
    }

    public HomeBean.DataBean.IndexCateProBean.ProBean getListBean() {
        return listBean;
    }

    public void setListBean(HomeBean.DataBean.IndexCateProBean.ProBean listBean) {
        this.listBean = listBean;
    }

    public List<HomeBean.DataBean.IndexJifenProBean> getIconBanner() {
        return iconBanner;
    }

    public void setIconBanner(List<HomeBean.DataBean.IndexJifenProBean> iconBanner) {
        this.iconBanner = iconBanner;
    }
}
