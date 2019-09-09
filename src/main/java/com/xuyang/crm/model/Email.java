package com.xuyang.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @Auther: 许洋
 * @Date: 2019/1/6 21:51
 * @Description:
 */
@Data
@Slf4j
@ToString
@Document(collection = "Email")
public class Email implements Serializable {

    private static final long serialVersionUID = -8991756927614538137L;

    @Id
    @JsonProperty(value = "emailID")
    private String emailID;

    @Field
    @JsonProperty(value = "titleName")
    private String titleName;

    @Field
    @JsonProperty(value = "message")
    private String message;

    @Field
    @JsonProperty(value = "sendName")
    private String sendName;

    @Field
    @JsonProperty(value = "sendNumber")
    private String sendNumber;

    @Field
    @JsonProperty(value = "sendPassword")
    private String sendPassword;

    @Field
    @JsonProperty(value = "receiveName")
    private String receiveName;

    @Field
    @JsonProperty(value = "receiveNumber")
    private String receiveNumber;

    @Field
    @JsonProperty(value = "receivePassword")
    private String receivePassword;

    private String type;
}
