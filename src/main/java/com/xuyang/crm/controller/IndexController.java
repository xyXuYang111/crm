package com.xuyang.crm.controller;

import com.xuyang.crm.model.Result;
import com.xuyang.crm.model.User;
import com.xuyang.crm.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Data
@Slf4j
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "error", method = RequestMethod.GET)
    public String login() {
        log.info("出来异常了");
        return "error";
    }
}
