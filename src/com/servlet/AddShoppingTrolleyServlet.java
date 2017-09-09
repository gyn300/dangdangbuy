package com.servlet;

import com.control.ShoppingTrolleyControl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/21.
 */
@WebServlet(name = "AddShoppingTrolleyServlet")
public class AddShoppingTrolleyServlet extends HttpServlet {
    ShoppingTrolleyControl sc;

    @Override
    public void init() throws ServletException {
        sc=new ShoppingTrolleyControl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String book_id = request.getParameter("book_id");
        String user_name = request.getSession().getAttribute("user_name").toString();

        if (book_id!=null&&user_name!=null) {
            if (sc.addTrolley(Integer.parseInt(book_id), user_name)) {
                response.getWriter().println("添加成功");
            } else {
                response.getWriter().println("添加失败");
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
