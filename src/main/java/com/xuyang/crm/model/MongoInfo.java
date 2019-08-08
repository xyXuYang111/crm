package com.xuyang.crm.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @Auther: 许洋
 * @Date: 2019/7/29 02:12
 * @Description:
 */
@Data
@Slf4j
@Document(collection = "mongoInfo")
public class MongoInfo implements Serializable {

    private static final long serialVersionUID = -3475519817418705626L;

    // 主键使用此注解
    @Id
    private String id;

    // 字段使用此注解
    @Field
    private String name;

    // 字段还可以用自定义名称
    @Field("age")
    private int age;

    // 还可以生成索引
    @Indexed(name = "index_birth", direction = IndexDirection.DESCENDING)
    @Field
    private String birth;

}
