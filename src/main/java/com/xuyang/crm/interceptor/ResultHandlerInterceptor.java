package com.xuyang.crm.interceptor;

import com.xuyang.crm.model.Url;
import com.xuyang.crm.redis.RedisService;
import com.xuyang.crm.util.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class ResultHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("访问拦截");
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
        redisService.put("REQUEST", String.valueOf(System.currentTimeMillis()), urlInfo);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       log.debug("执行结果拦截");
       redisService.leftPush("SUCCESS", handler.toString());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
