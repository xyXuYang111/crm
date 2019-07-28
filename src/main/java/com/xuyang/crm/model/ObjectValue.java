package com.xuyang.crm.model;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Auther: 许洋
 * @Date: 2019/7/28 22:36
 * @Description:
 */
@Slf4j
@Data
@ToString
public class ObjectValue implements Serializable {

    private static final long serialVersionUID = -3654963681509028252L;

    private String id;

    private String objectName;

    private String objectContext;

    private String createTime;

    private String updateTime;

    private String userName;
}
