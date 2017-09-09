package com.servlet;

import com.control.UserControl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ModifyServlet")
public class ModifyServlet extends HttpServlet {
    UserControl uc;

    @Override
    public void init() throws ServletException {
        uc=new UserControl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String user_name=request.getParameter("user_name");
        String password=request.getParameter("password");
        String tel=request.getParameter("tel");
        String address=request.getParameter("address");
        uc.updateAllUser();
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        if(user_name!=null&&user_name!=""){
            if(password!=null&&password!=""){
                if(uc.modifyPassword(user_name,password)){//ture表示修改成功
                   response.getWriter().print("密码修改成功");
                }
            }
            if(tel!=null&&tel!=""){
                if(uc.modifyTel(user_name,tel)){
                    response.getWriter().print("电话号码修改成功");
                }
            }
            if(address!=null&&address!=""){
                if(uc.modifyAddress(user_name,address)){
                    response.getWriter().print("收货地址修改成功");
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
