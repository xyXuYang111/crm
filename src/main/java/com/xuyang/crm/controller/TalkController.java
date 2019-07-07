package com.xuyang.crm.controller;

import com.xuyang.crm.model.Talk;
import com.xuyang.crm.redis.RedisMessageListener;
import com.xuyang.crm.redis.RedisService;
import com.xuyang.crm.redis.redisRepository.RedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class TalkController {

    @Autowired
    private RedisMessageListener redisMessageListener;

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "talkInsertController", method = RequestMethod.POST)
    @ResponseBody
    public String talkInsertController(@RequestBody Talk talk) {
        log.debug("开始进行交谈");
        try {
            String channel = talk.getTalkCode();
            log.debug("订阅编码:" + channel);
            String msg = talk.getTalkContent();
            log.debug("消息内容:" + msg);
            redisMessageListener.sendMessage(channel, msg);
            return "消息发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(value = "talkInsertObjectController", method = RequestMethod.POST)
    @ResponseBody
    public String talkInsertObjectController(@RequestBody Talk talk) {
        log.debug("开始进行交谈");
        try {
            String channel = talk.getTalkCode();
            log.debug("订阅编码:" + channel);
            log.debug("消息内容:" + talk.toString());
            redisMessageListener.sendMessage(channel, talk);
            return "消息发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(value = "talkController", method = RequestMethod.POST)
    @ResponseBody
    public List<Talk> talkController(@RequestBody Talk talk) {
        log.debug("获取交谈内容");
        String channel = talk.getTalkCode();
        log.debug("订阅编码：" + channel);
        //获取前10条记录
        List<Talk> talkList = redisService.getObjectList(channel, 0, -1);
        System.out.println(talkList.size());
        return talkList;
    }

    @RequestMapping(value = "talkCodeController", method = RequestMethod.POST)
    @ResponseBody
    public List<String> talkCodeController() {
        log.debug("获取订阅对象");
        //获取前10条记录
        List<String> talkList = redisService.getObjectList("TALK_CODE", 0, -1);
        System.out.println(talkList.size());
        return talkList;
    }
}
