package com.dao;


import com.daoinf.OrderDaoInf;
import com.model.Orders;
import com.model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements OrderDaoInf{

    @Override
    public List<Orders> getAllOrders() {
        String sql="select * from orders";
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Orders> orders=new ArrayList<>();
        try {
            ps=Baseconn.getConn().prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("id");
                String content=rs.getString("content");
                String time=rs.getString("time");
                String user_name=rs.getString("user_name");
                Orders order=new Orders(id,content,time,user_name);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Baseconn.closeAll(rs, ps);
        }

        return orders;
    }

    /**
     * 添加订单
     */

    @Override
    public int addOrder(String content, String time,String user_name) {
            String sql="insert into orders(content,time,user_name) value(?,?,?)";
            PreparedStatement ps=null;
            ResultSet rs=null;
            int num=0;
            try {
                ps=Baseconn.getConn().prepareStatement(sql);
                ps.setString(1, content);
                ps.setString(2, time);
                ps.setString(3, user_name);
                num=ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                Baseconn.closeAll(rs, ps);
            }

            return num;
        }
    }

