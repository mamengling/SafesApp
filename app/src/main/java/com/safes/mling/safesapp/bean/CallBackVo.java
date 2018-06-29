package com.safes.mling.safesapp.bean;

/**
 * 说明：基础实体类
 * 作者： MLing
 * 邮箱：mamenglingkl1314@163.com
 * 创建时间 ：2017/6/9 17:15.
 */

public class CallBackVo<T> {

    /**
     * code : 0
     * message : success
     * data : {"id":"28","username":"15554509193","status":"0","token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IjE1NTU0NTA5MTkzIiwiaWF0IjoxNTE5NTc0NDAwLCJuYmYiOjE1MTk1NzQ0MDB9.Avxccpj25XQbWglmkpLCUDPgZspeMszzoHiamjmuA-c","leixing":"2","nickname":"","avatar":"","gender":"0","onclick":"0","lng":"0.000000","lat":"0.000000","province":"","city":"","area":"","address":"","devicetype":"1","lastversion":"1.0","loginnum":"1","lasttime":"1519103823","channelid":"5762820962650265056"}
     */

    private int errcode;
    private String errmsg;
    private T data;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
