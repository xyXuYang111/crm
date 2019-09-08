package com.xuyang.crm.model;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Auther: xuy
 * @Date: 2019/5/4 03:04
 * @Description:
 */
@Data
@Slf4j
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = -2728917107256427803L;

    private String userID;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 邮箱
     */
    private String email;
}
