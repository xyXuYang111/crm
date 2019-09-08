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
 * @Auther: xuyang
 * @Date: 2019/9/8 13:15
 * @Description:
 */
@Data
@Slf4j
@ToString
@Document(collection = "Message")
public class Message implements Serializable {

    private static final long serialVersionUID = 5217507575665505077L;

    @Id
    @JsonProperty(value = "messageID")
    private String messageID;

    @Field
    @JsonProperty(value = "messageName")
    private String messageName;

    @Field
    @JsonProperty(value = "messageDes")
    private String messageDes;

    @Field
    @JsonProperty(value = "messageContent")
    private String messageContent;

    @Field
    @JsonProperty(value = "createTime")
    private String createTime;
}
