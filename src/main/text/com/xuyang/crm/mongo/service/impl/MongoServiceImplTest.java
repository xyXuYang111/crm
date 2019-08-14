package com.xuyang.crm.mongo.service.impl;

import com.xuyang.crm.model.MongoInfo;
import com.xuyang.crm.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class MongoServiceImplTest {

    @Autowired
    private MongoServiceImpl mongoService;

    @Test
    public void insert() {
        try {
            MongoInfo mongoInfo = new MongoInfo();
            mongoInfo.setName("伏念若曦");
            mongoInfo.setBirth(DateUtil.getNowTime());
            mongoInfo.setAge(22);
            mongoInfo.setId(String.valueOf(System.currentTimeMillis()));

            mongoService.insert(mongoInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() {
    }

    @Test
    public void findByAnd() {
    }

    @Test
    public void findByOr() {
    }

    @Test
    public void findByPattern() {
    }

    @Test
    public void findByExists() {
    }

    @Test
    public void findByPage() {
    }

    @Test
    public void removeByID() {
    }

    @Test
    public void dropCollection() {
    }

    @Test
    public void mongodbCount() {
    }
}
