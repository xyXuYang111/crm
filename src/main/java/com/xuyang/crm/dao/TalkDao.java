package com.xuyang.crm.dao;

import com.xuyang.crm.annotation.MyBatisDao;
import com.xuyang.crm.model.Talk;

@MyBatisDao
public interface TalkDao {

    public void insertTalk(Talk talk);
}
