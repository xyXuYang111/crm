package com.xuyang.crm.controller;

import com.xuyang.crm.Exception.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Auther: xuy
 * @Date: 2019/5/4 12:34
 * @Description:
 */
@Slf4j
@Controller
public class SessionController extends BaseController {

    @ResponseBody
    @RequestMapping(value = "/insertSpringSessionText", method = RequestMethod.POST)
    public String insertSpringSessionText(HttpSession session){
        log.debug("存储session，实现测试数据");
        session.setAttribute("session_1", "session_1");
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/getSpringSessionText", method = RequestMethod.POST)
    public String getSpringSessionText(HttpSession session){
        String value = (String)session.getAttribute("session_1");
        log.debug("获取session："+value);
        return value;
    }
}