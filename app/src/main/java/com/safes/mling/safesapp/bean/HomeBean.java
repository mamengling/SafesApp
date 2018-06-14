package com.safes.mling.safesapp.bean;

/**
 * Created by MLing on 2018/6/14 0014.
 */

public class HomeBean {
    /**
     * code : 0
     * message : success
     * data : {"id":"28","username":"15554509193","status":"0","token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IjE1NTU0NTA5MTkzIiwiaWF0IjoxNTE5NTc0NDAwLCJuYmYiOjE1MTk1NzQ0MDB9.Avxccpj25XQbWglmkpLCUDPgZspeMszzoHiamjmuA-c","leixing":"2","nickname":"","avatar":"","gender":"0","onclick":"0","lng":"0.000000","lat":"0.000000","province":"","city":"","area":"","address":"","devicetype":"1","lastversion":"1.0","loginnum":"1","lasttime":"1519103823","channelid":"5762820962650265056"}
     */

    private int code;
    private String message;
    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
