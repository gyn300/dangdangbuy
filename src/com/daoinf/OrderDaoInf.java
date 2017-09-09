package com.daoinf;


import com.model.Orders;

import java.util.List;

public interface OrderDaoInf {
    public List<Orders> getAllOrders();
    public int addOrder(String content, String time,String user_name);
}
