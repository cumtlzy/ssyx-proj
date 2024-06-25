package com.atguigu.ssyx.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: ServiceProductApplication
 * Package: com.atguigu.ssyx.product
 */

@SpringBootApplication
@ComponentScan("com.atguigu")
public class ServiceProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProductApplication.class, args);
    }
}
