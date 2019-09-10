package com.xuyang.crm.mongo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: cypc
 * @Date: 2019/9/10 10:24
 * @Description:
 */
@Slf4j
@Component
public class MongoFind<T> {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据一个条件去查询
     * @param map
     * @param clazz
     * @return
     */
    public <T> List<T> getGoodsDetails1(Map<String, Object> map, Class<T> clazz){

        Query query = new Query();

        for(String keyLine : map.keySet()){
            //条件
            Criteria criteria = new Criteria().andOperator(Criteria.where(keyLine).is(map.get(keyLine)));
            query.addCriteria(criteria);
        }
        return mongoTemplate.find(query, clazz);
    }

    /**
     * 根据一个条件进行分页查询
     * @param map
     * @param clazz
     * @return
     */
    public <T> List<T> getGoodsDetails4(Map<String, Object> map, Class<T> clazz,
                               int begin, int end){

        Query query = new Query();
        for(String keyLine : map.keySet()){
            //条件
            Criteria criteria = new Criteria().andOperator(Criteria.where(keyLine).is(map.get(keyLine)));
            query.addCriteria(criteria);
        }

        //分页
        query.limit(end - begin).skip(begin);
        return mongoTemplate.find(query, clazz);
    }

    /**
     * 查询从什么到什么时候的数据
     * @param begin
     * @param end
     * @param beginDate
     * @param endDate
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> getGoodsDetails5(int begin, int end, Date beginDate, Date endDate,
                                           Class<T> clazz) {
        Query query = new Query();
        Criteria criteria = new Criteria().
                andOperator(Criteria.where("createTime").gte(beginDate).lte(endDate));
        query.limit(end - begin).skip(begin);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, clazz);
    }

    /**
     * key不存在的分页查询
     * @param map
     * @param clazz
     * @param begin
     * @param end
     * @param <T>
     * @return
     */
    public <T> List<T> getGoodsDetails2(Map<String, Object> map, Class<T> clazz,
                                        int begin, int end) {
        Query query = new Query();
        for(String keyLine : map.keySet()){
            //条件
            Criteria criteria = new Criteria().andOperator(Criteria.where(keyLine).not());
            query.addCriteria(criteria);
        }
        return mongoTemplate.find(query.limit(end - begin).skip(begin), clazz);
    }

    /**
     * key存在的分页查询
     * 查询字段不为空的数据     -----关键字---ne
     * @param map
     * @param clazz
     * @param begin
     * @param end
     * @param <T>
     * @return
     */
    public <T> List<T> getGoodsDetails3(Map<String, Object> map, Class<T> clazz,
                                        int begin, int end) {
        Query query = new Query();
        for(String keyLine : map.keySet()){
            //条件
            Criteria criteria = new Criteria().andOperator(Criteria.where(keyLine).ne("").ne(null));
            query.addCriteria(criteria);
        }
        return mongoTemplate.find(query.limit(end - begin).skip(begin), clazz);
    }

    /**
     * 统计查询
     *
     * @param map
     * @param clazz
     * @return
     */
    public Long getGoodsDetails3(Map<String, Object> map, Class<T> clazz) {
        Query query = new Query();
        for (String keyLine : map.keySet()) {
            //条件
            Criteria criteria = new Criteria().andOperator(Criteria.where(keyLine).is(map.get(keyLine)));
            query.addCriteria(criteria);
        }
        return mongoTemplate.count(query, clazz);
    }

    /**
     * 查找包含在某个集合范围：----- 关键字---in
     * 排序
     * @param map
     * @param clazz
     * @param property1
     * @param property2
     * @param <T>
     * @return
     */
    public <T> List<T> getGoodsDetails4(Map<String, Object> map, Class<T> clazz,
                                        String property1, String property2) {
        Criteria criteria = new Criteria();
        for (String keyLine : map.keySet()) {
            //条件
            criteria.and(keyLine).in(map.get(keyLine));
        }

        Query query = new Query(criteria);
        query.with(new Sort(new Sort.Order(Sort.Direction.ASC, property1))).
                with(new Sort(new Sort.Order(Sort.Direction.ASC, property2)));

        return mongoTemplate.find(query, clazz);
    }
}
