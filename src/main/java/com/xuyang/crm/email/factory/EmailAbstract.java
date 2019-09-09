package com.xuyang.crm.email.factory;

import com.xuyang.crm.email.service.EmailMongoDB;
import com.xuyang.crm.email.service.EmailService;
import com.xuyang.crm.model.Email;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: xuyang
 * @Date: 2019/9/10 01:14
 * @Description:
 */
@Data
@Slf4j
@Component
public abstract class EmailAbstract implements EmailInterface{

    protected Email emailInfo;

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailMongoDB emailMongoDB;

    @Override
    public void sendMail() throws Exception{
        emailMongoDB.insertEmail(emailInfo);
        emailService.insertEmail(emailInfo);
    }
}
