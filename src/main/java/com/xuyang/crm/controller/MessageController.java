package com.xuyang.crm.controller;

import com.xuyang.crm.kafka.provider.KafkaProvider;
import com.xuyang.crm.model.Talk;
import com.xuyang.crm.rabbitMq.provider.RabbitMqProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class MessageController {

    @Autowired
    private KafkaProvider kafkaProvider;

    @Autowired
    private RabbitMqProvider rabbitMqProvider;

    @RequestMapping(value = "kafkaInsertMessage", method = RequestMethod.POST)
    @ResponseBody
    public String kafkaInsertMessage(@RequestBody Talk talk){
        try {
            log.debug("通过kafka发送消息");
            kafkaProvider.sendKafka("mhb-test_2", 123, talk.toString());
            return "消息发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(value = "rabbitInsertMessage", method = RequestMethod.POST)
    @ResponseBody
    public String rabbitInsertMessage(@RequestBody Talk talk){
        try {
            log.debug("通过kafka发送消息");
            rabbitMqProvider.sendDataToCrQueue(talk.toString());
            return "消息发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
