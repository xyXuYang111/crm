package com.xuyang.crm.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: xuyang
 * @Date: 2019/10/6 18:37
 * @Description:
 */
@Slf4j
@Controller
public class BaseController {

    @ModelAttribute
    public void init(Model model, HttpServletRequest req) throws Exception {
        log.debug("前置处理");
        String url = "http://192.168.133.131:8000/crm/";
        log.debug("相对路径：" + url);
        model.addAttribute("url", url);
    }
}
