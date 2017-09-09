package com.servlet;

import com.control.BookControl;
import com.model.Books;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/21.
 */
@WebServlet(name = "CommodityServlet")
public class CommodityServlet extends HttpServlet {
    BookControl bc;

    @Override
    public void init() throws ServletException {
        bc=new BookControl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            Books book = bc.getBook(Integer.parseInt(id));
            request.setAttribute("book", book);
            request.getRequestDispatcher("commodityMessage.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
