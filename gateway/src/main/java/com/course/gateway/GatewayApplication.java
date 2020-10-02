package com.course.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;


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


    /**
     * spring boot处理跨域
     * @return
     */
    @Bean
    public CorsWebFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(Boolean.TRUE);
        corsConfiguration.addAllowedOrigin(CorsConfiguration.ALL);
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        corsConfiguration.setMaxAge(3600L);
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(source);
    }


}
