package com.xuyang.crm.email.service.impl;

import com.xuyang.crm.email.service.EmailMongoDB;
import com.xuyang.crm.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/9/10 01:28
 * @Description:
 */
@Slf4j
@Component
public class EmailMongoDBImpl implements EmailMongoDB {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Email emailInfo(Email email) throws Exception {
        return null;
    }

    @Override
    public List<Email> emailList(Email email) throws Exception {
        Query query = new Query();
        return mongoTemplate.find(query, Email.class);
    }

    @Override
    public void insertEmail(Email email) throws Exception {
        mongoTemplate.save(email);
    }

    @Override
    public void updateEmail(Email email) throws Exception {

    }

    @Override
    public void deleteEmail(Email email) throws Exception {

    }
}
