package com.xuyang.crm.email.util;

import com.xuyang.crm.model.Mail;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;

import java.net.URL;

/**
 * @Auther: cypc
 * @Date: 2019-3-29 11:50
 * @Description:
 */
public class HtmlEmailUtil {

    public boolean send(Mail mail) throws Exception {
        // 发送email
        HtmlEmail email = new HtmlEmail();
        // 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
        email.setHostName(mail.getHost());
        // 字符编码集的设置
        email.setCharset(Mail.ENCODEING);
        // 收件人的邮箱
        email.addTo(mail.getReceiver());
        // 发送人的邮箱
        email.setFrom(mail.getSender(), mail.getName());
        // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
        email.setAuthentication(mail.getUsername(), mail.getPassword());
        // 要发送的邮件主题
        email.setSubject(mail.getSubject());
        // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
        email.setMsg(mail.getMessage());
        //文件附件:可上传多个
        EmailAttachment attachment = new EmailAttachment();//创建附件
        attachment.setPath("D:\\MongoDB.txt");//本地附件，绝对路径
        attachment.setURL(new URL("http://www.baidu.com/moumou附件"));//可添加网络上的附件
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("MongoDB入门精通");//附件描述
        attachment.setName("NoSQL数据库");//附件名称
        email.attach(attachment);//添加附件到邮件,可添加多个
        // 发送
        email.send();
        return true;
    }
}
