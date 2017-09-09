package com.servlet;

import com.control.BookControl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/20.
 */
@WebServlet(name = "MdBookServlet")
public class MdBookServlet extends HttpServlet {
    BookControl bd;

    @Override
    public void init() throws ServletException {
        bd=new BookControl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String book_name=request.getParameter("book_name");
        String book_price=request.getParameter("book_price");
        String dangdang_price=request.getParameter("dangdang_price");
        String publishing =request.getParameter("publishing");
        String synopsis=request.getParameter("synopsis");
        String family=request.getParameter("family");
        String author =request.getParameter("author");
        System.out.println(id);
        if(id !=null ) {

            if ( book_name != null) {

                if (bd.updateBook_name(Integer.parseInt(id), book_name)) {

                    response.getWriter().println("修改成功");
                } else {

                    response.getWriter().println("修改失败");
                }
            }
            if ( book_price != null) {
                if (bd.updateBook_price(Integer.parseInt(id), Double.parseDouble(book_price))) {
                    response.getWriter().println("修改成功");
                } else {
                    response.getWriter().println("修改失败");
                }
            }
            if ( dangdang_price != null) {
                if (bd.updateDangdang_price(Integer.parseInt(id), Double.parseDouble(dangdang_price))) {
                    response.getWriter().println("修改成功");
                } else {
                    response.getWriter().println("修改失败");
                }
            }
            if ( publishing != null) {
                if (bd.updatePublishing(Integer.parseInt(id), publishing)) {
                    response.getWriter().println("修改成功");
                } else {
                    response.getWriter().println("修改失败");
                }
            }
            if ( synopsis != null) {
                if (bd.updateSynopsis(Integer.parseInt(id), synopsis)) {
                    response.getWriter().println("修改成功");
                } else {
                    response.getWriter().println("修改失败");
                }
            }
            if ( family != null) {
                if (bd.updateFamily(Integer.parseInt(id), family)) {
                    response.getWriter().println("修改成功");
                } else {
                    response.getWriter().println("修改失败");
                }
            }
            if ( author != null) {
                if (bd.updateAuthor(Integer.parseInt(id), author)) {
                    response.getWriter().println("修改成功");
                } else {
                    response.getWriter().println("修改失败");
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
