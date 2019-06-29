package com.xuyang.crm.redis;

import com.xuyang.crm.redis.redisRepository.RedisRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Auther: xuy
 * @Date: 2019/4/17 00:17
 * @Description:
 */
@Data
@Slf4j
@Component
public class RedisMessageListener implements MessageListener {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] body = message.getBody();
        //信息内容
        String msgBody = (String) stringRedisTemplate.getValueSerializer().deserialize(body);
        System.out.println(msgBody);
        //节点
        byte[] channel = message.getChannel();
        String msgChannel = (String) stringRedisTemplate.getValueSerializer().deserialize(channel);
        System.out.println(msgChannel);

        //数据写到redis中
        RedisRepository.leftPush(msgChannel, msgBody);
    }
}
