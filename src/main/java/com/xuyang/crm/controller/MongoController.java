package com.xuyang.crm.controller;

import com.xuyang.crm.model.MongoInfo;
import com.xuyang.crm.mongo.service.MongoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public List<MongoInfo> mongoInfoList(@RequestBody MongoInfo mongoInfo){
        try {
            log.debug("mongodb学习之or查询");
            List<MongoInfo> mongoInfoList = mongoService.findByOr(mongoInfo);
            return mongoInfoList;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "mongoInfoPattern", method = RequestMethod.POST)
    public List<MongoInfo> mongoInfoPattern(@RequestBody MongoInfo mongoInfo){
        try {
            log.debug("mongodb学习之模糊查询");
            List<MongoInfo> mongoInfoList = mongoService.findByPattern(mongoInfo);
            return mongoInfoList;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "mongoInfoExists", method = RequestMethod.POST)
    public List<MongoInfo> mongoInfoExists(@RequestBody MongoInfo mongoInfo){
        try {
            log.debug("mongodb学习之自动忽略查询");
            List<MongoInfo> mongoInfoList = mongoService.findByExists(mongoInfo);
            return mongoInfoList;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "insertMongodb", method = RequestMethod.POST)
    public MongoInfo insertMongodb(@RequestBody MongoInfo mongoInfo){
        try {
            log.debug("mongodb学习之or查询");
            mongoInfo.setId(String.valueOf(System.currentTimeMillis()));
            mongoService.insert(mongoInfo);

            MongoInfo mongoInfoLine= mongoService.findByAnd(mongoInfo);
            log.debug("新增的结果数据：" + mongoInfoLine.toString());

            return mongoInfoLine;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "updateMongodb", method = RequestMethod.POST)
    public String updateMongodb(@RequestBody MongoInfo mongoInfo){
        try {
            log.debug("mongodb学习之修改数据");
            mongoService.update(mongoInfo);
            return "mongodb修改成功";
        } catch (Exception e) {
            log.error(e.getMessage());
            return "mongodb修改失败：" + e.getMessage();
        }
    }
}
