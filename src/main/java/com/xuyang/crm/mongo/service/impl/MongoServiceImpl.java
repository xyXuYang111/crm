package com.xuyang.crm.mongo.service.impl;

import com.xuyang.crm.mongo.service.MongoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Auther: 许洋
 * @Date: 2019/7/29 02:17
 * @Description:
 */
@Slf4j
@Component
public class MongoServiceImpl implements MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(Object object, String collectionName) throws Exception {

    }

    @Override
    public Object findOne(Map params, String collectionName) throws Exception {
        return null;
    }

    @Override
    public List findAll(Map params, String collectionName) throws Exception {
        return null;
    }

    @Override
    public void update(Map params, String collectionName) throws Exception {

    }

    @Override
    public void createCollection(String collectionName) throws Exception {

    }

    @Override
    public void remove(Map params, String collectionName) throws Exception {

    }
}
