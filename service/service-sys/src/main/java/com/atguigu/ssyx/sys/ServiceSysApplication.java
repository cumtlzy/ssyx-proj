package com.atguigu.ssyx.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: ServiceSysApplication
 * Package: com.atguigu.ssyx.sys
 */

@SpringBootApplication
@ComponentScan("com.atguigu")
public class ServiceSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSysApplication.class, args);
    }
}
