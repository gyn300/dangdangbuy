package com.servlet;

import com.control.OrderControl;
import com.model.PageData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "CheckOrdersServlet")
public class CheckOrdersServlet extends HttpServlet {
    OrderControl oc;

    @Override
    public void init() throws ServletException {
        oc=new OrderControl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取上一页或下一页的请求
        // 参数校验
        String user_name=request.getSession().getAttribute("user_name").toString();
        String pageNum = request.getParameter("pageNum");
        pageNum = pageNum == null ? "1" : pageNum;
        PageData pageData = oc.getOrdersPageData(Integer.parseInt(pageNum),user_name);
        // 把数据保存到request域中
        request.setAttribute("pageData", pageData);
        // 转发jsp页面
        request.getRequestDispatcher("userInformation.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
