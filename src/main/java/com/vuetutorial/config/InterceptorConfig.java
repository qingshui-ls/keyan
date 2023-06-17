package com.vuetutorial.config;

import com.vuetutorial.interceptor.JWTInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/**")
//                .excludePathPatterns("/user/**")
                .excludePathPatterns("/login");
    }
}
