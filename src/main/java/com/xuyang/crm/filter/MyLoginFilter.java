package com.xuyang.crm.filter;

import com.xuyang.crm.model.Url;
import com.xuyang.crm.redis.RedisService;
import com.xuyang.crm.redis.redisRepository.RedisRepository;
import com.xuyang.crm.util.IpUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.swing.StringUIClientPropertyKey;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Data
@Slf4j
@Component
public class MyLoginFilter implements Filter {

    @Autowired
    private RedisService redisService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.debug("记录日志成功");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("销毁过滤器");
    }
}
