package com.hf.eureka;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import sun.applet.Main;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
       LoggerFactory.getLogger(EurekaApplication.class).info("Eureka服务注册中心启动成功!");

//        System.out.println("Eureka服务注册中心启动成功!");
    }

}
