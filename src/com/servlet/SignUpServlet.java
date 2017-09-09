package com.servlet;

import com.control.UserControl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "SignUpServlet")
public class SignUpServlet extends HttpServlet {
    UserControl uc;
    @Override
    public void init() throws ServletException {
                uc=new UserControl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String user_name=request.getParameter("user_name");
        String password=request.getParameter("password");
        String user_email=request.getParameter("user_email");
        String vcode=request.getParameter("vcode");
        uc.updateAllUser();
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        boolean flag;

        if(vcode.toUpperCase().equals(request.getSession().getAttribute("validateCode"))){
          if(uc.judgeUserEmail(user_email)==-1){
            if(uc.judgeUserName(user_name)==-1){
                if(uc.register(user_name,password,user_email)){
                    response.getWriter().print("注册成功");
                }
            }else {
                response.getWriter().println("用户昵称已经存在");
            }
        }else {
            response.getWriter().println("邮箱已经存在");
        }
      }else{
            response.getWriter().print("验证码错误");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
