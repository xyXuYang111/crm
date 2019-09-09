package com.xuyang.crm.model;

/**
 * @Auther: cypc
 * @Date: 2019-3-29 11:51
 * @Description:
 */

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * Mail属性实体
 *
 * @author shadow
 *
 */
@Data
@Slf4j
@ToString
public class Mail implements Serializable {

    public static final String ENCODEING = "UTF-8";

    private String host; // 服务器地址

    private String sender; // 发件人的邮箱

    private String receiver; // 收件人的邮箱

    private String name; // 发件人昵称

    private String username; // 账号

    private String password; // 密码

    private String subject; // 主题

    private String message; // 信息(支持HTML)

}
