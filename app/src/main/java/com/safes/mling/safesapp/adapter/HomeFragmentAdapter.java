package com.safes.mling.safesapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.safes.mling.safesapp.R;
import com.safes.mling.safesapp.bean.ViewBean;

import java.util.ArrayList;
import java.util.List;

import lib.util.open.rollviewpage.RollPagerView;

/**
 * Created by MLing on 2018/6/14 0014.
 */

public class HomeFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEW_BANNER = 101;
    public static final int VIEW_ICON = 102;
    public static final int VIEW_ICON_BANNER = 103;
    public static final int VIEW_LIST_TITLE = 104;
    public static final int VIEW_LIST = 105;
    private List<ViewBean> mList = new ArrayList<>();
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
            return new ViewHolderBanner(view);
        } else if (viewType == VIEW_ICON) {
            view = LayoutInflater.from(mContext).inflate(R.layout.xml_item_home_icon, null);
            return new ViewHolderIcon(view);
        } else if (viewType == VIEW_ICON_BANNER) {
            view = LayoutInflater.from(mContext).inflate(R.layout.xml_item_home_icon_banner, null);
            return new ViewHolderBanner(view);
        } else if (viewType == VIEW_LIST_TITLE) {
            view = LayoutInflater.from(mContext).inflate(R.layout.xml_item_home_list_title, null);
            return new ViewHolderBanner(view);
        } else if (viewType == VIEW_LIST) {
            view = LayoutInflater.from(mContext).inflate(R.layout.xml_item_home_list, null);
            return new ViewHolderBanner(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return 0;
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
        RecyclerView recycler_view;

        public ViewHolderListTitle(View itemView) {
            super(itemView);
            recycler_view = (RecyclerView) itemView.findViewById(R.id.recycler_view);
        }
    }
    public class ViewHolderList extends RecyclerView.ViewHolder {
        RecyclerView recycler_view;

        public ViewHolderList(View itemView) {
            super(itemView);
            recycler_view = (RecyclerView) itemView.findViewById(R.id.recycler_view);
        }
    }
}
