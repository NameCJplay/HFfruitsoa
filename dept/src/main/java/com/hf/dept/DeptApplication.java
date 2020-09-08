package com.hf.dept;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DeptApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeptApplication.class, args);
        LoggerFactory.getLogger(DeptApplication.class).info("Dept消费者启动成功!");

    }

}
