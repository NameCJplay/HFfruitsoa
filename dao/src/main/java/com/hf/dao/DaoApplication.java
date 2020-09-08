package com.hf.dao;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
public class DaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaoApplication.class, args);
        LoggerFactory.getLogger(DaoApplication.class).info("Dao数据中心启动成功!");
//        System.out.println("Dao数据中心启动成功!");
    }

}
