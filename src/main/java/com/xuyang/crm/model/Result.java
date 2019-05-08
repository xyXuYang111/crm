package com.xuyang.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@ToString
public class Result {

    @JsonProperty(value = "code")
    private String code;

    @JsonProperty(value = "msg")
    private String msg;
}
