package com.xuyang.crm.mongo.service;

import com.xuyang.crm.model.MongoInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class MongoServiceTest {

    @Autowired
    private MongoService mongoService;

    @Test
    public void findList() {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("name", "许洋");
        try {
            List<MongoInfo> mongoInfoList = mongoService.findList(stringMap);
            System.out.println(mongoInfoList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
