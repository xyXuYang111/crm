package com.xuyang.crm.redis;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: xuy
 * @Date: 2019/4/7 00:56
 * @Description:
 */
@Data
@Slf4j
@Component
public class RedisService<T> {

    @Autowired
    private RedisTemplate redisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 设置缓存失效时间
     *
     * @param key
     * @param time
     */
    public void expire(String key, long time) {
        if (time > 0) {
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    /**
     * 获取value
     *
     * @param key
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     *
     * @param key
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 批量删除key
     *
     * @param key
     */
    @SuppressWarnings("unchecked")
    public void delete(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 获取存放在redis上的对象
     *
     * @param key
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 存储带对象的
     *
     * @param key
     * @param object
     */
    public void set(String key, Object object) {
        redisTemplate.opsForValue().set(key, object);
    }

    /**
     * 添加对象，设置超时时间
     *
     * @param key
     * @param object
     * @param time
     */
    public void set(String key, Object object, long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key, object, time, TimeUnit.SECONDS);
        } else {
            set(key, object);
        }
    }

    /**
     * HashGet
     *
     * @param key
     * @param item
     */
    public Object getObject(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * 获取hash的值
     *
     * @param key
     */
    public Map<Object, Object> getMap(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 存储hashMap
     *
     * @param key
     * @param map
     */
    public void putAll(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * 存储hasp对象，同时设置超时时间
     *
     * @param key
     * @param map
     * @param time
     */
    public void putAll(String key, Map<String, Object> map, long time) {
        redisTemplate.opsForHash().putAll(key, map);
        if (time > 0) {
            expire(key, time);
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key
     * @param item
     * @param object
     */
    public void put(String key, String item, Object object) {
        redisTemplate.opsForHash().put(key, item, object);
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key
     * @param item
     * @param object
     * @param time   时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
     */
    public void put(String key, String item, Object object, long time) {
        redisTemplate.opsForHash().put(key, item, object);
        if (time > 0) {
            expire(key, time);
        }
    }

    /**
     * 删除hash表中的值
     *
     * @param key
     * @param item
     */
    public void delete(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 判断hash表中是否有该项的值
     *
     * @param key
     * @param item
     */
    public boolean hasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * 根据key获取Set中的所有值
     *
     * @param key
     */
    public Set<Object> members(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key
     * @param value
     */
    public boolean isMember(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    /**
     * 将数据放入set缓存
     *
     * @param key
     * @param objects
     */
    public long add(String key, Object... objects) {
        return redisTemplate.opsForSet().add(key, objects);
    }

    /**
     * 将set数据放入缓存
     *
     * @param key
     * @param time
     * @param objects
     */
    public long add(String key, long time, Object... objects) {
        Long count = redisTemplate.opsForSet().add(key, objects);
        if (time > 0) {
            expire(key, time);
        }
        return count;
    }

    /**
     * 获取缓存的长度
     *
     * @param key
     */
    public long getSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * 移除值为value的
     *
     * @param key
     * @param objects
     */
    public long remove(String key, Object... objects) {
        return redisTemplate.opsForSet().remove(key, objects);
    }

    /**
     * 获取list缓存的内容
     *
     * @param key
     * @param start
     * @param end
     */
    public List<T> getObjectList(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 获取list缓存的长度
     *
     * @param key
     */
    public long size(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * 通过索引 获取list中的值
     *
     * @param key
     * @param index
     */
    public Object getObject(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    /**
     * 添加数据
     *
     * @param key
     * @param object
     */
    public void leftPush(String key, Object object) {
        redisTemplate.opsForList().leftPush(key, object);
    }

    /**
     * 添加数据
     *
     * @param key
     * @param list
     */
    public void leftPushAll(String key, List<Object> list) {
        redisTemplate.opsForList().leftPushAll(key, list);
    }

    /**
     * 添加数据
     *
     * @param key
     * @param object
     */
    public void rightPush(String key, Object object) {
        redisTemplate.opsForList().rightPush(key, object);
    }

    /**
     * 将list放入缓存
     *
     * @param key
     * @param object
     * @param time
     */
    public void rightPush(String key, Object object, long time) {
        redisTemplate.opsForList().rightPush(key, object);
        if (time > 0) {
            expire(key, time);
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key
     * @param list
     */
    public void rightPushAll(String key, List<Object> list) {
        redisTemplate.opsForList().rightPushAll(key, list);
    }

    /**
     * 将list放入缓存
     *
     * @param key
     * @param list
     * @param time
     */
    public void rightPushAll(String key, List<Object> list, long time) {
        redisTemplate.opsForList().rightPushAll(key, list);
        if (time > 0) {
            expire(key, time);
        }
    }

    /**
     * 根据索引修改list中的某条数据
     *
     * @param key
     * @param index
     * @param object
     */
    public void setIndexObject(String key, long index, Object object) {
        redisTemplate.opsForList().set(key, index, object);
    }

    /**
     * 移除N个值为value
     *
     * @param key
     * @param count
     * @param object
     */
    public long remove(String key, long count, Object object) {
        return redisTemplate.opsForList().remove(key, count, object);
    }
}
