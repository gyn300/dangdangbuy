package com.daoinf;


import com.model.Users;

import java.util.List;

public interface UserDaoInf {
    public int regist(String user_name,String user_pwd,String user_email);
    public boolean login(String user_name,String user_pwd);
    public int recharge(String user_name,double money);
    public double CheckBalance(String user_name);
    public List<Users> getAllUser();
    public int  modifyPassword(String user_name,String user_pwd);
    public int  modifyUser_tel(String user_name,String user_tel);
    public int  modifyUser_address(String user_name,String user_address);
}
