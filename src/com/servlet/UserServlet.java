package com.servlet;

import com.control.UserControl;
import com.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "CheckUserServlet")

public class UserServlet extends HttpServlet {
    UserControl uc;

    @Override
    public void init() throws ServletException {
        uc=new UserControl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name  = request.getSession().getAttribute("user_name").toString();
        System.out.println(user_name);
        if(user_name!=null) {

            if (uc.getUser(user_name)!=null){

                Users user=uc.getUser(user_name);
                request.setAttribute("user",user);
                request.getRequestDispatcher("shoppingTrolley.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
