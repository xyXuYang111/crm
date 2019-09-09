package com.xuyang.crm.log.factory;

import com.xuyang.crm.log.service.LoggerMongoDB;
import com.xuyang.crm.log.service.LoggerService;
import com.xuyang.crm.model.Files;
import com.xuyang.crm.model.Logger;
import com.xuyang.crm.model.Message;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: cypc
 * @Date: 2019/9/9 08:21
 * @Description:
 */
@Data
@Slf4j
@Component
public abstract class LoggerAbstract implements LoggerInterface{

    @Autowired
    private LoggerService loggerService;

    @Autowired
    private LoggerMongoDB loggerMongoDB;

    protected Logger logger;

    @Override
    public void insertSqlLogger() throws Exception{
        loggerService.insertLogger(logger);
    }

    @Override
    public void insertMongoDBLogger() throws Exception{
        loggerMongoDB.insertLogger(logger);
    }
}
