package com.xuyang.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Auther: xuy
 * @Date: 2019/3/28 01:04
 * @Description:
 */
@Data
@Slf4j
@ToString
public class ResultJson implements Serializable {

    private static final long serialVersionUID = -7627924395932767364L;

    @JsonProperty(value = "state")
    private String state;

    @JsonProperty(value = "result")
    private String result;
}
