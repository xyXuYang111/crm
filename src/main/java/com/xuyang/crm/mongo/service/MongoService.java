package com.xuyang.crm.mongo.service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: 许洋
 * @Date: 2019/7/29 02:16
 * @Description:
 */
public interface MongoService<T> {

    //添加
    public void insert(T object,String collectionName) throws Exception;
    //根据条件查找
    public T findOne(Map<String,Object> params, String collectionName) throws Exception;
    //查找所有
    public List<T> findAll(Map<String,Object> params, String collectionName) throws Exception;
    //修改
    public void update(Map<String,Object> params,String collectionName) throws Exception;
    //创建集合
    public void createCollection(String collectionName) throws Exception;
    //根据条件删除
    public void remove(Map<String,Object> params,String collectionName) throws Exception;
}
