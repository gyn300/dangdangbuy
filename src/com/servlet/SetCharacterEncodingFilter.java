package com.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/17.
 */
@WebFilter(filterName = "SetCharacterEncodingFilter")
public class SetCharacterEncodingFilter implements Filter {

    private String encoding;


    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        System.out.println("CharsetEncodingFilter--->>>begin");

        //设置web.xml中配置的字符集
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);

        System.out.println("CharsetEncodingFilter--->>>doing");

        //继续执行
        chain.doFilter(request, response);

        System.out.println("CharsetEncodingFilter--->>>end");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
        System.out.println("CharsetEncodingFilter.init()-->> encoding=" + encoding);
    }

}
