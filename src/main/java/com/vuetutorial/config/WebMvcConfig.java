package com.vuetutorial.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//    @Value("${ip-port}")
    private String ipPort;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //跨域配置   允许所有端口访问
        //跨域配置，不可设置为*，不安全, 前后端分离项目，可能域名不一致
        //本地测试 端口不一致 也算跨域
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedOriginPatterns("*")// 设置允许跨域请求的域名
                .allowedHeaders("*")// 设置允许的请求头
//                .allowCredentials(true)// 是否允许证书
                .allowedMethods("*")// 允许的方法
                .maxAge(3600);

    }
}
