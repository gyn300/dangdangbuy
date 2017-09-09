package com.servlet;

import com.control.BookControl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "AddBookServlet")
public class AddBookServlet extends HttpServlet {
    BookControl bd;

    @Override
    public void init() throws ServletException {
        bd=new BookControl();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String book_name=request.getParameter("book_name");
        String book_price=request.getParameter("book_price");
        String dangdang_price=request.getParameter("dangdang_price");
        String publishing =request.getParameter("publishing");
        String synopsis=request.getParameter("synopsis");
        String family=request.getParameter("family");
        String author =request.getParameter("author");

        if(bd.regist(book_name,Double.valueOf(book_price),Double.valueOf(dangdang_price),publishing,synopsis,family,author)){

            response.getWriter().println("添加成功");
        }else {
            response.getWriter().println("添加失败");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
