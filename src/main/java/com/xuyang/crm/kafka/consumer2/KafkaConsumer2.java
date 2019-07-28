package com.xuyang.crm.kafka.consumer2;

import com.xuyang.crm.model.ObjectValue;
import com.xuyang.crm.service.ObjectService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer2<Integer, T> implements MessageListener<Integer, T> {

    @Autowired
    private ObjectService objectService;

    @Override
    public void onMessage(ConsumerRecord<Integer, T> tyConsumerRecord) {
        log.debug("第二种");
        log.info("kafka的key: " + tyConsumerRecord.key());
        log.info("kafka的value: " + tyConsumerRecord.value().toString());
        ObjectValue objectValue = new ObjectValue();
        objectValue.setObjectName("kafka测试数据");
        objectValue.setObjectContext("kafka的key: " + tyConsumerRecord.key() +
                "kafka的value: " + tyConsumerRecord.value().toString());
        objectValue.setUserName("许洋");
        try {
            objectService.insertObjectValue(objectValue);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
