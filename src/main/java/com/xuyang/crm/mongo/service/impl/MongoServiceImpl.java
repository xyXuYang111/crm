package com.xuyang.crm.mongo.service.impl;

import com.xuyang.crm.model.MongoInfo;
import com.xuyang.crm.mongo.service.MongoService;
import com.xuyang.crm.mongo.util.MongodbUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.nntp.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
     * @param mongoInfo 参数
     * @throws Exception
     */
    @Override
    public void insert(MongoInfo mongoInfo) throws Exception {
        mongoTemplate.save(mongoInfo);
    }

    /**
     * 只能单个单个的修改吗
     * @param mongoInfo
     * @throws Exception
     */
    @Override
    public void update(MongoInfo mongoInfo) throws Exception {
        //根据条件
        Query query = new Query(Criteria.where("id").is(mongoInfo.getId()));
        Update update = Update.update("name", mongoInfo.getName()).set("age", mongoInfo.getAge());
        mongoTemplate.updateFirst(query, update, Article.class);
    }

    /**
     * 根据ID查询数据
     * 唯一条件
     * @param mongoInfo
     * @return
     * @throws Exception
     */
    @Override
    public MongoInfo findByAnd(MongoInfo mongoInfo) throws Exception {
        Query query = new Query();
        Criteria criteria = new Criteria().andOperator(Criteria.where("id").is(mongoInfo.getId()));
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, MongoInfo.class);
    }

    /**
     * or的方式查询数据
     * @param mongoInfo
     * @return
     * @throws Exception
     */
    @Override
    public List<MongoInfo> findByOr(MongoInfo mongoInfo) throws Exception {
        Query query = new Query();
        Criteria criteria = new Criteria().orOperator(Criteria.where("id").is(mongoInfo.getId()),
                Criteria.where("name").is(mongoInfo.getName()),
                Criteria.where("age").is(mongoInfo.getAge()),
                Criteria.where("birth").is(mongoInfo.getBirth()));
        query.addCriteria(criteria);
        return mongoTemplate.find(query, MongoInfo.class);
    }

    /**
     * 模糊查询(全模糊+or查询)
     * @param mongoInfo
     * @return
     * @throws Exception
     */
    @Override
    public List<MongoInfo> findByPattern(MongoInfo mongoInfo) throws Exception {
        Query query = new Query();
        Criteria criteria = new Criteria().orOperator(Criteria.where("name").regex(MongodbUtil.pattern(mongoInfo.getName())));
        query.addCriteria(criteria);
        return mongoTemplate.find(query, MongoInfo.class);
    }
}
