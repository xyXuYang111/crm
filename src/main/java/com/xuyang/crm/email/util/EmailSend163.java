package com.xuyang.crm.email.util;

import com.xuyang.crm.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

;

/**
 * @Auther: 许洋
 * @Date: 2019/1/6 21:39
 * @Description: 网易邮箱
 */
@Slf4j
@Component
public class EmailSend163 {

    public boolean sendMail(Email email) throws Exception {

        // 定义Properties对象,设置环境信息
        Properties props = new Properties();
        //设置邮件服务器的地址
        props.setProperty("mail.smtp.host", "smtp.163.com");
        // 指定的smtp服务器
        props.setProperty("mail.smtp.auth", "true");
        //设置发送邮件使用的协议
        props.setProperty("mail.transport.protocol", "smtp");
        // 创建Session对象,session对象表示整个邮件的环境信息
        Session session = Session.getInstance(props);
        //设置输出调试信息
        session.setDebug(true);
        log.info("短信发送开始");
        //Message的实例对象表示一封电子邮件
        MimeMessage message = new MimeMessage(session);
        //设置发件人的地址
        message.setFrom(new InternetAddress(email.getSendNumber()));
        //设置主题
        message.setSubject(email.getTitleName());
        //设置邮件的文本内容
        message.setText(email.getTitleName());
        message.setContent(email.getMessage(), "text/html;charset=utf-8");            //从session的环境中获取发送邮件的对象
        Transport transport = session.getTransport();
        //连接邮件服务器
        transport.connect("smtp.163.com", 25, email.getSendNumber(), email.getSendPassword());
        //设置收件人地址,并发送消息
        transport.sendMessage(message, new Address[]{new InternetAddress(email.getReceiveNumber())});
        transport.close();
        log.info("短信发送结束");
        return true;
    }
}
