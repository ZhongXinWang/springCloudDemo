package com.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.ConfigurableEnvironment;

/**
* eureka  服务端
* @author Winston.Wang
* @date 2020/8/5
* @version 1.0
**/
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	private final  static Logger LOG = LoggerFactory.getLogger(EurekaApplication.class);

	public static void main(String[] args) {
		ConfigurableEnvironment environment = SpringApplication.run(EurekaApplication.class, args).getEnvironment();
		LOG.info("启动EurekaServer成功,地址\thttp://localhost:{}",environment.getProperty("server.port"));
	}

}
