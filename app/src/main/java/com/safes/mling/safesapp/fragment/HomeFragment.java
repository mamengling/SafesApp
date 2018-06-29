package com.safes.mling.safesapp.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.loopj.android.http.RequestParams;
import com.melnykov.fab.FloatingActionButton;
import com.melnykov.fab.ScrollDirectionListener;
import com.safes.mling.safesapp.R;
import com.safes.mling.safesapp.adapter.HomeFragmentAdapter;
import com.safes.mling.safesapp.base.BaseFragment;
import com.safes.mling.safesapp.bean.BannerBean;
import com.safes.mling.safesapp.bean.CallBackVo;
import com.safes.mling.safesapp.bean.HomeBean;
import com.safes.mling.safesapp.bean.ViewBean;
import com.safes.mling.safesapp.bean.ViewPagerBean;
import com.safes.mling.safesapp.iactivityview.HomeFragmentView;
import com.safes.mling.safesapp.presenter.HomeFragmentPresenter;
import com.safes.mling.safesapp.utils.common.AppMethod;
import com.safes.mling.safesapp.utils.common.Constants;
import com.safes.mling.safesapp.utils.common.DensityUtil;
import com.safes.mling.safesapp.utils.common.UIUtils;
import com.safes.mling.safesapp.utils.common.log.LogUtil;
import com.safes.mling.safesapp.utils.dialogutils.MDialog;
import com.safes.mling.safesapp.utils.widget.RecycleViewDivider;
import com.safes.mling.safesapp.utils.widget.TextIconPointView;
import com.safes.mling.safesapp.utils.widget.TitleBar;
import com.safes.mling.safesapp.utils.widget.YRecycleview;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：MLing
 * 邮箱：mlingvip@163.com
 * 创建时间：2018/4/9 22:57
 */

public class HomeFragment extends BaseFragment implements HomeFragmentView, View.OnClickListener {
    private HomeFragmentPresenter mHomeFragmentPersenter;
    private HomeFragmentAdapter mAdapter;
    private List<ViewBean> mList = new ArrayList<>();
    private YRecycleview yrecycle_view;
    private LinearLayout line_search;
    private TextIconPointView message;
    private FloatingActionButton image_top;
    private LinearLayoutManager layoutManager;
    private int intNumberPage = 0;
    private int intHandler = 101;

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void titleBarSet(TitleBar titleBar) {
        mHomeFragmentPersenter = new HomeFragmentPresenter(this);
        titleBar.setVisibility(View.GONE);
    }

    @Override
    protected int onCreateViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onCreateViewContent(View view) {
        yrecycle_view = (YRecycleview) view.findViewById(R.id.yrecycle_view);
        line_search = (LinearLayout) view.findViewById(R.id.line_search);
        image_top = (FloatingActionButton) view.findViewById(R.id.fab);
        message = (TextIconPointView) view.findViewById(R.id.text_message);
        message.setTextNumber(1,true);
    }

    @Override
    protected void fromNetGetData() {
        mHomeFragmentPersenter.getIndexList();
    }

    @Override
    protected void fromNotMsgReference() {
        mHomeFragmentPersenter.getIndexList();
    }

    @Override
    protected void setListener() {
        image_top.hide(false);
        image_top.setOnClickListener(this);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        yrecycle_view.setLayoutManager(layoutManager);
        //水平分割线
//        yrecycle_view.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.HORIZONTAL, DensityUtil.dip2px(getActivity(), 5), getResources().getColor(R.color.content_view_bg)));
        mAdapter = new HomeFragmentAdapter(getActivity());
        yrecycle_view.setAdapter(mAdapter);
        yrecycle_view.setReFreshEnabled(true);
        yrecycle_view.setLoadMoreEnabled(false);
        yrecycle_view.setRefreshAndLoadMoreListener(new YRecycleview.OnRefreshAndLoadMoreListener() {
            @Override
            public void onRefresh() {
                LogUtil.i("MissCandy", "下拉刷新");
                intNumberPage = 1;
                intHandler = 101;
                mHomeFragmentPersenter.getIndexList();
            }

            @Override
            public void onLoadMore() {
                LogUtil.i("MissCandy", "加载更多");
                intNumberPage += 1;
                intHandler = 102;
                mHomeFragmentPersenter.getIndexList();
            }
        });
        //设置为小图
        image_top.setType(FloatingActionButton.TYPE_MINI);//或布局中：fab:fab_type="mini"
        image_top.attachToRecyclerView(yrecycle_view, new ScrollDirectionListener() {
            @Override
            public void onScrollDown() {
                image_top.hide();
            }

            @Override
            public void onScrollUp() {
                image_top.show();
            }
        }, new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = yrecycle_view.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                    int firstVisibleItemPosition = linearManager.findFirstVisibleItemPosition();
                    if (firstVisibleItemPosition > 5) {
                        image_top.show();
                    } else {
                        image_top.hide();
                    }
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }

    @Override
    public void excuteSuccessCallBack(HomeBean bean) {
        mList.clear();
        switch (intHandler) {
            case 101:
                //banner
                ViewBean viewBean = new ViewBean();
                viewBean.setViewType(101);
                viewBean.setBannerBeans(bean.getData().getBanner());
                mList.add(viewBean);
                //icon
                ViewBean viewIcon = new ViewBean();
                viewIcon.setViewType(102);
                mList.add(viewIcon);
                //viewpager
                ViewBean viewPager = new ViewBean();
                viewPager.setViewType(103);
                viewPager.setIconBanner(bean.getData().getIndexJifenPro());
                mList.add(viewPager);
                //list
                for (int i = 0; i < bean.getData().getIndexCatePro().size(); i++) {
                    ViewBean viewBeanTitle = new ViewBean();
                    viewBeanTitle.setViewType(104);
                    viewBeanTitle.setTitleBean(bean.getData().getIndexCatePro().get(i));
                    mList.add(viewBeanTitle);
                    for (int j = 0; j < bean.getData().getIndexCatePro().get(i).getPro().size(); j++) {
                        ViewBean viewBeanList = new ViewBean();
                        viewBeanList.setViewType(105);
                        viewBeanList.setListBean(bean.getData().getIndexCatePro().get(i).getPro().get(j));
                        mList.add(viewBeanList);
                    }
                }
                mAdapter.onReference(mList);
                yrecycle_view.setReFreshComplete();
                break;
        }
    }

    /**
     * 获取参数
     *
     * @return
     */
    @Override
    public RequestParams getParamenters() {
        RequestParams params = AppMethod.getMapParams(Constants.HOME_API_INDEX);

        return params;
    }

    /**
     * 显示操作进度
     */
    @Override
    public void showProgress() {
        MDialog.getInstance(getActivity()).showProgressDialog();
    }

    /**
     * 关闭进度
     */
    @Override
    public void closeProgress() {
        MDialog.getInstance(getActivity()).closeProgressDialog();
    }

    /**
     * 失败回调
     *
     * @param mCallBackVo
     */
    @Override
    public void excuteFailedCallBack(CallBackVo mCallBackVo) {
        switch (intHandler) {
            case 101:
                yrecycle_view.setReFreshComplete();
                break;
        }
        MDialog.getInstance(getActivity()).showToast(mCallBackVo.getErrmsg());
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                UIUtils.MoveToPosition(layoutManager, 0);
                image_top.hide();

                break;
        }
    }
}
