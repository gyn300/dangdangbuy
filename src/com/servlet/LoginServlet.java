package com.servlet;

import com.control.UserControl;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet(name = "LoginServlet")

public class LoginServlet extends HttpServlet {
    UserControl uc;
    @Override
    public void init() throws ServletException {
        uc=new UserControl();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user_name=request.getParameter("user_name");
        String password=request.getParameter("password");
        String remember=request.getParameter("remember");
        System.out.println(remember);
        uc.updateAllUser();
        HttpSession session=request.getSession();
        boolean flag;
        int status=0;

        if(uc.judgeUser(user_name,password)==1){
            session.setAttribute("user_name",user_name);
            if (remember.equals("true")){

                Cookie cookie=new Cookie("user_name",user_name);
                cookie.setMaxAge(60*60*24*7);
                response.addCookie(cookie);
            }
            flag = true;

            status= uc.getStatus(user_name);//status==1表示管理员
            if(status==1){
                response.getWriter().print("admin"+flag);

            }else{

                response.getWriter().print(flag);
            }

        }else {
            flag=false;
            response.getWriter().print(flag);


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
