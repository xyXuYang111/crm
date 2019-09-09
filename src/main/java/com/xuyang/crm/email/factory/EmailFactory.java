package com.xuyang.crm.email.factory;

import com.xuyang.crm.Exception.MyException;
import com.xuyang.crm.email.def.EmailDef;
import com.xuyang.crm.email.factory.type.EmailType1;
import com.xuyang.crm.email.factory.type.EmailType2;
import com.xuyang.crm.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: xuyang
 * @Date: 2019/9/10 01:16
 * @Description:
 */
@Slf4j
@Component
public class EmailFactory {

    private static EmailType1 emailType1;

    @Autowired
    public void setEmailType1(EmailType1 emailType1) {
        EmailFactory.emailType1 = emailType1;
    }

    private static EmailType2 emailType2;

    @Autowired
    public void setEmailType2(EmailType2 emailType2) {
        EmailFactory.emailType2 = emailType2;
    }

    public static EmailAbstract getAbstractFile(Email email) throws Exception{

        if (email == null) {
            log.error("文件信息不存在。");
            new MyException("文件类型不存在");
        }

        String type = email.getType();

        if (EmailDef.TYPE_1.contains(type)) {
            emailType1.setEmailInfo(email);
            return emailType1;
        } else if (EmailDef.TYPE_2.contains(type)) {
            emailType2.setEmailInfo(email);
            return emailType2;
        } else {
            emailType1.setEmailInfo(email);
            return emailType1;
        }
    }
}
