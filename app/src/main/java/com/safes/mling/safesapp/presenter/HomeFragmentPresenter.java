package com.safes.mling.safesapp.presenter;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.safes.mling.safesapp.base.BaseApplication;
import com.safes.mling.safesapp.bean.CallBackVo;
import com.safes.mling.safesapp.bean.HomeBean;
import com.safes.mling.safesapp.iactivityview.HomeFragmentView;
import com.safes.mling.safesapp.utils.common.Constants;
import com.safes.mling.safesapp.utils.common.HttpUtil;
import com.safes.mling.safesapp.utils.common.log.LogUtil;
import com.safes.mling.safesapp.utils.common.log.klog.JsonLog;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * 作者： MLing
 * 邮箱：mamenglingkl1314@163.com
 * 创建时间 ：2018/4/3 14:25
 * $DESE$
 */
public class HomeFragmentPresenter{
    private HomeFragmentView mHomeFragmentView;

    public HomeFragmentPresenter(HomeFragmentView mHomeFragmentView) {
        this.mHomeFragmentView = mHomeFragmentView;
    }

    public void getIndexList() {
        mHomeFragmentView.showProgress();
        HttpUtil.get(Constants.BASE_URL + Constants.BASE_URL, mHomeFragmentView.getParamenters(), new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                mHomeFragmentView.showProgress();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                mHomeFragmentView.closeProgress();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);
                LogUtil.i("putUserInfo", result);
                JsonLog.printJson("putUserInfo", result, this.getRequestURI().toString());
                mHomeFragmentView.closeProgress();
                JSONObject object = null;
                try {
                    object = new JSONObject(result);
                    if (object.getInt("rtnCode") == 200) {
                        Gson gson = new Gson();
                        HomeBean userVo = gson.fromJson(result, HomeBean.class);
                        if (userVo.getCode() == 200) {
                            mHomeFragmentView.excuteSuccessCallBack(userVo);
                        } else {
                            CallBackVo mCallBackVo = new CallBackVo();
                            mCallBackVo.setCode(userVo.getCode());
                            mCallBackVo.setMessage(userVo.getMessage());
                            mCallBackVo.setData(null);
                            mHomeFragmentView.excuteFailedCallBack(mCallBackVo);
                        }
                    }else if (object.getInt("rtnCode") == 104){
                        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(BaseApplication.getContext());
                        Intent intent = new Intent();
                        intent.setAction("exitApp");
                        intent.putExtra("goWhere", 5);
                        lbm.sendBroadcast(intent);
                    }else {
                        Gson gson = new Gson();
                        CallBackVo userVo = gson.fromJson(result, CallBackVo.class);
                        CallBackVo mCallBackVo = new CallBackVo();
                        mCallBackVo.setCode(userVo.getCode());
                        mCallBackVo.setMessage(userVo.getMessage());
                        mCallBackVo.setData(null);
                        mHomeFragmentView.excuteFailedCallBack(mCallBackVo);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                LogUtil.i("putUserInfo", "-----------------" + statusCode + "");
                LogUtil.i("putUserInfo", "-----------------" + error.getMessage() + "");
                mHomeFragmentView.closeProgress();
                JsonLog.printJson("TAG" + "[onError]", error.getMessage(), "");
                CallBackVo mCallBackVo = new CallBackVo();
                mCallBackVo.setCode(404);
                mCallBackVo.setMessage("别着急哦~");
                mCallBackVo.setData(null);
                mHomeFragmentView.excuteFailedCallBack(mCallBackVo);
            }
        });
    }
}
