package com.xuyang.crm.controller;

import com.xuyang.crm.model.Logger;
import com.xuyang.crm.model.Url;
import com.xuyang.crm.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class LoggerController {

    @Autowired
    private RedisService redisService;

    @ResponseBody
    @RequestMapping(value = "loggerErrorList", method = RequestMethod.POST)
    public List<Logger> loggerErrorList() throws Exception{
        try {
            Map<Object, Object> objectMap = redisService.getMap("ERROR");
            List<Logger> loggerList = new ArrayList<>();
            for(Object object : objectMap.keySet()){
                String key = (String) object;
                String content = (String) objectMap.get(object);
                Logger loggerInfo = new Logger();
                loggerInfo.setCode(key);
                loggerInfo.setContent(content);
                loggerInfo.setTime(key);
                loggerList.add(loggerInfo);
            }
            return loggerList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "loggerRequestList", method = RequestMethod.POST)
    public List<Url> loggerRequestList() throws Exception{
        try {
            Map<Object, Object> objectMap = redisService.getMap("REQUEST");
            List<Url> urlList = new ArrayList<>();
            for(Object object : objectMap.keySet()){
                Url url = (Url) objectMap.get(object);
                urlList.add(url);
            }
            return urlList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
