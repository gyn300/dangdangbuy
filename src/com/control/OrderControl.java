package com.control;


import com.dao.OrderDao;
import com.daoinf.OrderDaoInf;
import com.model.Books;
import com.model.Orders;
import com.model.PageData;
import com.model.Users;

import java.util.ArrayList;
import java.util.List;

public class OrderControl {
    List<Orders> orders;
    OrderDaoInf odi=new OrderDao();
    public void updateAllOrders(){
        orders  = odi.getAllOrders();
    }
    /**
     * 通过名字查找订单
     */
    public List<Orders> getOrders(String user_name) {
        updateAllOrders();
        List<Orders> ordersList=new ArrayList<>();
        for (Orders order:orders
             ) {
            if(user_name.equals(order.getUser_name())){
                ordersList.add(order);
            }
        }
        return ordersList;
    }
    public boolean addOrder(String content,String time,String user_name){
        boolean flag=false;
        if (odi.addOrder(content,time,user_name)!=0){
            flag=true;
        }
        return flag;
    }
    /**
     * 得到order分页数据
     */
    public PageData getOrdersPageData(int pageNum, String user_name)  {
        PageData pageData = new PageData();
        // 获取总记录数
        int count =getOrders(user_name).size();
        // 赋值的同时，算出总页数
        pageData.setCount(count);
        // pageNum 判断值是否正确 ，最小值是1，不允许有0或负数。
        pageNum = pageNum < 1 ? 1 : pageNum;

        // 如果大于最大页数，就等于最大页数
        if(pageData.getPageCount()<1) {
            pageData.setPageCount(1);
        }
        pageNum = pageNum > pageData.getPageCount() ? pageData.getPageCount() : pageNum;
        // 赋值当前页码
        pageData.setPageNum(pageNum);
        // 获取数据调用dao

        List<Orders> list = getPageOrdersList(pageData.getStart(),pageData.getPageSize(),user_name);
        // 设置分页数据list到PageData中
        pageData.setList(list);
        return pageData;

    }
    /**
     * 获得orders分页书本列表
     */
    public List<Orders> getPageOrdersList(int start,int size,String user_name){
        List<Orders> orders=getOrders(user_name);
        List<Orders> pageOrders=new ArrayList<>();
        if(orders!=null){
            for (int i = start; i <(start+size>orders.size()?orders.size():start+size); i++) {

                pageOrders.add(orders.get(i));

            }
        }

        return pageOrders;
    }
}
