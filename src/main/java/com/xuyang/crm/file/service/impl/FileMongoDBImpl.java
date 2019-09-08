package com.xuyang.crm.file.service.impl;

import com.xuyang.crm.file.service.FileMongoDB;
import com.xuyang.crm.model.Files;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: 许洋
 * @Date: 2019/9/7 23:07
 * @Description:
 */
@Slf4j
@Component
public class FileMongoDBImpl implements FileMongoDB {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Files fileInfo(Files files) throws Exception {
        Query query = new Query();
        Criteria criteria = new Criteria().andOperator(Criteria.where("fileID").is(files.getFileID()));
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, Files.class);
    }

    @Override
    public List<Files> fileList(Files files) throws Exception {
        Query query = new Query();
        return mongoTemplate.find(query, Files.class);
    }

    @Override
    public void insertFile(Files files) throws Exception {
        mongoTemplate.save(files);
    }

    @Override
    public void updateFile(Files files) throws Exception {
    }

    @Override
    public void deleteFile(Files files) throws Exception {

    }
}
