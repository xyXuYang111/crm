package com.xuyang.crm.log.factory.type;

import com.xuyang.crm.log.factory.LoggerAbstract;
import com.xuyang.crm.model.Files;
import com.xuyang.crm.model.Logger;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Auther: cypc
 * @Date: 2019/9/9 08:26
 * @Description: 其他日志
 */
@Component
@Slf4j
@Data
@Scope("prototype")
public class LoggerType0 extends LoggerAbstract {

    @Override
    public void insertSqlLogger() throws Exception {
        super.insertSqlLogger();
    }

    @Override
    public void insertMongoDBLogger() throws Exception {
        super.insertMongoDBLogger();
    }
}
