package com.xuyang.crm.model;

import com.xuyang.crm.util.DateUtil;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @Auther: 许洋
 * @Date: 2019/8/28 00:44
 * @Description:
 */
@Data
@Slf4j
@ToString
@Document(collection = "MONGO_PARAM")
public class MongoParam implements Serializable {

    private static final long serialVersionUID = 5131811961571109580L;

    // 主键使用此注解
    @Id
    private String id;

    // 字段使用此注解
    @Field
    private String name;

    // 字段还可以用自定义名称
    @Field("value1")
    private String value1;

    @Field("value2")
    private String value2;

    @Field("value3")
    private String value3;

    @Field("value4")
    private String value4;

    @Field("value5")
    private String value5 = DateUtil.getNowTime();

    @Field("createTime")
    private String createTime = DateUtil.getNowTime();

    @Field("updateTime")
    private String updateTime = DateUtil.getNowTime();
}
