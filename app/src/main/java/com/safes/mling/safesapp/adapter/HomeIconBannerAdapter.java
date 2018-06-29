package com.safes.mling.safesapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.safes.mling.safesapp.R;
import com.safes.mling.safesapp.bean.HomeBean;
import com.safes.mling.safesapp.bean.ViewBean;
import com.safes.mling.safesapp.utils.common.DensityUtil;
import com.safes.mling.safesapp.utils.common.GlideUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MLing on 2018/6/27 0027.
 */

public class HomeIconBannerAdapter extends RecyclerView.Adapter<HomeIconBannerAdapter.Viewholder> {
    private List<HomeBean.DataBean.IndexJifenProBean> mList = new ArrayList<>();
    private Context mContext;

    public HomeIconBannerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void onReference(List<HomeBean.DataBean.IndexJifenProBean> list1) {
        if (list1 != null) {
            mList.clear();
            mList.addAll(list1);
            notifyDataSetChanged();
        }
    }

    @Override
    public HomeIconBannerAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.xml_itme_home_banner, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT-(DensityUtil.dip2px(mContext,20)), ViewGroup.LayoutParams.WRAP_CONTENT));
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        GlideUtils.getInstance().LoadContextBitmap(mContext, mList.get(position).getTitle_pic(), holder.image_default, R.mipmap.icon_logo_app, GlideUtils.LOAD_BITMAP);
        GlideUtils.getInstance().LoadContextBitmap(mContext, mList.get(position).getBrand().getPic(), holder.image_logo, R.mipmap.icon_logo_app, GlideUtils.LOAD_BITMAP);
        holder.tv_title.setText(mList.get(position).getTitle());
        holder.title_content.setText(mList.get(position).getTitle_desc());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView image_default;
        ImageView image_logo;
        TextView tv_title;
        TextView title_content;

        public Viewholder(View itemView) {
            super(itemView);
            image_default = (ImageView) itemView.findViewById(R.id.image_default);
            image_logo = (ImageView) itemView.findViewById(R.id.image_logo);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            title_content = (TextView) itemView.findViewById(R.id.title_content);
        }
    }
}
