package com.safes.mling.safesapp.utils.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.safes.mling.safesapp.R;

/**
 * Created by wangLianJun on 2016/12/20.
 * 邮箱：695301501@qq.com
 *
 * @desc 图标及文字展示控件，带右上角小气泡
 * @tools
 */

public class TextIconPointView extends LinearLayout {

    private Context mContext;
    int textColor;
    ColorStateList textColorS = null;
    Drawable drawIcon;
    int textSize=15;
    String textName="";
    private TextView mTvNum;
    private ImageView mImgIcon;

    public TextIconPointView(Context context) {
        this(context,null);
    }

    public TextIconPointView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TextIconPointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        initView(context,attrs,defStyleAttr);
        initView();
    }

    private void initView() {
        mContext = getContext();

        setOrientation(LinearLayout.VERTICAL);

        View.inflate(mContext, R.layout.text_icon_point_view,
                this);
//        mTvName= (TextView) findViewById(R.id.view_tab_text);
        mTvNum= (TextView) findViewById(R.id.view_tab_num);
        mTvNum.setVisibility(View.GONE);
        mImgIcon= (ImageView) findViewById(R.id.view_tab_icon);
    }

    public void setImageResource(int drwId){
        mImgIcon.setImageResource(drwId);
    }

    /**
     * 设置显示
     * @param txt
     * @param isShow
     */
    public void setTextNumber(String txt,boolean isShow){
        if (isShow){
            mTvNum.setVisibility(View.VISIBLE);
        }else{
            mTvNum.setVisibility(View.GONE);
        }
        mTvNum.setText(txt);
    }

    private int number;
    public int getNumber(){
        return number;
    }
    /**
     * @param num
     * @param isShow
     */
    public void setTextNumber(int num,boolean isShow){
        this.number=num;
        if (isShow&&num>0){
            mTvNum.setVisibility(View.VISIBLE);
        }else{
            mTvNum.setVisibility(View.GONE);
        }
//        if (intTxt>99){
//            mTvNum.setText(9+"+");
//        }else{
        mTvNum.setText(num+"");
//        }
    }
}
