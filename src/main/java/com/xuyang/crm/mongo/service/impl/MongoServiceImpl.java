package com.xuyang.crm.mongo.service.impl;

import com.mongodb.DBObject;
import com.xuyang.crm.model.MongoInfo;
import com.xuyang.crm.mongo.service.MongoService;
import com.xuyang.crm.mongo.util.MongodbUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.nntp.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

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
        Criteria criteria = new Criteria().orOperator(Criteria.where("name").is(mongoInfo.getName()));
        query.addCriteria(criteria);
        return mongoTemplate.find(query, MongoInfo.class);
    }

    /**
     * 自动忽略
     * @param mongoInfo
     * @return findByPattern
     * @throws Exception
     */
    @Override
    public List<MongoInfo> findByExists(MongoInfo mongoInfo) throws Exception {
        Query query = new Query();
        Criteria criteria = new Criteria().exists(false).
                andOperator(Criteria.where("name").regex(MongodbUtil.pattern(mongoInfo.getName())));
        query.addCriteria(criteria);
        return mongoTemplate.find(query, MongoInfo.class);
    }

    /**
     * 分页查询
     * @param mongoInfo
     * @param pageable 分页条件
     * @return
     * @throws Exception
     */
    @Override
    public List<MongoInfo> findByPage(MongoInfo mongoInfo, Pageable pageable) throws Exception {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.exists(false).andOperator(Criteria.where("name").regex(MongodbUtil.pattern(mongoInfo.getName())));
        query.addCriteria(criteria);
        // 分页 和 排序
        query.with(pageable);
        //根据什么条件进行排序
        query.with(new Sort(Sort.Direction.DESC, "id"));
        return mongoTemplate.find(query, MongoInfo.class);
    }

    /**
     * 自定义条件删除
     * @param mongoInfo
     * @throws Exception
     */
    @Override
    public void removeByID(MongoInfo mongoInfo) throws Exception {
        Query query = new Query();
        Criteria criteria = new Criteria().andOperator(Criteria.where("id").is(mongoInfo.getId()));
        query.addCriteria(criteria);
        mongoTemplate.remove(query, MongoInfo.class);
    }

    /**
     * 删除集合（也就是删表）
     * @param collectionName
     * @throws Exception
     */
    @Override
    public void dropCollection(String collectionName) throws Exception {
        mongoTemplate.dropCollection(collectionName);
    }

    /**
     * MongoInfo的聚合
     * @param mongoInfo
     * @return
     * @throws Exception
     */
    @Override
    public List<MongoInfo> mongodbCount(MongoInfo mongoInfo) throws Exception {

        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("age").gt("0"),
                Criteria.where("name").lt("30"));

        Aggregation agg = Aggregation.newAggregation(
                Aggregation.match(criteria),//条件
                Aggregation.group("name").//根据name进行分组
                        addToSet("age").as("ages").//获取此name下的此人所有年龄数据
                        first("id").as("firstId").//获取此name下的第一个id
                        sum("id").as("peopleNum").//获取此name下的所有人员数据
                        last("id").as("lastID"),//获取此name下的最后一个id
                Aggregation.sort(Sort.Direction.DESC, "id")//排序
        );
        AggregationResults<MongoInfo> mongoInfoAggregationResults = mongoTemplate.aggregate(agg,"mongoInfo", MongoInfo.class);
        List<MongoInfo> mongoInfoList=mongoInfoAggregationResults.getMappedResults();
        return mongoInfoList;
    }
}
