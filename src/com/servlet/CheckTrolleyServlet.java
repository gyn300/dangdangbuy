package com.servlet;

import com.control.BookControl;
import com.control.ShoppingTrolleyControl;
import com.control.UserControl;
import com.model.Books;
import com.model.ShoppingTrolley;
import com.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */
@WebServlet(name = "CheckTrolleyServlet")
public class CheckTrolleyServlet extends HttpServlet {
    ShoppingTrolleyControl sc;
    BookControl bc;
    UserControl uc;
    @Override
    public void init() throws ServletException {
        sc=new ShoppingTrolleyControl();
        bc=new BookControl();
        uc=new UserControl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name=request.getSession().getAttribute("user_name").toString();
        List<ShoppingTrolley> list=null;

        if(user_name!=null){
            list=sc.getShoppingTrolley(user_name);
        }
        if(list==null||list.size()==0){

            response.getWriter().println("购物车为空");
            request.getRequestDispatcher("shoppingTrolley.jsp").forward(request,response);
        }else{
            List<Books> books=bc.getBooks();

            Users user=uc.getUser(user_name);
            request.setAttribute("bc",bc);
            request.setAttribute("user",user);
            request.setAttribute("list",list);
            request.getRequestDispatcher("shoppingTrolley.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
