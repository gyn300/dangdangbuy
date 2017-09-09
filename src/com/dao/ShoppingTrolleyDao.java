package com.dao;


import com.daoinf.ShoppingTrolleyDaoInf;
import com.model.ShoppingTrolley;
import com.model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingTrolleyDao implements ShoppingTrolleyDaoInf{

    @Override
    public List<ShoppingTrolley> getShoppingTrolley(String user_name) {
        String sql="select * from shoppingtrolley where user_name=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<ShoppingTrolley> shoppingTrolley=new ArrayList<>();
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setString(1,user_name);
            rs=ps.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("id");

                int book_id=rs.getInt("book_id");
                int count=rs.getInt("count");

                ShoppingTrolley s=new ShoppingTrolley(id,book_id,count,user_name);
                shoppingTrolley.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }

        return shoppingTrolley;
    }

    @Override
    public int add(int book_id, String user_name) {
        String sql="insert into shoppingtrolley(book_id,user_name) value(?,?)";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setInt(1, book_id);
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
    public int del(int book_id, String user_name) {
        String sql="delete from shoppingtrolley where book_id=? and user_name=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setInt(1, book_id);
            ps.setString(2,user_name);
            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return num;
    }

    @Override
    public int delAll(String user_name) {
        String sql="delete from shoppingtrolley where user_name=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);

            ps.setString(1,user_name);
            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return num;
    }

    @Override
    public int updateCount(int count,int book_id,String user_name) {
        String sql="update shoppingtrolley set count=? WHERE book_id=? and user_name=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            ps.setInt(1, count);
            ps.setInt(2, book_id);
            ps.setString(3,user_name);

            num=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }
        return num;
    }
}
