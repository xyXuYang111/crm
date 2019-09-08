package com.xuyang.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@ToString
@Slf4j
public class Talk implements Serializable {

    private static final long serialVersionUID = -1151984553314027917L;

    @JsonProperty(value = "talkID")
    private String talkID;

    @JsonProperty(value = "userName")
    private String userName;

    @JsonProperty(value = "talkCode")
    private String talkCode;

    @JsonProperty(value = "talkContent")
    private String talkContent;

    @JsonProperty(value = "createDate")
    private String createDate;
}
