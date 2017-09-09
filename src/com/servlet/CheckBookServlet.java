package com.servlet;

import com.control.BookControl;
import com.model.PageData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "CheckBookServlet")
public class CheckBookServlet extends HttpServlet {
    BookControl bc;

    @Override
    public void init() throws ServletException {
        bc = new BookControl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取上一页或下一页的请求
        // 参数校验
        String pageNum = request.getParameter("pageNum");
        pageNum = pageNum == null ? "1" : pageNum;
        PageData pageData = bc.getPageData(Integer.parseInt(pageNum));
        // 把数据保存到request域中
        request.setAttribute("pageData", pageData);
        // 转发jsp页面
        request.getRequestDispatcher("admin.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}