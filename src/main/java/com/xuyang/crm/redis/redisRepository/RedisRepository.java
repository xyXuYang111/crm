package com.xuyang.crm.redis.redisRepository;

import com.xuyang.crm.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: xuy
 * @Date: 2019/4/20 04:36
 * @Description:
 */
@Component
public class RedisRepository {

    private static RedisService redisService;

    @Autowired
    public void setRedisService(RedisService redisService) {
        RedisRepository.redisService = redisService;
    }

    /**
     * 根据key获取value
     */
    public static Object getValueByKey(String key){

        return redisService.get(key);
    }

    /**
     * 添加对象
     */
    public static void set(String key, Object object){
        redisService.set(key, object);
    }

    /**
     * 添加对象
     */
    public static void set(String key, Object object, long time){
        redisService.set(key, object, time);
    }

    /**
     * 根据索引查询
     * @param key
     * @param index
     */
    public static Object getObject(String key, long index){
        return redisService.getObject(key, index);
    }

    /**
     *
     * @param key
     * @param start
     * @param end
     */
    public static <T> List<T> getObjectList(String key, long start, long end ){
        return redisService.getObjectList(key, start, end);
    }

    /**
     *
     * @param key
     * @param object
     */
    public static void leftPush(String key, Object object){
        redisService.leftPush(key, object);
    }

    /**
     *
     * @param key
     * @param list
     */
    public static void rightPush(String key, List<Object> list){
        redisService.rightPush(key, list);
    }

    /**
     *
     * @param key
     * @param list
     * @param time
     */
    public static void rightPush(String key, List<Object> list, long time){
        redisService.rightPush(key, list, time);
    }

    /**
     *
     * @param key
     * @param object
     */
    public static void rightPush(String key, Object object){
        redisService.rightPush(key, object);
    }

    /**
     *
     * @param key
     * @param object
     * @param time
     */
    public static void rightPush(String key, Object object, long time){
        redisService.rightPush(key, object, time);
    }

    /**
     *
     * @param key
     * @param item
     * @param object
     */
    public static void setMap(String key, String item, Object object) {
        redisService.put(key, item, object);
    }

    /**
     *
     * @param key
     */
    public static Set<Object> members(String key){
        return redisService.members(key);
    }

    /**
     *
     * @param key
     * @param item
     * @param map
     */
    public static void setMap(String key, String item, Map<String, Object> map) {
        redisService.putAll(key, map);
    }

    /**
     *
     * @param key
     * @param item
     * @param map
     * @param time
     */
    public static void setMap(String key, String item, Map<String, Object> map, long time) {
        redisService.putAll(key, map, time);
    }

    /**
     *
     * @param key
     */
    public static Map<Object, Object> getMap(String key){
        return redisService.getMap(key);
    }

    /**
     *
     * @param key
     * @param item
     */
    public static Object getMap(String key, String item){
        return redisService.getObject(key, item);
    }

    /**
     *
     * @param key
     * @param item
     */
    public static void delete(String key, String item) {
        redisService.delete(key);
    }

    /**
     * 删除对象
     */
    public static void delete(String key) {
        redisService.delete(key);
    }

    /**
     * 删除对象
     */
    public static long listSize(String key) {
        return redisService.size(key);
    }
}
