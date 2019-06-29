package com.xuyang.crm.repsitory;

import com.xuyang.crm.model.Talk;
import com.xuyang.crm.service.impl.TalkServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class TalkRepository {

    private static TalkServiceImpl talkService;

    @Autowired
    public void setTalkService(TalkServiceImpl talkService) {
        TalkRepository.talkService = talkService;
    }

    public static void insertTalk(Talk talk){
        log.debug("添加日志信息");
        talkService.insertTalk(talk);
    }
}
