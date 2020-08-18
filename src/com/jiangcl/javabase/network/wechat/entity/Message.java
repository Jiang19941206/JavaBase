package com.jiangcl.javabase.network.wechat.entity;

/**
 * @author jiangcl
 * @date 2020/8/18
 * @desc 消息实体类
 */
public class Message {
    private String userId;

    private String msg;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
