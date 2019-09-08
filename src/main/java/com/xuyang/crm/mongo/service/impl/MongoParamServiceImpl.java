package com.xuyang.crm.mongo.service.impl;

import com.xuyang.crm.model.MongoParam;
import com.xuyang.crm.mongo.service.MongoParamService;
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
public class MongoParamServiceImpl implements MongoParamService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * mongo数据存储
     * @param mongoParam 参数
     * @throws Exception
     */
    @Override
    public void insert(MongoParam mongoParam) throws Exception {
        mongoTemplate.save(mongoParam);
    }

    /**
     * 只能单个单个的修改吗
     * @param mongoParam
     * @throws Exception
     */
    @Override
    public void update(MongoParam mongoParam) throws Exception {
        //根据条件
        Query query = new Query(Criteria.where("id").is(mongoParam.getId()));
        Update update = Update.update("name", mongoParam.getName()).
                set("value1", mongoParam.getValue1()).
                set("value2", mongoParam.getValue2()).
                set("value3", mongoParam.getValue3()).
                set("value4", mongoParam.getValue4()).
                set("value5", mongoParam.getValue5()).
                set("updateTime", mongoParam.getUpdateTime());
        mongoTemplate.updateFirst(query, update, Article.class);
    }

    /**
     * 根据ID查询数据
     * 唯一条件
     * @param mongoParam
     * @return
     * @throws Exception
     */
    @Override
    public MongoParam findByAnd(MongoParam mongoParam) throws Exception {
        Query query = new Query();
        Criteria criteria = new Criteria().andOperator(Criteria.where("id").is(mongoParam.getId()));
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, MongoParam.class);
    }

    /**
     * 多数据查询
     * @param mongoParam
     * @return
     * @throws Exception
     */
    @Override
    public List<MongoParam> findByOr(MongoParam mongoParam) throws Exception {
        Query query = new Query();
        Criteria criteria = new Criteria().orOperator(Criteria.where("id").exists(false).is(mongoParam.getId()),
                Criteria.where("name").exists(false).regex(MongodbUtil.pattern(mongoParam.getName())),
                Criteria.where("value1").exists(false).is(mongoParam.getValue1()),
                Criteria.where("value2").exists(false).is(mongoParam.getValue2()),
                Criteria.where("value3").exists(false).is(mongoParam.getValue3()),
                Criteria.where("value4").exists(false).is(mongoParam.getValue4()),
                Criteria.where("value5").exists(false).is(mongoParam.getValue5()),
                Criteria.where("createTime").exists(false).is(mongoParam.getCreateTime()),
                Criteria.where("updateTime").exists(false).is(mongoParam.getUpdateTime()));
        query.addCriteria(criteria);
        return mongoTemplate.find(query, MongoParam.class);
    }

    /**
     * 分页查询:倒叙排序
     * @param mongoParam
     * @param pageable 分页条件
     * @return
     * @throws Exception
     */
    @Override
    public List<MongoParam> findByPage(MongoParam mongoParam, Pageable pageable) throws Exception {
        Query query = new Query();
        Criteria criteria = new Criteria().orOperator(Criteria.where("id").exists(false).is(mongoParam.getId()),
                Criteria.where("name").exists(false).regex(MongodbUtil.pattern(mongoParam.getName())),
                Criteria.where("value1").exists(false).is(mongoParam.getValue1()),
                Criteria.where("value2").exists(false).is(mongoParam.getValue2()),
                Criteria.where("value3").exists(false).is(mongoParam.getValue3()),
                Criteria.where("value4").exists(false).is(mongoParam.getValue4()),
                Criteria.where("value5").exists(false).is(mongoParam.getValue5()),
                Criteria.where("createTime").exists(false).is(mongoParam.getCreateTime()),
                Criteria.where("updateTime").exists(false).is(mongoParam.getUpdateTime()));

        query.addCriteria(criteria);
        // 分页 和 排序
        query.with(pageable);
        //根据什么条件进行排序
        query.with(new Sort(Sort.Direction.DESC, "createTime"));

        return mongoTemplate.find(query, MongoParam.class);
    }

    /**
     * 主键删除
     * @param mongoParam
     * @throws Exception
     */
    @Override
    public void removeByID(MongoParam mongoParam) throws Exception {
        Query query = new Query();
        Criteria criteria = new Criteria().andOperator(Criteria.where("id").exists(true).is(mongoParam.getId()),
                Criteria.where("name").exists(false).is(mongoParam.getName()),
                Criteria.where("value1").exists(false).is(mongoParam.getValue1()),
                Criteria.where("value2").exists(false).is(mongoParam.getValue2()),
                Criteria.where("value3").exists(false).is(mongoParam.getValue3()),
                Criteria.where("value4").exists(false).is(mongoParam.getValue4()),
                Criteria.where("value5").exists(false).is(mongoParam.getValue5()),
                Criteria.where("createTime").exists(false).is(mongoParam.getCreateTime()),
                Criteria.where("updateTime").exists(false).is(mongoParam.getUpdateTime()));
        query.addCriteria(criteria);

        mongoTemplate.remove(query, MongoParam.class);
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
     * MongoParam的聚合
     * @param mongoParam
     * @return
     * @throws Exception
     */
    @Override
    public List<MongoParam> mongodbCount(MongoParam mongoParam) throws Exception {

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
        AggregationResults<MongoParam> mongoParamAggregationResults = mongoTemplate.aggregate(agg,"mongoParam", MongoParam.class);
        List<MongoParam> mongoParamList=mongoParamAggregationResults.getMappedResults();
        return mongoParamList;
    }
}
