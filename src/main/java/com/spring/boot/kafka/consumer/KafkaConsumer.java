package com.spring.boot.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topicPartitions = @TopicPartition(topic = "Sports",partitions = "0"),groupId = "football")
    public void listenGroup(@Payload String message,@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition){
        log.info("1st Consumer Received data from topic Sports :: {}, with partition :: {}",message,partition);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "Sports",partitions = {"1","2"}),groupId = "football")
    public void listenGroup2nd(@Payload String message,@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition){
        log.info("2nd Consumer Received data from topic Sports :: {}, with partition :: {}",message,partition);
    }
}
