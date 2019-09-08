package com.xuyang.crm.controller;

import com.xuyang.crm.log.service.LoggerMongoDB;
import com.xuyang.crm.log.service.LoggerService;
import com.xuyang.crm.model.Logger;
import com.xuyang.crm.model.Url;
import com.xuyang.crm.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class LoggerController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private LoggerService loggerService;

    @Autowired
    private LoggerMongoDB loggerMongoDB;

    @RequestMapping(value = "loggerErrorList")
    public String loggerErrorList(Model model) throws Exception{
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
            model.addAttribute("loggerList", loggerList);
            return "log/show2";
        } catch (Exception e) {
            e.printStackTrace();
            return "log/show2";
        }
    }

    @RequestMapping(value = "loggerRequestList")
    public String loggerRequestList(Model model) throws Exception{
        try {
            Map<Object, Object> objectMap = redisService.getMap("REQUEST");
            List<Url> urlList = new ArrayList<>();
            for(Object object : objectMap.keySet()){
                Url url = (Url) objectMap.get(object);
                urlList.add(url);
            }
            model.addAttribute("urlList", urlList);
            return "log/show3";
        } catch (Exception e) {
            e.printStackTrace();
            return "log/show3";
        }
    }

    /**
     * 数据库的日志文件
     * @param model
     * @param logger
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "loggerSqlList")
    public String loggerSqlList(Model model, Logger logger) throws Exception{
        try {
           log.debug("数据库中的日志");
           List<Logger> loggerList = loggerService.loggerList(logger);
           model.addAttribute("loggerList", loggerList);
            return "log/show1";
        } catch (Exception e) {
            log.error(e.getMessage());
            return "log/show1";
        }
    }

    /**
     * 数据库的日志文件
     * @param model
     * @param logger
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "loggerMongoDBList")
    public String loggerMongoDBList(Model model, Logger logger) throws Exception{
        try {
            log.debug("mongoDB中的日志");
            List<Logger> loggerList = loggerMongoDB.loggerList(logger);
            model.addAttribute("loggerList", loggerList);
            return "log/show1";
        } catch (Exception e) {
            log.error(e.getMessage());
            return "log/show1";
        }
    }
}
