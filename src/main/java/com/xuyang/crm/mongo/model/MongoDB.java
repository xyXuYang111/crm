package com.xuyang.crm.mongo.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @Auther: 许洋
 * @Date: 2019/8/11 00:45
 * @Description:
 */
@Data
@Slf4j
@Document(collection = "mongoDB")
public class MongoDB implements Serializable {

    private static final long serialVersionUID = 5176068453008974886L;

    @Id
    private String id;

    private String userName;

    private String password;
}
