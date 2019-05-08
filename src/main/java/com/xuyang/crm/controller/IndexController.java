package com.xuyang.crm.controller;

import com.xuyang.crm.model.Result;
import com.xuyang.crm.model.User;
import com.xuyang.crm.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        log.info("跳转到登录界面");
        return "page/login";
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "userLogin", method = RequestMethod.POST)
    @ResponseBody
    public Result userLogin(@RequestBody User user, HttpSession session) {
        log.info("登录请求");
        Result result = new Result();
        User userInfo = userService.userInfo(user);
        try {
            if (userInfo == null) {
                result.setCode("0");
                result.setMsg("登录失败");
            } else {
                result.setCode("1");
                result.setMsg("登录成功");

                String userID = userInfo.getUserID();
                session.setAttribute("userID", userID);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("0");
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST)
    public String index(HttpSession session){
        log.info("主界面");
        String userID = (String) session.getAttribute("userID");
        User user = new User();
        user.setUserID(userID);
        User userInfo = userService.userInfo(user);
        return "page/index";
    }

    @RequestMapping(value = "loginOut", method = RequestMethod.POST)
    public String loginOut(HttpSession session) {
        log.info("用户退出");
        session.removeAttribute("userID");
        return "page/login";
    }
}
