package com.daoinf;


import com.model.ShoppingTrolley;

import java.util.List;

public interface ShoppingTrolleyDaoInf {
    public List<ShoppingTrolley> getShoppingTrolley(String user_name);
    public int add(int book_id,String user_name);
    public int del(int book_id,String user_name);
    public int delAll(String user_name);
    public int updateCount(int count,int book_id,String user_name);
}
