package com.xuyang.crm.controller;

import com.xuyang.crm.Exception.BaseController;
import com.xuyang.crm.model.ObjectValue;
import com.xuyang.crm.service.ObjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: 许洋
 * @Date: 2019/7/28 23:39
 * @Description:
 */
@Slf4j
@Controller
public class ObjectController extends BaseController {

    @Autowired
    private ObjectService objectService;

    /**
     * 测试
     * @param objectValue
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/objectValueList")
    public List<ObjectValue> ObjectValueList(ObjectValue objectValue) throws Exception {
        log.debug("获取list对象，返回值为json格式");
        List<ObjectValue> objectValueList = objectService.objectValueList(objectValue);
        return objectValueList;
    }

    @ResponseBody
    @RequestMapping(value = "/objectValuePageList")
    public List<ObjectValue> ObjectValuePageList(ObjectValue objectValue,
                                                 @RequestParam(value = "startPage", defaultValue = "1")String startPage,
                                                 @RequestParam(value = "pageSize", defaultValue = "10")String pageSize) throws Exception {
        log.debug("获取list对象，返回值为json格式");
        List<ObjectValue> objectValueList = objectService.objectValueList(objectValue, startPage, pageSize);
        return objectValueList;
    }

    @ResponseBody
    @RequestMapping(value = "/insertObjectValue", method = RequestMethod.POST)
    public String insertObjectValue(ObjectValue objectValue) throws Exception {
        log.debug("获取list对象，返回值为json格式");
        try {
            objectService.insertObjectValue(objectValue);
            return "添加成功";
        } catch (Exception e) {
            log.error(e.getMessage());
            return "添加失败：" + e.getMessage();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateObjectValue")
    public String updateObjectValue(ObjectValue objectValue) throws Exception {
        log.debug("获取list对象，返回值为json格式");
        try {
            objectService.updateObjectValue(objectValue);
            return "修改成功";
        } catch (Exception e) {
            log.error(e.getMessage());
            return "修改失败：" + e.getMessage();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/deleteObjectValue")
    public String deleteObjectValue(ObjectValue objectValue) throws Exception {
        log.debug("获取list对象，返回值为json格式");
        try {
            objectService.deleteObjectValue(objectValue);
            return "删除成功";
        } catch (Exception e) {
            log.error(e.getMessage());
            return "删除失败：" + e.getMessage();
        }
    }


}
