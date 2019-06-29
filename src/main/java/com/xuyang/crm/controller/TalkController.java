package com.xuyang.crm.controller;

import com.xuyang.crm.model.Talk;
import com.xuyang.crm.redis.RedisMessageListener;
import com.xuyang.crm.redis.redisRepository.RedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class TalkController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "talkInsertController", method = RequestMethod.POST)
    @ResponseBody
    public String talkInsertController(@RequestBody Talk talk) {
        log.debug("开始进行交谈");
        String channel = talk.getTalkCode();
        log.debug("订阅编码:" + channel);
        String msg = talk.getTalkContent();
        log.debug("消息内容:" + msg);
        redisTemplate.convertAndSend(channel, msg);
        return "消息发送成功";
    }

    @RequestMapping(value = "talkController", method = RequestMethod.POST)
    @ResponseBody
    public List<Talk> talkController(@RequestBody Talk talk) {
        log.debug("获取交谈内容");
        String channel = talk.getTalkCode();
        log.debug("订阅编码：" + channel);
        //获取前10条记录
        List<Talk> talkList = RedisRepository.getObjectList(channel, 0, 10);
        return talkList;
    }
}
