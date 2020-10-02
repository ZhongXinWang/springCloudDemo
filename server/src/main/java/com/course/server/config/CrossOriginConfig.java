package com.course.server.config;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
* AJAX请求跨域,该方法放在网关工程去拦截
* @author Winston.Wang
* @date 2020/9/20
* @version 1.0
**/
/*@Configuration*/
public class CrossOriginConfig  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders(CorsConfiguration.ALL)
                .allowedMethods(CorsConfiguration.ALL)
                .allowCredentials(true)
                .maxAge(3600);
                // 1小时内不需要再预检（发OPTIONS请求）
    }

}
