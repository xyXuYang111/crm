package com.xuyang.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Slf4j
@Data
@ToString
public class Logger implements Serializable {

    private static final long serialVersionUID = -4991901771565207029L;

    @Field
    @JsonProperty(value = "logID")
    private String logID;

    @Field
    @JsonProperty(value = "logContent")
    private String logContent;

    @Field
    @JsonProperty(value = "logType")
    private String logType;

    @Field
    @JsonProperty(value = "createTime")
    private String createTime;

    @Field
    @JsonProperty(value = "content")
    private String content;

    @Field
    @JsonProperty(value = "code")
    private String code;

    @Field
    @JsonProperty(value = "time")
    private String time;
}
