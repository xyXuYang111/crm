package com.xuyang.crm.task;

import com.xuyang.crm.kafka.provider.KafkaProvider;
import com.xuyang.crm.model.ObjectValue;
import com.xuyang.crm.model.Talk;
import com.xuyang.crm.redis.RedisService;
import com.xuyang.crm.service.ObjectService;
import com.xuyang.crm.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class TalkTask {

    @Autowired
    private RedisService redisService;

    @Autowired
    private ObjectService objectService;

    @Autowired
    private KafkaProvider kafkaProvider;

    @Scheduled(cron = "0 */1 * * * ?")
    public void task(){
        log.debug("定时调度开始：kafka新增数据");
        RestTemplate restTemplate = new RestTemplate();
        String url = "localhost/kafkaInsertMessage.do";

        Talk talk = new Talk();
        talk.setCreateDate(DateUtil.getNowTime());
        talk.setUserName("许洋");
        talk.setTalkContent(DateUtil.getNowTime() + "往kafka中写书");

        kafkaProvider.sendKafka("mhb-test_2", 123, talk.toString());
        kafkaProvider.sendKafka("mhb-test_1", 123, talk.toString());

        String redisCode = "REDIS_KAFKA_";
        //记录日志
        redisService.put(redisCode, DateUtil.getNowTime(), talk);
        log.debug("定时调度结束：kafka新增数据");
    }

    @Scheduled(cron = "*/10 * * * * ? ")
    public void objectValueTesk(){
        log.debug("定时调度开始：objectValue新增数据");
        RestTemplate restTemplate = new RestTemplate();
        String url = "localhost/insertObjectValue.do";

        ObjectValue objectValue = new ObjectValue();
        objectValue.setCreateTime(DateUtil.getNowTime());
        objectValue.setUserName("许洋");
        objectValue.setObjectContext(DateUtil.getNowTime() + "写的mysql测试数据");
        objectValue.setObjectName("测试数据");

        try {
            objectService.insertObjectValue(objectValue);

            String redisCode = "REDIS_OBJECT_";
            //记录日志
            redisService.put(redisCode, DateUtil.getNowTime(), objectValue);
            log.debug("定时调度结束：objectValue新增数据");
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("定时调度异常：" + e.getMessage());
        }
    }
}
