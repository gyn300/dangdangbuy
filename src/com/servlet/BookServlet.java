package com.servlet;

import com.control.BookControl;
import com.model.Books;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */
@WebServlet(name = "BookServlet")
public class BookServlet extends HttpServlet {
    BookControl bc;

    @Override
    public void init() throws ServletException {
        bc=new BookControl();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Books> books=bc.getBooks();
        request.setAttribute("books",books);
        request.getRequestDispatcher("welcome.jsp").forward(request,response);
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for(Cookie c : cookies){
                if("user_name".equals(c.getName())){
                   String user_name=c.getValue();
                   request.getSession().setAttribute("user_name",user_name);
                   break;
                }

            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
