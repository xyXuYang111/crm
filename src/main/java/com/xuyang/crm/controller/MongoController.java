package com.xuyang.crm.controller;

import com.xuyang.crm.Exception.BaseController;
import com.xuyang.crm.model.MongoParam;
import com.xuyang.crm.mongo.service.MongoParamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 * @Auther: 许洋
 * @Date: 2019/7/31 00:15
 * @Description:
 */
@Slf4j
@Controller
public class MongoController extends BaseController {

    @Autowired
    private MongoParamService mongoParamService;

    /**
     * 新增mongoDB数据
     * @param mongoParam
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/insertMongoDB", method = RequestMethod.POST)
    public String insertMongoDB(@RequestBody MongoParam mongoParam) throws Exception{
        log.debug("mongoParam参数"+ mongoParam.toString());
        mongoParam.setId(UUID.randomUUID().toString());
        mongoParamService.insert(mongoParam);
        return "添加成功，uuid是：" + UUID.randomUUID().toString();
    }

    /**
     * 修改mongoDB数据
     * @param mongoParam
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/updateMongoDB", method = RequestMethod.POST)
    public String updateMongoDB(@RequestBody MongoParam mongoParam) throws Exception{
        log.debug("mongoParam参数"+ mongoParam.toString());
        mongoParamService.update(mongoParam);
        return "添加成功，uuid是：" + UUID.randomUUID().toString();
    }

    /**
     * 单行数据查询mongoDB数据
     * @param mongoParam
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/selectOneMongoDB", method = RequestMethod.POST)
    public MongoParam selectOneMongoDB(@RequestBody MongoParam mongoParam) throws Exception{
        log.debug("mongoParam参数"+ mongoParam.toString());
        MongoParam findMongoDB = mongoParamService.findByAnd(mongoParam);
        return findMongoDB;
    }

    /**
     * 多行数据mongoDB数据
     * @param mongoParam
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/selectListMongoDB", method = RequestMethod.POST)
    public List<MongoParam> selectListMongoDB(@RequestBody MongoParam mongoParam) throws Exception{
        log.debug("mongoParam参数"+ mongoParam.toString());
        List<MongoParam> findMongoDB = mongoParamService.findByOr(mongoParam);
        log.debug("查询结果：" + findMongoDB.size());
        return findMongoDB;
    }

    /**
     * 多行数据mongoDB数据
     * @param mongoParam
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/selectListPageMongoDB", method = RequestMethod.POST)
    public List<MongoParam> selectListPageMongoDB(@RequestBody MongoParam mongoParam) throws Exception{
        log.debug("mongoParam参数"+ mongoParam.toString());
        // 每页10个
        Pageable pageable = new PageRequest(1, 10);
        List<MongoParam> findMongoDB = mongoParamService.findByPage(mongoParam, pageable);
        log.debug("分页查询结果：" + findMongoDB.size());
        return findMongoDB;
    }
}
