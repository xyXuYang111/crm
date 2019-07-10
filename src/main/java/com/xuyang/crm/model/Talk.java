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

    public String getTalkID() {
        return talkID;
    }

    public void setTalkID(String talkID) {
        this.talkID = talkID;
    }

    public String getTalkCode() {
        return talkCode;
    }

    public void setTalkCode(String talkCode) {
        this.talkCode = talkCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTalkContent() {
        return talkContent;
    }

    public void setTalkContent(String talkContent) {
        this.talkContent = talkContent;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}