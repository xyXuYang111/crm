package com.xuyang.crm.kafka.consumer2;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer2<Integer, T> implements MessageListener<Integer, T> {

    @Override
    public void onMessage(ConsumerRecord<Integer, T> tyConsumerRecord) {
        log.info("kafka的key: " + tyConsumerRecord.key());
        log.info("kafka的value: " + tyConsumerRecord.value().toString());
    }
}
