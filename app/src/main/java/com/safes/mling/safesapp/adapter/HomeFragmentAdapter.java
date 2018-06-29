package com.safes.mling.safesapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.safes.mling.safesapp.R;
import com.safes.mling.safesapp.bean.ViewBean;
import com.safes.mling.safesapp.utils.common.ConstmOnItemOnclickListener;
import com.safes.mling.safesapp.utils.common.DensityUtil;
import com.safes.mling.safesapp.utils.common.GlideUtils;
import com.safes.mling.safesapp.utils.widget.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

import lib.util.open.rollviewpage.OnItemClickListener;
import lib.util.open.rollviewpage.RollPagerView;
import lib.util.open.rollviewpage.hintview.ColorPointHintView;
import lib.util.open.rollviewpage.hintview.ShapeHintView;

/**
 * Created by MLing on 2018/6/14 0014.
 */

public class HomeFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEW_BANNER = 101;
    public static final int VIEW_ICON = 102;
    public static final int VIEW_ICON_BANNER = 103;
    public static final int VIEW_LIST_TITLE = 104;
    public static final int VIEW_LIST = 105;
    private ConstmOnItemOnclickListener constmOnItemOnclickListener;
    private List<ViewBean> mList = new ArrayList<>();
    private ArrayList<String> items = new ArrayList<>();
    private Context mContext;

    public HomeFragmentAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void onReference(List<ViewBean> list1) {
        if (list1 != null) {
            mList.clear();
            mList.addAll(list1);
            notifyDataSetChanged();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == VIEW_BANNER) {
            view = LayoutInflater.from(mContext).inflate(R.layout.xml_item_home_banner, null);
            view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return new ViewHolderBanner(view);
        } else if (viewType == VIEW_ICON) {
            view = LayoutInflater.from(mContext).inflate(R.layout.xml_item_home_icon, null);
            view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return new ViewHolderIcon(view);
        } else if (viewType == VIEW_ICON_BANNER) {
            view = LayoutInflater.from(mContext).inflate(R.layout.xml_item_home_icon_banner, null);
            view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return new ViewHolderIconBanner(view);
        } else if (viewType == VIEW_LIST_TITLE) {
            view = LayoutInflater.from(mContext).inflate(R.layout.xml_item_home_list_title, null);
            view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return new ViewHolderListTitle(view);
        } else if (viewType == VIEW_LIST) {
            view = LayoutInflater.from(mContext).inflate(R.layout.xml_item_home_list, null);
            view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return new ViewHolderList(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (mList.get(position).getViewType()) {
            case VIEW_BANNER:
                //轮播图
                HomeViewpagerAdapter viewpagerAdapter = new HomeViewpagerAdapter(mContext);
                ((ViewHolderBanner) holder).normal_view_pager.setPlayDelay(5000);
                ((ViewHolderBanner) holder).normal_view_pager.setAdapter(viewpagerAdapter);
                ((ViewHolderBanner) holder).normal_view_pager.setHintView(new ColorPointHintView(mContext, Color.parseColor("#5ac5b3"), Color.WHITE));
                ((ViewHolderBanner) holder).normal_view_pager.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int positionChild) {
                        constmOnItemOnclickListener.clickItem(null, position, positionChild, 1, mList.get(position).getBannerBeans().get(positionChild).getId() + "");
                    }
                });
                if (mList.get(position).getBannerBeans() != null && mList.get(position).getBannerBeans().size() > 0) {
                    items.clear();
                    for (int i = 0; i < mList.get(position).getBannerBeans().size(); i++) {
                        items.add(mList.get(position).getBannerBeans().get(i).getPic());
                    }
                    viewpagerAdapter.setImgs(items);
                }
                break;
            case VIEW_ICON:
                break;
            case VIEW_ICON_BANNER:
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                ((ViewHolderIconBanner) holder).recycler_view.setLayoutManager(linearLayoutManager);
                HomeIconBannerAdapter mAdapter = new HomeIconBannerAdapter(mContext);
                ((ViewHolderIconBanner) holder).recycler_view.setAdapter(mAdapter);
                mAdapter.onReference(mList.get(position).getIconBanner());
                break;
            case VIEW_LIST_TITLE:
                ((ViewHolderListTitle) holder).tv_title.setText(mList.get(position).getTitleBean().getCate_name());
                break;
            case VIEW_LIST:
                ((ViewHolderList) holder).tv_title.setText(mList.get(position).getListBean().getBrand().getBname());
                ((ViewHolderList) holder).title_content.setText(mList.get(position).getListBean().getBrand().getSname());
                ((ViewHolderList) holder).tv_money.setText(mList.get(position).getListBean().getPrice());
                GlideUtils.getInstance().LoadContextBitmap(mContext, mList.get(position).getListBean().getTitle_pic(), ((ViewHolderList) holder).image_default, R.mipmap.icon_logo_app, GlideUtils.LOAD_BITMAP);
                GlideUtils.getInstance().LoadContextBitmap(mContext, mList.get(position).getListBean().getBrand().getPic(), ((ViewHolderList) holder).image_logo, R.mipmap.icon_logo_app, GlideUtils.LOAD_BITMAP);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolderBanner extends RecyclerView.ViewHolder {
        RollPagerView normal_view_pager;

        public ViewHolderBanner(View itemView) {
            super(itemView);
            normal_view_pager = (RollPagerView) itemView.findViewById(R.id.normal_view_pager);
        }
    }


    public class ViewHolderIcon extends RecyclerView.ViewHolder {
        TextView tv_zsbx;
        TextView tv_mxcp;
        TextView tv_jfsc;
        TextView tv_bxfl;
        TextView tv_xbzs;

        public ViewHolderIcon(View itemView) {
            super(itemView);
            tv_zsbx = (TextView) itemView.findViewById(R.id.tv_zsbx);
            tv_mxcp = (TextView) itemView.findViewById(R.id.tv_mxcp);
            tv_jfsc = (TextView) itemView.findViewById(R.id.tv_jfsc);
            tv_bxfl = (TextView) itemView.findViewById(R.id.tv_bxfl);
            tv_xbzs = (TextView) itemView.findViewById(R.id.tv_xbzs);
        }
    }


    public class ViewHolderIconBanner extends RecyclerView.ViewHolder {
        RecyclerView recycler_view;

        public ViewHolderIconBanner(View itemView) {
            super(itemView);
            recycler_view = (RecyclerView) itemView.findViewById(R.id.recycler_view);
        }
    }

    public class ViewHolderListTitle extends RecyclerView.ViewHolder {
        TextView tv_title;

        public ViewHolderListTitle(View itemView) {
            super(itemView);
            tv_title= (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public class ViewHolderList extends RecyclerView.ViewHolder {
        ImageView image_default;
        ImageView image_logo;
        TextView tv_title;
        TextView title_content;
        TextView tv_money_q;
        TextView tv_money;

        public ViewHolderList(View itemView) {
            super(itemView);
            image_default = (ImageView) itemView.findViewById(R.id.image_default);
            image_logo = (ImageView) itemView.findViewById(R.id.image_logo);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            title_content = (TextView) itemView.findViewById(R.id.title_content);
            tv_money_q = (TextView) itemView.findViewById(R.id.tv_money_q);
            tv_money = (TextView) itemView.findViewById(R.id.tv_money);
        }
    }


    public void setOnItemOnclickListener(ConstmOnItemOnclickListener onItemOnclickListener) {
        this.constmOnItemOnclickListener = onItemOnclickListener;
    }
}
