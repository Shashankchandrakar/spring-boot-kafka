package com.spring.boot.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class KafkaProducer {

    private final KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public ListenableFuture<SendResult<String, String>> sendMessageWithFuture(String message){
        return kafkaTemplate.send("Sports",message);
    }

    public void sendMessage(String msg){
        ListenableFuture<SendResult<String, String>> listenableFuture = sendMessageWithFuture(msg);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("Failure cannot deliver to topic Sports",throwable);
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                log.info("Message has been successfully delivered response is {}",stringStringSendResult);
            }
        });
    }
}
