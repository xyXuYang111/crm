package com.xuyang.crm.controller;

import com.xuyang.crm.model.Talk;
import com.xuyang.crm.redis.RedisMessageListener;
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

    @RequestMapping(value = "talkController", method = RequestMethod.POST)
    @ResponseBody
    public List<Talk> talkController(@RequestBody Talk talk){
        log.debug("开始进行交谈");
        List<Talk> talkList = new ArrayList<>();

        return talkList;
    }
}
