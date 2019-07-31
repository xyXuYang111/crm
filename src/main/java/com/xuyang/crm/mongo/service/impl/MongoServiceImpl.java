package com.xuyang.crm.mongo.service.impl;

import com.xuyang.crm.model.MongoInfo;
import com.xuyang.crm.mongo.service.MongoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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

    /**
     * mongo数据存储
     * @param object 参数
     * @throws Exception
     */
    @Override
    public void insert(Object object) throws Exception {
        mongoTemplate.save(object);
    }

    /**
     * 多条件触发查询
     * 多条件查询：
     *    和sql差不多，条件没办法做到动态筛选
     * @param params
     * @return
     * @throws Exception
     */
    @Override
    public List findList(Map params) throws Exception {
        Query query = new Query();
        Criteria criteria = new Criteria().andOperator(Criteria.where("name").gt(params.get("name")),
                Criteria.where("id").gt(params.get("id")),
                Criteria.where("age").gt(params.get("age")),
                Criteria.where("birth").gt(params.get("birth")));
        query.addCriteria(criteria);
        return mongoTemplate.find(query, MongoInfo.class);
    }

    @Override
    public List findAll(Map params) throws Exception {
        //完全匹配
        Pattern allPattern = Pattern.compile("^许$", Pattern.CASE_INSENSITIVE);
        //右匹配
        Pattern rightPattern = Pattern.compile("^.*许$", Pattern.CASE_INSENSITIVE);
        //左匹配
        Pattern leftPattern = Pattern.compile("^许.*$", Pattern.CASE_INSENSITIVE);
        //模糊匹配-p
        Pattern pattern = Pattern.compile("^.*许.*$", Pattern.CASE_INSENSITIVE);

        Query query = Query.query(Criteria.where("name").regex(pattern));
        List list = mongoTemplate.find(query, Object.class);
        return list;
    }

    @Override
    public void update(Map params) throws Exception {

    }

    @Override
    public void createCollection(String collectionName) throws Exception {

    }

    @Override
    public void remove(Map params) throws Exception {

    }
}
