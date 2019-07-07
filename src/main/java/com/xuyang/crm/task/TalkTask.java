package com.xuyang.crm.task;

import com.xuyang.crm.model.Talk;
import com.xuyang.crm.redis.redisRepository.RedisRepository;
import com.xuyang.crm.service.impl.TalkServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class TalkTask {

    @Autowired
    private TalkServiceImpl talkService;

    @Scheduled(cron = "0 0 23 * * ?")
    public void task(){
        log.debug("redis日志文件写到mysql中");
        //获取所有用户code
        List<Talk> talkList = RedisRepository.getObjectList("TALK", 0, -1);
        for(Talk talk : talkList){
            talkService.insertTalk(talk);
        }
    }
}
