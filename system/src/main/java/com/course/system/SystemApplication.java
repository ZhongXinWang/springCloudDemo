package com.course.system;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

/**
* 业务系统启动类
* @author Winston.Wang
* @date 2020/8/6
* @version 1.0
**/
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.course")
@MapperScan("com.course.server.mapper")
public class SystemApplication {
    private final static Logger logger = LoggerFactory.getLogger(SystemApplication.class);
    public static void main(String[] args) {

        ConfigurableEnvironment environment = SpringApplication.run(SystemApplication.class).getEnvironment();
        logger.info("业务系统启动成功,地址\thttp://localhost:{}/system",environment.getProperty("server.port"));
    }
}
