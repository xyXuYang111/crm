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
public class RedisMessageListener<T> implements MessageListener {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisService redisService;

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] body = message.getBody();
        //信息内容
        T msgBody = (T) stringRedisTemplate.getValueSerializer().deserialize(body);
        //节点
        byte[] channel = message.getChannel();
        String msgChannel = (String) stringRedisTemplate.getValueSerializer().deserialize(channel);
        System.out.println(msgChannel);

        //数据写到redis中
        redisService.leftPush(msgChannel, msgBody);
        log.debug("消息发送成功");
    }

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage(String channel, String message){
        log.debug("消息内容");
        stringRedisTemplate.convertAndSend(channel, message);
    }

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage(String channel, T message){
        log.debug("消息内容");
        stringRedisTemplate.convertAndSend(channel, message.toString());
    }
}
