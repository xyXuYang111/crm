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
@WebFilter(filterName = "MyLoginFilter", urlPatterns = "/*")
public class MyLoginFilter implements Filter {

    @Autowired
    private RedisService redisService;

    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;

        //获取ip地址
        String ip = IpUtil.getIpAddress(request);
        String uri = request.getRequestURI();//返回请求行中的资源名称
        String url = request.getRequestURL().toString();//获得客户端发送请求的完整url
        String returnIp = request.getRemoteAddr();//返回发出请求的IP地址
        String params = request.getQueryString();//返回请求行中的参数部分
        String host=request.getRemoteHost();//返回发出请求的客户机的主机名
        int port =request.getRemotePort();//返回发出请求的客户机的端口号。

        Url urlInfo = new Url();
        urlInfo.setIp(ip);
        urlInfo.setUri(uri);
        urlInfo.setUrl(url);
        urlInfo.setReturnIp(returnIp);
        urlInfo.setParams(params);
        urlInfo.setHost(host);
        urlInfo.setPort(port);
        redisService.put(ip, String.valueOf(System.currentTimeMillis()), urlInfo);
        log.debug("记录日志成功");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("销毁过滤器");
    }
}
