package com.xuyang.crm.controller;

import com.xuyang.crm.Exception.BaseController;
import com.xuyang.crm.model.Menu;
import com.xuyang.crm.service.ObjectService;
import com.xuyang.crm.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
@Slf4j
@Controller
public class IndexController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectService objectService;

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "indexPage", method = RequestMethod.GET)
    public String indexPage() {
        log.info("项目主页");
        return "index";
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "/fileIndex", method = RequestMethod.GET)
    public String fileIndex() {
        log.info("文件上传主页");
        return "file/file";
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "/messageIndex", method = RequestMethod.GET)
    public String messageIndex() {
        log.info("文件上传主页");
        return "message/message";
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "/loggerIndex", method = RequestMethod.GET)
    public String loggerIndex() {
        log.info("文件上传主页");
        return "log/logger";
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        log.info("关于个人的主页");
        return "about/about";
    }

    @ResponseBody
    @RequestMapping(value = "/formDataText", method = RequestMethod.POST)
    public Menu formDataText(Menu menu){
        log.debug("测试接收到的数据");
        log.debug(menu.toString());
        return menu;
    }
}
