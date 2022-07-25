package com.mypro.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//在过滤器中完成 请求 响应 对象中的中文编码操作
@WebFilter(urlPatterns = {"/*"}) //所有路径
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FilterConfig.doFilter");
        HttpServletRequest req  = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        req.setCharacterEncoding("utf-8");//设置请求中文编码
        res.setContentType("text/html;charset=utf-8");//设置响应中文编码
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
