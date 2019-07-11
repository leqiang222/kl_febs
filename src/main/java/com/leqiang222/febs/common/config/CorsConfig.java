package com.leqiang222.febs.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author LeQiang Li
 * @Date Created in 15:32 2019/7/9
 * @Description: 跨域
 * @Modified By:
 */
@Configuration
public class CorsConfig {
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowCredentials(false)
//                        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//                        .allowedOrigins("*")
//                        .allowedHeaders("*");
//
//            }
//        };
//    }
}
