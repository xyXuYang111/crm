package com.xuyang.crm.service.impl;

import com.xuyang.crm.dao.TalkDao;
import com.xuyang.crm.model.Talk;
import com.xuyang.crm.service.TalkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class TalkServiceImpl implements TalkService {

    @Autowired
    private TalkDao talkDao;

    @Override
    public void insertTalk(Talk talk) {
        log.debug("添加聊天记录");
        talkDao.insertTalk(talk);
    }
}
