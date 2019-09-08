package com.xuyang.crm.model;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Auther: xuy
 * @Date: 2019/5/4 03:03
 * @Description:
 */
@Data
@Slf4j
@ToString
public class Menu implements Serializable {

    private static final long serialVersionUID = -2322614864119531461L;

    private String menuID;

    private String userID;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单接口
     */
    private String menuUrl;

    /**
     * 上级菜单ID
     */
    private String parentID;

    private String json;
}
