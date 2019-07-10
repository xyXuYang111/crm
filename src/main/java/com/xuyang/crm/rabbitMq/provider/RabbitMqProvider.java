package com.xuyang.crm.rabbitMq.provider;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: 86151
 * @Date: 2019/7/11 00:10
 * @Description:
 */
@Slf4j
@Component
public class RabbitMqProvider {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息
     * 列队：queue_one_key
     * @param value
     */
    public void sendDataToCrQueue(String value) {
        log.debug("生产者发送消息");
        amqpTemplate.convertAndSend("queue_1", value);
    }
}
