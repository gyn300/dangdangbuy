package com.servlet;

import com.control.ShoppingTrolleyControl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "MdShoppingTrolleyServlet")
public class MdShoppingTrolleyServlet extends HttpServlet {
    ShoppingTrolleyControl sc;

    @Override
    public void init() throws ServletException {
        sc=new ShoppingTrolleyControl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String count=request.getParameter("count");
        String book_id=request.getParameter("book_id");
        String user_name=request.getSession().getAttribute("user_name").toString();
        if(count!=null&&book_id!=null&&user_name!=null){
            if(sc.updateCount(Integer.parseInt(count),Integer.parseInt(book_id),user_name)){
                response.getWriter().println("更改成功");
            }else{
                response.getWriter().println("更改失败");
            }
        }
        if(count==null&&book_id!=null&&user_name!=null){
            if(sc.delTrolley(Integer.parseInt(book_id),user_name)){
                response.getWriter().println("删除成功");
            }else{
                response.getWriter().println("删除失败");
            }
        }
        if(count==null&&book_id==null&&user_name!=null){
            if(sc.delAll(user_name)){
                response.getWriter().println("删除成功");
            }else{
                response.getWriter().println("删除失败");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
