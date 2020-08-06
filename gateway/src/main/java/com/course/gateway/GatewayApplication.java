package com.course.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.ConfigurableEnvironment;

/**
* 网关子工程启动类
* @author Winston.Wang
* @date 2020/8/7
* @version 1.0
**/
@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

    private final static Logger logger = LoggerFactory.getLogger(GatewayApplication.class);


    public static void main(String[] args) {

        ConfigurableEnvironment environment = SpringApplication.run(GatewayApplication.class).getEnvironment();

        logger.info("启动gateway工程成功，路径:http://localhost:{}",environment.getProperty("server.port"));
    }
}
