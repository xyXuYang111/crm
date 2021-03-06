package com.xuyang.crm.model;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Auther: xuy
 * @Date: 2019/5/4 03:08
 * @Description:
 */
@Data
@Slf4j
@ToString
public class History implements Serializable {

    private static final long serialVersionUID = -2881418366837280067L;

    private String historyID;

    private String userID;

    /**
     * 操作命
     */
    private String historyName;

    /**
     * 操作内容
     */
    private String historyContext;

    /**
     * 运行结果
     */
    private String historyStatue;
}
