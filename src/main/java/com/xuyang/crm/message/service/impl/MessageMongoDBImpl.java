package com.xuyang.crm.message.service.impl;

import com.xuyang.crm.message.service.MessageMongoDB;
import com.xuyang.crm.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/9/8 13:26
 * @Description:
 */
@Component
public class MessageMongoDBImpl implements MessageMongoDB {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Message messageInfo(Message message) throws Exception {
        return null;
    }

    @Override
    public List<Message> messageList(Message message) throws Exception {
        Query query = new Query();
        return mongoTemplate.find(query, Message.class);
    }

    @Override
    public void insertMessage(Message message) throws Exception {
        mongoTemplate.save(message);
    }

    @Override
    public void updateMessage(Message message) throws Exception {

    }

    @Override
    public void deleteMessage(Message message) throws Exception {

    }
}
