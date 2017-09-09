package com.model;

public class Users {
    private int user_id;
    private String user_name;
    private String user_pwd;


    private String user_tel;
    private String user_address;
    private String user_email;
    private double user_balance;
    private int user_status;

    public Users(int user_id, String user_name, String pwd, String user_tel, String user_address, String user_email, double user_balance, int user_status) {
        super();
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pwd = pwd;
        this.user_tel = user_tel;
        this.user_address = user_address;
        this.user_email = user_email;
        this.user_balance = user_balance;
        this.user_status = user_status;
    }

    public Users(String user_name, String pwd, String user_tel, String user_address, String user_email, double user_balance) {
        super();
        this.user_name = user_name;
        this.user_pwd = pwd;
        this.user_tel = user_tel;
        this.user_address = user_address;
        this.user_email = user_email;
        this.user_balance = user_balance;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String pwd) {
        this.user_pwd = pwd;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public double getUser_balance() {
        return user_balance;
    }

    public void setUser_balance(double user_balance) {
        this.user_balance = user_balance;
    }

    public int getUser_status() {
        return user_status;
    }

    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }

    @Override
    public String toString() {
        return "id:"+user_id + ",\t" + "用户名:"+user_name + ",\t"+"用户余额:" + user_balance + ",\t"+"用户状态:" + user_status + ",\t"+"用户邮箱:" + user_email;
    }


}
