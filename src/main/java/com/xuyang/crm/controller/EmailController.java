package com.xuyang.crm.controller;

import com.xuyang.crm.Exception.BaseController;
import com.xuyang.crm.email.factory.EmailFactory;
import com.xuyang.crm.email.factory.EmailInterface;
import com.xuyang.crm.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: xuyang
 * @Date: 2019/9/10 01:07
 * @Description:
 */
@Slf4j
@Controller
public class EmailController extends BaseController {

    /**
     * 给qq邮箱发邮件
     * @param emailParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sendEmail")
    public String sendQqEmail(Email emailParam) throws Exception{

        log.debug("开始发送邮件");
        EmailInterface emailInterface = EmailFactory.getAbstractFile(emailParam);
        emailInterface.sendMail();

        return "email/email";
    }
}
