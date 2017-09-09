package com.servlet;

import com.control.BookControl;
import com.control.OrderControl;
import com.control.ShoppingTrolleyControl;
import com.control.UserControl;
import com.model.Books;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/20.
 */
@WebServlet(name = "BuyBookServlet")
public class BuyBookServlet extends HttpServlet {
    BookControl  bc;
    UserControl uc;
    OrderControl oc;
    ShoppingTrolleyControl sc;
    @Override
    public void init() throws ServletException {
        bc=new BookControl();
        uc=new UserControl();
        oc=new OrderControl();
        sc=new ShoppingTrolleyControl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content=request.getParameter("content");
        String user_name=request.getSession().getAttribute("user_name").toString();
        String consumeMoney=request.getParameter("consumeMoney");
        if(user_name!=null&&consumeMoney!=null&&content!=null){
            if(uc.consume(user_name,Double.parseDouble(consumeMoney))){
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time=df.format(new Date());
                response.getWriter().print("购买成功");
                oc.addOrder(content,time,user_name);
                sc.delAll(user_name);
          }else{
                response.getWriter().print("余额不足");
            }
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
