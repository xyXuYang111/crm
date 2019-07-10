package com.xuyang.crm.rabbitMq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: 86151
 * @Date: 2019/7/11 00:08
 * @Description:
 */
@Component
@Slf4j
public class RabbitMqConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        log.debug("消息内容："+ message.getBody());
    }

    @Override
    public void containerAckMode(AcknowledgeMode mode) {

    }
}
