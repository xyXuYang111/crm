package com.xuyang.crm.controller;

import com.xuyang.crm.model.MongoInfo;
import com.xuyang.crm.mongo.service.MongoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 许洋
 * @Date: 2019/7/31 00:15
 * @Description:
 */
@Slf4j
@Controller
public class MongoController {

    @Autowired
    private MongoService mongoService;

    @ResponseBody
    @RequestMapping(value = "mongoInfoList", method = RequestMethod.POST)
    public List<MongoInfo> mongoInfoList(){
        return null;
    }
}
