package com.xuyang.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.xuyang.crm.dao.ObjectDao;
import com.xuyang.crm.model.ObjectValue;
import com.xuyang.crm.redis.redisRepository.RedisRepository;
import com.xuyang.crm.service.ObjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 许洋
 * @Date: 2019/7/28 22:23
 * @Description:
 */
@Slf4j
@Service
@Transactional
public class ObjectServiceImpl implements ObjectService {

    @Autowired
    private ObjectDao objectDao;

    @Cacheable(value = "cacheName", key = "'object_'+ objectValue")
    @Override
    public List<ObjectValue> objectValueList(ObjectValue objectValue) throws Exception {
        log.debug("根据对象获取redis中的参数");
        List<ObjectValue> objectValueList = objectDao.objectValueList(objectValue);
        //数据备份
        RedisRepository.setMap("objectValue", objectValue.toString(), objectValueList);
        return objectValueList;
    }

    @Cacheable(value = "cacheName", key = "'object_'+ objectValue + startIndex + pageSize")
    @Override
    public List<ObjectValue> objectValueList(ObjectValue objectValue, String startIndex, String pageSize) throws Exception {
        log.debug("根据对象获取redis中的参数");
        int pageNum = Integer.valueOf(startIndex);
        int pageSiz = Integer.valueOf(pageSize);
        List<ObjectValue> objectValueList = new ArrayList<>();
        PageHelper.startPage(pageNum, pageSiz);
        //从数据中获取
        List<ObjectValue> objectValuePage = objectDao.objectValueList(objectValue);
        //获取redis中的所有参数
        RedisRepository.setMap("objectValue", objectValue.toString(), objectValuePage);
        return objectValuePage;
    }

    @Cacheable(value = "cacheName", key = "'object_' + objectValue")
    @Override
    public ObjectValue objectValueInfo(ObjectValue objectValue) throws Exception {
        log.debug("根据对象获取redis中的参数");
        ObjectValue objectValueInfo = objectDao.objectValueInfo(objectValue);
        RedisRepository.setMap("objectValue", objectValue.toString(), objectValueInfo);
        return objectValueInfo;
    }

    @CachePut(value = "cacheName", key = "'object_'+ objectValue")
    @Override
    public void insertObjectValue(ObjectValue objectValue) throws Exception {
        log.debug("添加数据到redis和mysql中");
        RedisRepository.setMap("objectValue", objectValue.toString(), objectValue);
        objectDao.insertObjectValue(objectValue);
    }

    @CachePut(value = "cacheName", key = "'object_'+ objectValue")
    @Override
    public void updateObjectValue(ObjectValue objectValue) throws Exception {
        log.debug("修改数据到redis和mysql中");
        RedisRepository.setMap("objectValue", objectValue.toString(), objectValue);
        objectDao.updateObjectValue(objectValue);
    }

    @CacheEvict(value = "cacheName", key = "'object_'+ objectValue")
    @Override
    public void deleteObjectValue(ObjectValue objectValue) throws Exception {
        log.debug("删除数据到redis和mysql中");
        objectDao.deleteObjectValue(objectValue);
    }
}
