package io.kimmking.javacourse.kafka.da;

/**
 * @author da
 * @version 1.0
 * @description: TODO
 * @date 2022年04月09日 14:35
 */
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @description: 消费者
 * @author da
 * @date 2022/4/9 14:47
 * @param
 * @return null
 */
@Component
@Slf4j
public class KafkaConsumer {

//    //  @KafkaListener(topics = "otndata",groupId = "MyGroup2")
//    public void listenGroup(ConsumerRecord<String, String> record, Acknowledgment ack) {
//        String value = record.value();
//        System.out.println(value);
//        System.out.println(record);
//        //手动提交offset
//        ack.acknowledge();
//    }


    @KafkaListener(topics = KafkaProducer.TOPIC_TEST ,groupId = "defaultConsumerGroup")
    public void topic_test1(ConsumerRecord<String, String> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("topic_test_defaultConsumerGroup 消费了：Topic:" + topic + ",Message:" + msg);
            ack.acknowledge();
        }
    }

}
