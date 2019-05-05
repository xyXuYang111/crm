package com.xuyang.crm.redis.redisRepository;

import com.xuyang.crm.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


}
