package com.vuetutorial;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
@MapperScan("com.vuetutorial.mapper")
public class VueTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueTutorialApplication.class, args);
    }

}
