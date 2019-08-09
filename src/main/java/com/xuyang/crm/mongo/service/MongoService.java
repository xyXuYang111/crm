package com.xuyang.crm.mongo.service;

import com.xuyang.crm.model.MongoInfo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @Auther: 许洋
 * @Date: 2019/7/29 02:16
 * @Description:
 */
public interface MongoService {

    //添加
    public void insert(MongoInfo mongoInfo) throws Exception;

    public void update(MongoInfo mongoInfo) throws Exception;

    public MongoInfo findByAnd(MongoInfo mongoInfo) throws Exception;

    public List<MongoInfo> findByOr(MongoInfo mongoInfo) throws Exception;

    public List<MongoInfo> findByPattern(MongoInfo mongoInfo) throws Exception;

    public List<MongoInfo> findByExists(MongoInfo mongoInfo) throws Exception;

    public List<MongoInfo> findByPage(MongoInfo mongoInfo, Pageable pageable) throws Exception;

    public void removeByID(MongoInfo mongoInfo) throws Exception;
}
