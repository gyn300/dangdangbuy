package com.dao;

import com.model.Users;
import com.daoinf.UserDaoInf;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDao implements UserDaoInf {
    @Override
    /**
     * 添加记录
     */
    public int regist(String user_name, String user_pwd,String user_email) {
        String sql="insert into users(user_name,user_pwd,user_email) value(?,?,?)";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setString(1, user_name);
            ps.setString(2, user_pwd);
            ps.setString(3,user_email);
            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }

        return num;
    }

    @Override
    public boolean login(String user_name, String user_pwd) {
        return false;
    }

    @Override
    public int recharge(String user_name, double money) {
        String sql="update users set user_balance=(user_balance+?) where user_name=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setDouble(1, money);
            ps.setString(2, user_name);
            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return num;
    }

    @Override
    public double CheckBalance(String user_name) {
        return 0;
    }

    @Override
    public List<Users> getAllUser() {
        String sql="select * from users";
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Users> users=new ArrayList<>();
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                int user_id=rs.getInt("user_id");
                String user_name=rs.getString("user_name");
                String user_pwd=rs.getString("user_pwd");
                double user_balance=rs.getDouble("user_balance");
                int user_status=rs.getInt("user_status");
                String user_email=rs.getString("user_email");
                String user_address=rs.getString("user_address");
                String user_tel=rs.getString("user_tel");
                Users user=new Users(user_id, user_name, user_pwd, user_tel, user_address, user_email, user_balance, user_status);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }

        return users;
    }

    @Override
    public int modifyPassword(String user_name, String user_pwd) {
        String sql="update users set user_pwd=? where user_name=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setString(1, user_pwd);
            ps.setString(2, user_name);
            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return num;
    }
    /**
     * 修改电话号码
     */
    @Override
    public int modifyUser_tel(String user_name, String user_tel) {
        String sql="update users set user_tel=? where user_name=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setString(1, user_tel);
            ps.setString(2, user_name);
            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return num;
    }
    /**
     * 修改收货地址
     */
    @Override
    public int modifyUser_address(String user_name, String user_address) {
        String sql="update users set user_address=? where user_name=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setString(1, user_address);
            ps.setString(2, user_name);
            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return num;
    }
}
