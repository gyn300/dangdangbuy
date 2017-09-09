package com.servlet;

import com.control.UserControl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "CheckUserServlet")

public class CheckUserServlet extends HttpServlet {
    UserControl uc;

    @Override
    public void init() throws ServletException {
        uc=new UserControl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name  = request.getParameter("user_name");
        System.out.println(user_name);
        if(user_name!=null) {

            if (uc.getUser(user_name)!=null){

                response.getWriter().println(uc.getUser(user_name).toString());
             }else{

                response.getWriter().println("没有该用户");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
