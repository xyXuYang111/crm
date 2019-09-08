package com.xuyang.crm.log.service.impl;

import com.xuyang.crm.log.service.LoggerMongoDB;
import com.xuyang.crm.model.Logger;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: 许洋
 * @Date: 2019/9/7 23:40
 * @Description:
 */
@Data
@Slf4j
@Component
public class LoggerMongoDBImpl implements LoggerMongoDB {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Logger loggerInfo(Logger logger) throws Exception {
        return null;
    }

    @Override
    public List<Logger> loggerList(Logger logger) throws Exception {
        Query query = new Query();
        return mongoTemplate.find(query, Logger.class);
    }

    @Override
    public void insertLogger(Logger logger) throws Exception {
        mongoTemplate.insert(logger);
    }

    @Override
    public void updateLogger(Logger logger) throws Exception {

    }

    @Override
    public void deleteLogger(Logger logger) throws Exception {

    }
}
