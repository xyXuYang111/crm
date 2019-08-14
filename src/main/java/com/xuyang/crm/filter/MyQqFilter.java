package com.xuyang.crm.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Auther: cypc
 * @Date: 2019/8/1 19:18
 * @Description:
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class MyQqFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.debug("拦截放行");
        HttpServletRequest request = (HttpServletRequest)servletRequest;

        String uri = request.getRequestURI();//返回请求行中的资源名称
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
