package com.xuyang.crm.kafka.provider;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaProvider<T> {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public String sendKafka(String topic, Integer key, T message) {
        log.info("kafka的消息");
        kafkaTemplate.send(topic, key, message);
        log.info("发送kafka成功.");
        return "kafka消息发送成功";
    }
}
