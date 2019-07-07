package com.xuyang.crm.dao;

import com.xuyang.crm.annotation.MyBatisDao;
import com.xuyang.crm.model.Talk;

import java.util.List;

@MyBatisDao
public interface TalkDao {

    public void insertTalk(Talk talk);

    public List<Talk> talkList(Talk talk);
}
