package com.xuyang.crm.mongo.service;

import com.xuyang.crm.model.MongoParam;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Auther: 许洋
 * @Date: 2019/7/29 02:16
 * @Description:
 */
public interface MongoParamService {

    //添加
    public void insert(MongoParam mongoParam) throws Exception;

    public void update(MongoParam mongoParam) throws Exception;

    public MongoParam findByAnd(MongoParam mongoParam) throws Exception;

    public List<MongoParam> findByOr(MongoParam mongoParam) throws Exception;

    public List<MongoParam> findByPage(MongoParam mongoParam, Pageable pageable) throws Exception;

    public void removeByID(MongoParam mongoParam) throws Exception;

    public void dropCollection(String collectionName) throws Exception;

    public List<MongoParam> mongodbCount(MongoParam mongoParam) throws Exception;
}
