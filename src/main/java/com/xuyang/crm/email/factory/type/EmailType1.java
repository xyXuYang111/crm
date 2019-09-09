package com.xuyang.crm.email.factory.type;

import com.xuyang.crm.email.factory.EmailAbstract;
import com.xuyang.crm.email.util.EmailQq;
import com.xuyang.crm.model.Email;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Auther: xuyang
 * @Date: 2019/9/10 01:17
 * @Description: qq邮箱邮件发送
 */
@Component
@Slf4j
@Data
@Scope("prototype")
public class EmailType1 extends EmailAbstract {

    @Override
    public void sendMail() throws Exception {

        Email email = new Email();
        email.setTitleName(emailInfo.getTitleName());
        email.setMessage(emailInfo.getMessage());
        email.setSendName(emailInfo.getSendName());
        email.setSendNumber(emailInfo.getSendNumber());
        email.setReceiveNumber("许洋");
        email.setReceiveNumber("1824650783@qq.com");
        email.setReceivePassword("wjtbyokdodejbccj");

        EmailQq emailQq = new EmailQq();
        emailQq.sendEmailQq(email);

        emailInfo = email;

        super.sendMail();
    }
}
