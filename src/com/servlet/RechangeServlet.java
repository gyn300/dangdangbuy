package com.servlet;

import com.control.UserControl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/20.
 */
@WebServlet(name = "RechangeServlet")
public class RechangeServlet extends HttpServlet {
    UserControl uc;

    @Override
    public void init() throws ServletException {
        uc=new UserControl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name=request.getSession().getAttribute("user_name").toString();
        String rechangeMoney=request.getParameter("rechangeMoney");

        if(user_name!=null&&rechangeMoney!=null){

            if(uc.recharge(user_name,Double.parseDouble(rechangeMoney))){
                response.getWriter().println("充值成功");
            }else{
                response.getWriter().println("账号不存在");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
