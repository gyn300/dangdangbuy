package com.control;

import com.dao.BookDao;
import com.dao.ShoppingTrolleyDao;
import com.daoinf.BookDaoInf;
import com.daoinf.ShoppingTrolleyDaoInf;
import com.model.Books;
import com.model.ShoppingTrolley;

import java.util.List;

public class ShoppingTrolleyControl {
    List<ShoppingTrolley> shoppingTrolley;
    ShoppingTrolleyDaoInf sdi = new ShoppingTrolleyDao();

    /**
     * 获得指定用户购物列表
     * @param user_name
     * @return
     */
    public List<ShoppingTrolley> getShoppingTrolley(String user_name){
        return sdi.getShoppingTrolley(user_name);
    }
    /**
     * 加入购物车
     */
    public boolean addTrolley(int book_id,String user_name){
        boolean flag=false;

        shoppingTrolley=getShoppingTrolley(user_name);

        if(shoppingTrolley.size()!=0) {

            for (int i = 0; i < shoppingTrolley.size(); i++) {
                if (shoppingTrolley.get(i).getBook_id() == book_id && shoppingTrolley.get(i).getUser_name() == user_name) {
                    if (updateCount(shoppingTrolley.get(i).getCount() + 1, book_id, user_name)) {
                        flag = true;
                        break;
                    }
                }
                if (i == shoppingTrolley.size() - 1) {
                    if (sdi.add(book_id, user_name) != 0) {
                        flag = true;
                    }
                }
            }
        }else {

            if (sdi.add(book_id, user_name) != 0) {

                flag = true;
            }

        }
        return flag;
    }
    /**
     * 删除购物记录
     */
    public boolean delTrolley(int book_id,String user_name){
        boolean flag=false;
        if(sdi.del(book_id,user_name)!=0){
            flag=true;
        }
        return flag;
    }
    /**
     * 清空购物记录
     */
    public boolean delAll(String user_name){
        boolean flag=false;
        if(sdi.delAll(user_name)!=0){
            flag=true;
        }
        return flag;
    }
    /**
     * 更新购买数量
     */
    public boolean updateCount(int count,int book_id,String user_name){
        boolean flag=false;
        if(sdi.updateCount(count,book_id,user_name)!=0){
            flag=true;
        }
        return flag;
    }
}
