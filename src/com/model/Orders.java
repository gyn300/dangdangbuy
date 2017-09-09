package com.model;


public class Orders {
    private int id;
    private String content;
    private String time;
    private String user_name;

    public Orders(int id, String content, String time,String user_name) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.user_name=user_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "订单{" +
                "订单编号=" + id +
                ", 购买物品='" + content + '\'' +
                ", 购买时间='" + time + '\'' +
                '}';
    }
}
