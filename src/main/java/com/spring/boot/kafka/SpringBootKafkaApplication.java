package com.spring.boot.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.spring.boot.kafka")
@EntityScan(basePackages = "com.spring.boot.kafka")
public class SpringBootKafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaApplication.class,args);
    }
}
